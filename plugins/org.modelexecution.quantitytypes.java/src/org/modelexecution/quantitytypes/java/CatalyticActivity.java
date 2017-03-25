package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class CatalyticActivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-1.0;
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

public CatalyticActivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a CatalyticActivity");
this.unit = new Unit (q.unit);
}
public CatalyticActivity () {
value = new UReal();
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an CatalyticActivity");
this.unit = new Unit (unit);
}
public CatalyticActivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CatalyticActivity");
this.unit = new Unit (unit);
}
public CatalyticActivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CatalyticActivity");
this.unit = new Unit (unit);
}
public CatalyticActivity(String x) { //creates a CatalyticActivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity(String x, String u) { //creates a CatalyticActivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Katal);
}
public CatalyticActivity(String x, String u, Unit unit) { //creates a CatalyticActivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a CatalyticActivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public CatalyticActivity add(CatalyticActivity r) {  //only works if compatible units && operand has no offset
return new CatalyticActivity(super.add(r));
}
public CatalyticActivity minus(CatalyticActivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new CatalyticActivity(super.minus(r));
}
public AmountOfSubstance mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstance(super.mult(r));
}
public ElectricCurrent mult(ElectricChargePerAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public Activity mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Activity(super.mult(r));
}
public HeatFlowRate mult(MolarEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public Activity divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public AmountOfSubstance divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public VolumePerUnitTime divideBy(AmountOfSubstancePerUnitVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public MassPerUnitTime divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public AmountOfSubstance divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public AmountOfSubstancePerUnitVolume divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitVolume(super.divideBy(r));
}
public UReal divideBy(CatalyticActivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public CatalyticActivity abs() { //units are maintained
return new CatalyticActivity(super.abs());
}
public CatalyticActivity neg() { //units are maintained
return new CatalyticActivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(CatalyticActivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(CatalyticActivity r) {
return !(this.equals(r));
}
public CatalyticActivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new CatalyticActivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public CatalyticActivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new CatalyticActivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public CatalyticActivity min(CatalyticActivity r) { // units maintained
if (r.lessThan(this)) return new CatalyticActivity(r.getX(),r.getU(),r.getUnits());
return new CatalyticActivity(this.getX(),this.getU(),this.getUnits());
}
public CatalyticActivity max(CatalyticActivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new CatalyticActivity(r.getX(),r.getU(),r.getUnits());
return new CatalyticActivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public CatalyticActivity mult(double r) {
return new CatalyticActivity(this.value.mult(new UReal(r)),this.getUnits());
}
public CatalyticActivity divideBy(double r) {
return new CatalyticActivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public CatalyticActivity mult(UReal r) {
return new CatalyticActivity(this.value.mult(r),this.getUnits());
}
public CatalyticActivity divideBy(UReal r) {
return new CatalyticActivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public CatalyticActivity clone() {
return new CatalyticActivity(this.getUReal(),this.getUnits());
}
}
