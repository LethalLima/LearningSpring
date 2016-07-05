package lethallima.web.services;

import lethallima.web.dao.entities.Offer;

import java.util.List;

/**
 * Created by LethalLima on 6/14/16.
 */
public interface OffersService {

    List<Offer> getOffers();

    boolean createOffer(Offer offer);

    Offer getOffer(int offerId);

    boolean updateOffer(Offer offer);

}
