//
// CS680: HW11
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MileageComparatorTest {
    private static ArrayList<Car> cars = new ArrayList<>();
    
    @BeforeAll
    public static void init() {
        cars.add(new Car("Honda", "Civic", 2000, 1998, 30000));
        cars.add(new Car("Toyota", "RAV4", 1500, 2004, 30000));
        cars.add(new Car("Lexus", "ES300h", 1100, 2015, 20000));
        cars.add(new Car("Tesla", "Model3", 5000, 2020, 10000));
    }
    
    @Test
    public void MileageCompare() {
        String[] expected = {"ES300h", "RAV4", "Civic", "Model3"};
        Collections.sort(cars, new MileageComparator());
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
