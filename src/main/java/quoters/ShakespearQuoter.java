package quoters;

import lombok.Setter;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class ShakespearQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
