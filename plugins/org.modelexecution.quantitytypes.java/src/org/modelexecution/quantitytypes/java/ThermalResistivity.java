package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ThermalResistivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-1.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ThermalResistivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistivity");
this.unit = new Unit (q.unit);
}
public ThermalResistivity () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalResistivity");
this.unit = new Unit (unit);
}
public ThermalResistivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistivity");
this.unit = new Unit (unit);
}
public ThermalResistivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistivity");
this.unit = new Unit (unit);
}
public ThermalResistivity(String x) { //creates a ThermalResistivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity(String x, String u) { //creates a ThermalResistivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterKelvinPerWatt);
}
public ThermalResistivity(String x, String u, Unit unit) { //creates a ThermalResistivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalResistivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ThermalResistivity add(ThermalResistivity r) {  //only works if compatible units && operand has no offset
return new ThermalResistivity(super.add(r));
}
public ThermalResistivity minus(ThermalResistivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ThermalResistivity(super.minus(r));
}
public ThermalInsulance mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalInsulance(super.mult(r));
}
public LengthTemperature mult(HeatFlowRate r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthTemperature(super.mult(r));
}
public LengthTemperature mult(Power r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthTemperature(super.mult(r));
}
public ThermalResistance divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistance(super.divideBy(r));
}
public Length divideBy(ThermalResistance r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public UReal divideBy(ThermalResistivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ThermalConductivity inverse() {
return new  ThermalConductivity(super.inverse());
}
public ThermalResistivity abs() { //units are maintained
return new ThermalResistivity(super.abs());
}
public ThermalResistivity neg() { //units are maintained
return new ThermalResistivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ThermalResistivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ThermalResistivity r) {
return !(this.equals(r));
}
public ThermalResistivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ThermalResistivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ThermalResistivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ThermalResistivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ThermalResistivity min(ThermalResistivity r) { // units maintained
if (r.lessThan(this)) return new ThermalResistivity(r.getX(),r.getU(),r.getUnits());
return new ThermalResistivity(this.getX(),this.getU(),this.getUnits());
}
public ThermalResistivity max(ThermalResistivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ThermalResistivity(r.getX(),r.getU(),r.getUnits());
return new ThermalResistivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ThermalResistivity mult(double r) {
return new ThermalResistivity(this.value.mult(new UReal(r)),this.getUnits());
}
public ThermalResistivity divideBy(double r) {
return new ThermalResistivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ThermalResistivity mult(UReal r) {
return new ThermalResistivity(this.value.mult(r),this.getUnits());
}
public ThermalResistivity divideBy(UReal r) {
return new ThermalResistivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ThermalResistivity clone() {
return new ThermalResistivity(this.getUReal(),this.getUnits());
}
}
