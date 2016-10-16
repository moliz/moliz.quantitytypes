package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class SpecificHeatVolume extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=-1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public SpecificHeatVolume(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatVolume");
this.unit = new Unit (q.unit);
}
public SpecificHeatVolume () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an SpecificHeatVolume");
this.unit = new Unit (unit);
}
public SpecificHeatVolume(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatVolume");
this.unit = new Unit (unit);
}
public SpecificHeatVolume(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatVolume");
this.unit = new Unit (unit);
}
public SpecificHeatVolume(String x) { //creates a SpecificHeatVolume from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume(String x, String u) { //creates a SpecificHeatVolume from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
}
public SpecificHeatVolume(String x, String u, Unit unit) { //creates a SpecificHeatVolume from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatVolume");
this.unit = new Unit (unit);
}
// Specific Type Operations
public SpecificHeatVolume add(SpecificHeatVolume r) {  //only works if compatible units && operand has no offset
return new SpecificHeatVolume(super.add(r));
}
public SpecificHeatVolume minus(SpecificHeatVolume r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new SpecificHeatVolume(super.minus(r));
}
public VolumetricHeatCapacity mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public ThermalConductivity mult(AngularMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public LinearAcceleration mult(AreaTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public CoefficientOfHeatTransfer mult(LinearMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.mult(r));
}
public EnergyDensity mult(MassTemPerature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public SpecificHeatCapacity mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public SpecificHeatVolume abs() { //units are maintained
return new SpecificHeatVolume(super.abs());
}
public SpecificHeatVolume neg() { //units are maintained
return new SpecificHeatVolume(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(SpecificHeatVolume r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(SpecificHeatVolume r) {
return !(this.equals(r));
}
public SpecificHeatVolume floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new SpecificHeatVolume(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public SpecificHeatVolume round(){ //returns (i,u) with i the closest int to x -- units maintained
return new SpecificHeatVolume(Math.round(this.getX()),this.getU(),this.getUnits());
}
public SpecificHeatVolume min(SpecificHeatVolume r) { // units maintained
if (r.lessThan(this)) return new SpecificHeatVolume(r.getX(),r.getU(),r.getUnits());
return new SpecificHeatVolume(this.getX(),this.getU(),this.getUnits());
}
public SpecificHeatVolume max(SpecificHeatVolume r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new SpecificHeatVolume(r.getX(),r.getU(),r.getUnits());
return new SpecificHeatVolume(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public SpecificHeatVolume mult(double r) {
return new SpecificHeatVolume(this.value.mult(new UReal(r)),this.getUnits());
}
public SpecificHeatVolume divideBy(double r) {
return new SpecificHeatVolume(this.value.divideBy(new UReal(r)),this.getUnits());
}
public SpecificHeatVolume mult(UReal r) {
return new SpecificHeatVolume(this.value.mult(r),this.getUnits());
}
public SpecificHeatVolume divideBy(UReal r) {
return new SpecificHeatVolume(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public SpecificHeatVolume clone() {
return new SpecificHeatVolume(this.getUReal(),this.getUnits());
}
}
