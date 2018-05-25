package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ForcePerElectricCharge extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
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

public ForcePerElectricCharge(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ForcePerElectricCharge");
this.unit = new Unit (q.unit);
}
public ForcePerElectricCharge () {
value = new UReal();
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ForcePerElectricCharge");
this.unit = new Unit (unit);
}
public ForcePerElectricCharge(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ForcePerElectricCharge");
this.unit = new Unit (unit);
}
public ForcePerElectricCharge(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ForcePerElectricCharge");
this.unit = new Unit (unit);
}
public ForcePerElectricCharge(String x) { //creates a ForcePerElectricCharge from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge(String x, String u) { //creates a ForcePerElectricCharge from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.NewtonPerCoulomb);
}
public ForcePerElectricCharge(String x, String u, Unit unit) { //creates a ForcePerElectricCharge from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ForcePerElectricCharge");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ForcePerElectricCharge add(ForcePerElectricCharge r) {  //only works if compatible units && operand has no offset
return new ForcePerElectricCharge(super.add(r));
}
public ForcePerElectricCharge minus(ForcePerElectricCharge r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ForcePerElectricCharge(super.minus(r));
}
public ElectromotiveForce mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public ElectricChargeLineDensity mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public Force mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyPerUnitArea mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public EnergyAndWork mult(ElectricDipoleMoment r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyDensity mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public MagneticFieldStrength mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public LinearAcceleration mult(Exposure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public ElectricFluxDensity mult(Permittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public InversePermittivity divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new InversePermittivity(super.divideBy(r));
}
public ElectricFluxDensity divideBy(InversePermittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public MagneticFluxDensity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public Resistance divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public LinearVelocity divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public MagneticFieldStrength divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public UReal divideBy(ForcePerElectricCharge r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ForcePerElectricCharge abs() { //units are maintained
return new ForcePerElectricCharge(super.abs());
}
public ForcePerElectricCharge neg() { //units are maintained
return new ForcePerElectricCharge(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ForcePerElectricCharge r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ForcePerElectricCharge r) {
return !(this.equals(r));
}
public ForcePerElectricCharge floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ForcePerElectricCharge(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ForcePerElectricCharge round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ForcePerElectricCharge(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ForcePerElectricCharge min(ForcePerElectricCharge r) { // units maintained
if (r.lt(this)) return new ForcePerElectricCharge(r.getX(),r.getU(),r.getUnits());
return new ForcePerElectricCharge(this.getX(),this.getU(),this.getUnits());
}
public ForcePerElectricCharge max(ForcePerElectricCharge r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ForcePerElectricCharge(r.getX(),r.getU(),r.getUnits());
return new ForcePerElectricCharge(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ForcePerElectricCharge mult(double r) {
return new ForcePerElectricCharge(this.value.mult(new UReal(r)),this.getUnits());
}
public ForcePerElectricCharge divideBy(double r) {
return new ForcePerElectricCharge(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ForcePerElectricCharge mult(UReal r) {
return new ForcePerElectricCharge(this.value.mult(r),this.getUnits());
}
public ForcePerElectricCharge divideBy(UReal r) {
return new ForcePerElectricCharge(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ForcePerElectricCharge clone() {
return new ForcePerElectricCharge(this.getUReal(),this.getUnits());
}
}
