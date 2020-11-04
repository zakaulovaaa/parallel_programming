package com.company;

import java.util.Random;

public class Train {
    private int cntVans, typeOfStuff, id;
    Random rnd = new Random();
    private static int cnt = 0;
    Train() {
        id = ++cnt;
        cntVans = rnd.nextInt(8) + 3;
        typeOfStuff = rnd.nextInt(3);
    }

    public int getId() {
        return id;
    }

    public int getCntVans() {
        return cntVans;
    }

    public int getTypeOfStuff() {
        return typeOfStuff;
    }

    public void setCntVans(int cntVans) {
        this.cntVans = cntVans;
    }

    public void setTypeOfStuff(int typeOfStuff) {
        this.typeOfStuff = typeOfStuff;
    }
}
