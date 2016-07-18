package quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class BeanDefinitionAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition(name);
            if (beanDefinition.getDestroyMethodName() != null && beanDefinition.isPrototype()) {
                throw new RuntimeException("you are an idiot");
            }
        }
    }
}
