package org.modelexecution.quantitytypes.java;

public class HeatFlowRatePerUnitArea extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int t = BaseUnits.Second.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[t]!=-3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=m)&&(i!=t)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public HeatFlowRatePerUnitArea(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an HeatFlowRatePerUnitArea");
    	this.unit = new Unit (q.unit);
    }

    public HeatFlowRatePerUnitArea () {
        value = new UReal();
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
    }

    public HeatFlowRatePerUnitArea(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
    }

    public HeatFlowRatePerUnitArea(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatFlowRatePerUnitArea");
    	this.unit = new Unit (unit);
    }

	public HeatFlowRatePerUnitArea(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
	}
  
    public HeatFlowRatePerUnitArea (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
    
    public HeatFlowRatePerUnitArea(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatFlowRatePerUnitArea");
    	this.unit = new Unit (unit);
   }

    public HeatFlowRatePerUnitArea(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatFlowRatePerUnitArea");
    	this.unit = new Unit (unit);
    }

    public HeatFlowRatePerUnitArea(String x) { //creates an HeatFlowRatePerUnitArea from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
    
    public HeatFlowRatePerUnitArea(String x, String u) { //creates an HeatFlowRatePerUnitArea from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.WattPerSquareMeter);
   }
   
    public HeatFlowRatePerUnitArea(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a HeatFlowRatePerUnitArea");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public HeatFlowRatePerUnitArea add(HeatFlowRatePerUnitArea r) {  //only works if compatible units && operand has no offset
		
		return new HeatFlowRatePerUnitArea(super.add(r));
	}
	
	public HeatFlowRatePerUnitArea minus(HeatFlowRatePerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new HeatFlowRatePerUnitArea(super.minus(r));
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
	
	public HeatFlowRatePerUnitArea abs() { //units are maintained
		return new HeatFlowRatePerUnitArea(super.abs());
	}
	
	public HeatFlowRatePerUnitArea neg() { //units are maintained
		return new HeatFlowRatePerUnitArea(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(HeatFlowRatePerUnitArea r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(HeatFlowRatePerUnitArea r) {  
		return !(this.equals(r));
	}
	
	public HeatFlowRatePerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new HeatFlowRatePerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public HeatFlowRatePerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new HeatFlowRatePerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public HeatFlowRatePerUnitArea min(HeatFlowRatePerUnitArea r) { // units maintained
		if (r.lessThan(this)) return new HeatFlowRatePerUnitArea(r.getX(),r.getU(),r.getUnits()); 
		return new HeatFlowRatePerUnitArea(this.getX(),this.getU(),this.getUnits());
	}
	public HeatFlowRatePerUnitArea max(HeatFlowRatePerUnitArea r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new HeatFlowRatePerUnitArea(r.getX(),r.getU(),r.getUnits());
		return new HeatFlowRatePerUnitArea(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus do not work here
	 */

	public HeatFlowRatePerUnitArea mult(double r) {  
		return new HeatFlowRatePerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public HeatFlowRatePerUnitArea divideBy(double r) {  
		return new HeatFlowRatePerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public HeatFlowRatePerUnitArea clone() {
		return new HeatFlowRatePerUnitArea(this.getUReal(),this.getUnits());
	}



}
