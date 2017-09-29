package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class SolidAngle extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=2.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public SolidAngle(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
this.unit = new Unit (q.unit);
}
public SolidAngle () {
value = new UReal();
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an SolidAngle");
this.unit = new Unit (unit);
}
public SolidAngle(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
this.unit = new Unit (unit);
}
public SolidAngle(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
this.unit = new Unit (unit);
}
public SolidAngle(String x) { //creates a SolidAngle from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle(String x, String u) { //creates a SolidAngle from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Steradian);
}
public SolidAngle(String x, String u, Unit unit) { //creates a SolidAngle from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SolidAngle");
this.unit = new Unit (unit);
}
// Specific Type Operations
public SolidAngle add(SolidAngle r) {  //only works if compatible units && operand has no offset
return new SolidAngle(super.add(r));
}
public SolidAngle minus(SolidAngle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new SolidAngle(super.minus(r));
}
public AreaAngle mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaAngle(super.mult(r));
}
public MagnetomotiveForce mult(CurrentPerAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public HeatFlowRate mult(PowerPerAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(PowerPerAreaAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public Angle divideBy(Angle r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public UReal divideBy(SolidAngle r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Angle sqrt() {
return new  Angle(super.sqrt());
}
public SolidAngle abs() { //units are maintained
return new SolidAngle(super.abs());
}
public SolidAngle neg() { //units are maintained
return new SolidAngle(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(SolidAngle r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(SolidAngle r) {
return !(this.equals(r));
}
public SolidAngle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new SolidAngle(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public SolidAngle round(){ //returns (i,u) with i the closest int to x -- units maintained
return new SolidAngle(Math.round(this.getX()),this.getU(),this.getUnits());
}
public SolidAngle min(SolidAngle r) { // units maintained
if (r.lessThan(this)) return new SolidAngle(r.getX(),r.getU(),r.getUnits());
return new SolidAngle(this.getX(),this.getU(),this.getUnits());
}
public SolidAngle max(SolidAngle r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new SolidAngle(r.getX(),r.getU(),r.getUnits());
return new SolidAngle(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public SolidAngle mult(double r) {
return new SolidAngle(this.value.mult(new UReal(r)),this.getUnits());
}
public SolidAngle divideBy(double r) {
return new SolidAngle(this.value.divideBy(new UReal(r)),this.getUnits());
}
public SolidAngle mult(UReal r) {
return new SolidAngle(this.value.mult(r),this.getUnits());
}
public SolidAngle divideBy(UReal r) {
return new SolidAngle(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public SolidAngle clone() {
return new SolidAngle(this.getUReal(),this.getUnits());
}
}
