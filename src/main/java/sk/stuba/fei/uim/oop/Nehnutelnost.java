package sk.stuba.fei.uim.oop;

public class Nehnutelnost {     //objekt kde sa vytvaraju nehnutelnosti
    private String menoNeh;
    private int price;
    private int ownderID;
    private int payMoney;

    Nehnutelnost(String menoNeh, int price, int payMoney){
        this.menoNeh = menoNeh;
        this.price = price;
        this.ownderID = 0;
        this.payMoney = payMoney;
    }


    public String getMenoNeh() {
        return menoNeh;
    }

    public int getPrice() {
        return price;
    }

    public int getOwnderID() {
        return ownderID;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setMenoNeh(String menoNeh) {
        this.menoNeh = menoNeh;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwnderID(int ownderID) {
        this.ownderID = ownderID;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }
}
