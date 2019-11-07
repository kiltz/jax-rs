package de.kiltz.rest.basic;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author tz
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {
    public LocalDateSerializer(){
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        String datum = DateTimeFormatter.ofPattern("dd.MM.YYYY").format(value);
        System.out.println("Serial: "+ datum);
        gen.writeString(datum);
    }
}
