//
// CS680: HW13
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw13.multicast;

public class StockEvent {
    private String ticker;
    private float quote;
    
	public StockEvent(String t, float q) {
		this.ticker = t;
		this.quote = q;
	}
	
    public String getTicker() {
        return ticker;
    }
    
    public float getQuote() {
        return quote;
    }
}
