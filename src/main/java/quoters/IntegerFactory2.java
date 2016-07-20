package quoters;

import java.util.Random;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class IntegerFactory2 {
    public int getInt(){
        Random random = new Random();
        return random.nextInt(100);
    }
}
