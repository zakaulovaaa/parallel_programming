package com.company;

public class Unloading extends Thread{
    private SortStation station;
    private int stuff;
    static int cnTrain = 0;
    Unloading(SortStation station, int stuff, String name){
        super(name);
        this.station = station;
        this.stuff = stuff;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Train train = station.getTrain(stuff);
                if (train != null) {
                    cnTrain++;
                    System.out.println("Train is getting fuck out: " + train.getId());
                    Thread.sleep(100 * train.getCntVans());
                }
                if (cnTrain >= 10) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
