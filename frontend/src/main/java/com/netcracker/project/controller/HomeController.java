package com.netcracker.project.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class.getSimpleName());

    private static final String ERROR_VIEW_PATH = "error";
    private static final String HOME_VIEW_PATH = "home";

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView goToHomePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView();
        if (authentication != null) {
            modelAndView.setViewName(HOME_VIEW_PATH);
            logger.debug("Show home page for authentificated user: " + ((Principal) authentication.getPrincipal()).getName());
        } else {
            modelAndView.setViewName(ERROR_VIEW_PATH);
            logger.debug("Show error page for non-authentificated user.");
        }
        return modelAndView;
    }

}
