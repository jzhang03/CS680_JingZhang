//
// CS680: HW1
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3,4);
		assertTrue(cut instanceof Calculator);
		assertEquals(expected, actual);
	}
	@Test
	public void divide3By2(){
		Calculator cut = new Calculator();
		float expected = 1.5f;
		float actual = cut.divide(3,2);
		assertEquals(expected, actual);
	}
	@Test
	public void divide5By0withTryCatch(){
		Calculator cut = new Calculator();
		try{
			cut.divide(5, 0);
			fail("Division by zero");
		}
		catch(IllegalArgumentException ex){
			assertEquals("division by zero", ex.getMessage());
		}
	}
}
