package com.study.server.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getMain() {
        return "main/index";
    }
}