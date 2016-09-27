package org.modelexecution.quantitytypes.java;

// MISSING SPECIFIC OPERATIONS

public class DoseEquivalent extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Second.ordinal();
		int k = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=-2.0) return false;
		if (u.dimensions[k]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public DoseEquivalent(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an DoseEquivalent");
    	this.unit = new Unit (q.unit);
    }

    public DoseEquivalent () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Sievert);
    }

    public DoseEquivalent(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Sievert);
    }

    public DoseEquivalent(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DoseEquivalent");
    	this.unit = new Unit (unit);
    }

	public DoseEquivalent(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Sievert);
	}
  
    public DoseEquivalent (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Sievert);
   }
    
    public DoseEquivalent(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DoseEquivalent");
    	this.unit = new Unit (unit);
   }

    public DoseEquivalent(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DoseEquivalent");
    	this.unit = new Unit (unit);
    }

    public DoseEquivalent(String x) { //creates an DoseEquivalent from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Sievert);
   }
    
    public DoseEquivalent(String x, String u) { //creates an DoseEquivalent from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Sievert);
   }
   
    public DoseEquivalent(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a DoseEquivalent");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public DoseEquivalent add(DoseEquivalent r) {  //only works if compatible units && operand has no offset
		
		return new DoseEquivalent(super.add(r));
	}
	
	public DoseEquivalent minus(DoseEquivalent r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new DoseEquivalent(super.minus(r));
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
	
	public DoseEquivalent abs() { //units are maintained
		return new DoseEquivalent(super.abs());
	}
	
	public DoseEquivalent neg() { //units are maintained
		return new DoseEquivalent(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(DoseEquivalent r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(DoseEquivalent r) {  
		return !(this.equals(r));
	}
	
	public DoseEquivalent floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new DoseEquivalent(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public DoseEquivalent round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new DoseEquivalent(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public DoseEquivalent min(DoseEquivalent r) { // units maintained
		if (r.lessThan(this)) return new DoseEquivalent(r.getX(),r.getU(),r.getUnits()); 
		return new DoseEquivalent(this.getX(),this.getU(),this.getUnits());
	}
	public DoseEquivalent max(DoseEquivalent r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new DoseEquivalent(r.getX(),r.getU(),r.getUnits());
		return new DoseEquivalent(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public DoseEquivalent mult(double r) {  
		return new DoseEquivalent(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public DoseEquivalent divideBy(double r) {  
		return new DoseEquivalent(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public DoseEquivalent clone() {
		return new DoseEquivalent(this.getUReal(),this.getUnits());
	}



}
