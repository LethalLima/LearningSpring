package lethallima.web.dao;

import lethallima.web.entities.User;
import lethallima.web.helpers.Const;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
@Transactional
@Repository("userDao")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

//    public boolean userExists(String username) {
//        Long result = (Long)session().createCriteria(User.class).setProjection(Projections.count(username)).uniqueResult();
//        return result.intValue() == 0;
//    }

    public void create(User user) {
        try {
            session().save(user);
        } catch (HibernateException e ) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        Criteria criteria = session().createCriteria(User.class).add(Restrictions.eq(Const.USERNAME, username));
        return (User) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Criteria criteria = session().createCriteria(User.class);
        return criteria.list();
    }

    public User getUserById(int id) {
        Criteria criteria = session().createCriteria(User.class)
                .add(Restrictions.eq(Const.USER_ID, id));
        return (User) criteria.uniqueResult();
    }

    public int getUsersCount() {
        Criteria criteria = session().createCriteria(User.class)
                .setProjection(Projections.rowCount());

        return ((Long)(criteria.uniqueResult())).intValue();
    }
}
