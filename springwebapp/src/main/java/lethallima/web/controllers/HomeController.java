package lethallima.web.controllers;

import lethallima.web.dao.entities.User;
import lethallima.web.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by LethalLima on 6/12/16.
 */
@Controller
public class HomeController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Principal principal) {
        if (principal != null)
            return "redirect:/dashboard";

        return "login/login";
    }

    @RequestMapping(value = "login/create", method = RequestMethod.GET)
    public String createUserLogin(Model model, Principal principal) {
        if (principal != null)
            return "redirect:/dashboard";

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new User());
        }
        return "login/create";
    }

    @RequestMapping(value = "login/create", method = RequestMethod.POST)
    public String storeUserLogin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest http){
        if(bindingResult.hasErrors()) {
            // redirect with errors and same page
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/login/create";
        } else {
            usersService.create(user);
        }

        return "redirect:/dashboard";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public void getAllUsers() {
        for(User user: usersService.getAllUsers())
            System.out.println(user);
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showHome() {
        return "dashboard/dashboard";
    }
}
