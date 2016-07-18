package mySpring;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
      /*  ObjectFactory factory = ObjectFactory.getInstance();
        IRobot iRobot = factory.createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getClass());*/
        MyService service = ObjectFactory.getInstance().createObject(MyService.class);
        service.doWork();


    }
}
