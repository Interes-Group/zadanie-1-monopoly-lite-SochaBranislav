package sk.stuba.fei.uim.oop.game;

import java.util.Random;

public class Round {

    final private int number=6;

    Random rand= new Random();
    public int rand_toss(){

        return  rand.nextInt(number)+1;
    }
}
