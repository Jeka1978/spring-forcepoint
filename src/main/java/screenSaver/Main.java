package screenSaver;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
        while (true) {
            context.getBean(ColorFrame.class).changeCoordinates();
            Thread.sleep(50);
        }
    }
}
