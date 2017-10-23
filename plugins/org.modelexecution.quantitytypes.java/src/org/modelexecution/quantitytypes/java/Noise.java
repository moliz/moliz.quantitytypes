package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Noise extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=1.0;
return Arrays.equals(x,u.dimensions);
}

public Noise(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Noise");
this.unit = new Unit (q.unit);
}
public Noise () {
value = new UReal();
unit = new Unit(BaseUnits.Decibel);
}
public Noise(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Decibel);
}
public Noise(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Noise");
this.unit = new Unit (unit);
}
public Noise(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Decibel);
}
public Noise (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Decibel);
}
public Noise(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Noise");
this.unit = new Unit (unit);
}
public Noise(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Noise");
this.unit = new Unit (unit);
}
public Noise(String x) { //creates a Storage from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Decibel);
}
public Noise(String x, String u) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Decibel);
}
public Noise(String x, String u, Unit unit) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Noise");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Noise add(Noise r) {  //only works if compatible units && operand has no offset
return new Noise(super.add(r));
}
public Noise minus(Noise r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Noise(super.minus(r));
}
public UReal divideBy(Noise r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Noise abs() { //units are maintained
return new Noise(super.abs());
}
public Noise neg() { //units are maintained
return new Noise(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Noise r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Noise r) {
return !(this.equals(r));
}
public Noise floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Noise(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Noise round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Noise(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Noise min(Noise r) { // units maintained
if (r.lessThan(this)) return new Noise(r.getX(),r.getU(),r.getUnits());
return new Noise(this.getX(),this.getU(),this.getUnits());
}
public Noise max(Noise r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Noise(r.getX(),r.getU(),r.getUnits());
return new Noise(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Noise mult(double r) {
return new Noise(this.value.mult(new UReal(r)),this.getUnits());
}
public Noise divideBy(double r) {
return new Noise(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Noise mult(UReal r) {
return new Noise(this.value.mult(r),this.getUnits());
}
public Noise divideBy(UReal r) {
return new Noise(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Noise clone() {
return new Noise(this.getUReal(),this.getUnits());
}
}
