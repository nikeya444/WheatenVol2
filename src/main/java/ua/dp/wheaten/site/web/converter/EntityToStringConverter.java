package ua.dp.wheaten.site.web.converter;


import org.springframework.core.convert.converter.Converter;
import ua.dp.wheaten.site.root.entities.Convertable;

/**
 * Created by kkm on 08.02.2016.
 */
public class EntityToStringConverter implements Converter<Convertable, String> {
    @Override
    public String convert(Convertable source) {
        return source.createStringRepresentation();
    }
}
