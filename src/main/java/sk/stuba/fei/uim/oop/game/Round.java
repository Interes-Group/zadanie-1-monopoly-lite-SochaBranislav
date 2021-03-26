package sk.stuba.fei.uim.oop.game;

import java.util.Random;

public class Round {

    final private int number=6;

    Random rand= new Random();
    public int rand_toss(Players players){
        System.out.printf(" %s Hodil si cislo %d si na -> ",players.get_name(),rand.nextInt(number)+1);
        return  rand.nextInt(number)+1;
    }
}
