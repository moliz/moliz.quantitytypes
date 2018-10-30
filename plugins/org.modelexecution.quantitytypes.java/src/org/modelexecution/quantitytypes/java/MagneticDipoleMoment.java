package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MagneticDipoleMoment extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MagneticDipoleMoment(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticDipoleMoment");
this.unit = new Unit (q.unit);
}
public MagneticDipoleMoment () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MagneticDipoleMoment");
this.unit = new Unit (unit);
}
public MagneticDipoleMoment(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticDipoleMoment");
this.unit = new Unit (unit);
}
public MagneticDipoleMoment(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticDipoleMoment");
this.unit = new Unit (unit);
}
public MagneticDipoleMoment(String x) { //creates a MagneticDipoleMoment from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment(String x, String u) { //creates a MagneticDipoleMoment from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerTesla);
}
public MagneticDipoleMoment(String x, String u, Unit unit) { //creates a MagneticDipoleMoment from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MagneticDipoleMoment");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MagneticDipoleMoment add(MagneticDipoleMoment r) {  //only works if compatible units && operand has no offset
return new MagneticDipoleMoment(super.add(r));
}
public MagneticDipoleMoment minus(MagneticDipoleMoment r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MagneticDipoleMoment(super.minus(r));
}
public EnergyAndWork mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Area divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Exposure divideBy(AngularMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricCurrent divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public KinematicViscosity divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public VolumePerUnitTime divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public LinearVelocity divideBy(ElectricDipoleMoment r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public AngularMomentum divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMomentum(super.divideBy(r));
}
public ElectricCharge divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public ElectricDipoleMoment divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.divideBy(r));
}
public Volume divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public ElectricCharge divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public MagneticFieldStrength divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public UReal divideBy(MagneticDipoleMoment r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public MagneticDipoleMoment abs() { //units are maintained
return new MagneticDipoleMoment(super.abs());
}
public MagneticDipoleMoment neg() { //units are maintained
return new MagneticDipoleMoment(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MagneticDipoleMoment r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MagneticDipoleMoment r) {
return !(this.equals(r));
}
public MagneticDipoleMoment floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MagneticDipoleMoment(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MagneticDipoleMoment round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MagneticDipoleMoment(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MagneticDipoleMoment min(MagneticDipoleMoment r) { // units maintained
if (r.lt(this)) return new MagneticDipoleMoment(r.getX(),r.getU(),r.getUnits());
return new MagneticDipoleMoment(this.getX(),this.getU(),this.getUnits());
}
public MagneticDipoleMoment max(MagneticDipoleMoment r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MagneticDipoleMoment(r.getX(),r.getU(),r.getUnits());
return new MagneticDipoleMoment(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MagneticDipoleMoment mult(double r) {
return new MagneticDipoleMoment(this.value.mult(new UReal(r)),this.getUnits());
}
public MagneticDipoleMoment divideBy(double r) {
return new MagneticDipoleMoment(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MagneticDipoleMoment mult(UReal r) {
return new MagneticDipoleMoment(this.value.mult(r),this.getUnits());
}
public MagneticDipoleMoment divideBy(UReal r) {
return new MagneticDipoleMoment(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MagneticDipoleMoment clone() {
return new MagneticDipoleMoment(this.getUReal(),this.getUnits());
}
}
