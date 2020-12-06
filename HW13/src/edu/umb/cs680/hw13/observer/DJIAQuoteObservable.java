//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.observer;

import java.util.Observable;

public class DJIAQuoteObservable extends Observable {
    private float quote;

    public void changeQuote(float q) {
        quote = q;
        setChanged();
        notifyObservers(new DJIAEvent(quote));
    }
}
