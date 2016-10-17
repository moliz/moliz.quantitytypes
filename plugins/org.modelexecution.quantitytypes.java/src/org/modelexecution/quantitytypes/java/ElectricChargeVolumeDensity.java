package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricChargeVolumeDensity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-3.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=1.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ElectricChargeVolumeDensity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeVolumeDensity");
this.unit = new Unit (q.unit);
}
public ElectricChargeVolumeDensity () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeVolumeDensity");
this.unit = new Unit (unit);
}
public ElectricChargeVolumeDensity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeVolumeDensity");
this.unit = new Unit (unit);
}
public ElectricChargeVolumeDensity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeVolumeDensity");
this.unit = new Unit (unit);
}
public ElectricChargeVolumeDensity(String x) { //creates a ElectricChargeVolumeDensity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity(String x, String u) { //creates a ElectricChargeVolumeDensity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerCubicMeter);
}
public ElectricChargeVolumeDensity(String x, String u, Unit unit) { //creates a ElectricChargeVolumeDensity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeVolumeDensity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricChargeVolumeDensity add(ElectricChargeVolumeDensity r) {  //only works if compatible units && operand has no offset
return new ElectricChargeVolumeDensity(super.add(r));
}
public ElectricChargeVolumeDensity minus(ElectricChargeVolumeDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricChargeVolumeDensity(super.minus(r));
}
public ElectricFluxDensity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public ElectricChargeLineDensity mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public EnergyDensity mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public MagneticFieldStrength mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricCurrentDensity mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.mult(r));
}
public DynamicViscosity mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public MagneticFieldStrength mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricCharge mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricCurrent mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricChargePerAmountOfSubstance divideBy(AmountOfSubstancePerUnitVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.divideBy(r));
}
public Exposure divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public AmountOfSubstancePerUnitVolume divideBy(ElectricChargePerAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.divideBy(r));
}
public Density divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public UReal divideBy(ElectricChargeVolumeDensity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricChargeVolumeDensity abs() { //units are maintained
return new ElectricChargeVolumeDensity(super.abs());
}
public ElectricChargeVolumeDensity neg() { //units are maintained
return new ElectricChargeVolumeDensity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricChargeVolumeDensity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricChargeVolumeDensity r) {
return !(this.equals(r));
}
public ElectricChargeVolumeDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricChargeVolumeDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargeVolumeDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricChargeVolumeDensity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargeVolumeDensity min(ElectricChargeVolumeDensity r) { // units maintained
if (r.lessThan(this)) return new ElectricChargeVolumeDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricChargeVolumeDensity(this.getX(),this.getU(),this.getUnits());
}
public ElectricChargeVolumeDensity max(ElectricChargeVolumeDensity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricChargeVolumeDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricChargeVolumeDensity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricChargeVolumeDensity mult(double r) {
return new ElectricChargeVolumeDensity(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricChargeVolumeDensity divideBy(double r) {
return new ElectricChargeVolumeDensity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricChargeVolumeDensity mult(UReal r) {
return new ElectricChargeVolumeDensity(this.value.mult(r),this.getUnits());
}
public ElectricChargeVolumeDensity divideBy(UReal r) {
return new ElectricChargeVolumeDensity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricChargeVolumeDensity clone() {
return new ElectricChargeVolumeDensity(this.getUReal(),this.getUnits());
}
}
