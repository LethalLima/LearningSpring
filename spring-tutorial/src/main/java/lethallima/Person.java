package lethallima;

/**
 * Created by jeffrey.lima on 4/15/2016.
 */
public class Person {
    private int id;
    private String name;
    private int taxId;
    private Address address;

    public static Person getInstance(int id, String name){
        System.out.println("Creating Person using factory method.");
        return new Person(id, name);
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void speak(){
        System.out.println("Hello! I am person.");
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void onCreate(){
        System.out.println("Person created: " + this);
    }

    public void onDestroy(){
        System.out.println("Person destroyed");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId=" + taxId +
                ", address=" + address +
                '}';
    }
}
