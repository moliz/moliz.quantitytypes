package org.modelexecution.quantitytypes.java;

public class CatalyticActivity extends Quantity {

	//MISSING SPECIFIC OPERATIONS

		static protected boolean checkUnit(Unit u) {
			int l = BaseUnits.Second.ordinal();
			int k = BaseUnits.Mole.ordinal();
			if (u.dimensions[l]!=1.0) return false;
			if (u.dimensions[k]!=1.0) return false;
			for (int i=0;i<u.dimensions.length;i++) {
				if ((i!=l)&&(i!=k)&&(u.dimensions[i]!=0.0)) return false;
			}
			return true;
		}

		public CatalyticActivity(Quantity q){
	    	value = q.value.clone();
	    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an CatalyticActivity");
	    	this.unit = new Unit (q.unit);
	    }

	    public CatalyticActivity () {
	        value = new UReal();
	        unit = new Unit(DerivedUnits.Katal);
	    }

	    public CatalyticActivity(UReal u){
	    	value = u.clone();
	        unit = new Unit(DerivedUnits.Katal);
	    }

	    public CatalyticActivity(UReal u, Unit unit){
	    	value = u.clone();
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CatalyticActivity");
	    	this.unit = new Unit (unit);
	    }

		public CatalyticActivity(double x){ //"promotes" a real x 
			value = new UReal(x);
	        unit = new Unit(DerivedUnits.Katal);
		}
	  
	    public CatalyticActivity (double x, double u) {
	    	value = new UReal(x,u);
	        unit = new Unit(DerivedUnits.Katal);
	   }
	    
	    public CatalyticActivity(double x, Unit unit){ //we only allow the same Units
	    	value = new UReal(x);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CatalyticActivity");
	    	this.unit = new Unit (unit);
	   }

	    public CatalyticActivity(double x, double u, Unit unit){
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CatalyticActivity");
	    	this.unit = new Unit (unit);
	    }

	    public CatalyticActivity(String x) { //creates an CatalyticActivity from a string representing a real, with u=0.
	    	value = new UReal(x);
	        unit = new Unit(DerivedUnits.Katal);
	   }
	    
	    public CatalyticActivity(String x, String u) { //creates an CatalyticActivity from two strings representing (x,u).
	    	value = new UReal(x,u);
	        unit = new Unit(DerivedUnits.Katal);
	   }
	   
	    public CatalyticActivity(String x, String u, Unit unit) { //creates an Angle from two strings representing (x,u).
	    	value = new UReal(x,u);
	    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CatalyticActivity");
	    	this.unit = new Unit (unit);
	   }

		
		/*********
	     * 
	     * Specific Type Operations
	     */

		public CatalyticActivity add(CatalyticActivity r) {  //only works if compatible units && operand has no offset
			
			return new CatalyticActivity(super.add(r));
		}
		
		public CatalyticActivity minus(CatalyticActivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

			return new CatalyticActivity(super.minus(r));
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
		
		public CatalyticActivity abs() { //units are maintained
			return new CatalyticActivity(super.abs());
		}
		
		public CatalyticActivity neg() { //units are maintained
			return new CatalyticActivity(super.neg());
		}

	    // power(s), and inverse() return Quantity
		// lessThan, LessEq, gt, ge all directly from Quantity

		public boolean equals(CatalyticActivity r) {  
			return  r.compatibleUnits(this) && 
					this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
		}

		public boolean distinct(CatalyticActivity r) {  
			return !(this.equals(r));
		}
		
		public CatalyticActivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
			return new CatalyticActivity(Math.floor(this.getX()),this.getU(),this.getUnits());
		}
		public CatalyticActivity round(){ //returns (i,u) with i the closest int to x -- units maintained
			return new CatalyticActivity(Math.round(this.getX()),this.getU(),this.getUnits());
		}
		public CatalyticActivity min(CatalyticActivity r) { // units maintained
			if (r.lessThan(this)) return new CatalyticActivity(r.getX(),r.getU(),r.getUnits()); 
			return new CatalyticActivity(this.getX(),this.getU(),this.getUnits());
		}
		public CatalyticActivity max(CatalyticActivity r) { // unit maintained
			//if (r>this) r; else this;
			if (r.gt(this)) return new CatalyticActivity(r.getX(),r.getU(),r.getUnits());
			return new CatalyticActivity(this.getX(),this.getU(),this.getUnits());
		}

		/***
		 * working with constants (note that add and minus do not work here
		 */

		public CatalyticActivity mult(double r) {  
			return new CatalyticActivity(this.value.mult(new UReal(r)),this.getUnits());
		}
		
		public CatalyticActivity divideBy(double r) {  
			return new CatalyticActivity(this.value.divideBy(new UReal(r)),this.getUnits());
		}

		/******
		 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
		 */
		
	 	public int hashcode(){ //required for equals()
			return Math.round((float)value.getX());
		}

	 	public CatalyticActivity clone() {
			return new CatalyticActivity(this.getUReal(),this.getUnits());
		}



	
}
