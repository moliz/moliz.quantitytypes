package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.modelexecution.quantitytypes.java.Units;

import org.modelexecution.quantitytypes.java.ThermodynamicTemperature;

public class TemperatureTest {

	 protected ThermodynamicTemperature q1, q2, q3, q4, q5;
	  
	 @Before
	 public void setUp(){
			q1 = new ThermodynamicTemperature(10.0, 0.000, Units.Celsius);
			q2 = new ThermodynamicTemperature(5.0, 0.000, Units.Celsius);
			
			q3 = new ThermodynamicTemperature(10.0, 0.000, Units.Kelvin);
			q4 = new ThermodynamicTemperature( 5.0, 0.000, Units.Kelvin);
			
			q5 = new ThermodynamicTemperature( 5.0, 0.000, Units.DeltaCelsius);
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
