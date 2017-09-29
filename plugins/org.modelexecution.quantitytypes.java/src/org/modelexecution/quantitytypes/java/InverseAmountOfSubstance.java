package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class InverseAmountOfSubstance extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
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

public InverseAmountOfSubstance(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a InverseAmountOfSubstance");
this.unit = new Unit (q.unit);
}
public InverseAmountOfSubstance () {
value = new UReal();
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an InverseAmountOfSubstance");
this.unit = new Unit (unit);
}
public InverseAmountOfSubstance(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InverseAmountOfSubstance");
this.unit = new Unit (unit);
}
public InverseAmountOfSubstance(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InverseAmountOfSubstance");
this.unit = new Unit (unit);
}
public InverseAmountOfSubstance(String x) { //creates a InverseAmountOfSubstance from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance(String x, String u) { //creates a InverseAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.PerMole);
}
public InverseAmountOfSubstance(String x, String u, Unit unit) { //creates a InverseAmountOfSubstance from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InverseAmountOfSubstance");
this.unit = new Unit (unit);
}
// Specific Type Operations
public InverseAmountOfSubstance add(InverseAmountOfSubstance r) {  //only works if compatible units && operand has no offset
return new InverseAmountOfSubstance(super.add(r));
}
public InverseAmountOfSubstance minus(InverseAmountOfSubstance r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new InverseAmountOfSubstance(super.minus(r));
}
public Activity mult(CatalyticActivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Activity(super.mult(r));
}
public ElectricChargePerAmountOfSubstance mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.mult(r));
}
public MolarEnergy mult(EnergyAndWork r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public MolarHeatCapacity mult(HeatCapacityAndEntropy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarHeatCapacity(super.mult(r));
}
public ThermodynamicTemperature mult(TemperatureAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public MolarEnergy mult(BendingMomentOrTorque r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public UReal divideBy(InverseAmountOfSubstance r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AmountOfSubstance inverse() {
return new  AmountOfSubstance(super.inverse());
}
public InverseAmountOfSubstance abs() { //units are maintained
return new InverseAmountOfSubstance(super.abs());
}
public InverseAmountOfSubstance neg() { //units are maintained
return new InverseAmountOfSubstance(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(InverseAmountOfSubstance r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(InverseAmountOfSubstance r) {
return !(this.equals(r));
}
public InverseAmountOfSubstance floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new InverseAmountOfSubstance(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public InverseAmountOfSubstance round(){ //returns (i,u) with i the closest int to x -- units maintained
return new InverseAmountOfSubstance(Math.round(this.getX()),this.getU(),this.getUnits());
}
public InverseAmountOfSubstance min(InverseAmountOfSubstance r) { // units maintained
if (r.lessThan(this)) return new InverseAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new InverseAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
public InverseAmountOfSubstance max(InverseAmountOfSubstance r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new InverseAmountOfSubstance(r.getX(),r.getU(),r.getUnits());
return new InverseAmountOfSubstance(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public InverseAmountOfSubstance mult(double r) {
return new InverseAmountOfSubstance(this.value.mult(new UReal(r)),this.getUnits());
}
public InverseAmountOfSubstance divideBy(double r) {
return new InverseAmountOfSubstance(this.value.divideBy(new UReal(r)),this.getUnits());
}
public InverseAmountOfSubstance mult(UReal r) {
return new InverseAmountOfSubstance(this.value.mult(r),this.getUnits());
}
public InverseAmountOfSubstance divideBy(UReal r) {
return new InverseAmountOfSubstance(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public InverseAmountOfSubstance clone() {
return new InverseAmountOfSubstance(this.getUReal(),this.getUnits());
}
}
