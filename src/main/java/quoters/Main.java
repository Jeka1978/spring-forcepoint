package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean(Integer.class));
        context.close();
    }
}
