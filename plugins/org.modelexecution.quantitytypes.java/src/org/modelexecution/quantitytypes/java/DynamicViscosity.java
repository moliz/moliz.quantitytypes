package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class DynamicViscosity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
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

public DynamicViscosity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a DynamicViscosity");
this.unit = new Unit (q.unit);
}
public DynamicViscosity () {
value = new UReal();
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an DynamicViscosity");
this.unit = new Unit (unit);
}
public DynamicViscosity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a DynamicViscosity");
this.unit = new Unit (unit);
}
public DynamicViscosity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a DynamicViscosity");
this.unit = new Unit (unit);
}
public DynamicViscosity(String x) { //creates a DynamicViscosity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity(String x, String u) { //creates a DynamicViscosity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.PascalSecond);
}
public DynamicViscosity(String x, String u, Unit unit) { //creates a DynamicViscosity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a DynamicViscosity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public DynamicViscosity add(DynamicViscosity r) {  //only works if compatible units && operand has no offset
return new DynamicViscosity(super.add(r));
}
public DynamicViscosity minus(DynamicViscosity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new DynamicViscosity(super.minus(r));
}
public MassPerUnitTime mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public MassPerUnitLength mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public EnergyDensity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public LinearMomentum mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public MagneticFieldStrength mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public EnergyDensity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public AbsorbedDoseRate mult(GravitationalAttraction r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public Force mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public EnergyPerUnitArea mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ThermalConductivity mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public Force mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public AngularMomentum mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public EnergyAndWork mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyDensity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public MassPerUnitLength divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public KinematicViscosity divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public Time divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public MassPerUnitLength divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public Density divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public MassPerUnitArea divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public LinearVelocity divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Activity divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Time divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Density divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public UReal divideBy(DynamicViscosity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public DynamicViscosity abs() { //units are maintained
return new DynamicViscosity(super.abs());
}
public DynamicViscosity neg() { //units are maintained
return new DynamicViscosity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(DynamicViscosity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(DynamicViscosity r) {
return !(this.equals(r));
}
public DynamicViscosity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new DynamicViscosity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public DynamicViscosity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new DynamicViscosity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public DynamicViscosity min(DynamicViscosity r) { // units maintained
if (r.lessThan(this)) return new DynamicViscosity(r.getX(),r.getU(),r.getUnits());
return new DynamicViscosity(this.getX(),this.getU(),this.getUnits());
}
public DynamicViscosity max(DynamicViscosity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new DynamicViscosity(r.getX(),r.getU(),r.getUnits());
return new DynamicViscosity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public DynamicViscosity mult(double r) {
return new DynamicViscosity(this.value.mult(new UReal(r)),this.getUnits());
}
public DynamicViscosity divideBy(double r) {
return new DynamicViscosity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public DynamicViscosity mult(UReal r) {
return new DynamicViscosity(this.value.mult(r),this.getUnits());
}
public DynamicViscosity divideBy(UReal r) {
return new DynamicViscosity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public DynamicViscosity clone() {
return new DynamicViscosity(this.getUReal(),this.getUnits());
}
}
