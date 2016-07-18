package quoters;

import lombok.Setter;

import java.util.List;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
       messages.forEach(System.out::println);
    }
}
