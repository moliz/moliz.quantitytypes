package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class AmountOfSubstancePerUnitVolume extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=-3.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public AmountOfSubstancePerUnitVolume(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitVolume");
this.unit = new Unit (q.unit);
}
public AmountOfSubstancePerUnitVolume () {
value = new UReal();
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an AmountOfSubstancePerUnitVolume");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitVolume(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitVolume");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitVolume(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitVolume");
this.unit = new Unit (unit);
}
public AmountOfSubstancePerUnitVolume(String x) { //creates a AmountOfSubstancePerUnitVolume from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume(String x, String u) { //creates a AmountOfSubstancePerUnitVolume from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MolePerCubicMeter);
}
public AmountOfSubstancePerUnitVolume(String x, String u, Unit unit) { //creates a AmountOfSubstancePerUnitVolume from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a AmountOfSubstancePerUnitVolume");
this.unit = new Unit (unit);
}
// Specific Type Operations
public AmountOfSubstancePerUnitVolume add(AmountOfSubstancePerUnitVolume r) {  //only works if compatible units && operand has no offset
return new AmountOfSubstancePerUnitVolume(super.add(r));
}
public AmountOfSubstancePerUnitVolume minus(AmountOfSubstancePerUnitVolume r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new AmountOfSubstancePerUnitVolume(super.minus(r));
}
public ElectricChargeVolumeDensity mult(ElectricChargePerAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.mult(r));
}
public EnergyDensity mult(MolarEnergy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public VolumetricHeatCapacity mult(MolarHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public AmountOfSubstance mult(Volume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AmountOfSubstance(super.mult(r));
}
public CatalyticActivity mult(VolumePerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new CatalyticActivity(super.mult(r));
}
public Density divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new Density(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(Density r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public UReal divideBy(AmountOfSubstancePerUnitVolume r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public AmountOfSubstancePerUnitVolume abs() { //units are maintained
return new AmountOfSubstancePerUnitVolume(super.abs());
}
public AmountOfSubstancePerUnitVolume neg() { //units are maintained
return new AmountOfSubstancePerUnitVolume(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(AmountOfSubstancePerUnitVolume r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(AmountOfSubstancePerUnitVolume r) {
return !(this.equals(r));
}
public AmountOfSubstancePerUnitVolume floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new AmountOfSubstancePerUnitVolume(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitVolume round(){ //returns (i,u) with i the closest int to x -- units maintained
return new AmountOfSubstancePerUnitVolume(Math.round(this.getX()),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitVolume min(AmountOfSubstancePerUnitVolume r) { // units maintained
if (r.lessThan(this)) return new AmountOfSubstancePerUnitVolume(r.getX(),r.getU(),r.getUnits());
return new AmountOfSubstancePerUnitVolume(this.getX(),this.getU(),this.getUnits());
}
public AmountOfSubstancePerUnitVolume max(AmountOfSubstancePerUnitVolume r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new AmountOfSubstancePerUnitVolume(r.getX(),r.getU(),r.getUnits());
return new AmountOfSubstancePerUnitVolume(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public AmountOfSubstancePerUnitVolume mult(double r) {
return new AmountOfSubstancePerUnitVolume(this.value.mult(new UReal(r)),this.getUnits());
}
public AmountOfSubstancePerUnitVolume divideBy(double r) {
return new AmountOfSubstancePerUnitVolume(this.value.divideBy(new UReal(r)),this.getUnits());
}
public AmountOfSubstancePerUnitVolume mult(UReal r) {
return new AmountOfSubstancePerUnitVolume(this.value.mult(r),this.getUnits());
}
public AmountOfSubstancePerUnitVolume divideBy(UReal r) {
return new AmountOfSubstancePerUnitVolume(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public AmountOfSubstancePerUnitVolume clone() {
return new AmountOfSubstancePerUnitVolume(this.getUReal(),this.getUnits());
}
}
