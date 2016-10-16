package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Exposure extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=1.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Exposure(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Exposure");
this.unit = new Unit (q.unit);
}
public Exposure () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Exposure");
this.unit = new Unit (unit);
}
public Exposure(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Exposure");
this.unit = new Unit (unit);
}
public Exposure(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Exposure");
this.unit = new Unit (unit);
}
public Exposure(String x) { //creates a Exposure from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure(String x, String u) { //creates a Exposure from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerKilogram);
}
public Exposure(String x, String u, Unit unit) { //creates a Exposure from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Exposure");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Exposure add(Exposure r) {  //only works if compatible units && operand has no offset
return new Exposure(super.add(r));
}
public Exposure minus(Exposure r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Exposure(super.minus(r));
}
public ElectricCharge mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public MagneticDipoleMoment mult(AngularMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public ElectricChargeVolumeDensity mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.mult(r));
}
public MagneticFieldStrength mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public LinearAcceleration mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public AbsorbedDose mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public LinearAcceleration mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public ElectricDipoleMoment mult(LengthMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public KinematicViscosity mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public Activity mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Activity(super.mult(r));
}
public ElectricCurrent mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricFluxDensity mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public ElectricChargeLineDensity mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricChargePerAmountOfSubstance divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(ElectricChargePerAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public Exposure abs() { //units are maintained
return new Exposure(super.abs());
}
public Exposure neg() { //units are maintained
return new Exposure(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Exposure r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Exposure r) {
return !(this.equals(r));
}
public Exposure floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Exposure(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Exposure round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Exposure(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Exposure min(Exposure r) { // units maintained
if (r.lessThan(this)) return new Exposure(r.getX(),r.getU(),r.getUnits());
return new Exposure(this.getX(),this.getU(),this.getUnits());
}
public Exposure max(Exposure r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Exposure(r.getX(),r.getU(),r.getUnits());
return new Exposure(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Exposure mult(double r) {
return new Exposure(this.value.mult(new UReal(r)),this.getUnits());
}
public Exposure divideBy(double r) {
return new Exposure(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Exposure mult(UReal r) {
return new Exposure(this.value.mult(r),this.getUnits());
}
public Exposure divideBy(UReal r) {
return new Exposure(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Exposure clone() {
return new Exposure(this.getUReal(),this.getUnits());
}
}
