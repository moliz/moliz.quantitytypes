package org.modelexecution.quantitytypes.java;


public class ElectricCurrentDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Meter.ordinal();
		if (u.dimensions[m]!=-2.0) return false;
		if (u.dimensions[l]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricCurrentDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrentDensity");
    	this.unit = new Unit (q.unit);
    }
    public ElectricCurrentDensity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
    }

    public ElectricCurrentDensity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
    }

    public ElectricCurrentDensity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrentDensity");
    	this.unit = new Unit (unit);
    }

	public ElectricCurrentDensity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
	}
  
    public ElectricCurrentDensity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
   }
    
    public ElectricCurrentDensity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrentDensity");
    	this.unit = new Unit (unit);
   }

    public ElectricCurrentDensity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrentDensity");
    	this.unit = new Unit (unit);
    }

    public ElectricCurrentDensity(String x) { //creates an ElectricCurrentDensity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
   }
    
    public ElectricCurrentDensity(String x, String u) { //creates an ElectricCurrentDensity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmperePerSquareMeter);
   }
   
    public ElectricCurrentDensity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrentDensity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ElectricCurrentDensity add(ElectricCurrentDensity r) {  //only works if compatible units && operand has no offset
		
		return new ElectricCurrentDensity(super.add(r));
	}
	
	public ElectricCurrentDensity minus(ElectricCurrentDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ElectricCurrentDensity(super.minus(r));
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
	
	public ElectricCurrentDensity abs() { //units are maintained
		return new ElectricCurrentDensity(super.abs());
	}
	
	public ElectricCurrentDensity neg() { //units are maintained
		return new ElectricCurrentDensity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ElectricCurrentDensity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ElectricCurrentDensity r) {  
		return !(this.equals(r));
	}
	
	public ElectricCurrentDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ElectricCurrentDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCurrentDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ElectricCurrentDensity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCurrentDensity min(ElectricCurrentDensity r) { // units maintained
		if (r.lessThan(this)) return new ElectricCurrentDensity(r.getX(),r.getU(),r.getUnits()); 
		return new ElectricCurrentDensity(this.getX(),this.getU(),this.getUnits());
	}
	public ElectricCurrentDensity max(ElectricCurrentDensity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ElectricCurrentDensity(r.getX(),r.getU(),r.getUnits());
		return new ElectricCurrentDensity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ElectricCurrentDensity mult(double r) {  
		return new ElectricCurrentDensity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ElectricCurrentDensity divideBy(double r) {  
		return new ElectricCurrentDensity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ElectricCurrentDensity clone() {
		return new ElectricCurrentDensity(this.getUReal(),this.getUnits());
	}


}
