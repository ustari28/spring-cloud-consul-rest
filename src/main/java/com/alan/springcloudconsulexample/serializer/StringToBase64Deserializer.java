package com.alan.springcloudconsulexample.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Base64;

import static org.apache.commons.lang.CharEncoding.UTF_8;

/**
 * @author Alan Dávila<br>
 *         22 Jul. 2017 21:30
 */
public class StringToBase64Deserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        return new String(Base64.getDecoder().decode(p.getText().getBytes(UTF_8)), UTF_8);
    }
}
