package com.prokopenkodi.advise.client.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public String start(){
        return "welcome";
    }

    @RequestMapping(value = { "/about" }, method = RequestMethod.GET)
    public String about(){
        return "about";
    }


}
