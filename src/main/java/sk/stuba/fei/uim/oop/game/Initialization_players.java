package sk.stuba.fei.uim.oop.game;
import sk.stuba.fei.uim.oop.KeyboardInput;


public class Initialization_players extends Players {
    public int i_leight;

    public int how_many_players(){
        KeyboardInput keyboardInput=new KeyboardInput();
        return i_leight= keyboardInput.readInt();

    }

    public Players[] set_Initialization_players(Players[] players) {
        for (int i=0;i<i_leight;i++){
            System.out.println("Zadaj meno: ");
            players[i]=new Players();
            players[i].set_name();
        }
        return players;
    }

    public void get_Initialization_players(Players[] players){
        for (int i=0;i<i_leight;i++){
            System.out.printf("hrac %d  %s  ma  %d€  : ",i+1,players[i].get_name(),players[i].get_money());
            System.out.println();
        }
    }

}
