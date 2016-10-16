package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LengthMass extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public LengthMass(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LengthMass");
this.unit = new Unit (q.unit);
}
public LengthMass () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LengthMass");
this.unit = new Unit (unit);
}
public LengthMass(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthMass");
this.unit = new Unit (unit);
}
public LengthMass(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthMass");
this.unit = new Unit (unit);
}
public LengthMass(String x) { //creates a LengthMass from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass(String x, String u) { //creates a LengthMass from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKilogram);
}
public LengthMass(String x, String u, Unit unit) { //creates a LengthMass from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthMass");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LengthMass add(LengthMass r) {  //only works if compatible units && operand has no offset
return new LengthMass(super.add(r));
}
public LengthMass minus(LengthMass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LengthMass(super.minus(r));
}
public AngularMass mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public LinearMomentum mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public ElectricDipoleMoment mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public LinearMomentum mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public EnergyAndWork mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AngularMomentum mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public EnergyAndWork mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Mass divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public Length divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LinearMomentum divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public MassPerUnitLength divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public TimeSquared divideBy(Force r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Time divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public MassTemPerature divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemPerature(super.divideBy(r));
}
public LinearThermalExpansion divideBy(MassTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public Volume divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public Area divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Force divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new Force(super.divideBy(r));
}
public MassPerUnitArea divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public LengthMass abs() { //units are maintained
return new LengthMass(super.abs());
}
public LengthMass neg() { //units are maintained
return new LengthMass(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LengthMass r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LengthMass r) {
return !(this.equals(r));
}
public LengthMass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LengthMass(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LengthMass round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LengthMass(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LengthMass min(LengthMass r) { // units maintained
if (r.lessThan(this)) return new LengthMass(r.getX(),r.getU(),r.getUnits());
return new LengthMass(this.getX(),this.getU(),this.getUnits());
}
public LengthMass max(LengthMass r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LengthMass(r.getX(),r.getU(),r.getUnits());
return new LengthMass(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LengthMass mult(double r) {
return new LengthMass(this.value.mult(new UReal(r)),this.getUnits());
}
public LengthMass divideBy(double r) {
return new LengthMass(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LengthMass mult(UReal r) {
return new LengthMass(this.value.mult(r),this.getUnits());
}
public LengthMass divideBy(UReal r) {
return new LengthMass(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LengthMass clone() {
return new LengthMass(this.getUReal(),this.getUnits());
}
}
