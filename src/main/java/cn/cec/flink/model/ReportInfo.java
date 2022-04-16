package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Yu Tao
 * @Description report_info表对应bean
 * @Date 202200417$
 * @Version 1.0
 */
public class ReportInfo extends BaseData{

  @JsonProperty("result_id")
  @JsonAlias(value = {"record_num", "report_uid"})
  private  int resultId;

  @JsonProperty("rpt_no")
  @JsonAlias(value = {"lab_num", "study_request_no"})
  private String rptNo;

  @JsonProperty("rpt_status")
  @JsonAlias(value = {"check_status", "report_status"})
  private int rptStatus;

  @JsonProperty("rpt_organ_code")
  @JsonAlias(value = {"rpt_organ_code"})
  private String rptOrganCode;

  @JsonProperty("rpt_idcard")
  @JsonAlias(value = {"rpt_idcard"})
  private String rptIdcard;

  @JsonProperty("rpt_name")
  @JsonAlias(value = {"report_doctor_name", "report_create_doctor"})
  private String rptName;

  @JsonProperty("rv_organ_code")
  @JsonAlias(value = {"rv_organ_code"})
  private String rvOrganCode;

  @JsonProperty("rv_idcard")
  @JsonAlias(value = {"rv_idcard"})
  private String rvIdcard;

  @JsonProperty("rv_name")
  @JsonAlias(value = {"confirm_doctor_name", "report_submit_doctor"})
  private String rvName;

  @JsonProperty("rv2_organ_code")
  @JsonAlias(value = {"rv2_organ_code"})
  private String rv2OrganCode;

  @JsonProperty("rv2_idcard")
  @JsonAlias(value = {"rv2_idcard"})
  private String rv2Idcard;

  @JsonProperty("rv2_name")
  @JsonAlias(value = {"report_approve_doctor"})
  private String rv2Name;

  @JsonProperty("rpt_dt")
  @JsonAlias(value = {"report_date", "report_create_time"})
  private Long rptDt;

  @JsonProperty("rv_dt")
  @JsonAlias(value = {"confirm_date", "report_submit_time"})
  private Long rvDt;

  @JsonProperty("rv2_dt")
  @JsonAlias(value = {"report_approve_time"})
  private Long rv2Dt;

  @JsonProperty("rpt_type")
  @JsonAlias(value = {"rpt_type"})
  private int  rptType;

  @JsonProperty("rpt_descrip")
  @JsonAlias(value = {"findings", "image_performance"})
  private String rptDescrip;

  @JsonProperty("rpt_seeing")
  @JsonAlias(value = {"inspect_exam_result", "report_diagnoses"})
  private String rptSeeing;

  @JsonProperty("rpt_remark")
  @JsonAlias(value = {"remark"})
  private String rptRemark;

  @JsonProperty("rpt_pub_dt")
  @JsonAlias(value = {"report_public_time"})
  private Long rptPubDt;

  @JsonProperty("rpt_critical_value")
  @JsonAlias(value = {"rpt_critical_value"})
  private String rptCriticalValue;

  @JsonProperty("snapshot_count")
  @JsonAlias(value = {"snapshot_count"})
  private int snapshotCount;

  @JsonProperty("rpt_image_count")
  @JsonAlias(value = {"rpt_image_count"})
  private int rptImageCount;

  @JsonProperty("rpt_share")
  @JsonAlias(value = {"rpt_share"})
  private int rptShare;

  @JsonProperty("disable_flag")
  @JsonAlias(value = {"disable_flag"})
  private  int disableFlag;

  @JsonProperty("hash_id")
  @JsonAlias(value = {"hash_id"})
  private String hashId;

  public int getResultId() {
    return resultId;
  }

  public void setResultId(int resultId) {
    this.resultId = resultId;
  }

  public String getRptNo() {
    return rptNo;
  }

  public void setRptNo(String rptNo) {
    this.rptNo = rptNo;
  }

  public int getRptStatus() {
    return rptStatus;
  }

  public void setRptStatus(int rptStatus) {
    this.rptStatus = rptStatus;
  }

  public String getRptOrganCode() {
    return rptOrganCode;
  }

  public void setRptOrganCode(String rptOrganCode) {
    this.rptOrganCode = rptOrganCode;
  }

  public String getRptIdcard() {
    return rptIdcard;
  }

  public void setRptIdcard(String rptIdcard) {
    this.rptIdcard = rptIdcard;
  }

  public String getRptName() {
    return rptName;
  }

  public void setRptName(String rptName) {
    this.rptName = rptName;
  }

  public String getRvOrganCode() {
    return rvOrganCode;
  }

  public void setRvOrganCode(String rvOrganCode) {
    this.rvOrganCode = rvOrganCode;
  }

  public String getRvIdcard() {
    return rvIdcard;
  }

  public void setRvIdcard(String rvIdcard) {
    this.rvIdcard = rvIdcard;
  }

  public String getRvName() {
    return rvName;
  }

  public void setRvName(String rvName) {
    this.rvName = rvName;
  }

  public String getRv2OrganCode() {
    return rv2OrganCode;
  }

  public void setRv2OrganCode(String rv2OrganCode) {
    this.rv2OrganCode = rv2OrganCode;
  }

  public String getRv2Idcard() {
    return rv2Idcard;
  }

  public void setRv2Idcard(String rv2Idcard) {
    this.rv2Idcard = rv2Idcard;
  }

  public String getRv2Name() {
    return rv2Name;
  }

  public void setRv2Name(String rv2Name) {
    this.rv2Name = rv2Name;
  }

  public Long getRptDt() {
    return rptDt;
  }

  public void setRptDt(Long rptDt) {
    this.rptDt = rptDt;
  }

  public Long getRvDt() {
    return rvDt;
  }

  public void setRvDt(Long rvDt) {
    this.rvDt = rvDt;
  }

  public Long getRv2Dt() {
    return rv2Dt;
  }

  public void setRv2Dt(Long rv2Dt) {
    this.rv2Dt = rv2Dt;
  }

  public int getRptType() {
    return rptType;
  }

  public void setRptType(int rptType) {
    this.rptType = rptType;
  }

  public String getRptDescrip() {
    return rptDescrip;
  }

  public void setRptDescrip(String rptDescrip) {
    this.rptDescrip = rptDescrip;
  }

  public String getRptSeeing() {
    return rptSeeing;
  }

  public void setRptSeeing(String rptSeeing) {
    this.rptSeeing = rptSeeing;
  }

  public String getRptRemark() {
    return rptRemark;
  }

  public void setRptRemark(String rptRemark) {
    this.rptRemark = rptRemark;
  }

  public Long getRptPubDt() {
    return rptPubDt;
  }

  public void setRptPubDt(Long rptPubDt) {
    this.rptPubDt = rptPubDt;
  }

  public String getRptCriticalValue() {
    return rptCriticalValue;
  }

  public void setRptCriticalValue(String rptCriticalValue) {
    this.rptCriticalValue = rptCriticalValue;
  }

  public int getSnapshotCount() {
    return snapshotCount;
  }

  public void setSnapshotCount(int snapshotCount) {
    this.snapshotCount = snapshotCount;
  }

  public int getRptImageCount() {
    return rptImageCount;
  }

  public void setRptImageCount(int rptImageCount) {
    this.rptImageCount = rptImageCount;
  }

  public int getRptShare() {
    return rptShare;
  }

  public void setRptShare(int rptShare) {
    this.rptShare = rptShare;
  }

  public int getDisableFlag() {
    return disableFlag;
  }

  public void setDisableFlag(int disableFlag) {
    this.disableFlag = disableFlag;
  }

  public String getHashId() {
    return hashId;
  }

  public void setHashId(String hashId) {
    this.hashId = hashId;
  }
}
