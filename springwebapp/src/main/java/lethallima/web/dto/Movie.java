package lethallima.web.dto;

import java.io.Serializable;

/**
 * Created by LethalLima on 12/4/16.
 */
public class Movie implements Serializable {
    private String title;
    private String year;

    public Movie() {

    }

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
