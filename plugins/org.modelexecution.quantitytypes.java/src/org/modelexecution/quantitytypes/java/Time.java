package org.modelexecution.quantitytypes.java;

//READY

public class Time extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[s]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Time(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Time");
    	this.unit = new Unit (q.unit);
    }

	   public Time () {
	        value = new UReal();
	        unit = new Unit(BaseUnits.Second);
	    }

	    public Time(UReal u){
	    	value = u.clone();
	        unit = new Unit(BaseUnits.Second);
	    }

	    public Time(UReal u, Unit unit){
	    	value = u.clone();
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Time");
	    	this.unit = new Unit (unit);
	    }

		public Time(double x){ //"promotes" a real x 
			value = new UReal(x,0.0);
	        unit = new Unit(BaseUnits.Second);
		}
		
	    public Time (double x, double u) {
	    	value = new UReal(x,u);
	        unit = new Unit(BaseUnits.Second);
	   }
	    
	    public Time(double x, Unit unit){ //we only allow Time Units
	    	value = new UReal(x);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Time");
	    	this.unit = new Unit (unit);
	   }

	    public Time(double x, double u, Unit unit){
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Time");
	    	this.unit = new Unit (unit);
	    }


	    public Time(String x) { //creates an Length from a string representing a real, with u=0.
	    	value = new UReal(x);
	        unit = new Unit(BaseUnits.Second);
	   }
	    
	    public Time(String x, String u) { //creates an Length from two strings representing (x,u).
	    	value = new UReal(x,u);
	        unit = new Unit(BaseUnits.Second);
	   }
	   
	    public Time(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Time");
	    	this.unit = new Unit (unit);
	   }

		
		/*********
	     * 
	     * Specific Type Operations
	     */

		public Time add(Time r) {  //only works if compatible units && operand has no offset
			
			return new Time(super.add(r));
		}
		
		public Time minus(Time r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

			return new Time(super.minus(r));
		}

		
		public ElectricCharge mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
			return new ElectricCharge(super.mult(r));
		}
		
		public ElectricChargeLineDensity mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
			return new ElectricChargeLineDensity(super.mult(r));
		}
		
		public ElectricFluxDensity mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
			return new ElectricFluxDensity(super.mult(r));
		}
		
		/** OTHER OPERATIONS
		 * 
		 */
		
		public Time abs() { //units are maintained
			return new Time(super.abs());
		}
		
		public Time neg() { //units are maintained
			return new Time(super.neg());
		}

	    // power(s), sqrt() and inverse() return Quantity
		// lessThan, LessEq, gt, ge all directly from Quantity

		public boolean equals(Time r) {  
			return  r.compatibleUnits(this) && 
					this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
		}

		public boolean distinct(Time r) {  
			return !(this.equals(r));
		}
		
		public Time floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
			return new Time(Math.floor(this.getX()),this.getU(),this.getUnits());
		}
		public Time round(){ //returns (i,u) with i the closest int to x -- units maintained
			return new Time(Math.round(this.getX()),this.getU(),this.getUnits());
		}
		public Time min(Time r) { // units maintained
			if (r.lessThan(this)) return new Time(r.getX(),r.getU(),r.getUnits()); 
			return new Time(this.getX(),this.getU(),this.getUnits());
		}
		public Time max(Time r) { // unit maintained
			//if (r>this) r; else this;
			if (r.gt(this)) return new Time(r.getX(),r.getU(),r.getUnits());
			return new Time(this.getX(),this.getU(),this.getUnits());
		}

		/***
		 * working with constants (note that add and minus do not work here
		 */

		public Time mult(double r) {  
			return new Time(this.value.mult(new UReal(r)),this.getUnits());
		}
		
		public Time divideBy(double r) {  
			return new Time(this.value.divideBy(new UReal(r)),this.getUnits());
		}

		/******
		 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
		 */
		
	 	public int hashcode(){ //required for equals()
			return Math.round((float)value.getX());
		}

	 	public Time clone() {
			return new Time(this.getUReal(),this.getUnits());
		}


}
