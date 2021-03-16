package sk.stuba.fei.uim.oop;

public class PlayerSuper{       //Rodicovska classa
        int id;
        String playerName;


        PlayerSuper(int id, String playerName) {
            this.id = id;
            this.playerName = playerName;

        }

    public int getID() {
        System.out.println(id);
        return this.id;
    }

    public String getPlayerName() {
        System.out.println(playerName);
        return this.playerName;
    }


}
