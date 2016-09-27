package org.modelexecution.quantitytypes.java;

public class VolumePerUnitTime extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Second.ordinal();
		int k = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[k]!=3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public VolumePerUnitTime(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an VolumePerUnitTime");
    	this.unit = new Unit (q.unit);
    }

    public VolumePerUnitTime () {
        value = new UReal();
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
    }

    public VolumePerUnitTime(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
    }

    public VolumePerUnitTime(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an VolumePerUnitTime");
    	this.unit = new Unit (unit);
    }

	public VolumePerUnitTime(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
	}
  
    public VolumePerUnitTime (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
   }
    
    public VolumePerUnitTime(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an VolumePerUnitTime");
    	this.unit = new Unit (unit);
   }

    public VolumePerUnitTime(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an VolumePerUnitTime");
    	this.unit = new Unit (unit);
    }

    public VolumePerUnitTime(String x) { //creates an VolumePerUnitTime from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
   }
    
    public VolumePerUnitTime(String x, String u) { //creates an VolumePerUnitTime from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CubicMeterPerSecond);
   }
   
    public VolumePerUnitTime(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumePerUnitTime");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public VolumePerUnitTime add(VolumePerUnitTime r) {  //only works if compatible units && operand has no offset
		
		return new VolumePerUnitTime(super.add(r));
	}
	
	public VolumePerUnitTime minus(VolumePerUnitTime r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new VolumePerUnitTime(super.minus(r));
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
	
	public VolumePerUnitTime abs() { //units are maintained
		return new VolumePerUnitTime(super.abs());
	}
	
	public VolumePerUnitTime neg() { //units are maintained
		return new VolumePerUnitTime(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(VolumePerUnitTime r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(VolumePerUnitTime r) {  
		return !(this.equals(r));
	}
	
	public VolumePerUnitTime floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new VolumePerUnitTime(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public VolumePerUnitTime round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new VolumePerUnitTime(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public VolumePerUnitTime min(VolumePerUnitTime r) { // units maintained
		if (r.lessThan(this)) return new VolumePerUnitTime(r.getX(),r.getU(),r.getUnits()); 
		return new VolumePerUnitTime(this.getX(),this.getU(),this.getUnits());
	}
	public VolumePerUnitTime max(VolumePerUnitTime r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new VolumePerUnitTime(r.getX(),r.getU(),r.getUnits());
		return new VolumePerUnitTime(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public VolumePerUnitTime mult(double r) {  
		return new VolumePerUnitTime(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public VolumePerUnitTime divideBy(double r) {  
		return new VolumePerUnitTime(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public VolumePerUnitTime clone() {
		return new VolumePerUnitTime(this.getUReal(),this.getUnits());
	}



}
