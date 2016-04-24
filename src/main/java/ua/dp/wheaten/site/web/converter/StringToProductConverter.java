package ua.dp.wheaten.site.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ua.dp.wheaten.site.root.entities.Product;
import ua.dp.wheaten.site.root.repositories.ProductRepository;

import javax.inject.Inject;

/**
 * Created by kkm on 17.02.2016.
 */
public class StringToProductConverter implements Converter<String, Product> {

    @Inject
    private ProductRepository repository;

    public StringToProductConverter() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public Product convert(String source) {
        Integer id = Integer.valueOf(source);
        return repository.findOne(id);
    }
}
