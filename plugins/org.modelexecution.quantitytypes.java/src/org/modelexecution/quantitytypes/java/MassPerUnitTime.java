package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MassPerUnitTime extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-1.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MassPerUnitTime(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
this.unit = new Unit (q.unit);
}
public MassPerUnitTime () {
value = new UReal();
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MassPerUnitTime");
this.unit = new Unit (unit);
}
public MassPerUnitTime(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
this.unit = new Unit (unit);
}
public MassPerUnitTime(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
this.unit = new Unit (unit);
}
public MassPerUnitTime(String x) { //creates a MassPerUnitTime from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime(String x, String u) { //creates a MassPerUnitTime from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.KilogramPerSecond);
}
public MassPerUnitTime(String x, String u, Unit unit) { //creates a MassPerUnitTime from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MassPerUnitTime");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MassPerUnitTime add(MassPerUnitTime r) {  //only works if compatible units && operand has no offset
return new MassPerUnitTime(super.add(r));
}
public MassPerUnitTime minus(MassPerUnitTime r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MassPerUnitTime(super.minus(r));
}
public LinearMomentum mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public Mass mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public HeatFlowRate mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public EnergyPerUnitArea mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public CatalyticActivity mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CatalyticActivity(super.mult(r));
}
public AngularMomentum mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public HeatFlowRate mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public ElectricCurrent mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public EnergyPerUnitArea mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public EnergyAndWork mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Force mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public HeatFlowRate mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public EnergyAndWork mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public DynamicViscosity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public Activity divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public Mass divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public VolumePerUnitTime divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public Length divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public Time divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Time divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Mass divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public TimeSquared divideBy(HeatFlowRatePerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public MassPerUnitArea divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public MassPerUnitLength divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public ElectricFluxDensity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectricCharge divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public KinematicViscosity divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public LinearVelocity divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public TimeSquared divideBy(PowerPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public MassPerUnitArea divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public HeatFlowRatePerUnitArea divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.divideBy(r));
}
public Density divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public UReal divideBy(MassPerUnitTime r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MassPerUnitTime abs() { //units are maintained
return new MassPerUnitTime(super.abs());
}
public MassPerUnitTime neg() { //units are maintained
return new MassPerUnitTime(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MassPerUnitTime r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MassPerUnitTime r) {
return !(this.equals(r));
}
public MassPerUnitTime floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MassPerUnitTime(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitTime round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MassPerUnitTime(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MassPerUnitTime min(MassPerUnitTime r) { // units maintained
if (r.lessThan(this)) return new MassPerUnitTime(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitTime(this.getX(),this.getU(),this.getUnits());
}
public MassPerUnitTime max(MassPerUnitTime r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MassPerUnitTime(r.getX(),r.getU(),r.getUnits());
return new MassPerUnitTime(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MassPerUnitTime mult(double r) {
return new MassPerUnitTime(this.value.mult(new UReal(r)),this.getUnits());
}
public MassPerUnitTime divideBy(double r) {
return new MassPerUnitTime(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MassPerUnitTime mult(UReal r) {
return new MassPerUnitTime(this.value.mult(r),this.getUnits());
}
public MassPerUnitTime divideBy(UReal r) {
return new MassPerUnitTime(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MassPerUnitTime clone() {
return new MassPerUnitTime(this.getUReal(),this.getUnits());
}
}
