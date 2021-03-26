package sk.stuba.fei.uim.oop.game;



public class Chance extends Board  {

    public void pay_card(Players players,int how_much) {
        players.player_pay(how_much);
        System.out.printf("Za prenajom platis %d tvoj zostatok je %d \n",how_much,players.get_money());


    }

    public void earn_card(Players players,int how_much) {
        players.player_earn(how_much);
        System.out.printf("Za prenajom dostanes %d tvoj zostatok je %d \n",how_much,players.get_money());

    }

    public void take_card(Players players){
        System.out.print(" SANCA --> ");
        switch(which_card_chance){
            case 0 :
                pay_card(players,100);
                break;
            case 1 :
                earn_card(players,125);
                break;
            case 2:
                earn_card(players,175);
                break;
            case 3:
                pay_card(players,200);
                break;
            case 4:
                earn_card(players,150);
                break;
            case 5:
                pay_card(players,150);
                break;
            default:
                which_card_chance=0;
        }
        which_card_chance_increase();
        no_money(players);
    }
    public void no_money(Players players){
        if(players.get_money()<0){
            players.alive=false;
            System.out.println("PREHRAL SI !!!");
        }
    }
}
