package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricFieldStrength extends Quantity {
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
return Arrays.equals(x,u.dimensions);
}

public ElectricFieldStrength(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFieldStrength");
this.unit = new Unit (q.unit);
}
public ElectricFieldStrength () {
value = new UReal();
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricFieldStrength");
this.unit = new Unit (unit);
}
public ElectricFieldStrength(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFieldStrength");
this.unit = new Unit (unit);
}
public ElectricFieldStrength(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFieldStrength");
this.unit = new Unit (unit);
}
public ElectricFieldStrength(String x) { //creates a ElectricFieldStrength from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength(String x, String u) { //creates a ElectricFieldStrength from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.VoltPerMeter);
}
public ElectricFieldStrength(String x, String u, Unit unit) { //creates a ElectricFieldStrength from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFieldStrength");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricFieldStrength add(ElectricFieldStrength r) {  //only works if compatible units && operand has no offset
return new ElectricFieldStrength(super.add(r));
}
public ElectricFieldStrength minus(ElectricFieldStrength r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricFieldStrength(super.minus(r));
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
public HeatFlowratePerUnitArea mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowratePerUnitArea(super.mult(r));
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
public ElectricFieldStrength abs() { //units are maintained
return new ElectricFieldStrength(super.abs());
}
public ElectricFieldStrength neg() { //units are maintained
return new ElectricFieldStrength(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricFieldStrength r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricFieldStrength r) {
return !(this.equals(r));
}
public ElectricFieldStrength floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricFieldStrength(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricFieldStrength round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricFieldStrength(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricFieldStrength min(ElectricFieldStrength r) { // units maintained
if (r.lessThan(this)) return new ElectricFieldStrength(r.getX(),r.getU(),r.getUnits());
return new ElectricFieldStrength(this.getX(),this.getU(),this.getUnits());
}
public ElectricFieldStrength max(ElectricFieldStrength r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricFieldStrength(r.getX(),r.getU(),r.getUnits());
return new ElectricFieldStrength(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricFieldStrength mult(double r) {
return new ElectricFieldStrength(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricFieldStrength divideBy(double r) {
return new ElectricFieldStrength(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricFieldStrength mult(UReal r) {
return new ElectricFieldStrength(this.value.mult(r),this.getUnits());
}
public ElectricFieldStrength divideBy(UReal r) {
return new ElectricFieldStrength(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricFieldStrength clone() {
return new ElectricFieldStrength(this.getUReal(),this.getUnits());
}
}
