package com.study.server.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    int com_result = (int)(Math.random()*(100-1)+1);
    int count =6;
    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String getMain() {
        return "main/index";
    }


    @GetMapping("/main/echo")
    public ModelAndView getEcho(@RequestParam Integer User_result1){
        ModelAndView result = new ModelAndView("main/echo");
        String remainCount="";
        String outcome ="";
        if(count == 0){
            remainCount="기회를 모두 사용했습니다. 탈락입니다.";
            outcome = "정답은 "+com_result+"입니다.!";
            com_result = (int)(Math.random()*(100-1)+1);
            count = 6;

        }
        else if(com_result!=User_result1) {
            if(com_result>User_result1){
                outcome = "정답은 더 큰 숫자 입니다.";
            }else if(com_result<User_result1){
                outcome = "정답은 더 작은 숫자 입니다.";
            }
            count = count-1;
            remainCount = count + "번의 기회가 남았습니다.";
        }else{
            remainCount = "정답입니다.!";
            outcome = "정답:"+com_result;
            com_result = (int)(Math.random()*(100-1)+1);
            count =6;
        }
        result.getModel().put("remainCount",remainCount);
        result.getModel().put("outcome",outcome);
        return result;
    }
}