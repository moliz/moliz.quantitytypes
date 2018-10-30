package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ThermalInsulance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ThermalInsulance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermalInsulance");
this.unit = new Unit (q.unit);
}
public ThermalInsulance () {
value = new UReal();
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalInsulance");
this.unit = new Unit (unit);
}
public ThermalInsulance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalInsulance");
this.unit = new Unit (unit);
}
public ThermalInsulance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalInsulance");
this.unit = new Unit (unit);
}
public ThermalInsulance(String x) { //creates a ThermalInsulance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance(String x, String u) { //creates a ThermalInsulance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
}
public ThermalInsulance(String x, String u, Unit unit) { //creates a ThermalInsulance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalInsulance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ThermalInsulance add(ThermalInsulance r) {  //only works if compatible units && operand has no offset
return new ThermalInsulance(super.add(r));
}
public ThermalInsulance minus(ThermalInsulance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ThermalInsulance(super.minus(r));
}
public AreaTemperature mult(HeatFlowRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public ThermodynamicTemperature mult(HeatFlowRatePerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public AreaTemperature mult(Power r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public ThermodynamicTemperature mult(PowerPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public Length mult(ThermalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public ThermalResistivity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistivity(super.divideBy(r));
}
public ThermalResistance divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistance(super.divideBy(r));
}
public Area divideBy(ThermalResistance r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(ThermalResistivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public UReal divideBy(ThermalInsulance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public CoefficientOfHeatTransfer inverse() {
return new  CoefficientOfHeatTransfer(super.inverse());
}
public ThermalInsulance abs() { //units are maintained
return new ThermalInsulance(super.abs());
}
public ThermalInsulance neg() { //units are maintained
return new ThermalInsulance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ThermalInsulance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ThermalInsulance r) {
return !(this.equals(r));
}
public ThermalInsulance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ThermalInsulance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ThermalInsulance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ThermalInsulance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ThermalInsulance min(ThermalInsulance r) { // units maintained
if (r.lt(this)) return new ThermalInsulance(r.getX(),r.getU(),r.getUnits());
return new ThermalInsulance(this.getX(),this.getU(),this.getUnits());
}
public ThermalInsulance max(ThermalInsulance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ThermalInsulance(r.getX(),r.getU(),r.getUnits());
return new ThermalInsulance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ThermalInsulance mult(double r) {
return new ThermalInsulance(this.value.mult(new UReal(r)),this.getUnits());
}
public ThermalInsulance divideBy(double r) {
return new ThermalInsulance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ThermalInsulance mult(UReal r) {
return new ThermalInsulance(this.value.mult(r),this.getUnits());
}
public ThermalInsulance divideBy(UReal r) {
return new ThermalInsulance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ThermalInsulance clone() {
return new ThermalInsulance(this.getUReal(),this.getUnits());
}
}
