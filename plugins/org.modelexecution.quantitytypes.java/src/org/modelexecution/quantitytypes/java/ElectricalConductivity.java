package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricalConductivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=3.0;
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

public ElectricalConductivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricalConductivity");
this.unit = new Unit (q.unit);
}
public ElectricalConductivity () {
value = new UReal();
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricalConductivity");
this.unit = new Unit (unit);
}
public ElectricalConductivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricalConductivity");
this.unit = new Unit (unit);
}
public ElectricalConductivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricalConductivity");
this.unit = new Unit (unit);
}
public ElectricalConductivity(String x) { //creates a ElectricalConductivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity(String x, String u) { //creates a ElectricalConductivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Siemens);
}
public ElectricalConductivity(String x, String u, Unit unit) { //creates a ElectricalConductivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricalConductivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricalConductivity add(ElectricalConductivity r) {  //only works if compatible units && operand has no offset
return new ElectricalConductivity(super.add(r));
}
public ElectricalConductivity minus(ElectricalConductivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricalConductivity(super.minus(r));
}
public Capacitance mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Capacitance(super.mult(r));
}
public MagneticFieldStrength mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricCurrent mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MagneticFieldStrength mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public Time mult(Inductance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public LinearVelocity mult(InversePermittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public ElectricCharge mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricFluxDensity mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public Capacitance divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public Activity divideBy(Capacitance r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Capacitance divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public Permittivity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Permittivity(super.divideBy(r));
}
public LinearVelocity divideBy(Permittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public UReal divideBy(ElectricalConductivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Resistance inverse() {
return new  Resistance(super.inverse());
}
public ElectricalConductivity abs() { //units are maintained
return new ElectricalConductivity(super.abs());
}
public ElectricalConductivity neg() { //units are maintained
return new ElectricalConductivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricalConductivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricalConductivity r) {
return !(this.equals(r));
}
public ElectricalConductivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricalConductivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricalConductivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricalConductivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricalConductivity min(ElectricalConductivity r) { // units maintained
if (r.lessThan(this)) return new ElectricalConductivity(r.getX(),r.getU(),r.getUnits());
return new ElectricalConductivity(this.getX(),this.getU(),this.getUnits());
}
public ElectricalConductivity max(ElectricalConductivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricalConductivity(r.getX(),r.getU(),r.getUnits());
return new ElectricalConductivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricalConductivity mult(double r) {
return new ElectricalConductivity(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricalConductivity divideBy(double r) {
return new ElectricalConductivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricalConductivity mult(UReal r) {
return new ElectricalConductivity(this.value.mult(r),this.getUnits());
}
public ElectricalConductivity divideBy(UReal r) {
return new ElectricalConductivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricalConductivity clone() {
return new ElectricalConductivity(this.getUReal(),this.getUnits());
}
}
