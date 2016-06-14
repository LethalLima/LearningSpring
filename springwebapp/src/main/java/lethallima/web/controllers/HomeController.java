package lethallima.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LethalLima on 6/12/16.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHome() {
        return "offers/home";
    }
}
