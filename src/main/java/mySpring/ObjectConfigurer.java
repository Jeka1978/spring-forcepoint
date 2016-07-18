package mySpring;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Evegeny on 18/07/2016.
 */
public interface ObjectConfigurer {
    void configure(Object t) throws IllegalAccessException, InstantiationException, InvocationTargetException;
}
