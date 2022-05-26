package com.tomboy.SpringBoot.LearnTour.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${Welcome}")
    private String Message;

    @GetMapping("/")                             //  @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloController()
    {
        return Message ;
    }
}
