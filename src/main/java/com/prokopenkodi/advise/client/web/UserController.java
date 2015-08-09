package com.prokopenkodi.advise.client.web;

import com.prokopenkodi.advise.client.classes.AdviseWebException;
import com.prokopenkodi.advise.client.pojo.AuthUser;
import com.prokopenkodi.advise.client.pojo.User;
import com.prokopenkodi.advise.client.service.UserService;
import com.prokopenkodi.advise.client.web.validator.UserFormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("userForm") @Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            logger.error("Form has errors, return to registration");
            modelAndView.setViewName("registration");
            return modelAndView;
        } else {
            logger.info("Saving user with email " + user.getEmail());
            try {
                userService.saveUser(user);
            } catch (AdviseWebException e) {
                logger.error("Cannot save user with this params");
                modelAndView.setViewName("registration");
                modelAndView.addObject("error", "User with this email or login already registered");
                return modelAndView;
            }
            return new ModelAndView("redirect:/login");
        }
    }


    @RequestMapping(value = "/profile**", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        AuthUser user = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelAndView.addObject("email", user.getUsername());
        modelAndView.addObject("login", user.getLogin());
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password.");
        }
        if (logout != null) {
            model.addObject("logout", "Log out successful.");
        }
        model.setViewName("login");
        return model;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "registration";
    }


}
