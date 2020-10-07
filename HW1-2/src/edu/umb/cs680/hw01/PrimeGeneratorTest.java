package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PrimeGeneratorTest {
	
	@Test
    public void primeFrom1To10() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = { 2L, 3L, 5L, 7L };
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void primeFrom50To75() {
        PrimeGenerator gen = new PrimeGenerator(50, 75);
        gen.generatePrimes();
        Long[] expectedPrimes = { 53L, 59L, 61L, 67L, 71L, 73L};
        assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
    }

    @Test
    public void primeFromNegative10To10() {
        try{
            PrimeGenerator gen = new PrimeGenerator(-10, 10);
            fail("Out of range");
        } catch(IllegalArgumentException ex) {
            assertEquals("start number should bigger than 0", ex.getMessage());
        }
    }

    @Test
    public void primeFrom100To1() {
        try {
            PrimeGenerator gen = new PrimeGenerator(100, 1);
            fail("Out of range");
        } catch (IllegalArgumentException ex) {
            assertEquals("start number shoule be smaller than end number", ex.getMessage());
        }
    }
}