package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class GravitationalAttraction extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=3.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public GravitationalAttraction(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a GravitationalAttraction");
this.unit = new Unit (q.unit);
}
public GravitationalAttraction () {
value = new UReal();
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an GravitationalAttraction");
this.unit = new Unit (unit);
}
public GravitationalAttraction(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a GravitationalAttraction");
this.unit = new Unit (unit);
}
public GravitationalAttraction(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a GravitationalAttraction");
this.unit = new Unit (unit);
}
public GravitationalAttraction(String x) { //creates a GravitationalAttraction from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction(String x, String u) { //creates a GravitationalAttraction from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
}
public GravitationalAttraction(String x, String u, Unit unit) { //creates a GravitationalAttraction from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a GravitationalAttraction");
this.unit = new Unit (unit);
}
// Specific Type Operations
public GravitationalAttraction add(GravitationalAttraction r) {  //only works if compatible units && operand has no offset
return new GravitationalAttraction(super.add(r));
}
public GravitationalAttraction minus(GravitationalAttraction r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new GravitationalAttraction(super.minus(r));
}
public AbsorbedDoseRate mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public LinearAcceleration mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public AbsorbedDose mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public UReal divideBy(GravitationalAttraction r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public GravitationalAttraction abs() { //units are maintained
return new GravitationalAttraction(super.abs());
}
public GravitationalAttraction neg() { //units are maintained
return new GravitationalAttraction(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(GravitationalAttraction r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(GravitationalAttraction r) {
return !(this.equals(r));
}
public GravitationalAttraction floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new GravitationalAttraction(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public GravitationalAttraction round(){ //returns (i,u) with i the closest int to x -- units maintained
return new GravitationalAttraction(Math.round(this.getX()),this.getU(),this.getUnits());
}
public GravitationalAttraction min(GravitationalAttraction r) { // units maintained
if (r.lt(this)) return new GravitationalAttraction(r.getX(),r.getU(),r.getUnits());
return new GravitationalAttraction(this.getX(),this.getU(),this.getUnits());
}
public GravitationalAttraction max(GravitationalAttraction r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new GravitationalAttraction(r.getX(),r.getU(),r.getUnits());
return new GravitationalAttraction(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public GravitationalAttraction mult(double r) {
return new GravitationalAttraction(this.value.mult(new UReal(r)),this.getUnits());
}
public GravitationalAttraction divideBy(double r) {
return new GravitationalAttraction(this.value.divideBy(new UReal(r)),this.getUnits());
}
public GravitationalAttraction mult(UReal r) {
return new GravitationalAttraction(this.value.mult(r),this.getUnits());
}
public GravitationalAttraction divideBy(UReal r) {
return new GravitationalAttraction(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public GravitationalAttraction clone() {
return new GravitationalAttraction(this.getUReal(),this.getUnits());
}
}
