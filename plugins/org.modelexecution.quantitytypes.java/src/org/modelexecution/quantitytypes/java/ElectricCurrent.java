package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

// IN PROGRESS

public class ElectricCurrent extends Quantity {

	static protected boolean checkUnit(Unit u) {
	    double [] x = new double [BaseUnits.values().length];
	    Arrays.fill(x, 0.0);
	    x[BaseUnits.Ampere.ordinal()] = 1.0;
	    return Arrays.equals(x,u.dimensions);
	}

	public ElectricCurrent(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
    	this.unit = new Unit (q.unit);
    }

    public ElectricCurrent () {
        value = new UReal();
        unit = new Unit(BaseUnits.Ampere);
    }

    public ElectricCurrent(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Ampere);
    }

    public ElectricCurrent(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrent");
    	this.unit = new Unit (unit);
    }

	public ElectricCurrent(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(BaseUnits.Ampere);
	}
  
    public ElectricCurrent (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Ampere);
   }
    
    public ElectricCurrent(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrent");
    	this.unit = new Unit (unit);
   }

    public ElectricCurrent(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrent");
    	this.unit = new Unit (unit);
    }

    public ElectricCurrent(String x) { //creates an ElectricCurrent from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Ampere);
   }
    
    public ElectricCurrent(String x, String u) { //creates an ElectricCurrent from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Ampere);
   }
   
    public ElectricCurrent(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ElectricCurrent add(ElectricCurrent r) {  //only works if compatible units && operand has no offset
		
		return new ElectricCurrent(super.add(r));
	}
	
	public ElectricCurrent minus(ElectricCurrent r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ElectricCurrent(super.minus(r));
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
	
	public ElectricCurrent abs() { //units are maintained
		return new ElectricCurrent(super.abs());
	}
	
	public ElectricCurrent neg() { //units are maintained
		return new ElectricCurrent(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ElectricCurrent r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ElectricCurrent r) {  
		return !(this.equals(r));
	}
	
	public ElectricCurrent floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ElectricCurrent(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCurrent round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ElectricCurrent(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ElectricCurrent min(ElectricCurrent r) { // units maintained
		if (r.lessThan(this)) return new ElectricCurrent(r.getX(),r.getU(),r.getUnits()); 
		return new ElectricCurrent(this.getX(),this.getU(),this.getUnits());
	}
	public ElectricCurrent max(ElectricCurrent r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ElectricCurrent(r.getX(),r.getU(),r.getUnits());
		return new ElectricCurrent(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ElectricCurrent mult(double r) {  
		return new ElectricCurrent(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ElectricCurrent divideBy(double r) {  
		return new ElectricCurrent(this.value.divideBy(new UReal(r)),this.getUnits());
	}
	
	public ElectricCurrent mult(UReal r) {  
		return new ElectricCurrent(this.value.mult(r),this.getUnits());
	}
	
	public ElectricCurrent divideBy(UReal r) {  
		return new ElectricCurrent(this.value.divideBy(r),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ElectricCurrent clone() {
		return new ElectricCurrent(this.getUReal(),this.getUnits());
	}


}
