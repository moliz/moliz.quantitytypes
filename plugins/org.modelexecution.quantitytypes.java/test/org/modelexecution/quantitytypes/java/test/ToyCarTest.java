/**
 * @author mw
 *
 */

package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.quantitytypes.java.BaseUnits;
import org.modelexecution.quantitytypes.java.CommonUnits;
import org.modelexecution.quantitytypes.java.Quantity;
import org.modelexecution.quantitytypes.java.Unit;


/*
 * This test implements the toy example from the SLE 2016 paper. 
 * It assumes to have several sensed values which are used to compute other ones.
 * The test is considering the correctness of the computed values as well as their attached units.
 */ 
public class ToyCarTest {

	@Test
	public void testAc1() {
		
		// sensed values
		Quantity initialPosition = new Quantity( 0, 0.001, CommonUnits.M);
		Quantity finalPosition	 = new Quantity(10, 0.001, CommonUnits.M);
		Quantity duration        = new Quantity(10, 0.002, new Unit(BaseUnits.Second));
		Quantity initialVelocity = new Quantity( 0, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		Quantity finalVelocity   = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		
		// computed values
		Quantity distance        = finalPosition.minus(initialPosition);
		Quantity avgVelocity     = distance.divideBy(duration);
		Quantity avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);
		
		// Testing the value results
		assertEquals("distance=finalPostion-initialPostion must be 10", 
				10, distance.getX(), 0.1);
		assertEquals("avgVel=distance/duration must be ~1", 
				1, avgVelocity.getX(), 0.1);
		assertEquals("avgAcc=(finalVel-initialVel)/distance must be ~0.2", 
				0.2, avgAcceleration.getX(), 0.1);
		
		// Testing the uncertainty results
		assertEquals("uncertainty of distance must be ~0.001?", 
				0.00141, distance.getU(), 0.0001);
		
		assertEquals("uncertainty of avgVel must be ~0.0005?", 
				0.00049, avgVelocity.getU(), 0.00001);
		
		assertEquals("uncertainty of avgAcc must be ~0.09?", 
				0.08944, avgAcceleration.getU(), 0.00001);

		// Testing the return types
		Assert.assertArrayEquals("distance is in metre (m)", 
				new double[]{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
				distance.getUnits().dimensions(), 0);
		
		Assert.assertArrayEquals("avgVel is in metre per second (m s-1)", 
				new double[]{1.0,0.0,-1.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
				avgVelocity.getUnits().dimensions(), 0);
		
		Assert.assertArrayEquals("avgAcc is in metre per second squared (m s-2)", 
					new double[]{1.0,0.0,-2.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
					avgAcceleration.getUnits().dimensions(), 0);
	}

	@Test
	public void testAc2() {
		
		// sensed values
		Quantity initialPosition = new Quantity(10, 0.001, CommonUnits.M);
		Quantity finalPosition	 = new Quantity(20, 0.001, CommonUnits.M);
		Quantity duration        = new Quantity( 5, 0.002, new Unit(BaseUnits.Second));
		Quantity initialVelocity = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		Quantity finalVelocity   = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		
		// computed values
		Quantity distance        = finalPosition.minus(initialPosition);
		Quantity avgVelocity     = distance.divideBy(duration);
		Quantity avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);
		
		// Testing the value results
		assertEquals("distance=finalPostion-initialPostion must be 10", 
				10, distance.getX(), 0.1);
		assertEquals("avgVel=distance/duration must be ~2", 
				2, avgVelocity.getX(), 0.1);
		assertEquals("avgAcc=(finalVel-initialVel)/distance must be ~0.0", 
				0.0, avgAcceleration.getX(), 0.1);
		
		// Testing the uncertainty results
		assertEquals("uncertainty of distance must be ~0.001?", 
				0.00141, distance.getU(), 0.00001);
		
		assertEquals("uncertainty of avgVel must be ~0.001?", 
				0.00102, avgVelocity.getU(), 0.00001);
		
		assertEquals("uncertainty of avgAcc must be ~0.13?", 
				0.1265, avgAcceleration.getU(), 0.00001);

		// Testing the return types
		Assert.assertArrayEquals("distance is in metre (m)", 
				new double[]{1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
				distance.getUnits().dimensions(), 0);
		
		Assert.assertArrayEquals("avgVel is in metre per second (m s-1)", 
				new double[]{1.0,0.0,-1.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
				avgVelocity.getUnits().dimensions(), 0);
		
		Assert.assertArrayEquals("avgAcc is in metre per second squared (m s-2)", 
				new double[]{1.0,0.0,-2.0,0.0,0.0,0.0,0.0,0.0,0.0}, 
				avgAcceleration.getUnits().dimensions(), 0);
		

	}
	
}
