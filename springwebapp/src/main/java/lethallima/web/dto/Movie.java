package lethallima.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by LethalLima on 12/4/16.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {
//    private int id;
    private String title;
    private String year;

    public Movie() {

    }

//    public Movie(String title, String year) {
//        this.title = title;
//        this.year = year;
//    }

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
