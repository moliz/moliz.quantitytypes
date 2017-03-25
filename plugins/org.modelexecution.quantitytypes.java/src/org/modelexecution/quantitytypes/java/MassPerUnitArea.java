package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MassPerUnitArea extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MassPerUnitArea(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitArea");
this.unit = new Unit (q.unit);
}
public MassPerUnitArea () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitArea");
this.unit = new Unit (unit);
}
public MassPerUnitArea(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitArea");
this.unit = new Unit (unit);
}
public MassPerUnitArea(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitArea");
this.unit = new Unit (unit);
}
public MassPerUnitArea(String x) { //creates a MassPerUnitArea from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea(String x, String u) { //creates a MassPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerSquareMeter);
}
public MassPerUnitArea(String x, String u, Unit unit) { //creates a MassPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitArea");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MassPerUnitArea add(MassPerUnitArea r) {  //only works if compatible units && operand has no offset
return new MassPerUnitArea(super.add(r));
}
public MassPerUnitArea minus(MassPerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MassPerUnitArea(super.minus(r));
}
public MassPerUnitLength mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public EnergyPerUnitArea mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(AbsorbedDoseRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public Mass mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public MassTemperature mult(AreaTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public EnergyPerUnitArea mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ElectricFluxDensity mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public LinearAcceleration mult(GravitationalAttraction r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public MassPerUnitTime mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public EnergyDensity mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public DynamicViscosity mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public EnergyPerUnitArea mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public LinearThermalExpansion mult(SpecificHeatPressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearThermalExpansion(super.mult(r));
}
public MassPerUnitTime mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public EnergyDensity mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public LengthMass mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public LinearMomentum mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public Density divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public Length divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public UReal divideBy(MassPerUnitArea r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MassPerUnitArea abs() { //units are maintained
return new MassPerUnitArea(super.abs());
}
public MassPerUnitArea neg() { //units are maintained
return new MassPerUnitArea(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MassPerUnitArea r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MassPerUnitArea r) {
return !(this.equals(r));
}
public MassPerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MassPerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MassPerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitArea min(MassPerUnitArea r) { // units maintained
if (r.lessThan(this)) return new MassPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
public MassPerUnitArea max(MassPerUnitArea r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MassPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MassPerUnitArea mult(double r) {
return new MassPerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
}
public MassPerUnitArea divideBy(double r) {
return new MassPerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MassPerUnitArea mult(UReal r) {
return new MassPerUnitArea(this.value.mult(r),this.getUnits());
}
public MassPerUnitArea divideBy(UReal r) {
return new MassPerUnitArea(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MassPerUnitArea clone() {
return new MassPerUnitArea(this.getUReal(),this.getUnits());
}
}
