package com.astha.spring.DemoSpringApp.game;

import com.astha.spring.DemoSpringApp.GamingConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    @Autowired
    private GamingConsole game;
//constructor based injection
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
