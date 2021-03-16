package sk.stuba.fei.uim.oop;
import java.util.List;

public class Sanca {
    public void event(int i, List<Player> list){         //funkcia policka sance, nahodne vybere kartu
        int randomNum = (int) ((Math.random() * (5 - 1)) + 1);

        switch (randomNum) {
            case 1:
                FunctionsOfSwitchTwo sanca = new FunctionsOfSwitchTwo();
                sanca.add(i,list);
                break;
            case 2:
                FunctionsOfSwitchTwo sanca2 = new FunctionsOfSwitchTwo();
                sanca2.add(list);
                break;
            case 3:
                FunctionsOfSwitchTwo sanca3 = new FunctionsOfSwitchTwo();
                sanca3.gift(i,list);
                break;
            case 4:
                FunctionsOfSwitchTwo sanca4 = new FunctionsOfSwitchTwo();
                sanca4.jailTime(i,list);
                break;
            case 5:
                FunctionsOfSwitchTwo sanca5 = new FunctionsOfSwitchTwo();
                sanca5.sub(i,list);
                break;
        }
    }
}
