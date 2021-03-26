package sk.stuba.fei.uim.oop.game;
import sk.stuba.fei.uim.oop.KeyboardInput;

import java.util.ArrayList;
import java.util.Iterator;


public class Initialization_players extends Players {

    public ArrayList<Players> set_Initialization_players(ArrayList<Players> players) {

        System.out.println("Zacina hra monopoly ");
        System.out.println("Zadaj pocet hracov");
        int number=KeyboardInput.readInt();
        for (int i=0;i<number;i++){
            System.out.println("Zadaj meno: ");
            players.add(new Players(set_name()));
        }
        return players;
    }

    public void get_Initialization_players(ArrayList<Players> players){

        for(Players i :players){
            System.out.printf("hrac %d je %s  ma  %d : ",i.id,i.get_name(),i.get_money());
            System.out.println();
        }
    }

}
