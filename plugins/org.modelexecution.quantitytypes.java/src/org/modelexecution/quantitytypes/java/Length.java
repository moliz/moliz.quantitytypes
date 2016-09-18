package org.modelexecution.quantitytypes.java;

//READY

/**
 * @author av
 * 
 */
public class Length extends Quantity {
	
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    /**
     * Constructors 
     */
    public Length () {
        value = new UReal();
        unit = new Unit(BaseUnits.Meter);
    }

    public Length(UReal u){
    	value = u.clone();
        unit = new Unit(BaseUnits.Meter);
    }

    public Length(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
    }

    public Length(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (q.unit);
    }

	public Length(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(BaseUnits.Meter);
	}
  
    public Length (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Meter);
   }
    
    public Length(double x, Unit unit){ //we only allow Length Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
   }

    public Length(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
    }

    public Length(String x) { //creates an Length from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(BaseUnits.Meter);
   }
    
    public Length(String x, String u) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(BaseUnits.Meter);
   }
   
    public Length(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Length add(Length r) {  //only works if compatible units && operand has no offset
		
		return new Length(super.add(r));
	}
	
	public Length minus(Length r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Length(super.minus(r));
	}

	public LengthMass mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LengthMass(super.mult(r));
	}
	
	public LengthTemperature mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LengthTemperature(super.mult(r));
	}

	public Area mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Area(super.mult(r));
	}
	
	public Volume mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Volume(super.mult(r));
	}
	
	public LinearMomentum mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LinearMomentum(super.mult(r));
	}
		
	public LinearVelocity divideBy(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LinearVelocity(super.divideBy(r));
	}
	
	public LinearThermalExpansion divideBy(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new LinearThermalExpansion(super.divideBy(r));
	}
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public Length abs() { //units are maintained
		return new Length(super.abs());
	}
	
	public Length neg() { //units are maintained
		return new Length(super.neg());
	}

    // power(s), sqrt() and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Length r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Length r) {  
		return !(super.equals(r));
	}
	
	public Length floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Length(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Length round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Length(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Length min(Length r) { // units maintained
		if (r.lessThan(this)) return new Length(r.getX(),r.getU(),r.getUnits()); 
		return new Length(this.getX(),this.getU(),this.getUnits());
	}
	public Length max(Length r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Length(r.getX(),r.getU(),r.getUnits());
		return new Length(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Length mult(double r) {  
		return new Length(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Length divideBy(double r) {  
		return new Length(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Length clone() {
		return new Length(this.getUReal(),this.getUnits());
	}

}
