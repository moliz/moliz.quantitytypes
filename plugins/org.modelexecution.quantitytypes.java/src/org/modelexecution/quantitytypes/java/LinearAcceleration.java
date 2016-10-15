package org.modelexecution.quantitytypes.java;


public class LinearAcceleration extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public LinearAcceleration(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
    	this.unit = new Unit (q.unit);
    }
    public LinearAcceleration () {
        value = new UReal();
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
    }

    public LinearAcceleration(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
    }

    public LinearAcceleration(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearAcceleration");
    	this.unit = new Unit (unit);
    }

	public LinearAcceleration(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
	}
  
    public LinearAcceleration (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
   }
    
    public LinearAcceleration(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearAcceleration");
    	this.unit = new Unit (unit);
   }

    public LinearAcceleration(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearAcceleration");
    	this.unit = new Unit (unit);
    }

    public LinearAcceleration(String x) { //creates an LinearAcceleration from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
   }
    
    public LinearAcceleration(String x, String u) { //creates an LinearAcceleration from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerSecondSquared);
   }
   
    public LinearAcceleration(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LinearAcceleration add(LinearAcceleration r) {  //only works if compatible units && operand has no offset
		
		return new LinearAcceleration(super.add(r));
	}
	
	public LinearAcceleration minus(LinearAcceleration r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new LinearAcceleration(super.minus(r));
	}

/*	public ZZZZ mult(TTTT r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDoseRate(super.mult(r));
	}
	
	public TimeSquared divideBy(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new TimeSquared(super.divideBy(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public LinearAcceleration abs() { //units are maintained
		return new LinearAcceleration(super.abs());
	}
	
	public LinearAcceleration neg() { //units are maintained
		return new LinearAcceleration(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LinearAcceleration r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LinearAcceleration r) {  
		return !(this.equals(r));
	}
	
	public LinearAcceleration floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LinearAcceleration(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LinearAcceleration round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LinearAcceleration(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LinearAcceleration min(LinearAcceleration r) { // units maintained
		if (r.lessThan(this)) return new LinearAcceleration(r.getX(),r.getU(),r.getUnits()); 
		return new LinearAcceleration(this.getX(),this.getU(),this.getUnits());
	}
	public LinearAcceleration max(LinearAcceleration r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LinearAcceleration(r.getX(),r.getU(),r.getUnits());
		return new LinearAcceleration(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LinearAcceleration mult(double r) {  
		return new LinearAcceleration(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LinearAcceleration divideBy(double r) {  
		return new LinearAcceleration(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	public LinearAcceleration mult(UReal r) {  
		return new LinearAcceleration(this.value.mult(r),this.getUnits());
	}
	
	public LinearAcceleration divideBy(UReal r) {  
		return new LinearAcceleration(this.value.divideBy(r),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LinearAcceleration clone() {
		return new LinearAcceleration(this.getUReal(),this.getUnits());
	}


}
