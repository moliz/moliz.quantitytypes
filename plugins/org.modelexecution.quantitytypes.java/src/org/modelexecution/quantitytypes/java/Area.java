package org.modelexecution.quantitytypes.java;

//READY
  
public class Area extends Quantity {

	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    public Area(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (q.unit);
    }
    /**
     * Constructors 
     */
    public Area () {
        value = new UReal();
        unit = new Unit(DerivedUnits.SquareMeter);
    }

    public Area(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.SquareMeter);
    }

    public Area(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (unit);
    }

	public Area(double x){ //"promotes" a real x 
		value = new UReal(x,0.0);
        unit = new Unit(DerivedUnits.SquareMeter);
	}
  
    public Area (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeter);
   }
    
    public Area(double x, Unit unit){ //we only allow Area Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (unit);
   }

    public Area(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (unit);
    }

    public Area(String x) { //creates an Area from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.SquareMeter);
   }
    
    public Area(String x, String u) { //creates an Area from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.SquareMeter);
   }
   
    public Area(String x, String u, Unit unit) { //creates an Area from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (unit);
   }

	
	/*********
     * 
     * Specific Type Operations
     */

	public Area add(Area r) {  //only works if compatible units && operand has no offset
		
		return new Area(super.add(r));
	}
	
	public Area minus(Area r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new Area(super.minus(r));
	}

	public Volume mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Volume(super.mult(r));
	}

	public AngularMass mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularMass(super.mult(r));
	}
	
	public AreaAngle mult(SolidAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AreaAngle(super.mult(r));
	}
	
	public AreaTemperature mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AreaTemperature(super.mult(r));
	}
	
	public AngularMomentum mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AngularMomentum(super.mult(r));
	}

	public EnergyAndWork mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new EnergyAndWork(super.mult(r));
	}
	
	public MagneticDipoleMoment mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new MagneticDipoleMoment(super.mult(r));
	}
	
	public MagneticFlux mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new MagneticFlux(super.mult(r));
	}
	
	public Power mult(PowerPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Power(super.mult(r));
	}
	 
	public PowerPerAngle mult(PowerPerAreaAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new PowerPerAngle(super.mult(r));
	}
	 
	public Volume mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Volume(super.mult(r));
	}
	
	
	public AreaThermalExpansion divideBy(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AreaThermalExpansion(super.divideBy(r));
	}

	public KinematicViscosity divideBy(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new KinematicViscosity(super.divideBy(r));
	}

	public AbsorbedDose divideBy(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDose(super.divideBy(r));
	}
	
	public Length divideBy(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new Length(super.divideBy(r));
	}
	
	
	/** OTHER OPERATIONS
	 * 
	 */
	
	public Area abs() { //units are maintained
		return new Area(super.abs());
	}
	
	public Area neg() { //units are maintained
		return new Area(super.neg());
	}

	public Length sqrt() { 
		return new Length(super.sqrt());
	}

    // power(s) and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(Area r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Area r) {  
		return !(super.equals(r));
	}
	
	public Area floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new Area(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public Area round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new Area(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public Area min(Area r) { // units maintained
		if (r.lessThan(this)) return new Area(r.getX(),r.getU(),r.getUnits()); 
		return new Area(this.getX(),this.getU(),this.getUnits());
	}
	public Area max(Area r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new Area(r.getX(),r.getU(),r.getUnits());
		return new Area(this.getX(),this.getU(),this.getUnits());
	}

	/***
	 * working with constants (note that add and minus will only work if "this" is unit-less
	 */

	public Area mult(double r) {  
		return new Area(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public Area divideBy(double r) {  
		return new Area(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	/******
	 * Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	 */
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public Area clone() {
		return new Area(this.getUReal(),this.getUnits());
	}

}
