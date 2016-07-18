package quoters;

import lombok.Setter;
import mySpring.Benchmark;
import mySpring.Transactional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Benchmark
@Transactional
@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

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
