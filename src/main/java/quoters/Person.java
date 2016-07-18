package quoters;

import lombok.ToString;

/**
 * Created by Evegeny on 18/07/2016.
 */
@ToString
public class Person {
    private String name;
    private String family;

    public Person(String שם, String משפחה) {
        this.name = שם;
        this.family = משפחה;
    }
}
