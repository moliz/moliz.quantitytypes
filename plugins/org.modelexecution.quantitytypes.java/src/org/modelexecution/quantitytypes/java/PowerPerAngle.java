package org.modelexecution.quantitytypes.java;

public class PowerPerAngle extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int r = BaseUnits.Radian.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		int m = BaseUnits.Meter.ordinal();
		if (u.dimensions[s]!=-3.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[r]!=-2.0) return false;
		if (u.dimensions[m]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=m)&&(i!=s)&&(i!=k)&&(i!=r)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public PowerPerAngle(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAngle");
    	this.unit = new Unit (q.unit);
    }
    public PowerPerAngle () {
        value = new UReal();
        unit = new Unit(DerivedUnits.WattPerSteradian);
    }

    public PowerPerAngle(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.WattPerSteradian);
    }

    public PowerPerAngle(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerAngle");
    	this.unit = new Unit (unit);
    }

	public PowerPerAngle(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSteradian);
	}
  
    public PowerPerAngle (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSteradian);
   }
    
    public PowerPerAngle(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerAngle");
    	this.unit = new Unit (unit);
   }

    public PowerPerAngle(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerAngle");
    	this.unit = new Unit (unit);
    }

    public PowerPerAngle(String x) { //creates an PowerPerAngle from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSteradian);
   }
    
    public PowerPerAngle(String x, String u) { //creates an PowerPerAngle from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSteradian);
   }
   
    public PowerPerAngle(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAngle");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public PowerPerAngle add(PowerPerAngle r) {  //only works if compatible units && operand has no offset
		
		return new PowerPerAngle(super.add(r));
	}
	
	public PowerPerAngle minus(PowerPerAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new PowerPerAngle(super.minus(r));
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
	
	public PowerPerAngle abs() { //units are maintained
		return new PowerPerAngle(super.abs());
	}
	
	public PowerPerAngle neg() { //units are maintained
		return new PowerPerAngle(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(PowerPerAngle r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(PowerPerAngle r) {  
		return !(this.equals(r));
	}
	
	public PowerPerAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new PowerPerAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public PowerPerAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new PowerPerAngle(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public PowerPerAngle min(PowerPerAngle r) { // units maintained
		if (r.lessThan(this)) return new PowerPerAngle(r.getX(),r.getU(),r.getUnits()); 
		return new PowerPerAngle(this.getX(),this.getU(),this.getUnits());
	}
	public PowerPerAngle max(PowerPerAngle r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new PowerPerAngle(r.getX(),r.getU(),r.getUnits());
		return new PowerPerAngle(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public PowerPerAngle mult(double r) {  
		return new PowerPerAngle(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public PowerPerAngle divideBy(double r) {  
		return new PowerPerAngle(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public PowerPerAngle clone() {
		return new PowerPerAngle(this.getUReal(),this.getUnits());
	}


}
