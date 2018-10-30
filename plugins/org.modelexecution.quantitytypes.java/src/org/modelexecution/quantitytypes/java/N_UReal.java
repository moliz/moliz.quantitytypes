package org.modelexecution.quantitytypes.java;

import java.util.Arrays;
import java.util.Random;

public class N_UReal implements Cloneable,Comparable<N_UReal>{
	
	protected final int MAXLENGTH = 100000;
	protected double [] sample = new double [MAXLENGTH];
	private static Random rnd = new Random();

	protected double x = 0.0; 
	protected double u = 0.0;

	/**
	 * auxiliary class
	 */
	class Result {
		double lt;
		double eq;
		double gt;
		
		Result (){
			this.lt = 0.0;
			this.eq= 1.0;
			this.gt = 0.0;
		}
		Result (double l, double e, double g){
			this.lt = l;
			this.eq= e;
			this.gt = g;
		}
		
		Result check(boolean swap){ //swap the values if swap == true
			if (!swap) return this;
			return new Result(this.gt,this.eq,this.lt);
		}
	}

	/**
	 * auxiliary methods
	 */
	private void fillSample(double s[], double x1, double u1, Distribution dist) {
		//fills the sample with values from the given distribution
		double d = u1 * Math.sqrt(3);   	
		DistributionGenerator g = new DistributionGenerator();
        switch (dist) {
        	case UNIFORM:
        		for (int i = 0; i < MAXLENGTH; i++) {
        			s[i] = (x1-d) + 2*d*rnd.nextDouble();
        	    };
        	    break;
        	case NORMAL:
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = x1 + rnd.nextGaussian() * u1;
	            };
		        break;
            case TRIANGULAR:
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = g.nextTriangular(x1,u1);
	            };
                break;
            case TRUNCATED:
            	double beta = 2/3; //ratio between the lengths of the top of the trapezoid and of the base
                for (int i = 0; i < MAXLENGTH; i++) {
	    	      s[i] = g.nextTruncated(x1,u1,beta);
	            };
                break;
            case USHAPED:
                for (int i = 0; i < MAXLENGTH; i++) {
   	    	      s[i] = g.nextUShaped(x1,u1);
   	            };
                break;
            // Uniform distribution by deafult
            default:
        		for (int i = 0; i < MAXLENGTH; i++) {
	    	        s[i] = (x1-d) + 2*d*rnd.nextDouble();
	            }
                break;
        }
	}

	/**
     * Getters (no setters in this case, they are derived!)
     */
    public double getX() {
		return x; 
	}
    public double getU() {
		return u;
	}
	protected double[] getSample() { //gets a copy of the sample
		return Arrays.copyOf(sample, sample.length);
	}
	
	/**
	 * Constructors
	 */
	public N_UReal(){ //no params, sample initialised to 0
		x = 0.0;
		u = 0.0;
		Arrays.fill(sample, x); 	
	}

	public N_UReal(double x){ //"promotes" a real x to (x,0.0) 
		this.x = x;
		u = 0.0;
		Arrays.fill(sample, x); //sample initialised to x	
	}

	//Normal distribution if no distribution given.
	public N_UReal(double x, double u) {
		this.x = x;
		this.u = u;
		fillSample(sample,x,u,Distribution.UNIFORM);
	}

    //creates an N_UReal from two numbers representing (x,u), given a distribution
    public N_UReal(double x, double u, Distribution dist) {
		this.x = x;
		this.u = u;
    	fillSample(sample,x,u,dist);
	}

	//creates x, u from the given sample
    public N_UReal(double s[]) { 
		sample = Arrays.copyOf(s, s.length);
		double sum = 0.0; 
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

    
	private N_UReal(double x, double u, double s[]) { //only for cloning numbers
		this.x = x;
		this.u = u;
		sample = Arrays.copyOf(s, s.length);
	}

    public N_UReal(String x) { //creates an N_UReal from a string representing a real, with u=0.
    	this.x = Double.parseDouble(x);
    	this.u = 0.0;
		Arrays.fill(sample, this.x); //sample initialised to 0	
    }

    public N_UReal(String x, String u) { 
    	//creates an N_UReal from two strings representing (x,u)
    	this.x = Double.parseDouble(x);
    	this.u = Double.parseDouble(u);
    	fillSample(sample,this.x,this.u,Distribution.UNIFORM);
    }

    public N_UReal(String x, String u, Distribution dist) { 
    	//creates an N_UReal from two strings representing (x,u), given a distribution
    	this.x = Double.parseDouble(x);
    	this.u = Double.parseDouble(u);
    	fillSample(sample,this.x,this.u,dist);
    }
    
    /*********
     * 
     * Type Operations
     */

	public N_UReal add(N_UReal r) {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] + r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	    
	    return result;
	}
	
	public N_UReal minus(N_UReal r) {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] - r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	    
	    return result;
	}
	
	public N_UReal mult(N_UReal r) {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] * r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	    
	    return result;
	}
	
	public N_UReal divideBy(N_UReal r) {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] / r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	    
	    return result;
	}

	public N_UReal abs() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.abs(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal neg() {
		N_UReal result = new N_UReal();
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = -this.sample[i];
	    }
	    result.x = -this.x;
	    result.u = this.u;
	
		return result;
	}

	public N_UReal power(float s) {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.pow(this.sample[i],s);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}

	public N_UReal sqrt() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.sqrt(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal sin() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.sin(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal cos() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.cos(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal tan() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.tan(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal asin() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.asin(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal acos() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.acos(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}
	
	public N_UReal atan() {
		N_UReal result = new N_UReal();
		double sum = 0.0; 
        double dev = 0.0;
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = Math.atan(this.sample[i]);
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
	    result.x = sum/MAXLENGTH;
	    //standard deviation
	    result.u = Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1));
	
		return result;
	}

	public N_UReal inverse() { //inverse (reciprocal)
		return new N_UReal(1.0).divideBy(this);
	}
	
	public N_UReal floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u)
		double [] s = getSample();
		double newX = Math.floor(this.getX());
		for (int i=0;i<s.length;i++) {
			s[i] = newX + (s[i] - this.getX()); 
		}
		return new N_UReal(newX,this.getU(),s);
	}
	public N_UReal round(){ //returns (i,u) with i the closest int to x
		double [] s = getSample();
		double newX = Math.round(this.getX());
		for (int i=0;i<s.length;i++) {
			s[i] = newX + (s[i] - this.getX()); 
		}
		return new N_UReal(newX,this.getU(),s);
	}


	/*** 
	 *   CRISP COMPARISON OPERATIONS
	 * 	These operations, that return a boolean, have been superseded by the
	 *  corresponding UBoolean-returning operations -- except equals() and
	 *  distinct, since they have another meaning in Java!.
     */

	//	public boolean lt(N_UReal r) {
	//		boolean result = false;
	//result = (this.getX() < r.getX()) &&
	//           ((this.getX() + this.getU())  < (r.getX() - r.getU()));
	//return result;
	//	}
	//	
	//
	//	public boolean le(N_UReal r) {
	//	boolean result = false;
	//	result = (this.lt(r) || this.equals(r));
	//	return result;
	//}

	//	public boolean gt(N_UReal r) {
	//	boolean result = false;
	//	
	//	result = r.lt(this);
	//	
	//	return result;
	//}
		
	//public boolean ge(N_UReal r) {
	//	boolean result = false;
	//	
	//	result = (this.gt(r) || this.equals(r)); 
	//	
	//	return result;
	//}
	
	public boolean equals(N_UReal r) {
		boolean result = false;
		
		double a = Math.max((this.getX() - this.getU()), (r.getX() - r.getU()));
		double b = Math.min((this.getX() + this.getU()), (r.getX() + r.getU()));
		result = (a <= b);
		
		return result;
	}

	public boolean distinct(N_UReal r) {
		boolean result = false;
		
		result =  ( !(this.equals(r)) );
		
		return result;
	}
	
	/***
	 * comparison operations WITH ZERO = UReal(0.0)
	 */
	//public boolean ltZero() {
	//	return this.lt(new N_UReal());
	//}
		
	//public boolean leZero() {
	//	return this.le(new N_UReal());
	//}
	
	//public boolean gtZero() {
	//	return this.gt(new N_UReal());
	//}
	//	
	//public boolean geZero() {
	//	return this.ge(new N_UReal());
	//}
	
	public boolean equalsZero() {
		return this.equals(new N_UReal());
	}

	public boolean distinctZero() {
		return this.distinct(new N_UReal());
	}


	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 */

    /** 
     * This method returns three numbers (lt, eq, gt) with the probabilities that 
     * lt: this < number, 
     * eq: this = number
     * gt: this > number
     */
	private Result calculate(N_UReal number) {
		Result res = new Result(0.0,0.0,0.0);
	
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	if (this.sample[i] < number.sample[i]) res.lt++;
	    	else if (this.sample[i] > number.sample[i]) res.gt++;
	    	else res.eq++;
	    };
	    res.lt = res.lt/MAXLENGTH;
	    res.gt = res.gt/MAXLENGTH;
	    res.eq = 1.0 - (res.lt+res.gt);
	    return res;
	}
	
	public UBoolean uEquals(N_UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.eq);
	}

	public UBoolean uDistinct(N_UReal r) {
		return this.uEquals(r).not();
	}

	public UBoolean lt(N_UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.lt);
	}
	
	public UBoolean le(N_UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true, r.lt+r.eq);
	}

	public UBoolean gt(N_UReal number) {
		Result r = this.calculate(number);
		return new UBoolean (true, r.gt);
	}

	
	public UBoolean ge(N_UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.gt+r.eq);
	}

	/*** 
	 *   FUZZY COMPARISON OPERATIONS WITH ZERO=UReal(0.0,0.0)
	 */


	public UBoolean uEqualsZero() {
		return this.uEquals(new N_UReal());
	}

	public UBoolean uDistinctZero() {
		return this.uDistinct(new N_UReal());
	}

	public UBoolean uLtZero() {
		return this.lt(new N_UReal());
	}
	
	public UBoolean uLeZero() {
		return this.le(new N_UReal());
	}

	public UBoolean uGtZero() {
		return this.gt(new N_UReal());
	}

	public UBoolean uGeZero() {
		return this.ge(new N_UReal());
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS
	 */

	
	
	@Override
	public int compareTo(N_UReal other) {
		if (this.equals(other)) return 0;
		if (this.lt(other).toBoolean()) return -1;
		return 1;
	}
	
	
	public N_UReal min(N_UReal r) {
		if (r.lt(this).toBoolean()) return r.clone(); 
		return this.clone();
	}
	public N_UReal max(N_UReal r) {
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
		return (int)Math.floor(this.getX());
	}
	
	public double toReal()  { 
		return this.getX();
	}
	
	
	/**
	 * Other Methods 
	 */

 	public int hashcode(){ //required for equals()
		return Math.round((float)x);
	}


	public N_UReal clone() {
		return new N_UReal(this.getX(),this.getU(),this.sample);
	}
}
