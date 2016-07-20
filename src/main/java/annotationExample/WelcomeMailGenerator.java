package annotationExample;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {

        return "<html> welcome "+mailInfo.getClientName();

    }

    @Override
    public int mailCode() {
        return 1;
    }
}
