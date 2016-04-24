package ua.dp.wheaten.config;

import org.apache.velocity.app.Velocity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by kkm on 23.02.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.dp.wheaten.site.web.rest")
public class RestConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public VelocityConfigurer velocityConfig() {
        VelocityConfigurer configurer = new VelocityConfigurer();
        configurer.setResourceLoaderPath("/WEB-INF/velocity");
        Properties props = new Properties();
        props.setProperty("input.encoding", "utf-8");
    //    props.setProperty("output.encoding", "utf-8");
        configurer.setVelocityProperties(props);
        return configurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        VelocityViewResolver viewResolver = new VelocityViewResolver();

        viewResolver.setViewClass(VelocityView.class);
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".html");
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setContentType("text/html;charset=UTF-8");

        registry.viewResolver(viewResolver);
    }

}
