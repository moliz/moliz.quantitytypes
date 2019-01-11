package org.modelexecution.quantitytypes.java;

/** This class contains static versions of the operations for type UUnlimitedNaturals
 *  It is required because Esper (a CEP language) can only invoke static operations
 */

public class UUnlimitedNaturals {
	
   
    /**
     * Setters and getters 
     */
    public static int getX(UUnlimitedNatural n) {
		return n.getX(); 
	}
    public static void setX(UUnlimitedNatural n, int x) {
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		n.setX(x); 
	}
    public static double getU(UUnlimitedNatural n) {
		return n.getU();
	}
	public static void setU(UUnlimitedNatural n, double u) {
		if ((n.getX()==-1)&&(u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
		n.setU(u);
	}

 	//// Static operations

	public static UUnlimitedNatural add(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.add(r2);
	}
	
	public static UUnlimitedNatural mult(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.mult(r2);
	}
	public static UUnlimitedNatural divideBy(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.divideBy(r2);
	}

	public static UReal divideByR(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.divideByR(r2);
	}
	
	public static UUnlimitedNatural add(UUnlimitedNatural r1, UUnlimitedNatural r2, double covariance) {
		return r1.add(r2, covariance);
	}
	
	public static UUnlimitedNatural mult(UUnlimitedNatural r1, UUnlimitedNatural r2, double covariance) {
		return r1.mult(r2, covariance);
	}
	public static UUnlimitedNatural divideBy(UUnlimitedNatural r1, UUnlimitedNatural r2, double covariance) {
		return r1.divideBy(r2, covariance);
	}

	public static UReal divideByR(UUnlimitedNatural r1, UUnlimitedNatural r2, double covariance) {
		return r1.divideByR(r2, covariance);
	}


	/***
	 * comparison operations
	 
 	public static boolean lt(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.lt(r2);
	}
 	public static boolean le(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.le(r2);
	}

 	public static boolean ge(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.ge(r2);
	}
 	public static boolean gt(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.gt(r2);
	}
	 */

	public static boolean equals(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.equals(r2);
	}
 	public static boolean distinct(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.distinct(r2);
	}
	/***
	 * comparison operations WITH ZERO = UUnlimitedNatural(0.0)

	public static boolean ltZero(UUnlimitedNatural r1) {
		return r1.ltZero();
	}
	
	public static boolean gtZero(UUnlimitedNatural r1) {
		return r1.gtZero();
	}
	public static boolean leZero(UUnlimitedNatural r1) {
		return r1.leZero();
	}
	public static boolean geZero(UUnlimitedNatural r1) {
		return r1.geZero();
	}
	*/
 	
 	public static boolean equalsZero(UUnlimitedNatural r1) {
		return r1.equalsZero();
	}
	public static boolean distinctZero(UUnlimitedNatural r1) {
		return r1.distinctZero();
	}
	
	/*** FUZZY COMPARISON OPERATIONS
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	
 	public static UBoolean uEquals(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.uEquals(r2);
	}

 	public static UBoolean uDistinct(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.uDistinct(r2);
	}

 	public static UBoolean lt(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.lt(r2);
	}

 	public static UBoolean le(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.le(r2);
	}

 	public static UBoolean ge(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.ge(r2);
	}

 	public static UBoolean gt(UUnlimitedNatural r1, UUnlimitedNatural r2) {
		return r1.gt(r2);
	}

	
	/***
	 * comparison operations WITH ZERO = UInteger(0.0)
	 */
	public static UBoolean ltZero(UUnlimitedNatural r1) {
		return r1.ltZero();
	}
	
	public static UBoolean gtZero(UUnlimitedNatural r1) {
		return r1.gtZero();
	}
	public static UBoolean leZero(UUnlimitedNatural r1) {
		return r1.leZero();
	}
	public static UBoolean geZero(UUnlimitedNatural r1) {
		return r1.geZero();
	}
	public static UBoolean uEqualsZero(UUnlimitedNatural r1) {
		return r1.uEqualsZero();
	}
	public static UBoolean uDistinctZero(UUnlimitedNatural r1) {
		return r1.uDistinctZero();
	}
  
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	public static UUnlimitedNatural min(UUnlimitedNatural r1,UUnlimitedNatural r2) {
		return r1.min(r2);
	}
	public static UUnlimitedNatural max(UUnlimitedNatural r1,UUnlimitedNatural r2) {
		return r1.max(r2);
	}
	/******
	 * Conversions
	 */
	
	public static String toString(UUnlimitedNatural n) {
		return n.toString();
	}

	public static int toInteger(UUnlimitedNatural n){ //
		return n.toInteger();
	}
	
	public static double toReal(UUnlimitedNatural n)  { 
		return n.toReal();
	}
	
	public static UReal toUReal(UUnlimitedNatural n) {
		return n.toUReal();
	}
	public static UInteger toUInteger(UUnlimitedNatural n) {
		return n.toUInteger();
	}

}
