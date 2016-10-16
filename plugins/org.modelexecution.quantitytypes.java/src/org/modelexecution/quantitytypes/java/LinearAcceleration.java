package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LinearAcceleration extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public LinearAcceleration(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
this.unit = new Unit (q.unit);
}
public LinearAcceleration () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearAcceleration");
this.unit = new Unit (unit);
}
public LinearAcceleration(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
this.unit = new Unit (unit);
}
public LinearAcceleration(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
this.unit = new Unit (unit);
}
public LinearAcceleration(String x) { //creates a LinearAcceleration from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration(String x, String u) { //creates a LinearAcceleration from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerSecondSquared);
}
public LinearAcceleration(String x, String u, Unit unit) { //creates a LinearAcceleration from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearAcceleration");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LinearAcceleration add(LinearAcceleration r) {  //only works if compatible units && operand has no offset
return new LinearAcceleration(super.add(r));
}
public LinearAcceleration minus(LinearAcceleration r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LinearAcceleration(super.minus(r));
}
public AbsorbedDose mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public Force mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public LinearVelocity mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public InversePermittivity mult(Inductance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public EnergyAndWork mult(LengthMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public HeatFlowRate mult(LinearMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public SpecificHeatCapacity mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public AbsorbedDoseRate mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public EnergyDensity mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public EnergyPerUnitArea mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public Length mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public LinearVelocity divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public SpecificHeatVolume divideBy(AreaTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public Exposure divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricFieldStrength divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public Exposure divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public LinearVelocity divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public MassPerUnitArea divideBy(GravitationalAttraction r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public Activity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public GravitationalAttraction divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new GravitationalAttraction(super.divideBy(r));
}
public AreaTemperature divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public LinearAcceleration abs() { //units are maintained
return new LinearAcceleration(super.abs());
}
public LinearAcceleration neg() { //units are maintained
return new LinearAcceleration(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LinearAcceleration r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LinearAcceleration r) {
return !(this.equals(r));
}
public LinearAcceleration floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LinearAcceleration(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LinearAcceleration round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LinearAcceleration(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LinearAcceleration min(LinearAcceleration r) { // units maintained
if (r.lessThan(this)) return new LinearAcceleration(r.getX(),r.getU(),r.getUnits());
return new LinearAcceleration(this.getX(),this.getU(),this.getUnits());
}
public LinearAcceleration max(LinearAcceleration r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LinearAcceleration(r.getX(),r.getU(),r.getUnits());
return new LinearAcceleration(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LinearAcceleration mult(double r) {
return new LinearAcceleration(this.value.mult(new UReal(r)),this.getUnits());
}
public LinearAcceleration divideBy(double r) {
return new LinearAcceleration(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LinearAcceleration mult(UReal r) {
return new LinearAcceleration(this.value.mult(r),this.getUnits());
}
public LinearAcceleration divideBy(UReal r) {
return new LinearAcceleration(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LinearAcceleration clone() {
return new LinearAcceleration(this.getUReal(),this.getUnits());
}
}
