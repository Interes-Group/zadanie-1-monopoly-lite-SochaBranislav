package sk.stuba.fei.uim.oop.game.cards;



import sk.stuba.fei.uim.oop.KeyboardInput;
import sk.stuba.fei.uim.oop.game.Players;
import sk.stuba.fei.uim.oop.game.Round;
import sk.stuba.fei.uim.oop.game.Win;
import sk.stuba.fei.uim.oop.game.inicialization.Initialization_players;

import java.util.ArrayList;

public class Play  {

    Initialization_game initialization_game=new Initialization_game();

    Initialization_players initialization_players=new Initialization_players();

    Chance chance=new Chance();

    Win win = new Win();

     public void getInitialization_game() {

        ArrayList<Players> players = new ArrayList<>();

        Round round = new Round();

        Board[] board = initialization_game.setBuilding();

        players = initialization_players.set_Initialization_players(players);

        initialization_players.get_Initialization_players(players);

        int end = players.size();
        while (end != 1) {
            end = players.size();
            for (Players i : players) {
                if (!i.alive) {
                    i.lose(i, board);
                    end--;
                } else {
                    if (!i.how_long_stay_in_prison(i)) {
                        continue;
                    }

                    int toss = round.rand_toss();
                    System.out.printf(" %s Hodil si cislo %d si na -> ", i.get_name(), toss);
                    i.position = i.position + toss;
                    if (i.position >= 24) {
                        i.player_crosd_start();
                        i.position = i.position - 24;
                    }
                    if (board[i.position] instanceof Building) {
                        board[i.position].is_free(i);
                    }
                    if (board[i.position] instanceof Chance) {
                        chance.take_card(i);
                    }
                    if (board[i.position] instanceof Prison) {
                        System.out.print(" VÄZENIE ->  ");
                        System.out.println(" si len na navsteve ");
                    }
                    if (board[i.position] instanceof Start) {
                        System.out.println(" START ");
                    }
                    if (board[i.position] instanceof Police) {
                        i.position = i.position - 12;
                        i.jail();
                    }
                    if (board[i.position] instanceof Tax) {
                        (board[i.position]).pay_tax(i);
                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("koniec kola pre pokracovanie stlac klavesu ");
            KeyboardInput.readChar();
            System.out.println("dalsie kolo");
            System.out.println();
            System.out.println();
        }
        win.who_wins(players);
    }
}
