package org.modelexecution.quantitytypes.java;


import java.util.Calendar;

public class TestLength {
	

		public static void main(String[] args) {
		
		
//			System.out.println("Loading sample...");
			long millisStart = Calendar.getInstance().get(Calendar.MILLISECOND);
			long millisEnd;
			float total;
			
			Quantity radius = new Quantity(30, 0.000, Units.Centimeter);
			Quantity multi = new Quantity(2 * Math.PI);
			Quantity circumference = radius.mult(multi);
			System.out.println(circumference);
	
			System.out.println(circumference.convertTo(Units.Centimeter));
			Quantity area = (radius.mult(radius)).mult(new Quantity(Math.PI));

			System.out.println(area);
			System.out.println(area.convertTo(Units.SquareCentimeter));
			
			
			Length lf = new Length(1.0,0.001,Units.Foot);
			Length lm = new Length(1.0,0.001,Units.Centimeter);
			Time t = new Time(1.0,0.001);
			Time s = new Time(new Quantity(1.0,0.001,Units.Hour));
			LinearVelocity v = lf.divideBy(s);
			LinearAcceleration a = v.divideBy(s);
			
			Quantity x = v.divideBy(v);
			System.out.println("x: "+x);
			
			
			System.out.println("LF"+lf);
			System.out.println("LM"+lm);
			System.out.println("S"+s);
			System.out.println("V"+v);
			System.out.println("V"+lf.divideBy(s));
			
			System.out.println("A"+a);
			System.out.println("A"+v.divideBy(s));
			System.out.println("A"+lf.divideBy(s).divideBy(s));
			
			Length initialPosition = new Length(0,0,Units.Centimeter);
			Length finalPosition = new Length(10.0, 0.001,Units.Centimeter);
			Time duration        = new Time(10.0, 0.002);
			LinearVelocity initialVelocity = new LinearVelocity();
			LinearVelocity finalVelocity   = new LinearVelocity(2, 0.2);
			
			// computed values
			Length distance        = finalPosition.minus(initialPosition);
			LinearVelocity avgVelocity     = distance.divideBy(duration);
			LinearAcceleration avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);
	
			Quantity q1 = new Quantity(10.0, 0.000, Units.Celsius);
			Quantity q2 = new Quantity(5.0, 0.000, Units.Celsius);
			
			Quantity q3 = new Quantity(10.0, 0.000, Units.Kelvin);
			Quantity q4 = new Quantity( 5.0, 0.000, Units.Kelvin);
			
			Quantity q5 = new Quantity( 5.0, 0.000, Units.DeltaCelsius);

			System.out.println("10C+5deltaC must be 15C"+q1.add(q5));
			
			// Testing the return type to be delta type
			System.out.println("Celsius?"+ q1.add(q5).getUnits().name());

/**
 * 
			Quantity initialPosition = new Quantity( 0, 0.000, Units.M);
			Quantity finalPosition	 = new Quantity(10, 0.001, Units.M);
			Quantity duration        = new Quantity(10, 0.002, new Unit(BaseUnits.Second));
			Quantity initialVelocity = new Quantity( 0, 0.000, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			Quantity finalVelocity   = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			
			// computed values
			Quantity distance        = finalPosition.minus(initialPosition);
			Quantity avgVelocity     = distance.divideBy(duration);
			Quantity avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);
 */
			
			System.out.println("distance"+distance);
			System.out.println("avgVelocity"+avgVelocity);
			System.out.println("avgAcceleration"+avgAcceleration);
			System.out.println("avgAcceleration"+avgAcceleration.convertTo(Units.CentimeterPerSecondSquared));


			millisEnd = Calendar.getInstance().get(Calendar.MILLISECOND);
			total = (millisEnd - millisStart);
			System.out.println("Total time: "+ total + " ms");
			
			System.out.println("DONE");
		}


}
