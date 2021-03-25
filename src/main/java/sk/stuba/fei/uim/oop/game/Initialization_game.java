package sk.stuba.fei.uim.oop.game;

public class Initialization_game extends Board {

       private int[]  price_of_buldings={0,60,0,80,100,50,
               120,140,0,160,180,200,200,
               200,220,0,240,0 ,
               260,280,300,350,0,500 };

       private  String[] name_buldings = {"START","B1", "CHANCE", "B2", "B3", "POLICKO VAZANIE",
               "B4", "B5", "CHANCE","B6","B7","B8","TAX",
               "B9","B10","CHANCE","B11","POLICIA"
               ,"B12","B13","B14","B15","CHANCE","B16"};
       private int[] buldings_rent={0,20,0,40,60,0,
               80,100,0,120,140,160,0,
               160,180,0,200,0,
               200,210,240,260,0,400 };

    public Board[] setBuilding() {
        Building[] building = new Building[16];
        for(int i=0;i<16;i++){
            building[i]=new Building();
        }
        Chance[] chance=new Chance[4];
        for(int i=0;i<4;i++){
            chance[i]=new Chance();
        }
        Prison prison=new Prison();

        Start start=new Start();

        Tax tax=new Tax();

        Police police=new Police();

        Board[] board= {start, building[0], chance[0], building[1], building[2], prison,
                building[3], building[4], chance[1], building[5],building[6],building[7], tax,
                building[8],building[9],chance[2],building[10],police,
                building[11],building[12],building[13],building[14],chance[3],building[15]};
        for(int i=0;i<24;i++) {
           board[i].set_name(name_buldings[i]);
           board[i].set_price(price_of_buldings[i]);
           board[i].set_price_rent(buldings_rent[i]);
        }
        return board;
    }

}
