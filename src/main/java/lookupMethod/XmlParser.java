package lookupMethod;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
/*@Component
@Scope(value = "prototype")*/
public class XmlParser implements Parser {
    private boolean used;
    @Override
    public void open(String xml) {
        if (used) {
            throw new IllegalStateException("parser was in use");
        }
        System.out.println(xml);
    }

    @Override
    public void close() {
        used=true;
    }
}
