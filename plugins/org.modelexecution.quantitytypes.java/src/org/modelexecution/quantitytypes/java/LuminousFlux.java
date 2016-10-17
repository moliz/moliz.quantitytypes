package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LuminousFlux extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=1.0;
x[BaseUnits.Candela.ordinal()]=1.0;
return Arrays.equals(x,u.dimensions);
}

public LuminousFlux(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LuminousFlux");
this.unit = new Unit (q.unit);
}
public LuminousFlux () {
value = new UReal();
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LuminousFlux");
this.unit = new Unit (unit);
}
public LuminousFlux(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LuminousFlux");
this.unit = new Unit (unit);
}
public LuminousFlux(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LuminousFlux");
this.unit = new Unit (unit);
}
public LuminousFlux(String x) { //creates a LuminousFlux from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux(String x, String u) { //creates a LuminousFlux from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Lumen);
}
public LuminousFlux(String x, String u, Unit unit) { //creates a LuminousFlux from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LuminousFlux");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LuminousFlux add(LuminousFlux r) {  //only works if compatible units && operand has no offset
return new LuminousFlux(super.add(r));
}
public LuminousFlux minus(LuminousFlux r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LuminousFlux(super.minus(r));
}
public LuminousIntensity divideBy(Angle r) { //both values and units are divided. No offsets allowed in any of the units
return new LuminousIntensity(super.divideBy(r));
}
public Angle divideBy(LuminousIntensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public Illuminance divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new Illuminance(super.divideBy(r));
}
public Area divideBy(Illuminance r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public UReal divideBy(LuminousFlux r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public LuminousFlux abs() { //units are maintained
return new LuminousFlux(super.abs());
}
public LuminousFlux neg() { //units are maintained
return new LuminousFlux(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LuminousFlux r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LuminousFlux r) {
return !(this.equals(r));
}
public LuminousFlux floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LuminousFlux(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LuminousFlux round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LuminousFlux(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LuminousFlux min(LuminousFlux r) { // units maintained
if (r.lessThan(this)) return new LuminousFlux(r.getX(),r.getU(),r.getUnits());
return new LuminousFlux(this.getX(),this.getU(),this.getUnits());
}
public LuminousFlux max(LuminousFlux r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LuminousFlux(r.getX(),r.getU(),r.getUnits());
return new LuminousFlux(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LuminousFlux mult(double r) {
return new LuminousFlux(this.value.mult(new UReal(r)),this.getUnits());
}
public LuminousFlux divideBy(double r) {
return new LuminousFlux(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LuminousFlux mult(UReal r) {
return new LuminousFlux(this.value.mult(r),this.getUnits());
}
public LuminousFlux divideBy(UReal r) {
return new LuminousFlux(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LuminousFlux clone() {
return new LuminousFlux(this.getUReal(),this.getUnits());
}
}
