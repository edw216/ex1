package com.study.server.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/board")
public class BoardController {
    @GetMapping("/board")
    public String getBoard() {
        return "board/index";
    }

    @GetMapping("/board/echo")
    public ModelAndView getEcho(@RequestParam Integer User_result1,
                          @RequestParam Integer User_result2) {
        ModelAndView result = new ModelAndView("board/echo");
        result.getModel().put("User_result1", User_result1);
        result.getModel().put("User_result2", User_result2);

        return result;
    }

    /*@PostMapping("/board/echo")
    public ModelAndView postEcho(@RequestParam String title,
                                @RequestParam String content) {
        ModelAndView result = new ModelAndView("board/echo");
        result.getModel().put("title", title);
        result.getModel().put("content", content);

        return result;
    }*/

    /*@GetMapping("")
    public String getBoard() {
        return "board/index";
    }

    @GetMapping("/echo")
    public String getEcho() {
        return "board/echo";
    }*/
}
