package org.modelexecution.quantitytypes.java;


public class AngularMass extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AngularMass(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AngularMass");
    	this.unit = new Unit (q.unit);
    }

    public AngularMass () {
        value = new UReal();
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
    }

    public AngularMass(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
    }

    public AngularMass(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMass");
    	this.unit = new Unit (unit);
    }

	public AngularMass(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
	}
  
    public AngularMass (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
   }
    
    public AngularMass(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMass");
    	this.unit = new Unit (unit);
   }

    public AngularMass(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMass");
    	this.unit = new Unit (unit);
    }

    public AngularMass(String x) { //creates an AngularMass from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
   }
    
    public AngularMass(String x, String u) { //creates an AngularMass from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.KilogramMeterSquared);
   }
   
    public AngularMass(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMass");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AngularMass add(AngularMass r) {  //only works if compatible units && operand has no offset
		
		return new AngularMass(super.add(r));
	}
	
	public AngularMass minus(AngularMass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new AngularMass(super.minus(r));
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
	
	public AngularMass abs() { //units are maintained
		return new AngularMass(super.abs());
	}
	
	public AngularMass neg() { //units are maintained
		return new AngularMass(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AngularMass r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AngularMass r) {  
		return !(this.equals(r));
	}
	
	public AngularMass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AngularMass(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AngularMass round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AngularMass(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AngularMass min(AngularMass r) { // units maintained
		if (r.lessThan(this)) return new AngularMass(r.getX(),r.getU(),r.getUnits()); 
		return new AngularMass(this.getX(),this.getU(),this.getUnits());
	}
	public AngularMass max(AngularMass r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AngularMass(r.getX(),r.getU(),r.getUnits());
		return new AngularMass(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AngularMass mult(double r) {  
		return new AngularMass(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AngularMass divideBy(double r) {  
		return new AngularMass(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AngularMass clone() {
		return new AngularMass(this.getUReal(),this.getUnits());
	}



}
