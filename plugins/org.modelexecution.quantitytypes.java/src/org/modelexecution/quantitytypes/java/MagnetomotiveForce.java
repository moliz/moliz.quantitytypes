package org.modelexecution.quantitytypes.java;

public class MagnetomotiveForce extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int k = BaseUnits.Radian.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagnetomotiveForce(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
    	this.unit = new Unit (q.unit);
    }
    public MagnetomotiveForce () {
        value = new UReal();
        unit = new Unit(DerivedUnits.AmpereTurn);
    }

    public MagnetomotiveForce(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.AmpereTurn);
    }

    public MagnetomotiveForce(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagnetomotiveForce");
    	this.unit = new Unit (unit);
    }

	public MagnetomotiveForce(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.AmpereTurn);
	}
  
    public MagnetomotiveForce (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmpereTurn);
   }
    
    public MagnetomotiveForce(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagnetomotiveForce");
    	this.unit = new Unit (unit);
   }

    public MagnetomotiveForce(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagnetomotiveForce");
    	this.unit = new Unit (unit);
    }

    public MagnetomotiveForce(String x) { //creates an MagnetomotiveForce from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.AmpereTurn);
   }
    
    public MagnetomotiveForce(String x, String u) { //creates an MagnetomotiveForce from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.AmpereTurn);
   }
   
    public MagnetomotiveForce(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MagnetomotiveForce add(MagnetomotiveForce r) {  //only works if compatible units && operand has no offset
		
		return new MagnetomotiveForce(super.add(r));
	}
	
	public MagnetomotiveForce minus(MagnetomotiveForce r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MagnetomotiveForce(super.minus(r));
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
	
	public MagnetomotiveForce abs() { //units are maintained
		return new MagnetomotiveForce(super.abs());
	}
	
	public MagnetomotiveForce neg() { //units are maintained
		return new MagnetomotiveForce(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MagnetomotiveForce r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MagnetomotiveForce r) {  
		return !(this.equals(r));
	}
	
	public MagnetomotiveForce floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MagnetomotiveForce(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MagnetomotiveForce round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MagnetomotiveForce(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MagnetomotiveForce min(MagnetomotiveForce r) { // units maintained
		if (r.lessThan(this)) return new MagnetomotiveForce(r.getX(),r.getU(),r.getUnits()); 
		return new MagnetomotiveForce(this.getX(),this.getU(),this.getUnits());
	}
	public MagnetomotiveForce max(MagnetomotiveForce r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MagnetomotiveForce(r.getX(),r.getU(),r.getUnits());
		return new MagnetomotiveForce(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MagnetomotiveForce mult(double r) {  
		return new MagnetomotiveForce(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MagnetomotiveForce divideBy(double r) {  
		return new MagnetomotiveForce(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MagnetomotiveForce clone() {
		return new MagnetomotiveForce(this.getUReal(),this.getUnits());
	}


}
