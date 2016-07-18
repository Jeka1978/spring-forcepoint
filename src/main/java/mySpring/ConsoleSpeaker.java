package mySpring;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
