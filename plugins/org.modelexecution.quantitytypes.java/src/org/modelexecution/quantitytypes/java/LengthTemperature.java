package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class LengthTemperature extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public LengthTemperature(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LengthTemperature");
this.unit = new Unit (q.unit);
}
public LengthTemperature () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an LengthTemperature");
this.unit = new Unit (unit);
}
public LengthTemperature(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthTemperature");
this.unit = new Unit (unit);
}
public LengthTemperature(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthTemperature");
this.unit = new Unit (unit);
}
public LengthTemperature(String x) { //creates a LengthTemperature from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature(String x, String u) { //creates a LengthTemperature from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKelvin);
}
public LengthTemperature(String x, String u, Unit unit) { //creates a LengthTemperature from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a LengthTemperature");
this.unit = new Unit (unit);
}
// Specific Type Operations
public LengthTemperature add(LengthTemperature r) {  //only works if compatible units && operand has no offset
return new LengthTemperature(super.add(r));
}
public LengthTemperature minus(LengthTemperature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new LengthTemperature(super.minus(r));
}
public AreaTemperature mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public Volume mult(AreaThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public Area mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public MassTemperature mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public HeatFlowrate mult(ThermalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowrate(super.mult(r));
}
public EnergyPerUnitArea mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ThermodynamicTemperature divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Length divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ThermalResistivity divideBy(HeatFlowrate r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistivity(super.divideBy(r));
}
public ThermalResistivity divideBy(Power r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistivity(super.divideBy(r));
}
public HeatFlowrate divideBy(ThermalResistivity r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowrate(super.divideBy(r));
}
public LengthTemperature abs() { //units are maintained
return new LengthTemperature(super.abs());
}
public LengthTemperature neg() { //units are maintained
return new LengthTemperature(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(LengthTemperature r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(LengthTemperature r) {
return !(this.equals(r));
}
public LengthTemperature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new LengthTemperature(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public LengthTemperature round(){ //returns (i,u) with i the closest int to x -- units maintained
return new LengthTemperature(Math.round(this.getX()),this.getU(),this.getUnits());
}
public LengthTemperature min(LengthTemperature r) { // units maintained
if (r.lessThan(this)) return new LengthTemperature(r.getX(),r.getU(),r.getUnits());
return new LengthTemperature(this.getX(),this.getU(),this.getUnits());
}
public LengthTemperature max(LengthTemperature r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new LengthTemperature(r.getX(),r.getU(),r.getUnits());
return new LengthTemperature(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public LengthTemperature mult(double r) {
return new LengthTemperature(this.value.mult(new UReal(r)),this.getUnits());
}
public LengthTemperature divideBy(double r) {
return new LengthTemperature(this.value.divideBy(new UReal(r)),this.getUnits());
}
public LengthTemperature mult(UReal r) {
return new LengthTemperature(this.value.mult(r),this.getUnits());
}
public LengthTemperature divideBy(UReal r) {
return new LengthTemperature(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public LengthTemperature clone() {
return new LengthTemperature(this.getUReal(),this.getUnits());
}
}
