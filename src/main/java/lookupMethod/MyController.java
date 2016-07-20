package lookupMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 20/07/2016.
 */

public abstract class MyController {
    @Autowired
    private Parser parser;

    public void parseXmls(List<String> xmls) {
        for (String xml : xmls) {
            parser = getNewParser();
            System.out.println(parser);
            parser.open(xml);
            System.out.println(parser);
            parser.close();
            System.out.println(parser);
        }
    }

    protected abstract Parser getNewParser();
}
