package ua.dp.wheaten.site.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.dp.wheaten.site.root.entities.Partner;
import ua.dp.wheaten.site.root.repositories.PartnerRepository;

import javax.inject.Inject;
import java.lang.reflect.Parameter;

/**
 * Created by kkm on 17.02.2016.
 */
public class StringToPartnerConverter implements Converter<String, Partner> {
    @Inject
    private PartnerRepository repository;

    public StringToPartnerConverter() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public Partner convert(String source) {
        Integer id = Integer.valueOf(source);
        return repository.findOne(id);
    }
}
