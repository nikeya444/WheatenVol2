package ua.dp.wheaten.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kkm on 18.01.2016.
 */
public class ApplicationTest {

    @Test
    public void bootstrapApplication() {
        new AnnotationConfigApplicationContext(Bootstrap.class);
    }

}
