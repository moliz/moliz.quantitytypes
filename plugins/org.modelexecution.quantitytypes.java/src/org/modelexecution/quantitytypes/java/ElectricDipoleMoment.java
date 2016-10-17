package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricDipoleMoment extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=1.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ElectricDipoleMoment(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricDipoleMoment");
this.unit = new Unit (q.unit);
}
public ElectricDipoleMoment () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricDipoleMoment");
this.unit = new Unit (unit);
}
public ElectricDipoleMoment(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricDipoleMoment");
this.unit = new Unit (unit);
}
public ElectricDipoleMoment(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricDipoleMoment");
this.unit = new Unit (unit);
}
public ElectricDipoleMoment(String x) { //creates a ElectricDipoleMoment from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment(String x, String u) { //creates a ElectricDipoleMoment from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombMeter);
}
public ElectricDipoleMoment(String x, String u, Unit unit) { //creates a ElectricDipoleMoment from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricDipoleMoment");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricDipoleMoment add(ElectricDipoleMoment r) {  //only works if compatible units && operand has no offset
return new ElectricDipoleMoment(super.add(r));
}
public ElectricDipoleMoment minus(ElectricDipoleMoment r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricDipoleMoment(super.minus(r));
}
public EnergyAndWork mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyAndWork mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public MagneticDipoleMoment mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public LinearMomentum mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public ElectricCharge divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public Length divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Area divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Volume divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public LengthMass divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public Exposure divideBy(LengthMass r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricFluxDensity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public UReal divideBy(ElectricDipoleMoment r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricDipoleMoment abs() { //units are maintained
return new ElectricDipoleMoment(super.abs());
}
public ElectricDipoleMoment neg() { //units are maintained
return new ElectricDipoleMoment(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricDipoleMoment r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricDipoleMoment r) {
return !(this.equals(r));
}
public ElectricDipoleMoment floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricDipoleMoment(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricDipoleMoment round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricDipoleMoment(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricDipoleMoment min(ElectricDipoleMoment r) { // units maintained
if (r.lessThan(this)) return new ElectricDipoleMoment(r.getX(),r.getU(),r.getUnits());
return new ElectricDipoleMoment(this.getX(),this.getU(),this.getUnits());
}
public ElectricDipoleMoment max(ElectricDipoleMoment r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricDipoleMoment(r.getX(),r.getU(),r.getUnits());
return new ElectricDipoleMoment(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricDipoleMoment mult(double r) {
return new ElectricDipoleMoment(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricDipoleMoment divideBy(double r) {
return new ElectricDipoleMoment(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricDipoleMoment mult(UReal r) {
return new ElectricDipoleMoment(this.value.mult(r),this.getUnits());
}
public ElectricDipoleMoment divideBy(UReal r) {
return new ElectricDipoleMoment(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricDipoleMoment clone() {
return new ElectricDipoleMoment(this.getUReal(),this.getUnits());
}
}
