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
@Repository
public class UserDAOImpl extends AbstractCommonDAO implements UserDAO {

    @Transactional
    public int create(User user) throws HibernateException {
        return super.save(user);
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {
        Criteria criteria = session().createCriteria(User.class)
                .add(Restrictions.eq(Const.USERNAME, username));
        return (User) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        Criteria criteria = session().createCriteria(User.class);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return (User) session().get(User.class, id);
    }

    @Transactional(readOnly = true)
    public int getUsersCount() {
        Criteria criteria = session().createCriteria(User.class)
                .setProjection(Projections.rowCount());

        return ((Long)(criteria.uniqueResult())).intValue();
    }
}