package org.modelexecution.quantitytypes.java.test;


import java.util.Calendar;

import org.modelexecution.quantitytypes.java.BaseUnits;
import org.modelexecution.quantitytypes.java.Quantity;
import org.modelexecution.quantitytypes.java.Unit;

public class SimpleTest {
		final static int NTEST = 20;
		
		static Quantity [] n = new Quantity [NTEST];
		static Quantity [] nU = new Quantity [NTEST];
		static Quantity [] nQ = new Quantity [NTEST];

	

		public static void main(String[] args) {
		
		
			System.out.println("Loading sample...");
			long millisStart = Calendar.getInstance().get(Calendar.MILLISECOND);
			long millisEnd;
			float total;
			
			
			
			for (int i=0; i<NTEST; i++) {
				n[i]=new Quantity((double)i/10,0.0);
				nU[i]=new Quantity((double)i/10,0.001);
				nQ[i]=new Quantity((double)i/10,0.001,new Unit(BaseUnits.Meter));
			}
			
			Quantity m[] = { 
					new Quantity(1.0,0.01,new Unit(BaseUnits.Meter, 4.0)),
					new Quantity(2.0,0.01,new Unit(BaseUnits.Kilogram)),
					new Quantity(3.0,0.01,new Unit(BaseUnits.Second)),
					new Quantity(4.0,0.01,new Unit(BaseUnits.Ampere)),
					new Quantity(5.0,0.01,new Unit(BaseUnits.Kelvin)),
					new Quantity(6.0,0.01,new Unit(BaseUnits.Mole)),
					new Quantity(7.0,0.01,new Unit(BaseUnits.Candela)),
					new Quantity(8.0,0.01,new Unit(BaseUnits.Meter, 1.0,BaseUnits.Second,-1.0))
			};
			
			
		
			System.out.println(m[0].divideBy(m[0]).sMult(2.0));
			System.out.println(m[0].divideBy(m[0]).sMult(2.0));

			System.out.println(m[0].divideBy(m[0]).sMult(2.0).equals(m[0].divideBy(m[0]).sAdd(1.0)));

			System.out.println(m[7].mult(m[0]));
			System.out.println(m[6].divideBy(m[1]));
			
			System.out.println((new Unit(BaseUnits.Meter, 1.0)).isBaseUnit());
			System.out.println((new Unit(BaseUnits.Meter, 4.0)).isBaseUnit());
			System.out.println((new Unit(BaseUnits.Meter, 0.5)).isBaseUnit());
			System.out.println((new Unit(BaseUnits.Meter, 0.0)).isBaseUnit());
			System.out.println((new Unit(BaseUnits.Meter, 1.0)).isDimensionless());
			System.out.println((new Unit(BaseUnits.Meter, 0.0)).isDimensionless());
			System.out.println((new Unit()).isDimensionless());
			System.out.println((new Unit()).isBaseUnit());


			
			millisEnd = Calendar.getInstance().get(Calendar.MILLISECOND);
			total = (millisEnd - millisStart);
			System.out.println("Total time: "+ total + " ms");
			
			System.out.println("DONE");
		}


}
