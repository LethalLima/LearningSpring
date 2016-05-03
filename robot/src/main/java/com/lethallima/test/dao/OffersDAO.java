package com.lethallima.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by jeffrey.lima on 4/29/2016.
 */

@Component("offersDao")
public class OffersDAO {

//    private JdbcTemplate jdbc;
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Offer> getOffers() {

        return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

            public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Offer offer = new Offer();

                offer.setId(rs.getInt("id"));
                offer.setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));

                return offer;
            }

        });
    }

    @Transactional
    public boolean create(Offer offer){
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return jdbc.update("INSERT INTO offers (name, email, text) VALUES (:name, :email, :text)", params) == 1;
    }

    @Transactional
    public int[] create(List<Offer> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbc.batchUpdate("INSERT INTO offers (name, email, text) VALUES (:name, :email, :text)", params);

    }

    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
        return jdbc.update("UPDATE offers SET name=:name, email=:email, text=:text WHERE id=:id", params) == 1;
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

                offer.setId(rs.getInt("id")).setName(rs.getString("name"));
                offer.setText(rs.getString("text"));
                offer.setEmail(rs.getString("email"));

                return offer;
            }

        });
    }
}
