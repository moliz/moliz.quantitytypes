package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.modelexecution.quantitytypes.java.CommonUnits;
import org.modelexecution.quantitytypes.java.Quantity;

public class TemperatureTest {

	 protected Quantity q1, q2, q3, q4, q5;
	  
	 @Before
	 public void setUp(){
			q1 = new Quantity(10.0, 0.000, CommonUnits.CELSIUS);
			q2 = new Quantity(5.0, 0.000, CommonUnits.CELSIUS);
			
			q3 = new Quantity(10.0, 0.000, CommonUnits.KELVIN);
			q4 = new Quantity( 5.0, 0.000, CommonUnits.KELVIN);
			
			q5 = new Quantity( 5.0, 0.000, CommonUnits.DeltaCELSIUS);
	 }
	

	@Test(expected=RuntimeException.class)
	public void testPlusCelsius() {
		q1.add(q2);
	}
	
	@Test
	public void testCelsiusMinusCelsius() {
		assertEquals("10C-5C must be 5deltaC", 5, q1.minus(q2).getX(), 0.0);
		
		// Testing the return type to be delta type
		assertEquals("DeltaCelsius", q1.minus(q2).getUnits().name());
	}

	@Test(expected=RuntimeException.class)
	public void testCelsiusDivCelsius() {
		q1.divideBy(q2);
	}
	
	@Test
	public void testKelvinMinusKelvin() {
		assertEquals("10K-5K must be 5K", 5, q3.minus(q4).getX(), 0.0);
	}
	
	@Test
	public void testCelsiusPlusDeltaCelsius() {
		assertEquals("10C+5deltaC must be 15C", 15, q1.add(q5).getX(), 0.0);
		
		// Testing the return type to be delta type
		assertEquals("Celsius", q1.add(q5).getUnits().name());
	}
	
}
