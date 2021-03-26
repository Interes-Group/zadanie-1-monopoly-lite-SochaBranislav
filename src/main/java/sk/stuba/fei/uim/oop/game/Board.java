package sk.stuba.fei.uim.oop.game;

abstract class Board {

    protected String name;

    protected int price;

    protected int price_of_rent;

    int which_card_chance=0;

    public  void which_card_chance_increase(){ which_card_chance++; }

    private Players players;

    protected String set_name(String name){ return this.name=name; }

    protected int set_price(int price){return this.price=price; }

    protected int set_price_rent(int price_of_rent){return this.price_of_rent=price_of_rent; }

    public String getName() { return name; }

    public int getPrice() { return price; }

    public int getPrice_of_rent() { return price_of_rent; }

    public void pay_another_player(Players players){

    }
    public void pay_tax(Players players){

    }
    public void pay_for_freedom(Players players){
    }
    public void is_free(Players players){

    }
}
