package quoters;

import annotationExample.MailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Configuration
//@Import(MailConfig.class)
@EnableAspectJAutoProxy
@PropertySource("classpath:quotes.properties")
public class Config {
    @PostConstruct
    public void init(){
        System.out.println("Config is started");
    }

   /* @Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/


}
