package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ThermalResistance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ThermalResistance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistance");
this.unit = new Unit (q.unit);
}
public ThermalResistance () {
value = new UReal();
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalResistance");
this.unit = new Unit (unit);
}
public ThermalResistance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistance");
this.unit = new Unit (unit);
}
public ThermalResistance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistance");
this.unit = new Unit (unit);
}
public ThermalResistance(String x) { //creates a ThermalResistance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance(String x, String u) { //creates a ThermalResistance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KelvinPerWatt);
}
public ThermalResistance(String x, String u, Unit unit) { //creates a ThermalResistance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ThermalResistance add(ThermalResistance r) {  //only works if compatible units && operand has no offset
return new ThermalResistance(super.add(r));
}
public ThermalResistance minus(ThermalResistance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ThermalResistance(super.minus(r));
}
public ThermalResistivity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalResistivity(super.mult(r));
}
public ThermalInsulance mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalInsulance(super.mult(r));
}
public Time mult(HeatCapacityAndEntropy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public ThermodynamicTemperature mult(HeatFlowRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public ThermodynamicTemperature mult(Power r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public ThermalResistance abs() { //units are maintained
return new ThermalResistance(super.abs());
}
public ThermalResistance neg() { //units are maintained
return new ThermalResistance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ThermalResistance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ThermalResistance r) {
return !(this.equals(r));
}
public ThermalResistance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ThermalResistance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ThermalResistance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ThermalResistance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ThermalResistance min(ThermalResistance r) { // units maintained
if (r.lessThan(this)) return new ThermalResistance(r.getX(),r.getU(),r.getUnits());
return new ThermalResistance(this.getX(),this.getU(),this.getUnits());
}
public ThermalResistance max(ThermalResistance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ThermalResistance(r.getX(),r.getU(),r.getUnits());
return new ThermalResistance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ThermalResistance mult(double r) {
return new ThermalResistance(this.value.mult(new UReal(r)),this.getUnits());
}
public ThermalResistance divideBy(double r) {
return new ThermalResistance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ThermalResistance mult(UReal r) {
return new ThermalResistance(this.value.mult(r),this.getUnits());
}
public ThermalResistance divideBy(UReal r) {
return new ThermalResistance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ThermalResistance clone() {
return new ThermalResistance(this.getUReal(),this.getUnits());
}
}
