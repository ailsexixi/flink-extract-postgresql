package cn.cec.flink.process;

import cn.cec.flink.model.PostGreSQLModel;
import cn.cec.flink.process.function.TransferProcessFunction;
import cn.cec.flink.sink.CustomerKafkaSink;
import cn.cec.flink.source.PostGreSQLSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
@Slf4j
public class FlinkExtractCore {

    public static void run(StreamExecutionEnvironment env){
        //获取全局参数
        ParameterTool parameterTools = (ParameterTool)env.getConfig().getGlobalJobParameters();
        DataStreamSource<PostGreSQLModel> postGreSQLModelDataStreamSource = env.addSource(new PostGreSQLSource());
        postGreSQLModelDataStreamSource
                .keyBy(PostGreSQLModel::getId)
                .process(new TransferProcessFunction())
                .addSink(new CustomerKafkaSink(parameterTools).producer());
    }

}
