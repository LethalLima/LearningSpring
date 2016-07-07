package lethallima.web.services;

import lethallima.web.dao.entities.User;

import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
public interface UsersService {
    void create(User user);

    List<User> getAllUsers();
}
