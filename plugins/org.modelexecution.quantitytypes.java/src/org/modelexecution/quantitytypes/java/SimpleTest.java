package org.modelexecution.quantitytypes.java;


import java.util.Calendar;

public class SimpleTest {
		final static int NTEST = 20;
		
		static Quantity [] n = new Quantity [NTEST];
		static Quantity [] nU = new Quantity [NTEST];
		static Quantity [] nQ = new Quantity [NTEST];

	

		public static void main(String[] args) {
		
		
//			System.out.println("Loading sample...");
			long millisStart = Calendar.getInstance().get(Calendar.MILLISECOND);
			long millisEnd;
			float total;
			
			
			
//			for (int i=0; i<NTEST; i++) {
//				n[i]=new Quantity((double)i/10,0.0);
//				nU[i]=new Quantity((double)i/10,0.001);
//				nQ[i]=new Quantity((double)i/10,0.001,new Unit(BaseUnits.Meter));
//			}
			
			Quantity m[] = { 
					new Quantity(1.0,0.01,new Unit(BaseUnits.Meter, 4.0)),
					new Quantity(2.0,0.01,new Unit(BaseUnits.Kilogram)),
					new Quantity(3.0,0.01,new Unit(BaseUnits.Second)),
					new Quantity(4.0,0.01,new Unit(BaseUnits.Ampere)),
					new Quantity(5.0,0.01,new Unit(BaseUnits.Kelvin)),
					new Quantity(6.0,0.01,new Unit(BaseUnits.Mole)),
					new Quantity(7.0,0.01,new Unit(BaseUnits.Candela)),
					new Quantity(8.0,0.01,new Unit(DerivedUnits.MeterPerSecond))
			};
			
//			double o[] = {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0};
//			Unit errorUnit = new Unit("uno","uno",o,o,o);
//			System.out.println(errorUnit);

			 
			System.out.println(m[0].divideBy(m[0]).mult(2.0));
			System.out.println(m[0].divideBy(m[0]).mult(2.0));

			System.out.println(m[0].divideBy(m[0]).mult(2.0).equals(m[0].divideBy(m[0]).mult(1.0)));

			System.out.println(m[7].mult(m[0]));
			System.out.println(m[6].divideBy(m[1]));
			
			System.out.println((new SIUnit(BaseUnits.Meter, 1.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 4.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.5)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 1.0)).isUnitless());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.0)).isUnitless());
			System.out.println((new SIUnit()).isUnitless());
			System.out.println((new SIUnit(BaseUnits.Meter, 1.0)).isDimensionless());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.0)).isDimensionless());
			System.out.println((new SIUnit()).isDimensionless());
			System.out.println((new SIUnit()).isBaseUnit());


			
			
			Quantity A = new Quantity(50.0, 0.0001, Units.MilePerHour);
			Quantity B = new Quantity(3.0, 0.0, new Unit("KilometerPerMinute", "km/min", BaseUnits.Meter, 1.0, 1000.0, 0.0, BaseUnits.Second, -1.0, 60.0));
			System.out.println("A+B: "+A.add(B));
			System.out.println("B+A: "+B.add(A));
			System.out.println("B+A-SI: "+A.add(B).convertToSIUnits());

			
			
			Quantity qkm = new Quantity(1.0, 0.0, Units.Kilometer);
			Quantity qm = new Quantity(1.0, 0.0, Units.Meter);
			Quantity qmile = new Quantity(1.0, 0.0, Units.Mile);
			Quantity qyard = new Quantity(1.0, 0.0, Units.Yard);
			Quantity qfeet = new Quantity(1.0, 0.0, Units.Foot);
			Quantity qinch = new Quantity(1.0, 0.0, Units.Inch);

			Quantity qms = new Quantity(1.0, 0.000, new Unit(DerivedUnits.MeterPerSecond));
			Quantity qkms = new Quantity(1.0, 0.000, Units.KilometerPerSecond);
			Quantity qkms2 = new Quantity(1.00, 0.000, Units.KilometerPerSecondSquared);
			Quantity qkmh = new Quantity(1.0,0.000,Units.KilometerPerHour);
			Quantity qkmh2 = new Quantity(1.0,0.000,Units.KilometerPerHourSquared);

			Quantity k = new Quantity(1.0, 0.00, new Unit(BaseUnits.Kelvin));
			Quantity c = new Quantity(1.0,0.000,Units.Celsius);
			Quantity f = new Quantity(1.0,0.00,Units.Farenheit);
			
			Quantity dc = new Quantity(1.0,0.000,Units.DeltaCelsius);
			Quantity df = new Quantity(1.0,0.00,Units.DeltaFarenheit);

			System.out.println("1K + K: "+k.add(k));
			System.out.println("1K - K: "+k.minus(k));
			System.out.println("1K * K: "+k.mult(k));
			System.out.println("1K / K: "+k.divideBy(k));

			 Quantity  K1 = new Quantity(10.0, 0.000, Units.Kelvin);
			 Quantity  K2 = new Quantity(5.0, 0.000, Units.Kelvin);
			 System.out.println("K1 minus K2: "+K1.minus(K2));
			   
			 Quantity  F1 = new Quantity(10.0, 0.000, Units.Farenheit);
			 Quantity  C1 = new Quantity(5.0, 0.000, Units.Celsius);
			 System.out.println("C1 minus C1: "+C1.minus(C1));
			 System.out.println("F1 minus F1: "+F1.minus(F1));
			 System.out.println("C1 minus F1: "+C1.minus(F1));
			 System.out.println("F1 minus C1: "+F1.minus(C1));
//ERROR		 System.out.println("K1 minus F1: "+K1.minus(F1));  // checked
//ERROR		 System.out.println("K1 minus C1: "+K1.minus(C1));  // checked
//ERROR		 System.out.println("F1 minus K1: "+K1.minus(F1));  // checked
//ERROR		 System.out.println("C1 minus K1: "+K1.minus(C1));  // checked
			 
			 Quantity  q3 = new Quantity(10.0, 0.000, Units.Kelvin);
			 Quantity  q4 = new Quantity(5.0, 0.000, Units.Kelvin);
			 System.out.println("Q3 minus Q4: "+q3.minus(q4));
			 
			 System.out.println("C1 minus DC: "+C1.minus(dc));
			 System.out.println("F1 minus DF: "+F1.minus(df));
			 System.out.println("C1 + DC: "+C1.add(dc));
			 System.out.println("F1 + DF: "+F1.add(df));
		 
			 System.out.println("C1 minus DF: "+C1.minus(df));
			 System.out.println("F1 minus DC: "+F1.minus(dc));
			 System.out.println("C1 + DF: "+C1.add(df));
			 System.out.println("F1 + DC: "+F1.add(dc));

			 System.out.println("1K to K: "+k.convertToSIUnits());
			System.out.println("1K to K: "+k.convertFromSIUnits(k.convertToSIUnits().value));
			System.out.println("1K to K: "+k.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1K to F: "+k.convertTo(Units.Farenheit));
			System.out.println("1K to C: "+k.convertTo(Units.Celsius));

			System.out.println("1C to K: "+c.convertToSIUnits());
			System.out.println("1C to K: "+c.convertTo(new Unit(BaseUnits.Kelvin)));
			
			System.out.println("1F to K: "+f.convertToSIUnits());
			System.out.println("1F to K: "+f.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1C to C: "+c.convertFromSIUnits(c.convertToSIUnits().value));
			System.out.println("1C to C: "+c.convertTo(Units.Celsius));


			System.out.println("1F to F: "+f.convertFromSIUnits(f.convertToSIUnits().value));
			System.out.println("1F to F: "+f.convertTo(Units.Farenheit));

			System.out.println("1F to C: "+f.convertTo(Units.Celsius));
			System.out.println("1C to F: "+c.convertTo(Units.Farenheit));

			
/////////////////
			System.out.println("1K to DF: "+k.convertTo(Units.DeltaFarenheit));
			System.out.println("1K to DC: "+k.convertTo(Units.DeltaCelsius));

			System.out.println("1DC to K: "+dc.convertToSIUnits());
			System.out.println("1DC to K: "+dc.convertTo(new Unit(BaseUnits.Kelvin)));
			
			System.out.println("1DF to K: "+df.convertToSIUnits());
			System.out.println("1DF to K: "+df.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1DC to C: "+c.convertFromSIUnits(dc.convertToSIUnits().value));
			System.out.println("1DC to C: "+c.convertTo(Units.DeltaCelsius));

			System.out.println("1DC to DC: "+dc.convertFromSIUnits(dc.convertToSIUnits().value));
			System.out.println("1DC to DC: "+dc.convertTo(Units.DeltaCelsius));

			System.out.println("1DF to DF: "+df.convertFromSIUnits(df.convertToSIUnits().value));
			System.out.println("1DF to DF: "+df.convertTo(Units.DeltaFarenheit));

			System.out.println("1DF to F: "+f.convertFromSIUnits(df.convertToSIUnits().value));
			System.out.println("1DF to F: "+f.convertTo(Units.DeltaFarenheit));

			System.out.println("1DF to DC: "+df.convertTo(Units.DeltaCelsius));
			System.out.println("1DC to DF: "+dc.convertTo(Units.DeltaFarenheit));

			System.out.println("1DF to C: "+df.convertTo(Units.Celsius));
			System.out.println("1DC to F: "+dc.convertTo(Units.Farenheit));
			System.out.println("1F to DC: "+f.convertTo(Units.DeltaCelsius));
			System.out.println("1C to DF: "+c.convertTo(Units.DeltaFarenheit));
			
//////////////
			

			System.out.println("1M to SI: "+ qm.convertToSIUnits());

			System.out.println("1KM to SI: "+qkm.convertToSIUnits());

			System.out.println("1Mile to SI: "+qmile.convertToSIUnits());
			System.out.println("1yd to SI: "+qyard.convertToSIUnits());
			System.out.println("1ft to SI: "+qfeet.convertToSIUnits());
			System.out.println("1in to SI: "+qinch.convertToSIUnits());
		
			
			System.out.println("1M/S to SI: "+qms.convertToSIUnits());
			System.out.println("1KM/H to SI: "+qkmh.convertToSIUnits());
			System.out.println("1KM/S to SI: "+qkms.convertToSIUnits());
			System.out.println("1KM/H2 to SI: "+qkmh2.convertToSIUnits());
			System.out.println("1KM/S2 to SI: "+qkms2.convertToSIUnits());


			System.out.println("1KM + 1M: "+qkm.add(qm));
			System.out.println("1M + 1KM: "+qm.add(qkm));
			System.out.println("1KM - 1M: "+qkm.minus(qm));
			System.out.println("1M - 1KM: "+qm.minus(qkm));

			System.out.println("1KM to M: "+qkm.convertTo(Units.Meter));
			System.out.println("1M to KM: "+qm.convertTo(Units.Kilometer));
			
			System.out.println("1M to KM to M: "+qm.convertTo(Units.Kilometer).convertTo(Units.Meter));
			System.out.println("1KM to M to KM: "+qkm.convertTo(Units.Meter).convertTo(Units.Kilometer));
			System.out.println("1KM to KM: "+qkm.convertTo(Units.Kilometer));
			System.out.println("1M to M: "+qm.convertTo(Units.Meter));
			
			

			Quantity x = qkm.mult(qm);
			System.out.println("1KM * 1M: "+x);
			System.out.println("1KM * 1M * 1M * 1C: "+x.mult(qm).mult(dc));
			System.out.println("1KM * 1M * 1M * 1C / 1C: "+x.mult(qm).mult(dc).divideBy(dc));
			System.out.println("1KM * M / 1KM: "+x.divideBy(qkm));
			System.out.println("1KM / C * KM: "+qkm.divideBy(dc).divideBy(qkm));
			System.out.println("1M /C * M: "+qm.divideBy(dc).divideBy(qm));

			System.out.println("1KMK + 1KMS: "+qkmh.add(qkms));
			System.out.println("1KMS + 1KMH: "+qkms.add(qkmh));
			System.out.println("1KMH + 1KMH: "+qkmh.add(qkmh));
			System.out.println("1KMS + 1KMS: "+qkms.add(qkms));

			System.out.println("1KMK * 2: "+qkmh.mult(2.0));

			System.out.println("1KMS2 + 1KMH2: "+qkms2.add(qkmh2));
			System.out.println("1KMS - 1KMH: "+qkms.minus(qkmh));
			System.out.println("1M - 1KM: "+qm.minus(qkm));
			System.out.println("1KMS to MS: "+qkms.convertTo(new Unit(DerivedUnits.MeterPerSecond)));
			System.out.println("1KMH to MS: "+qkmh.convertTo(new Unit(DerivedUnits.MeterPerSecond)));
			System.out.println("1KMS2 to MS2: "+qkms2.convertTo(new Unit(DerivedUnits.MeterPerSecondSquared)));
			System.out.println("1KMH2 to MS2: "+qkmh2.convertTo(new Unit(DerivedUnits.MeterPerSecondSquared)));

			Quantity initialPosition = new Quantity( 0, 0.000, Units.Meter);
			Quantity finalPosition	 = new Quantity(10, 0.001, Units.Meter);
			Quantity duration        = new Quantity(10, 0.002, new Unit(BaseUnits.Second));
			Quantity initialVelocity = new Quantity( 0, 0.000, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			Quantity finalVelocity   = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			
			// computed values
			Quantity distance        = finalPosition.minus(initialPosition);
			Quantity avgVelocity     = distance.divideBy(duration);
			Quantity avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);
			
	/***
	 * 		// Testing the value results
	 		assertEquals("distance=finalPostion-initialPostion must be 10", 
					10, distance.getX(), 0.1);
			assertEquals("avgVel=distance/duration must be ~1", 
					1, avgVelocity.getX(), 0.1);
			assertEquals("avgAcc=(finalVel-initialVel)/distance must be ~0.2", 
					0.2, avgAcceleration.getX(), 0.1);
			
			// Testing the uncertainty results
			assertEquals("uncertainty of distance must be 0.001?", 
					0.001, distance.getU(), 0.001);
			
//			assertEquals("uncertainty of avgVel must be ~0.0002?", 
//					0.0002, avgVelocity.getU(), 0.0001);
	*/

			System.out.println(avgVelocity.getU());
			
//			assertEquals("uncertainty of avgAcc must be ~0.02?", 
//					0.02, avgAcceleration.getU(), 0.01);
			System.out.println(avgAcceleration.getU());


			millisEnd = Calendar.getInstance().get(Calendar.MILLISECOND);
			total = (millisEnd - millisStart);
			System.out.println("Total time: "+ total + " ms");
			
			System.out.println("DONE");
		}


}
