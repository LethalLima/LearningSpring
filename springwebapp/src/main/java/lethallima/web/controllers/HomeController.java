package lethallima.web.controllers;

import lethallima.web.entities.User;
import lethallima.web.helpers.Const;
import lethallima.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Principal principal) {
        if (principal != null)
            return "redirect:/dashboard";
        return "login/login";
    }

    @RequestMapping(value = "/login/create", method = RequestMethod.GET)
    public String createUserLogin(Model model, Principal principal) {
        if (principal != null)
            return "redirect:/dashboard";

        if (!model.containsAttribute(Const.USER)) {
            model.addAttribute(Const.USER, new User());
        }
        return "login/create";
    }

    @RequestMapping(value = "/login/create", method = RequestMethod.POST)
    public String storeUserLogin(@Valid @ModelAttribute("user") User user,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 HttpServletRequest http){

        if(bindingResult.hasErrors()) {
            // redirect with errors and same page
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
            redirectAttributes.addFlashAttribute(Const.USER, user);
            return "redirect:/login/create";
        } else {
            userService.create(user);
        }

        return "redirect:/dashboard";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/users/{" + Const.ID + "}", method = RequestMethod.GET)
    public User getUser(@PathVariable(Const.ID) Object id) {
        User user;
        try {
            int userId = Integer.parseInt(id.toString());
            user = userService.getUserById(userId);
        } catch (NumberFormatException e) {
            user = userService.getUserByName(id.toString());
        }

        if(user == null) {
            throw new IllegalArgumentException(id.toString());
        }

        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/users/roles", method = RequestMethod.GET)
    public List<String> getAllRoles() {
        return userService.getAllRoles();
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showHome() {
        return "dashboard/dashboard";
    }
}
