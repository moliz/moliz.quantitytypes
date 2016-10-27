package org.modelexecution.quantitytypes.java;


/**
 * @author av
 *
 */
public class Quantity implements Comparable<Quantity> {
	
	protected UReal value;
	protected Unit unit;
	
    /**
     * Constructors 
     */
    public Quantity () {
        value = new UReal();
        unit = new Unit(); //unit-less 
    }

    public Quantity(UReal u){
    	this.value = u.clone();
    	this.unit = new Unit ();//unit-less
    }

    public Quantity(UReal u, Unit unit){
    	value = u.clone();
    	this.unit = new Unit (unit);
    }

	public Quantity(double x){ //"promotes" a real x to a unit-less (x,0) 
		value = new UReal(x,0.0);
        unit = new Unit(); //unit-less 
	}
  
    public Quantity (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(); //Unitless 
    }
    
    public Quantity(double x, Unit unit){
    	value = new UReal(x);
    	this.unit = new Unit (unit);
    }

    public Quantity(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	this.unit = new Unit (unit);
    }

    public Quantity(String x) { //creates an Quantity from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(); //unit-less 
   }
    
    public Quantity(String x, String u) { //creates an Quantity from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(); //unit-less 
   }
   
    public Quantity(String x, String u, Unit unit) { //creates an Quantity from two strings representing (x,u).
    	value = new UReal(x,u);
    	this.unit = new Unit (unit);
   }

    /**
     * Setters and getters 
     */
    public UReal getUReal() {
 		return value; 
 	}
    public void setUReal(UReal x) {
    	 value = new UReal(x.getX(),x.getU()); 
 	}
   public double getX() {
		return value.getX(); 
	}
    public void setX(double x) {
    	value.setX(x); 
	}
    public double getU() {
		return value.getU();
	}
	public void setU(double u) {
		value.setU(u);;
	}
    public Unit getUnits() {
		return unit;
	}
	public void setUnits(Unit unit) {
        this.unit = new Unit(unit); 
	}
	
	/******
	 * Auxiliary operations. They are made publicly available to help 
	 */
	
	public boolean compatibleUnits(Quantity x) {
		return this.unit.isCompatibleWith(x.unit);
	}

	public boolean compatibleUnits(Unit u) {
		return this.unit.isCompatibleWith(u);
	}
	

	/*********
     * 
     * Unit Conversion Operations
     */

	
	public Quantity convertTo(Unit u) { //Have to have compatible units

		//assert this.compatibleUnits(u);
		if (!this.compatibleUnits(u)) throw new RuntimeException("convertTo: Incompatible Units: "+this.unit+" and "+u);

/***
 * 		System.out.println("CONVERTTO");
 
		System.out.println("this: "+this);
		System.out.println("this.value: "+this.value);
		System.out.println("unit: "+u);
		System.out.println("this.unit.factor: "+this.unit.factor());
		System.out.println("u.factor: "+u.factor());
*/		
		UReal value = this.value.mult(new UReal(this.unit.factor()/u.factor(),0.0));

//		System.out.println("new value: "+value);

		// Now we add the offset, only if there is one offset in the array. Otherwise we raise an exception
		for (int i = 0; i<BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i]>=0.0) && ((this.unit.offset[i])!=0.0||(u.offset[i]!=0.0))) {
				value = value.add(new UReal((this.unit.offset[i]-u.offset[i])/u.factor()));
			}
		}
		if (!this.compatibleUnits(u)) throw new RuntimeException("convertTo: Incompatible Units: "+this.unit+" and "+u);

//		assert u.checkOffset() : u.offset;
		if (!u.checkOffset()) throw new RuntimeException("Invalid Offset in unit: "+u.offset);

		return new Quantity(value,u);
	}
	
	public Quantity convertToSIUnits(){

/** OLD VERSION, ACCUMMULATES UNCERTAINTY */
  		UReal value = this.value.mult(new UReal(this.unit.factor(),0.0));
 		// Now we add the offset, only if there is one offset in the array. Otherwise we raise an exception
		for (int i = 0; i<BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i]>=0.0) && (this.unit.offset[i]!=0.0)) {
				value = value.add(new UReal(this.unit.offset[i]));
			}
		}
//		assert this.unit.checkOffset() : this.unit.offset;
		if (!this.unit.checkOffset()) throw new RuntimeException("Invalid Offset in unit: "+this.unit.symbol);

		return new Quantity(value,new Unit(unit.dimensions));

/* NEW VERSION
  		double x = this.value.x*this.unit.factor();
 		// Now we add the offset, only if there is one offset in the array. Otherwise we raise an exception
		for (int i = 0; i<BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i]>=0.0) && (this.unit.offset[i]!=0.0)) {
				x+=this.unit.offset[i];
			}
		}
//		assert this.unit.checkOffset() : this.unit.offset;
		if (!this.unit.checkOffset()) throw new RuntimeException("Invalid Offset in unit: "+this.unit.symbol);

		return new Quantity(new UReal(x,this.value.u*this.unit.factor()),unit);		
		*/
	}
	
	public Quantity convertFromSIUnits(UReal v){// v is the value of the quantity expressed in SIUnits

		UReal value = v.mult(new UReal(1.0/this.unit.factor(),0.0));
		// Now we substract the offset, only if there is one offset in the array. Otherwise we raise an exception
		for (int i = 0; i<BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i]>=0.0) && (this.unit.offset[i]!=0.0)) {
				value = value.minus(new UReal(this.unit.offset[i]/this.unit.conversionFactor[i]));
			}
		}
		// assert this.unit.checkOffset() : this.unit.offset;
		if (!this.unit.checkOffset()) throw new RuntimeException("Invalid Offset in unit: "+this.unit.symbol);
		return new Quantity(value,unit);

		/*** OLD VERSION, ACCUMMULATES UNCERTAINTY
		double x = v.x/this.unit.factor();
		for (int i = 0; i<BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i]>=0.0) && (this.unit.offset[i]!=0.0)) {
				x-=this.unit.offset[i]/this.unit.conversionFactor[i];
			}
		}

		//	assert this.unit.checkOffset() : this.unit.offset;
		if (!this.unit.checkOffset()) throw new RuntimeException("Invalid Offset in unit: "+this.unit.symbol);
		return new Quantity(new UReal(x,v.u/this.unit.factor()),unit);
	 * 	
	 */
	}
	
	/*********
     * 
     * Type Operations
     */

	public Quantity add(Quantity r) {  //only works if compatible units && operand has no offset
		
		Quantity result = null;
//		assert this.compatibleUnits(r.unit);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("add: Incompatible Units: "+this.unit+" and "+r.unit);

//		assert r.unit.noOffset(): r.unit.symbol;
		if (!r.unit.noOffset()) throw new RuntimeException("Add: Invalid Offset in operand unit: "+r.unit.symbol);
		if (this.unit.noOffset()) { //both this and r are not delta
			Quantity other = r.convertTo(this.getUnits());
			result = new Quantity(this.getUReal().add(other.getUReal()),this.getUnits());
		} else { //r is delta, this is not
			Quantity one = this.convertToSIUnits();
			Quantity other = r.convertToSIUnits();
			return this.convertFromSIUnits(one.getUReal().add(other.getUReal()));
//			Quantity other = r.convertTo(this.getUnits());
//			result = new Quantity(this.getUReal().add(other.getUReal().add(new UReal(this.unit.sumOffset(),0.0))),this.getUnits());
		}
		return result;
	}
	
	public Quantity minus(Quantity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
//		assert this.compatibleUnits(r.unit);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("minus: Incompatible Units: "+this.unit+" and "+r.unit);

//		assert r.unit.noOffset(): r.unit.symbol;

		if (!r.unit.noOffset() && this.unit.noOffset()) throw new RuntimeException("Minus: Invalid Offset in operand unit: "+r.unit.symbol);
		if (r.unit.noOffset() && this.unit.noOffset()) {
			Quantity other = r.convertTo(this.getUnits());
			return new Quantity(this.getUReal().minus(other.getUReal()),this.getUnits());
		}
		if (r.unit.noOffset()) { // r is a Delta Unit, but "this" is not
			Quantity one = this.convertToSIUnits();
			Quantity other = r.convertToSIUnits();
			return this.convertFromSIUnits(one.getUReal().minus(other.getUReal()));
//			Quantity other = r.convertTo(this.getUnits());
//			return new Quantity(this.getUReal().minus(other.getUReal().add(new UReal(this.unit.sumOffset(),0.0))),this.getUnits());
		} 
		// else neither r nor this are Delta Units, but the result should be a Delta Unit...
		// and then we convert to the  Delta"This" unit, with no offset
		Quantity other = r.convertTo(this.getUnits());
		return new Quantity(this.getUReal().minus(other.getUReal()),
		  	                new Unit("Delta"+this.unit.name,
					           		 "Delta"+this.unit.symbol,
					            	 this.unit.dimensions(),
					            	 this.unit.conversionFactor));		
	}

	public Quantity mult(Quantity r) { //both values and units are multiplied. No offsets allowed in any of the units

//		assert this.unit.noOffset(): this.unit.symbol;
//		assert r.unit.noOffset(): r.unit.symbol;
		if (!this.unit.noOffset()) throw new RuntimeException("mult: Invalid Offset in this unit: "+this.unit.symbol);
		if (!r.unit.noOffset()) throw new RuntimeException("mult: Invalid Offset in operand unit: "+r.unit.symbol);
		
//		if (r.unit.isDimensionless()) return new Quantity(this.value.mult(r.value),this.unit);
		Quantity result = new Quantity();
		Quantity one = this.convertToSIUnits();
		Quantity other = r.convertToSIUnits();
		result.setUReal(one.getUReal().mult(other.getUReal()));
		result.setUnits(one.getUnits().multiplyUnits(other.getUnits()));
		return result;
	}
	
	public Quantity divideBy(Quantity r) { //both values and units are divided. No offsets allowed in any of the units

//		assert this.unit.noOffset(): this.unit.symbol;
//		assert r.unit.noOffset(): r.unit.symbol;
		if (!this.unit.noOffset()) throw new RuntimeException("divideBy: Invalid Offset in this unit: "+this.unit.symbol);
		if (!r.unit.noOffset()) throw new RuntimeException("divideBy: Invalid Offset in operand unit: "+r.unit.symbol);
	
		Quantity result = new Quantity();
		Quantity one = this.convertToSIUnits();
		Quantity other = r.convertToSIUnits();
		result.setUReal(one.getUReal().divideBy(other.getUReal()));
    	result.setUnits(one.getUnits().divideUnits(other.getUnits()));
		return result;
	}
	
	public Quantity abs() { //units are maintained
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().abs());
		result.setUnits(this.getUnits());
		return result;
	}
	
	public Quantity neg() { //units are maintained
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().neg());
		result.setUnits(this.getUnits());
		return result;
	}

	public Quantity power(float s) { //unit are also powered. No offsets allowed

//		assert this.unit.noOffset(): this.unit.symbol;
		if ((s!=0.0) && (!this.unit.noOffset())) throw new RuntimeException("power: Invalid Offset in this unit: "+this.unit.symbol);

		Quantity result = new Quantity();
		result.setUReal(this.getUReal().power(s));
		result.setUnits(this.getUnits().powerUnits(s));
		return result;
	}

	public Quantity sqrt() {  //unit are also squared. No offsets allowed

//		assert this.unit.noOffset(): this.unit.symbol;
		if (!this.unit.noOffset()) throw new RuntimeException("sqrt: Invalid Offset in this unit: "+this.unit.symbol);

		Quantity result = new Quantity();
		result.setUReal(this.getUReal().sqrt());
		result.setUnits(this.getUnits().powerUnits(0.5f));
		return result;
	}

	public boolean lessThan(Quantity r) {  //only if same unit

//		assert this.compatibleUnits(r.unit);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("lessThan: Incompatible Units: "+this.unit+" and "+r.unit);

		return this.getUReal().lessThan(r.convertTo(this.getUnits()).getUReal());
	}
	
	public boolean lessEq(Quantity r) {  //only if same unit

//		assert this.compatibleUnits(r.unit);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("lessEq: Incompatible Units: "+this.unit+" and "+r.unit);

		Quantity other = r.convertTo(this.getUnits());
		return (this.lessThan(other) || this.equals(other));
	}

	public boolean gt(Quantity r) {  //only if same unit

//		assert this.compatibleUnits(r.unit);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("gt: Incompatible Units: "+this.unit+" and "+r.unit);

		return r.convertTo(this.getUnits()).lessThan(this);		
	}
	
	public boolean ge(Quantity r) {  //only if same unit

//		assert this.compatibleUnits(r);
		if (!this.compatibleUnits(r.unit)) throw new RuntimeException("ge: Incompatible Units: "+this.unit+" and "+r.unit);
		
		Quantity other = r.convertTo(this.getUnits());
		return (this.gt(other) || this.equals(other));		
		
	}
	
	public boolean equals(Quantity r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Quantity r) {  
		return !(this.equals(r));
	}
	
	public Quantity inverse() { //inverse (reciprocal)
		return new Quantity(1.0).divideBy(this);
	}
	
	public Quantity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Quantity(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Quantity round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Quantity(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Quantity min(Quantity r) { // units maintained
		if (r.lessThan(this)) return new Quantity(r.getX(),r.getU(),r.getUnits()); 
		return new Quantity(this.getX(),this.getU(),this.getUnits());
	}
	public Quantity max(Quantity r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Quantity(r.getX(),r.getU(),r.getUnits());
		return new Quantity(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus will only work if "this" is unit-less
	 */

	public Quantity mult(double r) {  
		return new Quantity(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Quantity divideBy(double r) {  
		return new Quantity(this.value.divideBy(new UReal(r)),this.getUnits());
	}
	
	public Quantity mult(UReal r) {  
		return new Quantity(this.value.mult(r),this.getUnits());
	}
	
	public Quantity divideBy(UReal r) {  
		return new Quantity(this.value.divideBy(r),this.getUnits());
	}

	/******
	 * Conversions to basic types
	 */
	
	public String toString() {
		return value.toString() + unit.toString();
	}
	
	
	public int toInteger(){ //
		return (int)Math.floor(this.getX());
	}
	
	public double toReal()  { 
		return this.getX();
	}
	
	/**
	 * Other Methods 
	 */

 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Quantity clone() {
		return new Quantity(this.getUReal(),this.getUnits());
	}

	@Override
	public int compareTo(Quantity other) {
		if (this.equals(other)) return 0;
		if (this.lessThan(other)) return -1;
		return 1;
	}

}
