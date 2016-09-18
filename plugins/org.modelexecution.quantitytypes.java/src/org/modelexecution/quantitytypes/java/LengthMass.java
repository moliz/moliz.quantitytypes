package org.modelexecution.quantitytypes.java;

public class LengthMass extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public LengthMass(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a lengthMass");
    	this.unit = new Unit (q.unit);
    }
    public LengthMass () {
        value = new UReal();
        unit = new Unit(DerivedUnits.MeterKilogram);
    }

    public LengthMass(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.MeterKilogram);
    }

    public LengthMass(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LengthMass");
    	this.unit = new Unit (unit);
    }

	public LengthMass(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterKilogram);
	}
  
    public LengthMass (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterKilogram);
   }
    
    public LengthMass(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LengthMass");
    	this.unit = new Unit (unit);
   }

    public LengthMass(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LengthMass");
    	this.unit = new Unit (unit);
    }

    public LengthMass(String x) { //creates an LengthMass from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterKilogram);
   }
    
    public LengthMass(String x, String u) { //creates an LengthMass from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterKilogram);
   }
   
    public LengthMass(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthMass");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LengthMass add(LengthMass r) {  //only works if compatible units && operand has no offset
		
		return new LengthMass(super.add(r));
	}
	
	public LengthMass minus(LengthMass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new LengthMass(super.minus(r));
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
	
	public LengthMass abs() { //units are maintained
		return new LengthMass(super.abs());
	}
	
	public LengthMass neg() { //units are maintained
		return new LengthMass(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LengthMass r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LengthMass r) {  
		return !(this.equals(r));
	}
	
	public LengthMass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LengthMass(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LengthMass round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LengthMass(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LengthMass min(LengthMass r) { // units maintained
		if (r.lessThan(this)) return new LengthMass(r.getX(),r.getU(),r.getUnits()); 
		return new LengthMass(this.getX(),this.getU(),this.getUnits());
	}
	public LengthMass max(LengthMass r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LengthMass(r.getX(),r.getU(),r.getUnits());
		return new LengthMass(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LengthMass mult(double r) {  
		return new LengthMass(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LengthMass divideBy(double r) {  
		return new LengthMass(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LengthMass clone() {
		return new LengthMass(this.getUReal(),this.getUnits());
	}


}
