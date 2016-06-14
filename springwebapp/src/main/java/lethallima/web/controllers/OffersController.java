package lethallima.web.controllers;

import lethallima.web.dao.Offer;
import lethallima.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by LethalLima on 5/30/16.
 */

@Controller
public class OffersController {
//    @RequestMapping("/")
//    public String showHome(HttpSession session){
//        session.setAttribute("name", "Jeff");
//            return "home";
//    }

//    @RequestMapping("/")
//    public ModelAndView showHome() {
//        ModelAndView modelAndView = new ModelAndView("home");
//        Map<String, Object> model = modelAndView.getModel();
//        model.put("name", "Michelle");
//        return modelAndView;
//    }

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(Model model, @RequestParam("id") String id) {
        System.out.println("id is " + id);
        return "offers/home";
    }

    @RequestMapping("/offers")
    public String indexOffers(Model model) {
        List<Offer> offers = offersService.getOffers();
        model.addAttribute("offers", offers);
        return "offers/index";
    }

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.GET)
    public String showOffer(Model model, @PathVariable int offerId) {
        Offer offer = offersService.getOffer(offerId);
        model.addAttribute("offer", offer);
        return "offers/show";
    }

    @RequestMapping("/offers/create")
    public String createOffer(Model model) {
        if (!model.containsAttribute("offer")) {
            model.addAttribute("offer", new Offer());
        }

        return "offers/create";
    }

    @RequestMapping(value = "/offers/store", method = RequestMethod.POST)
    public String storeOffer(@Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()) {
//            List<ObjectError> objectErrors = bindingResult.getAllErrors();
//            for(ObjectError objectError: objectErrors){
//                System.out.println(objectError.getDefaultMessage());
//            }
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", bindingResult);
            redirectAttributes.addFlashAttribute("offer", offer);
            return "redirect:/offers/create";
        } else {
            offersService.createOffer(offer);
        }

        // redirect to the proper route
        return "redirect:/offers"; // eventually redirect to offers/{offerId}
    }

    @RequestMapping(value = "/offers/{offerId}/edit", method = RequestMethod.GET)
    public String editOffer(Model model, @PathVariable int offerId){
        Offer offer = offersService.getOffer(offerId);
        model.addAttribute("offer", offer);
        return "offers/edit";
    }

    @RequestMapping(value = "/offers/{offerId}", method = RequestMethod.POST)
    public String updateOffer(@PathVariable int offerId, @Valid @ModelAttribute("offer") Offer offer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        System.out.println(offer);
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", bindingResult);
            redirectAttributes.addFlashAttribute("offer", offer);
            return "redirect:/offers/" + offerId + "/edit";
        } else {
            offersService.updateOffer(new Offer(offerId, offer.getFirstName(), offer.getLastName(), offer.getEmail(), offer.getMessage()));
        }
        return "redirect:/offers/" + offerId;
    }
}
