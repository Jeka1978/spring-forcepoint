package annotationExample;

import org.fluttercode.datafactory.impl.DataFactory;

/**
 * Created by Evegeny on 20/07/2016.
 */
public class DBUtils {
    private static DataFactory dataFactory = new DataFactory();
    public static MailInfo getMailInfo() {

        return new MailInfo(dataFactory.getName(), dataFactory.getNumberBetween(1, 4));
    }
}
