package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class StoragePerUnitTime extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-1.0;
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

public StoragePerUnitTime(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a StoragePerUnitTime");
this.unit = new Unit (q.unit);
}
public StoragePerUnitTime () {
value = new UReal();
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a StoragePerUnitTime");
this.unit = new Unit (unit);
}
public StoragePerUnitTime(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a StoragePerUnitTime");
this.unit = new Unit (unit);
}
public StoragePerUnitTime(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a StoragePerUnitTime");
this.unit = new Unit (unit);
}
public StoragePerUnitTime(String x) { //creates a Storage from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime(String x, String u) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Bit);
}
public StoragePerUnitTime(String x, String u, Unit unit) { //creates a Storage from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a StoragePerUnitTime");
this.unit = new Unit (unit);
}
// Specific Type Operations
public StoragePerUnitTime add(StoragePerUnitTime r) {  //only works if compatible units && operand has no offset
return new StoragePerUnitTime(super.add(r));
}
public StoragePerUnitTime minus(StoragePerUnitTime r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new StoragePerUnitTime(super.minus(r));
}
public Storage mult(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new Storage(super.mult(r));
}
public UReal divideBy(StoragePerUnitTime r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public StoragePerUnitTime abs() { //units are maintained
return new StoragePerUnitTime(super.abs());
}
public StoragePerUnitTime neg() { //units are maintained
return new StoragePerUnitTime(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(StoragePerUnitTime r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(StoragePerUnitTime r) {
return !(this.equals(r));
}
public StoragePerUnitTime floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new StoragePerUnitTime(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public StoragePerUnitTime round(){ //returns (i,u) with i the closest int to x -- units maintained
return new StoragePerUnitTime(Math.round(this.getX()),this.getU(),this.getUnits());
}
public StoragePerUnitTime min(StoragePerUnitTime r) { // units maintained
if (r.lessThan(this)) return new StoragePerUnitTime(r.getX(),r.getU(),r.getUnits());
return new StoragePerUnitTime(this.getX(),this.getU(),this.getUnits());
}
public StoragePerUnitTime max(StoragePerUnitTime r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new StoragePerUnitTime(r.getX(),r.getU(),r.getUnits());
return new StoragePerUnitTime(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public StoragePerUnitTime mult(double r) {
return new StoragePerUnitTime(this.value.mult(new UReal(r)),this.getUnits());
}
public StoragePerUnitTime divideBy(double r) {
return new StoragePerUnitTime(this.value.divideBy(new UReal(r)),this.getUnits());
}
public StoragePerUnitTime mult(UReal r) {
return new StoragePerUnitTime(this.value.mult(r),this.getUnits());
}
public StoragePerUnitTime divideBy(UReal r) {
return new StoragePerUnitTime(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public StoragePerUnitTime clone() {
return new StoragePerUnitTime(this.getUReal(),this.getUnits());
}
}
