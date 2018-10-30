package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class HeatCapacityAndEntropy extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
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

public HeatCapacityAndEntropy(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a HeatCapacityAndEntropy");
this.unit = new Unit (q.unit);
}
public HeatCapacityAndEntropy () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an HeatCapacityAndEntropy");
this.unit = new Unit (unit);
}
public HeatCapacityAndEntropy(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a HeatCapacityAndEntropy");
this.unit = new Unit (unit);
}
public HeatCapacityAndEntropy(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a HeatCapacityAndEntropy");
this.unit = new Unit (unit);
}
public HeatCapacityAndEntropy(String x) { //creates a HeatCapacityAndEntropy from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy(String x, String u) { //creates a HeatCapacityAndEntropy from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKelvin);
}
public HeatCapacityAndEntropy(String x, String u, Unit unit) { //creates a HeatCapacityAndEntropy from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a HeatCapacityAndEntropy");
this.unit = new Unit (unit);
}
// Specific Type Operations
public HeatCapacityAndEntropy add(HeatCapacityAndEntropy r) {  //only works if compatible units && operand has no offset
return new HeatCapacityAndEntropy(super.add(r));
}
public HeatCapacityAndEntropy minus(HeatCapacityAndEntropy r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new HeatCapacityAndEntropy(super.minus(r));
}
public EnergyAndWork mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public MolarHeatCapacity mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarHeatCapacity(super.mult(r));
}
public Time mult(ThermalResistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Time(super.mult(r));
}
public SpecificHeatCapacity divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public MolarHeatCapacity divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarHeatCapacity(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(AreaThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public VolumeThermalExpansion divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.divideBy(r));
}
public AreaThermalExpansion divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaThermalExpansion(super.divideBy(r));
}
public LinearThermalExpansion divideBy(Force r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public AreaThermalExpansion divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaThermalExpansion(super.divideBy(r));
}
public Force divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new Force(super.divideBy(r));
}
public AmountOfSubstance divideBy(MolarHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public VolumeThermalExpansion divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.divideBy(r));
}
public Mass divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public EnergyDensity divideBy(VolumeThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public Volume divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public UReal divideBy(HeatCapacityAndEntropy r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public HeatCapacityAndEntropy abs() { //units are maintained
return new HeatCapacityAndEntropy(super.abs());
}
public HeatCapacityAndEntropy neg() { //units are maintained
return new HeatCapacityAndEntropy(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(HeatCapacityAndEntropy r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(HeatCapacityAndEntropy r) {
return !(this.equals(r));
}
public HeatCapacityAndEntropy floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new HeatCapacityAndEntropy(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public HeatCapacityAndEntropy round(){ //returns (i,u) with i the closest int to x -- units maintained
return new HeatCapacityAndEntropy(Math.round(this.getX()),this.getU(),this.getUnits());
}
public HeatCapacityAndEntropy min(HeatCapacityAndEntropy r) { // units maintained
if (r.lt(this)) return new HeatCapacityAndEntropy(r.getX(),r.getU(),r.getUnits());
return new HeatCapacityAndEntropy(this.getX(),this.getU(),this.getUnits());
}
public HeatCapacityAndEntropy max(HeatCapacityAndEntropy r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new HeatCapacityAndEntropy(r.getX(),r.getU(),r.getUnits());
return new HeatCapacityAndEntropy(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public HeatCapacityAndEntropy mult(double r) {
return new HeatCapacityAndEntropy(this.value.mult(new UReal(r)),this.getUnits());
}
public HeatCapacityAndEntropy divideBy(double r) {
return new HeatCapacityAndEntropy(this.value.divideBy(new UReal(r)),this.getUnits());
}
public HeatCapacityAndEntropy mult(UReal r) {
return new HeatCapacityAndEntropy(this.value.mult(r),this.getUnits());
}
public HeatCapacityAndEntropy divideBy(UReal r) {
return new HeatCapacityAndEntropy(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public HeatCapacityAndEntropy clone() {
return new HeatCapacityAndEntropy(this.getUReal(),this.getUnits());
}
}
