package mySpring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Evegeny on 18/07/2016.
 */
public class MyServiceImpl implements MyService {
    @Autowired
    private MyService proxy;

    @Override
    public void doWork() {
        System.out.println("working...");
        proxy.drinkBeer();

    }

    @Override
    @Transactional
    public void drinkBeer() {
        System.out.println("drinking beer");
    }
}
