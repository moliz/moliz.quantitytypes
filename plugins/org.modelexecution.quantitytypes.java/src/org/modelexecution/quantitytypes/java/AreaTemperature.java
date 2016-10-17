package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AreaTemperature extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AreaTemperature(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AreaTemperature");
this.unit = new Unit (q.unit);
}
public AreaTemperature () {
value = new UReal();
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AreaTemperature");
this.unit = new Unit (unit);
}
public AreaTemperature(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaTemperature");
this.unit = new Unit (unit);
}
public AreaTemperature(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaTemperature");
this.unit = new Unit (unit);
}
public AreaTemperature(String x) { //creates a AreaTemperature from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature(String x, String u) { //creates a AreaTemperature from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterKelvin);
}
public AreaTemperature(String x, String u, Unit unit) { //creates a AreaTemperature from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AreaTemperature");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AreaTemperature add(AreaTemperature r) {  //only works if compatible units && operand has no offset
return new AreaTemperature(super.add(r));
}
public AreaTemperature minus(AreaTemperature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AreaTemperature(super.minus(r));
}
public HeatFlowRate mult(CoefficientOfHeatTransfer r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public Volume mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public MassTemperature mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public LinearAcceleration mult(SpecificHeatVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearAcceleration(super.mult(r));
}
public Force mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public LengthTemperature divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemperature(super.divideBy(r));
}
public Area divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public ThermalInsulance divideBy(HeatFlowRate r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalInsulance(super.divideBy(r));
}
public Length divideBy(LengthTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ThermalInsulance divideBy(Power r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalInsulance(super.divideBy(r));
}
public HeatFlowRate divideBy(ThermalInsulance r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRate(super.divideBy(r));
}
public UReal divideBy(AreaTemperature r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AreaTemperature abs() { //units are maintained
return new AreaTemperature(super.abs());
}
public AreaTemperature neg() { //units are maintained
return new AreaTemperature(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AreaTemperature r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AreaTemperature r) {
return !(this.equals(r));
}
public AreaTemperature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AreaTemperature(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AreaTemperature round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AreaTemperature(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AreaTemperature min(AreaTemperature r) { // units maintained
if (r.lessThan(this)) return new AreaTemperature(r.getX(),r.getU(),r.getUnits());
return new AreaTemperature(this.getX(),this.getU(),this.getUnits());
}
public AreaTemperature max(AreaTemperature r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AreaTemperature(r.getX(),r.getU(),r.getUnits());
return new AreaTemperature(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AreaTemperature mult(double r) {
return new AreaTemperature(this.value.mult(new UReal(r)),this.getUnits());
}
public AreaTemperature divideBy(double r) {
return new AreaTemperature(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AreaTemperature mult(UReal r) {
return new AreaTemperature(this.value.mult(r),this.getUnits());
}
public AreaTemperature divideBy(UReal r) {
return new AreaTemperature(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AreaTemperature clone() {
return new AreaTemperature(this.getUReal(),this.getUnits());
}
}
