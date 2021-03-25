package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.KeyboardInput;

import javax.swing.plaf.basic.BasicOptionPaneUI;

public class  Players {
    private String name;

    private int money =1000;

    public boolean alive=true;

    public boolean in_prison=false;

    public int round_in_prison=0;

    public int how_much_stay=3;

    public Building[] which_buldings_own;

    public String set_name(){
        KeyboardInput keyboardInput=new KeyboardInput();
        name= keyboardInput.readString();
        return name;
    }

    public String get_name(){
        return this.name;
    }

    public void  buy_building(int how_much){
        money=money-how_much;
    }

    public int get_money(){
        return money;
    }

    public void player_pay(int how_much){
        money=money-how_much;
    }

    public void player_earn(int how_much){
        money=money+how_much;
    }

    public void player_crosd_start(){
        money=money+200;
    }

    public void three_round_in_prison(){
        round_in_prison=round_in_prison%3;
        if(round_in_prison==2){
            this.in_prison=false;
            round_in_prison=-1;
            how_much_stay=4;
        }
        else {
            how_much_stay--;
            round_in_prison++;
        }
    }

}
