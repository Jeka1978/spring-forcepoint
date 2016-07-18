package mySpring;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class BenchmarkProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        if (type.isAnnotationPresent(Benchmark.class)) {
            if (type.getAnnotatedInterfaces().length == 0) {
                return Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        return BenchmarkProxyConfigurer.this.invoke(method, args, t);
                    }
                });
            }
            return  Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return BenchmarkProxyConfigurer.this.invoke(method, args, t);
                }
            });
        }
        return t;
    }

    private static Object invoke(Method method, Object[] args, Object t) throws IllegalAccessException, InvocationTargetException {
        System.out.println("***********BENCHMARK***********");
        long start = System.nanoTime();
        Object retVal = method.invoke(t, args);
        long end = System.nanoTime();
        System.out.println(method.getName()+" was working for: "+(end-start));
        System.out.println("***********BENCHMARK***********");
        return retVal;
    }
}
