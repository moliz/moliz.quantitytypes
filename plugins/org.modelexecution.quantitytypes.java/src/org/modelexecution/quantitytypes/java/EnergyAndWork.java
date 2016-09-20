package org.modelexecution.quantitytypes.java;


public class EnergyAndWork extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=s)&&(i!=k)&&(i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public EnergyAndWork(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
    	this.unit = new Unit (q.unit);
    }
    public EnergyAndWork () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Joule);
    }

    public EnergyAndWork(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Joule);
    }

    public EnergyAndWork(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyAndWork");
    	this.unit = new Unit (unit);
    }

	public EnergyAndWork(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Joule);
	}
  
    public EnergyAndWork (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Joule);
   }
    
    public EnergyAndWork(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyAndWork");
    	this.unit = new Unit (unit);
   }

    public EnergyAndWork(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyAndWork");
    	this.unit = new Unit (unit);
    }

    public EnergyAndWork(String x) { //creates an EnergyAndWork from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Joule);
   }
    
    public EnergyAndWork(String x, String u) { //creates an EnergyAndWork from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Joule);
   }
   
    public EnergyAndWork(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public EnergyAndWork add(EnergyAndWork r) {  //only works if compatible units && operand has no offset
		
		return new EnergyAndWork(super.add(r));
	}
	
	public EnergyAndWork minus(EnergyAndWork r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new EnergyAndWork(super.minus(r));
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
	
	public EnergyAndWork abs() { //units are maintained
		return new EnergyAndWork(super.abs());
	}
	
	public EnergyAndWork neg() { //units are maintained
		return new EnergyAndWork(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(EnergyAndWork r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(EnergyAndWork r) {  
		return !(this.equals(r));
	}
	
	public EnergyAndWork floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new EnergyAndWork(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public EnergyAndWork round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new EnergyAndWork(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public EnergyAndWork min(EnergyAndWork r) { // units maintained
		if (r.lessThan(this)) return new EnergyAndWork(r.getX(),r.getU(),r.getUnits()); 
		return new EnergyAndWork(this.getX(),this.getU(),this.getUnits());
	}
	public EnergyAndWork max(EnergyAndWork r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new EnergyAndWork(r.getX(),r.getU(),r.getUnits());
		return new EnergyAndWork(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public EnergyAndWork mult(double r) {  
		return new EnergyAndWork(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public EnergyAndWork divideBy(double r) {  
		return new EnergyAndWork(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public EnergyAndWork clone() {
		return new EnergyAndWork(this.getUReal(),this.getUnits());
	}


}
