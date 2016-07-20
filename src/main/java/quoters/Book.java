package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Component
@Autowired
public @interface Book {
    int version();
}
