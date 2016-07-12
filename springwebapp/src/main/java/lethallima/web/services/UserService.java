package lethallima.web.services;

import lethallima.web.entities.User;

import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
public interface UserService {
    void create(User user);

    List<User> getAllUsers();

    User getUser(String username);

//    boolean exists(String username);
}
