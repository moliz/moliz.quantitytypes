package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LinearVelocity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
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

public LinearVelocity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
this.unit = new Unit (q.unit);
}
public LinearVelocity () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LinearVelocity");
this.unit = new Unit (unit);
}
public LinearVelocity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
this.unit = new Unit (unit);
}
public LinearVelocity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
this.unit = new Unit (unit);
}
public LinearVelocity(String x) { //creates a LinearVelocity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity(String x, String u) { //creates a LinearVelocity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerSecond);
}
public LinearVelocity(String x, String u, Unit unit) { //creates a LinearVelocity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LinearVelocity add(LinearVelocity r) {  //only works if compatible units && operand has no offset
return new LinearVelocity(super.add(r));
}
public LinearVelocity minus(LinearVelocity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LinearVelocity(super.minus(r));
}
public KinematicViscosity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public LinearMomentum mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public Length mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public LinearAcceleration mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public VolumePerUnitTime mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public EnergyPerUnitArea mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ElectricCurrent mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricCurrentDensity mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.mult(r));
}
public MagneticDipoleMoment mult(ElectricDipoleMoment r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public MagneticFieldStrength mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public HeatFlowRate mult(Force r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public LinearAcceleration mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public AngularMomentum mult(LengthMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public AbsorbedDoseRate mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public EnergyAndWork mult(LinearMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AbsorbedDose mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public ElectricFieldStrength mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public Force mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public DynamicViscosity mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public MassPerUnitTime mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public Resistance mult(Permeability r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Resistance(super.mult(r));
}
public ElectricalConductivity mult(Permittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricalConductivity(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public InversePermittivity mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public AbsorbedDoseRate mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public CoefficientOfHeatTransfer mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.mult(r));
}
public Activity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public LinearAcceleration divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Length divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public InversePermittivity divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new InversePermittivity(super.divideBy(r));
}
public Length divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ElectricalConductivity divideBy(InversePermittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public Time divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Time divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public UReal divideBy(LinearVelocity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public LinearVelocity abs() { //units are maintained
return new LinearVelocity(super.abs());
}
public LinearVelocity neg() { //units are maintained
return new LinearVelocity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LinearVelocity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LinearVelocity r) {
return !(this.equals(r));
}
public LinearVelocity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LinearVelocity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LinearVelocity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LinearVelocity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LinearVelocity min(LinearVelocity r) { // units maintained
if (r.lessThan(this)) return new LinearVelocity(r.getX(),r.getU(),r.getUnits());
return new LinearVelocity(this.getX(),this.getU(),this.getUnits());
}
public LinearVelocity max(LinearVelocity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LinearVelocity(r.getX(),r.getU(),r.getUnits());
return new LinearVelocity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LinearVelocity mult(double r) {
return new LinearVelocity(this.value.mult(new UReal(r)),this.getUnits());
}
public LinearVelocity divideBy(double r) {
return new LinearVelocity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LinearVelocity mult(UReal r) {
return new LinearVelocity(this.value.mult(r),this.getUnits());
}
public LinearVelocity divideBy(UReal r) {
return new LinearVelocity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LinearVelocity clone() {
return new LinearVelocity(this.getUReal(),this.getUnits());
}
}
