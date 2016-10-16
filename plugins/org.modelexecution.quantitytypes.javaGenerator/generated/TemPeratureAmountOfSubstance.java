package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class TemPeratureAmountOfSubstance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public TemPeratureAmountOfSubstance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a TemPeratureAmountOfSubstance");
this.unit = new Unit (q.unit);
}
public TemPeratureAmountOfSubstance () {
value = new UReal();
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an TemPeratureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemPeratureAmountOfSubstance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemPeratureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemPeratureAmountOfSubstance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemPeratureAmountOfSubstance");
this.unit = new Unit (unit);
}
public TemPeratureAmountOfSubstance(String x) { //creates a TemPeratureAmountOfSubstance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance(String x, String u) { //creates a TemPeratureAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MoleKelvin);
}
public TemPeratureAmountOfSubstance(String x, String u, Unit unit) { //creates a TemPeratureAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a TemPeratureAmountOfSubstance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public TemPeratureAmountOfSubstance add(TemPeratureAmountOfSubstance r) {  //only works if compatible units && operand has no offset
return new TemPeratureAmountOfSubstance(super.add(r));
}
public TemPeratureAmountOfSubstance minus(TemPeratureAmountOfSubstance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new TemPeratureAmountOfSubstance(super.minus(r));
}
public ThermodynamicTemperature mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public EnergyAndWork mult(MolarHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AmountOfSubstance divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public MassTemPerature divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemPerature(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(MassTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public TemPeratureAmountOfSubstance abs() { //units are maintained
return new TemPeratureAmountOfSubstance(super.abs());
}
public TemPeratureAmountOfSubstance neg() { //units are maintained
return new TemPeratureAmountOfSubstance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(TemPeratureAmountOfSubstance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(TemPeratureAmountOfSubstance r) {
return !(this.equals(r));
}
public TemPeratureAmountOfSubstance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new TemPeratureAmountOfSubstance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public TemPeratureAmountOfSubstance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new TemPeratureAmountOfSubstance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public TemPeratureAmountOfSubstance min(TemPeratureAmountOfSubstance r) { // units maintained
if (r.lessThan(this)) return new TemPeratureAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new TemPeratureAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
public TemPeratureAmountOfSubstance max(TemPeratureAmountOfSubstance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new TemPeratureAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new TemPeratureAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public TemPeratureAmountOfSubstance mult(double r) {
return new TemPeratureAmountOfSubstance(this.value.mult(new UReal(r)),this.getUnits());
}
public TemPeratureAmountOfSubstance divideBy(double r) {
return new TemPeratureAmountOfSubstance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public TemPeratureAmountOfSubstance mult(UReal r) {
return new TemPeratureAmountOfSubstance(this.value.mult(r),this.getUnits());
}
public TemPeratureAmountOfSubstance divideBy(UReal r) {
return new TemPeratureAmountOfSubstance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public TemPeratureAmountOfSubstance clone() {
return new TemPeratureAmountOfSubstance(this.getUReal(),this.getUnits());
}
}
