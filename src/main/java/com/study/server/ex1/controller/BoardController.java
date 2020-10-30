package com.study.server.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;

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
        Integer User = User_result1 + User_result2;
        result.getModel().put("User",User);
        Integer comDice1 = (int)(Math.random()*(6-1)+1);
        Integer comDice2 = (int)(Math.random()*(6-1)+1);


        Integer com_result = getComputer(comDice1,comDice2);
        result.getModel().put("comDice1",comDice1);
        result.getModel().put("comDice2",comDice2);
        result.getModel().put("com_result",com_result);
        String dice_result="";
        if(com_result > User){
            dice_result = "컴퓨터 승!";
        }
        else if(com_result < User){
            dice_result = "유저 승!";
        }else{
            dice_result = "무승부 !";
        }

        result.getModel().put("dice_result",dice_result);
        return result;
    }
    public Integer getComputer(Integer com1,Integer com2){
        return com1+com2;

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
