package quoters;

import lombok.Setter;
import mySpring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Book(version = 1)
public class ShakespearQuoter implements Quoter {
    @Value("${shake}")
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






