package com.lethallima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */

@Component
public class Robot {
    private int id = 0;
    private String speech = "Hello";

    public void speak(){
        System.out.println(id + ": " + speech);
    }

    @Autowired
    public void setId(@Value("1337") int id){
        this.id = id;
    }

    @Autowired
    public void setSpeech(@Value("I'll be back, baby.") String speech){
        this.speech = speech;
    }
}
