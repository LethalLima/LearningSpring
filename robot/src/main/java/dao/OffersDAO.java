package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jeffrey.lima on 4/29/2016.
 */

@Component()
public class OffersDAO {

    private JdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new JdbcTemplate(jdbc);
    }

    public List<Offer> getOffers() {
        return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>(){
            public Offer mapRow(ResultSet resultSet, int rowNum) throws SQLException{
                Offer offer = new Offer();

                offer.setId(resultSet.getInt("id"));
                offer.setName(resultSet.getString("name"));
                offer.setText(resultSet.getString("text"));
                offer.setEmail(resultSet.getString("email"));

                return offer;
            }
        });
    }
}
