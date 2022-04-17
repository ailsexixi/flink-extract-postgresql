package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Describe 对应json格式的封装类
   * json格式: {"dataType":"...","data":"...","link_fields":"...","index_fields":"..."}
 */
public class PostGreSQLModel {

    @JsonProperty("dataType")
    @JsonAlias(value = {"dataType"})
    private String dataType;

    @JsonProperty("link_fields")
    @JsonAlias(value = {"link_fields"})
    private String[] link_fields;

    @JsonProperty("index_fields")
    @JsonAlias(value = {"index_fields"})
    private String[] index_fields;

    @JsonProperty("data")
    @JsonAlias(value = {"data"})
    private BaseData data;

    public PostGreSQLModel(String dataType, String[] link_fields, String[] index_fields,
        BaseData data) {
        this.dataType = dataType;
        this.link_fields = link_fields;
        this.index_fields = index_fields;
        this.data = data;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String[] getLink_fields() {
        return link_fields;
    }

    public void setLink_fields(String[] link_fields) {
        this.link_fields = link_fields;
    }

    public String[] getIndex_fields() {
        return index_fields;
    }

    public void setIndex_fields(String[] index_fields) {
        this.index_fields = index_fields;
    }

    public BaseData getData() {
        return data;
    }

    public void setData(BaseData data) {
        this.data = data;
    }
}
