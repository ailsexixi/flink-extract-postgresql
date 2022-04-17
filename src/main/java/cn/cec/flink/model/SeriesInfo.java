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
  @JsonAlias(value = {"patientname", "patient_name"})
  private String patientName;

  @JsonProperty("patient_id")
  @JsonAlias(value = {"patientid", "patient_id"})
  private String patientId;

  @JsonProperty("other_patient_ids")
  @JsonAlias(value = {"otherpatientids", "other_patient_ids"})
  private String otherPatientIds;

  @JsonProperty("other_patient_names")
  @JsonAlias(value = {"otherpatientnames", "other_patient_names"})
  private String otherPatientNames;

  @JsonProperty("patient_birth_date")
  @JsonAlias(value = {"birthdate", "patient_birth_date"})
  private String patientBirthDate;

  @JsonProperty("patient_sex")
  @JsonAlias(value = {"sex", "patient_sex"})
  private String patientSex;

  @JsonProperty("patient_weight")
  @JsonAlias(value = {"weight", "patient_weight"})
  private String patientWeight;

  @JsonProperty("patient_size")
  @JsonAlias(value = {"size", "patient_size"})
  private String patientSize;

  @JsonProperty("pregnancy_status")
  @JsonAlias(value = {"pregnancy_status"})
  private String pregnancyStatus;

  @JsonProperty("study_priority_id")
  @JsonAlias(value = {"study_priority_id"})
  private String studyPriorityId;

  @JsonProperty("study_comments")
  @JsonAlias(value = {"study_comments"})
  private String studyComments;

  @JsonProperty("study_date")
  @JsonAlias(value = {"studydate", "study_date"})
  private String studyDate;

  @JsonProperty("study_time")
  @JsonAlias(value = {"study_time", "studytime"})
  private String studyTime;

  @JsonProperty("study_completion_date")
  @JsonAlias(value = {"study_completion_date"})
  private String studyCompletionDate;

  @JsonProperty("study_completion_time")
  @JsonAlias(value = {"study_completion_time"})
  private String studyCompletionTime;

  @JsonProperty("performing_physician_name")
  @JsonAlias(value = {"performing_physician_name"})
  private String performingPhysicianName;

  @JsonProperty("modalities_in_study")
  @JsonAlias(value = {"modalities_in_study"})
  private String modalitiesInStudy;

  @JsonProperty("body_part_examined")
  @JsonAlias(value = {"body_part_examined, bodypartexamined"})
  private String bodyPartExamined;

  @JsonProperty("study_description")
  @JsonAlias(value = {"study_description", "studydescription"})
  private String studyDescription;

  @JsonProperty("patient_age")
  @JsonAlias(value = {"patientage", "patient_age"})
  private String patientAge;

  @JsonProperty("institution_name")
  @JsonAlias(value = {"institution_name"})
  private String institutionName;

  @JsonProperty("manufacturer")
  @JsonAlias(value = {"equipment_produced"})
  private String manufacturer;

  @JsonProperty("manufacturers_model_name")
  @JsonAlias(value = {"manufacturer_model_name"})
  private String manufacturersModelName;

  @JsonProperty("station_name")
  @JsonAlias(value = {"stationname", "station_name"})
  private String stationName;

  @JsonProperty("patient_phone")
  @JsonAlias(value = {"patient_telephone"})
  private String patientPhone;

  @JsonProperty("software_version")
  @JsonAlias(value = {"software_versions"})
  private String softwareVersion;

  @JsonProperty("chk_modality")
  @JsonAlias(value = {"modality"})
  private String chkModality;

  @JsonProperty("imagenumber_of_study")
  @JsonAlias(value = {"imagenumber_of_study"})
  private String imagenumberOfStudy;

  @JsonProperty("patient_address")
  @JsonAlias(value = {"patient_address", "address"})
  private String patientAddress;

  @JsonProperty("occupation")
  @JsonAlias(value = {"occupation"})
  private String occupation;

  @JsonProperty("allergic_history")
  @JsonAlias(value = {"allergies"})
  private String allergicHistory;

  @JsonProperty("kvp")
  @JsonAlias(value = {"kvp"})
  private String kvp;

  @JsonProperty("exposure")
  @JsonAlias(value = {"exposure"})
  private String exposure;

  @JsonProperty("series_description")
  @JsonAlias(value = {"seriesdescription", "series_description"})
  private String seriesDescription;

  @JsonProperty("series_date")
  @JsonAlias(value = {"series_date", "seriesdate"})
  private String seriesDate;

  @JsonProperty("series_time")
  @JsonAlias(value = {"series_time", "seriestime"})
  private String seriesTime;

  @JsonProperty("image_position")
  @JsonAlias(value = {"imagepositionpatient", "image_position"})
  private String imagePosition;

  @JsonProperty("image_orientation")
  @JsonAlias(value = {"image_orientation", "imageorientationpatient"})
  private String imageOrientation;

  @JsonProperty("slice_thickness")
  @JsonAlias(value = {"slice_thickness"})
  private String sliceThickness;

  @JsonProperty("spacing_between_slices")
  @JsonAlias(value = {"spacing_between_slices"})
  private String spacingBetweenSlices;

  @JsonProperty("slice_location")
  @JsonAlias(value = {"slice_location"})
  private String sliceLcation;

  @JsonProperty("mr_acquisition_type")
  @JsonAlias(value = {"mr_acquisition_type"})
  private String mrAcquisitionType;

  @JsonProperty("accession_number")
  @JsonAlias(value = {"accession_number", "accession_number"})
  private String accessionNumber;

  @JsonProperty("entrance_dose_in_milli_gy")
  @JsonAlias(value = {"entrance_dose_in_milli_gy"})
  private String entranceDoseInMilliGy;

  @JsonProperty("distance_source_to_detector")
  @JsonAlias(value = {"distance_source_to_detector"})
  private String distanceSourceToDetector;

  @JsonProperty("storage_path")
  @JsonAlias(value = {"bucket", "patch_name", "file_path", "fid"})
  private String storagePath;

  @JsonProperty("thumb_path")
  @JsonAlias(value = {"thumb_path"})
  private String thumbPath;

  @JsonProperty("window_center")
  @JsonAlias(value = {"window_center"})
  private String windowCenter;

  @JsonProperty("window_width")
  @JsonAlias(value = {"window_width"})
  private String windowWidth;

  @JsonProperty("dcm_analysis_time")
  @JsonAlias(value = {"window_width"})
  private Long dcmAnalysisTime;

  public String getPacsStudyId() {
    return pacsStudyId;
  }

  public void setPacsStudyId(String pacsStudyId) {
    this.pacsStudyId = pacsStudyId;
  }

  public String getStudyInstanceUid() {
    return studyInstanceUid;
  }

  public void setStudyInstanceUid(String studyInstanceUid) {
    this.studyInstanceUid = studyInstanceUid;
  }

  public String getPacsSeriesId() {
    return pacsSeriesId;
  }

  public void setPacsSeriesId(String pacsSeriesId) {
    this.pacsSeriesId = pacsSeriesId;
  }

  public int getImageCount() {
    return imageCount;
  }

  public void setImageCount(int imageCount) {
    this.imageCount = imageCount;
  }

  public String getSeriesSort() {
    return seriesSort;
  }

  public void setSeriesSort(String seriesSort) {
    this.seriesSort = seriesSort;
  }

  public int getImageType() {
    return imageType;
  }

  public void setImageType(int imageType) {
    this.imageType = imageType;
  }

  public int getDisableFlag() {
    return disableFlag;
  }

  public void setDisableFlag(int disableFlag) {
    this.disableFlag = disableFlag;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getOtherPatientIds() {
    return otherPatientIds;
  }

  public void setOtherPatientIds(String otherPatientIds) {
    this.otherPatientIds = otherPatientIds;
  }

  public String getOtherPatientNames() {
    return otherPatientNames;
  }

  public void setOtherPatientNames(String otherPatientNames) {
    this.otherPatientNames = otherPatientNames;
  }

  public String getPatientBirthDate() {
    return patientBirthDate;
  }

  public void setPatientBirthDate(String patientBirthDate) {
    this.patientBirthDate = patientBirthDate;
  }

  public String getPatientSex() {
    return patientSex;
  }

  public void setPatientSex(String patientSex) {
    this.patientSex = patientSex;
  }

  public String getPatientWeight() {
    return patientWeight;
  }

  public void setPatientWeight(String patientWeight) {
    this.patientWeight = patientWeight;
  }

  public String getPatientSize() {
    return patientSize;
  }

  public void setPatientSize(String patientSize) {
    this.patientSize = patientSize;
  }

  public String getPregnancyStatus() {
    return pregnancyStatus;
  }

  public void setPregnancyStatus(String pregnancyStatus) {
    this.pregnancyStatus = pregnancyStatus;
  }

  public String getStudyPriorityId() {
    return studyPriorityId;
  }

  public void setStudyPriorityId(String studyPriorityId) {
    this.studyPriorityId = studyPriorityId;
  }

  public String getStudyComments() {
    return studyComments;
  }

  public void setStudyComments(String studyComments) {
    this.studyComments = studyComments;
  }

  public String getStudyDate() {
    return studyDate;
  }

  public void setStudyDate(String studyDate) {
    this.studyDate = studyDate;
  }

  public String getStudyTime() {
    return studyTime;
  }

  public void setStudyTime(String studyTime) {
    this.studyTime = studyTime;
  }

  public String getStudyCompletionDate() {
    return studyCompletionDate;
  }

  public void setStudyCompletionDate(String studyCompletionDate) {
    this.studyCompletionDate = studyCompletionDate;
  }

  public String getStudy_completion_time() {
    return studyCompletionTime;
  }

  public void setStudy_completion_time(String studyCompletionTime) {
    this.studyCompletionTime = studyCompletionTime;
  }

  public String getPerformingPhysicianName() {
    return performingPhysicianName;
  }

  public void setPerformingPhysicianName(String performingPhysicianName) {
    this.performingPhysicianName = performingPhysicianName;
  }

  public String getModalitiesInStudy() {
    return modalitiesInStudy;
  }

  public void setModalitiesInStudy(String modalitiesInStudy) {
    this.modalitiesInStudy = modalitiesInStudy;
  }

  public String getBodyPartExamined() {
    return bodyPartExamined;
  }

  public void setBodyPartExamined(String bodyPartExamined) {
    this.bodyPartExamined = bodyPartExamined;
  }

  public String getStudy_description() {
    return studyDescription;
  }

  public void setStudy_description(String studyDescription) {
    this.studyDescription = studyDescription;
  }

  public String getPatientAge() {
    return patientAge;
  }

  public void setPatientAge(String patientAge) {
    this.patientAge = patientAge;
  }

  public String getInstitutionName() {
    return institutionName;
  }

  public void setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getManufacturersModelName() {
    return manufacturersModelName;
  }

  public void setManufacturersModelName(String manufacturersModelName) {
    this.manufacturersModelName = manufacturersModelName;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getPatientPhone() {
    return patientPhone;
  }

  public void setPatientPhone(String patientPhone) {
    this.patientPhone = patientPhone;
  }

  public String getSoftwareVersion() {
    return softwareVersion;
  }

  public void setSoftwareVersion(String softwareVersion) {
    this.softwareVersion = softwareVersion;
  }

  public String getChkModality() {
    return chkModality;
  }

  public void setChkModality(String chkModality) {
    this.chkModality = chkModality;
  }

  public String getImagenumberOfStudy() {
    return imagenumberOfStudy;
  }

  public void setImagenumberOfStudy(String imagenumberOfStudy) {
    this.imagenumberOfStudy = imagenumberOfStudy;
  }

  public String getPatientAddress() {
    return patientAddress;
  }

  public void setPatientAddress(String patientAddress) {
    this.patientAddress = patientAddress;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getAllergicHistory() {
    return allergicHistory;
  }

  public void setAllergicHistory(String allergicHistory) {
    this.allergicHistory = allergicHistory;
  }

  public String getKvp() {
    return kvp;
  }

  public void setKvp(String kvp) {
    this.kvp = kvp;
  }

  public String getExposure() {
    return exposure;
  }

  public void setExposure(String exposure) {
    this.exposure = exposure;
  }

  public String getSeriesDescription() {
    return seriesDescription;
  }

  public void setSeriesDescription(String seriesDescription) {
    this.seriesDescription = seriesDescription;
  }

  public String getSeriesDate() {
    return seriesDate;
  }

  public void setSeriesDate(String seriesDate) {
    this.seriesDate = seriesDate;
  }

  public String getSeriesTime() {
    return seriesTime;
  }

  public void setSeriesTime(String seriesTime) {
    this.seriesTime = seriesTime;
  }

  public String getImagePosition() {
    return imagePosition;
  }

  public void setImagePosition(String imagePosition) {
    this.imagePosition = imagePosition;
  }

  public String getImageOrientation() {
    return imageOrientation;
  }

  public void setImageOrientation(String imageOrientation) {
    this.imageOrientation = imageOrientation;
  }

  public String getSliceThickness() {
    return sliceThickness;
  }

  public void setSliceThickness(String sliceThickness) {
    this.sliceThickness = sliceThickness;
  }

  public String getSpacingBetweenSlices() {
    return spacingBetweenSlices;
  }

  public void setSpacingBetweenSlices(String spacingBetweenSlices) {
    this.spacingBetweenSlices = spacingBetweenSlices;
  }

  public String getSliceLcation() {
    return sliceLcation;
  }

  public void setSliceLcation(String sliceLcation) {
    this.sliceLcation = sliceLcation;
  }

  public String getMrAcquisitionType() {
    return mrAcquisitionType;
  }

  public void setMrAcquisitionType(String mrAcquisitionType) {
    this.mrAcquisitionType = mrAcquisitionType;
  }

  public String getAccessionNumber() {
    return accessionNumber;
  }

  public void setAccessionNumber(String accessionNumber) {
    this.accessionNumber = accessionNumber;
  }

  public String getEntranceDoseInMilliGy() {
    return entranceDoseInMilliGy;
  }

  public void setEntranceDoseInMilliGy(String entranceDoseInMilliGy) {
    this.entranceDoseInMilliGy = entranceDoseInMilliGy;
  }

  public String getDistanceSourceToDetector() {
    return distanceSourceToDetector;
  }

  public void setDistanceSourceToDetector(String distanceSourceToDetector) {
    this.distanceSourceToDetector = distanceSourceToDetector;
  }

  public String getStoragePath() {
    return storagePath;
  }

  public void setStoragePath(String storagePath) {
    this.storagePath = storagePath;
  }

  public String getThumbPath() {
    return thumbPath;
  }

  public void setThumbPath(String thumbPath) {
    this.thumbPath = thumbPath;
  }

  public String getWindowCenter() {
    return windowCenter;
  }

  public void setWindowCenter(String windowCenter) {
    this.windowCenter = windowCenter;
  }

  public String getWindowWidth() {
    return windowWidth;
  }

  public void setWindowWidth(String windowWidth) {
    this.windowWidth = windowWidth;
  }

  public Long getDcmAnalysisTime() {
    return dcmAnalysisTime;
  }

  public void setDcmAnalysisTime(Long dcmAnalysisTime) {
    this.dcmAnalysisTime = dcmAnalysisTime;
  }
}
