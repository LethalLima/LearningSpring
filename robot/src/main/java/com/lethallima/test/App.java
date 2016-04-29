package com.lethallima.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Robot robot = (Robot)context.getBean("robot");

        robot.speak();

        ((ClassPathXmlApplicationContext)context).close();
    }
}
