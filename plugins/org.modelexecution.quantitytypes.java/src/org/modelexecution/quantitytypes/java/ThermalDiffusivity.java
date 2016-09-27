package org.modelexecution.quantitytypes.java;

public class ThermalDiffusivity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int t = BaseUnits.Second.ordinal();
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[t]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=t)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ThermalDiffusivity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an ThermalDiffusivity");
    	this.unit = new Unit (q.unit);
    }

    public ThermalDiffusivity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
    }

    public ThermalDiffusivity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
    }

    public ThermalDiffusivity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalDiffusivity");
    	this.unit = new Unit (unit);
    }

	public ThermalDiffusivity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
	}
  
    public ThermalDiffusivity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
    
    public ThermalDiffusivity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalDiffusivity");
    	this.unit = new Unit (unit);
   }

    public ThermalDiffusivity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalDiffusivity");
    	this.unit = new Unit (unit);
    }

    public ThermalDiffusivity(String x) { //creates an ThermalDiffusivity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
    
    public ThermalDiffusivity(String x, String u) { //creates an ThermalDiffusivity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
   
    public ThermalDiffusivity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalDiffusivity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public ThermalDiffusivity add(ThermalDiffusivity r) {  //only works if compatible units && operand has no offset
		
		return new ThermalDiffusivity(super.add(r));
	}
	
	public ThermalDiffusivity minus(ThermalDiffusivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new ThermalDiffusivity(super.minus(r));
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
	
	public ThermalDiffusivity abs() { //units are maintained
		return new ThermalDiffusivity(super.abs());
	}
	
	public ThermalDiffusivity neg() { //units are maintained
		return new ThermalDiffusivity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(ThermalDiffusivity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(ThermalDiffusivity r) {  
		return !(this.equals(r));
	}
	
	public ThermalDiffusivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new ThermalDiffusivity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public ThermalDiffusivity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new ThermalDiffusivity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public ThermalDiffusivity min(ThermalDiffusivity r) { // units maintained
		if (r.lessThan(this)) return new ThermalDiffusivity(r.getX(),r.getU(),r.getUnits()); 
		return new ThermalDiffusivity(this.getX(),this.getU(),this.getUnits());
	}
	public ThermalDiffusivity max(ThermalDiffusivity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new ThermalDiffusivity(r.getX(),r.getU(),r.getUnits());
		return new ThermalDiffusivity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public ThermalDiffusivity mult(double r) {  
		return new ThermalDiffusivity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public ThermalDiffusivity divideBy(double r) {  
		return new ThermalDiffusivity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public ThermalDiffusivity clone() {
		return new ThermalDiffusivity(this.getUReal(),this.getUnits());
	}



}
