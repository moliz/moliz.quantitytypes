package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class TemperatureAmountOfSubstance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public TemperatureAmountOfSubstance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a TemperatureAmountOfSubstance");
this.unit = new Unit (q.unit);
}
public TemperatureAmountOfSubstance () {
value = new UReal();
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an TemperatureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemperatureAmountOfSubstance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemperatureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemperatureAmountOfSubstance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemperatureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemperatureAmountOfSubstance(String x) { //creates a TemperatureAmountOfSubstance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance(String x, String u) { //creates a TemperatureAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemperatureAmountOfSubstance(String x, String u, Unit unit) { //creates a TemperatureAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemperatureAmountOfSubstance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public TemperatureAmountOfSubstance add(TemperatureAmountOfSubstance r) {  //only works if compatible units && operand has no offset
return new TemperatureAmountOfSubstance(super.add(r));
}
public TemperatureAmountOfSubstance minus(TemperatureAmountOfSubstance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new TemperatureAmountOfSubstance(super.minus(r));
}
public ThermodynamicTemperature mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public EnergyAndWork mult(MolarHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AmountOfSubstance divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public MassTemperature divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemperature(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(MassTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public UReal divideBy(TemperatureAmountOfSubstance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public TemperatureAmountOfSubstance abs() { //units are maintained
return new TemperatureAmountOfSubstance(super.abs());
}
public TemperatureAmountOfSubstance neg() { //units are maintained
return new TemperatureAmountOfSubstance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(TemperatureAmountOfSubstance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(TemperatureAmountOfSubstance r) {
return !(this.equals(r));
}
public TemperatureAmountOfSubstance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new TemperatureAmountOfSubstance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public TemperatureAmountOfSubstance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new TemperatureAmountOfSubstance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public TemperatureAmountOfSubstance min(TemperatureAmountOfSubstance r) { // units maintained
if (r.lt(this)) return new TemperatureAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new TemperatureAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
public TemperatureAmountOfSubstance max(TemperatureAmountOfSubstance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new TemperatureAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new TemperatureAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public TemperatureAmountOfSubstance mult(double r) {
return new TemperatureAmountOfSubstance(this.value.mult(new UReal(r)),this.getUnits());
}
public TemperatureAmountOfSubstance divideBy(double r) {
return new TemperatureAmountOfSubstance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public TemperatureAmountOfSubstance mult(UReal r) {
return new TemperatureAmountOfSubstance(this.value.mult(r),this.getUnits());
}
public TemperatureAmountOfSubstance divideBy(UReal r) {
return new TemperatureAmountOfSubstance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public TemperatureAmountOfSubstance clone() {
return new TemperatureAmountOfSubstance(this.getUReal(),this.getUnits());
}
}
