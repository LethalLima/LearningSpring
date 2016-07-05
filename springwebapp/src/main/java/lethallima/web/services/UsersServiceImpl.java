package lethallima.web.services;

import lethallima.web.dao.UserDAO;
import lethallima.web.dao.entities.User;
import lethallima.web.helpers.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by LethalLima on 7/2/16.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void create(User user) {
        user.setRole(Consts.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.create(user);
    }
}
