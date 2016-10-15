package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

// MISSING SPECIFIC OPERATIONS

public class AmountOfSubstance extends Quantity {

	static protected boolean checkUnit(Unit u) {
	    double [] x = new double [BaseUnits.values().length];
	    Arrays.fill(x, 0.0);
	    x[BaseUnits.Mole.ordinal()] = 1.0;
	    return Arrays.equals(x,u.dimensions);
	}

	public AmountOfSubstance(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AmountOfSubstance");
    	this.unit = new Unit (q.unit);
    }

    public AmountOfSubstance () {
        value = new UReal();
        unit = new Unit(BaseUnits.Mole);
    }

    public AmountOfSubstance(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Mole);
    }

    public AmountOfSubstance(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstance");
    	this.unit = new Unit (unit);
    }

	public AmountOfSubstance(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(BaseUnits.Mole);
	}
  
    public AmountOfSubstance (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Mole);
   }
    
    public AmountOfSubstance(double x, Unit unit){ //we only allow this kind of Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstance");
    	this.unit = new Unit (unit);
   }

    public AmountOfSubstance(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AmountOfSubstance");
    	this.unit = new Unit (unit);
    }

    public AmountOfSubstance(String x) { //creates an AmountOfSubstance from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Mole);
   }
    
    public AmountOfSubstance(String x, String u) { //creates an AmountOfSubstance from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Mole);
   }
   
    public AmountOfSubstance(String x, String u, Unit unit) { //creates an AmountOfSubstance from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstance");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AmountOfSubstance add(AmountOfSubstance r) {  //only works if compatible units && operand has no offset
		return new AmountOfSubstance(super.add(r));
	}
	
	public AmountOfSubstance minus(AmountOfSubstance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
		return new AmountOfSubstance(super.minus(r));
	}


	/** OTHER OPERATIONS
	 * 
	 */
	
	public AmountOfSubstance abs() { //units are maintained
		return new AmountOfSubstance(super.abs());
	}
	
	public AmountOfSubstance neg() { //units are maintained
		return new AmountOfSubstance(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AmountOfSubstance r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AmountOfSubstance r) {  
		return !(this.equals(r));
	}
	
	public AmountOfSubstance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AmountOfSubstance(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AmountOfSubstance round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AmountOfSubstance(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AmountOfSubstance min(AmountOfSubstance r) { // units maintained
		if (r.lessThan(this)) return new AmountOfSubstance(r.getX(),r.getU(),r.getUnits()); 
		return new AmountOfSubstance(this.getX(),this.getU(),this.getUnits());
	}
	public AmountOfSubstance max(AmountOfSubstance r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AmountOfSubstance(r.getX(),r.getU(),r.getUnits());
		return new AmountOfSubstance(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AmountOfSubstance mult(double r) {  
		return new AmountOfSubstance(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AmountOfSubstance divideBy(double r) {  
		return new AmountOfSubstance(this.value.divideBy(new UReal(r)),this.getUnits());
	}
	
	public AmountOfSubstance mult(UReal r) {  
		return new AmountOfSubstance(this.value.mult(r),this.getUnits());
	}
	
	public AmountOfSubstance divideBy(UReal r) {  
		return new AmountOfSubstance(this.value.divideBy(r),this.getUnits());
	}



	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AmountOfSubstance clone() {
		return new AmountOfSubstance(this.getUReal(),this.getUnits());
	}


}
