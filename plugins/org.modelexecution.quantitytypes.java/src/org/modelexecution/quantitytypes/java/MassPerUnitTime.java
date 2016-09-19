package org.modelexecution.quantitytypes.java;

public class MassPerUnitTime extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[s]!=-1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=s)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MassPerUnitTime(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
    	this.unit = new Unit (q.unit);
    }
    public MassPerUnitTime () {
        value = new UReal();
        unit = new Unit(DerivedUnits.KilogramPerSecond);
    }

    public MassPerUnitTime(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.KilogramPerSecond);
    }

    public MassPerUnitTime(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitTime");
    	this.unit = new Unit (unit);
    }

	public MassPerUnitTime(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramPerSecond);
	}
  
    public MassPerUnitTime (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramPerSecond);
   }
    
    public MassPerUnitTime(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitTime");
    	this.unit = new Unit (unit);
   }

    public MassPerUnitTime(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitTime");
    	this.unit = new Unit (unit);
    }

    public MassPerUnitTime(String x) { //creates an MassPerUnitTime from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramPerSecond);
   }
    
    public MassPerUnitTime(String x, String u) { //creates an MassPerUnitTime from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramPerSecond);
   }
   
    public MassPerUnitTime(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MassPerUnitTime add(MassPerUnitTime r) {  //only works if compatible units && operand has no offset
		
		return new MassPerUnitTime(super.add(r));
	}
	
	public MassPerUnitTime minus(MassPerUnitTime r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MassPerUnitTime(super.minus(r));
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
	
	public MassPerUnitTime abs() { //units are maintained
		return new MassPerUnitTime(super.abs());
	}
	
	public MassPerUnitTime neg() { //units are maintained
		return new MassPerUnitTime(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MassPerUnitTime r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MassPerUnitTime r) {  
		return !(this.equals(r));
	}
	
	public MassPerUnitTime floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MassPerUnitTime(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MassPerUnitTime round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MassPerUnitTime(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MassPerUnitTime min(MassPerUnitTime r) { // units maintained
		if (r.lessThan(this)) return new MassPerUnitTime(r.getX(),r.getU(),r.getUnits()); 
		return new MassPerUnitTime(this.getX(),this.getU(),this.getUnits());
	}
	public MassPerUnitTime max(MassPerUnitTime r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MassPerUnitTime(r.getX(),r.getU(),r.getUnits());
		return new MassPerUnitTime(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MassPerUnitTime mult(double r) {  
		return new MassPerUnitTime(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MassPerUnitTime divideBy(double r) {  
		return new MassPerUnitTime(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MassPerUnitTime clone() {
		return new MassPerUnitTime(this.getUReal(),this.getUnits());
	}


}
