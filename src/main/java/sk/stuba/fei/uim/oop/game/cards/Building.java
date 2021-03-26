package sk.stuba.fei.uim.oop.game.cards;

import sk.stuba.fei.uim.oop.game.Players;
import sk.stuba.fei.uim.oop.KeyboardInput;

public class Building extends Board {

    Building[] bulding=new Building[16];

    public Players who_own;

    public boolean free=true;

    public void buy_building(Players players){

        System.out.printf(" chces kupit tuto budovu ( %d ) ? A/N ?  ", getPrice());
        char token=KeyboardInput.readChar();
        if(token=='a' || token=='A' || token=='y' || token=='Y') {
            if (players.get_money() >= this.getPrice()) {

                players.buy_building(this.getPrice());
                System.out.print(" kupil si tuto budovu gratulujem");
                free = false;
                who_own = players;
                players.which_buldings_own = this.bulding;
                System.out.println();
            } else {
                System.out.println(" nemas dostatok penazi je mi to luto");
                System.out.println();
            }
        }

    }

    public void pay_another_player(Players players){

        System.out.printf(" !!! tuto budovu vlastni hrac %s \n",who_own.get_name());

        if(players.get_money()>=this.getPrice_of_rent()){

            players.player_pay(this.getPrice_of_rent());
            who_own.player_earn(this.getPrice_of_rent());
            System.out.printf(" tvoj zostatok je: %d \n",players.get_money());
        }

        else{
            System.out.println(" PREHRAL SI ");
            players.alive=false;
        }
    }
    public void is_free(Players players){
        System.out.printf(" %s ",getName());
        System.out.printf(" mas %d € ", players.get_money());
        if (free) {

            buy_building(players);

        }
        else if (players.equals(who_own)) {

            System.out.println(" TVOJA KARTA ");
            System.out.println();

        }
        else {

            pay_another_player(players);
        }
    }

}
