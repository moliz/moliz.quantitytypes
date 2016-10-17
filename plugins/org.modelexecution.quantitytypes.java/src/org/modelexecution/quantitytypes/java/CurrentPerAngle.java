package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class CurrentPerAngle extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=-1.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public CurrentPerAngle(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a CurrentPerAngle");
this.unit = new Unit (q.unit);
}
public CurrentPerAngle () {
value = new UReal();
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CurrentPerAngle");
this.unit = new Unit (unit);
}
public CurrentPerAngle(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CurrentPerAngle");
this.unit = new Unit (unit);
}
public CurrentPerAngle(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CurrentPerAngle");
this.unit = new Unit (unit);
}
public CurrentPerAngle(String x) { //creates a CurrentPerAngle from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle(String x, String u) { //creates a CurrentPerAngle from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmperePerRadian);
}
public CurrentPerAngle(String x, String u, Unit unit) { //creates a CurrentPerAngle from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CurrentPerAngle");
this.unit = new Unit (unit);
}
// Specific Type Operations
public CurrentPerAngle add(CurrentPerAngle r) {  //only works if compatible units && operand has no offset
return new CurrentPerAngle(super.add(r));
}
public CurrentPerAngle minus(CurrentPerAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new CurrentPerAngle(super.minus(r));
}
public ElectricCurrent mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MagnetomotiveForce mult(SolidAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public UReal divideBy(CurrentPerAngle r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public CurrentPerAngle abs() { //units are maintained
return new CurrentPerAngle(super.abs());
}
public CurrentPerAngle neg() { //units are maintained
return new CurrentPerAngle(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(CurrentPerAngle r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(CurrentPerAngle r) {
return !(this.equals(r));
}
public CurrentPerAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new CurrentPerAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public CurrentPerAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
return new CurrentPerAngle(Math.round(this.getX()),this.getU(),this.getUnits());
}
public CurrentPerAngle min(CurrentPerAngle r) { // units maintained
if (r.lessThan(this)) return new CurrentPerAngle(r.getX(),r.getU(),r.getUnits());
return new CurrentPerAngle(this.getX(),this.getU(),this.getUnits());
}
public CurrentPerAngle max(CurrentPerAngle r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new CurrentPerAngle(r.getX(),r.getU(),r.getUnits());
return new CurrentPerAngle(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public CurrentPerAngle mult(double r) {
return new CurrentPerAngle(this.value.mult(new UReal(r)),this.getUnits());
}
public CurrentPerAngle divideBy(double r) {
return new CurrentPerAngle(this.value.divideBy(new UReal(r)),this.getUnits());
}
public CurrentPerAngle mult(UReal r) {
return new CurrentPerAngle(this.value.mult(r),this.getUnits());
}
public CurrentPerAngle divideBy(UReal r) {
return new CurrentPerAngle(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public CurrentPerAngle clone() {
return new CurrentPerAngle(this.getUReal(),this.getUnits());
}
}
