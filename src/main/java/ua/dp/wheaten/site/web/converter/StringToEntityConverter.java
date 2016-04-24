package ua.dp.wheaten.site.web.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.entities.PersistableObject;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.entities.Storage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by kkm on 17.02.2016.
 */
public class StringToEntityConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        System.out.println(sourceType.toString());
        System.out.println(targetType.toString());
        return false;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        System.out.println("In getConvertibleTypes");
        return new HashSet<>(
                Arrays.asList(
                        new ConvertiblePair(String.class, Product.class),
                        new ConvertiblePair(String.class, Partner.class),
                        new ConvertiblePair(String.class, Storage.class)
                )
        );
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        System.out.println("CONVERT");
        System.out.println("source " + source.toString());
        System.out.println("sourceType " + sourceType);
        System.out.println("targetType " + targetType);
        return null;
    }
}
