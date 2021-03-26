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
    public int end_game(ArrayList<Players> players,int end){
        int number=players.size();
        System.out.println("kolko krat ?");
        for(Players i:players){
            if(i.id==end){
                i.id=100;
            }
            if(i.id==100){
                number--;
            }
            end++;
        }
        System.out.println(number);
        return number;
    }
}
