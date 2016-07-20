package lookupMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Configuration
public class Conf {

    @Bean
    @Scope("prototype")
    public XmlParser xmlParser(){
        return new XmlParser();
    }

    @Bean
    public MyController controller(){
      return   new MyController() {
            @Override
            protected Parser getNewParser() {
                return xmlParser();
            }
        };
    }
}
