package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class LuminousIntensity extends Quantity {

	static protected boolean checkUnit(Unit u) {
	    double [] x = new double [BaseUnits.values().length];
	    Arrays.fill(x, 0.0);
	    x[BaseUnits.Candela.ordinal()] = 1.0;
	    return Arrays.equals(x,u.dimensions);
	}

	public LuminousIntensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LuminousIntensity");
    	this.unit = new Unit (q.unit);
    }
    public LuminousIntensity () {
        value = new UReal();
        unit = new Unit(BaseUnits.Candela);
    }

    public LuminousIntensity(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Candela);
    }

    public LuminousIntensity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LuminousIntensity");
    	this.unit = new Unit (unit);
    }

	public LuminousIntensity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(BaseUnits.Candela);
	}
  
    public LuminousIntensity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Candela);
   }
    
    public LuminousIntensity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LuminousIntensity");
    	this.unit = new Unit (unit);
   }

    public LuminousIntensity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LuminousIntensity");
    	this.unit = new Unit (unit);
    }

    public LuminousIntensity(String x) { //creates an LuminousIntensity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Candela);
   }
    
    public LuminousIntensity(String x, String u) { //creates an LuminousIntensity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Candela);
   }
   
    public LuminousIntensity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LuminousIntensity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LuminousIntensity add(LuminousIntensity r) {  //only works if compatible units && operand has no offset
		
		return new LuminousIntensity(super.add(r));
	}
	
	public LuminousIntensity minus(LuminousIntensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new LuminousIntensity(super.minus(r));
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
	
	public LuminousIntensity abs() { //units are maintained
		return new LuminousIntensity(super.abs());
	}
	
	public LuminousIntensity neg() { //units are maintained
		return new LuminousIntensity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LuminousIntensity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LuminousIntensity r) {  
		return !(this.equals(r));
	}
	
	public LuminousIntensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LuminousIntensity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LuminousIntensity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LuminousIntensity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LuminousIntensity min(LuminousIntensity r) { // units maintained
		if (r.lessThan(this)) return new LuminousIntensity(r.getX(),r.getU(),r.getUnits()); 
		return new LuminousIntensity(this.getX(),this.getU(),this.getUnits());
	}
	public LuminousIntensity max(LuminousIntensity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LuminousIntensity(r.getX(),r.getU(),r.getUnits());
		return new LuminousIntensity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LuminousIntensity mult(double r) {  
		return new LuminousIntensity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LuminousIntensity divideBy(double r) {  
		return new LuminousIntensity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	public LuminousIntensity mult(UReal r) {  
		return new LuminousIntensity(this.value.mult(r),this.getUnits());
	}
	
	public LuminousIntensity divideBy(UReal r) {  
		return new LuminousIntensity(this.value.divideBy(r),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LuminousIntensity clone() {
		return new LuminousIntensity(this.getUReal(),this.getUnits());
	}


}
