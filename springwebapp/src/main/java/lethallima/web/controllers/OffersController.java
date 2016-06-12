package lethallima.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("name", "Mario");
        return "home";
    }

    @RequestMapping("/test")
    public String showTest(){
        return "test";
    }
}
