package sk.stuba.fei.uim.oop.game;



import sk.stuba.fei.uim.oop.KeyboardInput;

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


        while (players.size()>1) {

            for (Players i : players) {
                    if (!i.alive) {
                        if(i.id==1){
                            win.who_wins(players);
                        }
                        i.lose(i,board);

                    }
                    else {
                        if( !i.how_long_stay_in_prison(i)){
                            i.position= i.position-12;
                            System.out.println("som vo veyeni");
                            continue;
                        }
                        int toss=round.rand_toss(i);
                        i.position = i.position + toss;
                        if (i.position >= 24) {
                            i.player_crosd_start();
                            i.position = i.position - 24;
                        }
                        if (board[i.position] instanceof Building) {
                            System.out.printf(" %s ", board[i.position].getName());
                            System.out.printf("mas %d € ", i.get_money());
                            if (((Building) board[i.position]).free) {

                                ((Building) board[i.position]).buy_building(i);

                            }
                            else if (i.equals(((Building) board[i.position]).who_own)) {

                                System.out.println(" TVOJA KARTA ");
                                System.out.println();

                            }
                            else {

                                (board[i.position]).pay_another_player(i);
                            }
                        }
                        if (board[i.position] instanceof Chance) {
                            System.out.print(" SANCA --> ");
                            i.position = i.position + chance.take_card(i);
                            if (i.position >= 24) {
                                i.position = i.position - 24;
                            }
                        }
                        if (board[i.position] instanceof Prison) {
                            System.out.print(" VÄZENIE ->  ");
                            System.out.println(" si len na navsteve ");
                        }
                        if (board[i.position] instanceof Start) {
                            System.out.println(" START ");
                        }
                        if (board[i.position] instanceof Police) {
                            System.out.println(" POLICIA (chod do väzenia) ");
                            i.position = i.position - 12;
                        }
                        if (board[i.position] instanceof Tax) {
                            System.out.print("TAX ->");
                            (board[i.position]).pay_tax(i);
                        }
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println("dalsie kolo");
                System.out.println();
                System.out.println();
            }
        win.who_wins(players);
        }
}
