package com.lethallima.test;

import com.lethallima.test.dao.Offer;
import com.lethallima.test.dao.OffersDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeffrey.lima on 4/22/2016.
 */
public class App {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        OffersDAO offersDAO = (OffersDAO)context.getBean("offersDao");

        try {

//            Offer offer1 = new Offer("Art", "art@gmail.com", "front-end dev");
//            Offer offer2 = new Offer("Anderson", "anderson@gmail.com", "QA");
//
//            if(offersDAO.create(offer1))
//                System.out.println("Successfully inserted offer.");
//
//            if(offersDAO.create(offer2))
//                System.out.println("Successfully inserted offer.");


            // delete record
            //offersDAO.delete(8);

            // update record
//            Offer offer = offersDAO.getOffer(2);
//            offer.setName("Misha").setText("Personal Trainer AND Interior Designer");
//            offersDAO.update(offer);
//            System.out.println(offer);

            List<Offer> offersToStore = new ArrayList<Offer>();
            offersToStore.add(new Offer("Alex", "alex@gmail.com", "QA soon to dev"));
            offersToStore.add(new Offer("Ben", "ben@gmail.com", "AngularJS dev"));
            offersToStore.add(new Offer("Brady", "brady@gmail.com", "Back-end Java developer"));

            // store list off new offers
            offersDAO.create(offersToStore);

            List<Offer> offers = offersDAO.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }

        } catch (DataAccessException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }



        ((ClassPathXmlApplicationContext)context).close();
    }
}
