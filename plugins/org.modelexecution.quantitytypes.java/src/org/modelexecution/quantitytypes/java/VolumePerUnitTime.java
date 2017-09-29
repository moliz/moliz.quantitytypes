package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class VolumePerUnitTime extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=3.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
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

public VolumePerUnitTime(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a VolumePerUnitTime");
this.unit = new Unit (q.unit);
}
public VolumePerUnitTime () {
value = new UReal();
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an VolumePerUnitTime");
this.unit = new Unit (unit);
}
public VolumePerUnitTime(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumePerUnitTime");
this.unit = new Unit (unit);
}
public VolumePerUnitTime(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumePerUnitTime");
this.unit = new Unit (unit);
}
public VolumePerUnitTime(String x) { //creates a VolumePerUnitTime from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime(String x, String u) { //creates a VolumePerUnitTime from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeterPerSecond);
}
public VolumePerUnitTime(String x, String u, Unit unit) { //creates a VolumePerUnitTime from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumePerUnitTime");
this.unit = new Unit (unit);
}
// Specific Type Operations
public VolumePerUnitTime add(VolumePerUnitTime r) {  //only works if compatible units && operand has no offset
return new VolumePerUnitTime(super.add(r));
}
public VolumePerUnitTime minus(VolumePerUnitTime r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new VolumePerUnitTime(super.minus(r));
}
public Volume mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public CatalyticActivity mult(AmountOfSubstancePerUnitVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CatalyticActivity(super.mult(r));
}
public MassPerUnitTime mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public EnergyAndWork mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public MagneticDipoleMoment mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public ElectricCurrent mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public HeatFlowRate mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public LinearMomentum mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public AngularMomentum mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public HeatFlowRate mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public KinematicViscosity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public Volume divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public LinearVelocity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Volume divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public Length divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Area divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Activity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public UReal divideBy(VolumePerUnitTime r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public VolumePerUnitTime abs() { //units are maintained
return new VolumePerUnitTime(super.abs());
}
public VolumePerUnitTime neg() { //units are maintained
return new VolumePerUnitTime(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(VolumePerUnitTime r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(VolumePerUnitTime r) {
return !(this.equals(r));
}
public VolumePerUnitTime floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new VolumePerUnitTime(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public VolumePerUnitTime round(){ //returns (i,u) with i the closest int to x -- units maintained
return new VolumePerUnitTime(Math.round(this.getX()),this.getU(),this.getUnits());
}
public VolumePerUnitTime min(VolumePerUnitTime r) { // units maintained
if (r.lessThan(this)) return new VolumePerUnitTime(r.getX(),r.getU(),r.getUnits());
return new VolumePerUnitTime(this.getX(),this.getU(),this.getUnits());
}
public VolumePerUnitTime max(VolumePerUnitTime r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new VolumePerUnitTime(r.getX(),r.getU(),r.getUnits());
return new VolumePerUnitTime(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public VolumePerUnitTime mult(double r) {
return new VolumePerUnitTime(this.value.mult(new UReal(r)),this.getUnits());
}
public VolumePerUnitTime divideBy(double r) {
return new VolumePerUnitTime(this.value.divideBy(new UReal(r)),this.getUnits());
}
public VolumePerUnitTime mult(UReal r) {
return new VolumePerUnitTime(this.value.mult(r),this.getUnits());
}
public VolumePerUnitTime divideBy(UReal r) {
return new VolumePerUnitTime(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public VolumePerUnitTime clone() {
return new VolumePerUnitTime(this.getUReal(),this.getUnits());
}
}
