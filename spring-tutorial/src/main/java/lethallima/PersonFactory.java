package lethallima;

/**
 * Created by jeffrey.lima on 4/18/2016.
 */
public class PersonFactory {
    public Person createPerson(int id, String name){
        System.out.println("Using factory to create person.");
        return new Person(id, name);
    }
}
