package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {



    @Book(version = 1)
    private List<Quoter> quoters = Arrays.asList(new Quoter() {
        @Override
        public void sayQuote() {
            System.out.println("this is default");
        }
    });

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }

    @PostConstruct
    public void x() {
        System.out.println("XXXXXXXXXXx");
    }
}
