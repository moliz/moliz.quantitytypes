package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AngularMomentum extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-1.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AngularMomentum(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AngularMomentum");
this.unit = new Unit (q.unit);
}
public AngularMomentum () {
value = new UReal();
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AngularMomentum");
this.unit = new Unit (unit);
}
public AngularMomentum(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMomentum");
this.unit = new Unit (unit);
}
public AngularMomentum(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMomentum");
this.unit = new Unit (unit);
}
public AngularMomentum(String x) { //creates a AngularMomentum from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum(String x, String u) { //creates a AngularMomentum from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JouleSecond);
}
public AngularMomentum(String x, String u, Unit unit) { //creates a AngularMomentum from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AngularMomentum");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AngularMomentum add(AngularMomentum r) {  //only works if compatible units && operand has no offset
return new AngularMomentum(super.add(r));
}
public AngularMomentum minus(AngularMomentum r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AngularMomentum(super.minus(r));
}
public AngularMass mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public EnergyAndWork mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public MagneticDipoleMoment mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public EnergyAndWork mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public ThermalConductivity mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public LinearMomentum divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public KinematicViscosity divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public EnergyAndWork divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyAndWork(super.divideBy(r));
}
public AngularMass divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMass(super.divideBy(r));
}
public Activity divideBy(AngularMass r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public MassPerUnitTime divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public Volume divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public Time divideBy(EnergyAndWork r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public AngularMass divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMass(super.divideBy(r));
}
public TimeSquared divideBy(HeatFlowRate r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Mass divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public LinearVelocity divideBy(LengthMass r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Length divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LengthMass divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public ElectricCharge divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public Area divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public VolumePerUnitTime divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public TimeSquared divideBy(Power r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Mass divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public HeatFlowRate divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRate(super.divideBy(r));
}
public Time divideBy(BendingMomentOrTorque r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public DynamicViscosity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public MassPerUnitLength divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public UReal divideBy(AngularMomentum r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AngularMomentum abs() { //units are maintained
return new AngularMomentum(super.abs());
}
public AngularMomentum neg() { //units are maintained
return new AngularMomentum(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AngularMomentum r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AngularMomentum r) {
return !(this.equals(r));
}
public AngularMomentum floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AngularMomentum(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AngularMomentum round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AngularMomentum(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AngularMomentum min(AngularMomentum r) { // units maintained
if (r.lessThan(this)) return new AngularMomentum(r.getX(),r.getU(),r.getUnits());
return new AngularMomentum(this.getX(),this.getU(),this.getUnits());
}
public AngularMomentum max(AngularMomentum r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AngularMomentum(r.getX(),r.getU(),r.getUnits());
return new AngularMomentum(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AngularMomentum mult(double r) {
return new AngularMomentum(this.value.mult(new UReal(r)),this.getUnits());
}
public AngularMomentum divideBy(double r) {
return new AngularMomentum(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AngularMomentum mult(UReal r) {
return new AngularMomentum(this.value.mult(r),this.getUnits());
}
public AngularMomentum divideBy(UReal r) {
return new AngularMomentum(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AngularMomentum clone() {
return new AngularMomentum(this.getUReal(),this.getUnits());
}
}
