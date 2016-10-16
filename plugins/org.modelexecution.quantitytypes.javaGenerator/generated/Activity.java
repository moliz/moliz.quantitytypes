package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Activity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-1.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Activity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Activity");
this.unit = new Unit (q.unit);
}
public Activity () {
value = new UReal();
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Activity");
this.unit = new Unit (unit);
}
public Activity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Activity");
this.unit = new Unit (unit);
}
public Activity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Activity");
this.unit = new Unit (unit);
}
public Activity(String x) { //creates a Activity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity(String x, String u) { //creates a Activity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Becquerel);
}
public Activity(String x, String u, Unit unit) { //creates a Activity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Activity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Activity add(Activity r) {  //only works if compatible units && operand has no offset
return new Activity(super.add(r));
}
public Activity minus(Activity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Activity(super.minus(r));
}
public LinearVelocity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public MassPerUnitTime mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public CatalyticActivity mult(AmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CatalyticActivity(super.mult(r));
}
public AngularVelocity mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularVelocity(super.mult(r));
}
public AbsorbedDoseRate mult(AbsorbedDose r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public AngularMomentum mult(AngularMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public EnergyAndWork mult(AngularMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AngularAcceleration mult(AngularVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularAcceleration(super.mult(r));
}
public KinematicViscosity mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public ElectricalConductivity mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricalConductivity(super.mult(r));
}
public AbsorbedDoseRate mult(DoseEquivalent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public EnergyDensity mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ElectricCurrent mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MagneticFieldStrength mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricCurrentDensity mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.mult(r));
}
public HeatFlowRate mult(EnergyAndWork r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public Resistance mult(Inductance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Resistance(super.mult(r));
}
public AbsorbedDose mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public LinearMomentum mult(LengthMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public Force mult(LinearMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public LinearAcceleration mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public ElectromotiveForce mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public EnergyPerUnitArea mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public DynamicViscosity mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public AbsorbedDoseRate mult(SpecificEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public AbsorbedDose mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public Time mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public HeatFlowRate mult(BendingMomentOrTorque r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public VolumePerUnitTime mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public InverseAmountOfSubstance divideBy(CatalyticActivity r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public MagneticFluxDensity divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public CatalyticActivity divideBy(InverseAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new CatalyticActivity(super.divideBy(r));
}
public Exposure divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public Time inverse() {
return new  Time(super.inverse());
}
public Activity abs() { //units are maintained
return new Activity(super.abs());
}
public Activity neg() { //units are maintained
return new Activity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Activity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Activity r) {
return !(this.equals(r));
}
public Activity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Activity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Activity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Activity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Activity min(Activity r) { // units maintained
if (r.lessThan(this)) return new Activity(r.getX(),r.getU(),r.getUnits());
return new Activity(this.getX(),this.getU(),this.getUnits());
}
public Activity max(Activity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Activity(r.getX(),r.getU(),r.getUnits());
return new Activity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Activity mult(double r) {
return new Activity(this.value.mult(new UReal(r)),this.getUnits());
}
public Activity divideBy(double r) {
return new Activity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Activity mult(UReal r) {
return new Activity(this.value.mult(r),this.getUnits());
}
public Activity divideBy(UReal r) {
return new Activity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Activity clone() {
return new Activity(this.getUReal(),this.getUnits());
}
}
