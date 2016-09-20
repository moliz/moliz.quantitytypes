package org.modelexecution.quantitytypes.java;


// READY

public class AbsorbedDose extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AbsorbedDose(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDose");
    	this.unit = new Unit (q.unit);
    }
    public AbsorbedDose () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Gray);
    }

    public AbsorbedDose(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Gray);
    }

    public AbsorbedDose(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDose");
    	this.unit = new Unit (unit);
    }

	public AbsorbedDose(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Gray);
	}
  
    public AbsorbedDose (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Gray);
   }
    
    public AbsorbedDose(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDose");
    	this.unit = new Unit (unit);
   }

    public AbsorbedDose(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDose");
    	this.unit = new Unit (unit);
    }

    public AbsorbedDose(String x) { //creates an AbsorbedDose from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Gray);
   }
    
    public AbsorbedDose(String x, String u) { //creates an AbsorbedDose from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Gray);
   }
   
    public AbsorbedDose(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDose");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AbsorbedDose add(AbsorbedDose r) {  //only works if compatible units && operand has no offset
		return new AbsorbedDose(super.add(r));
	}
	
	public AbsorbedDose minus(AbsorbedDose r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
		return new AbsorbedDose(super.minus(r));
	}

	public AbsorbedDoseRate divideBy(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDoseRate(super.divideBy(r));
	}
	
	public LinearVelocity sqrt() { 
		return new LinearVelocity(super.sqrt());
	}

	public Area mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Area(super.mult(r));
	}
	
	public TimeSquared divideBy(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new TimeSquared(super.divideBy(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public AbsorbedDose abs() { //units are maintained
		return new AbsorbedDose(super.abs());
	}
	
	public AbsorbedDose neg() { //units are maintained
		return new AbsorbedDose(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AbsorbedDose r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AbsorbedDose r) {  
		return !(this.equals(r));
	}
	
	public AbsorbedDose floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AbsorbedDose(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AbsorbedDose round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AbsorbedDose(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AbsorbedDose min(AbsorbedDose r) { // units maintained
		if (r.lessThan(this)) return new AbsorbedDose(r.getX(),r.getU(),r.getUnits()); 
		return new AbsorbedDose(this.getX(),this.getU(),this.getUnits());
	}
	public AbsorbedDose max(AbsorbedDose r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AbsorbedDose(r.getX(),r.getU(),r.getUnits());
		return new AbsorbedDose(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AbsorbedDose mult(double r) {  
		return new AbsorbedDose(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AbsorbedDose divideBy(double r) {  
		return new AbsorbedDose(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AbsorbedDose clone() {
		return new AbsorbedDose(this.getUReal(),this.getUnits());
	}


}
