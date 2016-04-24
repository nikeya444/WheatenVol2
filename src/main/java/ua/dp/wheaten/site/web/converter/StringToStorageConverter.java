package ua.dp.wheaten.site.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.dp.wheaten.site.root.entities.Storage;
import ua.dp.wheaten.site.root.repositories.StorageRepository;

import javax.inject.Inject;
import javax.jnlp.IntegrationService;

/**
 * Created by kkm on 17.02.2016.
 */
public class StringToStorageConverter implements Converter<String, Storage> {
    @Inject
    private StorageRepository repository;

    public StringToStorageConverter() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public Storage convert(String source) {
        Integer id = Integer.valueOf(source);
        return repository.findOne(id);
    }
}
