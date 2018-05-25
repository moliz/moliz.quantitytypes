package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Permeability extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
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

public Permeability(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Permeability");
this.unit = new Unit (q.unit);
}
public Permeability () {
value = new UReal();
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Permeability");
this.unit = new Unit (unit);
}
public Permeability(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permeability");
this.unit = new Unit (unit);
}
public Permeability(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permeability");
this.unit = new Unit (unit);
}
public Permeability(String x) { //creates a Permeability from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability(String x, String u) { //creates a Permeability from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.HenryPerMeter);
}
public Permeability(String x, String u, Unit unit) { //creates a Permeability from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permeability");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Permeability add(Permeability r) {  //only works if compatible units && operand has no offset
return new Permeability(super.add(r));
}
public Permeability minus(Permeability r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Permeability(super.minus(r));
}
public Inductance mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Inductance(super.mult(r));
}
public InversePermittivity mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public InversePermittivity mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public Resistance mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Resistance(super.mult(r));
}
public MagneticFluxDensity mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFluxDensity(super.mult(r));
}
public InversePermittivity mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public UReal divideBy(Permeability r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Permeability abs() { //units are maintained
return new Permeability(super.abs());
}
public Permeability neg() { //units are maintained
return new Permeability(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Permeability r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Permeability r) {
return !(this.equals(r));
}
public Permeability floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Permeability(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Permeability round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Permeability(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Permeability min(Permeability r) { // units maintained
if (r.lt(this)) return new Permeability(r.getX(),r.getU(),r.getUnits());
return new Permeability(this.getX(),this.getU(),this.getUnits());
}
public Permeability max(Permeability r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Permeability(r.getX(),r.getU(),r.getUnits());
return new Permeability(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Permeability mult(double r) {
return new Permeability(this.value.mult(new UReal(r)),this.getUnits());
}
public Permeability divideBy(double r) {
return new Permeability(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Permeability mult(UReal r) {
return new Permeability(this.value.mult(r),this.getUnits());
}
public Permeability divideBy(UReal r) {
return new Permeability(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Permeability clone() {
return new Permeability(this.getUReal(),this.getUnits());
}
}
