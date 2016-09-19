package org.modelexecution.quantitytypes.java;

public class Force extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Force(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Force");
    	this.unit = new Unit (q.unit);
    }
    public Force () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Newton);
    }

    public Force(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Newton);
    }

    public Force(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Force");
    	this.unit = new Unit (unit);
    }

	public Force(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Newton);
	}
  
    public Force (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Newton);
   }
    
    public Force(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Force");
    	this.unit = new Unit (unit);
   }

    public Force(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Force");
    	this.unit = new Unit (unit);
    }

    public Force(String x) { //creates an Force from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Newton);
   }
    
    public Force(String x, String u) { //creates an Force from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Newton);
   }
   
    public Force(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Force");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Force add(Force r) {  //only works if compatible units && operand has no offset
		
		return new Force(super.add(r));
	}
	
	public Force minus(Force r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Force(super.minus(r));
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
	
	public Force abs() { //units are maintained
		return new Force(super.abs());
	}
	
	public Force neg() { //units are maintained
		return new Force(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Force r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Force r) {  
		return !(this.equals(r));
	}
	
	public Force floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Force(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Force round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Force(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Force min(Force r) { // units maintained
		if (r.lessThan(this)) return new Force(r.getX(),r.getU(),r.getUnits()); 
		return new Force(this.getX(),this.getU(),this.getUnits());
	}
	public Force max(Force r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Force(r.getX(),r.getU(),r.getUnits());
		return new Force(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Force mult(double r) {  
		return new Force(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Force divideBy(double r) {  
		return new Force(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Force clone() {
		return new Force(this.getUReal(),this.getUnits());
	}


}
