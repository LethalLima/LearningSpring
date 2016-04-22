package com.lethallima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/lethallima/beans/beans.xml");

        Robot robot = (Robot)context.getBean("robot");

        robot.speak();

        ((FileSystemXmlApplicationContext)context).close();
    }
}
