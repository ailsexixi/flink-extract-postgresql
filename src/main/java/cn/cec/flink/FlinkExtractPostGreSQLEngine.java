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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlinkExtractPostGreSQLEngine {

    private static final Logger LOGGER= LoggerFactory.getLogger(FlinkExtractPostGreSQLEngine.class);

    public static void main( String[] args ) throws Exception {
        LOGGER.info("==========>开始flink程序抽取postGreSQL数据");
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final ParameterTool params = ParameterCheck.parameterCheck(args);
        env.getConfig().setGlobalJobParameters(params);
        FlinkExtractCore.run(env);
        env.execute("flinkExtractPostGreSQLEinge");
    }
}
