package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Volume extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=3.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Volume(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
this.unit = new Unit (q.unit);
}
public Volume () {
value = new UReal();
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Volume");
this.unit = new Unit (unit);
}
public Volume(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
this.unit = new Unit (unit);
}
public Volume(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
this.unit = new Unit (unit);
}
public Volume(String x) { //creates a Volume from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume(String x, String u) { //creates a Volume from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CubicMeter);
}
public Volume(String x, String u, Unit unit) { //creates a Volume from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Volume add(Volume r) {  //only works if compatible units && operand has no offset
return new Volume(super.add(r));
}
public Volume minus(Volume r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Volume(super.minus(r));
}
public VolumePerUnitTime mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public AmountOfSubstance mult(AmountOfSubstancePerUnitVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstance(super.mult(r));
}
public Mass mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public AngularMomentum mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public ElectricCharge mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricDipoleMoment mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public EnergyAndWork mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public VolumePerUnitTime mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public MagneticDipoleMoment mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public LengthMass mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public AngularMass mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public EnergyAndWork mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public SpecificHeatCapacity mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public HeatCapacityAndEntropy mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public Area divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public VolumePerUnitTime divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public VolumeThermalExpansion divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.divideBy(r));
}
public Length divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LinearThermalExpansion divideBy(AreaTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public LengthTemPerature divideBy(AreaThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemPerature(super.divideBy(r));
}
public AreaThermalExpansion divideBy(LengthTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaThermalExpansion(super.divideBy(r));
}
public AreaTemperature divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public SpecificHeatPressure divideBy(MassTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatPressure(super.divideBy(r));
}
public MassTemPerature divideBy(SpecificHeatPressure r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemPerature(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(VolumeThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Time divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Volume abs() { //units are maintained
return new Volume(super.abs());
}
public Volume neg() { //units are maintained
return new Volume(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Volume r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Volume r) {
return !(this.equals(r));
}
public Volume floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Volume(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Volume round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Volume(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Volume min(Volume r) { // units maintained
if (r.lessThan(this)) return new Volume(r.getX(),r.getU(),r.getUnits());
return new Volume(this.getX(),this.getU(),this.getUnits());
}
public Volume max(Volume r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Volume(r.getX(),r.getU(),r.getUnits());
return new Volume(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Volume mult(double r) {
return new Volume(this.value.mult(new UReal(r)),this.getUnits());
}
public Volume divideBy(double r) {
return new Volume(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Volume mult(UReal r) {
return new Volume(this.value.mult(r),this.getUnits());
}
public Volume divideBy(UReal r) {
return new Volume(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Volume clone() {
return new Volume(this.getUReal(),this.getUnits());
}
}
