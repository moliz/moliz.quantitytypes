package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class PowerPerAreaAngle extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=-2.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public PowerPerAreaAngle(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAreaAngle");
this.unit = new Unit (q.unit);
}
public PowerPerAreaAngle () {
value = new UReal();
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerAreaAngle");
this.unit = new Unit (unit);
}
public PowerPerAreaAngle(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAreaAngle");
this.unit = new Unit (unit);
}
public PowerPerAreaAngle(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAreaAngle");
this.unit = new Unit (unit);
}
public PowerPerAreaAngle(String x) { //creates a PowerPerAreaAngle from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle(String x, String u) { //creates a PowerPerAreaAngle from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
}
public PowerPerAreaAngle(String x, String u, Unit unit) { //creates a PowerPerAreaAngle from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAreaAngle");
this.unit = new Unit (unit);
}
// Specific Type Operations
public PowerPerAreaAngle add(PowerPerAreaAngle r) {  //only works if compatible units && operand has no offset
return new PowerPerAreaAngle(super.add(r));
}
public PowerPerAreaAngle minus(PowerPerAreaAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new PowerPerAreaAngle(super.minus(r));
}
public PowerPerAngle mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new PowerPerAngle(super.mult(r));
}
public HeatFlowRate mult(AreaAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(SolidAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public UReal divideBy(PowerPerAreaAngle r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public PowerPerAreaAngle abs() { //units are maintained
return new PowerPerAreaAngle(super.abs());
}
public PowerPerAreaAngle neg() { //units are maintained
return new PowerPerAreaAngle(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(PowerPerAreaAngle r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(PowerPerAreaAngle r) {
return !(this.equals(r));
}
public PowerPerAreaAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new PowerPerAreaAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public PowerPerAreaAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
return new PowerPerAreaAngle(Math.round(this.getX()),this.getU(),this.getUnits());
}
public PowerPerAreaAngle min(PowerPerAreaAngle r) { // units maintained
if (r.lessThan(this)) return new PowerPerAreaAngle(r.getX(),r.getU(),r.getUnits());
return new PowerPerAreaAngle(this.getX(),this.getU(),this.getUnits());
}
public PowerPerAreaAngle max(PowerPerAreaAngle r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new PowerPerAreaAngle(r.getX(),r.getU(),r.getUnits());
return new PowerPerAreaAngle(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public PowerPerAreaAngle mult(double r) {
return new PowerPerAreaAngle(this.value.mult(new UReal(r)),this.getUnits());
}
public PowerPerAreaAngle divideBy(double r) {
return new PowerPerAreaAngle(this.value.divideBy(new UReal(r)),this.getUnits());
}
public PowerPerAreaAngle mult(UReal r) {
return new PowerPerAreaAngle(this.value.mult(r),this.getUnits());
}
public PowerPerAreaAngle divideBy(UReal r) {
return new PowerPerAreaAngle(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public PowerPerAreaAngle clone() {
return new PowerPerAreaAngle(this.getUReal(),this.getUnits());
}
}
