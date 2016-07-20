package lookupMethod;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("lookupMethod");
        List<String> xmls = Arrays.asList("xml1", "xml2", "xml3");
        MyController controller = context.getBean(MyController.class);
        controller.parseXmls(xmls);

    }
}
