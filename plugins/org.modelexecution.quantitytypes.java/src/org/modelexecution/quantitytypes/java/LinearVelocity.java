package org.modelexecution.quantitytypes.java;


//READY

public class LinearVelocity extends Quantity {

	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    /**
     * Constructors 
     */
	
	public LinearVelocity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (q.unit);
    }

    public LinearVelocity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.MeterPerSecond);
    }

    public LinearVelocity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.MeterPerSecond);
    }

    public LinearVelocity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (unit);
    }

	public LinearVelocity(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(DerivedUnits.MeterPerSecond);
	}
  
    public LinearVelocity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerSecond);
   }
    
    public LinearVelocity(double x, Unit unit){ //we only allow Length Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (unit);
   }

    public LinearVelocity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
    }

    public LinearVelocity(String x) { //creates an Length from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.MeterPerSecond);
   }
    
    public LinearVelocity(String x, String u) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.MeterPerSecond);
   }
   
    public LinearVelocity(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public LinearVelocity add(LinearVelocity r) {  //only works if compatible units && operand has no offset
		return new LinearVelocity (super.add(r));
	}
	
	public LinearVelocity minus(LinearVelocity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
		return new LinearVelocity(super.minus(r));
	}

	public AbsorbedDose mult(LinearVelocity r) { 
		return new AbsorbedDose(super.mult(r));
	}

	public LinearAcceleration divideBy(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LinearAcceleration(super.divideBy(r));
	}

	public Force mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Force (super.mult(r));
	}
	
	public LinearMomentum mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LinearMomentum(super.mult(r));
	}
	
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public LinearVelocity abs() { //units are maintained
		return new LinearVelocity(super.abs());
	}
	
	public LinearVelocity neg() { //units are maintained
		return new LinearVelocity(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(LinearVelocity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(LinearVelocity r) {  
		return !(this.equals(r));
	}
	
	public LinearVelocity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new LinearVelocity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public LinearVelocity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new LinearVelocity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public LinearVelocity min(LinearVelocity r) { // units maintained
		if (r.lessThan(this)) return new LinearVelocity(r.getX(),r.getU(),r.getUnits()); 
		return new LinearVelocity(this.getX(),this.getU(),this.getUnits());
	}
	public LinearVelocity max(LinearVelocity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new LinearVelocity(r.getX(),r.getU(),r.getUnits());
		return new LinearVelocity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public LinearVelocity mult(double r) {  
		return new LinearVelocity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public LinearVelocity divideBy(double r) {  
		return new LinearVelocity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	public LinearVelocity mult(UReal r) {  
		return new LinearVelocity(this.value.mult(r),this.getUnits());
	}
	
	public LinearVelocity divideBy(UReal r) {  
		return new LinearVelocity(this.value.divideBy(r),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public LinearVelocity clone() {
		return new LinearVelocity(this.getUReal(),this.getUnits());
	}


}
