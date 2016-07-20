package annotationExample;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "don't call us we call you";
    }
}
