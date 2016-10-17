package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MolarHeatCapacity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=-1.0;
x[BaseUnits.Mole.ordinal()]=-1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MolarHeatCapacity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MolarHeatCapacity");
this.unit = new Unit (q.unit);
}
public MolarHeatCapacity () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MolarHeatCapacity");
this.unit = new Unit (unit);
}
public MolarHeatCapacity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarHeatCapacity");
this.unit = new Unit (unit);
}
public MolarHeatCapacity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarHeatCapacity");
this.unit = new Unit (unit);
}
public MolarHeatCapacity(String x) { //creates a MolarHeatCapacity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity(String x, String u) { //creates a MolarHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerMoleKelvin);
}
public MolarHeatCapacity(String x, String u, Unit unit) { //creates a MolarHeatCapacity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarHeatCapacity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MolarHeatCapacity add(MolarHeatCapacity r) {  //only works if compatible units && operand has no offset
return new MolarHeatCapacity(super.add(r));
}
public MolarHeatCapacity minus(MolarHeatCapacity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MolarHeatCapacity(super.minus(r));
}
public MolarEnergy mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public HeatCapacityAndEntropy mult(AmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.mult(r));
}
public VolumetricHeatCapacity mult(AmountOfSubstancePerUnitVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.mult(r));
}
public SpecificHeatCapacity mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.mult(r));
}
public EnergyAndWork mult(TemperatureAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public InverseAmountOfSubstance divideBy(HeatCapacityAndEntropy r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public HeatCapacityAndEntropy divideBy(InverseAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.divideBy(r));
}
public UReal divideBy(MolarHeatCapacity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MolarHeatCapacity abs() { //units are maintained
return new MolarHeatCapacity(super.abs());
}
public MolarHeatCapacity neg() { //units are maintained
return new MolarHeatCapacity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MolarHeatCapacity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MolarHeatCapacity r) {
return !(this.equals(r));
}
public MolarHeatCapacity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MolarHeatCapacity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MolarHeatCapacity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MolarHeatCapacity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MolarHeatCapacity min(MolarHeatCapacity r) { // units maintained
if (r.lessThan(this)) return new MolarHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new MolarHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
public MolarHeatCapacity max(MolarHeatCapacity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MolarHeatCapacity(r.getX(),r.getU(),r.getUnits());
return new MolarHeatCapacity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MolarHeatCapacity mult(double r) {
return new MolarHeatCapacity(this.value.mult(new UReal(r)),this.getUnits());
}
public MolarHeatCapacity divideBy(double r) {
return new MolarHeatCapacity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MolarHeatCapacity mult(UReal r) {
return new MolarHeatCapacity(this.value.mult(r),this.getUnits());
}
public MolarHeatCapacity divideBy(UReal r) {
return new MolarHeatCapacity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MolarHeatCapacity clone() {
return new MolarHeatCapacity(this.getUReal(),this.getUnits());
}
}
