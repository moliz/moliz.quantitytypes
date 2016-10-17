package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MassTemperature extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MassTemperature(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassTemperature");
this.unit = new Unit (q.unit);
}
public MassTemperature () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassTemperature");
this.unit = new Unit (unit);
}
public MassTemperature(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemperature");
this.unit = new Unit (unit);
}
public MassTemperature(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemperature");
this.unit = new Unit (unit);
}
public MassTemperature(String x) { //creates a MassTemperature from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature(String x, String u) { //creates a MassTemperature from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemperature(String x, String u, Unit unit) { //creates a MassTemperature from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemperature");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MassTemperature add(MassTemperature r) {  //only works if compatible units && operand has no offset
return new MassTemperature(super.add(r));
}
public MassTemperature minus(MassTemperature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MassTemperature(super.minus(r));
}
public TemperatureAmountOfSubstance mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TemperatureAmountOfSubstance(super.mult(r));
}
public AngularMass mult(AreaThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public LengthMass mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public EnergyAndWork mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Volume mult(SpecificHeatPressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public EnergyDensity mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ThermodynamicTemperature divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Mass divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public MassPerUnitArea divideBy(AreaTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public MassPerUnitLength divideBy(LengthTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public AreaTemperature divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public LengthTemperature divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemperature(super.divideBy(r));
}
public UReal divideBy(MassTemperature r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MassTemperature abs() { //units are maintained
return new MassTemperature(super.abs());
}
public MassTemperature neg() { //units are maintained
return new MassTemperature(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MassTemperature r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MassTemperature r) {
return !(this.equals(r));
}
public MassTemperature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MassTemperature(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MassTemperature round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MassTemperature(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MassTemperature min(MassTemperature r) { // units maintained
if (r.lessThan(this)) return new MassTemperature(r.getX(),r.getU(),r.getUnits());
return new MassTemperature(this.getX(),this.getU(),this.getUnits());
}
public MassTemperature max(MassTemperature r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MassTemperature(r.getX(),r.getU(),r.getUnits());
return new MassTemperature(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MassTemperature mult(double r) {
return new MassTemperature(this.value.mult(new UReal(r)),this.getUnits());
}
public MassTemperature divideBy(double r) {
return new MassTemperature(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MassTemperature mult(UReal r) {
return new MassTemperature(this.value.mult(r),this.getUnits());
}
public MassTemperature divideBy(UReal r) {
return new MassTemperature(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MassTemperature clone() {
return new MassTemperature(this.getUReal(),this.getUnits());
}
}
