package com.andersenlab.adamovichjr.web.controller.authentification;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String loginGetMethod() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
            return "login_form";
        }
        return "redirect:/user/";
    }

    @GetMapping(value = "/login_error")
    public ModelAndView loginErrorMethod() {
        final ModelAndView modelAndView = new ModelAndView("login_form");
        modelAndView.addObject("error", true);
        return modelAndView;
    }

}
