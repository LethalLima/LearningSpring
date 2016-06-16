package lethallima.web.services;

import lethallima.web.dao.Offer;

import java.util.List;

/**
 * Created by LethalLima on 6/14/16.
 */
public interface OffersService {
//    @Autowired
//    void setOfferDAO(OfferDAO offerDAO);

    List<Offer> getOffers();

    boolean createOffer(Offer offer);

    Offer getOffer(int offerId);

    boolean updateOffer(Offer offer);

}
