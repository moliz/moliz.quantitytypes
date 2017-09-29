package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MagneticFieldStrength extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
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

public MagneticFieldStrength(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFieldStrength");
this.unit = new Unit (q.unit);
}
public MagneticFieldStrength () {
value = new UReal();
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFieldStrength");
this.unit = new Unit (unit);
}
public MagneticFieldStrength(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFieldStrength");
this.unit = new Unit (unit);
}
public MagneticFieldStrength(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFieldStrength");
this.unit = new Unit (unit);
}
public MagneticFieldStrength(String x) { //creates a MagneticFieldStrength from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength(String x, String u) { //creates a MagneticFieldStrength from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.AmpereTurnPerMeter);
}
public MagneticFieldStrength(String x, String u, Unit unit) { //creates a MagneticFieldStrength from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFieldStrength");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MagneticFieldStrength add(MagneticFieldStrength r) {  //only works if compatible units && operand has no offset
return new MagneticFieldStrength(super.add(r));
}
public MagneticFieldStrength minus(MagneticFieldStrength r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MagneticFieldStrength(super.minus(r));
}
public ElectricCurrent mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricChargeLineDensity mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public Force mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyDensity mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public MagneticFluxDensity mult(Permeability r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFluxDensity(super.mult(r));
}
public ElectricFieldStrength mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public MagneticDipoleMoment mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public ElectricCurrentDensity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public Exposure divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public Activity divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public KinematicViscosity divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public Length divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ElectricalConductivity divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public LinearVelocity divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public DynamicViscosity divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public ElectricalConductivity divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public ElectricFluxDensity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public UReal divideBy(MagneticFieldStrength r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MagneticFieldStrength abs() { //units are maintained
return new MagneticFieldStrength(super.abs());
}
public MagneticFieldStrength neg() { //units are maintained
return new MagneticFieldStrength(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MagneticFieldStrength r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MagneticFieldStrength r) {
return !(this.equals(r));
}
public MagneticFieldStrength floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MagneticFieldStrength(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MagneticFieldStrength round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MagneticFieldStrength(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MagneticFieldStrength min(MagneticFieldStrength r) { // units maintained
if (r.lessThan(this)) return new MagneticFieldStrength(r.getX(),r.getU(),r.getUnits());
return new MagneticFieldStrength(this.getX(),this.getU(),this.getUnits());
}
public MagneticFieldStrength max(MagneticFieldStrength r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MagneticFieldStrength(r.getX(),r.getU(),r.getUnits());
return new MagneticFieldStrength(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MagneticFieldStrength mult(double r) {
return new MagneticFieldStrength(this.value.mult(new UReal(r)),this.getUnits());
}
public MagneticFieldStrength divideBy(double r) {
return new MagneticFieldStrength(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MagneticFieldStrength mult(UReal r) {
return new MagneticFieldStrength(this.value.mult(r),this.getUnits());
}
public MagneticFieldStrength divideBy(UReal r) {
return new MagneticFieldStrength(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MagneticFieldStrength clone() {
return new MagneticFieldStrength(this.getUReal(),this.getUnits());
}
}
