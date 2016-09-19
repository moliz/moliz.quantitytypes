package org.modelexecution.quantitytypes.java;

public class EnergyPerUnitArea extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public EnergyPerUnitArea(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an EnergyPerUnitArea");
    	this.unit = new Unit (q.unit);
    }
    public EnergyPerUnitArea () {
        value = new UReal();
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
    }

    public EnergyPerUnitArea(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
    }

    public EnergyPerUnitArea(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyPerUnitArea");
    	this.unit = new Unit (unit);
    }

	public EnergyPerUnitArea(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
	}
  
    public EnergyPerUnitArea (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
   }
    
    public EnergyPerUnitArea(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyPerUnitArea");
    	this.unit = new Unit (unit);
   }

    public EnergyPerUnitArea(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyPerUnitArea");
    	this.unit = new Unit (unit);
    }

    public EnergyPerUnitArea(String x) { //creates an EnergyPerUnitArea from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
   }
    
    public EnergyPerUnitArea(String x, String u) { //creates an EnergyPerUnitArea from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JoulePerSquareMeter);
   }
   
    public EnergyPerUnitArea(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyPerUnitArea");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public EnergyPerUnitArea add(EnergyPerUnitArea r) {  //only works if compatible units && operand has no offset
		
		return new EnergyPerUnitArea(super.add(r));
	}
	
	public EnergyPerUnitArea minus(EnergyPerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new EnergyPerUnitArea(super.minus(r));
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
	
	public EnergyPerUnitArea abs() { //units are maintained
		return new EnergyPerUnitArea(super.abs());
	}
	
	public EnergyPerUnitArea neg() { //units are maintained
		return new EnergyPerUnitArea(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(EnergyPerUnitArea r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(EnergyPerUnitArea r) {  
		return !(this.equals(r));
	}
	
	public EnergyPerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new EnergyPerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public EnergyPerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new EnergyPerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public EnergyPerUnitArea min(EnergyPerUnitArea r) { // units maintained
		if (r.lessThan(this)) return new EnergyPerUnitArea(r.getX(),r.getU(),r.getUnits()); 
		return new EnergyPerUnitArea(this.getX(),this.getU(),this.getUnits());
	}
	public EnergyPerUnitArea max(EnergyPerUnitArea r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new EnergyPerUnitArea(r.getX(),r.getU(),r.getUnits());
		return new EnergyPerUnitArea(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public EnergyPerUnitArea mult(double r) {  
		return new EnergyPerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public EnergyPerUnitArea divideBy(double r) {  
		return new EnergyPerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public EnergyPerUnitArea clone() {
		return new EnergyPerUnitArea(this.getUReal(),this.getUnits());
	}


}
