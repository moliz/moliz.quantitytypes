package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class CoefficientOfHeatTransfer extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=-1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public CoefficientOfHeatTransfer(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a CoefficientOfHeatTransfer");
this.unit = new Unit (q.unit);
}
public CoefficientOfHeatTransfer () {
value = new UReal();
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CoefficientOfHeatTransfer");
this.unit = new Unit (unit);
}
public CoefficientOfHeatTransfer(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CoefficientOfHeatTransfer");
this.unit = new Unit (unit);
}
public CoefficientOfHeatTransfer(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CoefficientOfHeatTransfer");
this.unit = new Unit (unit);
}
public CoefficientOfHeatTransfer(String x) { //creates a CoefficientOfHeatTransfer from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer(String x, String u) { //creates a CoefficientOfHeatTransfer from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
}
public CoefficientOfHeatTransfer(String x, String u, Unit unit) { //creates a CoefficientOfHeatTransfer from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CoefficientOfHeatTransfer");
this.unit = new Unit (unit);
}
// Specific Type Operations
public CoefficientOfHeatTransfer add(CoefficientOfHeatTransfer r) {  //only works if compatible units && operand has no offset
return new CoefficientOfHeatTransfer(super.add(r));
}
public CoefficientOfHeatTransfer minus(CoefficientOfHeatTransfer r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new CoefficientOfHeatTransfer(super.minus(r));
}
public ThermalConductivity mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public HeatFlowRatePerUnitArea mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.mult(r));
}
public HeatFlowRate mult(AreaTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public SpecificHeatVolume divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public LinearMomentum divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public LinearVelocity divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public UReal divideBy(CoefficientOfHeatTransfer r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ThermalInsulance inverse() {
return new  ThermalInsulance(super.inverse());
}
public CoefficientOfHeatTransfer abs() { //units are maintained
return new CoefficientOfHeatTransfer(super.abs());
}
public CoefficientOfHeatTransfer neg() { //units are maintained
return new CoefficientOfHeatTransfer(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(CoefficientOfHeatTransfer r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(CoefficientOfHeatTransfer r) {
return !(this.equals(r));
}
public CoefficientOfHeatTransfer floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new CoefficientOfHeatTransfer(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public CoefficientOfHeatTransfer round(){ //returns (i,u) with i the closest int to x -- units maintained
return new CoefficientOfHeatTransfer(Math.round(this.getX()),this.getU(),this.getUnits());
}
public CoefficientOfHeatTransfer min(CoefficientOfHeatTransfer r) { // units maintained
if (r.lt(this)) return new CoefficientOfHeatTransfer(r.getX(),r.getU(),r.getUnits());
return new CoefficientOfHeatTransfer(this.getX(),this.getU(),this.getUnits());
}
public CoefficientOfHeatTransfer max(CoefficientOfHeatTransfer r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new CoefficientOfHeatTransfer(r.getX(),r.getU(),r.getUnits());
return new CoefficientOfHeatTransfer(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public CoefficientOfHeatTransfer mult(double r) {
return new CoefficientOfHeatTransfer(this.value.mult(new UReal(r)),this.getUnits());
}
public CoefficientOfHeatTransfer divideBy(double r) {
return new CoefficientOfHeatTransfer(this.value.divideBy(new UReal(r)),this.getUnits());
}
public CoefficientOfHeatTransfer mult(UReal r) {
return new CoefficientOfHeatTransfer(this.value.mult(r),this.getUnits());
}
public CoefficientOfHeatTransfer divideBy(UReal r) {
return new CoefficientOfHeatTransfer(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public CoefficientOfHeatTransfer clone() {
return new CoefficientOfHeatTransfer(this.getUReal(),this.getUnits());
}
}
