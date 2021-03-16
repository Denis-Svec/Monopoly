package sk.stuba.fei.uim.oop;

import java.util.List;

public class FunctionsOfSwitch {
    public void sub(int i, List<Player> list){
        System.out.println("Poplatok 30% za vyhibanie dani ");
        System.out.println("Stratil si $" + (list.get(i).getMoney() / 100) * 20);
        list.get(i).subMoney((list.get(i).getMoney() / 100) * 20);
    }
    public void add(int i, List<Player> list){
        System.out.println("Vyhra v loterii $200!");
        list.get(i).addMoney(200);
    }

}

