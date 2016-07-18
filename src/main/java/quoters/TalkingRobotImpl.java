package quoters;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    private List<Quoter> quoters;
    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
