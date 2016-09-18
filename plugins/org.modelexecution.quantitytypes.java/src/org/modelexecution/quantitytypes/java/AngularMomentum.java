package org.modelexecution.quantitytypes.java;

public class AngularMomentum extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[s]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=k)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AngularMomentum(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an AngularMomentum");
    	this.unit = new Unit (q.unit);
    }
    public AngularMomentum () {
        value = new UReal();
        unit = new Unit(DerivedUnits.JouleSecond);
    }

    public AngularMomentum(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.JouleSecond);
    }

    public AngularMomentum(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMomentum");
    	this.unit = new Unit (unit);
    }

	public AngularMomentum(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.JouleSecond);
	}
  
    public AngularMomentum (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JouleSecond);
   }
    
    public AngularMomentum(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMomentum");
    	this.unit = new Unit (unit);
   }

    public AngularMomentum(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMomentum");
    	this.unit = new Unit (unit);
    }

    public AngularMomentum(String x) { //creates an AngularMomentum from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.JouleSecond);
   }
    
    public AngularMomentum(String x, String u) { //creates an AngularMomentum from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.JouleSecond);
   }
   
    public AngularMomentum(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMomentum");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public AngularMomentum add(AngularMomentum r) {  //only works if compatible units && operand has no offset
		
		return new AngularMomentum(super.add(r));
	}
	
	public AngularMomentum minus(AngularMomentum r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new AngularMomentum(super.minus(r));
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
	
	public AngularMomentum abs() { //units are maintained
		return new AngularMomentum(super.abs());
	}
	
	public AngularMomentum neg() { //units are maintained
		return new AngularMomentum(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(AngularMomentum r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(AngularMomentum r) {  
		return !(this.equals(r));
	}
	
	public AngularMomentum floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new AngularMomentum(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public AngularMomentum round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new AngularMomentum(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public AngularMomentum min(AngularMomentum r) { // units maintained
		if (r.lessThan(this)) return new AngularMomentum(r.getX(),r.getU(),r.getUnits()); 
		return new AngularMomentum(this.getX(),this.getU(),this.getUnits());
	}
	public AngularMomentum max(AngularMomentum r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new AngularMomentum(r.getX(),r.getU(),r.getUnits());
		return new AngularMomentum(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public AngularMomentum mult(double r) {  
		return new AngularMomentum(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public AngularMomentum divideBy(double r) {  
		return new AngularMomentum(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public AngularMomentum clone() {
		return new AngularMomentum(this.getUReal(),this.getUnits());
	}


}
