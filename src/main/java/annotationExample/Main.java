package annotationExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MailConfig.class);
    }
}
