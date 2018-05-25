package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AngularMass extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
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

public AngularMass(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AngularMass");
this.unit = new Unit (q.unit);
}
public AngularMass () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMass");
this.unit = new Unit (unit);
}
public AngularMass(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMass");
this.unit = new Unit (unit);
}
public AngularMass(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMass");
this.unit = new Unit (unit);
}
public AngularMass(String x) { //creates a AngularMass from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass(String x, String u) { //creates a AngularMass from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramMeterSquared);
}
public AngularMass(String x, String u, Unit unit) { //creates a AngularMass from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMass");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AngularMass add(AngularMass r) {  //only works if compatible units && operand has no offset
return new AngularMass(super.add(r));
}
public AngularMass minus(AngularMass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AngularMass(super.minus(r));
}
public AngularMomentum mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public AngularMomentum mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public LengthMass divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public Area divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public AngularMomentum divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMomentum(super.divideBy(r));
}
public Time divideBy(AngularMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Mass divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public MassTemperature divideBy(AreaThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemperature(super.divideBy(r));
}
public TimeSquared divideBy(EnergyAndWork r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Length divideBy(LengthMass r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public AreaThermalExpansion divideBy(MassTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaThermalExpansion(super.divideBy(r));
}
public Volume divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public EnergyAndWork divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyAndWork(super.divideBy(r));
}
public TimeSquared divideBy(BendingMomentOrTorque r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public MassPerUnitLength divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public UReal divideBy(AngularMass r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AngularMass abs() { //units are maintained
return new AngularMass(super.abs());
}
public AngularMass neg() { //units are maintained
return new AngularMass(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AngularMass r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AngularMass r) {
return !(this.equals(r));
}
public AngularMass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AngularMass(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AngularMass round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AngularMass(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AngularMass min(AngularMass r) { // units maintained
if (r.lt(this)) return new AngularMass(r.getX(),r.getU(),r.getUnits());
return new AngularMass(this.getX(),this.getU(),this.getUnits());
}
public AngularMass max(AngularMass r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AngularMass(r.getX(),r.getU(),r.getUnits());
return new AngularMass(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AngularMass mult(double r) {
return new AngularMass(this.value.mult(new UReal(r)),this.getUnits());
}
public AngularMass divideBy(double r) {
return new AngularMass(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AngularMass mult(UReal r) {
return new AngularMass(this.value.mult(r),this.getUnits());
}
public AngularMass divideBy(UReal r) {
return new AngularMass(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AngularMass clone() {
return new AngularMass(this.getUReal(),this.getUnits());
}
}
