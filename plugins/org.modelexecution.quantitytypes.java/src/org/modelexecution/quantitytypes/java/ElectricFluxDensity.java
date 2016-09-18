package org.modelexecution.quantitytypes.java;

public class ElectricFluxDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[m]!=-2.0) return false;
		if (u.dimensions[s]!=1.0) return false;
		if (u.dimensions[l]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricFluxDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
    	this.unit = new Unit (q.unit);
    }
    public ElectricFluxDensity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
    }

    public ElectricFluxDensity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
    }

    public ElectricFluxDensity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricFluxDensity");
    	this.unit = new Unit (unit);
    }

	public ElectricFluxDensity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
	}
  
    public ElectricFluxDensity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
   }
    
    public ElectricFluxDensity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricFluxDensity");
    	this.unit = new Unit (unit);
   }

    public ElectricFluxDensity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricFluxDensity");
    	this.unit = new Unit (unit);
    }

    public ElectricFluxDensity(String x) { //creates an ElectricFluxDensity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
   }
    
    public ElectricFluxDensity(String x, String u) { //creates an ElectricFluxDensity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
   }
   
    public ElectricFluxDensity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ElectricFluxDensity add(ElectricFluxDensity r) {  //only works if compatible units && operand has no offset
		
		return new ElectricFluxDensity(super.add(r));
	}
	
	public ElectricFluxDensity minus(ElectricFluxDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ElectricFluxDensity(super.minus(r));
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
	
	public ElectricFluxDensity abs() { //units are maintained
		return new ElectricFluxDensity(super.abs());
	}
	
	public ElectricFluxDensity neg() { //units are maintained
		return new ElectricFluxDensity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ElectricFluxDensity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ElectricFluxDensity r) {  
		return !(this.equals(r));
	}
	
	public ElectricFluxDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ElectricFluxDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricFluxDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ElectricFluxDensity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricFluxDensity min(ElectricFluxDensity r) { // units maintained
		if (r.lessThan(this)) return new ElectricFluxDensity(r.getX(),r.getU(),r.getUnits()); 
		return new ElectricFluxDensity(this.getX(),this.getU(),this.getUnits());
	}
	public ElectricFluxDensity max(ElectricFluxDensity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ElectricFluxDensity(r.getX(),r.getU(),r.getUnits());
		return new ElectricFluxDensity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ElectricFluxDensity mult(double r) {  
		return new ElectricFluxDensity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ElectricFluxDensity divideBy(double r) {  
		return new ElectricFluxDensity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ElectricFluxDensity clone() {
		return new ElectricFluxDensity(this.getUReal(),this.getUnits());
	}


}
