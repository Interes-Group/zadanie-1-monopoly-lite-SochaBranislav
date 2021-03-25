package sk.stuba.fei.uim.oop.game;

public class Tax extends Board{

    public void pay_tax(Players players){
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
