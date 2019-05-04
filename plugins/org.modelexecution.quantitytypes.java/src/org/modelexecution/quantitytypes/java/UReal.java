package org.modelexecution.quantitytypes.java;

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

public class UReal implements Cloneable,Comparable<UReal> {
	
	protected double x = 0.0; 
	protected double u = 0.0;

    /**
     * Constructors 
     */
    public UReal () {
        this.x = 0.0; this.u = 0.0;
    }

	public UReal(double x){ //"promotes" a real x to (x,0) 
		this.x = x; this.u = 0.0;
	}
  
    public UReal (double x, double u) {
        this.x = x; this.u = Math.abs(u);
    }
	
    public UReal(String x) { //creates an UReal from a string representing a real, with u=0.
    	this.x = Double.parseDouble(x);
    	this.u = 0.0;
    }
    
    public UReal(String x, String u) { //creates an UReal from two strings representing (x,u).
    	this.x = Double.parseDouble(x);
    	this.u = Math.abs(Double.parseDouble(u));
    }
   
    /**
     * Setters and getters 
     */
    public double getX() {
		return x; 
	}
    public void setX(double x) {
		this.x = x; 
	}
    public double getU() {
		return u;
	}
	public void setU(double u) {
		this.u = Math.abs(u);
	}

   /*********
     * 
     * Type Operations
     */

	public UReal add(UReal r) {
		UReal result = new UReal();
		result.setX(this.getX() + r.getX());
		result.setU( Math.sqrt((this.getU() * this.getU()) + (r.getU() * r.getU()) ));
		return result;
	}

	public UReal minus(UReal r) {
		UReal result = new UReal();
		result.setX(this.getX() - r.getX());
		if (r==this) result.setU(0.0);
		else result.setU(Math.sqrt((this.getU()*this.getU()) + (r.getU()*r.getU())));
		return result;
	}
	
	public UReal mult(UReal r) {
		UReal result = new UReal();
		
		result.setX(this.getX() * r.getX());
		
//		if (this.getU()==0.0) { result.setU(r.getU() * this.getX()); }
//		else if (r.getU()==0.0) {result.setU(this.getU()*r.getX()); }
//			 else {
		double a = r.getX()*r.getX()*this.getU()*this.getU();
		double b = this.getX()*this.getX()*r.getU()*r.getU();
		result.setU(Math.sqrt(a + b));
//			 }	
		return result;
	}
	
	public UReal divideBy(UReal r) {
		UReal result = new UReal();

		if (r==this) { // pathological cases x/x
			result.setX(1.0);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()/r.getX()); // "this" may be a scalar, too
			return result;
		}
		if (this.getU()==0.0) { // "this is a scalar, r is not
			result.setX(this.getX() / r.getX());
			result.setU(r.getU()/(r.getX()*r.getX()));
			return result;
		}
		// both variables have associated uncertainty
		
		double a = this.getX() / r.getX();
		double b = 0.0; //(this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX(a + b);
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a+b);

		double c = ((this.getU()*this.getU())/Math.abs(r.getX()));
		double d = Math.abs((this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX()));
		result.setU(Math.sqrt(c + d));
		
		return result;
	}
	
	public UReal abs() {
		UReal result = new UReal();
		result.setX(Math.abs(this.getX()));
		result.setU(this.getU());
		return result;
	}
	
	public UReal neg() {
		UReal result = new UReal();
		result.setX(-this.getX());
		result.setU(this.getU());
		return result;
	}
	
	public UReal power(float s) {
		UReal result = new UReal();
		
		double a = Math.pow(this.getX(), s);
		double b = ((s*(s-1))/2) * (Math.pow(this.getX(), s-2)) * (this.getU()*this.getU());
		result.setX(a); //result.setX(a + b);
		double c = s * this.getU() * (Math.pow(this.getX(), s-1));
		result.setU(c);
	
		return result;
	}
	
	public UReal sqrt() {
		UReal result = new UReal();
		if (this.getX()==0.0 && this.getU()==0.0) {
			result.setX(0.0);
			result.setU(0.0);
		}
		else {
			double a = Math.sqrt(this.getX());
			double b = 0.0; //(this.getU()*this.getU()) / ((8)*Math.pow(this.getX(), 3/2));
			double c = (this.getU()) / (2*Math.sqrt(this.getX()));
			result.setX(a - b);
			result.setU(c);
		}
		return result;
	}
	
	public UReal sin() {
       UReal result = new UReal();
       result.setX(Math.sin(this.getX()));
       result.setU(this.getU()*Math.cos(this.getX()));
       return result;
	}
	
	public UReal cos() {
	       UReal result = new UReal();
	       result.setX(Math.cos(this.getX()));
	       result.setU(this.getU()*Math.sin(this.getX()));
	       return result;
	}
	
	public UReal tan() { 
		return this.sin().divideBy(this.cos()); 
	}

	public UReal atan() {
	       UReal result = new UReal();
	       result.setX(Math.atan(this.getX()));
	       result.setU(this.getU()/(1 + this.getX()*this.getX()));
	       return result;
		}

	public UReal acos() {
	       UReal result = new UReal();
	       result.setX(Math.acos(this.getX()));
	       if (Math.abs(this.getX())!=1.0) result.setU(this.getU()/Math.sqrt((1 - this.getX()*this.getX())));
	       else result.setU(this.getU());
	       return result;
		}

	public UReal asin() {
	       UReal result = new UReal();
	       result.setX(Math.asin(this.getX()));
	       if (Math.abs(this.getX())!=1.0) result.setU(this.getU()/Math.sqrt((1 - this.getX()*this.getX())));
	       else result.setU(this.getU());
	       return result;
		}

	public UReal inverse() { //inverse (reciprocal)
		return new UReal(1.0,0.0).divideBy(this);
	}
	
	public UReal floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u)
		return new UReal(Math.floor(this.getX()),this.getU());
	}

	public UReal round(){ //returns (i,u) with i the closest int to x
		return new UReal(Math.round(this.getX()),this.getU());
	}

	 /*********
     * 
     * Type Operations with correlated variables
     */
	public UReal add(UReal r, double covariance) {
		UReal result = new UReal();
		result.setX(this.getX() + r.getX());
		result.setU( Math.sqrt((this.getU() * this.getU()) + (r.getU() * r.getU()) + 2 * covariance));
		return result;
	}

	public UReal minus(UReal r, double covariance) {
		UReal result = new UReal();
		result.setX(this.getX() - r.getX());
		if (r==this) result.setU(0.0);
		else result.setU(Math.sqrt((this.getU()*this.getU()) + (r.getU()*r.getU() - 2 * covariance)));
		return result;
	}
	
	public UReal mult(UReal r, double covariance) {
		UReal result = new UReal();
		
		result.setX(this.getX() * r.getX());
		double a = r.getX()*r.getX()*this.getU()*this.getU();
		double b = this.getX()*this.getX()*r.getU()*r.getU();
		double c = 2 * this.getX() * r.getX() * covariance;
		result.setU(Math.sqrt(a + b + c));
		return result;
	}
	
	public UReal divideBy(UReal r, double covariance) {
		UReal result = new UReal();
	
		if (r==this) { // pathological cases x/x. Covariance should be 1!
			result.setX(1.0);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU() / r.getX()); // "this" may be a scalar, too
			return result;
		}
		if (this.getU()==0.0) { // "this is a scalar, r is not
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()/(this.getX()*this.getX()));
			return result;
		}
		// both variables have associated uncertainty

		double a = this.getX() / r.getX();
//		double b = (this.getX()*r.getU()*r.getU())/(Math.pow(r.getX(), 3));
		double b = 0.0; //(this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX(a + b);
		
		double c = ((this.getU()*this.getU())/Math.abs(r.getX()));
//		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX());
		double e = Math.abs((this.getX()*covariance)/(r.getX()*r.getX()*r.getX()));
		result.setU(Math.sqrt(c + d - e));
		
		return result;
	}
	


	/***
	 * comparison operations
	 * 	These operations, that return a boolean, have been superseded by the
	 * corresponding UBoolean-returning operations -- except equals() and
	 * distinct, since they have another meaning in Java!.
     */
//	public boolean lt(UReal number) {
//		// we compute the separation factor of the two distributions considered as a mixture
//		// see http://faculty.washington.edu/tamre/IsHumanHeightBimodal.pdf
	//		double s1 = this.getU();
	//	double s2 = number.getU();
	//	// non-UReal cases first
	//	if ((s1==0.0) || (s2==0.0)) 
	//		return (this.getX() < number.getX());
	//	// if both numbers have some uncertainty
	//	double r = (s1*s1)/(s2*s2);
	//	double S = Math.sqrt(-2.0 + 3*r + 3*r*r - 2*r*r*r + 2*Math.pow(1-r+r*r, 1.5) )/(Math.sqrt(r)*(1+Math.sqrt(r)));
	//	double separation =  S*(s1+s2);
	//	if (Double.isNaN(S)) // similar to s1==0 or s2==0. No way to compute the separation test 
	//		return (this.getX() < number.getX());
	//	double diff = number.getX() - this.getX();
	//	return  (diff > 0) && (diff > separation); // they are distinguishable
	//	/** previous implementation
	//	  boolean result = false;
	//	   result = (this.getX() < number.getX()) &&
	//      ((this.getX() + this.getU())  < (number.getX() - number.getU()));
	//	   return result; */
	//	}
	
//	public boolean le(UReal r) {
	//		return (this.lt(r) || this.equals(r));
	//	}
	
	//	public boolean gt(UReal r) {
	//	return r.lt(this);
	//}
	//
	//
	//	public boolean ge(UReal r) {
	//		return (this.gt(r) || this.equals(r));
	//	}

	public boolean equals(UReal number) {
		// we compute the separation factor of the two distributions considered as a mixture
		// see http://faculty.washington.edu/tamre/IsHumanHeightBimodal.pdf
		if (this == number) return true;
		
		double s1 = this.getU();
		double s2 = number.getU();
		// non-UReal cases first
		if ((s1==0)||(s2==0)) return this.getX() == number.getX();
		// if both numbers have some uncertainty
		double r = (s1*s1)/(s2*s2);
		double S = Math.sqrt(-2.0 + 3*r + 3*r*r - 2*r*r*r + 2*Math.pow(1-r+r*r, 1.5) )/(Math.sqrt(r)*(1+Math.sqrt(r)));
		if (Double.isNaN(S)) // similar to s1==0 or s2==0. No way to compute the separation test 
			return (this.getX() == number.getX());
		double separation =  S*(s1+s2);
		return  Math.abs(number.getX() - this.getX()) <= separation; // they are indistinguishable
		/** previous implementation
		 * 
		boolean result = false;
		double a = Math.max((this.getX() - this.getU()), (r.getX() - r.getU()));
		double b = Math.min((this.getX() + this.getU()), (r.getX() + r.getU()));
		result = (a <= b);
		return result;
		 */
	}

	public boolean distinct(UReal r) {
		return !(this.equals(r));
	}
	//

	//	/***
	// * comparison operations WITH ZERO = UReal(0.0)
	// */
	//public boolean ltZero() {
	//	return this.lt(new UReal());
	//}
	//	
	//public boolean leZero() {
	//	return this.le(new UReal());
	//}
	//
	//public boolean gtZero() {
	//	return this.gt(new UReal());
	//}
	//	
	//public boolean geZero() {
	//	return this.ge(new UReal());
	//}
	//
	public boolean equalsZero(double u) {
		return this.equals(new UReal(0.0,u));
	}
	
	public boolean distinctZero(double u) {
		return this.distinct(new UReal(0.0,u));
	}
	//
	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	
	/**
	 * Let's start by some Gaussian operations
	// returns the cumulative normal distribution function (CNDF) for a standard normal: N(0,1)
    */
	private static double CNDF(double x) {
			// See http://stackoverflow.com/questions/442758/which-java-library-computes-the-cumulative-standard-normal-distribution-function
			// and https://lyle.smu.edu/~aleskovs/emis/sqc2/accuratecumnorm.pdf
	    int neg = (x < 0d) ? 1 : 0;
	    if (neg == 1) 
	        x *= -1d;
	    double k = (1d / ( 1d + 0.2316419 * x));
	    double y = (((( 1.330274429 * k - 1.821255978) * k + 1.781477937) *
	                   k - 0.356563782) * k + 0.319381530) * k;
	    y = 1.0 - 0.398942280401 * Math.exp(-0.5 * x * x) * y;
	    return (1d - neg) * y + neg * (1d - y);
	}

	/** alternative implementation -- they both work equally well
	
	private static double CNDF(double z) {
		if (z < -8.0) return 0.0;
		if (z >  8.0) return 1.0;
		double sum = 0.0, term = z;
		for (int i = 3; sum + term != sum; i += 2) {
			sum  = sum + term;
			term = term * z * z / i;
		}
		return 0.5 + sum * pdf(z);
	}
	*/
	// returns pdf(x) = standard Gaussian pdf
	private static double pdf(double x) {
	        return Math.exp(-x*x / 2) / Math.sqrt(2 * Math.PI);
	}

    // return pdf(x, mu, signma) = Gaussian pdf with mean mu and stddev sigma
	private static double pdf(double x, double mu, double sigma) {
        return pdf((x - mu) / sigma) / sigma;
    }

	// return cdf(z, mu, sigma) = Gaussian cdf with mean mu and stddev sigma
    private static double CNDF(double z, double mu, double sigma) {
	    return CNDF((z - mu) / sigma);
	} 

	// Compute z such that cdf(z) = y via bisection search
	// taken from http://introcs.cs.princeton.edu/java/22library/Gaussian.java.html
	private static double inverseCNDF(double y) {
	    return inverseCNDF(y, 0.00000001, -8, 8);
	} 
    // bisection search
    private static double inverseCNDF(double y, double delta, double lo, double hi) {
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (CNDF(mid) > y) return inverseCNDF(y, delta, lo, mid);
        else              return inverseCNDF(y, delta, mid, hi);
    }

    /***
     * Now we start with the fuzzy functions
     */

    /** 
     * This method returns three numbers (lt, eq, gt) with the probabilities that 
     * lt: this < number, 
     * eq: this = number
     * gt: this > number
     */
	private Result calculate(UReal number) {
		Result r = new Result();
		double m1, m2, s1, s2;
		boolean swap = false;
		if (this.getX()<=number.getX()) { // m1 is less or equal than m2
			m1 = this.getX();
			m2 = number.getX();
			s1 = this.getU();
			s2 = number.getU();
		} else {
			m2 = this.getX();
			m1 = number.getX();
			s2 = this.getU();
			s1 = number.getU();
			swap = true; // to return values in the correct order
		}
	
		if ((s1==0.0)&&(s2==0.0)) { //comparison between Real numbers
			if (m1==m2) {
				r.lt = 0.0; r.eq = 1.0;  r.gt = 0.0; 
				return r.check(swap); 
			}
			if (m1<m2) {
				r.lt = 1.0; r.eq = 0.0;  r.gt = 0.0; 
				return r.check(swap); 
			}
			r.lt = 0.0; r.eq = 0.0;  r.gt = 1.0; 
			return r.check(swap); 
		}
		if ((s1==0.0)) { // s1 is degenerated, s2 is not
			r.lt=1-CNDF(m1,m2,s2); r.eq=0.0;r.gt=CNDF(m1,m2,s2); 
			return r.check(swap); 
		}
		if ((s2==0.0)) { // s2 is degenerated, s1 is not
			r.lt=CNDF(m2,m1,s1); r.eq=0.0;r.gt=1-CNDF(m2,m1,s1); 
			return r.check(swap); 
		}
		// here none of the numbers are degenerated
		if (s1==s2) {
			double crossing = (m1 + m2)/2;
//			System.out.println("crossing = "+crossing);
			r.lt = CNDF(crossing,m1,s1)-CNDF(crossing,m2,s2);
//			r.gt = 1-CNDF(crossing,m1,s1)-(1-CNDF(crossing,m2,s2));
//			r.eq = CNDF(crossing,m2,s2)+1.0-CNDF(crossing,m1,s1);
			r.gt = 0.0; //1-CNDF(crossing,m1,s1)-(1-CNDF(crossing,m2,s2));
			r.eq = 1.0 - (r.gt + r.lt); //CNDF(crossing,m2,s2)+1.0-CNDF(crossing,m1,s1); 
			return r.check(swap); 
		}
		else {
			double crossing1 = 
				-(-m2*s1*s1 + 
				   m1*s2*s2 +
				   s1*s2*Math.sqrt((m1-m2)*(m1-m2)-2.0*(s1*s1-s2*s2)*Math.log(s2/s1))
				 )/(s1*s1 - s2*s2);	
			double crossing2 = 
				(m2*s1*s1 - 
				 m1*s2*s2 +
				 s1*s2*Math.sqrt(((m1-m2)*(m1-m2)-2.0*(s1*s1-s2*s2)*Math.log(s2/s1))
				))/(s1*s1 - s2*s2);
			double c1 = Math.min(crossing1, crossing2);
			double c2 = Math.max(crossing1, crossing2);
//			System.out.println("crossing1 = "+c1);
//			System.out.println("crossing2 = "+c2);
			if (s1<s2) {
				r.gt = CNDF(c1,m2,s2)-CNDF(c1,m1,s1);//+CNDF(c2,m1,s1)-CNDF(c2,m2,s2);
				r.lt = 1.0-CNDF(c2,m2,s2)-(1.0-CNDF(c2,m1,s1));
				r.eq = CNDF(c1,m1,s1) + (1.0-CNDF(c2,m1,s1))
					 + CNDF(c2,m2,s2) - CNDF(c1,m2,s2);
			}
			else{
				r.lt = CNDF(c1,m1,s1)-CNDF(c1,m2,s2);//+CNDF(c2,m2,s2)-CNDF(c2,m1,s1);
				r.gt = 1.0-CNDF(c2,m1,s1)-(1.0-CNDF(c2,m2,s2));
				r.eq = CNDF(c1,m2,s2) + (1.0-CNDF(c2,m2,s2))
						 + CNDF(c2,m1,s1) - CNDF(c1,m1,s1);
			}
			return r.check(swap); 
		}		
	}

	public UBoolean uEquals(UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.eq);
	}

	public UBoolean uDistinct(UReal r) {
		return this.uEquals(r).not();
	}

	public UBoolean lt(UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.lt);
	}
	
	public UBoolean le(UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true, r.lt+r.eq);
	}

	public UBoolean gt(UReal number) {
		Result r = this.calculate(number);
		return new UBoolean (true, r.gt);
	}

	
	public UBoolean ge(UReal number) {
		Result r = this.calculate(number);
		return new UBoolean(true,r.gt+r.eq);
	}
   
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS
	 */


	/*** 
	 *   FUZZY COMPARISON OPERATIONS WITH ZERO=UReal(0.0,0.0)
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	

	public UBoolean uEqualsZero(double u) {
		return this.uEquals(new UReal(0.0,u));
	}

	public UBoolean uDistinctZero(double u) {
		return this.uDistinct(new UReal(0.0,u));
	}

	public UBoolean ltZero() {
		return this.lt(new UReal());
	}
	
	public UBoolean leZero() {
		return this.le(new UReal());
	}

	public UBoolean gtZero() {
		return this.gt(new UReal());
	}

	public UBoolean geZero() {
		return this.ge(new UReal());
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	@Override
	public int compareTo(UReal other) {
		if (this.equals(other)) return 0;
		if (this.lt(other).toBoolean()) return -1;
		return 1;
	}

	public UReal min(UReal r) {
		if (r.lt(this).toBoolean()) return new UReal(r.getX(),r.getU()); 
		return new UReal(this.getX(),this.getU());
	}
	public UReal max(UReal r) {
		//if (r>this) r; else this;
		if (r.gt(this).toBoolean()) return new UReal(r.getX(),r.getU());
		return new UReal(this.getX(),this.getU());
	}

	/******
	 * Conversions
	 */
	
	public String toString() {
		return "(" + x + "," + u + ")";
	}
	
	public int toInteger(){ //
		return (int)Math.floor(this.getX());
	}
	
	public double toReal()  { 
		return this.getX();
	}
	
	public UInteger toUInteger() {
		UInteger r = new UInteger();
		r.x=(int)Math.floor(this.getX());
		r.u=Math.sqrt((this.u*this.u)+(this.x-r.x)*(this.x-r.x));
		return r;
	}

	public UInteger toBestUInteger() {
		UInteger r = new UInteger();
		r.x=(int)Math.round(this.getX());
		r.u=Math.sqrt((this.u*this.u)+(this.x-r.x)*(this.x-r.x));
		return r;		
	}

	public UUnlimitedNatural toUUnlimitedNatural() {
		UUnlimitedNatural r = new UUnlimitedNatural();
		r.x=(int)Math.floor(this.getX());
		r.u=Math.sqrt((this.u*this.u)+(this.x-r.x)*(this.x-r.x));
		return r;
	}

	public UUnlimitedNatural toBestUUnlimitedNatural() {
		UUnlimitedNatural r = new UUnlimitedNatural();
		r.x=(int)Math.round(this.getX());
		r.u=Math.sqrt((this.u*this.u)+(this.x-r.x)*(this.x-r.x));
		return r;
	}

	/**
	 * Other Methods 
	 */
 	public int hashcode(){ //required for equals()
		return Math.round((float)x);
	}

 	public UReal clone() {
		return new UReal(this.getX(),this.getU());
	}
}
