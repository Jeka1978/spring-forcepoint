package quoters.bpp;

import mySpring.Transactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class TransactionalBPP implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Transactional.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass!=null) {
            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),bean.getClass().getInterfaces(), (o, method, args) -> {
                System.out.println("*********TRNA OPENME");
                Object retval = method.invoke(bean, args);
                System.out.println("*********TRNA CLOSED");
                return retval;
            });
        }
        return bean;
    }
}
