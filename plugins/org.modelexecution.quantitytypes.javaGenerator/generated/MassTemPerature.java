package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MassTemPerature extends Quantity {
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

public MassTemPerature(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassTemPerature");
this.unit = new Unit (q.unit);
}
public MassTemPerature () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassTemPerature");
this.unit = new Unit (unit);
}
public MassTemPerature(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemPerature");
this.unit = new Unit (unit);
}
public MassTemPerature(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemPerature");
this.unit = new Unit (unit);
}
public MassTemPerature(String x) { //creates a MassTemPerature from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature(String x, String u) { //creates a MassTemPerature from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramKelvin);
}
public MassTemPerature(String x, String u, Unit unit) { //creates a MassTemPerature from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassTemPerature");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MassTemPerature add(MassTemPerature r) {  //only works if compatible units && operand has no offset
return new MassTemPerature(super.add(r));
}
public MassTemPerature minus(MassTemPerature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MassTemPerature(super.minus(r));
}
public TemPeratureAmountOfSubstance mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TemPeratureAmountOfSubstance(super.mult(r));
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
public MassPerUnitLength divideBy(LengthTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public AreaTemperature divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public LengthTemPerature divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemPerature(super.divideBy(r));
}
public MassTemPerature abs() { //units are maintained
return new MassTemPerature(super.abs());
}
public MassTemPerature neg() { //units are maintained
return new MassTemPerature(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MassTemPerature r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MassTemPerature r) {
return !(this.equals(r));
}
public MassTemPerature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MassTemPerature(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MassTemPerature round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MassTemPerature(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MassTemPerature min(MassTemPerature r) { // units maintained
if (r.lessThan(this)) return new MassTemPerature(r.getX(),r.getU(),r.getUnits());
return new MassTemPerature(this.getX(),this.getU(),this.getUnits());
}
public MassTemPerature max(MassTemPerature r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MassTemPerature(r.getX(),r.getU(),r.getUnits());
return new MassTemPerature(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MassTemPerature mult(double r) {
return new MassTemPerature(this.value.mult(new UReal(r)),this.getUnits());
}
public MassTemPerature divideBy(double r) {
return new MassTemPerature(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MassTemPerature mult(UReal r) {
return new MassTemPerature(this.value.mult(r),this.getUnits());
}
public MassTemPerature divideBy(UReal r) {
return new MassTemPerature(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MassTemPerature clone() {
return new MassTemPerature(this.getUReal(),this.getUnits());
}
}
