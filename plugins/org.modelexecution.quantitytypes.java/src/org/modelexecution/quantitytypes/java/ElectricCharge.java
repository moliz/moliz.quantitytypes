package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricCharge extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=1.0;
x[BaseUnits.Ampere.ordinal()]=1.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ElectricCharge(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCharge");
this.unit = new Unit (q.unit);
}
public ElectricCharge () {
value = new UReal();
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCharge");
this.unit = new Unit (unit);
}
public ElectricCharge(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCharge");
this.unit = new Unit (unit);
}
public ElectricCharge(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCharge");
this.unit = new Unit (unit);
}
public ElectricCharge(String x) { //creates a ElectricCharge from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge(String x, String u) { //creates a ElectricCharge from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Coulomb);
}
public ElectricCharge(String x, String u, Unit unit) { //creates a ElectricCharge from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCharge");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricCharge add(ElectricCharge r) {  //only works if compatible units && operand has no offset
return new ElectricCharge(super.add(r));
}
public ElectricCharge minus(ElectricCharge r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricCharge(super.minus(r));
}
public ElectricDipoleMoment mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public ElectricCurrent mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public MagnetomotiveForce mult(AngularVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public Force mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyAndWork mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Force mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public ElectricCurrent mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricChargePerAmountOfSubstance mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.mult(r));
}
public MagneticDipoleMoment mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public AngularMomentum mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public MassPerUnitTime mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public MagneticFlux mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public MagneticDipoleMoment mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public ElectricChargeLineDensity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public Exposure divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricCurrent divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public Time divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public ElectricChargePerAmountOfSubstance divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.divideBy(r));
}
public ElectricFluxDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectromotiveForce divideBy(Capacitance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public Length divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Volume divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public AmountOfSubstance divideBy(ElectricChargePerAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public Area divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public Capacitance divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public Mass divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public ElectricalConductivity divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public UReal divideBy(ElectricCharge r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricCharge abs() { //units are maintained
return new ElectricCharge(super.abs());
}
public ElectricCharge neg() { //units are maintained
return new ElectricCharge(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricCharge r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricCharge r) {
return !(this.equals(r));
}
public ElectricCharge floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricCharge(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricCharge round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricCharge(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricCharge min(ElectricCharge r) { // units maintained
if (r.lessThan(this)) return new ElectricCharge(r.getX(),r.getU(),r.getUnits());
return new ElectricCharge(this.getX(),this.getU(),this.getUnits());
}
public ElectricCharge max(ElectricCharge r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricCharge(r.getX(),r.getU(),r.getUnits());
return new ElectricCharge(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricCharge mult(double r) {
return new ElectricCharge(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricCharge divideBy(double r) {
return new ElectricCharge(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricCharge mult(UReal r) {
return new ElectricCharge(this.value.mult(r),this.getUnits());
}
public ElectricCharge divideBy(UReal r) {
return new ElectricCharge(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricCharge clone() {
return new ElectricCharge(this.getUReal(),this.getUnits());
}
}
