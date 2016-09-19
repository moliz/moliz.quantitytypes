package org.modelexecution.quantitytypes.java;

public class MagneticDipoleMoment extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Ampere.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagneticDipoleMoment(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
    	this.unit = new Unit (q.unit);
    }

    public MagneticDipoleMoment () {
        value = new UReal();
        unit = new Unit(DerivedUnits.JoulePerTesla);
    }

    public MagneticDipoleMoment(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.JoulePerTesla);
    }

    public MagneticDipoleMoment(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticDipoleMoment");
    	this.unit = new Unit (unit);
    }

	public MagneticDipoleMoment(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.JoulePerTesla);
	}
  
    public MagneticDipoleMoment (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JoulePerTesla);
   }
    
    public MagneticDipoleMoment(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticDipoleMoment");
    	this.unit = new Unit (unit);
   }

    public MagneticDipoleMoment(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticDipoleMoment");
    	this.unit = new Unit (unit);
    }

    public MagneticDipoleMoment(String x) { //creates an MagneticDipoleMoment from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.JoulePerTesla);
   }
    
    public MagneticDipoleMoment(String x, String u) { //creates an MagneticDipoleMoment from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JoulePerTesla);
   }
   
    public MagneticDipoleMoment(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticDipoleMoment");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public MagneticDipoleMoment add(MagneticDipoleMoment r) {  //only works if compatible units && operand has no offset
		
		return new MagneticDipoleMoment(super.add(r));
	}
	
	public MagneticDipoleMoment minus(MagneticDipoleMoment r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new MagneticDipoleMoment(super.minus(r));
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
	
	public MagneticDipoleMoment abs() { //units are maintained
		return new MagneticDipoleMoment(super.abs());
	}
	
	public MagneticDipoleMoment neg() { //units are maintained
		return new MagneticDipoleMoment(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(MagneticDipoleMoment r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(MagneticDipoleMoment r) {  
		return !(this.equals(r));
	}
	
	public MagneticDipoleMoment floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new MagneticDipoleMoment(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticDipoleMoment round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new MagneticDipoleMoment(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public MagneticDipoleMoment min(MagneticDipoleMoment r) { // units maintained
		if (r.lessThan(this)) return new MagneticDipoleMoment(r.getX(),r.getU(),r.getUnits()); 
		return new MagneticDipoleMoment(this.getX(),this.getU(),this.getUnits());
	}
	public MagneticDipoleMoment max(MagneticDipoleMoment r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new MagneticDipoleMoment(r.getX(),r.getU(),r.getUnits());
		return new MagneticDipoleMoment(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public MagneticDipoleMoment mult(double r) {  
		return new MagneticDipoleMoment(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public MagneticDipoleMoment divideBy(double r) {  
		return new MagneticDipoleMoment(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public MagneticDipoleMoment clone() {
		return new MagneticDipoleMoment(this.getUReal(),this.getUnits());
	}


}
