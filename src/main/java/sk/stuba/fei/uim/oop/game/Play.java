package sk.stuba.fei.uim.oop.game;



import sk.stuba.fei.uim.oop.KeyboardInput;

public class Play  {

    Initialization_game initialization_game=new Initialization_game();

    Initialization_players initialization_players=new Initialization_players();

    KeyboardInput keyboardInput=new KeyboardInput();
    Chance chance=new Chance();


    public void getInitialization_game() {
        System.out.println("Zacina hra monopoly ");
        System.out.println("Zadaj pocet hracov");
        int  end=initialization_players.how_many_players();
        Players[] players=new Players[end];
        Round round=new Round();
        Board[] board=initialization_game.setBuilding();
        players=initialization_players.set_Initialization_players(players);
        initialization_players.get_Initialization_players(players);
        int[] previous_toss=new int[end];
        char ano_nie;
        int end_of_end=end;
        while(end_of_end != 1){

            for(int i=0;i<end;i++){
                if(!players[i].alive){
                    previous_toss[i]=0;
                        for (int k = 0; k < 24; k++) {
                            if(board[previous_toss[i]] instanceof Building) {
                                if (players[i].equals(((Building) board[previous_toss[i]]).who_own)) {
                                     ((Building) board[previous_toss[i]]).free = true;
                                     ((Building) board[previous_toss[i]]).who_own = null;
                                }
                            }
                            previous_toss[i]++;
                        }
                        end_of_end--;
                        if(end_of_end==1){
                            Win win=new Win();
                            win.who_wins(players,end);
                            break;
                        }
                }
                else{
                    if(players[i].in_prison){
                        int j=i;
                        while(j!=end){
                            if(players[j].in_prison){
                                System.out.printf("%s si vo väzeni zaplat 50€ alebo stoj este %d kola... zaplatit ? A/N ?",players[i].get_name(),players[j].how_much_stay);
                                ano_nie=keyboardInput.readChar();

                                if(ano_nie=='A'){
                                    ((board[previous_toss[j]])).pay_for_freedom(players[j]);
                                    if(!players[j].in_prison){
                                        System.out.println("Si vonku z väzenia");
                                        break;
                                    }
                                }
                                else{
                                    players[j].three_round_in_prison();
                                    j++;
                                }
                            }
                            else{
                                System.out.println("Si vonku z väzenia");
                                break;
                            }
                        }
                        if(j==end){
                            break;
                        }
                        i=j;
                    }
                    int toss= round.rand_toss();
                    previous_toss[i]=previous_toss[i]+toss;
                    System.out.printf("hrac %s Hodil si cislo %d si na -> ",players[i].get_name(),toss);

                    if (previous_toss[i]>=24) {
                        System.out.print("presiel si startom dostavas 200€ ");
                        players[i].player_crosd_start();
                        System.out.printf(" tvoj zostatok je %d \n",players[i].get_money());
                        previous_toss[i] = previous_toss[i] - 24;
                    }



                    if (board[previous_toss[i]] instanceof Building) {
                        // SPRAV KUPU ALEBO PLAT
                        System.out.printf(" %s ",board[previous_toss[i]].getName());
                        System.out.printf("mas %d € ",players[i].get_money());
                        if(((Building) board[previous_toss[i]]).free){

                            System.out.printf("chces kupit tuto budovu ( %d ) ? A/N ?  ",board[previous_toss[i]].getPrice());
                            ano_nie=keyboardInput.readChar();

                            if(ano_nie =='A'){
                                ((Building) board[previous_toss[i]]).buy_building(players[i]);
                            }
                            if(ano_nie =='a'){
                                ((Building) board[previous_toss[i]]).buy_building(players[i]);
                            }
                            System.out.println();
                        }

                        else if( players[i].equals(((Building) board[previous_toss[i]]).who_own)){
                            System.out.println(" TVOJA KARTA ");
                            System.out.println();
                        }

                        else{
                            System.out.printf(" !!! tuto budovu vlastni hrac %s \n",((Building) board[previous_toss[i]]).who_own.get_name());
                            (board[previous_toss[i]]).pay_another_player(players[i]);

                        }

                    }
                    if (board[previous_toss[i]] instanceof Chance) {
                        System.out.print(" SANCA --> ");
                        previous_toss[i]=previous_toss[i]+chance.take_card(players[i]);

                    }
                    if (board[previous_toss[i]] instanceof Prison) {
                        System.out.print(" VÄZENIE ->  ");
                        System.out.println(" si len na navsteve ");
                    }
                    if (board[previous_toss[i]] instanceof Start) {
                        System.out.println(" START ");
                    }
                    if(board[previous_toss[i]] instanceof Police){
                        System.out.println(" POLICIA (chod do väzenia) ");
                        players[i].in_prison=true;
                        previous_toss[i]=previous_toss[i]-12;
                    }
                    if(board[previous_toss[i]]instanceof Tax){
                        System.out.print("TAX ->");
                        (board[previous_toss[i]]).pay_tax(players[i]);

                    }
                }
            }
            System.out.println();
            System.out.println();
            System.out.println("dalsie kolo");
            System.out.println();
            System.out.println();
        }
    }
}
