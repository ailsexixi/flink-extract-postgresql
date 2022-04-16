package cn.cec.flink.utils;

import cn.cec.flink.constants.ConstantValue;
import cn.cec.flink.process.FlinkExtractCore;
import org.apache.flink.api.java.utils.ParameterTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.io.InputStream;

public class ParameterCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlinkExtractCore.class);

    public static ParameterTool parameterCheck(String[] args) throws ValidationException {

        if (args.length == 0) {
            throw new ValidationException("参数列表为空,请输入正确参数列表.");
        }

        ParameterTool params = ParameterTool.fromArgs(args);

        checkNotNull(params, ConstantValue.CONFIG);

        String propertiesFileName = params.get(ConstantValue.CONFIG);
        try {
            String filePath = "/".concat(propertiesFileName);
            InputStream inputStream = ParameterCheck.class.getResourceAsStream(filePath);
            ParameterTool propertiesFile = ParameterTool.fromPropertiesFile(inputStream);
            params = params.mergeWith(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return params;
    }

    private static void checkNotNull(ParameterTool params, String key) {
        if (!params.has(key)) {
            LOGGER.error("属性参数{}不能为空", key);
            throw new RuntimeException("属性参数{" + key + "}不能为空,请正确配置。。");
        }
    }
}
