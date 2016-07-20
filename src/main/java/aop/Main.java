package aop;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
//        context.getBean(MyService.class).doImportant();
        try {
            context.getBean(DBService.class).save2db();
        } catch (Exception e) {
            System.out.println("PROBLEM");
        }
    }
}
