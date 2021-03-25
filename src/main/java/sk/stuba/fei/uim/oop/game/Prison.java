package sk.stuba.fei.uim.oop.game;

public class Prison extends  Board{
    public void pay_for_freedom(Players players){
        if(players.get_money()<this.getPrice()){
            System.out.println("nemas dostatok penazi na oslobodenie");
        }
        else{
            players.player_pay(this.getPrice());
            players.in_prison=false;
        }
    }
}
