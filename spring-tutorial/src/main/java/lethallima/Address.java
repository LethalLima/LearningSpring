package lethallima;

/**
 * Created by jeffrey.lima on 4/18/2016.
 */
public class Address {
    private String street;
    private String postcode;

    public Address(){

    }

    public Address(String street, String postcode) {
        this.street = street;
        this.postcode = postcode;
    }

    public void init(){
        System.out.println("Beam created: " + this);
    }

    public void destroy(){
        System.out.println("Beam destroyed: " + this);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
