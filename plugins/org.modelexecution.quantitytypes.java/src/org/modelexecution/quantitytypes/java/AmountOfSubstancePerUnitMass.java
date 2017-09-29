package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AmountOfSubstancePerUnitMass extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=-1.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AmountOfSubstancePerUnitMass(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitMass");
this.unit = new Unit (q.unit);
}
public AmountOfSubstancePerUnitMass () {
value = new UReal();
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AmountOfSubstancePerUnitMass");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitMass(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitMass");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitMass(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitMass");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitMass(String x) { //creates a AmountOfSubstancePerUnitMass from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass(String x, String u) { //creates a AmountOfSubstancePerUnitMass from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MolePerKilogram);
}
public AmountOfSubstancePerUnitMass(String x, String u, Unit unit) { //creates a AmountOfSubstancePerUnitMass from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitMass");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AmountOfSubstancePerUnitMass add(AmountOfSubstancePerUnitMass r) {  //only works if compatible units && operand has no offset
return new AmountOfSubstancePerUnitMass(super.add(r));
}
public AmountOfSubstancePerUnitMass minus(AmountOfSubstancePerUnitMass r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AmountOfSubstancePerUnitMass(super.minus(r));
}
public AmountOfSubstance mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstance(super.mult(r));
}
public AmountOfSubstancePerUnitVolume mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.mult(r));
}
public Exposure mult(ElectricChargePerAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Exposure(super.mult(r));
}
public TemperatureAmountOfSubstance mult(MassTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TemperatureAmountOfSubstance(super.mult(r));
}
public CatalyticActivity mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CatalyticActivity(super.mult(r));
}
public AbsorbedDose mult(MolarEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public SpecificHeatCapacity mult(MolarHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public UReal divideBy(AmountOfSubstancePerUnitMass r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AmountOfSubstancePerUnitMass abs() { //units are maintained
return new AmountOfSubstancePerUnitMass(super.abs());
}
public AmountOfSubstancePerUnitMass neg() { //units are maintained
return new AmountOfSubstancePerUnitMass(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AmountOfSubstancePerUnitMass r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AmountOfSubstancePerUnitMass r) {
return !(this.equals(r));
}
public AmountOfSubstancePerUnitMass floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AmountOfSubstancePerUnitMass(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitMass round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AmountOfSubstancePerUnitMass(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitMass min(AmountOfSubstancePerUnitMass r) { // units maintained
if (r.lessThan(this)) return new AmountOfSubstancePerUnitMass(r.getX(),r.getU(),r.getUnits());
return new AmountOfSubstancePerUnitMass(this.getX(),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitMass max(AmountOfSubstancePerUnitMass r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AmountOfSubstancePerUnitMass(r.getX(),r.getU(),r.getUnits());
return new AmountOfSubstancePerUnitMass(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AmountOfSubstancePerUnitMass mult(double r) {
return new AmountOfSubstancePerUnitMass(this.value.mult(new UReal(r)),this.getUnits());
}
public AmountOfSubstancePerUnitMass divideBy(double r) {
return new AmountOfSubstancePerUnitMass(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AmountOfSubstancePerUnitMass mult(UReal r) {
return new AmountOfSubstancePerUnitMass(this.value.mult(r),this.getUnits());
}
public AmountOfSubstancePerUnitMass divideBy(UReal r) {
return new AmountOfSubstancePerUnitMass(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AmountOfSubstancePerUnitMass clone() {
return new AmountOfSubstancePerUnitMass(this.getUReal(),this.getUnits());
}
}
