package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Yu Tao
 * @Description
 * @Date 20220415$
 * @Version 1.0
 */
public abstract class BaseData {

  @JsonProperty("organ_code")
  @JsonAlias(value = {"hospitalcode", "hospital_code"})
  private String orgCode;

  @JsonProperty("organ_name")
  @JsonAlias(value = {"hospital_name"})
  private String orgName;

//  @JsonProperty("organ_name")
//  @JsonAlias(value = {"hospital_name"})
//  private String systemId;

  @JsonProperty("ris_study_id")
  @JsonAlias(value = {"study_uid", "study_instance_uid"})
  private String risStudyId;

  @JsonProperty("data_arrive_time")
  @JsonAlias(value = {"data_arrive_time"})
  private String dataArriveTime;

  @JsonProperty("data_process_time")
  @JsonAlias(value = {"data_process_time"})
  private String dataProcessTime;

  @JsonProperty("update_time")
  @JsonAlias(value = {"update_time"})
  private Long upDateTime;

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

//  public String getSystemId() {
//    return systemId;
//  }

//  public void setSystemId(String systemId) {
//    this.systemId = systemId;
//  }

  public String getRisStudyId() {
    return risStudyId;
  }

  public void setRisStudyId(String risStudyId) {
    this.risStudyId = risStudyId;
  }

  public String getDataArriveTime() {
    return dataArriveTime;
  }

  public void setDataArriveTime(String dataArriveTime) {
    this.dataArriveTime = dataArriveTime;
  }

  public String getDataProcessTime() {
    return dataProcessTime;
  }

  public void setDataProcessTime(String dataProcessTime) {
    this.dataProcessTime = dataProcessTime;
  }

  public Long getUpDateTime() {
    return upDateTime;
  }

  public void setUpDateTime(Long upDateTime) {
    this.upDateTime = upDateTime;
  }




}
