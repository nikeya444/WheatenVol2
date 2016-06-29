package ua.dp.wheaten.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ua.dp.wheaten.site.web.converter.*;
import ua.dp.wheaten.site.web.interceptors.DocumentCreateUpdateInterceptor;
import ua.dp.wheaten.site.web.interceptors.DocumentCreationInterceptor;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 04.05.15
 * Time: 22:35
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvc

@ComponentScan(
        basePackages = "ua.dp.wheaten.site.web.controllers"
)
public class WebServletContextConfiguration extends WebMvcConfigurerAdapter {

    @Inject
    SpringValidatorAdapter validator;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateConverter("dd.MM.yyyy"));
        registry.addConverter(new LocalDateToStringConverter("dd.MM.yyyy"));
        registry.addConverter(new EntityToStringConverter());

        registry.addConverter(new StringToProductConverter());
        registry.addConverter(new StringToPartnerConverter());
        registry.addConverter(new StringToStorageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    //    registry.addInterceptor(new DocumentCreationInterceptor()).addPathPatterns("/documents/new");
    //    registry.addInterceptor(new DocumentCreateUpdateInterceptor()).addPathPatterns("/documents/{id:\\d}");

    }

    @Override
    public Validator getValidator() {
        return this.validator;
    }
}
