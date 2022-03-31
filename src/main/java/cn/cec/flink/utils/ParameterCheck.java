package cn.cec.flink.utils;
import cn.cec.flink.constants.ConstantValue;
import org.apache.flink.api.java.utils.ParameterTool;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.io.InputStream;

public class ParameterCheck {

    public static ParameterTool parameterCheck(String[] args){

        if (args.length == 0) {
            new ValidationException("参数列表为空,请输入正确参数列表.");
        }
        ParameterTool params = ParameterTool.fromArgs(args);
        if (params.has(ConstantValue.CONFIG)) {
            String propertiesFileName = params.get(ConstantValue.CONFIG);
            try {
                String filePath="/".concat(propertiesFileName);
                InputStream inputStream= ParameterCheck.class.getResourceAsStream(filePath);
                ParameterTool propertiesFile = ParameterTool.fromPropertiesFile(inputStream);
                params = params.mergeWith(propertiesFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return params;
    }
}
