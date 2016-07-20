package annotationExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 20/07/2016.
 */
@Service
public class MailSender {
    private Map<Integer,MailGenerator> map = new HashMap<>();

    @Autowired
    public void initMap(List<MailGenerator> list) {
        for (MailGenerator mailGenerator : list) {
            int mailCode = mailGenerator.mailCode();
            if (map.containsKey(mailCode)) {
                throw new RuntimeException(mailCode + " already in use");
            }
            map.put(mailCode, mailGenerator);
        }
    }

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        MailInfo mailInfo = DBUtils.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
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
