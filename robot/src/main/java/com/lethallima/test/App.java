package com.lethallima.test;

import com.lethallima.test.dao.Offer;
import com.lethallima.test.dao.OffersDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        OffersDAO offersDAO = (OffersDAO)context.getBean("offersDao");

        List<Offer> offers = offersDAO.getOffers();

        for(Offer offer: offers){
            System.out.println(offer);
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
