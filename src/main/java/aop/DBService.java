package aop;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
public class DBService {
    public void save2db() {
        throw new DBException("fire all dba");
    }
}
