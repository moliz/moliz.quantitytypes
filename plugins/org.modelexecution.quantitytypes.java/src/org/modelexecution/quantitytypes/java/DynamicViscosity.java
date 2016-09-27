package org.modelexecution.quantitytypes.java;

public class DynamicViscosity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int t = BaseUnits.Second.ordinal();
		int l = BaseUnits.Meter.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[t]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=m)&&(i!=t)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public DynamicViscosity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an DynamicViscosity");
    	this.unit = new Unit (q.unit);
    }

    public DynamicViscosity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.PascalSecond);
    }

    public DynamicViscosity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.PascalSecond);
    }

    public DynamicViscosity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DynamicViscosity");
    	this.unit = new Unit (unit);
    }

	public DynamicViscosity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.PascalSecond);
	}
  
    public DynamicViscosity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.PascalSecond);
   }
    
    public DynamicViscosity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DynamicViscosity");
    	this.unit = new Unit (unit);
   }

    public DynamicViscosity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DynamicViscosity");
    	this.unit = new Unit (unit);
    }

    public DynamicViscosity(String x) { //creates an DynamicViscosity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.PascalSecond);
   }
    
    public DynamicViscosity(String x, String u) { //creates an DynamicViscosity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.PascalSecond);
   }
   
    public DynamicViscosity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a DynamicViscosity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public DynamicViscosity add(DynamicViscosity r) {  //only works if compatible units && operand has no offset
		
		return new DynamicViscosity(super.add(r));
	}
	
	public DynamicViscosity minus(DynamicViscosity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new DynamicViscosity(super.minus(r));
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
	
	public DynamicViscosity abs() { //units are maintained
		return new DynamicViscosity(super.abs());
	}
	
	public DynamicViscosity neg() { //units are maintained
		return new DynamicViscosity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(DynamicViscosity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(DynamicViscosity r) {  
		return !(this.equals(r));
	}
	
	public DynamicViscosity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new DynamicViscosity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public DynamicViscosity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new DynamicViscosity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public DynamicViscosity min(DynamicViscosity r) { // units maintained
		if (r.lessThan(this)) return new DynamicViscosity(r.getX(),r.getU(),r.getUnits()); 
		return new DynamicViscosity(this.getX(),this.getU(),this.getUnits());
	}
	public DynamicViscosity max(DynamicViscosity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new DynamicViscosity(r.getX(),r.getU(),r.getUnits());
		return new DynamicViscosity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public DynamicViscosity mult(double r) {  
		return new DynamicViscosity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public DynamicViscosity divideBy(double r) {  
		return new DynamicViscosity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public DynamicViscosity clone() {
		return new DynamicViscosity(this.getUReal(),this.getUnits());
	}



}
