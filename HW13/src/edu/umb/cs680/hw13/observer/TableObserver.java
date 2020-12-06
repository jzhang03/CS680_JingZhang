//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.observer;

import java.util.Observable;
import java.util.Observer;

public class TableObserver implements Observer {
    public void update(Observable o, Object arg) {
        if (arg instanceof StockEvent) {
            System.out.print("\n Table: \n Ticker = " + ((StockEvent)arg).getTicker()
                    + "\n Quote = "  + ((StockEvent)arg).getQuote() + "\n");
        }
        else if (arg instanceof DJIAEvent) {
             System.out.print("\n Table: \n DJIA = " + ((DJIAEvent)arg).getDjia());
        }
    }
}
