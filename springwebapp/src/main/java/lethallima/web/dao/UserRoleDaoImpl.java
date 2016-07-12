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
@Transactional
@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void create(UserRole userRole) {
        try {
            session().save(userRole);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
