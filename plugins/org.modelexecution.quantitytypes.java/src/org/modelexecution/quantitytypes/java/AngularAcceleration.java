package org.modelexecution.quantitytypes.java;

public class AngularAcceleration extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = DerivedUnits.RadianPerSecondSquared.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AngularAcceleration(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AngularAcceleration");
    	this.unit = new Unit (q.unit);
    }

    public AngularAcceleration () {
        value = new UReal();
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
    }

    public AngularAcceleration(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
    }

    public AngularAcceleration(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularAcceleration");
    	this.unit = new Unit (unit);
    }

	public AngularAcceleration(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
	}
  
    public AngularAcceleration (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
   }
    
    public AngularAcceleration(double x, Unit unit){ //we only allow this kind of Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularAcceleration");
    	this.unit = new Unit (unit);
   }

    public AngularAcceleration(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularAcceleration");
    	this.unit = new Unit (unit);
    }

    public AngularAcceleration(String x) { //creates an AngularAcceleration from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
   }
    
    public AngularAcceleration(String x, String u) { //creates an AngularAcceleration from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.RadianPerSecondSquared);
   }
   
    public AngularAcceleration(String x, String u, Unit unit) { //creates an AngularAcceleration from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularAcceleration");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Angle mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Angle(super.mult(r));
	}

	public AngularVelocity mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularVelocity(super.mult(r));
	}
	
	public TimeSquared divideBy(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new TimeSquared(super.divideBy(r));
	}

	public Time mult(AngularVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Time(super.mult(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public AngularAcceleration abs() { //units are maintained
		return new AngularAcceleration(super.abs());
	}
	
	public AngularAcceleration neg() { //units are maintained
		return new AngularAcceleration(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AngularAcceleration r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AngularAcceleration r) {  
		return !(this.equals(r));
	}
	
	public AngularAcceleration floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AngularAcceleration(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AngularAcceleration round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AngularAcceleration(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AngularAcceleration min(AngularAcceleration r) { // units maintained
		if (r.lessThan(this)) return new AngularAcceleration(r.getX(),r.getU(),r.getUnits()); 
		return new AngularAcceleration(this.getX(),this.getU(),this.getUnits());
	}
	public AngularAcceleration max(AngularAcceleration r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AngularAcceleration(r.getX(),r.getU(),r.getUnits());
		return new AngularAcceleration(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AngularAcceleration mult(double r) {  
		return new AngularAcceleration(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AngularAcceleration divideBy(double r) {  
		return new AngularAcceleration(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AngularAcceleration clone() {
		return new AngularAcceleration(this.getUReal(),this.getUnits());
	}


}
