package org.modelexecution.quantitytypes.java;

public class UBoolean implements Cloneable, Comparable<UBoolean> {
	
	protected boolean b = true; 
	protected double c = 0.0;
	
	/** Important: booleans are always kept in their canonical form
	 *  (b,c) with b=true and c=confidence that b=true
	 */
	private void setNormalForm() {
		if (!b) { b = true; c=1-c; }
	}
	
    /**
     * Constructors 
     */
    public UBoolean() {
        this.b = true; this.c = 0.0;
    }

	public UBoolean(boolean b){ //"promotes" a boolean b to (b,1.0) 
		this.b = b; this.c = 1.0;
		setNormalForm();
	}
  
    public UBoolean(boolean b, double c) {
    	this.b=b;
    	this.c=c;
		setNormalForm();
    }
	
    public UBoolean(String b) { //creates an UBoolean from a string representing a real, with u=0.
    	this.b = Boolean.parseBoolean(b);
    	this.c = 1.0;
		setNormalForm();
    }
    
    public UBoolean(String b, String c) { //creates an UBoolean from two strings representing (x,u).
    	this.b = Boolean.parseBoolean(b);
    	this.c = Double.parseDouble(c);
		setNormalForm();
    }
   
    /**
     * Setters and getters 
     */
    public boolean getB() {
    	setNormalForm();
    	return b; 
	}

    public double getC() {
    	setNormalForm();
    	return c;
	}

   /*********
     * 
     * Type Operations
     */

   /*
    * Not(u) = Not (b, c) = (b, 1-c) = (Not b, c)
    */

   public UBoolean not() {
	   UBoolean result = new UBoolean(!this.getB(), this.getC());
	   return result;
   }

	public UBoolean and(UBoolean b) {

		if (this==b) return new UBoolean(this.b & b.b, this.c); // x and x
		
		UBoolean result = new UBoolean(
//				this.getB() && b.getB(),
//		        this.getC() * b.getC() );
				this.b & b.b,
		        this.c * b.c );
		return result;
	}
	
	public UBoolean or(UBoolean b) {

		if (this==b) return new UBoolean(this.b | b.b, this.c); // x or x
		
		UBoolean result = new UBoolean(
//				this.getB() || b.getB(),
//				this.getC() + b.getC() - (this.getC()*b.getC()) );
				this.b | b.b,
				this.c + b.c - (this.c*b.c) );
		return result;
	}

	public UBoolean implies(UBoolean b) {

		if (this==b) return new UBoolean((!this.b) | b.b , this.c); // x implies x

		UBoolean result = new UBoolean(
				(!this.b) | b.b,
				(1-this.c) + b.c - ((1-this.c)*b.c) );
		return result;
//		return this.uNot().uOr(b);
	}

    public UBoolean equivalent(UBoolean b) {
		// return this.implies(b).and(b.implies(this));
		 return this.xor(b).not();
 	
	}

	public UBoolean xor(UBoolean b) {
		 UBoolean result = new UBoolean(
				true,
				java.lang.Math.abs(this.getC() - b.getC()) );
		 return result;
		//return this.equivalent(b).not();
	}

    public UBoolean uEquals(UBoolean b) {
		return this.equivalent(b);
	}

	/***
	 * comparison operations
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UBoolean uBoolean = (UBoolean) o;

		if (getB() != uBoolean.getB()) return false;
		return Double.compare(uBoolean.getC(), getC()) == 0;
	}

	public boolean distinct(UBoolean b) {
		return !this.equals(b);
	}

	public boolean equalsC(UBoolean b, double confidence) {
	//	UBoolean x = this.equivalent(b);
	//	return x.c >= confidence;
		return java.lang.Math.abs(this.getC()-b.getC()) <= (1-confidence);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (getB() ? 1 : 0);
		temp = Double.doubleToLongBits(getC());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	/******
	 * Conversions
	 */
	
	public String toString() {
        boolean val = this.getB();
        double conf = this.getC();
		if (conf < 0.5) {
		    val = !val;
		    conf = 1 - conf;
        }
		return String.format("(%b, %5.3f)", val, conf);
	}

	public boolean toBoolean(){ //
//		return Double.compare(c, 0.5)>=0;
		return (c>=0.5); //this works because it is in canonical form
	}
	
	/**
	 * Other Methods 
	 */
	@Override
	public int compareTo(UBoolean other) {
		double x = (this.c-other.c);
		if (x==0) return 0;
		if (x<0) return -1;
		return 1;
		// return (int)(this.c-other.c);
	}

 	public UBoolean clone() {
		return new UBoolean(this.getB(),this.getC());
	}

}
