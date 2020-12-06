//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable {
    private Map<String, Float> tickerquotemap= new HashMap<String, Float>();

    public void changeQuote(String t, float q) {
        tickerquotemap.put(t, q);
        setChanged();
        notifyObservers(new StockEvent(t,q));
    }
}
