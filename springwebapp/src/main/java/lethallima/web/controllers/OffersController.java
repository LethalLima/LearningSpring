package lethallima.web.controllers;

import lethallima.web.dao.Offer;
import lethallima.web.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("/")
    public String showHome(Model model) {
        List<Offer> offers = offersService.getCurrent();
        model.addAttribute("offers", offers);
        return "home";
    }

    @RequestMapping("/test")
    public String showTest(){
        return "test";
    }
}
