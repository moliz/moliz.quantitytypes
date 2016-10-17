package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MagnetomotiveForce extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=1.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MagnetomotiveForce(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
this.unit = new Unit (q.unit);
}
public MagnetomotiveForce () {
value = new UReal();
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagnetomotiveForce");
this.unit = new Unit (unit);
}
public MagnetomotiveForce(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
this.unit = new Unit (unit);
}
public MagnetomotiveForce(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
this.unit = new Unit (unit);
}
public MagnetomotiveForce(String x) { //creates a MagnetomotiveForce from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce(String x, String u) { //creates a MagnetomotiveForce from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmpereTurn);
}
public MagnetomotiveForce(String x, String u, Unit unit) { //creates a MagnetomotiveForce from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagnetomotiveForce");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MagnetomotiveForce add(MagnetomotiveForce r) {  //only works if compatible units && operand has no offset
return new MagnetomotiveForce(super.add(r));
}
public MagnetomotiveForce minus(MagnetomotiveForce r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MagnetomotiveForce(super.minus(r));
}
public Angle divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public ElectricCurrent divideBy(Angle r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public ElectricCharge divideBy(AngularVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public AngularVelocity divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularVelocity(super.divideBy(r));
}
public SolidAngle divideBy(CurrentPerAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new SolidAngle(super.divideBy(r));
}
public CurrentPerAngle divideBy(SolidAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new CurrentPerAngle(super.divideBy(r));
}
public UReal divideBy(MagnetomotiveForce r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MagnetomotiveForce abs() { //units are maintained
return new MagnetomotiveForce(super.abs());
}
public MagnetomotiveForce neg() { //units are maintained
return new MagnetomotiveForce(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MagnetomotiveForce r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MagnetomotiveForce r) {
return !(this.equals(r));
}
public MagnetomotiveForce floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MagnetomotiveForce(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MagnetomotiveForce round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MagnetomotiveForce(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MagnetomotiveForce min(MagnetomotiveForce r) { // units maintained
if (r.lessThan(this)) return new MagnetomotiveForce(r.getX(),r.getU(),r.getUnits());
return new MagnetomotiveForce(this.getX(),this.getU(),this.getUnits());
}
public MagnetomotiveForce max(MagnetomotiveForce r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MagnetomotiveForce(r.getX(),r.getU(),r.getUnits());
return new MagnetomotiveForce(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MagnetomotiveForce mult(double r) {
return new MagnetomotiveForce(this.value.mult(new UReal(r)),this.getUnits());
}
public MagnetomotiveForce divideBy(double r) {
return new MagnetomotiveForce(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MagnetomotiveForce mult(UReal r) {
return new MagnetomotiveForce(this.value.mult(r),this.getUnits());
}
public MagnetomotiveForce divideBy(UReal r) {
return new MagnetomotiveForce(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MagnetomotiveForce clone() {
return new MagnetomotiveForce(this.getUReal(),this.getUnits());
}
}
