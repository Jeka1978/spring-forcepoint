package mySpring;

import lombok.*;

/**
 * Created by Evegeny on 18/07/2016.
 */
@Data
@AllArgsConstructor(staticName = "of")
public class Person {

    private int age;

    public static void main(String[] args) {
        Person person = new Person(2);
        person.setAge(3);
        System.out.println();
    }


}
