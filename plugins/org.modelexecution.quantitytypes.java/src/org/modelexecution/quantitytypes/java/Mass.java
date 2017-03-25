package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Mass extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
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

public Mass(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
this.unit = new Unit (q.unit);
}
public Mass () {
value = new UReal();
unit = new Unit(BaseUnits.Kilogram);
}
public Mass(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Kilogram);
}
public Mass(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Mass");
this.unit = new Unit (unit);
}
public Mass(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Kilogram);
}
public Mass (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Kilogram);
}
public Mass(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
this.unit = new Unit (unit);
}
public Mass(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
this.unit = new Unit (unit);
}
public Mass(String x) { //creates a Mass from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Kilogram);
}
public Mass(String x, String u) { //creates a Mass from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Kilogram);
}
public Mass(String x, String u, Unit unit) { //creates a Mass from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Mass");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Mass add(Mass r) {  //only works if compatible units && operand has no offset
return new Mass(super.add(r));
}
public Mass minus(Mass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Mass(super.minus(r));
}
public LengthMass mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public MassTemperature mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public EnergyAndWork mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public HeatFlowRate mult(AbsorbedDoseRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public MassPerUnitTime mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public AmountOfSubstance mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstance(super.mult(r));
}
public AngularMass mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public EnergyAndWork mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public ElectricCharge mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public MassPerUnitTime mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public AngularMomentum mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public Force mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public LinearMomentum mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public EnergyAndWork mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public HeatCapacityAndEntropy mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public VolumeThermalExpansion mult(SpecificHeatPressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.mult(r));
}
public VolumetricHeatCapacity mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public AngularMomentum mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public Force mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public MassPerUnitLength divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public MassPerUnitTime divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public MassPerUnitArea divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public Volume divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public TimeSquared divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public TimeSquared divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Time divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Area divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public Density divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public UReal divideBy(Mass r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Mass abs() { //units are maintained
return new Mass(super.abs());
}
public Mass neg() { //units are maintained
return new Mass(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Mass r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Mass r) {
return !(this.equals(r));
}
public Mass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Mass(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Mass round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Mass(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Mass min(Mass r) { // units maintained
if (r.lessThan(this)) return new Mass(r.getX(),r.getU(),r.getUnits());
return new Mass(this.getX(),this.getU(),this.getUnits());
}
public Mass max(Mass r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Mass(r.getX(),r.getU(),r.getUnits());
return new Mass(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Mass mult(double r) {
return new Mass(this.value.mult(new UReal(r)),this.getUnits());
}
public Mass divideBy(double r) {
return new Mass(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Mass mult(UReal r) {
return new Mass(this.value.mult(r),this.getUnits());
}
public Mass divideBy(UReal r) {
return new Mass(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Mass clone() {
return new Mass(this.getUReal(),this.getUnits());
}
}
