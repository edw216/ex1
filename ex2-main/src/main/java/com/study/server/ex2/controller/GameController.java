package com.study.server.ex2.controller;

import com.study.server.ex2.domain.Board;
import com.study.server.ex2.domain.Game;
import com.study.server.ex2.repository.BoardRepository;
import com.study.server.ex2.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository repository;

    @GetMapping("")
    public ModelAndView getHomeForModel() {
        List<Game> gameList = repository.findAll();

        ModelAndView result = new ModelAndView("game/index");
        result.addObject(gameList);

        return result;
    }

    @PostMapping("")
    public String process(@RequestParam("input") int inputValue) {


        String user = "";
        String computer = "";
        String result = "";

        int computerValue = (int) ((Math.random() * 3) / 1 + 1);

        // User
        switch (inputValue) {
            case 1:
                user = "가위";
                break;
            case 2:
                user = "바위";
                break;
            case 3:
                user = "보";
                break;
        }
        // Computer
        switch (computerValue) {
            case 1:
                computer = "가위";
                break;
            case 2:
                computer = "바위";
                break;
            case 3:
                computer = "보";
                break;
        }

        // 게임 결과 판단
        if (inputValue == computerValue) {
            result = "비김";
        } else if ((computerValue == 1 && inputValue == 2) ||
                (computerValue == 2 && inputValue == 3) ||
                (computerValue == 3 && inputValue == 1)) {
            result = "승리";
        } else {
            result = "패배";
        }
        Game game = new Game();
        game.setUser(user);
        game.setComputer(computer);
        game.setResult(result);
        Game savedGame = repository.save(game);

        String redirectUrl = "redirect:/game/" + savedGame.getId();

        return redirectUrl;
    }
    @GetMapping("/{id}")
    public ModelAndView getGameItem(@PathVariable("id") Integer gameId) {

        Game game = repository.getOne(gameId);

        ModelAndView result = new ModelAndView("game/result");
        result.getModel().put("gameItem", game);
        return result;
    }
}
