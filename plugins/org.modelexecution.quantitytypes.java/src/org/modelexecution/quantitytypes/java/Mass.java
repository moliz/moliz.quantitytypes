package org.modelexecution.quantitytypes.java;


public class Mass extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Mass(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
    	this.unit = new Unit (q.unit);
    }
    public Mass () {
        value = new UReal();
        unit = new Unit(BaseUnits.Kilogram);
    }

    public Mass(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Kilogram);
    }

    public Mass(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Mass");
    	this.unit = new Unit (unit);
    }

	public Mass(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(BaseUnits.Kilogram);
	}
  
    public Mass (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Kilogram);
   }
    
    public Mass(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Mass");
    	this.unit = new Unit (unit);
   }

    public Mass(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Mass");
    	this.unit = new Unit (unit);
    }

    public Mass(String x) { //creates an Mass from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Kilogram);
   }
    
    public Mass(String x, String u) { //creates an Mass from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Kilogram);
   }
   
    public Mass(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Mass add(Mass r) {  //only works if compatible units && operand has no offset
		
		return new Mass(super.add(r));
	}
	
	public Mass minus(Mass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Mass(super.minus(r));
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
	
	public Mass abs() { //units are maintained
		return new Mass(super.abs());
	}
	
	public Mass neg() { //units are maintained
		return new Mass(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Mass r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Mass r) {  
		return !(this.equals(r));
	}
	
	public Mass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Mass(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Mass round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Mass(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Mass min(Mass r) { // units maintained
		if (r.lessThan(this)) return new Mass(r.getX(),r.getU(),r.getUnits()); 
		return new Mass(this.getX(),this.getU(),this.getUnits());
	}
	public Mass max(Mass r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Mass(r.getX(),r.getU(),r.getUnits());
		return new Mass(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Mass mult(double r) {  
		return new Mass(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Mass divideBy(double r) {  
		return new Mass(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Mass clone() {
		return new Mass(this.getUReal(),this.getUnits());
	}


}
