package cn.cec.flink;

import cn.cec.flink.process.FlinkExtractCore;
import cn.cec.flink.utils.ParameterCheck;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Hello world!
 *
 */
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class FlinkExtractPostGreSQLEngine {

    public static void main( String[] args ) throws Exception {
        log.info("==========>开始flink程序抽取postGreSQL数据");
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final ParameterTool params = ParameterCheck.parameterCheck(args);
        env.getConfig().setGlobalJobParameters(params);
        FlinkExtractCore.run(env);
        env.execute("flinkExtractPostGreSQLEinge");
    }
}
