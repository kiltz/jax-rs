package de.kiltz.rest.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author tz
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        System.out.println("Unmarshal: " + dateString);
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        System.out.println("Marshal: " + localDate);
        return DateTimeFormatter.ofPattern("dd.MM.YYYY").format(localDate);
    }
    
}
