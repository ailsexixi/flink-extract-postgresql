package cn.cec.flink;

import static org.junit.Assert.assertTrue;

import cn.cec.flink.model.PostGreSQLModel;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Unit test for simple FlinkExtractPostGreSQLEngine.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws JsonProcessingException {
        String json="{\"name\":\"lile\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        PostGreSQLModel postGreSQLModel=mapper.readValue(json,PostGreSQLModel.class);
        System.out.println(mapper.writeValueAsString(postGreSQLModel));

    }
}
