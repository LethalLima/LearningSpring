package lethallima.web.services;

import lethallima.web.entities.Role;
import lethallima.web.entities.User;

import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
public interface UserService {
    void create(User user);

    List<User> getAllUsers();

    User getUserByName(String username);

    User getUserById(int id);

    int getUsersCount();

    List<Role> getAllRoles();
}
