package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.KeyboardInput;

import java.util.ArrayList;

public class  Players {
    public int id=0;

    public int position=0;

    private String name;

    private int money =1000;

    public boolean alive=true;


    private int jail;

    public Building[] which_buldings_own;

    public Players(String name){
        id++;
        this.name=name;
    }

    public Players() {

    }

    public String set_name(){
        name= KeyboardInput.readString();
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
        System.out.print("presiel si startom dostavas 200€ ");
        money=money+200;
        System.out.printf(" tvoj zostatok je %d \n",get_money());
    }
    public void jail(){
        System.out.println(" POLICIA (chod do väzenia) ");
        setJail(3);
    }

    public void setJail(int jail) {
        this.jail = jail;
    }

    public int getJail() {

        return jail;
    }

    public boolean how_long_stay_in_prison(Players players){
        if (players.getJail() > 0) {
            System.out.println(" hrac: " + players.get_name() + " je vo väzeni: " + players.getJail() + " kola");
            players.setJail(players.getJail() - 1);
            return false;
        } else {
            return true;
        }
    }
    public void lose(Players players,Board[] board){
        for(int i=0;i<board.length;i++) {
            if (board[i] instanceof Building) {
                if (players.equals(((Building) board[i]).who_own)) {
                    ((Building) board[i]).free = true;
                    ((Building) board[i]).who_own = null;
                }
            }
        }
    }
}
