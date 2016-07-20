package aop;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
}
