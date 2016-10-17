package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Luminance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=1.0;
return Arrays.equals(x,u.dimensions);
}

public Luminance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Luminance");
this.unit = new Unit (q.unit);
}
public Luminance () {
value = new UReal();
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Luminance");
this.unit = new Unit (unit);
}
public Luminance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Luminance");
this.unit = new Unit (unit);
}
public Luminance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Luminance");
this.unit = new Unit (unit);
}
public Luminance(String x) { //creates a Luminance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance(String x, String u) { //creates a Luminance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CandelaPerSquareMeter);
}
public Luminance(String x, String u, Unit unit) { //creates a Luminance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Luminance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Luminance add(Luminance r) {  //only works if compatible units && operand has no offset
return new Luminance(super.add(r));
}
public Luminance minus(Luminance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Luminance(super.minus(r));
}
public Illuminance mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Illuminance(super.mult(r));
}
public LuminousIntensity mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LuminousIntensity(super.mult(r));
}
public UReal divideBy(Luminance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Luminance abs() { //units are maintained
return new Luminance(super.abs());
}
public Luminance neg() { //units are maintained
return new Luminance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Luminance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Luminance r) {
return !(this.equals(r));
}
public Luminance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Luminance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Luminance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Luminance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Luminance min(Luminance r) { // units maintained
if (r.lessThan(this)) return new Luminance(r.getX(),r.getU(),r.getUnits());
return new Luminance(this.getX(),this.getU(),this.getUnits());
}
public Luminance max(Luminance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Luminance(r.getX(),r.getU(),r.getUnits());
return new Luminance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Luminance mult(double r) {
return new Luminance(this.value.mult(new UReal(r)),this.getUnits());
}
public Luminance divideBy(double r) {
return new Luminance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Luminance mult(UReal r) {
return new Luminance(this.value.mult(r),this.getUnits());
}
public Luminance divideBy(UReal r) {
return new Luminance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Luminance clone() {
return new Luminance(this.getUReal(),this.getUnits());
}
}
