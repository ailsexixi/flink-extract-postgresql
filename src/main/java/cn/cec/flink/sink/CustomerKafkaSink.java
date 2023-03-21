package cn.cec.flink.sink;

import cn.cec.flink.constants.ConstantValue;
import cn.cec.flink.serialize.KafkaDynamicTopicSerialize;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;

import java.util.Properties;

public class CustomerKafkaSink {

    private Properties properties = new Properties();

    private String topic;


    public CustomerKafkaSink(ParameterTool parameterTools) {
        this.topic=parameterTools.get(ConstantValue.TOPIC);
        String bootstrap = parameterTools.get(ConstantValue.BOOTSTRAP_SERVERS);
        properties.setProperty("bootstrap.servers", bootstrap);
    }

    public FlinkKafkaProducer<String> producer() {


        return new FlinkKafkaProducer<String>(
                topic,                  // target topic
                (KafkaSerializationSchema<String>) new KafkaDynamicTopicSerialize(new SimpleStringSchema()),    // serialization schema
                properties,                  // producer config
                FlinkKafkaProducer.Semantic.EXACTLY_ONCE); // fault-tolerance
    }

}

