package ua.dp.wheaten.site.web.converter;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by kkm on 07.02.2016.
 */
public class LocalDateToStringConverter implements Converter<LocalDate, String> {

    private DateTimeFormatter formatter;

    public LocalDateToStringConverter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String convert(LocalDate date) {
        return date.format(formatter);
    }
}
