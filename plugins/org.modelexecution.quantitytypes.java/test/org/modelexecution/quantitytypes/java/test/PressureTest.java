package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.*;

public class PressureTest {

	@Test
	public void testPressureComputation() {
		
		Mass m = new Mass(55, 0.000, Units.Kilogram);
		Length l1 = new Length(0.02, 0.000, Units.Meter);
		Length l2 = new Length(0.02, 0.000, Units.Meter);
		
		Area a = l1.mult(l2);
		
//		LinearAcceleration g = new LinearAcceleration(9.81, 0.000, new Unit("meterPerSecondSquared", "m/s^2", BaseUnits.Meter, 1.0, 1.0, 0.0,BaseUnits.Second, -2.0, 1.0));
		LinearAcceleration g = new LinearAcceleration(9.81, 0.000, Units.MeterPerSecondSquared);
		
		Force f = m.mult(g);
		
		Quantity p = f.divideBy(a);
		
		assertEquals("p=f/a=m*g/a for given values must be 1348875Pa (m^-1, kg, s^-1) NewtonPerSquareMeter | (J/m^3) JoulePerCubicMeter", 1348875, 
				p.getX(), 0.01);
		
	}
	
}
