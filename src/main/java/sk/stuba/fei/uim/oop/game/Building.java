package sk.stuba.fei.uim.oop.game;

public class Building extends Board {

    Building[] bulding=new Building[16];

    public Players who_own;

    public boolean free=true;

    public void buy_building(Players players){

        if(players.get_money()>=this.getPrice()){

            players.buy_building(this.getPrice());
            System.out.print("kupil si tuto budovu gratulujem");
            free=false;
            who_own=players;
            players.which_buldings_own=this.bulding;
        }

        else{
            System.out.println("nemas dostatok penazi je mi to luto");
        }

    }

    public void pay_another_player(Players players){

        if(players.get_money()>=this.getPrice_of_rent()){

            players.player_pay(this.getPrice_of_rent());
            who_own.player_earn(this.getPrice_of_rent());
            System.out.printf("tvoj zostatok je: %d \n",players.get_money());
        }

        else{
            System.out.println("PREHRAL SI ");
            players.alive=false;
        }
    }

}
