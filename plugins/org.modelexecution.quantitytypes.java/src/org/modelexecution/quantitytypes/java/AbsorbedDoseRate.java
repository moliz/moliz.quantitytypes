package org.modelexecution.quantitytypes.java;

public class AbsorbedDoseRate extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=-3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AbsorbedDoseRate(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AngularAcceleration");
    	this.unit = new Unit (q.unit);
    }
    public AbsorbedDoseRate () {
        value = new UReal();
        unit = new Unit(DerivedUnits.GrayPerSecond);
    }

    public AbsorbedDoseRate(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.GrayPerSecond);
    }

    public AbsorbedDoseRate(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDoseRate");
    	this.unit = new Unit (unit);
    }

	public AbsorbedDoseRate(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.GrayPerSecond);
	}
  
    public AbsorbedDoseRate (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.GrayPerSecond);
   }
    
    public AbsorbedDoseRate(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDoseRate");
    	this.unit = new Unit (unit);
   }

    public AbsorbedDoseRate(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDoseRate");
    	this.unit = new Unit (unit);
    }

    public AbsorbedDoseRate(String x) { //creates an AbsorbedDoseRate from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.GrayPerSecond);
   }
    
    public AbsorbedDoseRate(String x, String u) { //creates an AbsorbedDoseRate from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.GrayPerSecond);
   }
   
    public AbsorbedDoseRate(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDoseRate");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AbsorbedDoseRate add(AbsorbedDoseRate r) {  //only works if compatible units && operand has no offset
		return new AbsorbedDoseRate(super.add(r));
	}
	
	public AbsorbedDoseRate minus(AbsorbedDoseRate r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
		return new AbsorbedDoseRate(super.minus(r));
	}

	public AbsorbedDose mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDose(super.mult(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public AbsorbedDoseRate abs() { //units are maintained
		return new AbsorbedDoseRate(super.abs());
	}
	
	public AbsorbedDoseRate neg() { //units are maintained
		return new AbsorbedDoseRate(super.neg());
	}

    // power(s), sqrt(), inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AbsorbedDoseRate r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AbsorbedDoseRate r) {  
		return !(this.equals(r));
	}
	
	public AbsorbedDoseRate floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AbsorbedDoseRate(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AbsorbedDoseRate round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AbsorbedDoseRate(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AbsorbedDoseRate min(AbsorbedDoseRate r) { // units maintained
		if (r.lessThan(this)) return new AbsorbedDoseRate(r.getX(),r.getU(),r.getUnits()); 
		return new AbsorbedDoseRate(this.getX(),this.getU(),this.getUnits());
	}
	public AbsorbedDoseRate max(AbsorbedDoseRate r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AbsorbedDoseRate(r.getX(),r.getU(),r.getUnits());
		return new AbsorbedDoseRate(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AbsorbedDoseRate mult(double r) {  
		return new AbsorbedDoseRate(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AbsorbedDoseRate divideBy(double r) {  
		return new AbsorbedDoseRate(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AbsorbedDoseRate clone() {
		return new AbsorbedDoseRate(this.getUReal(),this.getUnits());
	}


}
