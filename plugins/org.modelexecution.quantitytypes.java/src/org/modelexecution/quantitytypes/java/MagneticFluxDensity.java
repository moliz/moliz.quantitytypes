package org.modelexecution.quantitytypes.java;

public class MagneticFluxDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagneticFluxDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
    	this.unit = new Unit (q.unit);
    }
    public MagneticFluxDensity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Tesla);
    }

    public MagneticFluxDensity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Tesla);
    }

    public MagneticFluxDensity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFluxDensity");
    	this.unit = new Unit (unit);
    }

	public MagneticFluxDensity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Tesla);
	}
  
    public MagneticFluxDensity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Tesla);
   }
    
    public MagneticFluxDensity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFluxDensity");
    	this.unit = new Unit (unit);
   }

    public MagneticFluxDensity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFluxDensity");
    	this.unit = new Unit (unit);
    }

    public MagneticFluxDensity(String x) { //creates an MagneticFluxDensity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Tesla);
   }
    
    public MagneticFluxDensity(String x, String u) { //creates an MagneticFluxDensity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Tesla);
   }
   
    public MagneticFluxDensity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MagneticFluxDensity add(MagneticFluxDensity r) {  //only works if compatible units && operand has no offset
		
		return new MagneticFluxDensity(super.add(r));
	}
	
	public MagneticFluxDensity minus(MagneticFluxDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MagneticFluxDensity(super.minus(r));
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
	
	public MagneticFluxDensity abs() { //units are maintained
		return new MagneticFluxDensity(super.abs());
	}
	
	public MagneticFluxDensity neg() { //units are maintained
		return new MagneticFluxDensity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MagneticFluxDensity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MagneticFluxDensity r) {  
		return !(this.equals(r));
	}
	
	public MagneticFluxDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MagneticFluxDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFluxDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MagneticFluxDensity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFluxDensity min(MagneticFluxDensity r) { // units maintained
		if (r.lessThan(this)) return new MagneticFluxDensity(r.getX(),r.getU(),r.getUnits()); 
		return new MagneticFluxDensity(this.getX(),this.getU(),this.getUnits());
	}
	public MagneticFluxDensity max(MagneticFluxDensity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MagneticFluxDensity(r.getX(),r.getU(),r.getUnits());
		return new MagneticFluxDensity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MagneticFluxDensity mult(double r) {  
		return new MagneticFluxDensity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MagneticFluxDensity divideBy(double r) {  
		return new MagneticFluxDensity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MagneticFluxDensity clone() {
		return new MagneticFluxDensity(this.getUReal(),this.getUnits());
	}


}
