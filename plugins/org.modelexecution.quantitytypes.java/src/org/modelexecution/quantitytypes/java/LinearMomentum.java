package org.modelexecution.quantitytypes.java;

public class LinearMomentum extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public LinearMomentum(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
    	this.unit = new Unit (q.unit);
    }
    public LinearMomentum () {
        value = new UReal();
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
    }

    public LinearMomentum(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
    }

    public LinearMomentum(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearMomentum");
    	this.unit = new Unit (unit);
    }

	public LinearMomentum(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
	}
  
    public LinearMomentum (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
   }
    
    public LinearMomentum(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearMomentum");
    	this.unit = new Unit (unit);
   }

    public LinearMomentum(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearMomentum");
    	this.unit = new Unit (unit);
    }

    public LinearMomentum(String x) { //creates an LinearMomentum from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
   }
    
    public LinearMomentum(String x, String u) { //creates an LinearMomentum from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
   }
   
    public LinearMomentum(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LinearMomentum add(LinearMomentum r) {  //only works if compatible units && operand has no offset
		
		return new LinearMomentum(super.add(r));
	}
	
	public LinearMomentum minus(LinearMomentum r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new LinearMomentum(super.minus(r));
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
	
	public LinearMomentum abs() { //units are maintained
		return new LinearMomentum(super.abs());
	}
	
	public LinearMomentum neg() { //units are maintained
		return new LinearMomentum(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LinearMomentum r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LinearMomentum r) {  
		return !(this.equals(r));
	}
	
	public LinearMomentum floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LinearMomentum(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LinearMomentum round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LinearMomentum(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LinearMomentum min(LinearMomentum r) { // units maintained
		if (r.lessThan(this)) return new LinearMomentum(r.getX(),r.getU(),r.getUnits()); 
		return new LinearMomentum(this.getX(),this.getU(),this.getUnits());
	}
	public LinearMomentum max(LinearMomentum r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LinearMomentum(r.getX(),r.getU(),r.getUnits());
		return new LinearMomentum(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LinearMomentum mult(double r) {  
		return new LinearMomentum(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LinearMomentum divideBy(double r) {  
		return new LinearMomentum(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LinearMomentum clone() {
		return new LinearMomentum(this.getUReal(),this.getUnits());
	}


}
