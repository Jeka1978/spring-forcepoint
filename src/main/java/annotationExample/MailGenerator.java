package annotationExample;

/**
 * Created by Evegeny on 20/07/2016.
 */
public interface MailGenerator {
    String generateHtml(MailInfo mailInfo);
    int mailCode();
}
