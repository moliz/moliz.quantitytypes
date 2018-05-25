package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Pressure extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
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

public Pressure(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Pressure");
this.unit = new Unit (q.unit);
}
public Pressure () {
value = new UReal();
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Pressure");
this.unit = new Unit (unit);
}
public Pressure(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Pressure");
this.unit = new Unit (unit);
}
public Pressure(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Pressure");
this.unit = new Unit (unit);
}
public Pressure(String x) { //creates a Pressure from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure(String x, String u) { //creates a Pressure from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Pascal);
}
public Pressure(String x, String u, Unit unit) { //creates a Pressure from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Pressure");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Pressure add(Pressure r) {  //only works if compatible units && operand has no offset
return new Pressure(super.add(r));
}
public Pressure minus(Pressure r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Pressure(super.minus(r));
}
public EnergyPerUnitArea mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public DynamicViscosity mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public Force mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public SpecificHeatCapacity mult(SpecificHeatPressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public MassPerUnitLength mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public EnergyAndWork mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public HeatCapacityAndEntropy mult(VolumeThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public HeatFlowRate mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public VolumetricHeatCapacity divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public Density divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public DynamicViscosity divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public MolarEnergy divideBy(AmountOfSubstancePerUnitVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarEnergy(super.divideBy(r));
}
public AbsorbedDose divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public Density divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public Activity divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricFluxDensity divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public ElectricFluxDensity divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public DynamicViscosity divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public MassPerUnitArea divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public MagneticFluxDensity divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public MagneticFieldStrength divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public SpecificHeatVolume divideBy(MassTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public LinearAcceleration divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public AmountOfSubstancePerUnitVolume divideBy(MolarEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.divideBy(r));
}
public Density divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public MassTemperature divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemperature(super.divideBy(r));
}
public MassPerUnitArea divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public UReal divideBy(Pressure r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Pressure abs() { //units are maintained
return new Pressure(super.abs());
}
public Pressure neg() { //units are maintained
return new Pressure(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Pressure r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Pressure r) {
return !(this.equals(r));
}
public Pressure floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Pressure(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Pressure round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Pressure(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Pressure min(Pressure r) { // units maintained
if (r.lt(this)) return new Pressure(r.getX(),r.getU(),r.getUnits());
return new Pressure(this.getX(),this.getU(),this.getUnits());
}
public Pressure max(Pressure r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Pressure(r.getX(),r.getU(),r.getUnits());
return new Pressure(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Pressure mult(double r) {
return new Pressure(this.value.mult(new UReal(r)),this.getUnits());
}
public Pressure divideBy(double r) {
return new Pressure(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Pressure mult(UReal r) {
return new Pressure(this.value.mult(r),this.getUnits());
}
public Pressure divideBy(UReal r) {
return new Pressure(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Pressure clone() {
return new Pressure(this.getUReal(),this.getUnits());
}
}
