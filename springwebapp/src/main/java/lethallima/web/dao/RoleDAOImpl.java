package lethallima.web.dao;

import lethallima.web.entities.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LethalLima on 10/16/16.
 */
@Transactional(propagation = Propagation.MANDATORY)
@Repository
public class RoleDAOImpl extends AbstractCommonDAO implements RoleDAO {

    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        return session().createCriteria(Role.class)
                .list();
    }
}
