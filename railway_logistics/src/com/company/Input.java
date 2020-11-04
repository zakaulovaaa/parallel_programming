package com.company;

public class Input extends Thread{

    private SortStation station;
    private static int cntTrains;

    Input(SortStation station, int cntTrains) {
        this.station = station;
        this.cntTrains = cntTrains;
    }

    @Override
    public void run() {
        int cnt = 0;
        while (cnt < cntTrains) {
            cnt++;
            try {
                station.addTrain(new Train());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getCntTrains() {
        return cntTrains;
    }
}
