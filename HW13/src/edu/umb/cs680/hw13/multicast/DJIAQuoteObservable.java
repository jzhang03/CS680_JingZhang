//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.multicast;

import java.util.LinkedList;

public class DJIAQuoteObservable {
    private LinkedList<DJIAQuoteObserver> observers = new LinkedList<DJIAQuoteObserver>();

    public void addObserver(DJIAQuoteObserver ob) {
        observers.add(ob);
    }

    public void notifyObservers(DJIAEvent event) {
        for (DJIAQuoteObserver observer: observers) {
            observer.updateDJIA(event);
        }
    }
}
