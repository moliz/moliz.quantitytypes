/**
 * @author mw
 *
 */

package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.quantitytypes.java.*;

/*
 * This test implements the toy example from the SLE 2016 paper. 
 * It assumes to have several sensed values which are used to compute other ones.
 * The test is considering the correctness of the computed values as well as their attached units.
 */
public class ToyCarTest {

	@Test
	public void testAc1() {

		// sensed values
		Length initialPosition = new Length(0, 0.001, Units.Meter);
		Length finalPosition = new Length(10, 0.001, Units.Meter);
		Time duration = new Time(10, 0.002, new Unit(Units.Second));
		LinearVelocity initialVelocity = new LinearVelocity(0, 0*0.01,
				Units.MeterPerSecond);
//				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		LinearVelocity finalVelocity = new LinearVelocity(2, 2*0.01,
				Units.MeterPerSecond);
//				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));

		// computed values
		Length distance = finalPosition.minus(initialPosition);
		LinearVelocity avgVelocity = distance.divideBy(duration);
		LinearAcceleration avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);

		// Testing the value results
		assertEquals("distance=finalPostion-initialPostion must be 10", 10, distance.getX(), 0.1);
		assertEquals("avgVel=distance/duration must be ~1", 1, avgVelocity.getX(), 0.1);
		assertEquals("avgAcc=(finalVel-initialVel)/distance must be ~0.2", 0.2, avgAcceleration.getX(), 0.1);

		// Testing the uncertainty results
		assertEquals("uncertainty of distance must be ~0.001?", 0.001, distance.getU(), 0.001);

		assertEquals("uncertainty of avgVel must be ~0.0004?", 0.0004, avgVelocity.getU(), 0.0001);

		assertEquals("uncertainty of avgAcc must be ~0.006?", 0.00632, avgAcceleration.getU(), 0.001);

		// Testing the return types
		Assert.assertArrayEquals("distance is in metre (m)", new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				distance.getUnits().dimensions(), 0);

		Assert.assertArrayEquals("avgVel is in metre per second (m s-1)",
				new double[] { 1.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, avgVelocity.getUnits().dimensions(), 0);

		Assert.assertArrayEquals("avgAcc is in metre per second squared (m s-2)",
				new double[] { 1.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, avgAcceleration.getUnits().dimensions(), 0);
	}

	@Test
	public void testAc2() {

		// sensed values
		Length initialPosition = new Length(10, 0.001, Units.Meter);
		Length finalPosition = new Length(20, 0.001, Units.Meter);
		Time duration = new Time(5, 0.002, new Unit(Units.Second));
		LinearVelocity initialVelocity = new LinearVelocity(2, 2*0.01,
				Units.MeterPerSecond);
//				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		LinearVelocity finalVelocity = new LinearVelocity(2, 2*0.01,
				Units.MeterPerSecond);
//				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));

		// computed values
		Length distance = finalPosition.minus(initialPosition);
		LinearVelocity avgVelocity = distance.divideBy(duration);
		LinearAcceleration avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);

		// Testing the value results
		assertEquals("distance=finalPostion-initialPostion must be 10", 10, distance.getX(), 0.1);
		assertEquals("avgVel=distance/duration must be ~2", 2, avgVelocity.getX(), 0.1);
		assertEquals("avgAcc=(finalVel-initialVel)/distance must be ~0.0", 0.0, avgAcceleration.getX(), 0.1);

		// Testing the uncertainty results
		assertEquals("uncertainty of distance must be ~0.001?", 0.00141, distance.getU(), 0.00001);

		assertEquals("uncertainty of avgVel must be ~0.001?", 0.00102, avgVelocity.getU(), 0.00001);

		assertEquals("uncertainty of avgAcc must be ~0.013?", 0.01265, avgAcceleration.getU(), 0.00001);

		// Testing the return types
		Assert.assertArrayEquals("distance is in metre (m)", new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
				distance.getUnits().dimensions(), 0);

		Assert.assertArrayEquals("avgVel is in metre per second (m s-1)",
				new double[] { 1.0, 0.0, -1.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, avgVelocity.getUnits().dimensions(), 0);

		Assert.assertArrayEquals("avgAcc is in metre per second squared (m s-2)",
				new double[] { 1.0, 0.0, -2.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, avgAcceleration.getUnits().dimensions(), 0);

	}

	@Test
	public void testVehicle() {

		// sensed values acc1
		Length initialPositionAcc1 = new Length(0, 0.001, Units.Meter);
		Length finalPositionAcc1 = new Length(10, 0.001, Units.Meter);
		Time durationAcc1 = new Time(10, 0.002, new Unit(BaseUnits.Second));
		LinearVelocity initialVelocityAcc1 = new LinearVelocity(0, 0*0.01,
				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		LinearVelocity finalVelocityAcc1 = new LinearVelocity(2, 2*0.01,
				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));

		// computed values acc1
		Length distanceAcc1 = finalPositionAcc1.minus(initialPositionAcc1);
		LinearVelocity avgVelocityAcc1 = distanceAcc1.divideBy(durationAcc1);
		LinearAcceleration avgAccelerationAcc1 = (finalVelocityAcc1.minus(initialVelocityAcc1)).divideBy(durationAcc1);

		// sensed values acc2
		Length initialPositionAcc2 = new Length(10, 0.001, Units.Meter);
		Length finalPositionAcc2 = new Length(20, 0.001, Units.Meter);
		Time durationAcc2 = new Time(5, 0.002, new Unit(BaseUnits.Second));
		LinearVelocity initialVelocityAcc2 = new LinearVelocity(2, 2*0.01,
				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
		LinearVelocity finalVelocityAcc2 = new LinearVelocity(2, 2*0.01,
				new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));

		// computed values acc2
		Length distanceAcc2 = finalPositionAcc2.minus(initialPositionAcc2);
		LinearVelocity avgVelocityAcc2 = distanceAcc2.divideBy(durationAcc2);
		LinearAcceleration avgAccelerationAcc2 = (finalVelocityAcc2.minus(initialVelocityAcc2)).divideBy(durationAcc2);

		// computed values vehicle
		LinearVelocity avgVelocity = avgVelocityAcc1.add(avgVelocityAcc2).divideBy(new UReal(2));
		LinearAcceleration avgAcceleration = avgAccelerationAcc1.add(avgAccelerationAcc2).divideBy(2.0);

		// Testing the value results
		assertEquals("avgVelocity must be ~1.5", 1.5, avgVelocity.getX(), 0.001);
		assertEquals("avgAcceleration must be ~0.1", 0.1, avgAcceleration.getX(), 0.01);

		// Testing the uncertainty results
		assertEquals("uncertainty of avgVelocity must be ~0.0008?", 0.0008, avgVelocity.getU(), 0.0001);
		assertEquals("uncertainty of avgAcceleration must be ~0.01?", 0.01, avgAcceleration.getU(), 0.01);

	}

}
