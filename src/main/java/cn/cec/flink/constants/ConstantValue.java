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

    //update_time 开始时间/结束时间
    public static final String TIME_START = "update_time.start";
    public static final String TIME_STOP = "update_time.stop";

    //update_time 日期格式
    public static final String UPDATE_TIME_FORMAT = "update_time.format";

    //PG数据库类型
    public static final String SOURCE_TYPE = "postgre.type";
    public static final String KINGSOFT = "king";
    public static final String KAYISOFT = "kayi";

    //Sql定义
    public static final String KAYISOFT_SQL = "select ris_examinfo.*, ca_series.modality, "
        + "ca_series.seriesinstanceuid, ca_series.seriesnumber, ca_series.seriestime, "
        + "ca_series.seriesdescription, ca_series.seriesdate, ca_patient.patientname, "
        + "ca_patient.patientid, ca_patient.otherpatientids, ca_patient.otherpatientnames, "
        + "ca_patient.birthdate, ca_patient.birthtime, ca_patient.sex, ca_patient.weight, "
        + "ca_patient.size, ca_patient.address, ca_patient.allergies, ca_study.studydate, "
        + "ca_study.studytime, ca_study.bodypartexamined, ca_study.studydescription, "
        + "ca_study.patientage, ca_study.occupation, ca_study.accession_number, "
        + "ca_instance.stationname, ca_instancedcm.fid, ca_imageinstance.imagepositionpatient, "
        + "ca_imageinstance.imageorientationpatient, ca_instancedcm.patch_name "
        + "from ris_examinfo "
        + "join ca_series on ris_examinfo.lab_num = ca_series.lab_num "
        + "join ca_patient on ris.examinfo.lab_num = ca_patient.lab_num "
        + "join ca_study on ris.examinfo.lab_num = ca_study.lab_num "
        + "join ca_instance on ris.examinfo.lab_num = ca_instance.lab_num "
        + "join ca_imageinstance on ris.examinfo.lab_num = ca_imageinstance.lab_num "
        + "where ris_examinfo.update_time > ? and ris_examinfo.update_time < ?";

    public static final String KINGSOFT_SQL = "select ore.*, odp.*"
          + "ofu.file_type, ofu.bucket, ofu.file_path "
          + "from ods_ris_exam_info ore "
          + "join ods_dicom_parse_info odp on ore.study_request_no = odp.study_request_no "
          + "join ods_file_upload_success ofu on ore.study_request_no = ofu.study_request_no"
          + "where ore.update_time > ? and ore.update_time < ?";

    //查询执行失败重试次数
    public static  final String MAXRETRIES = "jdbc.MaxRetries";

    //dataType、link_fields、index_fields参数取值
    public static class ParamsConstants {

        public static final String APPLY_DATATYPE = "examApplyInfo";
        public static final String[] APPLY_LINKFIELDS = {"organ_code", "system_id", "ris_study_id"};
        public static final String[] APPLY_INDEXFIELDS = {"organ_code", "system_id", "ris_study_id",
            "exam_id"};

        public static final String STUDY_DATATYPE = "examInfo";
        public static final String[] STUDY_LINKFIELDS = {"organ_code", "system_id", "ris_study_id"};
        public static final String[] STUDY_INDEXFIELDS = {"organ_code", "system_id",
            "ris_study_id"};

        public static final String REPORT_DATATYPE = "reportInfo";
        public static final String[] REPORT_LINKFIELDS = {"organ_code", "system_id", "ris_study_id"};
        public static final String[] REPORT_INDEXFIELDS = {"organ_code", "system_id", "ris_study_id", "result_id"};

        public static final String SERIES_DATATYPE = "dataType";
        public static final String[] SERIES_LINKFIELDS = {"organ_code", "system_id", "ris_study_id"};
        public static final String[] SERIES_INDEXFIELDS = {"organ_code", "system_id", "ris_study_id", "pacs_series_id"};
    }

}
