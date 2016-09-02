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

			 
			System.out.println(m[0].divideBy(m[0]).sMult(2.0));
			System.out.println(m[0].divideBy(m[0]).sMult(2.0));

			System.out.println(m[0].divideBy(m[0]).sMult(2.0).equals(m[0].divideBy(m[0]).sAdd(1.0)));

			System.out.println(m[7].mult(m[0]));
			System.out.println(m[6].divideBy(m[1]));
			
			System.out.println((new SIUnit(BaseUnits.Meter, 1.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 4.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.5)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.0)).isBaseUnit());
			System.out.println((new SIUnit(BaseUnits.Meter, 1.0)).isDimensionless());
			System.out.println((new SIUnit(BaseUnits.Meter, 0.0)).isDimensionless());
			System.out.println((new SIUnit()).isDimensionless());
			System.out.println((new SIUnit()).isBaseUnit());


			
			
			Quantity A = new Quantity(50.0, 0.0001, CommonUnits.MH);
			Quantity B = new Quantity(3.0, 0.0, new Unit("KilometerPerMinute", "km/min", BaseUnits.Meter, 1.0, 1000.0, 0.0, BaseUnits.Second, -1.0, 60.0));
			System.out.println("A+B: "+A.add(B));
			System.out.println("B+A: "+B.add(A));
			System.out.println("B+A-SI: "+A.add(B).convertToSIUnits());

			
			
			Quantity qkm = new Quantity(1.0, 0.0, CommonUnits.KM);
			Quantity qm = new Quantity(1.0, 0.0, CommonUnits.M);
			Quantity qmile = new Quantity(1.0, 0.0, CommonUnits.MILE);
			Quantity qyard = new Quantity(1.0, 0.0, CommonUnits.YARD);
			Quantity qfeet = new Quantity(1.0, 0.0, CommonUnits.FT);
			Quantity qinch = new Quantity(1.0, 0.0, CommonUnits.INCH);

			Quantity qms = new Quantity(1.0, 0.000, new Unit(DerivedUnits.MeterPerSecond));
			Quantity qkms = new Quantity(1.0, 0.000, CommonUnits.KMS);
			Quantity qkms2 = new Quantity(1.00, 0.000, CommonUnits.KMS2);
			Quantity qkmh = new Quantity(1.0,0.000,CommonUnits.KMH);
			Quantity qkmh2 = new Quantity(1.0,0.000,CommonUnits.KMH2);

			Quantity k = new Quantity(1.0, 0.00, new Unit(BaseUnits.Kelvin));
			Quantity c = new Quantity(1.0,0.000,CommonUnits.CELSIUS);
			Quantity f = new Quantity(1.0,0.00,CommonUnits.FARENHEIT);
			
			Quantity dc = new Quantity(1.0,0.000,CommonUnits.DeltaCELSIUS);
			Quantity df = new Quantity(1.0,0.00,CommonUnits.DeltaFARENHEIT);

			System.out.println("1K . K: "+k.add(k));
			System.out.println("1K - K: "+k.minus(k));
			System.out.println("1K * K: "+k.mult(k));
			System.out.println("1K / K: "+k.divideBy(k));

			 Quantity  K1 = new Quantity(10.0, 0.000, CommonUnits.KELVIN);
			 Quantity  K2 = new Quantity(5.0, 0.000, CommonUnits.KELVIN);
			 System.out.println("K1 minus K2: "+K1.minus(K2));
			   
			 Quantity  F1 = new Quantity(10.0, 0.000, CommonUnits.FARENHEIT);
			 Quantity  C1 = new Quantity(5.0, 0.000, CommonUnits.CELSIUS);
			 System.out.println("C1 minus C1: "+C1.minus(C1));
			 System.out.println("F1 minus F1: "+F1.minus(F1));
			 System.out.println("C1 minus F1: "+C1.minus(F1));
			 System.out.println("F1 minus C1: "+F1.minus(C1));
//ERROR			 System.out.println("K1 minus F1: "+K1.minus(F1)); -- checked
//ERROR			 System.out.println("K1 minus C1: "+K1.minus(C1));  -- checked
//ERROR			 System.out.println("F1 minus K1: "+K1.minus(F1));  -- checked
		 System.out.println("C1 minus K1: "+K1.minus(C1));  // checked
			 
			 Quantity  q3 = new Quantity(10.0, 0.000, CommonUnits.KELVIN);
			 Quantity  q4 = new Quantity(5.0, 0.000, CommonUnits.KELVIN);
			 System.out.println("Q3 minus Q4: "+q3.minus(q4));

			 System.out.println("1K to K: "+k.convertToSIUnits());
			System.out.println("1K to K: "+k.convertFromSIUnits(k.convertToSIUnits().value));
			System.out.println("1K to K: "+k.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1K to F: "+k.convertTo(CommonUnits.FARENHEIT));
			System.out.println("1K to C: "+k.convertTo(CommonUnits.CELSIUS));

			System.out.println("1C to K: "+c.convertToSIUnits());
			System.out.println("1C to K: "+c.convertTo(new Unit(BaseUnits.Kelvin)));
			
			System.out.println("1F to K: "+f.convertToSIUnits());
			System.out.println("1F to K: "+f.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1C to C: "+c.convertFromSIUnits(c.convertToSIUnits().value));
			System.out.println("1C to C: "+c.convertTo(CommonUnits.CELSIUS));


			System.out.println("1F to F: "+f.convertFromSIUnits(f.convertToSIUnits().value));
			System.out.println("1F to F: "+f.convertTo(CommonUnits.FARENHEIT));

			System.out.println("1F to C: "+f.convertTo(CommonUnits.CELSIUS));
			System.out.println("1C to F: "+c.convertTo(CommonUnits.FARENHEIT));

			
/////////////////
			System.out.println("1K to DF: "+k.convertTo(CommonUnits.DeltaFARENHEIT));
			System.out.println("1K to DC: "+k.convertTo(CommonUnits.DeltaCELSIUS));

			System.out.println("1DC to K: "+dc.convertToSIUnits());
			System.out.println("1DC to K: "+dc.convertTo(new Unit(BaseUnits.Kelvin)));
			
			System.out.println("1DF to K: "+df.convertToSIUnits());
			System.out.println("1DF to K: "+df.convertTo(new Unit(BaseUnits.Kelvin)));

			System.out.println("1DC to C: "+c.convertFromSIUnits(dc.convertToSIUnits().value));
			System.out.println("1DC to C: "+c.convertTo(CommonUnits.DeltaCELSIUS));

			System.out.println("1DC to DC: "+dc.convertFromSIUnits(dc.convertToSIUnits().value));
			System.out.println("1DC to DC: "+dc.convertTo(CommonUnits.DeltaCELSIUS));

			System.out.println("1DF to DF: "+df.convertFromSIUnits(df.convertToSIUnits().value));
			System.out.println("1DF to DF: "+df.convertTo(CommonUnits.DeltaFARENHEIT));

			System.out.println("1DF to F: "+f.convertFromSIUnits(df.convertToSIUnits().value));
			System.out.println("1DF to F: "+f.convertTo(CommonUnits.DeltaFARENHEIT));

			System.out.println("1DF to DC: "+df.convertTo(CommonUnits.DeltaCELSIUS));
			System.out.println("1DC to DF: "+dc.convertTo(CommonUnits.DeltaFARENHEIT));

			System.out.println("1DF to C: "+df.convertTo(CommonUnits.CELSIUS));
			System.out.println("1DC to F: "+dc.convertTo(CommonUnits.FARENHEIT));
			System.out.println("1F to DC: "+f.convertTo(CommonUnits.DeltaCELSIUS));
			System.out.println("1C to DF: "+c.convertTo(CommonUnits.DeltaFARENHEIT));
			
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

			System.out.println("1KM to M: "+qkm.convertTo(CommonUnits.M));
			System.out.println("1M to KM: "+qm.convertTo(CommonUnits.KM));
			
			System.out.println("1M to KM to M: "+qm.convertTo(CommonUnits.KM).convertTo(CommonUnits.M));
			System.out.println("1KM to M to KM: "+qkm.convertTo(CommonUnits.M).convertTo(CommonUnits.KM));
			System.out.println("1KM to KM: "+qkm.convertTo(CommonUnits.KM));
			System.out.println("1M to M: "+qm.convertTo(CommonUnits.M));
			
			

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

			System.out.println("1KMK * 2: "+qkmh.sMult(2.0));

			System.out.println("1KMS2 + 1KMH2: "+qkms2.add(qkmh2));
			System.out.println("1KMS - 1KMH: "+qkms.minus(qkmh));
			System.out.println("1M - 1KM: "+qm.minus(qkm));
			System.out.println("1KMS to MS: "+qkms.convertTo(new Unit(DerivedUnits.MeterPerSecond)));
			System.out.println("1KMH to MS: "+qkmh.convertTo(new Unit(DerivedUnits.MeterPerSecond)));
			System.out.println("1KMS2 to MS2: "+qkms2.convertTo(new Unit(DerivedUnits.MeterPerSecondSquared)));
			System.out.println("1KMH2 to MS2: "+qkmh2.convertTo(new Unit(DerivedUnits.MeterPerSecondSquared)));


			millisEnd = Calendar.getInstance().get(Calendar.MILLISECOND);
			total = (millisEnd - millisStart);
			System.out.println("Total time: "+ total + " ms");
			
			System.out.println("DONE");
		}


}
