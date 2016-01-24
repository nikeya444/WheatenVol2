package ua.dp.wheaten.site.root.helpers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 15.09.15
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class AutowireHelper implements ApplicationContextAware {

    private static final AutowireHelper INSTANCE = new AutowireHelper();
    private static ApplicationContext applicationContext;

    public static void autowire(Object classToAutowire, Object ... beansToAutowireInClass) {
        for (Object bean : beansToAutowireInClass) {
            if (bean == null) {
                applicationContext.getAutowireCapableBeanFactory().autowireBean(classToAutowire);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AutowireHelper.applicationContext = applicationContext;
    }

    public static AutowireHelper getInstance() {
        return INSTANCE;
    }
}
