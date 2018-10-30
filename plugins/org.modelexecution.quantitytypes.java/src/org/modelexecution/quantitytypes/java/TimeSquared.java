package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class TimeSquared extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=2.0;
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

public TimeSquared(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
this.unit = new Unit (q.unit);
}
public TimeSquared () {
value = new UReal();
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an TimeSquared");
this.unit = new Unit (unit);
}
public TimeSquared(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
this.unit = new Unit (unit);
}
public TimeSquared(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
this.unit = new Unit (unit);
}
public TimeSquared(String x) { //creates a TimeSquared from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared(String x, String u) { //creates a TimeSquared from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SecondTimeSquared);
}
public TimeSquared(String x, String u, Unit unit) { //creates a TimeSquared from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TimeSquared");
this.unit = new Unit (unit);
}
// Specific Type Operations
public TimeSquared add(TimeSquared r) {  //only works if compatible units && operand has no offset
return new TimeSquared(super.add(r));
}
public TimeSquared minus(TimeSquared r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new TimeSquared(super.minus(r));
}
public Area mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public KinematicViscosity mult(AbsorbedDoseRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public Time mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public Angle mult(AngularAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Angle(super.mult(r));
}
public Area mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public MassPerUnitLength mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public AngularMass mult(EnergyAndWork r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public Mass mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public LengthMass mult(Force r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public Mass mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public Time mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public AngularMomentum mult(HeatFlowRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public MassPerUnitTime mult(HeatFlowRatePerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public Length mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public AngularMomentum mult(Power r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public MassPerUnitTime mult(PowerPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public MassPerUnitLength mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public Area mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public AreaThermalExpansion mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaThermalExpansion(super.mult(r));
}
public Length mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public AngularMass mult(BendingMomentOrTorque r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public Time divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Inductance divideBy(Capacitance r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public Capacitance divideBy(Inductance r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public UReal divideBy(TimeSquared r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Time sqrt() {
return new  Time(super.sqrt());
}
public TimeSquared abs() { //units are maintained
return new TimeSquared(super.abs());
}
public TimeSquared neg() { //units are maintained
return new TimeSquared(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(TimeSquared r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(TimeSquared r) {
return !(this.equals(r));
}
public TimeSquared floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new TimeSquared(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public TimeSquared round(){ //returns (i,u) with i the closest int to x -- units maintained
return new TimeSquared(Math.round(this.getX()),this.getU(),this.getUnits());
}
public TimeSquared min(TimeSquared r) { // units maintained
if (r.lt(this)) return new TimeSquared(r.getX(),r.getU(),r.getUnits());
return new TimeSquared(this.getX(),this.getU(),this.getUnits());
}
public TimeSquared max(TimeSquared r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new TimeSquared(r.getX(),r.getU(),r.getUnits());
return new TimeSquared(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public TimeSquared mult(double r) {
return new TimeSquared(this.value.mult(new UReal(r)),this.getUnits());
}
public TimeSquared divideBy(double r) {
return new TimeSquared(this.value.divideBy(new UReal(r)),this.getUnits());
}
public TimeSquared mult(UReal r) {
return new TimeSquared(this.value.mult(r),this.getUnits());
}
public TimeSquared divideBy(UReal r) {
return new TimeSquared(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public TimeSquared clone() {
return new TimeSquared(this.getUReal(),this.getUnits());
}
}
