package org.modelexecution.quantitytypes.java;

public class UReal implements Cloneable {
	
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
        this.x = x; this.u = u;
    }
	
    public UReal(String x) { //creates an UReal from a string representing a real, with u=0.
    	this.x = Double.parseDouble(x);
    	this.u = 0.0;
    }
    
    public UReal(String x, String u) { //creates an UReal from two strings representing (x,u).
    	this.x = Double.parseDouble(x);
    	this.u = Double.parseDouble(u);
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
		this.u = u;
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
			result.setU(Math.sqrt((this.getU()*this.getU()) + (r.getU()*r.getU())));
			return result;
	}

	
	public UReal mult(UReal r) {
		UReal result = new UReal();
		
		result.setX(this.getX() * r.getX());
		
		double a = r.getX()*r.getX()*this.getU()*this.getU();
		double b = this.getX()*this.getX()*r.getU()*r.getU();
		result.setU(Math.sqrt(a + b));
	
		return result;
	}
	
	
	public UReal divide(UReal r) {
		UReal result = new UReal();
	
		double a = this.getX() / r.getX();
		double b = (this.getX()*r.getU()*r.getU())/(Math.pow(r.getX(), 3));
		result.setX(a + b);
		
		double c = ((u*u)/r.getX());
		double d = (this.getX()*this.getX()*r.getU()*r.getU()) / Math.pow(r.getX(), 4);
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
		result.setX(a + b);
		double c = s * this.getU() * (Math.pow(this.getX(), s-1));
		result.setU(c);
	
		return result;
	}

	
	public UReal sqrt() {
		UReal result = new UReal();
		
		double a = Math.sqrt(this.getX());
		double b = (this.getU()*this.getU()) / ((8)*Math.pow(this.getX(), 3/2));
		result.setX(a - b);
		double c = (this.getU()) / (2*Math.sqrt(this.getX()));
		result.setU(c);
	
		return result;
	}

	/***
	 * comparison operations
	 */
	public boolean lessThan(UReal r) {
		boolean result = false;
		result = (this.getX() < r.getX()) &&
                 ((this.getX() + this.getU())  < (r.getX() - r.getU()));
		return result;
	}
	
	
	public boolean lessEq(UReal r) {
		boolean result = false;
		result = (this.lessThan(r) || this.equals(r));
		return result;
	}

	
	public boolean gt(UReal r) {
		boolean result = false;
		
		result = r.lessThan(this);
		
		return result;
	}
	
	
	public boolean ge(UReal r) {
		boolean result = false;
		
		result = (this.gt(r) || this.equals(r)); 
		
		return result;
	}
	

	public boolean equals(UReal r) {
		boolean result = false;
		
		double a = Math.max((this.getX() - this.getU()), (r.getX() - r.getU()));
		double b = Math.min((this.getX() + this.getU()), (r.getX() + r.getU()));
		result = (a <= b);
		
		return result;
	}

	public boolean distinct(UReal r) {
		boolean result = false;
		
		result =  ( !(this.equals(r)) );
		
		return result;
	}
	
	public UReal inv() { //inverse (reciprocal)
		return new UReal(1.0,0.0).divide(this);
	}
	
	public UReal floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u)
		return new UReal(Math.floor(this.getX()),this.getU());
	}
	public UReal round(){ //returns (i,u) with i the closest int to x
		return new UReal(Math.round(this.getX()),this.getU());
	}
	public UReal min(UReal r) {
		if (r.lessThan(this)) return new UReal(r.getX(),r.getU()); 
		return new UReal(this.getX(),this.getU());
	}
	public UReal max(UReal r) {
		//if (r>this) r; else this;
		if (r.gt(this)) return new UReal(r.getX(),r.getU());
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
