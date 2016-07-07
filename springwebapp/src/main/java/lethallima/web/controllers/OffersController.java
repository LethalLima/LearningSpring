package lethallima.web.controllers;

import lethallima.web.dao.entities.Offer;
import lethallima.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LethalLima on 5/30/16.
 */

@Controller
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private OffersService offersService;

    @RequestMapping(method = RequestMethod.GET)
    public String indexOffers(Model model) {
        List<Offer> offers = offersService.getOffers();
        model.addAttribute("offers", offers);
        return "offers/index";
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.GET)
    public String showOffer(Model model, @PathVariable int offerId) {
        Offer offer = offersService.getOffer(offerId);
        model.addAttribute("offer", offer);
        return "offers/show";
    }

    @RequestMapping("/create")
    public String createOffer(Model model) {
        if (!model.containsAttribute("offer")) {
            model.addAttribute("offer", new Offer());
        }

        return "offers/create";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String storeOffer(@Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            // redirect with errors and same page
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", bindingResult);
            redirectAttributes.addFlashAttribute("offer", offer);
            return "redirect:/offers/create";
        } else {
            offersService.createOffer(offer);
        }

        // redirect to the proper route
        return "redirect:/offers"; // eventually redirect to offers/{offerId}
    }

    @RequestMapping(value = "/{offerId}/edit", method = RequestMethod.GET)
    public String editOffer(Model model, @PathVariable int offerId){
        Offer offer = offersService.getOffer(offerId);
        model.addAttribute("offer", offer);
        return "offers/edit";
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.POST)
    public String updateOffer(@PathVariable int offerId, @Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", bindingResult);
            redirectAttributes.addFlashAttribute("offer", offer);
            return "redirect:/offers/" + offerId + "/edit";
        } else {
            offersService.updateOffer(offer);
        }
        return "redirect:/offers/" + offerId;
    }
}
