package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Yu Tao
 * @Description apply_info表对应bean
 * @Date 20220414$
 * @Version 1.0
 */
public class ApplyInfoData extends BaseData{

  @JsonProperty("ris_study_ids")
  @JsonAlias(value = {"ris_study_ids"})
  private String risStudyId;

  @JsonProperty("exam_id")
  @JsonAlias(value = {"id"})
  private String ExamId;

  @JsonProperty("rpt_no")
  @JsonAlias(value = {"lab_num", "study_request_no"})
  private String rptNo;

  @JsonProperty("hos_pack_no")
  @JsonAlias(value = {"hos_pack_no"})
  private String hosPackNo;

  @JsonProperty("hos_pack_name")
  @JsonAlias(value = {"hos_pack_name"})
  private String hosPackName;

  @JsonProperty("proj_no")
  @JsonAlias(value = {" proj_no"})
  private String  proNo;

  @JsonProperty("hos_proj_no")
  @JsonAlias(value = {"item_num"})
  private String  hosProjNo;

  @JsonProperty("proj_name")
  @JsonAlias(value = {" item_name"})
  private String  proj_name;

  @JsonProperty("ckpt_name")
  @JsonAlias(value = {"category_name","study_body_part"})
  private String  ckptName;

  @JsonProperty("chk_methodname")
  @JsonAlias(value = {"study_method"})
  private String  chkMethodname;

  @JsonProperty("chk_modality")
  @JsonAlias(value = {"modality", "study_modality"})
  private String  chkModality;

  @JsonProperty("app_dpt_code")
  @JsonAlias(value = {"dept_num"})
  private String  appDptCode;

  @JsonProperty("app_dpt_name")
  @JsonAlias(value = {"dept_name", "visit_departments"})
  private String  appDptName;

  @JsonProperty("app_doc_idcard")
  @JsonAlias(value = {"app_doc_idcard"})
  private String  appDocIdcard;

  @JsonProperty("app_doc_name")
  @JsonAlias(value = {"apply_doctor_name"})
  private String  appDocName;

  @JsonProperty("app_dt")
  @JsonAlias(value = {"study_request_time"})
  private Long  applyDt;

  @JsonProperty("app_remark")
  @JsonAlias(value = {"app_remark"})
  private String appRemark;

  @JsonProperty("clinic_diagnose")
  @JsonAlias(value = {"diagnosis", "first_clinical_diagnosis"})
  private String clinicDiagnose;

  @JsonProperty("symptom")
  @JsonAlias(value = {"clinical_history", "medical_history"})
  private String symptom;

  @JsonProperty("subj_complaint")
  @JsonAlias(value = {"chief_complaint"})
  private String subjComplaint;

  @JsonProperty("allergy_history")
  @JsonAlias(value = {"allergy_history"})
  private String allergyHistory;

  @JsonProperty("organ_empi")
  @JsonAlias(value = {"organ_empi"})
  private String organEmpi;

  @JsonProperty("organ_global_empi")
  @JsonAlias(value = {"organ_global_empi"})
  private String organGlobalEmpi;

  @JsonProperty("cardtype")
  @JsonAlias(value = {"cardtype"})
  private String cardType;

  @JsonProperty("cardno")
  @JsonAlias(value = {"cardno"})
  private String cardno;

  @JsonProperty("idcard_hos_type")
  @JsonAlias(value = {"idcard_hos_type"})
  private String idcardHosType;

  @JsonProperty("idcard_hos")
  @JsonAlias(value = {"mag_card_num", "medical_insurance_number"})
  private String idcardHos;

  @JsonProperty("patient_idcard")
  @JsonAlias(value = {"idcard", "id_card_number"})
  private String patientIdcard;

  @JsonProperty("name")
  @JsonAlias(value = {"pat_name", "patient_name"})
  private String name;

  @JsonProperty("sex")
  @JsonAlias(value = {"sex", "patient_sex"})
  private int sex;

  @JsonProperty("birthday")
  @JsonAlias(value = {"pat_birthday", "patient_birth_date"})
  private String birthday;

  @JsonProperty("mobile")
  @JsonAlias(value = {"pat_telephone", "phone_number"})
  private String mobile;

  @JsonProperty("op_em_hp_ex_mark")
  @JsonAlias(value = {"pat_type", "patient_visit_type"})
  private int opEmHpExMark;

  @JsonProperty("op_em_hp_ex_no")
  @JsonAlias(value = {"pat_type", "patient_visit_type"})
  private String opEmHpExNo;

  @JsonProperty("ward")
  @JsonAlias(value = {"ward", "hospitalization_area"})
  private String ward;

  @JsonProperty("sickbed_number")
  @JsonAlias(value = {"bunk_id", "hospitalization_bed_number"})
  private String sickbedNumber;

  @JsonProperty("type")
  @JsonAlias(value = {"type"})
  private int type;

  @JsonProperty("disable_flag")
  @JsonAlias(value = {"disable_flag"})
  private  int disableFlag;

  @JsonProperty("hash_id")
  @JsonAlias(value = {"hash_id"})
  private String hashId;

  public String getRisStudyId() {
    return risStudyId;
  }

  public void setRisStudyId(String risStudyId) {
    this.risStudyId = risStudyId;
  }

  public String getExamId() {
    return ExamId;
  }

  public void setExamId(String examId) {
    ExamId = examId;
  }

  public String getRptNo() {
    return rptNo;
  }

  public void setRptNo(String rptNo) {
    this.rptNo = rptNo;
  }

  public String getHosPackNo() {
    return hosPackNo;
  }

  public void setHosPackNo(String hosPackNo) {
    this.hosPackNo = hosPackNo;
  }

  public String getHosPackName() {
    return hosPackName;
  }

  public void setHosPackName(String hosPackName) {
    this.hosPackName = hosPackName;
  }

  public String getProNo() {
    return proNo;
  }

  public void setProNo(String proNo) {
    this.proNo = proNo;
  }

  public String getHosProjNo() {
    return hosProjNo;
  }

  public void setHosProjNo(String hosProjNo) {
    this.hosProjNo = hosProjNo;
  }

  public String getProj_name() {
    return proj_name;
  }

  public void setProj_name(String proj_name) {
    this.proj_name = proj_name;
  }

  public String getCkptName() {
    return ckptName;
  }

  public void setCkptName(String ckptName) {
    this.ckptName = ckptName;
  }

  public String getChkMethodname() {
    return chkMethodname;
  }

  public void setChkMethodname(String chkMethodname) {
    this.chkMethodname = chkMethodname;
  }

  public String getChkModality() {
    return chkModality;
  }

  public void setChkModality(String chkModality) {
    this.chkModality = chkModality;
  }

  public String getAppDptCode() {
    return appDptCode;
  }

  public void setAppDptCode(String appDptCode) {
    this.appDptCode = appDptCode;
  }

  public String getAppDptName() {
    return appDptName;
  }

  public void setAppDptName(String appDptName) {
    this.appDptName = appDptName;
  }

  public String getAppDocIdcard() {
    return appDocIdcard;
  }

  public void setAppDocIdcard(String appDocIdcard) {
    this.appDocIdcard = appDocIdcard;
  }

  public String getAppDocName() {
    return appDocName;
  }

  public void setAppDocName(String appDocName) {
    this.appDocName = appDocName;
  }

  public Long getApplyDt() {
    return applyDt;
  }

  public void setApplyDt(Long applyDt) {
    this.applyDt = applyDt;
  }

  public String getAppRemark() {
    return appRemark;
  }

  public void setAppRemark(String appRemark) {
    this.appRemark = appRemark;
  }

  public String getClinicDiagnose() {
    return clinicDiagnose;
  }

  public void setClinicDiagnose(String clinicDiagnose) {
    this.clinicDiagnose = clinicDiagnose;
  }

  public String getSymptom() {
    return symptom;
  }

  public void setSymptom(String symptom) {
    this.symptom = symptom;
  }

  public String getSubjComplaint() {
    return subjComplaint;
  }

  public void setSubjComplaint(String subjComplaint) {
    this.subjComplaint = subjComplaint;
  }

  public String getAllergyHistory() {
    return allergyHistory;
  }

  public void setAllergyHistory(String allergyHistory) {
    this.allergyHistory = allergyHistory;
  }

  public String getOrganEmpi() {
    return organEmpi;
  }

  public void setOrganEmpi(String organEmpi) {
    this.organEmpi = organEmpi;
  }

  public String getOrganGlobalEmpi() {
    return organGlobalEmpi;
  }

  public void setOrganGlobalEmpi(String organGlobalEmpi) {
    this.organGlobalEmpi = organGlobalEmpi;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getCardno() {
    return cardno;
  }

  public void setCardno(String cardno) {
    this.cardno = cardno;
  }

  public String getIdcardHosType() {
    return idcardHosType;
  }

  public void setIdcardHosType(String idcardHosType) {
    this.idcardHosType = idcardHosType;
  }

  public String getIdcardHos() {
    return idcardHos;
  }

  public void setIdcardHos(String idcardHos) {
    this.idcardHos = idcardHos;
  }

  public String getPatientIdcard() {
    return patientIdcard;
  }

  public void setPatientIdcard(String patientIdcard) {
    this.patientIdcard = patientIdcard;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public int getOpEmHpExMark() {
    return opEmHpExMark;
  }

  public void setOpEmHpExMark(int opEmHpExMark) {
    this.opEmHpExMark = opEmHpExMark;
  }

  public String getOpEmHpExNo() {
    return opEmHpExNo;
  }

  public void setOpEmHpExNo(String opEmHpExNo) {
    this.opEmHpExNo = opEmHpExNo;
  }

  public String getWard() {
    return ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public String getSickbedNumber() {
    return sickbedNumber;
  }

  public void setSickbedNumber(String sickbedNumber) {
    this.sickbedNumber = sickbedNumber;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
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
