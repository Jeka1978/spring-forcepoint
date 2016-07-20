package annotationExample;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday "+mailInfo.getClientName();
    }
}
