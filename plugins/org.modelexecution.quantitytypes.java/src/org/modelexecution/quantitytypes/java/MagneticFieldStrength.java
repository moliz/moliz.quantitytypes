package org.modelexecution.quantitytypes.java;


public class MagneticFieldStrength extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Ampere.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagneticFieldStrength(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFieldStrength");
    	this.unit = new Unit (q.unit);
    }
    public MagneticFieldStrength () {
        value = new UReal();
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
    }

    public MagneticFieldStrength(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
    }

    public MagneticFieldStrength(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFieldStrength");
    	this.unit = new Unit (unit);
    }

	public MagneticFieldStrength(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
	}
  
    public MagneticFieldStrength (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
   }
    
    public MagneticFieldStrength(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFieldStrength");
    	this.unit = new Unit (unit);
   }

    public MagneticFieldStrength(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFieldStrength");
    	this.unit = new Unit (unit);
    }

    public MagneticFieldStrength(String x) { //creates an MagneticFieldStrength from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
   }
    
    public MagneticFieldStrength(String x, String u) { //creates an MagneticFieldStrength from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
   }
   
    public MagneticFieldStrength(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFieldStrength");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MagneticFieldStrength add(MagneticFieldStrength r) {  //only works if compatible units && operand has no offset
		
		return new MagneticFieldStrength(super.add(r));
	}
	
	public MagneticFieldStrength minus(MagneticFieldStrength r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MagneticFieldStrength(super.minus(r));
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
	
	public MagneticFieldStrength abs() { //units are maintained
		return new MagneticFieldStrength(super.abs());
	}
	
	public MagneticFieldStrength neg() { //units are maintained
		return new MagneticFieldStrength(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MagneticFieldStrength r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MagneticFieldStrength r) {  
		return !(this.equals(r));
	}
	
	public MagneticFieldStrength floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MagneticFieldStrength(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFieldStrength round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MagneticFieldStrength(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFieldStrength min(MagneticFieldStrength r) { // units maintained
		if (r.lessThan(this)) return new MagneticFieldStrength(r.getX(),r.getU(),r.getUnits()); 
		return new MagneticFieldStrength(this.getX(),this.getU(),this.getUnits());
	}
	public MagneticFieldStrength max(MagneticFieldStrength r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MagneticFieldStrength(r.getX(),r.getU(),r.getUnits());
		return new MagneticFieldStrength(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MagneticFieldStrength mult(double r) {  
		return new MagneticFieldStrength(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MagneticFieldStrength divideBy(double r) {  
		return new MagneticFieldStrength(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MagneticFieldStrength clone() {
		return new MagneticFieldStrength(this.getUReal(),this.getUnits());
	}


}
