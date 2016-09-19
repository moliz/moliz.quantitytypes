package org.modelexecution.quantitytypes.java;

public class ThermodynamicTemperature extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kelvin.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ThermodynamicTemperature(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
    	this.unit = new Unit (q.unit);
    }
    public ThermodynamicTemperature () {
        value = new UReal();
        unit = new Unit(BaseUnits.Kelvin);
    }

    public ThermodynamicTemperature(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Kelvin);
    }

    public ThermodynamicTemperature(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermodynamicTemperature");
    	this.unit = new Unit (unit);
    }

	public ThermodynamicTemperature(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(BaseUnits.Kelvin);
	}
  
    public ThermodynamicTemperature (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Kelvin);
   }
    
    public ThermodynamicTemperature(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermodynamicTemperature");
    	this.unit = new Unit (unit);
   }

    public ThermodynamicTemperature(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermodynamicTemperature");
    	this.unit = new Unit (unit);
    }

    public ThermodynamicTemperature(String x) { //creates an ThermodynamicTemperature from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Kelvin);
   }
    
    public ThermodynamicTemperature(String x, String u) { //creates an ThermodynamicTemperature from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Kelvin);
   }
   
    public ThermodynamicTemperature(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ThermodynamicTemperature add(ThermodynamicTemperature r) {  //only works if compatible units && operand has no offset
		
		return new ThermodynamicTemperature(super.add(r));
	}
	
	public ThermodynamicTemperature minus(ThermodynamicTemperature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ThermodynamicTemperature(super.minus(r));
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
	
	public ThermodynamicTemperature abs() { //units are maintained
		return new ThermodynamicTemperature(super.abs());
	}
	
	public ThermodynamicTemperature neg() { //units are maintained
		return new ThermodynamicTemperature(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ThermodynamicTemperature r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ThermodynamicTemperature r) {  
		return !(this.equals(r));
	}
	
	public ThermodynamicTemperature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ThermodynamicTemperature(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ThermodynamicTemperature round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ThermodynamicTemperature(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ThermodynamicTemperature min(ThermodynamicTemperature r) { // units maintained
		if (r.lessThan(this)) return new ThermodynamicTemperature(r.getX(),r.getU(),r.getUnits()); 
		return new ThermodynamicTemperature(this.getX(),this.getU(),this.getUnits());
	}
	public ThermodynamicTemperature max(ThermodynamicTemperature r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ThermodynamicTemperature(r.getX(),r.getU(),r.getUnits());
		return new ThermodynamicTemperature(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ThermodynamicTemperature mult(double r) {  
		return new ThermodynamicTemperature(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ThermodynamicTemperature divideBy(double r) {  
		return new ThermodynamicTemperature(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ThermodynamicTemperature clone() {
		return new ThermodynamicTemperature(this.getUReal(),this.getUnits());
	}


}
