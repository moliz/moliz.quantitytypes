package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.*;

public class UnitCancellation {

	@Test
	public void testCancellation() {
		Mass a   = new Mass(10, 0.0, Units.Kilogram);
		Mass b	 = new Mass( 2, 0.0, Units.Kilogram);
		
		Length c	 = new Length(10, 0.0, Units.Foot);
		Length d   = new Length( 2, 0.0, Units.Centimeter);
		
		assertTrue(a.divideBy(b).getUnits().isDimensionless());
		
		assertTrue(c.divideBy(d).getUnits().isDimensionless());
	}

}
