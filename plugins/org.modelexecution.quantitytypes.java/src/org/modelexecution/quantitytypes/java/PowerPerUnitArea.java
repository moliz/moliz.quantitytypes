package org.modelexecution.quantitytypes.java;


public class PowerPerUnitArea extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[s]!=-3.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=s)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public PowerPerUnitArea(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Force");
    	this.unit = new Unit (q.unit);
    }
    public PowerPerUnitArea () {
        value = new UReal();
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
    }

    public PowerPerUnitArea(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
    }

    public PowerPerUnitArea(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerUnitArea");
    	this.unit = new Unit (unit);
    }

	public PowerPerUnitArea(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
	}
  
    public PowerPerUnitArea (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
    
    public PowerPerUnitArea(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerUnitArea");
    	this.unit = new Unit (unit);
   }

    public PowerPerUnitArea(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerUnitArea");
    	this.unit = new Unit (unit);
    }

    public PowerPerUnitArea(String x) { //creates an PowerPerUnitArea from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
    
    public PowerPerUnitArea(String x, String u) { //creates an PowerPerUnitArea from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
   
    public PowerPerUnitArea(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerUnitArea");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public PowerPerUnitArea add(PowerPerUnitArea r) {  //only works if compatible units && operand has no offset
		
		return new PowerPerUnitArea(super.add(r));
	}
	
	public PowerPerUnitArea minus(PowerPerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new PowerPerUnitArea(super.minus(r));
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
	
	public PowerPerUnitArea abs() { //units are maintained
		return new PowerPerUnitArea(super.abs());
	}
	
	public PowerPerUnitArea neg() { //units are maintained
		return new PowerPerUnitArea(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(PowerPerUnitArea r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(PowerPerUnitArea r) {  
		return !(this.equals(r));
	}
	
	public PowerPerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new PowerPerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public PowerPerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new PowerPerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public PowerPerUnitArea min(PowerPerUnitArea r) { // units maintained
		if (r.lessThan(this)) return new PowerPerUnitArea(r.getX(),r.getU(),r.getUnits()); 
		return new PowerPerUnitArea(this.getX(),this.getU(),this.getUnits());
	}
	public PowerPerUnitArea max(PowerPerUnitArea r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new PowerPerUnitArea(r.getX(),r.getU(),r.getUnits());
		return new PowerPerUnitArea(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public PowerPerUnitArea mult(double r) {  
		return new PowerPerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public PowerPerUnitArea divideBy(double r) {  
		return new PowerPerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public PowerPerUnitArea clone() {
		return new PowerPerUnitArea(this.getUReal(),this.getUnits());
	}


}
