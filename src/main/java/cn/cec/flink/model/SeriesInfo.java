package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Yu Tao
 * @Description
 * @Date 20220417$
 * @Version 1.0
 */
public class SeriesInfo extends BaseData {

  @JsonProperty("pacs_study_id")
  @JsonAlias(value = {"pacs_study_id"})
  private String pacsStudyId;

  @JsonProperty("study_instance_uid")
  @JsonAlias(value = {"study_instance_uid"})
  private String studyInstanceUid;

  @JsonProperty("pacs_series_id")
  @JsonAlias(value = {"seriesinstanceuid", "series_instance_uid"})
  private String pacsSeriesId;

  @JsonProperty("image_count")
  @JsonAlias(value = {"image_count"})
  private int imageCount;

  @JsonProperty("series_sort")
  @JsonAlias(value = {"seriesnumber", "series_number"})
  private String seriesSort;

  @JsonProperty("image_type")
  @JsonAlias(value = {"file_type"})
  private int imageType;

  @JsonProperty("disable_flag")
  @JsonAlias(value = {"disable_flag"})
  private int disableFlag;

  @JsonProperty("patient_name")
  @JsonAlias(value = {"disable_flag"})
  private String patientName;

}
