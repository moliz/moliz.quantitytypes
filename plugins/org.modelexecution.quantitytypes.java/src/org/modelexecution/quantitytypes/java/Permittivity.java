package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Permittivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-3.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=4.0;
x[BaseUnits.Ampere.ordinal()]=2.0;
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

public Permittivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Permittivity");
this.unit = new Unit (q.unit);
}
public Permittivity () {
value = new UReal();
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Permittivity");
this.unit = new Unit (unit);
}
public Permittivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permittivity");
this.unit = new Unit (unit);
}
public Permittivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permittivity");
this.unit = new Unit (unit);
}
public Permittivity(String x) { //creates a Permittivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity(String x, String u) { //creates a Permittivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.FaradPerMeter);
}
public Permittivity(String x, String u, Unit unit) { //creates a Permittivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Permittivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Permittivity add(Permittivity r) {  //only works if compatible units && operand has no offset
return new Permittivity(super.add(r));
}
public Permittivity minus(Permittivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Permittivity(super.minus(r));
}
public Capacitance mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Capacitance(super.mult(r));
}
public ElectricFluxDensity mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public ElectricChargeLineDensity mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricFluxDensity mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public ElectricalConductivity mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricalConductivity(super.mult(r));
}
public UReal divideBy(Permittivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public InversePermittivity inverse() {
return new  InversePermittivity(super.inverse());
}
public Permittivity abs() { //units are maintained
return new Permittivity(super.abs());
}
public Permittivity neg() { //units are maintained
return new Permittivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Permittivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Permittivity r) {
return !(this.equals(r));
}
public Permittivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Permittivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Permittivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Permittivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Permittivity min(Permittivity r) { // units maintained
if (r.lessThan(this)) return new Permittivity(r.getX(),r.getU(),r.getUnits());
return new Permittivity(this.getX(),this.getU(),this.getUnits());
}
public Permittivity max(Permittivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Permittivity(r.getX(),r.getU(),r.getUnits());
return new Permittivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Permittivity mult(double r) {
return new Permittivity(this.value.mult(new UReal(r)),this.getUnits());
}
public Permittivity divideBy(double r) {
return new Permittivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Permittivity mult(UReal r) {
return new Permittivity(this.value.mult(r),this.getUnits());
}
public Permittivity divideBy(UReal r) {
return new Permittivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Permittivity clone() {
return new Permittivity(this.getUReal(),this.getUnits());
}
}
