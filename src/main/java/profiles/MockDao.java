package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Repository
@Profile("DEV")
public class MockDao implements Dao {
    @Override
    public void save() {
        System.out.println("mocking...");
    }
}
