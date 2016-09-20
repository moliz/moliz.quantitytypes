package org.modelexecution.quantitytypes.java;


public class MagneticFlux extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		int k = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[k]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((k!=i)&&(i!=l)&&(i!=s)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagneticFlux(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
    	this.unit = new Unit (q.unit);
    }
    public MagneticFlux () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Weber);
    }

    public MagneticFlux(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Weber);
    }

    public MagneticFlux(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFlux");
    	this.unit = new Unit (unit);
    }

	public MagneticFlux(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Weber);
	}
  
    public MagneticFlux (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Weber);
   }
    
    public MagneticFlux(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFlux");
    	this.unit = new Unit (unit);
   }

    public MagneticFlux(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFlux");
    	this.unit = new Unit (unit);
    }

    public MagneticFlux(String x) { //creates an MagneticFlux from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Weber);
   }
    
    public MagneticFlux(String x, String u) { //creates an MagneticFlux from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Weber);
   }
   
    public MagneticFlux(String x, String u, Unit unit) { //creates a MagneticFlux from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MagneticFlux add(MagneticFlux r) {  //only works if compatible units && operand has no offset
		
		return new MagneticFlux(super.add(r));
	}
	
	public MagneticFlux minus(MagneticFlux r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MagneticFlux(super.minus(r));
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
	
	public MagneticFlux abs() { //units are maintained
		return new MagneticFlux(super.abs());
	}
	
	public MagneticFlux neg() { //units are maintained
		return new MagneticFlux(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MagneticFlux r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MagneticFlux r) {  
		return !(this.equals(r));
	}
	
	public MagneticFlux floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MagneticFlux(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFlux round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MagneticFlux(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticFlux min(MagneticFlux r) { // units maintained
		if (r.lessThan(this)) return new MagneticFlux(r.getX(),r.getU(),r.getUnits()); 
		return new MagneticFlux(this.getX(),this.getU(),this.getUnits());
	}
	public MagneticFlux max(MagneticFlux r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MagneticFlux(r.getX(),r.getU(),r.getUnits());
		return new MagneticFlux(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MagneticFlux mult(double r) {  
		return new MagneticFlux(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MagneticFlux divideBy(double r) {  
		return new MagneticFlux(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MagneticFlux clone() {
		return new MagneticFlux(this.getUReal(),this.getUnits());
	}


}
