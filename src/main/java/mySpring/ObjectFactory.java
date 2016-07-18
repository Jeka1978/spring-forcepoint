package mySpring;

import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    private Reflections scanner = new Reflections("mySpring");

    private Config config = new JavaConfig();

    private ObjectFactory() {

        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            try {
                objectConfigurers.add(aClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Set<Class<? extends ProxyConfigurer>> subTypesOf = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> aClass : subTypesOf) {
            try {
                proxyConfigurers.add(aClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public <T> T createObject(Class<T> type) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        initMethod(type, t);
        t = configureProxy(type, t);
        return t;
    }

    private <T> T configureProxy(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = (T) proxyConfigurer.wrapWithProxy(t, type);
        }
        return t;
    }

    private <T> void initMethod(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException(" ifc " + type + " have 0 or more impl in your classpath, please bind needed one in your config");
                } else {
                    type = (Class<T>) classes.iterator().next();
                }
            } else {
                type = implClass;
            }
        }
        return type;
    }

    private <T> void configure(T t) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (ObjectConfigurer objectConfigurer : objectConfigurers) {
            objectConfigurer.configure(t);
        }
    }
}









