package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Storage extends Quantity {
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
x[BaseUnits.Bit.ordinal()]=1.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Storage(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Storage");
this.unit = new Unit (q.unit);
}
public Storage () {
value = new UReal();
unit = new Unit(BaseUnits.Bit);
}
public Storage(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Bit);
}
public Storage(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Storage");
this.unit = new Unit (unit);
}
public Storage(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Bit);
}
public Storage (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Bit);
}
public Storage(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Storage");
this.unit = new Unit (unit);
}
public Storage(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Storage");
this.unit = new Unit (unit);
}
public Storage(String x) { //creates a Storage from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Bit);
}
public Storage(String x, String u) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Bit);
}
public Storage(String x, String u, Unit unit) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Storage");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Storage add(Storage r) {  //only works if compatible units && operand has no offset
return new Storage(super.add(r));
}
public Storage minus(Storage r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Storage(super.minus(r));
}
public StoragePerUnitTime divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new StoragePerUnitTime(super.divideBy(r));
}
public UReal divideBy(Storage r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Storage abs() { //units are maintained
return new Storage(super.abs());
}
public Storage neg() { //units are maintained
return new Storage(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Storage r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Storage r) {
return !(this.equals(r));
}
public Storage floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Storage(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Storage round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Storage(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Storage min(Storage r) { // units maintained
if (r.lt(this)) return new Storage(r.getX(),r.getU(),r.getUnits());
return new Storage(this.getX(),this.getU(),this.getUnits());
}
public Storage max(Storage r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Storage(r.getX(),r.getU(),r.getUnits());
return new Storage(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Storage mult(double r) {
return new Storage(this.value.mult(new UReal(r)),this.getUnits());
}
public Storage divideBy(double r) {
return new Storage(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Storage mult(UReal r) {
return new Storage(this.value.mult(r),this.getUnits());
}
public Storage divideBy(UReal r) {
return new Storage(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Storage clone() {
return new Storage(this.getUReal(),this.getUnits());
}
}
