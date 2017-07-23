package com.alan.springcloudconsulexample.dto;

import com.alan.springcloudconsulexample.serializer.StringToBase64Deserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

/**
 * @author Alan Dávila<br>
 *         22 Jul. 2017 19:36
 */
@Data
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
}
