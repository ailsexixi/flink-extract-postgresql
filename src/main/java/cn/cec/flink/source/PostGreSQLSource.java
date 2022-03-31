package cn.cec.flink.source;

import cn.cec.flink.constants.ConstantValue;
import cn.cec.flink.model.PostGreSQLModel;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.common.functions.RichFunction;
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
import scala.Tuple2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGreSQLSource extends RichSourceFunction<PostGreSQLModel>  implements SourceFunction<PostGreSQLModel>,CheckpointedFunction {

    private final static String START_TIME="start_time";

    private final static String END_TIME="end_time";

    private Connection connection;

    private List<PostGreSQLModel> postGreSQLModels = new ArrayList<>();

    private Map<String,String> extractTime=new HashMap<>();

    private transient ListState<PostGreSQLModel> checkPointedState;
    //pg库抽取时间
    private transient MapState<String,String> extractTimeState;

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
        Class.forName(parameterTool.get(ConstantValue.DRIVERNAME));
        connection = DriverManager.getConnection(parameterTool.get(ConstantValue.URL), parameterTool.get(ConstantValue.USERNAME), parameterTool.get(ConstantValue.PASSWORD));
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
        MapStateDescriptor<String,String> extractorTimeStateDescriptor=new MapStateDescriptor<String,String>("extract-time-buffer", String.class,String.class);
        checkPointedState = context.getOperatorStateStore().getListState(descriptor);
        extractTimeState=context.getKeyedStateStore().getMapState(extractorTimeStateDescriptor);
        if (context.isRestored()) {
            //将checkpoint内时间状态重新赋值抽取时间点
            String startTime = extractTimeState.get(START_TIME);
            String endTime=extractTimeState.get(END_TIME);
            extractTime.put(START_TIME,startTime);
            extractTime.put(END_TIME,endTime);
            //checkpoint内pg值赋值
            for (PostGreSQLModel value : checkPointedState.get()) {
                postGreSQLModels.add(value);
            }
        }
    }
}
