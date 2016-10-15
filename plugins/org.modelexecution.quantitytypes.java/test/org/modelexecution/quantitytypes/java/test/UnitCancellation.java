package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.*;

public class UnitCancellation {

	@Test
	public void testCancellation() {
		Mass a   = new Mass(10, 0.0, CommonUnits.KG);
		Mass b	 = new Mass( 2, 0.0, CommonUnits.KG);
		
		Length c	 = new Length(10, 0.0, CommonUnits.FT);
		Length d   = new Length( 2, 0.0, CommonUnits.CM);
		
		assertTrue(a.divideBy(b).getUnits().isDimensionless());
		
		assertTrue(c.divideBy(d).getUnits().isDimensionless());
	}

}
