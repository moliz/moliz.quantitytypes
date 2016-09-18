package org.modelexecution.quantitytypes.java;

public class KinematicViscosity extends Quantity {

	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[s]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    /**
     * Constructors 
     */
	public KinematicViscosity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (q.unit);
    }

    public KinematicViscosity () {
        value = new UReal();
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
    }

    public KinematicViscosity(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
    }

    public KinematicViscosity(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an KinematicViscosity");
    	this.unit = new Unit (unit);
    }

	public KinematicViscosity(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
	}
  
    public KinematicViscosity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
    
    public KinematicViscosity(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an KinematicViscosity");
    	this.unit = new Unit (unit);
   }

    public KinematicViscosity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an KinematicViscosity");
    	this.unit = new Unit (unit);
    }

    public KinematicViscosity(String x) { //creates an KinematicViscosity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
    
    public KinematicViscosity(String x, String u) { //creates an KinematicViscosity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeterPerSecond);
   }
   
    public KinematicViscosity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a KinematicViscosity");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public KinematicViscosity add(KinematicViscosity r) {  //only works if compatible units && operand has no offset
		
		return new KinematicViscosity(super.add(r));
	}
	
	public KinematicViscosity minus(KinematicViscosity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new KinematicViscosity(super.minus(r));
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
	
	public KinematicViscosity abs() { //units are maintained
		return new KinematicViscosity(super.abs());
	}
	
	public KinematicViscosity neg() { //units are maintained
		return new KinematicViscosity(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(KinematicViscosity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(KinematicViscosity r) {  
		return !(this.equals(r));
	}
	
	public KinematicViscosity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new KinematicViscosity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public KinematicViscosity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new KinematicViscosity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public KinematicViscosity min(KinematicViscosity r) { // units maintained
		if (r.lessThan(this)) return new KinematicViscosity(r.getX(),r.getU(),r.getUnits()); 
		return new KinematicViscosity(this.getX(),this.getU(),this.getUnits());
	}
	public KinematicViscosity max(KinematicViscosity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new KinematicViscosity(r.getX(),r.getU(),r.getUnits());
		return new KinematicViscosity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public KinematicViscosity mult(double r) {  
		return new KinematicViscosity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public KinematicViscosity divideBy(double r) {  
		return new KinematicViscosity(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public KinematicViscosity clone() {
		return new KinematicViscosity(this.getUReal(),this.getUnits());
	}


}
