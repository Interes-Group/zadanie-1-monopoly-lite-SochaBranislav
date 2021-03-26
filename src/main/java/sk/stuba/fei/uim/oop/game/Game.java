package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.game.cards.Play;

public class Game {
    public void game_start(){
        Play play=new Play();
        play.getInitialization_game();
    }
}
