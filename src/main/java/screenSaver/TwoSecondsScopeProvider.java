package screenSaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class TwoSecondsScopeProvider implements Scope {
    private Map<String, Pair<LocalDateTime,Object>> map = new HashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!map.containsKey(name)|| ChronoUnit.MILLIS.between(map.get(name).getKey(), now())>2000) {
            map.put(name, new Pair<>(now(),objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }







    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
