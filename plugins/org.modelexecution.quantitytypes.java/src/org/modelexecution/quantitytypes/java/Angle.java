package org.modelexecution.quantitytypes.java;

//READY

public class Angle extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Radian.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Angle(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an Angle");
    	this.unit = new Unit (q.unit);
    }

    public Angle () {
        value = new UReal();
        unit = new Unit(BaseUnits.Radian);
    }

    public Angle(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Radian);
    }

    public Angle(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
    	this.unit = new Unit (unit);
    }

	public Angle(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(BaseUnits.Radian);
	}
  
    public Angle (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Radian);
   }
    
    public Angle(double x, Unit unit){ //we only allow Length Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
    	this.unit = new Unit (unit);
   }

    public Angle(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
    }

    public Angle(String x) { //creates an Length from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Radian);
   }
    
    public Angle(String x, String u) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Radian);
   }
   
    public Angle(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Angle add(Angle r) {  //only works if compatible units && operand has no offset
		
		return new Angle(super.add(r));
	}
	
	public Angle minus(Angle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Angle(super.minus(r));
	}

	public SolidAngle mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new SolidAngle(super.mult(r));
	}

	public Illuminance mult(Luminance r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Illuminance(super.mult(r));
	}

	public LuminousFlux mult(LuminousIntensity r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LuminousFlux(super.mult(r));
	}
		
	public MagnetomotiveForce mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new MagnetomotiveForce(super.mult(r));
	}
	
	public AngularAcceleration divideBy(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularAcceleration(super.divideBy(r));
	}

	public AngularVelocity divideBy(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularVelocity(super.divideBy(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public Angle abs() { //units are maintained
		return new Angle(super.abs());
	}
	
	public Angle neg() { //units are maintained
		return new Angle(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Angle r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Angle r) {  
		return !(this.equals(r));
	}
	
	public Angle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Angle(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Angle round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Angle(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Angle min(Angle r) { // units maintained
		if (r.lessThan(this)) return new Angle(r.getX(),r.getU(),r.getUnits()); 
		return new Angle(this.getX(),this.getU(),this.getUnits());
	}
	public Angle max(Angle r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Angle(r.getX(),r.getU(),r.getUnits());
		return new Angle(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Angle sMult(double r) {  
		return new Angle(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Angle sDivideBy(double r) {  
		return new Angle(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Angle clone() {
		return new Angle(this.getUReal(),this.getUnits());
	}


}
