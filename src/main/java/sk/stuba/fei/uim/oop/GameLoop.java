package sk.stuba.fei.uim.oop;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class GameLoop {
    public void game(List<Object> gameBoard, List<Player> list) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int decision=0;
        boolean loop;
        String input;
        int numberOfPlayers = list.size();
        Sanca random = new Sanca();

        while(numberOfPlayers != 1) {

            for (int i = 0; i < list.size(); i++) {
                if (numberOfPlayers != 1) {
                    if (list.get(i).getWaitTime() > 0) {
                        System.out.println("Toto kolo stoji hrac: " + list.get(i).getPlayerName());
                        list.get(i).subWaitTime(1);
                    } else if (list.get(i).isInGame()) {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("");
                        System.out.println("Ide hrac: " + list.get(i).getPlayerName() + " stojaci na policku: " + (list.get(i).getPosition() + 1));
                        System.out.println("Zostavajuca bilancia: $" + list.get(i).getMoney());
                        System.out.println("Napis nieco na hodenie kocky");
                        scanner.next();
                        TimeUnit.SECONDS.sleep(1);

                        int diceRoll = (int) ((Math.random() * (6 - 1)) + 1);                                                       // hod kockou
                        System.out.println(list.get(i).getPlayerName() + " hodil cislo : " + diceRoll);

                        TimeUnit.SECONDS.sleep(1);
                        if ((list.get(i).getPosition() + diceRoll) > 23) {                                            //pohyb hraca na poli
                            list.get(i).setPosition((list.get(i).getPosition() + diceRoll) - 23);
                            list.get(i).addMoney(100);                                                      //+ 100 za prejdenie startom
                        } else {
                            list.get(i).setPosition(list.get(i).getPosition() + diceRoll);
                        }

                        System.out.println(list.get(i).getPlayerName() + " ide na pole " + (list.get(i).getPosition() + 1));

                        TimeUnit.SECONDS.sleep(2);
                        if (gameBoard.get(list.get(i).getPosition()) instanceof Nehnutelnost) {     //zistuje co sa nachadza na policku

                            System.out.print(list.get(i).getPlayerName() + " stupil si na nehnutelnost: ");
                            System.out.println(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getMenoNeh());

                            if (((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getOwnderID() == 0) {
                                System.out.println("Nenhnutelnost nikomu nepatri, prajete si ju zakupit za: " + ((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPrice()); //nezakupene policko nehnutelnosti
                                System.out.println("1 - Ano");
                                System.out.println("2 - Nie");
                                loop = true;

                                while(loop){

                                    input = scanner.next();
                                    try {
                                        decision = Integer.parseInt(input);
                                        loop = false;
                                        break;
                                    } catch(NumberFormatException ex)
                                    {
                                        System.out.println("Error skuste znovu");
                                    }
                                }

                                if (decision == 1 && list.get(i).getMoney() > ((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPrice()) {       //zakupenie nehnutelnosti
                                    System.out.println("Nehnutelnost zakupena");
                                    ((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).setOwnderID(list.get(i).getID());         //prideli policku id vlastnika
                                    list.get(i).subMoney(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPrice());           // hrac zaplati cenu nehnutelnosti
                                } else if (decision == 2) {
                                    System.out.println("Nehnutelnost zostava na predaj");
                                } else {
                                    System.out.println("Nedostatok penazi");
                                }
                            } else {
                                if(list.get((((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getOwnderID()) - 1).getPlayerName().equals(list.get(i).getPlayerName())){
                                    System.out.println("Stupil si na vlastnu nehnutelnost");
                                }else{
                                    System.out.print(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getMenoNeh());
                                    System.out.println(" patri hracovi: " + list.get((((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getOwnderID()) - 1).getPlayerName());
                                    System.out.print("Zaplatis poplatok $");
                                    System.out.println(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPayMoney());
                                    list.get(i).subMoney(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPayMoney());          //odobere peniaze hracovi
                                    list.get(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getOwnderID() - 1).addMoney(((Nehnutelnost) gameBoard.get(list.get(i).getPosition())).getPayMoney()); // da peniaze vlastnikovy
                                }
                            }


                        } else if (gameBoard.get(list.get(i).getPosition()).equals("Start")) {      //policko start
                            System.out.println("Stupil si na policko Start, obdrzis $200");
                        } else if (gameBoard.get(list.get(i).getPosition()).equals("Sanca")) {              //policko sanca
                            System.out.println("Stupil si na policko Sanca");
                            random.event(i, list);
                        } else if (gameBoard.get(list.get(i).getPosition()).equals("Jail")) {               //policko navsteva vezenia
                            System.out.println("Stupil si na policko Vezenie, ides na navstevu vezenia");

                        } else if (gameBoard.get(list.get(i).getPosition()).equals("Police")) {                 //policko policia
                            System.out.println("Stupil si na policko Policia, nemozes sa hybat na 2 kola");
                            list.get(i).setWaitTime(2);

                        } else if (gameBoard.get(list.get(i).getPosition()).equals("Tax")) {            //policko tax
                            System.out.println("Stupil si na policko Dane, stratis 20% svojich penazi");
                            System.out.println("Stratil si $" + (list.get(i).getMoney() / 100) * 20);
                            list.get(i).subMoney((list.get(i).getMoney() / 100) * 20);
                            System.out.println("\"Fňuk\"");
                        }

                        if (list.get(i).getMoney() <= 0) {                  //ak ma hrac 0 alebo menej penazi tak zbankrotuje a dalej nehra
                            numberOfPlayers--;
                            list.get(i).setInGame(false);
                            System.out.println(list.get(i).getPlayerName() + " prisiel o vsetky peniaze a zbankrotoval.");
                            for (int x = 0; x < gameBoard.size(); x++) {
                                if (gameBoard.get(x) instanceof Nehnutelnost && ((Nehnutelnost) gameBoard.get(x)).getOwnderID() == (i + 1)) {
                                    ((Nehnutelnost) gameBoard.get(x)).setOwnderID(0);                       //vrati do hry nehnutelnosti zbankrotovaneho hraca (daju sa znova kupit)
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < list.size(); i++){                       // vypise vytaza
            if(list.get(i).isInGame()){
                System.out.println(list.get(i).getPlayerName() + " vyhral!");
            }
        }
    }
}
