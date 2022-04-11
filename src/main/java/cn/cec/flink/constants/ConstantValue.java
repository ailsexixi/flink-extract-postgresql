package cn.cec.flink.constants;

public class ConstantValue {

    public static final String CONFIG = "application.properties";

    //kafka配置信息
    public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    public static final String GROUP_ID = "group.id";
    public static final String TOPIC = "kafka.topic";
    public static final String AUTO_OFFSET_RESET_CONFIG = "auto.offset.reset";

    //PG数据库配置信息
    public static final String USERNAME = "postgre.username";
    public static final String PASSWORD = "postgre.password";
    public static final String DRIVERNAME = "postgre.driver";
    public static final String URL = "postgre.url";
}
