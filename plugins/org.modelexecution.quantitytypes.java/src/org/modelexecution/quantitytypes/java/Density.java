package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Density extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-3.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Density(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Density");
this.unit = new Unit (q.unit);
}
public Density () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Density");
this.unit = new Unit (unit);
}
public Density(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Density");
this.unit = new Unit (unit);
}
public Density(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Density");
this.unit = new Unit (unit);
}
public Density(String x) { //creates a Density from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density(String x, String u) { //creates a Density from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerCubicMeter);
}
public Density(String x, String u, Unit unit) { //creates a Density from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Density");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Density add(Density r) {  //only works if compatible units && operand has no offset
return new Density(super.add(r));
}
public Density minus(Density r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Density(super.minus(r));
}
public MassPerUnitArea mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitArea(super.mult(r));
}
public EnergyDensity mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public AmountOfSubstancePerUnitVolume mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.mult(r));
}
public MassPerUnitLength mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public EnergyDensity mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ElectricChargeVolumeDensity mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.mult(r));
}
public DynamicViscosity mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public EnergyDensity mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public VolumetricHeatCapacity mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public DynamicViscosity mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public Mass mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public MassPerUnitTime mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public UReal divideBy(Density r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Density abs() { //units are maintained
return new Density(super.abs());
}
public Density neg() { //units are maintained
return new Density(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Density r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Density r) {
return !(this.equals(r));
}
public Density floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Density(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Density round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Density(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Density min(Density r) { // units maintained
if (r.lt(this)) return new Density(r.getX(),r.getU(),r.getUnits());
return new Density(this.getX(),this.getU(),this.getUnits());
}
public Density max(Density r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Density(r.getX(),r.getU(),r.getUnits());
return new Density(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Density mult(double r) {
return new Density(this.value.mult(new UReal(r)),this.getUnits());
}
public Density divideBy(double r) {
return new Density(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Density mult(UReal r) {
return new Density(this.value.mult(r),this.getUnits());
}
public Density divideBy(UReal r) {
return new Density(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Density clone() {
return new Density(this.getUReal(),this.getUnits());
}
}
