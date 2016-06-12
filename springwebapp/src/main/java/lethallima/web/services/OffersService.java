package lethallima.web.services;

import lethallima.web.dao.Offer;
import lethallima.web.dao.OfferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LethalLima on 6/11/16.
 */

@Service("offersService")
public class OffersService {
    private OfferDAO offerDAO;

    @Autowired
    public void setOfferDAO(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    public List<Offer> getCurrent() {
        return offerDAO.getOffers();
    }
}
