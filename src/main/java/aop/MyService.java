package aop;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Service
public class MyService {
    @Secured
    @PostConstruct
    public void doImportant() {
        System.out.println("working...");
    }
}
