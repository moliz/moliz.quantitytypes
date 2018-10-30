package org.modelexecution.quantitytypes.java;

import java.util.Arrays;
import java.util.Random;


public class N_UUnlimitedNatural implements Cloneable,Comparable<N_UUnlimitedNatural> {
	
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
    public N_UUnlimitedNatural () {
        this.x = 0; this.u = 0.0;
		Arrays.fill(sample, x); 	
   }

	public N_UUnlimitedNatural(int x){ //"promotes" a real x to (x,0) 
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		this.x = x; this.u = 0.0;
		Arrays.fill(sample, x); 	
	}
  
    public N_UUnlimitedNatural (int x, double u) {
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		if ((x==-1)&&(u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
        this.x = x; this.u = u;
        fillSample(sample,x,u,Distribution.UNIFORM);
    }
	
    public N_UUnlimitedNatural(int x, double u, Distribution dist) {
 		this.x = x;
 		this.u = u;
     	fillSample(sample,x,u,dist);
 	}

    
 	public N_UUnlimitedNatural(int s[]) { 
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
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 

 	}  
    
 	private N_UUnlimitedNatural(int x, double u, int s[]) { //only for cloning numbers
 		this.x = x;
 		this.u = u;
 		sample = Arrays.copyOf(s, s.length);
 	}

    public N_UUnlimitedNatural(String x) { //creates an UReal from a string representing a real, with u=0.
    	this.x = Integer.parseInt(x);
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
    	this.u = 0.0;
		Arrays.fill(sample, this.x); 	
    }
    
    public N_UUnlimitedNatural(String x, String u) { //creates an UReal from two strings representing (x,u).
    	this.x = Integer.parseInt(x);
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
    	this.u = Double.parseDouble(u);
		if ((this.x==-1)&&(this.u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
        fillSample(sample,this.x,this.u,Distribution.UNIFORM);
    }

    public N_UUnlimitedNatural(String x, String u, int s[]) { //creates an UReal from two strings representing (x,u).
    	this.x = Integer.parseInt(x);
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
    	this.u = Double.parseDouble(u);
		if ((this.x==-1)&&(this.u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
 		sample = Arrays.copyOf(s, s.length);
    }

    /**
     * Setters and getters 
     */
    public int getX() {
		return x; 
	}
    public void setX(int x) {
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		this.x = x; 
	}
    public double getU() {
		return u;
	}
	public void setU(double u) {
		this.u = u;
		if ((this.x==-1)&&(u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
	}

	protected int[] getSample() { //gets a copy of the sample
		return Arrays.copyOf(sample, sample.length);
	}

	/*********
     * 
     * Type Operations
     */

	
	public N_UUnlimitedNatural add(N_UUnlimitedNatural r) {

		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 

		N_UUnlimitedNatural result = new N_UUnlimitedNatural();
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
	

/** no minus for UUnlimitedNatural
 	public UUnlimitedNatural minus(UUnlimitedNatural r) {
 		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid minus with *"); 
		UUnlimitedNatural result = new UUnlimitedNatural();
			result.setX(this.getX() - r.getX());
			result.setU(Math.sqrt((this.getU()*this.getU()) + (r.getU()*r.getU())));
			return result;
	}
*/

	
	public N_UUnlimitedNatural mult(N_UUnlimitedNatural r) {

		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid mult with *"); 

		N_UUnlimitedNatural result = new N_UUnlimitedNatural();
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
	
	
	public N_UUnlimitedNatural divideBy(N_UUnlimitedNatural r) {
		N_UUnlimitedNatural result = new N_UUnlimitedNatural();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
		int sum = 0; 
        double dev = 0.0;
		
	    for (int i = 0; i < MAXLENGTH; i++) {
	    	result.sample[i] = this.sample[i] / r.sample[i];
            sum += result.sample[i];
            dev += result.sample[i]*result.sample[i];
	    }
	    // average
		result.setX((int)Math.floor(sum/MAXLENGTH));
	    //standard deviation
		result.setU(Math.sqrt(Math.abs(dev-(sum*sum/MAXLENGTH))/(MAXLENGTH-1)));
	    
		return result;
	}
		
	public UReal divideByR(N_UUnlimitedNatural r) {
		UReal result = new UReal();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
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
		

	/***
	 * comparison operations
	 * These operations, exept equals and distinct, have been replaced by
	 * the corresponding lifted operations to UBoolean
	 */
//	public boolean lt(UUnlimitedNatural r) {
	//		if ((this.getX()==-1)) return false;
	//	if ((r.getX()==-1)) return true;
	//	return this.toUReal().lt(r.toUReal());	
	//}
	//
	//public boolean le(UUnlimitedNatural r) {
	//	if ((r.getX()==-1)) return true;
	//	if ((this.getX()==-1)) return false;
	//	return (this.lt(r) || this.equals(r));
	//}
	//
	//public boolean gt(UUnlimitedNatural r) {
	//	return r.lt(this);
	//}
	//
	//public boolean ge(UUnlimitedNatural r) {
	//	return  (this.gt(r) || this.equals(r)); 
	//}
	
	public boolean equals(N_UUnlimitedNatural r) {
		return this.toUReal().equals(r.toUReal());
	}

	public boolean distinct(N_UUnlimitedNatural r) {
		return ( !(this.equals(r)) );
	}

	/***
	 * comparison operations WITH ZERO = UInteger(0.0)
	 * These have also been superseded.
	 */
	//public boolean ltZero() {
	//	return this.lt(new UUnlimitedNatural());
	//}
	//
	//public boolean leZero() {
	//	return this.le(new UUnlimitedNatural());
	//}
	//
	//public boolean gtZero() {
	//	return this.gt(new UUnlimitedNatural());
	//}
	//	
	//	
	//public boolean geZero() {
	//	return this.ge(new UUnlimitedNatural());
	//}
	//	
	public boolean equalsZero() {
		return this.equals(new N_UUnlimitedNatural());
	}

	public boolean distinctZero() {
		return this.distinct(new N_UUnlimitedNatural());
	}

	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	

	public UBoolean uEquals(N_UUnlimitedNatural number) {
		return this.toUReal().uEquals(number.toUReal());
	}

	public UBoolean uDistinct(N_UUnlimitedNatural r) {
		return this.uEquals(r).not();
	}

	public UBoolean lt(N_UUnlimitedNatural number) {
		if ((this.getX()==-1)) return new UBoolean(false,1.0);
		if ((number.getX()==-1)) return new UBoolean(true,1.0);
		return this.toUReal().lt(number.toUReal());
	}
	
	public UBoolean le(N_UUnlimitedNatural number) {
		if ((number.getX()==-1)) return new UBoolean(true,1.0);
		if ((this.getX()==-1)) return new UBoolean(false,1.0);
		return this.toUReal().le(number.toUReal());
	}

	public UBoolean gt(N_UUnlimitedNatural number) {
		return this.toUReal().gt(number.toUReal());
	}

	
	public UBoolean ge(N_UUnlimitedNatural number) {
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
	

	public UBoolean uEqualsZero() {
		return this.uEquals(new N_UUnlimitedNatural());
	}

	public UBoolean uDistinctZero() {
		return this.uDistinct(new N_UUnlimitedNatural());
	}

	public UBoolean ltZero() {
		return this.lt(new N_UUnlimitedNatural());
	}
	
	public UBoolean leZero() {
		return this.le(new N_UUnlimitedNatural());
	}

	public UBoolean gtZero() {
		return this.gt(new N_UUnlimitedNatural());
	}

	public UBoolean geZero() {
		return this.ge(new N_UUnlimitedNatural());
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	@Override
	public int compareTo(N_UUnlimitedNatural other) {
		if (this.equals(other)) return 0;
		if (this.lt(other).toBoolean()) return -1;
		return 1;
	}

	public N_UUnlimitedNatural min(N_UUnlimitedNatural r) {
		if (r.lt(this).toBoolean()) return r.clone(); 
		return this.clone();
	}
	public N_UUnlimitedNatural max(N_UUnlimitedNatural r) {
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
		if ((this.getX()==-1)) throw new RuntimeException("Invalid conversion of *"); 
		return this.getX();
	}
	
	public double toReal()  { 
		if ((this.getX()==-1)) throw new RuntimeException("Invalid conversion of *"); 
		return this.getX();
	}
	
	public UReal toUReal() {
		if ((this.getX()==-1)) throw new RuntimeException("Invalid conversion of *"); 
		return new UReal(this.getX(),this.getU());
	}
	public UInteger toUInteger() {
		if ((this.getX()==-1)) throw new RuntimeException("Invalid conversion of *"); 
		return new UInteger(this.getX(),this.getU());
	}

	/**
	 * Other Methods 
	 */
 	public int hashcode(){ //required for equals()
		return this.x;
	}

 	public N_UUnlimitedNatural clone() {
		return new N_UUnlimitedNatural(this.getX(),this.getU(),this.getSample());
	}


}
