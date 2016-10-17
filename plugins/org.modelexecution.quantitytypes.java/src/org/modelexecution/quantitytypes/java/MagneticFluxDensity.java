package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MagneticFluxDensity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=-1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MagneticFluxDensity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
this.unit = new Unit (q.unit);
}
public MagneticFluxDensity () {
value = new UReal();
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFluxDensity");
this.unit = new Unit (unit);
}
public MagneticFluxDensity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
this.unit = new Unit (unit);
}
public MagneticFluxDensity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
this.unit = new Unit (unit);
}
public MagneticFluxDensity(String x) { //creates a MagneticFluxDensity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity(String x, String u) { //creates a MagneticFluxDensity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Tesla);
}
public MagneticFluxDensity(String x, String u, Unit unit) { //creates a MagneticFluxDensity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFluxDensity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MagneticFluxDensity add(MagneticFluxDensity r) {  //only works if compatible units && operand has no offset
return new MagneticFluxDensity(super.add(r));
}
public MagneticFluxDensity minus(MagneticFluxDensity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MagneticFluxDensity(super.minus(r));
}
public EnergyPerUnitArea mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public MagneticFlux mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public MassPerUnitTime mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public DynamicViscosity mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public LinearMomentum mult(ElectricDipoleMoment r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public ElectricFluxDensity mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public Activity mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Activity(super.mult(r));
}
public ElectromotiveForce mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public ElectricFieldStrength mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public EnergyAndWork mult(MagneticDipoleMoment r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyDensity mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ElectromotiveForce mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public Inductance divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public Resistance divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public ElectricCurrentDensity divideBy(Inductance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public Permeability divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public MagneticFieldStrength divideBy(Permeability r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public ElectricFluxDensity divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public UReal divideBy(MagneticFluxDensity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MagneticFluxDensity abs() { //units are maintained
return new MagneticFluxDensity(super.abs());
}
public MagneticFluxDensity neg() { //units are maintained
return new MagneticFluxDensity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MagneticFluxDensity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MagneticFluxDensity r) {
return !(this.equals(r));
}
public MagneticFluxDensity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MagneticFluxDensity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MagneticFluxDensity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MagneticFluxDensity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MagneticFluxDensity min(MagneticFluxDensity r) { // units maintained
if (r.lessThan(this)) return new MagneticFluxDensity(r.getX(),r.getU(),r.getUnits());
return new MagneticFluxDensity(this.getX(),this.getU(),this.getUnits());
}
public MagneticFluxDensity max(MagneticFluxDensity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MagneticFluxDensity(r.getX(),r.getU(),r.getUnits());
return new MagneticFluxDensity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MagneticFluxDensity mult(double r) {
return new MagneticFluxDensity(this.value.mult(new UReal(r)),this.getUnits());
}
public MagneticFluxDensity divideBy(double r) {
return new MagneticFluxDensity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MagneticFluxDensity mult(UReal r) {
return new MagneticFluxDensity(this.value.mult(r),this.getUnits());
}
public MagneticFluxDensity divideBy(UReal r) {
return new MagneticFluxDensity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MagneticFluxDensity clone() {
return new MagneticFluxDensity(this.getUReal(),this.getUnits());
}
}
