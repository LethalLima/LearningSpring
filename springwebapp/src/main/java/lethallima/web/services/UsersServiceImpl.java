package lethallima.web.services;

import lethallima.web.dao.UserDAO;
import lethallima.web.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LethalLima on 7/2/16.
 */
@Service("userService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserDAO userDAO;

    public void create(User user) {
        userDAO.create(user);
    }
}
