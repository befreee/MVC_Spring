package com.ostretsov.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model) {

        //    System.out.println("from requestParam: " + name + " " + surname);
        model.addAttribute("message", " value from model with name MESSAGE " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("goodbye")
    public String sayGoodBye() {
        return "first/goodbye";
    }
}
