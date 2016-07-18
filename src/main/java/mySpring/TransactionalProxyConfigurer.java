package mySpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class TransactionalProxyConfigurer implements ProxyConfigurer {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Transactional.class)) {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
                        if (classMethod.isAnnotationPresent(Transactional.class)) {
                            System.out.println("Transaction opened.......................");
                            Object retVal = method.invoke(t, args);
                            System.out.println("Transaction commited.......................");
                            return retVal;
                        }else {
                            return method.invoke(t, args);
                        }
                    }
                });
            }
        }
        return t;
    }
}
