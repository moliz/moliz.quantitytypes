package org.modelexecution.quantitytypes.java;

public class HeatflowRate extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int t = BaseUnits.Second.ordinal();
		int l = BaseUnits.Meter.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[t]!=-3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=m)&&(i!=t)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public HeatflowRate(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an HeatflowRate");
    	this.unit = new Unit (q.unit);
    }

    public HeatflowRate () {
        value = new UReal();
        unit = new Unit(DerivedUnits.Watt);
    }

    public HeatflowRate(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.Watt);
    }

    public HeatflowRate(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatflowRate");
    	this.unit = new Unit (unit);
    }

	public HeatflowRate(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.Watt);
	}
  
    public HeatflowRate (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Watt);
   }
    
    public HeatflowRate(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatflowRate");
    	this.unit = new Unit (unit);
   }

    public HeatflowRate(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatflowRate");
    	this.unit = new Unit (unit);
    }

    public HeatflowRate(String x) { //creates an HeatflowRate from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.Watt);
   }
    
    public HeatflowRate(String x, String u) { //creates an HeatflowRate from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.Watt);
   }
   
    public HeatflowRate(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a HeatflowRate");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public HeatflowRate add(HeatflowRate r) {  //only works if compatible units && operand has no offset
		
		return new HeatflowRate(super.add(r));
	}
	
	public HeatflowRate minus(HeatflowRate r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new HeatflowRate(super.minus(r));
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
	
	public HeatflowRate abs() { //units are maintained
		return new HeatflowRate(super.abs());
	}
	
	public HeatflowRate neg() { //units are maintained
		return new HeatflowRate(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(HeatflowRate r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(HeatflowRate r) {  
		return !(this.equals(r));
	}
	
	public HeatflowRate floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new HeatflowRate(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public HeatflowRate round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new HeatflowRate(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public HeatflowRate min(HeatflowRate r) { // units maintained
		if (r.lessThan(this)) return new HeatflowRate(r.getX(),r.getU(),r.getUnits()); 
		return new HeatflowRate(this.getX(),this.getU(),this.getUnits());
	}
	public HeatflowRate max(HeatflowRate r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new HeatflowRate(r.getX(),r.getU(),r.getUnits());
		return new HeatflowRate(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public HeatflowRate mult(double r) {  
		return new HeatflowRate(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public HeatflowRate divideBy(double r) {  
		return new HeatflowRate(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public HeatflowRate clone() {
		return new HeatflowRate(this.getUReal(),this.getUnits());
	}



}
