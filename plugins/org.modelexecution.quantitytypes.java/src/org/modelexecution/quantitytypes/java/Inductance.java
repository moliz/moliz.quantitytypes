package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Inductance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=-2.0;
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

public Inductance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Inductance");
this.unit = new Unit (q.unit);
}
public Inductance () {
value = new UReal();
unit = new Unit(DerivedUnits.Henry);
}
public Inductance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Henry);
}
public Inductance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Inductance");
this.unit = new Unit (unit);
}
public Inductance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Henry);
}
public Inductance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Henry);
}
public Inductance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Inductance");
this.unit = new Unit (unit);
}
public Inductance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Inductance");
this.unit = new Unit (unit);
}
public Inductance(String x) { //creates a Inductance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Henry);
}
public Inductance(String x, String u) { //creates a Inductance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Henry);
}
public Inductance(String x, String u, Unit unit) { //creates a Inductance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Inductance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Inductance add(Inductance r) {  //only works if compatible units && operand has no offset
return new Inductance(super.add(r));
}
public Inductance minus(Inductance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Inductance(super.minus(r));
}
public MagneticFlux mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public Resistance mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Resistance(super.mult(r));
}
public TimeSquared mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TimeSquared(super.mult(r));
}
public MagneticFluxDensity mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFluxDensity(super.mult(r));
}
public Time mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public Resistance mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Resistance(super.mult(r));
}
public InversePermittivity mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public InversePermittivity mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public Permeability divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public Resistance divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public Length divideBy(Permeability r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Time divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public UReal divideBy(Inductance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Inductance abs() { //units are maintained
return new Inductance(super.abs());
}
public Inductance neg() { //units are maintained
return new Inductance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Inductance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Inductance r) {
return !(this.equals(r));
}
public Inductance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Inductance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Inductance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Inductance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Inductance min(Inductance r) { // units maintained
if (r.lessThan(this)) return new Inductance(r.getX(),r.getU(),r.getUnits());
return new Inductance(this.getX(),this.getU(),this.getUnits());
}
public Inductance max(Inductance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Inductance(r.getX(),r.getU(),r.getUnits());
return new Inductance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Inductance mult(double r) {
return new Inductance(this.value.mult(new UReal(r)),this.getUnits());
}
public Inductance divideBy(double r) {
return new Inductance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Inductance mult(UReal r) {
return new Inductance(this.value.mult(r),this.getUnits());
}
public Inductance divideBy(UReal r) {
return new Inductance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Inductance clone() {
return new Inductance(this.getUReal(),this.getUnits());
}
}
