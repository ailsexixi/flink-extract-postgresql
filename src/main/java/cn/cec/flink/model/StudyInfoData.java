package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author YU Tao
 * @Description study_info表对应bean
 * @Date 20220416$
 * @Version 1.0
 */
public class StudyInfoData extends BaseData {

  @JsonProperty("proj_no")
  @JsonAlias(value = {"proj_no"})
  private String projNo;

  @JsonProperty("hos_proj_no")
  @JsonAlias(value = {"item_num"})
  private String hosProjNo;

  @JsonProperty("proj_name")
  @JsonAlias(value = {"item_name"})
  private String projName;

  @JsonProperty("ckpt_name")
  @JsonAlias(value = {"category_name", "study_body_part"})
  private String ckptName;

  @JsonProperty("chk_methodname")
  @JsonAlias(value = {"study_method"})
  private String chkMethodname;

  @JsonProperty("chk_dpt_code")
  @JsonAlias(value = {"dept_num"})
  private String chkDptCode;

  @JsonProperty("chk_dpt_name")
  @JsonAlias(value = {"dept_name", "visit_departments"})
  private String chkDptName;

  @JsonProperty("dev_room")
  @JsonAlias(value = {"study_room_number"})
  private String dev_room;

  @JsonProperty("dev_name")
  @JsonAlias(value = {"study_equipment_name"})
  private String devName;

  @JsonProperty("chk_modality")
  @JsonAlias(value = {"modality", "study_modality"})
  private String chkModality;

  @JsonProperty("chk_desc")
  @JsonAlias(value = {"chk_desc"})
  private String chkDesc;

  @JsonProperty("chk_status")
  @JsonAlias(value = {"check_status", "study_status_id"})
  private int chkStatus;

  @JsonProperty("reg_dt")
  @JsonAlias(value = {"register_date", "study_status_id"})
  private Long regDt;

  @JsonProperty("reg_doc_idcard")
  @JsonAlias(value = {"reg_doc_idcard"})
  private String regDocIdcard;

  @JsonProperty("reg_doc_name")
  @JsonAlias(value = {"reg_doc_name"})
  private String regDocName;

  @JsonProperty("arrive_dt")
  @JsonAlias(value = {"register_date", "study_status_id"})
  private Long arriveDt;

  @JsonProperty("chk_dt")
  @JsonAlias(value = {"check_date", "study_time"})
  private Long chkDt;

  @JsonProperty("chk_doc_idcard")
  @JsonAlias(value = {"chk_doc_idcard"})
  private String chkDocIdcard;

  @JsonProperty("chk_doc_name")
  @JsonAlias(value = {"performing_physician_name"})
  private String chkDocName;

  @JsonProperty("pat_id")
  @JsonAlias(value = {"patient_id"})
  private String system_patient_id;

  @JsonProperty("cardtype")
  @JsonAlias(value = {"cardtype"})
  private String cardType;

  @JsonProperty("cardno")
  @JsonAlias(value = {"cardno"})
  private String cardNo;

  @JsonProperty("idcard_hos_type")
  @JsonAlias(value = {"cardno"})
  private String idcardHosType;

  @JsonProperty("idcard_hos")
  @JsonAlias(value = {"mag_card_num", "medical_insurance_number"})
  private String idcardHos;

  @JsonProperty("patient_idcard")
  @JsonAlias(value = {"idcard", "id_card_number"})
  private String patientIdCard;

  @JsonProperty("name")
  @JsonAlias(value = {"pat_name", "patient_name"})
  private String name;

  @JsonProperty("ename")
  @JsonAlias(value = {"pat_spell_name", "patient_other_names"})
  private String eName;

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

  @JsonProperty("img_count")
  @JsonAlias(value = {"img_count"})
  private int imgCount;

  @JsonProperty("disable_flag")
  @JsonAlias(value = {"disable_flag"})
  private  int disableFlag;

  @JsonProperty("hash_id")
  @JsonAlias(value = {"hash_id"})
  private String hashId;

  public String getProjNo() {
    return projNo;
  }

  public void setProjNo(String projNo) {
    this.projNo = projNo;
  }

  public String getHosProjNo() {
    return hosProjNo;
  }

  public void setHosProjNo(String hosProjNo) {
    this.hosProjNo = hosProjNo;
  }

  public String getProjName() {
    return projName;
  }

  public void setProjName(String projName) {
    this.projName = projName;
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

  public String getChkDptCode() {
    return chkDptCode;
  }

  public void setChkDptCode(String chkDptCode) {
    this.chkDptCode = chkDptCode;
  }

  public String getChkDptName() {
    return chkDptName;
  }

  public void setChkDptName(String chkDptName) {
    this.chkDptName = chkDptName;
  }

  public String getDev_room() {
    return dev_room;
  }

  public void setDev_room(String dev_room) {
    this.dev_room = dev_room;
  }

  public String getDevName() {
    return devName;
  }

  public void setDevName(String devName) {
    this.devName = devName;
  }

  public String getChkModality() {
    return chkModality;
  }

  public void setChkModality(String chkModality) {
    this.chkModality = chkModality;
  }

  public String getChkDesc() {
    return chkDesc;
  }

  public void setChkDesc(String chkDesc) {
    this.chkDesc = chkDesc;
  }

  public int getChkStatus() {
    return chkStatus;
  }

  public void setChkStatus(int chkStatus) {
    this.chkStatus = chkStatus;
  }

  public Long getRegDt() {
    return regDt;
  }

  public void setRegDt(Long regDt) {
    this.regDt = regDt;
  }

  public String getRegDocIdcard() {
    return regDocIdcard;
  }

  public void setRegDocIdcard(String regDocIdcard) {
    this.regDocIdcard = regDocIdcard;
  }

  public String getRegDocName() {
    return regDocName;
  }

  public void setRegDocName(String regDocName) {
    this.regDocName = regDocName;
  }

  public Long getArriveDt() {
    return arriveDt;
  }

  public void setArriveDt(Long arriveDt) {
    this.arriveDt = arriveDt;
  }

  public Long getChkDt() {
    return chkDt;
  }

  public void setChkDt(Long chkDt) {
    this.chkDt = chkDt;
  }

  public String getChkDocIdcard() {
    return chkDocIdcard;
  }

  public void setChkDocIdcard(String chkDocIdcard) {
    this.chkDocIdcard = chkDocIdcard;
  }

  public String getChkDocName() {
    return chkDocName;
  }

  public void setChkDocName(String chkDocName) {
    this.chkDocName = chkDocName;
  }

  public String getSystem_patient_id() {
    return system_patient_id;
  }

  public void setSystem_patient_id(String system_patient_id) {
    this.system_patient_id = system_patient_id;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
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

  public String getPatientIdCard() {
    return patientIdCard;
  }

  public void setPatientIdCard(String patientIdCard) {
    this.patientIdCard = patientIdCard;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String geteName() {
    return eName;
  }

  public void seteName(String eName) {
    this.eName = eName;
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

  public int getImgCount() {
    return imgCount;
  }

  public void setImgCount(int imgCount) {
    this.imgCount = imgCount;
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
