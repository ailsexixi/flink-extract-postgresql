package cn.cec.flink.model;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;


public class PostGreSQLModel {

    @JsonProperty("id")
    @JsonAlias(value = {"id"})
    private String id;

    @JsonProperty("source_name")
    @JsonAlias(value = {"name","source"})
    private String sourceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
