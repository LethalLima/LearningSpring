package lethallima.web.dao;

import lethallima.web.custom.validations.ValidEmail;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by LethalLima on 6/9/16.
 */
public class Offer {
    private int id;

    @NotEmpty(message = "Please enter a first name.")
    @Size(max = 40, message = "First name has exceeded maximum character count of 40.")
    private String firstName;

    @NotEmpty(message = "Please enter a last name.")
    @Size(max = 40, message = "Last name has exceeded maximum character count of 40.")
    private String lastName;

//    @Pattern(regexp = "\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,})+", message = "Please enter a valid email address.")
    @ValidEmail(message = "Please enter a valid email address.")
    private String email;

    @Size(min = 20, max = 200, message = "Please enter a message from 20 to 200 characters.")
    private String message;

    public Offer(){}

    public Offer(int id, String firstName, String lastName, String email, String message) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}