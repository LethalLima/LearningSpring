package com.lethallima.test.dao;

/**
 * Created by jeffrey.lima on 4/29/2016.
 */
public class Offer {
    private int id;
    private String name;
    private String email;
    private String text;

    public Offer(){}

    public Offer(String name, String email, String text) {
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public Offer(int id, String name, String email, String text) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Offer setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Offer setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Offer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getText() {
        return text;
    }

    public Offer setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
