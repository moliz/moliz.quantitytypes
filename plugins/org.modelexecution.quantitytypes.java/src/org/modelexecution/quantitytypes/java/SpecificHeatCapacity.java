package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class SpecificHeatCapacity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
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

public SpecificHeatCapacity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatCapacity");
this.unit = new Unit (q.unit);
}
public SpecificHeatCapacity () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an SpecificHeatCapacity");
this.unit = new Unit (unit);
}
public SpecificHeatCapacity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatCapacity");
this.unit = new Unit (unit);
}
public SpecificHeatCapacity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatCapacity");
this.unit = new Unit (unit);
}
public SpecificHeatCapacity(String x) { //creates a SpecificHeatCapacity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity(String x, String u) { //creates a SpecificHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogramKelvin);
}
public SpecificHeatCapacity(String x, String u, Unit unit) { //creates a SpecificHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificHeatCapacity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public SpecificHeatCapacity add(SpecificHeatCapacity r) {  //only works if compatible units && operand has no offset
return new SpecificHeatCapacity(super.add(r));
}
public SpecificHeatCapacity minus(SpecificHeatCapacity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new SpecificHeatCapacity(super.minus(r));
}
public HeatCapacityAndEntropy mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public AbsorbedDose mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public VolumetricHeatCapacity mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public ThermalConductivity mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public EnergyAndWork mult(MassTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AreaThermalExpansion mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaThermalExpansion(super.mult(r));
}
public MolarHeatCapacity divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarHeatCapacity(super.divideBy(r));
}
public SpecificHeatPressure divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatPressure(super.divideBy(r));
}
public LinearThermalExpansion divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public LinearAcceleration divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(MolarHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public SpecificHeatPressure divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatPressure(super.divideBy(r));
}
public EnergyDensity divideBy(SpecificHeatPressure r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public Volume divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public LinearThermalExpansion divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public SpecificHeatVolume divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public UReal divideBy(SpecificHeatCapacity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public SpecificHeatCapacity abs() { //units are maintained
return new SpecificHeatCapacity(super.abs());
}
public SpecificHeatCapacity neg() { //units are maintained
return new SpecificHeatCapacity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(SpecificHeatCapacity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(SpecificHeatCapacity r) {
return !(this.equals(r));
}
public SpecificHeatCapacity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new SpecificHeatCapacity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public SpecificHeatCapacity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new SpecificHeatCapacity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public SpecificHeatCapacity min(SpecificHeatCapacity r) { // units maintained
if (r.lt(this)) return new SpecificHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new SpecificHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
public SpecificHeatCapacity max(SpecificHeatCapacity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new SpecificHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new SpecificHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public SpecificHeatCapacity mult(double r) {
return new SpecificHeatCapacity(this.value.mult(new UReal(r)),this.getUnits());
}
public SpecificHeatCapacity divideBy(double r) {
return new SpecificHeatCapacity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public SpecificHeatCapacity mult(UReal r) {
return new SpecificHeatCapacity(this.value.mult(r),this.getUnits());
}
public SpecificHeatCapacity divideBy(UReal r) {
return new SpecificHeatCapacity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public SpecificHeatCapacity clone() {
return new SpecificHeatCapacity(this.getUReal(),this.getUnits());
}
}
