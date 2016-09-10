package lethallima.web.dao;

import lethallima.web.entities.User;

import java.util.List;

/**
 * Created by LethalLima on 7/10/16.
 */
public interface UserDAO {
//    boolean userExists(String username);

    void create(User user);

    User getUser(String username);

    @SuppressWarnings("unchecked")
    List<User> getAllUsers();

    User getUserById(int id);

    int getUsersCount();
}
