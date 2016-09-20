package org.modelexecution.quantitytypes.java;


public class LinearThermalExpansion extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kelvin.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[k]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public LinearThermalExpansion(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearThermalExpansion");
    	this.unit = new Unit (q.unit);
    }
    public LinearThermalExpansion () {
        value = new UReal();
        unit = new Unit(DerivedUnits.MeterPerKelvin);
    }

    public LinearThermalExpansion(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.MeterPerKelvin);
    }

    public LinearThermalExpansion(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearThermalExpansion");
    	this.unit = new Unit (unit);
    }

	public LinearThermalExpansion(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterPerKelvin);
	}
  
    public LinearThermalExpansion (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerKelvin);
   }
    
    public LinearThermalExpansion(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearThermalExpansion");
    	this.unit = new Unit (unit);
   }

    public LinearThermalExpansion(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearThermalExpansion");
    	this.unit = new Unit (unit);
    }

    public LinearThermalExpansion(String x) { //creates an LinearThermalExpansion from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterPerKelvin);
   }
    
    public LinearThermalExpansion(String x, String u) { //creates an LinearThermalExpansion from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerKelvin);
   }
   
    public LinearThermalExpansion(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearThermalExpansion");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LinearThermalExpansion add(LinearThermalExpansion r) {  //only works if compatible units && operand has no offset
		
		return new LinearThermalExpansion(super.add(r));
	}
	
	public LinearThermalExpansion minus(LinearThermalExpansion r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new LinearThermalExpansion(super.minus(r));
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
	
	public LinearThermalExpansion abs() { //units are maintained
		return new LinearThermalExpansion(super.abs());
	}
	
	public LinearThermalExpansion neg() { //units are maintained
		return new LinearThermalExpansion(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LinearThermalExpansion r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LinearThermalExpansion r) {  
		return !(this.equals(r));
	}
	
	public LinearThermalExpansion floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LinearThermalExpansion(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LinearThermalExpansion round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LinearThermalExpansion(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LinearThermalExpansion min(LinearThermalExpansion r) { // units maintained
		if (r.lessThan(this)) return new LinearThermalExpansion(r.getX(),r.getU(),r.getUnits()); 
		return new LinearThermalExpansion(this.getX(),this.getU(),this.getUnits());
	}
	public LinearThermalExpansion max(LinearThermalExpansion r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LinearThermalExpansion(r.getX(),r.getU(),r.getUnits());
		return new LinearThermalExpansion(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LinearThermalExpansion mult(double r) {  
		return new LinearThermalExpansion(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LinearThermalExpansion divideBy(double r) {  
		return new LinearThermalExpansion(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LinearThermalExpansion clone() {
		return new LinearThermalExpansion(this.getUReal(),this.getUnits());
	}


}
