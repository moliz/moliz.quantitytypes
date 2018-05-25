package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricFluxDensity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=1.0;
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

public ElectricFluxDensity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
this.unit = new Unit (q.unit);
}
public ElectricFluxDensity () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricFluxDensity");
this.unit = new Unit (unit);
}
public ElectricFluxDensity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
this.unit = new Unit (unit);
}
public ElectricFluxDensity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
this.unit = new Unit (unit);
}
public ElectricFluxDensity(String x) { //creates a ElectricFluxDensity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity(String x, String u) { //creates a ElectricFluxDensity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerSquareMeter);
}
public ElectricFluxDensity(String x, String u, Unit unit) { //creates a ElectricFluxDensity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricFluxDensity add(ElectricFluxDensity r) {  //only works if compatible units && operand has no offset
return new ElectricFluxDensity(super.add(r));
}
public ElectricFluxDensity minus(ElectricFluxDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricFluxDensity(super.minus(r));
}
public ElectricChargeLineDensity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricCurrentDensity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.mult(r));
}
public ElectricCharge mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public EnergyDensity mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public EnergyPerUnitArea mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public EnergyDensity mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ElectricCurrentDensity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.mult(r));
}
public ElectricFieldStrength mult(InversePermittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public ElectricCurrent mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MagneticFieldStrength mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public MassPerUnitTime mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public MagneticFluxDensity mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFluxDensity(super.mult(r));
}
public ElectricCurrent mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricDipoleMoment mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public ElectricChargeVolumeDensity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public ElectricCurrentDensity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public Length divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Time divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Permittivity divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Permittivity(super.divideBy(r));
}
public MagneticFluxDensity divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public MassPerUnitArea divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public Permittivity divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Permittivity(super.divideBy(r));
}
public ElectricalConductivity divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public Exposure divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricFieldStrength divideBy(Permittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public UReal divideBy(ElectricFluxDensity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricFluxDensity abs() { //units are maintained
return new ElectricFluxDensity(super.abs());
}
public ElectricFluxDensity neg() { //units are maintained
return new ElectricFluxDensity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricFluxDensity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricFluxDensity r) {
return !(this.equals(r));
}
public ElectricFluxDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricFluxDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricFluxDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricFluxDensity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricFluxDensity min(ElectricFluxDensity r) { // units maintained
if (r.lt(this)) return new ElectricFluxDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricFluxDensity(this.getX(),this.getU(),this.getUnits());
}
public ElectricFluxDensity max(ElectricFluxDensity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricFluxDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricFluxDensity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricFluxDensity mult(double r) {
return new ElectricFluxDensity(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricFluxDensity divideBy(double r) {
return new ElectricFluxDensity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricFluxDensity mult(UReal r) {
return new ElectricFluxDensity(this.value.mult(r),this.getUnits());
}
public ElectricFluxDensity divideBy(UReal r) {
return new ElectricFluxDensity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricFluxDensity clone() {
return new ElectricFluxDensity(this.getUReal(),this.getUnits());
}
}
