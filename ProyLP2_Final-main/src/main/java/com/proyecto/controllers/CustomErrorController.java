package com.proyecto.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error_page");
        int statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode == 404) {
            modelAndView.setViewName("error/404");
        } else {
            modelAndView.setViewName("error_page");
        }

        return modelAndView;
    }
}
