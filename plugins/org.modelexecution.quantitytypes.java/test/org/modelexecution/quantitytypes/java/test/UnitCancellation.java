package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.CommonUnits;
import org.modelexecution.quantitytypes.java.Quantity;

public class UnitCancellation {

	@Test
	public void testCancellation() {
		Quantity a   = new Quantity(10, 0.0, CommonUnits.KG);
		Quantity b	 = new Quantity( 2, 0.0, CommonUnits.KG);
		
		Quantity c	 = new Quantity(10, 0.0, CommonUnits.FT);
		Quantity d   = new Quantity( 2, 0.0, CommonUnits.CM);
		
		assertTrue(a.divideBy(b).getUnits().isDimensionless());
		
		assertTrue(c.divideBy(d).getUnits().isDimensionless());
	}

}
