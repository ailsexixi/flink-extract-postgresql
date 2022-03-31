package cn.cec.flink.process.function;

import cn.cec.flink.model.KafkaModel;
import cn.cec.flink.model.PostGreSQLModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

@Slf4j
public class TransferProcessFunction extends KeyedProcessFunction<String,PostGreSQLModel, String> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void open(Configuration parameters) throws Exception {
        ParameterTool parameterTool = (ParameterTool) getRuntimeContext().getExecutionConfig().getGlobalJobParameters();
        super.open(parameters);
    }


    @Override
    public void processElement(PostGreSQLModel postGreSQLModel, Context context, Collector<String> collector) throws Exception {
        String jsonValue = mapper.writeValueAsString(postGreSQLModel);
        collector.collect(jsonValue);
    }
}
