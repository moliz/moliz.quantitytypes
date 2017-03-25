package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricChargePerAmountOfSubstance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=1.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=-1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ElectricChargePerAmountOfSubstance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargePerAmountOfSubstance");
this.unit = new Unit (q.unit);
}
public ElectricChargePerAmountOfSubstance () {
value = new UReal();
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricChargePerAmountOfSubstance");
this.unit = new Unit (unit);
}
public ElectricChargePerAmountOfSubstance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargePerAmountOfSubstance");
this.unit = new Unit (unit);
}
public ElectricChargePerAmountOfSubstance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargePerAmountOfSubstance");
this.unit = new Unit (unit);
}
public ElectricChargePerAmountOfSubstance(String x) { //creates a ElectricChargePerAmountOfSubstance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance(String x, String u) { //creates a ElectricChargePerAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.CoulombPerMole);
}
public ElectricChargePerAmountOfSubstance(String x, String u, Unit unit) { //creates a ElectricChargePerAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricChargePerAmountOfSubstance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricChargePerAmountOfSubstance add(ElectricChargePerAmountOfSubstance r) {  //only works if compatible units && operand has no offset
return new ElectricChargePerAmountOfSubstance(super.add(r));
}
public ElectricChargePerAmountOfSubstance minus(ElectricChargePerAmountOfSubstance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricChargePerAmountOfSubstance(super.minus(r));
}
public ElectricCharge mult(AmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricChargeVolumeDensity mult(AmountOfSubstancePerUnitVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.mult(r));
}
public Exposure mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Exposure(super.mult(r));
}
public ElectricCurrent mult(CatalyticActivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MolarEnergy mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public InverseAmountOfSubstance divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public ElectricCharge divideBy(InverseAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public UReal divideBy(ElectricChargePerAmountOfSubstance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricChargePerAmountOfSubstance abs() { //units are maintained
return new ElectricChargePerAmountOfSubstance(super.abs());
}
public ElectricChargePerAmountOfSubstance neg() { //units are maintained
return new ElectricChargePerAmountOfSubstance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricChargePerAmountOfSubstance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricChargePerAmountOfSubstance r) {
return !(this.equals(r));
}
public ElectricChargePerAmountOfSubstance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricChargePerAmountOfSubstance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargePerAmountOfSubstance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricChargePerAmountOfSubstance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricChargePerAmountOfSubstance min(ElectricChargePerAmountOfSubstance r) { // units maintained
if (r.lessThan(this)) return new ElectricChargePerAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new ElectricChargePerAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
public ElectricChargePerAmountOfSubstance max(ElectricChargePerAmountOfSubstance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricChargePerAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new ElectricChargePerAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricChargePerAmountOfSubstance mult(double r) {
return new ElectricChargePerAmountOfSubstance(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricChargePerAmountOfSubstance divideBy(double r) {
return new ElectricChargePerAmountOfSubstance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricChargePerAmountOfSubstance mult(UReal r) {
return new ElectricChargePerAmountOfSubstance(this.value.mult(r),this.getUnits());
}
public ElectricChargePerAmountOfSubstance divideBy(UReal r) {
return new ElectricChargePerAmountOfSubstance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricChargePerAmountOfSubstance clone() {
return new ElectricChargePerAmountOfSubstance(this.getUReal(),this.getUnits());
}
}
