package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelexecution.quantitytypes.java.CommonUnits;
import org.modelexecution.quantitytypes.java.Quantity;

public class CircleTest {

	@Test
	public void testLengthAreaTransition() {
		
		Quantity radius = new Quantity(30, 0.000, CommonUnits.CM);
		Quantity multi = new Quantity(2 * Math.PI);
		Quantity circumference = radius.mult(multi);
	
		assertEquals("Circumference = 2*PI*radius: 2*PI*30cm must be 188.49cm", 188.49, 
				circumference.convertTo(CommonUnits.CM).getX(), 0.01);
		
		Quantity area = (radius.mult(radius)).mult(new Quantity(Math.PI));
		
		assertEquals("A=r^2*PI: 30cm^2*PI must be 2827,43cm^2", 2827.43, 
				area.convertTo(CommonUnits.CM2).getX(), 0.01);


	}

}
