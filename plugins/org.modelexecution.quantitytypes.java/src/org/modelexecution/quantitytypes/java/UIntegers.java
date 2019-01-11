package org.modelexecution.quantitytypes.java;

/** This class contains static versions of the operations for type UInteger
 *  It is required because Esper (a CEP language) can only invoke static operations
 */

public class UIntegers  {
	
    /**
     * Setters and getters 
     */
    public static int getX(UInteger n) {
		return n.getX(); 
	}
    public void setX(UInteger n, int x) {
		n.setX(x);
	}
    public double getU(UInteger n) {
		return n.getU();
	}
	public void setU(UInteger n, double u) {
		n.setU(u);
	}

    /*********
     * 
     * STATIC Operations
     */

	
	public static UInteger add(UInteger r1, UInteger r2) {
		return r1.add(r2);
	}
	public static UInteger minus(UInteger r1, UInteger r2) {
		return r1.minus(r2);
	}
	public static UInteger mult(UInteger r1, UInteger r2) {
		return r1.mult(r2);
	}
	public static UInteger divideBy(UInteger r1, UInteger r2) {
		return r1.divideBy(r2);
	}
	public static UReal divideByR(UInteger r1, UInteger r2) {
		return r1.divideByR(r2);
	}
	public static UInteger add(UInteger r1, UInteger r2, double covariance) {
		return r1.add(r2, covariance);
	}
	public static UInteger minus(UInteger r1, UInteger r2, double covariance) {
		return r1.minus(r2, covariance);
	}
	public static UInteger mult(UInteger r1, UInteger r2, double covariance) {
		return r1.mult(r2, covariance);
	}
	public static UInteger divideBy(UInteger r1, UInteger r2, double covariance) {
		return r1.divideBy(r2, covariance);
	}
	public static UReal divideByR(UInteger r1, UInteger r2, double covariance) {
		return r1.divideByR(r2, covariance);
	}
	public static UInteger abs(UInteger r1) {
		return r1.abs();
	}
	public static UInteger neg(UInteger r1) {
		return r1.neg();
	}
	public static UInteger power(UInteger r1, float s) {
		return r1.power(s);
	}
	public static UInteger sqrt(UInteger r1) {
		return r1.sqrt();
	}
	public static UInteger inverse(UInteger r1) {
		return r1.inverse();
	}
	
	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	

	public static UBoolean lt(UInteger r1, UInteger r2) {
		return r1.lt(r2);
	}
	public static UBoolean le(UInteger r1, UInteger r2) {
		return r1.le(r2);
	}
	public static UBoolean gt(UInteger r1, UInteger r2) {
		return r1.gt(r2);
	}
	public static UBoolean ge(UInteger r1, UInteger r2) {
		return r1.ge(r2);
	}
	public static UBoolean equals(UInteger r1, UInteger r2) {
		return r1.equals(r2);
	}
	public static UBoolean distinct(UInteger r1, UInteger r2) {
		return r1.distinct(r2);
	}
	/***
	 * comparison operations WITH ZERO = UInteger(0.0)
	 */
	public static UBoolean ltZero(UInteger r1) {
		return r1.ltZero();
	}
	public static UBoolean leZero(UInteger r1) {
		return r1.leZero();
	}
	public static UBoolean gtZero(UInteger r1) {
		return r1.gtZero();
	}
	public static UBoolean geZero(UInteger r1) {
		return r1.geZero();
	}
	public static UBoolean equalsZero(UInteger r1) {
		return r1.equalsZero();
	}
	public static UBoolean distinctZero(UInteger r1) {
		return r1.distinctZero();
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	public static  UInteger min(UInteger r1, UInteger r2) {
		return r1.min(r2);
	}
	public static  UInteger max(UInteger r1, UInteger r2) {
		return r1.max(r2);
	}


	/******
	 * Conversions
	 */
	
	public static String toString(UInteger n) {
		return n.toString();
	}
	
	
	public static int toInteger(UInteger n){ //
		return n.toInteger();
	}
	
	public static double toReal(UInteger n)  { 
		return n.toReal();
	}
	
	public static UReal toUReal(UInteger n) {
		return n.toUReal();
	}

	public static UUnlimitedNatural toUUnlimitedNatural(UInteger n) {
		return n.toUUnlimitedNatural();
	}

}
