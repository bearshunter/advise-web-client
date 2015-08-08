package com.prokopenkodi.advise.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {




//    private final UserService userService;
//
//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }



//    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
//    public ModelAndView hello(@PathVariable("name") String name) {
//        logger.debug("hello() is executed - $name {}", name);
//
//        ModelAndView model = new ModelAndView();
//        model.setViewName("index");
//
//        model.addObject("title", userService.getTitle(name));
//        model.addObject("msg", userService.getDesc());
//
//        return model;
//
//    }

}