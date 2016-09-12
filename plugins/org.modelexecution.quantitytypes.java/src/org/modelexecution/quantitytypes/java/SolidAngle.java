package org.modelexecution.quantitytypes.java;

// READY

public class SolidAngle extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = DerivedUnits.Steradian.ordinal();
		if (u.dimensions[k]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public SolidAngle(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
    	this.unit = new Unit (q.unit);
    }


    public SolidAngle () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Steradian);
    }

    public SolidAngle(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Steradian);
    }

    public SolidAngle(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
    	this.unit = new Unit (unit);
    }

	public SolidAngle(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(DerivedUnits.Steradian);
	}
  
    public SolidAngle (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Steradian);
   }
    
    public SolidAngle(double x, Unit unit){ //we only allow Length Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
    	this.unit = new Unit (unit);
   }

    public SolidAngle(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
    }

    public SolidAngle(String x) { //creates an Length from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Steradian);
   }
    
    public SolidAngle(String x, String u) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Steradian);
   }
   
    public SolidAngle(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public SolidAngle add(SolidAngle r) {  //only works if compatible units && operand has no offset
		
		return new SolidAngle(super.add(r));
	}
	
	public SolidAngle minus(SolidAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new SolidAngle(super.minus(r));
	}

	public Angle divideBy(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Angle(super.divideBy(r));
	}

	public AreaAngle mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AreaAngle(super.mult(r));
	}

	public PowerPerAngle mult(Power r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new PowerPerAngle(super.mult(r));
	}
    public PowerPerAreaAngle  mult(PowerPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new PowerPerAreaAngle(super.mult(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public SolidAngle abs() { //units are maintained
		return new SolidAngle(super.abs());
	}
	
	public SolidAngle neg() { //units are maintained
		return new SolidAngle(super.neg());
	}

	public Angle sqrt() { //units are maintained
		return new Angle(super.sqrt());
	}

    // power(s), inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(SolidAngle r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(SolidAngle r) {  
		return !(this.equals(r));
	}
	
	public SolidAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new SolidAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public SolidAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new SolidAngle(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public SolidAngle min(SolidAngle r) { // units maintained
		if (r.lessThan(this)) return new SolidAngle(r.getX(),r.getU(),r.getUnits()); 
		return new SolidAngle(this.getX(),this.getU(),this.getUnits());
	}
	public SolidAngle max(SolidAngle r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new SolidAngle(r.getX(),r.getU(),r.getUnits());
		return new SolidAngle(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public SolidAngle sMult(double r) {  
		return new SolidAngle(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public SolidAngle sDivideBy(double r) {  
		return new SolidAngle(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public SolidAngle clone() {
		return new SolidAngle(this.getUReal(),this.getUnits());
	}

	
}
