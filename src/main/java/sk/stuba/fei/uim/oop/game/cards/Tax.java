package sk.stuba.fei.uim.oop.game.cards;

import sk.stuba.fei.uim.oop.game.Players;
import sk.stuba.fei.uim.oop.game.cards.Board;

public class Tax extends Board {

    public void pay_tax(Players players){
        System.out.print("TAX ->");
        if(players.get_money()>=this.price){
            System.out.printf("mal si %d ",players.get_money());
            players.buy_building(this.price);
            System.out.printf("tvoj zostatok je %d \n",players.get_money());
        }
        else{
            System.out.println("PREHRAL SI TAX");
            players.alive=false;
        }
    }
}
