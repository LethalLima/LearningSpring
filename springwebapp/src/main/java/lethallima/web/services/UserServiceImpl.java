package lethallima.web.services;

import lethallima.web.dao.RoleDAO;
import lethallima.web.dao.UserDAO;
import lethallima.web.dao.UserRoleDAO;
import lethallima.web.entities.Role;
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
@Service
public class UserServiceImpl implements UserService {
    // TODO: Log all exceptions thrown from DAO layer
    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private RoleDAO roleDAO;

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
        userRoleDAO.createUserRole(userRole);
    }

    @Transactional(readOnly = true)
    public User getUserByName(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    public int getUsersCount() {
        return userDao.getUsersCount();
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
