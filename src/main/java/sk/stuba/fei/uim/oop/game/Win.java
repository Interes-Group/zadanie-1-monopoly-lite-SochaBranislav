package sk.stuba.fei.uim.oop.game;

import java.util.ArrayList;

public class Win {

    public void who_wins(ArrayList<Players> players){
        for(Players i : players) {
            if (i.alive) {
                System.out.printf("VYHRAL SI %s ", i.get_name());

            }
        }
    }
}
