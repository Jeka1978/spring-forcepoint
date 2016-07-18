package mySpring;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object t) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Class<?> type = field.getType();
                Object object = ObjectFactory.getInstance().createObject(type);
                field.setAccessible(true);
                field.set(t,object);
            }
        }
    }
}
