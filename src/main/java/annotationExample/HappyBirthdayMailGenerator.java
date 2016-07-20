package annotationExample;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "happy birthday "+mailInfo.getClientName();
    }

    @Override
    public int mailCode() {
        return 3;
    }
}
