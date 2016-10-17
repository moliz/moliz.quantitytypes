package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Capacitance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=4.0;
x[BaseUnits.Ampere.ordinal()]=2.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Capacitance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Capacitance");
this.unit = new Unit (q.unit);
}
public Capacitance () {
value = new UReal();
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Capacitance");
this.unit = new Unit (unit);
}
public Capacitance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Capacitance");
this.unit = new Unit (unit);
}
public Capacitance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Capacitance");
this.unit = new Unit (unit);
}
public Capacitance(String x) { //creates a Capacitance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance(String x, String u) { //creates a Capacitance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Farad);
}
public Capacitance(String x, String u, Unit unit) { //creates a Capacitance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Capacitance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Capacitance add(Capacitance r) {  //only works if compatible units && operand has no offset
return new Capacitance(super.add(r));
}
public Capacitance minus(Capacitance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Capacitance(super.minus(r));
}
public ElectricalConductivity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricalConductivity(super.mult(r));
}
public ElectricChargeLineDensity mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricCharge mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricChargeLineDensity mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricalConductivity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricalConductivity(super.mult(r));
}
public TimeSquared mult(Inductance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TimeSquared(super.mult(r));
}
public Length mult(InversePermittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public Time mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public Permittivity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Permittivity(super.divideBy(r));
}
public ElectricalConductivity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public Time divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Length divideBy(Permittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public UReal divideBy(Capacitance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Capacitance abs() { //units are maintained
return new Capacitance(super.abs());
}
public Capacitance neg() { //units are maintained
return new Capacitance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Capacitance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Capacitance r) {
return !(this.equals(r));
}
public Capacitance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Capacitance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Capacitance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Capacitance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Capacitance min(Capacitance r) { // units maintained
if (r.lessThan(this)) return new Capacitance(r.getX(),r.getU(),r.getUnits());
return new Capacitance(this.getX(),this.getU(),this.getUnits());
}
public Capacitance max(Capacitance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Capacitance(r.getX(),r.getU(),r.getUnits());
return new Capacitance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Capacitance mult(double r) {
return new Capacitance(this.value.mult(new UReal(r)),this.getUnits());
}
public Capacitance divideBy(double r) {
return new Capacitance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Capacitance mult(UReal r) {
return new Capacitance(this.value.mult(r),this.getUnits());
}
public Capacitance divideBy(UReal r) {
return new Capacitance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Capacitance clone() {
return new Capacitance(this.getUReal(),this.getUnits());
}
}
