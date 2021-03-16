package sk.stuba.fei.uim.oop;
import java.util.*;

public class PlayerIni {
    public List<Player> ini(){

        int numberOfPlayers = 2;
        String input;
        String pName;
        List<Player> list = new ArrayList<>();                      //list hracov
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        System.out.println("Kolko ludi bude hrat (min 2)(max 6)?");        //vytvorenie listu hracov

        while(loop && numberOfPlayers <= 6 && numberOfPlayers >= 2){

            input = scanner.next();
            try {
                numberOfPlayers = Integer.parseInt(input);
                loop = false;
                break;
            } catch(NumberFormatException ex)
            {
                System.out.println("Error skuste znovu");
            }
        }


        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Zadaj meno hraca " + (i + 1));
            pName = scanner.next();
            Player newPlayer = new Player((i + 1), pName);
            list.add(newPlayer);
        }

        return list;
    }
}