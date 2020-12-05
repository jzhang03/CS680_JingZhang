//
// CS680: HW11
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
	public int compare(Car car1, Car car2) {
		return car1.getPrice() - car2.getPrice();
	}
}
