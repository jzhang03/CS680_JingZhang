//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.multicast;

public class PiechartObserver implements StockQuoteObserver, DJIAQuoteObserver {
    public void updateStock(StockEvent stockE) {
        System.out.print("\n Piechart:\n Ticker = " + stockE.getTicker()
                + "\n Quote = " + stockE.getQuote() + "\n");
    }

    public void updateDJIA(DJIAEvent djiaE) {
        System.out.print("\n Piechart: \n DJIA = " + djiaE.getDjia());
    }
}
