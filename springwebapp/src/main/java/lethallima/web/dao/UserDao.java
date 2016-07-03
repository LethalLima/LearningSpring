package lethallima.web.dao;

import lethallima.web.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by LethalLima on 7/2/16.
 */
@Component("userDao")
public class UserDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional
    public boolean create(User user) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
        jdbc.update("INSERT INTO users (username, password, email, enabled) VALUES (:username, :password, :email, :enabled)", params);
        return jdbc.update("INSERT INTO user_role (username, role) VALUES (:username, :role)", params) == 1;
    }
}
