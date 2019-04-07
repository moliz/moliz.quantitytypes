package org.modelexecution.quantitytypes.java.test;


import java.util.Calendar;

import org.modelexecution.quantitytypes.java.*;

public class TestUReal {
	
	static void showCompare(String error, UReal a, UReal b){
		System.out.println(error);
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		
		System.out.println("a Equals b: "+a.equals(b));
		System.out.println("a LessThan b: "+a.lt(b).toBoolean());
		System.out.println("a GreaterThan b: "+a.gt(b).toBoolean());
		System.out.println("p(a Equals b): "+a.uEquals(b));
		System.out.println("p(a LessThan b): "+a.lt(b));
		System.out.println("p(a GreaterThan b): "+a.gt(b));
		System.out.println("p(a LessEq b): "+a.le(b));
		System.out.println("p(a GreaterEq b): "+a.ge(b));
	}

		public static void main(String[] args) {
			
		UReal a,b,c,d,e,f,g,h,i;
		
		a = new UReal(5.0,1.0);
		b = new UReal(1.0,1.5);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
		if (a.gt(b).getC() < 0.00001)showCompare("gt",a,b);

		a = new UReal(1.0,1.0);
		b = new UReal(1.0,1.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()<0.99999) showCompare("not equals",a,b);
		if (a.gt(b).getC() > 0.00001)showCompare("gt",a,b);

		a = new UReal(1.0,7.0);
		b = new UReal(1.0,2.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.26) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()<0.4) showCompare("not equals",a,b);
		if (a.gt(b).getC() < .26)showCompare("gt",a,b);

		a = new UReal(1.0,1.0);
		b = new UReal(10.0,2.0);
 //		showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.99) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() > 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .001)showCompare("gt",a,b);

		a = new UReal(1.0,1.0);
		b = new UReal(50.0,2.0);
 //	showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.99) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() > 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .001)showCompare("gt",a,b);

		a = new UReal(1.0,3.0);
		b = new UReal(1.5,3.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() >.1) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() < 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .1)showCompare("gt",a,b);

		a = new UReal(1.0,3.0);
		b = new UReal(1.5,5.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() >.2) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() < 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .1)showCompare("gt",a,b);

		/****
		 * CAMBIOS
		 * 
		 */
		
		a = new UReal(5.0,1.5);
		b = new UReal(1.0,1.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
		if (a.gt(b).getC() < 0.00001)showCompare("gt",a,b);

		a = new UReal(1.0,1.0);
		b = new UReal(1.0,1.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()<0.99999) showCompare("not equals",a,b);
		if (a.gt(b).getC() > 0.00001)showCompare("gt",a,b);

		a = new UReal(1.0,2.0);
		b = new UReal(1.0,7.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.26) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()<0.4) showCompare("not equals",a,b);
		if (a.gt(b).getC() < .26)showCompare("gt",a,b);

		a = new UReal(1.0,2.0);
		b = new UReal(10.0,1.0);
 //		showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.99) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() > 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .001)showCompare("gt",a,b);

		a = new UReal(1.0,2.0);
		b = new UReal(50.0,1.0);
 //	showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() <.99) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() > 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .001)showCompare("gt",a,b);

		a = new UReal(1.5,3.0);
		b = new UReal(1.0,3.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() >.1) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() < 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .1)showCompare("gt",a,b);

		a = new UReal(1.0,5.0);
		b = new UReal(1.5,3.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() >.2) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC() < 0.1) showCompare("equals",a,b);
		if (a.gt(b).getC() > .1)showCompare("gt",a,b);

		/***
		 * PATHOLOGICAL CASES
		 */
		a = new UReal(5.0,0.0);
		b = new UReal(1.0,0.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
		if (a.gt(b).getC() < 0.00001)showCompare("gt",a,b);

		a = new UReal(1.0,0.0);
		b = new UReal(5.0,0.0);
 //		showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() < 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
		if (a.gt(b).getC() > 0.00001)showCompare("gt",a,b);

		a = new UReal(5.0,0.0);
		b = new UReal(5.0,0.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.00001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()< 0.0001) showCompare("not equals",a,b);
		if (a.gt(b).getC() > 0.00001)showCompare("gt",a,b);

	/**
	 *  s1 = 0	
	 */
		a = new UReal(5.0,0.0);
		b = new UReal(1.0,1.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
 		if (a.gt(b).getC()< 0.001)showCompare("Ugt",a,b);

		a = new UReal(5.0,1.0);
		b = new UReal(1.0,0.0);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
 		if (a.gt(b).getC() < 0.001)showCompare("Ugt",a,b);

		a = new UReal(4.0,1.0);
		b = new UReal(4.0,0.0);
 //	showCompare("",a,b);
        if (!a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() < 0.001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.1) showCompare("not equals",a,b);
		if (a.gt(b).getC() < 0.001)showCompare("U gt",a,b);

		a = new UReal(4.0,0.0);
		b = new UReal(4.0,1.0);
 //	showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() < 0.001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.1) showCompare("not equals",a,b);
		if (a.gt(b).getC() < 0.001)showCompare("U gt",a,b);

		a = new UReal(1.0,0.0);
		b = new UReal(5.0,0.0);
		//showCompare("", a, b);
		
		a = new UReal(-2.0,0.01);
		b = new UReal(-2.0,0.01);
//		System.out.println(a.divideBy(b));

		a = new UReal(2.5,0.1);
		b = new UReal(2.0,0.1);
 //		showCompare("",a,b);
        if (a.lt(b).toBoolean()) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (!a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.lt(b).getC() > 0.001) showCompare("U less than",a,b);
 		if (a.uEquals(b).getC()> 0.2) showCompare("not equals",a,b);
 		if (a.gt(b).getC() < 0.001)showCompare("Ugt",a,b);
	
		UBoolean b1 = new UBoolean(true,0.4);
		UBoolean b2 = new UBoolean(true,0.8);
		System.out.println(b1.implies(b2));
		System.out.println(b1.not().or(b2));
		

 		

//		showCompare("",a,b);
/**
 *		// real numbers
		a = new UReal(1.0,0.0);
		b = new UReal(2.0,0.0);
 //		showCompare("",a,b);
        if (!a.lessThan(b)) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.U_lessThan(b)!=1.0) showCompare("U less than",a,b);
        if (a.U_lessEq(b)!=1.0) showCompare("U lessEq",a,b);
		if (a.U_equals(b)!=0.0) showCompare("not equals",a,b);
		if (a.U_gt(b)!=0.0)showCompare("gt",a,b);
		if (a.U_ge(b)!=0.0)showCompare("ge",a,b);
		
		// real numbers
		a = new UReal(1.0,0.00001);
		b = new UReal(2.0,0.00001);
//		showCompare("",a,b);
        if (!a.lessThan(b)) showCompare("less than",a,b);
		if (a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.U_lessThan(b)!=1.0) showCompare("U less than",a,b);
        if (a.U_lessEq(b)!=1.0) showCompare("U lessEq",a,b);
		if (a.U_equals(b)!=0.0) showCompare("not equals",a,b);
		if (a.U_gt(b)!=0.0)showCompare("gt",a,b);
		if (a.U_ge(b)!=0.0)showCompare("ge",a,b);
		
		// real numbers
		a = new UReal(1.0,0.0);
		b = new UReal(1.0,0.0);
//		showCompare("",a,b);
        if (a.lessThan(b)) showCompare("less than",a,b);
		if (!a.equals(b)) showCompare("equals",a,b);
		if (a.gt(b).toBoolean())showCompare("gt",a,b);
        if (a.U_lessThan(b)!=0.0) showCompare("U less than",a,b);
        if (a.U_lessEq(b)!=1.0) showCompare("U lessEq",a,b);
		if (a.U_equals(b)!=1.0) showCompare("not equals",a,b);
		if (a.U_gt(b)!=0.0)showCompare("gt",a,b);
		if (a.U_ge(b)!=1.0)showCompare("ge",a,b);


/**
 * 		
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
			
			UReal x = v.divideBy(v);
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

			Quantity initialPosition = new Quantity( 0, 0.000, Units.M);
			Quantity finalPosition	 = new Quantity(10, 0.001, Units.M);
			Quantity duration        = new Quantity(10, 0.002, new Unit(BaseUnits.Second));
			Quantity initialVelocity = new Quantity( 0, 0.000, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			Quantity finalVelocity   = new Quantity( 2, 0.200, new Unit("MeterPerSecond", "m/s", BaseUnits.Meter, 1.0, 1.0, 0.0, BaseUnits.Second, -1.0, 1.0));
			
			// computed values
			Quantity distance        = finalPosition.minus(initialPosition);
			Quantity avgVelocity     = distance.divideBy(duration);
			Quantity avgAcceleration = (finalVelocity.minus(initialVelocity)).divideBy(duration);

			
			System.out.println("distance"+distance);
			System.out.println("avgVelocity"+avgVelocity);
			System.out.println("avgAcceleration"+avgAcceleration);
			System.out.println("avgAcceleration"+avgAcceleration.convertTo(Units.CentimeterPerSecondSquared));

			System.out.println("distance"+distance);
			System.out.println("avgVelocity"+avgVelocity);

			Length c	 = new Length(10, 0.0, Units.Inch);
			Length d   = new Length( 2, 0.0, Units.Centimeter);

			System.out.println("c: "+c);
			System.out.println("d: "+d);

			System.out.println("c/d: "+c.divideBy(d));

			c	 = new Length(10, 0.0, Units.Foot);
			d   = new Length( 2, 0.0, Units.Foot);

			System.out.println("c: "+c);
			System.out.println("d: "+d);

			System.out.println("c/d: "+c.divideBy(d));
			System.out.println("c/d: "+new Quantity(c.divideBy(d)));

			
			millisEnd = Calendar.getInstance().get(Calendar.MILLISECOND);
			total = (millisEnd - millisStart);
			System.out.println("Total time: "+ total + " ms");
			
			System.out.println("DONE");
 */
			}


}
