package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MagneticFlux extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=-1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MagneticFlux(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
this.unit = new Unit (q.unit);
}
public MagneticFlux () {
value = new UReal();
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticFlux");
this.unit = new Unit (unit);
}
public MagneticFlux(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
this.unit = new Unit (unit);
}
public MagneticFlux(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
this.unit = new Unit (unit);
}
public MagneticFlux(String x) { //creates a MagneticFlux from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux(String x, String u) { //creates a MagneticFlux from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Weber);
}
public MagneticFlux(String x, String u, Unit unit) { //creates a MagneticFlux from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MagneticFlux add(MagneticFlux r) {  //only works if compatible units && operand has no offset
return new MagneticFlux(super.add(r));
}
public MagneticFlux minus(MagneticFlux r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MagneticFlux(super.minus(r));
}
public EnergyAndWork mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public ElectromotiveForce mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public AngularMomentum mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public LinearMomentum mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public DynamicViscosity mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public EnergyPerUnitArea mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public MassPerUnitTime mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public ElectricCharge mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public KinematicViscosity mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public ElectromotiveForce mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public Force mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public ElectromotiveForce divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public Inductance divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public MagneticFluxDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public Resistance divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public Time divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public ElectricCurrent divideBy(Inductance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public Area divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public ElectricCharge divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public UReal divideBy(MagneticFlux r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MagneticFlux abs() { //units are maintained
return new MagneticFlux(super.abs());
}
public MagneticFlux neg() { //units are maintained
return new MagneticFlux(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MagneticFlux r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MagneticFlux r) {
return !(this.equals(r));
}
public MagneticFlux floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MagneticFlux(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MagneticFlux round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MagneticFlux(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MagneticFlux min(MagneticFlux r) { // units maintained
if (r.lessThan(this)) return new MagneticFlux(r.getX(),r.getU(),r.getUnits());
return new MagneticFlux(this.getX(),this.getU(),this.getUnits());
}
public MagneticFlux max(MagneticFlux r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MagneticFlux(r.getX(),r.getU(),r.getUnits());
return new MagneticFlux(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MagneticFlux mult(double r) {
return new MagneticFlux(this.value.mult(new UReal(r)),this.getUnits());
}
public MagneticFlux divideBy(double r) {
return new MagneticFlux(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MagneticFlux mult(UReal r) {
return new MagneticFlux(this.value.mult(r),this.getUnits());
}
public MagneticFlux divideBy(UReal r) {
return new MagneticFlux(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MagneticFlux clone() {
return new MagneticFlux(this.getUReal(),this.getUnits());
}
}
