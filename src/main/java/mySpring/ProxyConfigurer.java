package mySpring;

/**
 * Created by Evegeny on 18/07/2016.
 */
public interface ProxyConfigurer {
    Object wrapWithProxy(Object o, Class type);
}
