package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext("quoters");
    }
}
