package com.lethallima.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */

@Component
public class Robot {
    private String id = "Default robot";
    private String speech = "Hello";

    public void speak(){
        System.out.println(id + ": " + speech);
    }

    @Autowired
    public void setId(@Value("${jdbc.user}")String id){
        this.id = id;
    }

    @Autowired
    // try new java.util.Date().toString()
    public void setSpeech(@Value("${jdbc.password}")String speech){
        this.speech = speech;
    }
}
