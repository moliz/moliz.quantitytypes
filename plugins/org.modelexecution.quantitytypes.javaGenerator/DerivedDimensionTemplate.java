package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

// Esta plantilla es solo para DerivedUnits.
//
//   Parameters: %%Dimension%% -- nombre de la dimension, y por tanto de la clase Java. Corresponde a una de los literales definidos en DerivedDimensions.java
//               %%Unit%% -- nombre de la unidad (En DerivedUnits.java)
//               %%Product%% -- parametro de la operacion mult()
//               %%MultResult%% -- resultado de la operacion mult()
//               %%Dividend%% -- parametro de la operacion divideBy()
//               %%DivResult%% -- resultado de la operacion divideBy()
//               %%SQRTDimension%% -- resultado de la operacion sqrt() [si tiene sentido]
//               %%INVDimension%% -- resultado de la operacion inverse() [si tiene sentido]
//
//En la operacion checkUnit() tambien hay parametros como %%BaseUnit1%%, %%BaseUnit2%%, ... y %%Base1Exponent%%, %%Base2Exponent%%,... 


public class %%Dimension%% extends Quantity {

	static protected boolean checkUnit(Unit u) {
		double [] x = new double [BaseUnits.values().length];
		Arrays.fill(x, 0.0);
		x[BaseUnits.%%BaseUnit1%%.ordinal()]=%%Base1Exponent%%;
		x[BaseUnits.%%BaseUnit2%%.ordinal()]=%%Base2Exponent%%;
		x[BaseUnits.%%BaseUnit3%%.ordinal()]=%%Base3Exponent%%;
		return Arrays.equals(x,u.dimensions);
	}

	public %%Dimension%%(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (q.unit);
    }
    public %%Dimension%% () {
        value = new UReal();
        unit = new Unit(DerivedUnits.%%Unit%%);
    }

    public %%Dimension%%(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.%%Unit%%);
    }

    public %%Dimension%%(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an %%Dimension%%");
    	this.unit = new Unit (unit);
    }

	public %%Dimension%%(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.%%Unit%%);
	}
  
    public %%Dimension%% (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
    
    public %%Dimension%%(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
   }

    public %%Dimension%%(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
    }

    public %%Dimension%%(String x) { //creates a %%Dimension%% from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
    
    public %%Dimension%%(String x, String u) { //creates a %%Dimension%% from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
   
    public %%Dimension%%(String x, String u, Unit unit) { //creates a %%Dimension%% from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
   }

	
//	  Specific Type Operations
     
	public %%Dimension%% add(%%Dimension%% r) {  //only works if compatible units && operand has no offset
		
		return new %%Dimension%%(super.add(r));
	}
	
	public %%Dimension%% minus(%%Dimension%% r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new %%Dimension%%(super.minus(r));
	}

	// One per valid mult operand 

    public %%MultResult%% mult(%%Product%% r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDoseRate(super.mult(r));
	}
	
    // One per valid div operand 
	public %%DivResult%% divideBy(%%Dividend%% r) { //both values and units are divided. No offsets allowed in any of the units
		return new TimeSquared(super.divideBy(r));
	}

// in case inverse() returns a valid dimension -- otherwise just leave it commented.

   public %%INVDimension%% inverse() {
       return new  %%INVDimension%%(super.inverse());
   }

//in case sqrt() returns a valid dimension -- otherwise just leave it commented.

   public %%SQRTDimension%% sqrt() {
       return new  %%SQRTDimension%%(super.sqrt());
   }

	
	// OTHER OPERATIONS
	
	
	public %%Dimension%% abs() { //units are maintained
		return new %%Dimension%%(super.abs());
	}
	
	public %%Dimension%% neg() { //units are maintained
		return new %%Dimension%%(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(%%Dimension%% r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(%%Dimension%% r) {  
		return !(this.equals(r));
	}
	
	public %%Dimension%% floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new %%Dimension%%(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public %%Dimension%% round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new %%Dimension%%(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public %%Dimension%% min(%%Dimension%% r) { // units maintained
		if (r.lessThan(this)) return new %%Dimension%%(r.getX(),r.getU(),r.getUnits()); 
		return new %%Dimension%%(this.getX(),this.getU(),this.getUnits());
	}
	public %%Dimension%% max(%%Dimension%% r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new %%Dimension%%(r.getX(),r.getU(),r.getUnits());
		return new %%Dimension%%(this.getX(),this.getU(),this.getUnits());
	}

	
	//  working with constants (note that add and minus do not work here
	

	public %%Dimension%% mult(double r) {  
		return new %%Dimension%%(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public %%Dimension%% divideBy(double r) {  
		return new %%Dimension%%(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	public %%Dimension%% mult(UReal r) {  
		return new %%Dimension%%(this.value.mult(r),this.getUnits());
	}
	
	public %%Dimension%% divideBy(UReal r) {  
		return new %%Dimension%%(this.value.divideBy(r),this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public %%Dimension%% clone() {
		return new %%Dimension%%(this.getUReal(),this.getUnits());
	}


}
