package lethallima.web.dao.entities;

import lethallima.web.custom.validations.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by LethalLima on 7/1/16.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @NotEmpty(message = "Please enter a username.")
    @Size(max = 40, message = "Username has exceeded maximum character count of 40.")
    @Column(name = "username")
    private String username;

//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    @Column(name = "password")
    private String password;

    @ValidEmail(message = "Please enter a valid email address.")
    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled = true;

    public User(){}

    public User(String username, String password, String email, boolean enabled, int role_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
