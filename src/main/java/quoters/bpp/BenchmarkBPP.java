package quoters.bpp;

import mySpring.Benchmark;
import mySpring.Transactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;

import java.util.Map;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class BenchmarkBPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Benchmark.class)) {
            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),bean.getClass().getInterfaces(), (o, method, args) -> {
                System.out.println("***********BENCHMARK***********");
                long start = System.nanoTime();
                Object retVal = method.invoke(bean, args);
                long end = System.nanoTime();
                System.out.println(method.getName()+" was working for: "+(end-start));
                System.out.println("***********BENCHMARK***********");
                return retVal;
            });
        }
        return bean;
    }
}
