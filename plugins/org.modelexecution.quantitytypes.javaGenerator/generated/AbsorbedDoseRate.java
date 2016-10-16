package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AbsorbedDoseRate extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AbsorbedDoseRate(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDoseRate");
this.unit = new Unit (q.unit);
}
public AbsorbedDoseRate () {
value = new UReal();
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AbsorbedDoseRate");
this.unit = new Unit (unit);
}
public AbsorbedDoseRate(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDoseRate");
this.unit = new Unit (unit);
}
public AbsorbedDoseRate(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDoseRate");
this.unit = new Unit (unit);
}
public AbsorbedDoseRate(String x) { //creates a AbsorbedDoseRate from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate(String x, String u) { //creates a AbsorbedDoseRate from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.GrayPerSecond);
}
public AbsorbedDoseRate(String x, String u, Unit unit) { //creates a AbsorbedDoseRate from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AbsorbedDoseRate");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AbsorbedDoseRate add(AbsorbedDoseRate r) {  //only works if compatible units && operand has no offset
return new AbsorbedDoseRate(super.add(r));
}
public AbsorbedDoseRate minus(AbsorbedDoseRate r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AbsorbedDoseRate(super.minus(r));
}
public HeatFlowRate mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public AbsorbedDose mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public KinematicViscosity mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public Activity divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public AbsorbedDose divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public Activity divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public GravitationalAttraction divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new GravitationalAttraction(super.divideBy(r));
}
public AbsorbedDose divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public DynamicViscosity divideBy(GravitationalAttraction r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public LinearVelocity divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public LinearAcceleration divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Activity divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public LinearVelocity divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public AbsorbedDoseRate abs() { //units are maintained
return new AbsorbedDoseRate(super.abs());
}
public AbsorbedDoseRate neg() { //units are maintained
return new AbsorbedDoseRate(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AbsorbedDoseRate r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AbsorbedDoseRate r) {
return !(this.equals(r));
}
public AbsorbedDoseRate floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AbsorbedDoseRate(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AbsorbedDoseRate round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AbsorbedDoseRate(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AbsorbedDoseRate min(AbsorbedDoseRate r) { // units maintained
if (r.lessThan(this)) return new AbsorbedDoseRate(r.getX(),r.getU(),r.getUnits());
return new AbsorbedDoseRate(this.getX(),this.getU(),this.getUnits());
}
public AbsorbedDoseRate max(AbsorbedDoseRate r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AbsorbedDoseRate(r.getX(),r.getU(),r.getUnits());
return new AbsorbedDoseRate(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AbsorbedDoseRate mult(double r) {
return new AbsorbedDoseRate(this.value.mult(new UReal(r)),this.getUnits());
}
public AbsorbedDoseRate divideBy(double r) {
return new AbsorbedDoseRate(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AbsorbedDoseRate mult(UReal r) {
return new AbsorbedDoseRate(this.value.mult(r),this.getUnits());
}
public AbsorbedDoseRate divideBy(UReal r) {
return new AbsorbedDoseRate(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AbsorbedDoseRate clone() {
return new AbsorbedDoseRate(this.getUReal(),this.getUnits());
}
}
