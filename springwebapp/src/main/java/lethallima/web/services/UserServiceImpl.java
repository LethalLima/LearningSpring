package lethallima.web.services;

import lethallima.web.dao.UserDAO;
import lethallima.web.dao.UserRoleDao;
import lethallima.web.entities.User;
import lethallima.web.entities.UserRole;
import lethallima.web.helpers.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(Const.USER_ENABLED);
        userDao.create(user);

        UserRole userRole = new UserRole();
        userRole.setUsername(user.getUsername());
        userRole.setRoleId(Const.ROLE_USER_ID);
        userRoleDao.create(userRole);
    }

//    @Transactional
//    public boolean exists(String username) {
//        return userDAO.userExists(username);
//    }

    @Transactional
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
