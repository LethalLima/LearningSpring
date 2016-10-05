package lethallima.web.dao;

import lethallima.web.entities.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LethalLima on 7/10/16.
 */

@Repository
public class UserRoleDAOImpl extends AbstractCommonDAO implements UserRoleDAO {

    @Transactional
    public int createUserRole(UserRole userRole) throws HibernateException {
        return super.save(userRole);
    }
}
