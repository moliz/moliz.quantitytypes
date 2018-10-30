package org.modelexecution.quantitytypes.java;

import java.util.Arrays;
import java.util.Random;

public class N_UInteger implements Cloneable,Comparable<N_UInteger> {
	
	protected final int MAXLENGTH = 100000;
	protected int [] sample = new int [MAXLENGTH];
	private static Random rnd = new Random();

	protected int x = 0; 
	protected double u = 0.0;

	/**
	 * auxiliary methods
	 */
	private void fillSample(int s[], int x1, double u1, Distribution dist) {
		//fills the sample with values from the given distribution
		double d = u1 * Math.sqrt(3);   	
		DistributionGenerator g = new DistributionGenerator();
        switch (dist) {
        	case UNIFORM:
        		for (int i = 0; i < MAXLENGTH; i++) {
        			s[i] = (int) ((x1-d) + 2*d*rnd.nextDouble());
        	    };
        	    break;
        	case NORMAL:
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = (int) (x1 + rnd.nextGaussian() * u1);
	            };
		        break;
            case TRIANGULAR:
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = (int) g.nextTriangular(x1,u1);
	            };
                break;
            case TRUNCATED:
            	double beta = 2/3; //ratio between the lengths of the top of the trapezoid and of the base
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = (int) g.nextTruncated(x1,u1,beta);
	            };
                break;
            case USHAPED:
                for (int i = 0; i < MAXLENGTH; i++) {
   	    	      s[i] = (int) g.nextUShaped(x1,u1);
   	            };
                break;
            // Uniform distribution by deafult
            default:
        		for (int i = 0; i < MAXLENGTH; i++) {
	    	        s[i] = (int) ((x1-d) + 2*d*rnd.nextDouble());
	            }
                break;
        }
	}

    /**
     * Constructors 
     */
    public N_UInteger () {
        this.x = 0; this.u = 0.0;
		Arrays.fill(sample, this.x); 	
   }

	public N_UInteger(int x){ //"promotes" a real x to (x,0) 
		this.x = x; this.u = 0.0;
		Arrays.fill(sample, this.x); 	
	}
  
	//Uniform distribution if no distribution given.
   public N_UInteger (int x, double u) {
        this.x = x; this.u = u;
        fillSample(sample,this.x,this.u,Distribution.UNIFORM);
   }

   public N_UInteger (int s[]) { 
	   sample = Arrays.copyOf(s, s.length);
		int sum = 0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
            sum += sample[i];
            dev += sample[i]*sample[i];
	    }
	    // average
	    x = sum/MAXLENGTH;
	    //standard deviation
	    u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	}


   private N_UInteger (int x, double u, int s[]) { //only for cloning numbers
       this.x = x; this.u = u;
	   sample = Arrays.copyOf(s, s.length);
  }
	
    public N_UInteger(String x) { //creates an UReal from a string representing a real, with u=0.
    	this.x = Integer.parseInt(x);
    	this.u = 0.0;
		Arrays.fill(sample, this.x); 	
  }
    
    public N_UInteger(String x, String u) { //creates an UReal from two strings representing (x,u).
    	this.x = Integer.parseInt(x);
    	this.u = Double.parseDouble(u);
        fillSample(sample,this.x,this.u,Distribution.UNIFORM);
    }
   
    /**
     * Setters and getters 
     */
    public int getX() {
		return x; 
	}
    public void setX(int x) {
		this.x = x; 
	}
    public double getU() {
		return u;
	}
	public void setU(double u) {
		this.u = u;
	}

	protected int[] getSample() { //gets a copy of the sample
		return Arrays.copyOf(sample, sample.length);
	}

   /*********
     * 
     * Type Operations
     */

	
	public N_UInteger add(N_UInteger r) {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] + r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}
	

	public N_UInteger minus(N_UInteger r) {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] - r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}

	
	public N_UInteger mult(N_UInteger r) {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] * r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}
	
	
	public N_UInteger divideBy(N_UInteger r) {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] / r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}
	
	/** this operation returns a UReal
	 */
	public UReal divideByR(N_UInteger r) {
		UReal result = new UReal();
		int sum = 0; 
        double dev = 0.0;
        double x;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	x = this.sample[i] / r.sample[i];
            sum += x;
            dev += x*x;
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}
		
	
	public N_UInteger abs() {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.abs(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}
	
	
	public N_UInteger neg() {
		N_UInteger result = new N_UInteger();
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = - (this.sample[i]);
	    }
	    // average
		result.setX(-this.getX());
	    //standard deviation
		result.setU(this.getU());
		return result;
	}

	
	public N_UInteger power(float s) {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = (int) Math.pow(this.sample[i],s);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
 	}

	
	public N_UInteger sqrt() {
		N_UInteger result = new N_UInteger();
		int sum = 0; 
        double dev = 0.0;
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = (int) Math.sqrt(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX(sum/MAXLENGTH);
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
		return result;
	}

	public N_UInteger inverse() { //inverse (reciprocal)
		return new N_UInteger(1,0.0).divideBy(this);
	}
	
	/***
	 * comparison operations
	 * These operations, that return a boolean, have been superseded by the
	 * corresponding UBoolean-returning operations.
	 * 
	public boolean lt(UInteger r) {
			return this.toUReal().lt(r.toUReal());	
	}

	public boolean le(UInteger r) {
		return (this.lt(r) || this.equals(r));
	}

	public boolean gt(UInteger r) {
		return r.lt(this);
	}

	public boolean ge(UInteger r) {
		return  (this.gt(r) || this.equals(r)); 
	}
	

	public boolean equals(UInteger r) {
		return this.toUReal().equals(r.toUReal());
	}

	public boolean distinct(UInteger r) {
		return ( !(this.equals(r)) );
	}
	 */

	/***
	 * comparison operations WITH ZERO = UInteger(0.0)
	 * 
	 * These operations have been superseded too.

	public boolean ltZero() {
		return this.lt(new UInteger());
	}
	
	
	public boolean leZero() {
		return this.le(new UInteger());
	}

	
	public boolean gtZero() {
		return this.gt(new UInteger());
	}
	
	
	public boolean geZero() {
		return this.ge(new UInteger());
	}
	

	public boolean equalsZero() {
		return this.equals(new UInteger());
	}

	public boolean distinctZero() {
		return this.distinct(new UInteger());
	}
	 */

	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 *   using 1-to-1 comparisons is not fair, due to possible reorderings
	 */
	

	public UBoolean equals(N_UInteger number) {
		return this.toUReal().uEquals(number.toUReal());
	}

	public UBoolean distinct(N_UInteger r) {
		return this.equals(r).not();
	}

	public UBoolean lt(N_UInteger number) {
		return this.toUReal().lt(number.toUReal());
	}
	
	public UBoolean le(N_UInteger number) {
		return this.toUReal().le(number.toUReal());
	}

	public UBoolean gt(N_UInteger number) {
		return this.toUReal().gt(number.toUReal());
	}

	
	public UBoolean ge(N_UInteger number) {
		return this.toUReal().ge(number.toUReal());
	}
   
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS
	 */


	/*** 
	 *   FUZZY COMPARISON OPERATIONS WITH ZERO=UReal(0.0,0.0)
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	

	public UBoolean equalsZero() {
		return this.equals(new N_UInteger());
	}

	public UBoolean distinctZero() {
		return this.distinct(new N_UInteger());
	}

	public UBoolean ltZero() {
		return this.lt(new N_UInteger());
	}
	
	public UBoolean leZero() {
		return this.le(new N_UInteger());
	}

	public UBoolean gtZero() {
		return this.gt(new N_UInteger());
	}

	public UBoolean geZero() {
		return this.ge(new N_UInteger());
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	@Override
	public int compareTo(N_UInteger other) {
		if (this.equals(other).toBoolean()) return 0;
		if (this.lt(other).toBoolean()) return -1;
		return 1;
	}

	public N_UInteger min(N_UInteger r) {
		if (r.lt(this).toBoolean()) return r.clone(); 
		return this.clone();
	}
	public N_UInteger max(N_UInteger r) {
		//if (r>this) r; else this;
		if (r.gt(this).toBoolean()) return r.clone();
		return this.clone();
	}

	/******
	 * Conversions
	 */
	
	public String toString() {
		return "(" + x + "," + u + ") ["+sample[0]+","+sample[1]+","+sample[2]+","+sample[3]+","+sample[4]+"]";
	}
	
	
	public int toInteger(){ //
		return this.getX();
	}
	
	public double toReal()  { 
		return this.getX();
	}
	
	public UReal toUReal() {
		return new UReal(this.getX(),this.getU());
	}

	public UUnlimitedNatural toUUnlimitedNatural() {
		if (this.ltZero().toBoolean()) throw new RuntimeException("Conversion error, from negative UInteger to UUnlimitedNatural"); 
		return new UUnlimitedNatural(this.getX(),this.getU());
	}
	/**
	 * Other Methods 
	 */

 	public int hashcode(){ //required for equals()
		return Math.round((float)x);
	}

 	public N_UInteger clone() {
		return new N_UInteger(this.getX(),this.getU(),this.getSample());
	}



}
