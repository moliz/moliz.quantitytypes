package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricChargeLineDensity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
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

public ElectricChargeLineDensity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeLineDensity");
this.unit = new Unit (q.unit);
}
public ElectricChargeLineDensity () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargeLineDensity");
this.unit = new Unit (unit);
}
public ElectricChargeLineDensity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeLineDensity");
this.unit = new Unit (unit);
}
public ElectricChargeLineDensity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeLineDensity");
this.unit = new Unit (unit);
}
public ElectricChargeLineDensity(String x) { //creates a ElectricChargeLineDensity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity(String x, String u) { //creates a ElectricChargeLineDensity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerMeter);
}
public ElectricChargeLineDensity(String x, String u, Unit unit) { //creates a ElectricChargeLineDensity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargeLineDensity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricChargeLineDensity add(ElectricChargeLineDensity r) {  //only works if compatible units && operand has no offset
return new ElectricChargeLineDensity(super.add(r));
}
public ElectricChargeLineDensity minus(ElectricChargeLineDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricChargeLineDensity(super.minus(r));
}
public ElectricCharge mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public MagneticFieldStrength mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricDipoleMoment mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public EnergyPerUnitArea mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public Force mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyPerUnitArea mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public MagneticFieldStrength mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectromotiveForce mult(InversePermittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public ElectricCurrent mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public LinearMomentum mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public DynamicViscosity mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public MagneticDipoleMoment mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public ElectricFluxDensity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public MagneticFieldStrength divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(Capacitance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public Area divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Capacitance divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public Length divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Permittivity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new Permittivity(super.divideBy(r));
}
public MassPerUnitLength divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public Capacitance divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public Time divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Exposure divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectromotiveForce divideBy(Permittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public UReal divideBy(ElectricChargeLineDensity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricChargeLineDensity abs() { //units are maintained
return new ElectricChargeLineDensity(super.abs());
}
public ElectricChargeLineDensity neg() { //units are maintained
return new ElectricChargeLineDensity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricChargeLineDensity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricChargeLineDensity r) {
return !(this.equals(r));
}
public ElectricChargeLineDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricChargeLineDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargeLineDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricChargeLineDensity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargeLineDensity min(ElectricChargeLineDensity r) { // units maintained
if (r.lt(this)) return new ElectricChargeLineDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricChargeLineDensity(this.getX(),this.getU(),this.getUnits());
}
public ElectricChargeLineDensity max(ElectricChargeLineDensity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricChargeLineDensity(r.getX(),r.getU(),r.getUnits());
return new ElectricChargeLineDensity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricChargeLineDensity mult(double r) {
return new ElectricChargeLineDensity(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricChargeLineDensity divideBy(double r) {
return new ElectricChargeLineDensity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricChargeLineDensity mult(UReal r) {
return new ElectricChargeLineDensity(this.value.mult(r),this.getUnits());
}
public ElectricChargeLineDensity divideBy(UReal r) {
return new ElectricChargeLineDensity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricChargeLineDensity clone() {
return new ElectricChargeLineDensity(this.getUReal(),this.getUnits());
}
}
