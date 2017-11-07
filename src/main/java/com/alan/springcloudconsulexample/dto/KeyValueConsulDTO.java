package com.alan.springcloudconsulexample.dto;

import com.alan.springcloudconsulexample.serializer.StringToBase64Deserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Alan Dávila<br>
 * 22 Jul. 2017 19:36
 */
public class KeyValueConsulDTO {

    @JsonProperty("CreateIndex")
    private Integer createIndex;
    @JsonProperty("ModifyIndex")
    private Integer modifyIndex;
    @JsonProperty("LockIndex")
    private Integer lockIndex;
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Flags")
    private Integer flags;
    @JsonProperty("Value")
    @JsonDeserialize(using = StringToBase64Deserializer.class)
    private String value;
    @JsonProperty("Session")
    private String session;


    public Integer getCreateIndex() {
        return createIndex;
    }

    public void setCreateIndex(Integer createIndex) {
        this.createIndex = createIndex;
    }

    public Integer getModifyIndex() {
        return modifyIndex;
    }

    public void setModifyIndex(Integer modifyIndex) {
        this.modifyIndex = modifyIndex;
    }

    public Integer getLockIndex() {
        return lockIndex;
    }

    public void setLockIndex(Integer lockIndex) {
        this.lockIndex = lockIndex;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
