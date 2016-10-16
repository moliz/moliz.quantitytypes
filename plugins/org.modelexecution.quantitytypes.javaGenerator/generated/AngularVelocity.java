package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AngularVelocity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-1.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=1.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AngularVelocity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AngularVelocity");
this.unit = new Unit (q.unit);
}
public AngularVelocity () {
value = new UReal();
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularVelocity");
this.unit = new Unit (unit);
}
public AngularVelocity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularVelocity");
this.unit = new Unit (unit);
}
public AngularVelocity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularVelocity");
this.unit = new Unit (unit);
}
public AngularVelocity(String x) { //creates a AngularVelocity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity(String x, String u) { //creates a AngularVelocity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.RadianPerSecond);
}
public AngularVelocity(String x, String u, Unit unit) { //creates a AngularVelocity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularVelocity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AngularVelocity add(AngularVelocity r) {  //only works if compatible units && operand has no offset
return new AngularVelocity(super.add(r));
}
public AngularVelocity minus(AngularVelocity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AngularVelocity(super.minus(r));
}
public Angle mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Angle(super.mult(r));
}
public AngularAcceleration mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularAcceleration(super.mult(r));
}
public MagnetomotiveForce mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public AngularAcceleration mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularAcceleration(super.mult(r));
}
public AngularAcceleration divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularAcceleration(super.divideBy(r));
}
public Activity divideBy(Angle r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Angle divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public Time divideBy(AngularAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Angle divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public AngularVelocity abs() { //units are maintained
return new AngularVelocity(super.abs());
}
public AngularVelocity neg() { //units are maintained
return new AngularVelocity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AngularVelocity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AngularVelocity r) {
return !(this.equals(r));
}
public AngularVelocity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AngularVelocity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AngularVelocity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AngularVelocity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AngularVelocity min(AngularVelocity r) { // units maintained
if (r.lessThan(this)) return new AngularVelocity(r.getX(),r.getU(),r.getUnits());
return new AngularVelocity(this.getX(),this.getU(),this.getUnits());
}
public AngularVelocity max(AngularVelocity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AngularVelocity(r.getX(),r.getU(),r.getUnits());
return new AngularVelocity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AngularVelocity mult(double r) {
return new AngularVelocity(this.value.mult(new UReal(r)),this.getUnits());
}
public AngularVelocity divideBy(double r) {
return new AngularVelocity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AngularVelocity mult(UReal r) {
return new AngularVelocity(this.value.mult(r),this.getUnits());
}
public AngularVelocity divideBy(UReal r) {
return new AngularVelocity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AngularVelocity clone() {
return new AngularVelocity(this.getUReal(),this.getUnits());
}
}
