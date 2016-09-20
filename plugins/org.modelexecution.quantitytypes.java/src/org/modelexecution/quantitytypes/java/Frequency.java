package org.modelexecution.quantitytypes.java;


//READY

public class Frequency extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Second.ordinal();
		if (u.dimensions[k]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Frequency(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an Frequency");
    	this.unit = new Unit (q.unit);
    }

    public Frequency () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Hertz);
    }

    public Frequency(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Hertz);
    }

    public Frequency(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Frequency");
    	this.unit = new Unit (unit);
    }

	public Frequency(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(DerivedUnits.Hertz);
	}
  
    public Frequency (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Hertz);
   }
    
    public Frequency(double x, Unit unit){ //we only allow this kind of Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Frequency");
    	this.unit = new Unit (unit);
   }

    public Frequency(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Frequency");
    	this.unit = new Unit (unit);
    }

    public Frequency(String x) { //creates an Frequency from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Hertz);
   }
    
    public Frequency(String x, String u) { //creates an Frequency from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Hertz);
   }
   
    public Frequency(String x, String u, Unit unit) { //creates an Frequency from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Frequency");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Frequency add(Frequency r) {  //only works if compatible units && operand has no offset
		return new Frequency(super.add(r));
	}
	
	public Frequency minus(Frequency r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
		return new Frequency(super.minus(r));
	}

	public AngularVelocity mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularVelocity(super.mult(r));
	}

	/** OTHER OPERATIONS
	 * 
	 */
	
	public Frequency abs() { //units are maintained
		return new Frequency(super.abs());
	}
	
	public Frequency neg() { //units are maintained
		return new Frequency(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Frequency r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Frequency r) {  
		return !(this.equals(r));
	}
	
	public Frequency floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Frequency(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Frequency round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Frequency(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Frequency min(Frequency r) { // units maintained
		if (r.lessThan(this)) return new Frequency(r.getX(),r.getU(),r.getUnits()); 
		return new Frequency(this.getX(),this.getU(),this.getUnits());
	}
	public Frequency max(Frequency r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Frequency(r.getX(),r.getU(),r.getUnits());
		return new Frequency(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Frequency mult(double r) {  
		return new Frequency(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Frequency divideBy(double r) {  
		return new Frequency(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Frequency clone() {
		return new Frequency(this.getUReal(),this.getUnits());
	}


}
