package com.prokopenkodi.advise.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        return model;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model){
        return "profile";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        return "login";
    }


    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Map<String, Object> model) {
        return "registration";
    }
}
