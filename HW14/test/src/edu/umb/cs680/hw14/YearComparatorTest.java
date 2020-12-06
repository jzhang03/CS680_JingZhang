//
// CS680: HW14
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {
    private static ArrayList<Car> cars = new ArrayList<>();
    
    @BeforeAll
    public static void init() {
        cars.add(new Car("Honda", "Civic", 2000, 1998, 35000f));
        cars.add(new Car("Toyota", "RAV4", 1500, 2004, 30000f));
        cars.add(new Car("Lexus", "ES300h", 1100, 2015, 20000f));
        cars.add(new Car("Tesla", "Model3", 5000, 2020, 10000f));
    }
    
    @Test
    public void YearCompareTest() {
        String[] expected = {"2020", "2015", "2004", "1998"};
        Collections.sort(cars, (Car car1, Car car2) -> {return car2.getYear() - car1.getYear();});
        String[] actual = {String.valueOf(cars.get(0).getYear()),
                String.valueOf(cars.get(1).getYear()),
                String.valueOf(cars.get(2).getYear()),
                String.valueOf(cars.get(3).getYear())};
        assertArrayEquals(expected, actual);
    }
}
