package lethallima.web.services;

import lethallima.web.dao.OfferDAO;
import lethallima.web.dao.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LethalLima on 6/11/16.
 */

@Service("offersService")
public class OffersServiceImpl implements OffersService {
    @Autowired
    private OfferDAO offerDAO;

    public List<Offer> getOffers() {
        return offerDAO.getOffers();
    }

    public boolean createOffer(Offer offer) {
        return offerDAO.create(offer);
    }

    public Offer getOffer(int offerId) {
        return offerDAO.getOffer(offerId);
    }

    public boolean updateOffer(Offer offer) {
        return offerDAO.update(offer);
    }

}
