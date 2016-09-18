package org.modelexecution.quantitytypes.java;

public class ElectricChargeLineDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Ampere.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[s]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricChargeLineDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeLineDensity");
    	this.unit = new Unit (q.unit);
    }
    public ElectricChargeLineDensity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.CoulombPerMeter);
    }

    public ElectricChargeLineDensity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.CoulombPerMeter);
    }

    public ElectricChargeLineDensity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeLineDensity");
    	this.unit = new Unit (unit);
    }

	public ElectricChargeLineDensity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.CoulombPerMeter);
	}
  
    public ElectricChargeLineDensity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CoulombPerMeter);
   }
    
    public ElectricChargeLineDensity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeLineDensity");
    	this.unit = new Unit (unit);
   }

    public ElectricChargeLineDensity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeLineDensity");
    	this.unit = new Unit (unit);
    }

    public ElectricChargeLineDensity(String x) { //creates an ElectricChargeLineDensity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.CoulombPerMeter);
   }
    
    public ElectricChargeLineDensity(String x, String u) { //creates an ElectricChargeLineDensity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.CoulombPerMeter);
   }
   
    public ElectricChargeLineDensity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeLineDensity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ElectricChargeLineDensity add(ElectricChargeLineDensity r) {  //only works if compatible units && operand has no offset
		
		return new ElectricChargeLineDensity(super.add(r));
	}
	
	public ElectricChargeLineDensity minus(ElectricChargeLineDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ElectricChargeLineDensity(super.minus(r));
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
	
	public ElectricChargeLineDensity abs() { //units are maintained
		return new ElectricChargeLineDensity(super.abs());
	}
	
	public ElectricChargeLineDensity neg() { //units are maintained
		return new ElectricChargeLineDensity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ElectricChargeLineDensity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ElectricChargeLineDensity r) {  
		return !(this.equals(r));
	}
	
	public ElectricChargeLineDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ElectricChargeLineDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricChargeLineDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ElectricChargeLineDensity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricChargeLineDensity min(ElectricChargeLineDensity r) { // units maintained
		if (r.lessThan(this)) return new ElectricChargeLineDensity(r.getX(),r.getU(),r.getUnits()); 
		return new ElectricChargeLineDensity(this.getX(),this.getU(),this.getUnits());
	}
	public ElectricChargeLineDensity max(ElectricChargeLineDensity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ElectricChargeLineDensity(r.getX(),r.getU(),r.getUnits());
		return new ElectricChargeLineDensity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ElectricChargeLineDensity mult(double r) {  
		return new ElectricChargeLineDensity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ElectricChargeLineDensity divideBy(double r) {  
		return new ElectricChargeLineDensity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ElectricChargeLineDensity clone() {
		return new ElectricChargeLineDensity(this.getUReal(),this.getUnits());
	}


}
