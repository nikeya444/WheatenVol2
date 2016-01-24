package ua.dp.wheaten.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

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

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


}
