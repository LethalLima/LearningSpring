package lethallima.web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by LethalLima on 10/4/16.
 */
@Repository
public abstract class AbstractCommonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    protected final Session session() {
        return sessionFactory.getCurrentSession();
    }

    protected final int save(Object object) throws HibernateException {
        return (Integer)session().save(object);
    }

    protected final void saveOrUpdate(Object object) throws HibernateException {
        session().saveOrUpdate(object);
    }

    protected final void update(Object object) throws HibernateException {
        session().update(object);
    }

    protected final void delete(Object object) throws HibernateException {
        session().delete(object);
    }

}
