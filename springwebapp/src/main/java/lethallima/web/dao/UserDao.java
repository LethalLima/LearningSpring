package lethallima.web.dao;

import lethallima.web.dao.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by LethalLima on 7/2/16.
 */
@Transactional
@Component("userDao")
public class UserDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }


    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public boolean userExists(String username) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM users where username=:username",
                new MapSqlParameterSource("username", username), Integer.class) > 0;
    }

//    @Transactional
    public void create(User user) {
//        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
//        jdbc.update("INSERT INTO users (username, password, email, enabled) VALUES (:username, :password, :email, :enabled)", params);
//        return jdbc.update("INSERT INTO user_role (username) VALUES (:username)", params) == 1;
        session().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return session().createQuery("FROM User").list();
    }

}
