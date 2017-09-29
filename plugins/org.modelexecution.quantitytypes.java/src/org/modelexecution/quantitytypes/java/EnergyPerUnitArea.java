package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class EnergyPerUnitArea extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
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

public EnergyPerUnitArea(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a EnergyPerUnitArea");
this.unit = new Unit (q.unit);
}
public EnergyPerUnitArea () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyPerUnitArea");
this.unit = new Unit (unit);
}
public EnergyPerUnitArea(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyPerUnitArea");
this.unit = new Unit (unit);
}
public EnergyPerUnitArea(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyPerUnitArea");
this.unit = new Unit (unit);
}
public EnergyPerUnitArea(String x) { //creates a EnergyPerUnitArea from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea(String x, String u) { //creates a EnergyPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerSquareMeter);
}
public EnergyPerUnitArea(String x, String u, Unit unit) { //creates a EnergyPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyPerUnitArea");
this.unit = new Unit (unit);
}
// Specific Type Operations
public EnergyPerUnitArea add(EnergyPerUnitArea r) {  //only works if compatible units && operand has no offset
return new EnergyPerUnitArea(super.add(r));
}
public EnergyPerUnitArea minus(EnergyPerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new EnergyPerUnitArea(super.minus(r));
}
public Force mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public MassPerUnitTime mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public EnergyAndWork mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public HeatCapacityAndEntropy mult(AreaThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public HeatFlowRate mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public HeatFlowRate mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public Mass mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public EnergyDensity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public HeatFlowRatePerUnitArea divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public MassPerUnitArea divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public MassPerUnitTime divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public MassPerUnitArea divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public LinearVelocity divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricFluxDensity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public Length divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public MassPerUnitTime divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public Time divideBy(HeatFlowRatePerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(LengthTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public MassPerUnitLength divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public DynamicViscosity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public ElectricCurrentDensity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public ElectricCurrent divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public Activity divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public AbsorbedDose divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public LinearAcceleration divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Time divideBy(PowerPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Length divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public MassPerUnitArea divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public MassPerUnitLength divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public LengthTemperature divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemperature(super.divideBy(r));
}
public UReal divideBy(EnergyPerUnitArea r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public EnergyPerUnitArea abs() { //units are maintained
return new EnergyPerUnitArea(super.abs());
}
public EnergyPerUnitArea neg() { //units are maintained
return new EnergyPerUnitArea(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(EnergyPerUnitArea r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(EnergyPerUnitArea r) {
return !(this.equals(r));
}
public EnergyPerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new EnergyPerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public EnergyPerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
return new EnergyPerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
}
public EnergyPerUnitArea min(EnergyPerUnitArea r) { // units maintained
if (r.lessThan(this)) return new EnergyPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new EnergyPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
public EnergyPerUnitArea max(EnergyPerUnitArea r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new EnergyPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new EnergyPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public EnergyPerUnitArea mult(double r) {
return new EnergyPerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
}
public EnergyPerUnitArea divideBy(double r) {
return new EnergyPerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
}
public EnergyPerUnitArea mult(UReal r) {
return new EnergyPerUnitArea(this.value.mult(r),this.getUnits());
}
public EnergyPerUnitArea divideBy(UReal r) {
return new EnergyPerUnitArea(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public EnergyPerUnitArea clone() {
return new EnergyPerUnitArea(this.getUReal(),this.getUnits());
}
}
