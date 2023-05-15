package cn.cec.flink;

import static org.junit.Assert.assertTrue;

import cn.cec.flink.model.PostGreSQLModel;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.DeserializationFeature;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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

    @Test
    public void shouldAnswerWithTrue2() {

        int[] arr = new int[5];
        Integer a = new Integer(100);
        Integer d = new Integer(100);
        Integer b = 100;
        int c = 100;
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a == b);
        ArrayList<Object> objects = new ArrayList<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        HashSet<Object> objects2 = new HashSet<>();
    }
}
