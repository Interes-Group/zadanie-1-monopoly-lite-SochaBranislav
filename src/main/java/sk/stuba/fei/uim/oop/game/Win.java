package sk.stuba.fei.uim.oop.game;

public class Win extends Players{

    public void who_wins(Players[] players,int end){
        for(int i=0;i<end;i++){
            if(players[i].alive){
                System.out.printf("VYHRAL SI %s ",players[i].get_name());
            }
        }
    }
}
