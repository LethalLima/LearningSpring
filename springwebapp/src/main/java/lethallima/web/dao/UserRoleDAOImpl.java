package lethallima.web.dao;

import lethallima.web.entities.UserRole;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LethalLima on 7/10/16.
 */
@Transactional(propagation = Propagation.MANDATORY)
@Repository
public class UserRoleDAOImpl extends AbstractCommonDAO implements UserRoleDAO {

    public int createUserRole(UserRole userRole) throws HibernateException {
        return super.save(userRole);
    }
}
