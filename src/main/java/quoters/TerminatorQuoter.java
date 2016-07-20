package quoters;

import lombok.Setter;
import mySpring.Benchmark;
import mySpring.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Component
@Book(version = 1)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;


    @Value("${terminator}")
    public void setMessages(String[] messages,@Value("${JAVA_HOME}") String javaHome) {
        System.out.println("javaHome = " + javaHome);
        this.messages = Arrays.asList(messages);
    }

    public void killAll() {
        new Thread(() -> {
            System.out.println("You are terminated");
        }).start();

    }

    @Override
    public void sayQuote() {
       messages.forEach(System.out::println);
    }
}
