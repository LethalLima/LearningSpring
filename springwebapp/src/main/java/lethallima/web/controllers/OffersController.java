package lethallima.web.controllers;

import lethallima.web.dao.Offer;
import lethallima.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/offers/create")
    public String createOffers(Model model) {
        model.addAttribute("offer", new Offer());
        return "offers/create";
    }

    @RequestMapping(value = "/offers/store", method = RequestMethod.POST)
    public String storeOffers(Model model, @Valid Offer offer, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
//            List<ObjectError> objectErrors = bindingResult.getAllErrors();
//            for(ObjectError objectError: objectErrors){
//                System.out.println(objectError.getDefaultMessage());
//            }
//            return "redirect:/offers/create"; // need to figure out how to redirect to same page instead of "/offers/store"
            return "/offers/create";
        } else {
            offersService.createOffer(offer);
        }

        // redirect to the proper route
        return "redirect:/offers";
    }

}
