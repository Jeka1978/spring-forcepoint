package profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Configuration
@PropertySource("classpath:prod.properties")
@Profile("PROD")
public class ProdConfig {
}
