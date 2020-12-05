//
// CS680: HW11
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest {

    private static ArrayList<Car> cars = new ArrayList<>();
    
    @BeforeAll
    public static void init() {
        cars.add(new Car("Honda", "Civic", 2000, 1998, 30000));
        cars.add(new Car("Toyota", "RAV4", 1500, 2004, 30000));
        cars.add(new Car("Lexus", "ES300h", 1100, 2015, 20000));
        cars.add(new Car("Tesla", "Model3", 0, 2020, 10000));
    }
    
    @Test
    public void ParetoCompare() {
        for(Car car: cars){ 
            car.setDominationCount(cars); 
        }
        String[] expected = {"Model3", "ES300h", "RAV4", "Civic"};
        Collections.sort(cars, new ParetoComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }
    
    private String[] carsToStringArray(ArrayList<Car> cars) {
        String[] carsModel =  new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
        	carsModel[i] = cars.get(i).getModel();
        }
        return carsModel;
    }
}
