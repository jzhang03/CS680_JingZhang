//
// CS680: HW5
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw05.Car;


public class CarTest {
    private String[] carToStringArray(Car car) {
        String[] carInfo = {car.getMake(),car.getModel(),Integer.toString(car.getYear())};
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear1() {
         String[] expected = {"Toyota", "RAV4", "2018"}; 
         Car actual = new Car("Toyota", "RAV4", 1000, 2018, 22000f); 
         assertArrayEquals(expected, carToStringArray(actual));
    }
    
    @Test
    public void verifyCarEqualityWithMakeModelYear2() {
        String[] expected = {"Lexus", "RX450h", "2015"};
        Car actual = new Car("Lexus", "RX450h", 25000, 2015, 37000f);
        assertArrayEquals(expected, carToStringArray(actual));
    }
    
    @Test
    public void verifyCarEqualityWithMakeModelYear3() {
        String[] expected = {"Acura", "RDX", "2017"};
        Car actual = new Car("Acura", "RDX", 6000, 2017, 34000f);
        assertArrayEquals(expected, carToStringArray(actual));
    }
}