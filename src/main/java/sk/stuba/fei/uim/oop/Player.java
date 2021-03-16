package sk.stuba.fei.uim.oop;

public class Player extends PlayerSuper{       //objekt kde sa vystaraju hraci //Zdenena classa

    private float money;
    private int position;
    private int waitTime;
    private boolean inGame;

    Player(int id,String playerName){
        super(id,playerName);
        this.money = 500;
        this.position = 0;
        this.waitTime = 0;
        this.inGame = true;
    }

    @Override                       //override metody zo superclassy PlayerSuper
    public int getID() {
        return this.id;
    }
    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    public float getMoney() {
        return this.money;
    }
    public void addMoney(float add) {
        this.money += add;
    }
    public void subMoney(float sub) {
        this.money -= sub;
    }
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public int getWaitTime() {
        return this.waitTime;
    }
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    public void subWaitTime(int waitTime) {
        this.waitTime -= waitTime;
    }
    public boolean isInGame() {
        return inGame;
    }
    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }
}
