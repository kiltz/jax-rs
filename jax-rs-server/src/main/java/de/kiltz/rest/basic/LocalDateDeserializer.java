package de.kiltz.rest.basic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author tz
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {
    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }


    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        CharSequence dateString = jp.readValueAs(String.class);
        System.out.println("deserial: " +dateString);
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.YYYY"));
    }

}
