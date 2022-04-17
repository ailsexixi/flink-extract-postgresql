package cn.cec.flink.serialize;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import java.nio.charset.StandardCharsets;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.streaming.connectors.kafka.internals.KeyedSerializationSchemaWrapper;

/**
 * @Author Yu Tao
 * @Description 动态发往不同的topic
 * @Date 20220417$
 * @Version 1.0
 */
public class KafkaDynamicTopicSerialize extends KeyedSerializationSchemaWrapper<String> {

  public KafkaDynamicTopicSerialize(
      SerializationSchema serializationSchema) {
    super(serializationSchema);
  }

  @Override
  public SerializationSchema getSerializationSchema() {
    return super.getSerializationSchema();
  }

  @Override
  public byte[] serializeKey(String element) {
    return null;
  }

  @Override
  public byte[] serializeValue(String element) {
    return JSONObject.parseObject(element).getString("model").getBytes(StandardCharsets.UTF_8);
  }

  @Override
  public String getTargetTopic(String element) {
    return JSONObject.parseObject(element).getString("topic");
  }
}
