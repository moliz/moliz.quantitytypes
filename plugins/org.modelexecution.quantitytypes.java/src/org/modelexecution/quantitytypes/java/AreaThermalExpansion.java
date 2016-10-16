package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AreaThermalExpansion extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=-1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AreaThermalExpansion(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AreaThermalExpansion");
this.unit = new Unit (q.unit);
}
public AreaThermalExpansion () {
value = new UReal();
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AreaThermalExpansion");
this.unit = new Unit (unit);
}
public AreaThermalExpansion(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaThermalExpansion");
this.unit = new Unit (unit);
}
public AreaThermalExpansion(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaThermalExpansion");
this.unit = new Unit (unit);
}
public AreaThermalExpansion(String x) { //creates a AreaThermalExpansion from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion(String x, String u) { //creates a AreaThermalExpansion from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterPerKelvin);
}
public AreaThermalExpansion(String x, String u, Unit unit) { //creates a AreaThermalExpansion from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaThermalExpansion");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AreaThermalExpansion add(AreaThermalExpansion r) {  //only works if compatible units && operand has no offset
return new AreaThermalExpansion(super.add(r));
}
public AreaThermalExpansion minus(AreaThermalExpansion r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AreaThermalExpansion(super.minus(r));
}
public VolumeThermalExpansion mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.mult(r));
}
public Area mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public HeatCapacityAndEntropy mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public HeatCapacityAndEntropy mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public Volume mult(LengthTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public AngularMass mult(MassTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public LinearThermalExpansion divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public Length divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public SpecificHeatPressure divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatPressure(super.divideBy(r));
}
public TimeSquared divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public MassPerUnitLength divideBy(SpecificHeatPressure r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public SpecificHeatCapacity divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public AreaThermalExpansion abs() { //units are maintained
return new AreaThermalExpansion(super.abs());
}
public AreaThermalExpansion neg() { //units are maintained
return new AreaThermalExpansion(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AreaThermalExpansion r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AreaThermalExpansion r) {
return !(this.equals(r));
}
public AreaThermalExpansion floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AreaThermalExpansion(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AreaThermalExpansion round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AreaThermalExpansion(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AreaThermalExpansion min(AreaThermalExpansion r) { // units maintained
if (r.lessThan(this)) return new AreaThermalExpansion(r.getX(),r.getU(),r.getUnits());
return new AreaThermalExpansion(this.getX(),this.getU(),this.getUnits());
}
public AreaThermalExpansion max(AreaThermalExpansion r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AreaThermalExpansion(r.getX(),r.getU(),r.getUnits());
return new AreaThermalExpansion(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AreaThermalExpansion mult(double r) {
return new AreaThermalExpansion(this.value.mult(new UReal(r)),this.getUnits());
}
public AreaThermalExpansion divideBy(double r) {
return new AreaThermalExpansion(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AreaThermalExpansion mult(UReal r) {
return new AreaThermalExpansion(this.value.mult(r),this.getUnits());
}
public AreaThermalExpansion divideBy(UReal r) {
return new AreaThermalExpansion(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AreaThermalExpansion clone() {
return new AreaThermalExpansion(this.getUReal(),this.getUnits());
}
}
