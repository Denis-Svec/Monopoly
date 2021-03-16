package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.List;

public class BoardFunctions {
    public List<Object> BoardGsme() {                    //funkcia vygeneruje hracie pole objektov
        List<Object> board = new ArrayList<>();

        board.add("Start");
        board.add("Sanca");

        board.add(new Nehnutelnost("Hilton Hotel",200,50));
        board.add(new Nehnutelnost("McDonald",320,100));
        board.add("Jail");                                                          //4
        board.add(new Nehnutelnost("Goldman Sachs",150,30));
        board.add(new Nehnutelnost("KFC",100,20));
        board.add(new Nehnutelnost("Apple",420,200));
        board.add("Sanca");
        board.add(new Nehnutelnost("Microsoft",380,200));
        board.add(new Nehnutelnost("Mariana Hotel",170,70));
        board.add(new Nehnutelnost("Google",400,200));
        board.add("Police");        //12
        board.add(new Nehnutelnost("Farm",100,20));
        board.add(new Nehnutelnost("Sunny coffe",80,20));
        board.add("Sanca");
        board.add(new Nehnutelnost("Tesla",250,80));
        board.add(new Nehnutelnost("Baron",50,10));
        board.add(new Nehnutelnost("Bory Mall",150,60));
        board.add("Tax");           //19
        board.add(new Nehnutelnost("Golem Gym",70,20));
        board.add(new Nehnutelnost("Starbucks",140,50));
        board.add("Sanca");
        board.add(new Nehnutelnost("Alize",60,15));


        return board;
    }

}
