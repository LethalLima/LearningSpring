package lethallima.web.dao;

import lethallima.web.dao.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by LethalLima on 6/9/16.
 */
@Component("offerDao")
public class OfferDAO {

    //    private JdbcTemplate jdbc;
    private NamedParameterJdbcTemplate jdbc;

//    public OfferDAO(){
//        System.out.println("Successfully loaded offers DAO.");
//    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Offer> getOffers() {

        return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();

                offer.setId(rs.getInt("id"));
                offer.setFirstName(rs.getString("firstName"));
                offer.setLastName(rs.getString("lastName"));
                offer.setMessage(rs.getString("message"));

                return offer;
            }

        });
    }

    @Transactional
    public boolean create(Offer offer){
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return jdbc.update("INSERT INTO offers (firstName, lastName, message) VALUES (:firstName, :lastName, :message)", params) == 1;
    }

    @Transactional
    public int[] create(List<Offer> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbc.batchUpdate("INSERT INTO offers (firstName, lastName, message) VALUES (:firstName, :lastName, :message)", params);

    }

    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return jdbc.update("UPDATE offers SET firstName=:firstName, lastName=:lastName, message=:message WHERE id=:id", params) == 1;
    }

    public boolean delete(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbc.update("delete from offers where id=:id", params) == 1;
    }

    public Offer getOffer(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbc.queryForObject("SELECT * FROM offers WHERE id=:id", params, new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();

                offer.setId(rs.getInt("id"));
                offer.setFirstName(rs.getString("firstName"));
                offer.setLastName(rs.getString("lastName"));
                offer.setMessage(rs.getString("message"));
                return offer;
            }

        });
    }
}
