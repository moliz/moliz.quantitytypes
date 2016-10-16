package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MassPerUnitLength extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MassPerUnitLength(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitLength");
this.unit = new Unit (q.unit);
}
public MassPerUnitLength () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitLength");
this.unit = new Unit (unit);
}
public MassPerUnitLength(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitLength");
this.unit = new Unit (unit);
}
public MassPerUnitLength(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitLength");
this.unit = new Unit (unit);
}
public MassPerUnitLength(String x) { //creates a MassPerUnitLength from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength(String x, String u) { //creates a MassPerUnitLength from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerMeter);
}
public MassPerUnitLength(String x, String u, Unit unit) { //creates a MassPerUnitLength from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitLength");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MassPerUnitLength add(MassPerUnitLength r) {  //only works if compatible units && operand has no offset
return new MassPerUnitLength(super.add(r));
}
public MassPerUnitLength minus(MassPerUnitLength r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MassPerUnitLength(super.minus(r));
}
public Mass mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public Force mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public DynamicViscosity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public LengthMass mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public Force mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public ElectricChargeLineDensity mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public DynamicViscosity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public AbsorbedDose mult(GravitationalAttraction r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public LinearMomentum mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public MassTemperature mult(LengthTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public EnergyPerUnitArea mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public MassPerUnitTime mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public Force mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public AreaThermalExpansion mult(SpecificHeatPressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaThermalExpansion(super.mult(r));
}
public LinearMomentum mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public EnergyPerUnitArea mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public AngularMass mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public AngularMomentum mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public MassPerUnitArea divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public DynamicViscosity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public Density divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public Area divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Time divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public TimeSquared divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Length divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public TimeSquared divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public EnergyDensity divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public MassPerUnitLength abs() { //units are maintained
return new MassPerUnitLength(super.abs());
}
public MassPerUnitLength neg() { //units are maintained
return new MassPerUnitLength(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MassPerUnitLength r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MassPerUnitLength r) {
return !(this.equals(r));
}
public MassPerUnitLength floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MassPerUnitLength(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitLength round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MassPerUnitLength(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitLength min(MassPerUnitLength r) { // units maintained
if (r.lessThan(this)) return new MassPerUnitLength(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitLength(this.getX(),this.getU(),this.getUnits());
}
public MassPerUnitLength max(MassPerUnitLength r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MassPerUnitLength(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitLength(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MassPerUnitLength mult(double r) {
return new MassPerUnitLength(this.value.mult(new UReal(r)),this.getUnits());
}
public MassPerUnitLength divideBy(double r) {
return new MassPerUnitLength(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MassPerUnitLength mult(UReal r) {
return new MassPerUnitLength(this.value.mult(r),this.getUnits());
}
public MassPerUnitLength divideBy(UReal r) {
return new MassPerUnitLength(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MassPerUnitLength clone() {
return new MassPerUnitLength(this.getUReal(),this.getUnits());
}
}
