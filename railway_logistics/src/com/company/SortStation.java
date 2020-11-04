package com.company;

import java.util.ArrayList;

public class SortStation {
    private int finished = 10;
    private ArrayList<Train> trains;
    private int trainsCounter = 0, maxSize = 5, minSize = 0;

    SortStation() {
        trains = new ArrayList<>();
    }

    public synchronized boolean addTrain(Train train) throws InterruptedException {
        while (trainsCounter >= maxSize)
            wait();
        notifyAll();
        trains.add(train);
        System.out.println("Add in station: " + train.getId());
        trainsCounter++;
        return true;
    }

    public synchronized Train getTrain(int needType) throws InterruptedException {
        while (finished != 0 && trainsCounter <= minSize)
            wait();
        notifyAll();
        for (Train train : trains) {
            if (train.getTypeOfStuff() == needType) {
                finished--;
                trainsCounter--;
                System.out.println("Get " + train.getId() + "| thread = " + Thread.currentThread().getName());
                trains.remove(train);
                return train;
            }
        }
        return null;
    }


}
