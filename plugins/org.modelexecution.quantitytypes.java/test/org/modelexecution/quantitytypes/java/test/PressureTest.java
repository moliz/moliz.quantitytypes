package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.BaseUnits;
import org.modelexecution.quantitytypes.java.CommonUnits;
import org.modelexecution.quantitytypes.java.Quantity;
import org.modelexecution.quantitytypes.java.Unit;

public class PressureTest {

	@Test
	public void testPressureComputation() {
		
		Quantity m = new Quantity(55, 0.000, CommonUnits.KG);
		Quantity l1 = new Quantity(0.02, 0.000, CommonUnits.M);
		Quantity l2 = new Quantity(0.02, 0.000, CommonUnits.M);
		
		Quantity a = l1.mult(l2);
		
		Quantity g = new Quantity(9.81, 0.000, new Unit("meterPerSecondSquared", "m/s^2", BaseUnits.Meter, 1.0, 1.0, 0.0,BaseUnits.Second, -2.0, 1.0));
		
		Quantity f = m.mult(g);
		
		Quantity p = f.divideBy(a);
		
		assertEquals("p=f/a=m*g/a for given values must be 1348875Pa (m^-1, kg, s^-1) NewtonPerSquareMeter | (J/m^3) JoulePerCubicMeter", 1348875, 
				p.getX(), 0.01);
		
	}
	
}
