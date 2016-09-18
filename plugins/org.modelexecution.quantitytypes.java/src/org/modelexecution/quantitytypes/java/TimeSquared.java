package org.modelexecution.quantitytypes.java;

// READY

public class TimeSquared extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[s]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public TimeSquared(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
    	this.unit = new Unit (q.unit);
    }

	   public TimeSquared () {
	        value = new UReal();
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
	    }

	    public TimeSquared(UReal u){
	    	value = u.clone();
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
	    }

	    public TimeSquared(UReal u, Unit unit){
	    	value = u.clone();
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
	    	this.unit = new Unit (unit);
	    }

		public TimeSquared(double x){ //"promotes" a real x 
			value = new UReal(x,0.0);
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
		}
		
	    public TimeSquared (double x, double u) {
	    	value = new UReal(x,u);
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
	   }
	    
	    public TimeSquared(double x, Unit unit){ //we only allow TimeSquared Units
	    	value = new UReal(x);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
	    	this.unit = new Unit (unit);
	   }

	    public TimeSquared(double x, double u, Unit unit){
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
	    	this.unit = new Unit (unit);
	    }


	    public TimeSquared(String x) { //creates an Length from a string representing a real, with u=0.
	    	value = new UReal(x);
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
	   }
	    
	    public TimeSquared(String x, String u) { //creates an Length from two strings representing (x,u).
	    	value = new UReal(x,u);
	        unit = new Unit(DerivedUnits.SecondTimeSquared);
	   }
	   
	    public TimeSquared(String x, String u, Unit unit) { //creates an Length from two strings representing (x,u).
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
	    	this.unit = new Unit (unit);
	   }

		
		/*********
	     * 
	     * Specific Type Operations
	     */

		public TimeSquared add(TimeSquared r) {  //only works if compatible units && operand has no offset
			
			return new TimeSquared(super.add(r));
		}
		
		public TimeSquared minus(TimeSquared r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

			return new TimeSquared(super.minus(r));
		}

		
		/** OTHER OPERATIONS
		 * 
		 */
		
		public TimeSquared abs() { //units are maintained
			return new TimeSquared(super.abs());
		}
		
		public TimeSquared neg() { //units are maintained
			return new TimeSquared(super.neg());
		}

		public Time sqrt() { 
			return new Time(super.sqrt());
		}

	    // power(s) and inverse() return Quantity
		// lessThan, LessEq, gt, ge all directly from Quantity

		public boolean equals(TimeSquared r) {  
			return  r.compatibleUnits(this) && 
					this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
		}

		public boolean distinct(TimeSquared r) {  
			return !(this.equals(r));
		}
		
		public TimeSquared floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
			return new TimeSquared(Math.floor(this.getX()),this.getU(),this.getUnits());
		}
		public TimeSquared round(){ //returns (i,u) with i the closest int to x -- units maintained
			return new TimeSquared(Math.round(this.getX()),this.getU(),this.getUnits());
		}
		public TimeSquared min(TimeSquared r) { // units maintained
			if (r.lessThan(this)) return new TimeSquared(r.getX(),r.getU(),r.getUnits()); 
			return new TimeSquared(this.getX(),this.getU(),this.getUnits());
		}
		public TimeSquared max(TimeSquared r) { // unit maintained
			//if (r>this) r; else this;
			if (r.gt(this)) return new TimeSquared(r.getX(),r.getU(),r.getUnits());
			return new TimeSquared(this.getX(),this.getU(),this.getUnits());
		}

		/***
		 * working with constants (note that add and minus do not work here
		 */

		public TimeSquared mult(double r) {  
			return new TimeSquared(this.value.mult(new UReal(r)),this.getUnits());
		}
		
		public TimeSquared divideBy(double r) {  
			return new TimeSquared(this.value.divideBy(new UReal(r)),this.getUnits());
		}

		/******
		 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
		 */
		
	 	public int hashcode(){ //required for equals()
			return Math.round((float)value.getX());
		}

	 	public TimeSquared clone() {
			return new TimeSquared(this.getUReal(),this.getUnits());
		}



}
