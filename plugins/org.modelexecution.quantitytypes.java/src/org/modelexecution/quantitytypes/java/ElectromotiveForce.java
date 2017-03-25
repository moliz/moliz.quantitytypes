package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectromotiveForce extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=-1.0;
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

public ElectromotiveForce(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectromotiveForce");
this.unit = new Unit (q.unit);
}
public ElectromotiveForce () {
value = new UReal();
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectromotiveForce");
this.unit = new Unit (unit);
}
public ElectromotiveForce(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectromotiveForce");
this.unit = new Unit (unit);
}
public ElectromotiveForce(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectromotiveForce");
this.unit = new Unit (unit);
}
public ElectromotiveForce(String x) { //creates a ElectromotiveForce from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce(String x, String u) { //creates a ElectromotiveForce from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Volt);
}
public ElectromotiveForce(String x, String u, Unit unit) { //creates a ElectromotiveForce from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectromotiveForce");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectromotiveForce add(ElectromotiveForce r) {  //only works if compatible units && operand has no offset
return new ElectromotiveForce(super.add(r));
}
public ElectromotiveForce minus(ElectromotiveForce r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectromotiveForce(super.minus(r));
}
public MagneticFlux mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public HeatFlowRate mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public ElectricCharge mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public EnergyAndWork mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Force mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyDensity mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public MolarEnergy mult(ElectricChargePerAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public EnergyPerUnitArea mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ElectricCurrent mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public AbsorbedDose mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public ElectricChargeLineDensity mult(Permittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricFieldStrength divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public Resistance divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public MagneticFlux divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public InversePermittivity divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new InversePermittivity(super.divideBy(r));
}
public Length divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Length divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public MagneticFlux divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(InversePermittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public MagneticFluxDensity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public Activity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public KinematicViscosity divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public ElectricCurrent divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public UReal divideBy(ElectromotiveForce r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectromotiveForce abs() { //units are maintained
return new ElectromotiveForce(super.abs());
}
public ElectromotiveForce neg() { //units are maintained
return new ElectromotiveForce(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectromotiveForce r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectromotiveForce r) {
return !(this.equals(r));
}
public ElectromotiveForce floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectromotiveForce(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectromotiveForce round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectromotiveForce(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectromotiveForce min(ElectromotiveForce r) { // units maintained
if (r.lessThan(this)) return new ElectromotiveForce(r.getX(),r.getU(),r.getUnits());
return new ElectromotiveForce(this.getX(),this.getU(),this.getUnits());
}
public ElectromotiveForce max(ElectromotiveForce r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectromotiveForce(r.getX(),r.getU(),r.getUnits());
return new ElectromotiveForce(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectromotiveForce mult(double r) {
return new ElectromotiveForce(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectromotiveForce divideBy(double r) {
return new ElectromotiveForce(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectromotiveForce mult(UReal r) {
return new ElectromotiveForce(this.value.mult(r),this.getUnits());
}
public ElectromotiveForce divideBy(UReal r) {
return new ElectromotiveForce(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectromotiveForce clone() {
return new ElectromotiveForce(this.getUReal(),this.getUnits());
}
}
