package sk.stuba.fei.uim.oop;

import java.util.List;

public class FunctionsOfSwitchTwo extends FunctionsOfSwitch {            //dedenie classy

    public void add(List<Player> list){                     //overrice funkcie add
        System.out.println("Vseci hraci dostanu $50");
        for(int x = 0; x < list.size(); x++){
            list.get(x).addMoney(50);
        }
    }

    public void gift(int i,List<Player> list){
        System.out.println("Mas narodeniny! Ako darcek si dostal $50");
        list.get(i).addMoney(50);
    }

    public void jailTime(int i,List<Player> list){
        System.out.println("Stojis 1 kolo");
        list.get(i).setWaitTime(1);
    }

}
