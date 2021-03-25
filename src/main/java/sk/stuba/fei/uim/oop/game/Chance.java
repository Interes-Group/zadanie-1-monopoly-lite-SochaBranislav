package sk.stuba.fei.uim.oop.game;



public class Chance extends Board  {

    int how_long=0;

    public int go_back(int how_long) {
        System.out.printf("Za to ze si podvadzal chod dopredu o %d \n",how_long);
        return how_long;
    }


    public void pay_card(Players players,int how_much) {
        players.player_pay(how_much);
        System.out.printf("Za prenajom platis %d tvoj zostatok je %d \n",how_much,players.get_money());


    }


    public void earn_card(Players players,int how_much) {
        players.player_earn(how_much);
        System.out.printf("Za prenajom dostanes %d tvoj zostatok je %d \n",how_much,players.get_money());

    }


    public int go_foward(int how_long) {
        System.out.printf("Za to ze si nepodvadzal chod do zadu o %d \n",how_long);
        return how_long;
    }



    public int take_card(Players players){
        switch(which_card_chance){
            case 0 :
                pay_card(players,100);
                break;
            case 1 :
                earn_card(players,125);
                break;
            case 2:
                how_long=go_back(2);
                break;
            case 3:
                how_long=go_foward(3);
                break;
            case 4:
                earn_card(players,175);
                break;
            case 5:
                pay_card(players,200);
                break;
            case 6:
                how_long=go_foward(2);
                break;
            case 7:
                how_long=go_back(3);
                break;
            default:
                which_card_chance=0;
        }
        which_card_chance_increase();
        return how_long;
    }
}
