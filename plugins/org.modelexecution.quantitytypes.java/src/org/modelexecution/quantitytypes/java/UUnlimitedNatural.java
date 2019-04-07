package org.modelexecution.quantitytypes.java;

public class UUnlimitedNatural implements Cloneable,Comparable<UUnlimitedNatural> {
	
	protected int x = 0; 
	protected double u = 0.0;

    /**
     * Constructors 
     */
    public UUnlimitedNatural () {
        this.x = 0; this.u = 0.0;
    }

	public UUnlimitedNatural(int x){ //"promotes" a real x to (x,0) 
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		this.x = x; this.u = 0.0;
	}
  
    public UUnlimitedNatural (int x, double u) {
		if (x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
		if ((x==-1)&&(u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
        this.x = x; this.u = Math.abs(u);
    }
	
    public UUnlimitedNatural(String x) { //creates an UReal from a string representing a real, with u=0.
    	this.x = Integer.parseInt(x);
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
    	this.u = 0.0;
    }
    
    public UUnlimitedNatural(String x, String u) { //creates an UReal from two strings representing (x,u).
    	this.x = Integer.parseInt(x);
		if (this.x<-1) throw new RuntimeException("Unlimited Naturals should be either >=0, or -1"); 
    	this.u = Math.abs(Double.parseDouble(u));
		if ((this.x==-1)&&(this.u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
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
		this.u = Math.abs(u);
		if ((this.x==-1)&&(u!=0.0)) throw new RuntimeException("Uncertainty of -1 is 0.0"); 
	}

   /*********
     * 
     * Type Operations
     */

	
	public UUnlimitedNatural add(UUnlimitedNatural r) {
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
		UUnlimitedNatural result = new UUnlimitedNatural();
		result.setX(this.getX() + r.getX());
		result.setU( Math.sqrt((this.getU() * this.getU()) + (r.getU() * r.getU()) ));
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

	
	public UUnlimitedNatural mult(UUnlimitedNatural r) {
		UUnlimitedNatural result = new UUnlimitedNatural();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid mult with *"); 
		
		result.setX(this.getX() * r.getX());

		if (this.getU()==0.0) { result.setU(r.getU()); }
		else if (r.getU()==0.0) {result.setU(this.getU()); }
			 else {
				double a = r.getX()*r.getX()*this.getU()*this.getU();
				double b = this.getX()*this.getX()*r.getU()*r.getU();
				result.setU(Math.sqrt(a + b));
			 }	
		return result;
	}
	
	
	public UUnlimitedNatural divideBy(UUnlimitedNatural r) {
		UUnlimitedNatural result = new UUnlimitedNatural();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
		if (r==this) { // pathological cases x/x
			result.setX(1);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()); // "this" may be a scalar, too
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
		double b = (this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX((int)Math.floor(a + b));
		
		double c = ((u*u)/Math.abs(r.getX()));
//		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX());
		result.setU(Math.sqrt(c + d));
		
		return result;
	}
		
	/** this operation returns a UReal
	 */
	public UReal divideByR(UUnlimitedNatural r) {
		UReal result = new UReal();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
		if (r==this) { // pathological cases x/x
			result.setX(1.0);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()); // "this" may be a scalar, too
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
		double b = (this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX((int)Math.floor(a + b));
		
		double c = ((u*u)/Math.abs(r.getX()));
//		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX());
		result.setU(Math.sqrt(c + d));
	
		return result;
	}

	  /*********
     * 
     * Type Operations between correlated variables
     */

	
	public UUnlimitedNatural add(UUnlimitedNatural r, double covariance) {
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
		UUnlimitedNatural result = new UUnlimitedNatural();
		result.setX(this.getX() + r.getX());
		result.setU( Math.sqrt((this.getU() * this.getU()) + (r.getU() * r.getU())+ 2 * covariance ));
		return result;
	}
	

/** no minus for UUnlimitedNatural
*/

	
	public UUnlimitedNatural mult(UUnlimitedNatural r, double covariance) {
		UUnlimitedNatural result = new UUnlimitedNatural();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid mult with *"); 
		
		result.setX(this.getX() * r.getX());

		if (this.getU()==0.0) { result.setU(r.getU()); }
		else if (r.getU()==0.0) {result.setU(this.getU()); }
			 else {
				double a = r.getX()*r.getX()*this.getU()*this.getU();
				double b = this.getX()*this.getX()*r.getU()*r.getU();
				double c = 2 * this.getX() * r.getX() * covariance;
				result.setU(Math.sqrt(a + b + c));
			 }	
		return result;
	}
	
	
	public UUnlimitedNatural divideBy(UUnlimitedNatural r, double covariance) {
		UUnlimitedNatural result = new UUnlimitedNatural();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
		if (r==this) { // pathological cases x/x
			result.setX(1);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()); // "this" may be a scalar, too
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
		double b = (this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX((int)Math.floor(a + b));
		
		double c = ((u*u)/Math.abs(r.getX()));
//		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX());
		double e = (this.getX()*covariance)/Math.abs(r.getX()*r.getX()*r.getX());
		result.setU(Math.sqrt(c + d - e));

		
		return result;
	}
		
	/** this operation returns a UReal
	 */
	public UReal divideByR(UUnlimitedNatural r, double covariance) {
		UReal result = new UReal();
		if ((this.getX()==-1)||r.getX()==-1) throw new RuntimeException("Invalid add with *"); 
	
		if (r==this) { // pathological cases x/x
			result.setX(1.0);
			result.setU(0.0);
			return result;
		}
		if (r.getU()==0.0) { // r is a scalar
			result.setX(this.getX() / r.getX());
			result.setU(this.getU()); // "this" may be a scalar, too
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
		double b = (this.getX()*r.getU()*r.getU())/(r.getX()*r.getX()*r.getX());
		result.setX((int)Math.floor(a + b));
		
		double c = ((u*u)/Math.abs(r.getX()));
//		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / (r.getX()*r.getX()*r.getX()*r.getX());
		double e = (this.getX()*covariance)/Math.abs(r.getX()*r.getX()*r.getX());
		result.setU(Math.sqrt(c + d - e));
	
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
	
	public boolean equals(UUnlimitedNatural r) {
		return this.toUReal().equals(r.toUReal());
	}

	public boolean distinct(UUnlimitedNatural r) {
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
		return this.equals(new UUnlimitedNatural());
	}

	public boolean distinctZero() {
		return this.distinct(new UUnlimitedNatural());
	}

	/*** 
	 *   FUZZY COMPARISON OPERATIONS
	 *   Assume UReal values (x,u) represent standard uncertainty values, i.e., they follow a Normal distribution
	 *   of mean x and standard deviation \sigma = u
	 */
	

	public UBoolean uEquals(UUnlimitedNatural number) {
		return this.toUReal().uEquals(number.toUReal());
	}

	public UBoolean uDistinct(UUnlimitedNatural r) {
		return this.uEquals(r).not();
	}

	public UBoolean lt(UUnlimitedNatural number) {
		if ((this.getX()==-1)) return new UBoolean(false,1.0);
		if ((number.getX()==-1)) return new UBoolean(true,1.0);
		return this.toUReal().lt(number.toUReal());
	}
	
	public UBoolean le(UUnlimitedNatural number) {
		if ((number.getX()==-1)) return new UBoolean(true,1.0);
		if ((this.getX()==-1)) return new UBoolean(false,1.0);
		return this.toUReal().le(number.toUReal());
	}

	public UBoolean gt(UUnlimitedNatural number) {
		return this.toUReal().gt(number.toUReal());
	}

	
	public UBoolean ge(UUnlimitedNatural number) {
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
		return this.uEquals(new UUnlimitedNatural());
	}

	public UBoolean uDistinctZero() {
		return this.uDistinct(new UUnlimitedNatural());
	}

	public UBoolean ltZero() {
		return this.lt(new UUnlimitedNatural());
	}
	
	public UBoolean leZero() {
		return this.le(new UUnlimitedNatural());
	}

	public UBoolean gtZero() {
		return this.gt(new UUnlimitedNatural());
	}

	public UBoolean geZero() {
		return this.ge(new UUnlimitedNatural());
	}
    
	/*** 
	 *   END OF FUZZY COMPARISON OPERATIONS WITH ZERO
	 */

	@Override
	public int compareTo(UUnlimitedNatural other) {
		if (this.equals(other)) return 0;
		if (this.lt(other).toBoolean()) return -1;
		return 1;
	}

	public UUnlimitedNatural min(UUnlimitedNatural r) {
		if (r.lt(this).toBoolean()) return new UUnlimitedNatural(r.getX(),r.getU()); 
		return new UUnlimitedNatural(this.getX(),this.getU());
	}
	public UUnlimitedNatural max(UUnlimitedNatural r) {
		//if (r>this) r; else this;
		if (r.gt(this).toBoolean()) return new UUnlimitedNatural(r.getX(),r.getU());
		return new UUnlimitedNatural(this.getX(),this.getU());
	}

	/******
	 * Conversions
	 */
	
	public String toString() {
		return "(" + x + "," + u + ")";
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

 	public UUnlimitedNatural clone() {
		return new UUnlimitedNatural(this.getX(),this.getU());
	}


}
