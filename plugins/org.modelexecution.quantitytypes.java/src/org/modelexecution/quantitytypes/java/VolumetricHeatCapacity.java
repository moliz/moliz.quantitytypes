package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class VolumetricHeatCapacity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
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

public VolumetricHeatCapacity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a VolumetricHeatCapacity");
this.unit = new Unit (q.unit);
}
public VolumetricHeatCapacity () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an VolumetricHeatCapacity");
this.unit = new Unit (unit);
}
public VolumetricHeatCapacity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumetricHeatCapacity");
this.unit = new Unit (unit);
}
public VolumetricHeatCapacity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumetricHeatCapacity");
this.unit = new Unit (unit);
}
public VolumetricHeatCapacity(String x) { //creates a VolumetricHeatCapacity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity(String x, String u) { //creates a VolumetricHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
}
public VolumetricHeatCapacity(String x, String u, Unit unit) { //creates a VolumetricHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a VolumetricHeatCapacity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public VolumetricHeatCapacity add(VolumetricHeatCapacity r) {  //only works if compatible units && operand has no offset
return new VolumetricHeatCapacity(super.add(r));
}
public VolumetricHeatCapacity minus(VolumetricHeatCapacity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new VolumetricHeatCapacity(super.minus(r));
}
public EnergyDensity mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public Force mult(AreaTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public ThermalConductivity mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public EnergyPerUnitArea mult(LengthTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public CoefficientOfHeatTransfer mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.mult(r));
}
public ThermalConductivity mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public HeatCapacityAndEntropy mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public SpecificHeatVolume divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public MolarHeatCapacity divideBy(AmountOfSubstancePerUnitVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarHeatCapacity(super.divideBy(r));
}
public SpecificHeatCapacity divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public AmountOfSubstancePerUnitVolume divideBy(MolarHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.divideBy(r));
}
public Density divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public Mass divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public UReal divideBy(VolumetricHeatCapacity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public VolumetricHeatCapacity abs() { //units are maintained
return new VolumetricHeatCapacity(super.abs());
}
public VolumetricHeatCapacity neg() { //units are maintained
return new VolumetricHeatCapacity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(VolumetricHeatCapacity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(VolumetricHeatCapacity r) {
return !(this.equals(r));
}
public VolumetricHeatCapacity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new VolumetricHeatCapacity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public VolumetricHeatCapacity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new VolumetricHeatCapacity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public VolumetricHeatCapacity min(VolumetricHeatCapacity r) { // units maintained
if (r.lt(this)) return new VolumetricHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new VolumetricHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
public VolumetricHeatCapacity max(VolumetricHeatCapacity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new VolumetricHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new VolumetricHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public VolumetricHeatCapacity mult(double r) {
return new VolumetricHeatCapacity(this.value.mult(new UReal(r)),this.getUnits());
}
public VolumetricHeatCapacity divideBy(double r) {
return new VolumetricHeatCapacity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public VolumetricHeatCapacity mult(UReal r) {
return new VolumetricHeatCapacity(this.value.mult(r),this.getUnits());
}
public VolumetricHeatCapacity divideBy(UReal r) {
return new VolumetricHeatCapacity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public VolumetricHeatCapacity clone() {
return new VolumetricHeatCapacity(this.getUReal(),this.getUnits());
}
}
