package quoters;

import lombok.Setter;
import mySpring.InjectRandomInt;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class ShakespearQuoter implements Quoter {
    @Setter
    private String message;

    @InjectRandomInt(min = 3,max = 5)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}






