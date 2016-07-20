package profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Service
public class ForcePointService {
    @Autowired
    private Dao dao;

    @PostConstruct
    public void init(){
        System.out.println("bla bkla");
        dao.save();
    }
}
