package sk.stuba.fei.uim.oop.game;

import java.util.Random;

public class Round {

    final private int number=6;

    public int rand_toss(){
        Random rand= new Random();
        return  rand.nextInt(number)+1;
    }
}
