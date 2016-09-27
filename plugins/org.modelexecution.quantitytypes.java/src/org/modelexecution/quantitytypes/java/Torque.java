package org.modelexecution.quantitytypes.java;

public class Torque extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		int t = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[t]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=t)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Torque(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an Torque");
    	this.unit = new Unit (q.unit);
    }

    public Torque () {
        value = new UReal();
        unit = new Unit(DerivedUnits.NewtonMeter);
    }

    public Torque(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.NewtonMeter);
    }

    public Torque(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Torque");
    	this.unit = new Unit (unit);
    }

	public Torque(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.NewtonMeter);
	}
  
    public Torque (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.NewtonMeter);
   }
    
    public Torque(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Torque");
    	this.unit = new Unit (unit);
   }

    public Torque(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Torque");
    	this.unit = new Unit (unit);
    }

    public Torque(String x) { //creates an Torque from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.NewtonMeter);
   }
    
    public Torque(String x, String u) { //creates an Torque from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.NewtonMeter);
   }
   
    public Torque(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Torque");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Torque add(Torque r) {  //only works if compatible units && operand has no offset
		
		return new Torque(super.add(r));
	}
	
	public Torque minus(Torque r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Torque(super.minus(r));
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
	
	public Torque abs() { //units are maintained
		return new Torque(super.abs());
	}
	
	public Torque neg() { //units are maintained
		return new Torque(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Torque r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Torque r) {  
		return !(this.equals(r));
	}
	
	public Torque floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Torque(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Torque round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Torque(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Torque min(Torque r) { // units maintained
		if (r.lessThan(this)) return new Torque(r.getX(),r.getU(),r.getUnits()); 
		return new Torque(this.getX(),this.getU(),this.getUnits());
	}
	public Torque max(Torque r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Torque(r.getX(),r.getU(),r.getUnits());
		return new Torque(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public Torque mult(double r) {  
		return new Torque(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Torque divideBy(double r) {  
		return new Torque(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Torque clone() {
		return new Torque(this.getUReal(),this.getUnits());
	}



}
