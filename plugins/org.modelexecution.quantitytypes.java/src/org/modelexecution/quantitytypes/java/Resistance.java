package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Resistance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
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

public Resistance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Resistance");
this.unit = new Unit (q.unit);
}
public Resistance () {
value = new UReal();
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Resistance");
this.unit = new Unit (unit);
}
public Resistance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Resistance");
this.unit = new Unit (unit);
}
public Resistance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Resistance");
this.unit = new Unit (unit);
}
public Resistance(String x) { //creates a Resistance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance(String x, String u) { //creates a Resistance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Ohm);
}
public Resistance(String x, String u, Unit unit) { //creates a Resistance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Resistance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Resistance add(Resistance r) {  //only works if compatible units && operand has no offset
return new Resistance(super.add(r));
}
public Resistance minus(Resistance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Resistance(super.minus(r));
}
public Inductance mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Inductance(super.mult(r));
}
public ElectromotiveForce mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public Time mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public MagneticFlux mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public MagneticFluxDensity mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFluxDensity(super.mult(r));
}
public InversePermittivity mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public ElectricFieldStrength mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public Inductance divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public Inductance divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public Activity divideBy(Inductance r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Permeability divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public LinearVelocity divideBy(Permeability r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public UReal divideBy(Resistance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricalConductivity inverse() {
return new  ElectricalConductivity(super.inverse());
}
public Resistance abs() { //units are maintained
return new Resistance(super.abs());
}
public Resistance neg() { //units are maintained
return new Resistance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Resistance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Resistance r) {
return !(this.equals(r));
}
public Resistance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Resistance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Resistance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Resistance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Resistance min(Resistance r) { // units maintained
if (r.lessThan(this)) return new Resistance(r.getX(),r.getU(),r.getUnits());
return new Resistance(this.getX(),this.getU(),this.getUnits());
}
public Resistance max(Resistance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Resistance(r.getX(),r.getU(),r.getUnits());
return new Resistance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Resistance mult(double r) {
return new Resistance(this.value.mult(new UReal(r)),this.getUnits());
}
public Resistance divideBy(double r) {
return new Resistance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Resistance mult(UReal r) {
return new Resistance(this.value.mult(r),this.getUnits());
}
public Resistance divideBy(UReal r) {
return new Resistance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Resistance clone() {
return new Resistance(this.getUReal(),this.getUnits());
}
}
