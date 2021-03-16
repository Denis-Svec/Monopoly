package sk.stuba.fei.uim.oop;
import java.util.*;


public class Assignment1 {              //Denis Švec

    public static void main(String[] args) throws InterruptedException {

        PlayerIni inicial = new PlayerIni();
        List<Player> list = inicial.ini();

        BoardFunctions game = new BoardFunctions();
        List<Object> gameBoard = game.BoardGsme();

        GameLoop play = new GameLoop();
        play.game(gameBoard,list);

    }
}


