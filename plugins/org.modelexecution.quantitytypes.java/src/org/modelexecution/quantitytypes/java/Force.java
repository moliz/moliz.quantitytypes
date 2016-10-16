package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Force extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Force(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Force");
this.unit = new Unit (q.unit);
}
public Force () {
value = new UReal();
unit = new Unit(DerivedUnits.Newton);
}
public Force(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Newton);
}
public Force(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Force");
this.unit = new Unit (unit);
}
public Force(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Newton);
}
public Force (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Newton);
}
public Force(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Force");
this.unit = new Unit (unit);
}
public Force(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Force");
this.unit = new Unit (unit);
}
public Force(String x) { //creates a Force from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Newton);
}
public Force(String x, String u) { //creates a Force from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Newton);
}
public Force(String x, String u, Unit unit) { //creates a Force from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Force");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Force add(Force r) {  //only works if compatible units && operand has no offset
return new Force(super.add(r));
}
public Force minus(Force r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Force(super.minus(r));
}
public EnergyAndWork mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public LinearMomentum mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public HeatCapacityAndEntropy mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public HeatFlowrate mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowrate(super.mult(r));
}
public LengthMass mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public EnergyPerUnitArea divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public LinearAcceleration divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public MassPerUnitLength divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public LinearMomentum divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public EnergyDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(AreaTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public MassPerUnitLength divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public KinematicViscosity divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricCharge divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public Area divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ElectricCharge divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public Length divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LinearMomentum divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public DynamicViscosity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public Mass divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public Activity divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public MassPerUnitTime divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public MagneticFlux divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public MagneticFieldStrength divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public LinearVelocity divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public AbsorbedDose divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public Area divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public MassPerUnitLength divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public DynamicViscosity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public Mass divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public AreaTemperature divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public Force abs() { //units are maintained
return new Force(super.abs());
}
public Force neg() { //units are maintained
return new Force(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Force r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Force r) {
return !(this.equals(r));
}
public Force floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Force(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Force round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Force(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Force min(Force r) { // units maintained
if (r.lessThan(this)) return new Force(r.getX(),r.getU(),r.getUnits());
return new Force(this.getX(),this.getU(),this.getUnits());
}
public Force max(Force r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Force(r.getX(),r.getU(),r.getUnits());
return new Force(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Force mult(double r) {
return new Force(this.value.mult(new UReal(r)),this.getUnits());
}
public Force divideBy(double r) {
return new Force(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Force mult(UReal r) {
return new Force(this.value.mult(r),this.getUnits());
}
public Force divideBy(UReal r) {
return new Force(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Force clone() {
return new Force(this.getUReal(),this.getUnits());
}
}
