package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;
import quoters.DeprecatedClass;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class DeprecatedClassesReplacerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                continue;
            }
            Class<?> beanClass = ClassUtils.resolveClassName(beanClassName, ClassLoader.getSystemClassLoader());
            if (beanClass.isAnnotationPresent(DeprecatedClass.class)) {
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                beanDefinition.setBeanClassName(annotation.value().getName());
            }
        }
    }
}




