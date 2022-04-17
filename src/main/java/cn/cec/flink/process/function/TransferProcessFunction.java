package cn.cec.flink.process.function;

import cn.cec.flink.model.KafkaModel;
import cn.cec.flink.model.PostGreSQLModel;
import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

@Slf4j
public class TransferProcessFunction extends KeyedProcessFunction<String, PostGreSQLModel,
    String> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void open(Configuration parameters) throws Exception {
        ParameterTool parameterTool = (ParameterTool) getRuntimeContext().getExecutionConfig().getGlobalJobParameters();
        super.open(parameters);
    }


    @Override
    public void processElement(PostGreSQLModel postGreSQLModel, Context context,
        Collector<String> collector) throws Exception {
        String dataValue = mapper.writeValueAsString(postGreSQLModel.getData());
        String dataType = postGreSQLModel.getDataType();
        String targetTopic = dataType + "_topic";
        StringBuilder jsonValue = new StringBuilder("{");
        jsonValue.append("\"topic\":\"")
            .append(targetTopic).append("\",")
            .append("\"model\": {")
            .append("\"data\":\"")
            .append(dataValue).append("\",")
            .append("\"dataType\":\"")
            .append(dataType).append("\",")
            .append("\"index_fields\":")
            .append(Arrays.toString(postGreSQLModel.getIndex_fields())).append(",")
            .append("\"link_fields\":")
            .append(Arrays.toString(postGreSQLModel.getLink_fields())).append("}}");

        collector.collect(jsonValue.toString());
    }
}
