package annotationExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Service
public class MailSender {
    @Autowired
    private Map<String,MailGenerator> map;

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        MailInfo mailInfo = DBUtils.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = map.get(Integer.toString(mailCode));
        if (mailGenerator == null) {
            throw new RuntimeException(mailCode + " not bound");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html);



    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
