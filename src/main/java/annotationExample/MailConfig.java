package annotationExample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "annotationExample")
public class MailConfig {
}
