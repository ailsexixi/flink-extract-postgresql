package cn.cec.flink.source;

import cn.cec.flink.constants.ConstantValue;
import cn.cec.flink.constants.ConstantValue.ParamsConstants;
import cn.cec.flink.model.ApplyInfoData;
import cn.cec.flink.model.PostGreSQLModel;
import cn.cec.flink.model.ReportInfo;
import cn.cec.flink.model.SeriesInfo;
import cn.cec.flink.model.StudyInfoData;
import cn.cec.flink.utils.JdbcOptions;
import cn.cec.flink.utils.JdbcOptions.JdbcConnectionOptionsBuilder;
import cn.cec.flink.utils.SimpleJdbcConnectionProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostGreSQLSource extends RichSourceFunction<PostGreSQLModel>  implements
    SourceFunction<PostGreSQLModel>, CheckpointedFunction {

    private static final Logger LOG = LoggerFactory.getLogger(PostGreSQLSource.class);

    private static final String START_TIME = "start_time";

    private static final String END_TIME = "end_time";

    private static JdbcOptions jdbcOptions;

    private static SimpleJdbcConnectionProvider jdbcConnectionProvider;

    private static Connection connection;

    private static String sourceSql;

    private static PreparedStatement statement;

    private static SimpleDateFormat dateFormat;

    private final List<PostGreSQLModel> postGreSQLModels = new ArrayList<>();

    private final Map<String, String> extractTime = new HashMap<>();

    private transient ListState<PostGreSQLModel> checkPointedState;
    //pg库抽取时间
    private transient MapState<String, String> extractTimeState;

    /**
    *@Description 初始化postgreSQL的链接池
    *@Author:lile
    *@Param
    *@Return 
    *@Date 2022/3/29
    *@Time 9:22
    */
    @Override
    public void open(Configuration parameters) throws Exception {
        ParameterTool parameterTool = (ParameterTool)getIterationRuntimeContext().getExecutionConfig().getGlobalJobParameters();

        dateFormat = new SimpleDateFormat(parameterTool.get(ConstantValue.UPDATE_TIME_FORMAT,
            "yyyy-MM-dd HH:mm:ss"));
        extractTime.put(START_TIME, parameterTool.get(ConstantValue.TIME_START,
            "1970-01-01 00:00:00"));
        extractTime.put(END_TIME, parameterTool.get(ConstantValue.TIME_STOP,
            dateFormat.format(new Date())));

        jdbcOptions = new JdbcConnectionOptionsBuilder()
            .withUrl(parameterTool.get(ConstantValue.URL))
            .withUsername(parameterTool.get(ConstantValue.USERNAME))
            .withPassword(parameterTool.get(ConstantValue.PASSWORD))
            .withDriverName(parameterTool.get(ConstantValue.DRIVERNAME))
            .withMaxRetries(parameterTool.getInt(ConstantValue.MAXRETRIES, 5))
            .build();
        jdbcConnectionProvider = new SimpleJdbcConnectionProvider(jdbcOptions);
        connection = jdbcConnectionProvider.getConnection();

        String sourceType = parameterTool.get(ConstantValue.SOURCE_TYPE);
        sourceSql = sourceType.equalsIgnoreCase(ConstantValue.KINGSOFT)
            ? ConstantValue.KINGSOFT_SQL : sourceType.equalsIgnoreCase(ConstantValue.KAYISOFT)
            ? ConstantValue.KAYISOFT_SQL : null;
        if (sourceSql == null) {
            throw new NullPointerException(String.format("请检查配置项 %s 是否配置正确, "
                + "正确的值应为 : %s or %s", ConstantValue.SOURCE_TYPE, ConstantValue.KAYISOFT,
                ConstantValue.KINGSOFT));
        }
        statement = connection.prepareStatement(sourceSql);
        connection.setAutoCommit(false);
        super.open(parameters);
    }

    /**
    *@Description 定时增量查询PostGreSQL数据
    *@Author:lile
    *@Param
    *@Return
    *@Date 2022/3/29
    *@Time 9:23
    */
    @Override
    public void run(SourceContext<PostGreSQLModel> sourceContext) throws Exception {
        while (true) {
            ResultSet resultSet = excuteQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                StringBuilder dataJson = new StringBuilder("{");
                for (int i = 1; i < metaData.getColumnCount(); i++) {
                    dataJson.append("\"" + metaData.getColumnName(i) + "\":\""
                        + resultSet.getString(i) + "\",");
                }
                dataJson.deleteCharAt(dataJson.length() - 1).append("}");
                String rowJson = dataJson.toString();
                ObjectMapper mapper = new ObjectMapper();

                ApplyInfoData applyInfoData = mapper
                    .readValue(rowJson, ApplyInfoData.class);
                StudyInfoData studyInfoData = mapper
                    .readValue(rowJson, StudyInfoData.class);
                ReportInfo reportInfoData = mapper
                    .readValue(rowJson, ReportInfo.class);
                SeriesInfo seriesInfoData = mapper
                    .readValue(rowJson, SeriesInfo.class);

                PostGreSQLModel applyModel = new PostGreSQLModel(ParamsConstants.APPLY_DATATYPE,
                    ParamsConstants.APPLY_LINKFIELDS,
                    ParamsConstants.APPLY_INDEXFIELDS, applyInfoData);
                PostGreSQLModel studyInfoModel = new PostGreSQLModel(ParamsConstants.STUDY_DATATYPE,
                    ParamsConstants.STUDY_LINKFIELDS,
                    ParamsConstants.STUDY_INDEXFIELDS, studyInfoData);
                PostGreSQLModel reportModel = new PostGreSQLModel(
                    ParamsConstants.REPORT_DATATYPE, ParamsConstants.REPORT_LINKFIELDS,
                    ParamsConstants.REPORT_INDEXFIELDS, reportInfoData);
                PostGreSQLModel seriesModel = new PostGreSQLModel(
                    ParamsConstants.SERIES_DATATYPE, ParamsConstants.SERIES_INDEXFIELDS,
                    ParamsConstants.SERIES_INDEXFIELDS, seriesInfoData);

                sourceContext.collect(applyModel);
                sourceContext.collect(studyInfoModel);
                sourceContext.collect(reportModel);
                sourceContext.collect(seriesModel);

                String endTime = extractTime.get(END_TIME);
                extractTime.put(START_TIME, endTime);
                extractTime.put(END_TIME, dateFormat
                    .format(new Date(new Date().getTime() + 30000L)));

                Thread.sleep(30000L);

            }


        }
    }

    /**
     * @Description 执行查询,返回result。 并在执行时处理异常
     * @return ResultSet
     * @throws IOException
     */
    public ResultSet excuteQuery() throws IOException {
        int i = 0;

        while (i <= jdbcOptions.getMaxRetries()) {
            try {
                statement.setString(1, START_TIME);
                statement.setString(2, END_TIME);
                ResultSet resultSet = statement.executeQuery();
                connection.commit();
                return  resultSet;
            } catch (SQLException var6) {
                LOG.error("JDBC executeQuery error, retry times = {}", i, var6);
                if (i >= jdbcOptions.getMaxRetries()) {
                    throw new IOException(var6);
                }
                try {
                    if (!connection.isValid(60)) {
                        connection = jdbcConnectionProvider.reestablishConnection();
                        statement.close();
                        statement = connection.prepareStatement(sourceSql);
                    }
                } catch (Exception var5) {
                    LOG.error("JDBC connection is not valid, and reestablish connection failed.", var5);
                    throw new IOException("Reestablish JDBC connection failed", var5);
                }

                try {
                    Thread.sleep(1000L * i);
                } catch (InterruptedException var4) {
                    Thread.currentThread().interrupt();
                    throw new IOException("unable to flush; interrupted while doing another attempt", var6);
                }

                ++i;
            }
        }
        throw new IOException("JDBC executeQuery failed");
    }


    @Override
    public void cancel() {

    }

    /**
    *@Description 关闭链接池
    *@Author:lile
    *@Param
    *@Return
    *@Date 2022/3/29
    *@Time 9:24
    */
    @Override
    public void close() throws Exception {
        super.close();
        statement.close();
        connection.close();
    }



    /**
    *@Description flink快照时将查询出来的实体缓存到checkpoint内
    *@Author:lile
    *@Param 
    *@Return
    *@Date 2022/3/29
    *@Time 9:19
    */
    @Override
    public void snapshotState(FunctionSnapshotContext context) throws Exception {
        extractTimeState.clear();
        checkPointedState.clear();
        //开始快照
        extractTimeState.putAll(extractTime);
        checkPointedState.addAll(postGreSQLModels);
    }

    /**
    *@Description 初始化checkpoints的状态描述器，并将checkpoint内的数据重新加载到list内
    *@Author:lile
    *@Param 
    *@Return 
    *@Date 2022/3/29
    *@Time 9:21
    */
    @Override
    public void initializeState(FunctionInitializationContext context) throws Exception {
        ListStateDescriptor<PostGreSQLModel> descriptor =
                new ListStateDescriptor<>(
                        "postGreSQLModels-buffer",
                        TypeInformation.of(new TypeHint<PostGreSQLModel>() {
                        }));
        MapStateDescriptor<String, String> extractorTimeStateDescriptor =
            new MapStateDescriptor<>("extract-time-buffer", String.class, String.class);
        checkPointedState = context.getOperatorStateStore().getListState(descriptor);
        extractTimeState = context.getKeyedStateStore().getMapState(extractorTimeStateDescriptor);
        if (context.isRestored()) {
            //将checkpoint内时间状态重新赋值抽取时间点
            String startTime = extractTimeState.get(START_TIME);
            String endTime = extractTimeState.get(END_TIME);
            extractTime.put(START_TIME, startTime);
            extractTime.put(END_TIME, endTime);
            //checkpoint内pg值赋值
            for (PostGreSQLModel value : checkPointedState.get()) {
                postGreSQLModels.add(value);
            }
        }
    }
}
