package org.modelexecution.quantitytypes.java;

public class ElectricCharge extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int k = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricCharge(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCharge");
    	this.unit = new Unit (q.unit);
    }
    public ElectricCharge () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Coulomb);
    }

    public ElectricCharge(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Coulomb);
    }

    public ElectricCharge(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCharge");
    	this.unit = new Unit (unit);
    }

	public ElectricCharge(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Coulomb);
	}
  
    public ElectricCharge (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Coulomb);
   }
    
    public ElectricCharge(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCharge");
    	this.unit = new Unit (unit);
   }

    public ElectricCharge(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCharge");
    	this.unit = new Unit (unit);
    }

    public ElectricCharge(String x) { //creates an ElectricCharge from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Coulomb);
   }
    
    public ElectricCharge(String x, String u) { //creates an ElectricCharge from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Coulomb);
   }
   
    public ElectricCharge(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCharge");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ElectricCharge add(ElectricCharge r) {  //only works if compatible units && operand has no offset
		
		return new ElectricCharge(super.add(r));
	}
	
	public ElectricCharge minus(ElectricCharge r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ElectricCharge(super.minus(r));
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
	
	public ElectricCharge abs() { //units are maintained
		return new ElectricCharge(super.abs());
	}
	
	public ElectricCharge neg() { //units are maintained
		return new ElectricCharge(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ElectricCharge r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ElectricCharge r) {  
		return !(this.equals(r));
	}
	
	public ElectricCharge floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ElectricCharge(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCharge round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ElectricCharge(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCharge min(ElectricCharge r) { // units maintained
		if (r.lessThan(this)) return new ElectricCharge(r.getX(),r.getU(),r.getUnits()); 
		return new ElectricCharge(this.getX(),this.getU(),this.getUnits());
	}
	public ElectricCharge max(ElectricCharge r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ElectricCharge(r.getX(),r.getU(),r.getUnits());
		return new ElectricCharge(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ElectricCharge mult(double r) {  
		return new ElectricCharge(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ElectricCharge divideBy(double r) {  
		return new ElectricCharge(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ElectricCharge clone() {
		return new ElectricCharge(this.getUReal(),this.getUnits());
	}


}
