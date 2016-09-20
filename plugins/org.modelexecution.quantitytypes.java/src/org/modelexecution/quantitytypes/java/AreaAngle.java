package org.modelexecution.quantitytypes.java;


public class AreaAngle extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Radian.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AreaAngle(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AreaAngle");
    	this.unit = new Unit (q.unit);
    }
    public AreaAngle () {
        value = new UReal();
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
    }

    public AreaAngle(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
    }

    public AreaAngle(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AreaAngle");
    	this.unit = new Unit (unit);
    }

	public AreaAngle(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
	}
  
    public AreaAngle (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
   }
    
    public AreaAngle(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AreaAngle");
    	this.unit = new Unit (unit);
   }

    public AreaAngle(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AreaAngle");
    	this.unit = new Unit (unit);
    }

    public AreaAngle(String x) { //creates an AreaAngle from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
   }
    
    public AreaAngle(String x, String u) { //creates an AreaAngle from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterSteradian);
   }
   
    public AreaAngle(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaAngle");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AreaAngle add(AreaAngle r) {  //only works if compatible units && operand has no offset
		
		return new AreaAngle(super.add(r));
	}
	
	public AreaAngle minus(AreaAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new AreaAngle(super.minus(r));
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
	
	public AreaAngle abs() { //units are maintained
		return new AreaAngle(super.abs());
	}
	
	public AreaAngle neg() { //units are maintained
		return new AreaAngle(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AreaAngle r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AreaAngle r) {  
		return !(this.equals(r));
	}
	
	public AreaAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AreaAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AreaAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AreaAngle(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AreaAngle min(AreaAngle r) { // units maintained
		if (r.lessThan(this)) return new AreaAngle(r.getX(),r.getU(),r.getUnits()); 
		return new AreaAngle(this.getX(),this.getU(),this.getUnits());
	}
	public AreaAngle max(AreaAngle r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AreaAngle(r.getX(),r.getU(),r.getUnits());
		return new AreaAngle(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AreaAngle mult(double r) {  
		return new AreaAngle(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AreaAngle divideBy(double r) {  
		return new AreaAngle(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AreaAngle clone() {
		return new AreaAngle(this.getUReal(),this.getUnits());
	}


}
