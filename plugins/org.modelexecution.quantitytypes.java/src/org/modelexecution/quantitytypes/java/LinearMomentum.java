package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LinearMomentum extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-1.0;
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

public LinearMomentum(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
this.unit = new Unit (q.unit);
}
public LinearMomentum () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearMomentum");
this.unit = new Unit (unit);
}
public LinearMomentum(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
this.unit = new Unit (unit);
}
public LinearMomentum(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
this.unit = new Unit (unit);
}
public LinearMomentum(String x) { //creates a LinearMomentum from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum(String x, String u) { //creates a LinearMomentum from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramMeterPerSecond);
}
public LinearMomentum(String x, String u, Unit unit) { //creates a LinearMomentum from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearMomentum");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LinearMomentum add(LinearMomentum r) {  //only works if compatible units && operand has no offset
return new LinearMomentum(super.add(r));
}
public LinearMomentum minus(LinearMomentum r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LinearMomentum(super.minus(r));
}
public AngularMomentum mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public LengthMass mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public Force mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public Force mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public HeatFlowRate mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public EnergyAndWork mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public CoefficientOfHeatTransfer mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.mult(r));
}
public HeatFlowRate mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public MassPerUnitTime divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public LinearVelocity divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Force divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new Force(super.divideBy(r));
}
public LengthMass divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public DynamicViscosity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public Area divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ElectricDipoleMoment r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public Time divideBy(Force r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public LengthMass divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public MassPerUnitLength divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public Activity divideBy(LengthMass r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Mass divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public ElectricDipoleMoment divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.divideBy(r));
}
public Length divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public VolumePerUnitTime divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public KinematicViscosity divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public MassPerUnitLength divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public MassPerUnitArea divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public UReal divideBy(LinearMomentum r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public LinearMomentum abs() { //units are maintained
return new LinearMomentum(super.abs());
}
public LinearMomentum neg() { //units are maintained
return new LinearMomentum(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LinearMomentum r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LinearMomentum r) {
return !(this.equals(r));
}
public LinearMomentum floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LinearMomentum(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LinearMomentum round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LinearMomentum(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LinearMomentum min(LinearMomentum r) { // units maintained
if (r.lessThan(this)) return new LinearMomentum(r.getX(),r.getU(),r.getUnits());
return new LinearMomentum(this.getX(),this.getU(),this.getUnits());
}
public LinearMomentum max(LinearMomentum r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LinearMomentum(r.getX(),r.getU(),r.getUnits());
return new LinearMomentum(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LinearMomentum mult(double r) {
return new LinearMomentum(this.value.mult(new UReal(r)),this.getUnits());
}
public LinearMomentum divideBy(double r) {
return new LinearMomentum(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LinearMomentum mult(UReal r) {
return new LinearMomentum(this.value.mult(r),this.getUnits());
}
public LinearMomentum divideBy(UReal r) {
return new LinearMomentum(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LinearMomentum clone() {
return new LinearMomentum(this.getUReal(),this.getUnits());
}
}
