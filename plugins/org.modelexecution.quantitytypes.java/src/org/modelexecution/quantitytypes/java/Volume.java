package org.modelexecution.quantitytypes.java;

public class Volume extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Volume(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
    	this.unit = new Unit (q.unit);
    }
    public Volume () {
        value = new UReal();
        unit = new Unit(DerivedUnits.CubicMeter);
    }

    public Volume(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.CubicMeter);
    }

    public Volume(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Volume");
    	this.unit = new Unit (unit);
    }

	public Volume(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.CubicMeter);
	}
  
    public Volume (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CubicMeter);
   }
    
    public Volume(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Volume");
    	this.unit = new Unit (unit);
   }

    public Volume(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Volume");
    	this.unit = new Unit (unit);
    }

    public Volume(String x) { //creates an Volume from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.CubicMeter);
   }
    
    public Volume(String x, String u) { //creates an Volume from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CubicMeter);
   }
   
    public Volume(String x, String u, Unit unit) { //creates an Volume from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Volume add(Volume r) {  //only works if compatible units && operand has no offset
		
		return new Volume(super.add(r));
	}
	
	public Volume minus(Volume r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Volume(super.minus(r));
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
	
	public Volume abs() { //units are maintained
		return new Volume(super.abs());
	}
	
	public Volume neg() { //units are maintained
		return new Volume(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Volume r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Volume r) {  
		return !(this.equals(r));
	}
	
	public Volume floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Volume(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Volume round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Volume(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Volume min(Volume r) { // units maintained
		if (r.lessThan(this)) return new Volume(r.getX(),r.getU(),r.getUnits()); 
		return new Volume(this.getX(),this.getU(),this.getUnits());
	}
	public Volume max(Volume r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Volume(r.getX(),r.getU(),r.getUnits());
		return new Volume(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Volume mult(double r) {  
		return new Volume(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Volume divideBy(double r) {  
		return new Volume(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Volume clone() {
		return new Volume(this.getUReal(),this.getUnits());
	}


}
