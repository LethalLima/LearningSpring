package lethallima.web.controllers;

import lethallima.web.configuration.PropertiesPlaceholder;
import lethallima.web.entities.Role;
import lethallima.web.entities.User;
import lethallima.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by LethalLima on 6/12/16.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private PropertiesPlaceholder prop;

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
            // use front-end to see if ask username exists.
            userService.create(user);
        }

        return "redirect:/dashboard";
    }

    @ResponseBody
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println("User size:" + users.size());

        for(User user: users) {
            System.out.println(user);
            for(Role role: user.getRoles()){
                System.out.println(role);
            }
        }
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) throws Exception {
        System.out.println("Path variable: " + username);
        User user = userService.getUser(username);
        System.out.println("User:\n" + user);
        for(Role role: user.getRoles())
            System.out.println(role);
        return user;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showHome() {
        return "dashboard/dashboard";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        System.out.println(prop.getBranch());
        System.out.println(prop.getTimestamp());
    }
}
