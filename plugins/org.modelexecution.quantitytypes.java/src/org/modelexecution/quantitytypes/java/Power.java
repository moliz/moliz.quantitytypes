package org.modelexecution.quantitytypes.java;

public class Power extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[s]!=-3.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Power(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Power");
    	this.unit = new Unit (q.unit);
    }
    public Power () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Watt);
    }

    public Power(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Watt);
    }

    public Power(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Power");
    	this.unit = new Unit (unit);
    }

	public Power(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Watt);
	}
  
    public Power (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Watt);
   }
    
    public Power(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Power");
    	this.unit = new Unit (unit);
   }

    public Power(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Power");
    	this.unit = new Unit (unit);
    }

    public Power(String x) { //creates an Power from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Watt);
   }
    
    public Power(String x, String u) { //creates an Power from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Watt);
   }
   
    public Power(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Power");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Power add(Power r) {  //only works if compatible units && operand has no offset
		
		return new Power(super.add(r));
	}
	
	public Power minus(Power r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Power(super.minus(r));
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
	
	public Power abs() { //units are maintained
		return new Power(super.abs());
	}
	
	public Power neg() { //units are maintained
		return new Power(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Power r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Power r) {  
		return !(this.equals(r));
	}
	
	public Power floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Power(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Power round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Power(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Power min(Power r) { // units maintained
		if (r.lessThan(this)) return new Power(r.getX(),r.getU(),r.getUnits()); 
		return new Power(this.getX(),this.getU(),this.getUnits());
	}
	public Power max(Power r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Power(r.getX(),r.getU(),r.getUnits());
		return new Power(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Power mult(double r) {  
		return new Power(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Power divideBy(double r) {  
		return new Power(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Power clone() {
		return new Power(this.getUReal(),this.getUnits());
	}


}
