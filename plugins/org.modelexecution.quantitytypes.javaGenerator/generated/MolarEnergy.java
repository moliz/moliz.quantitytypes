package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class MolarEnergy extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=-1.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public MolarEnergy(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MolarEnergy");
this.unit = new Unit (q.unit);
}
public MolarEnergy () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an MolarEnergy");
this.unit = new Unit (unit);
}
public MolarEnergy(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarEnergy");
this.unit = new Unit (unit);
}
public MolarEnergy(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarEnergy");
this.unit = new Unit (unit);
}
public MolarEnergy(String x) { //creates a MolarEnergy from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy(String x, String u) { //creates a MolarEnergy from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerMole);
}
public MolarEnergy(String x, String u, Unit unit) { //creates a MolarEnergy from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a MolarEnergy");
this.unit = new Unit (unit);
}
// Specific Type Operations
public MolarEnergy add(MolarEnergy r) {  //only works if compatible units && operand has no offset
return new MolarEnergy(super.add(r));
}
public MolarEnergy minus(MolarEnergy r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new MolarEnergy(super.minus(r));
}
public EnergyAndWork mult(AmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyDensity mult(AmountOfSubstancePerUnitVolume r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public AbsorbedDose mult(AmountOfSubstancePerUnitMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public HeatFlowRate mult(CatalyticActivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public MolarHeatCapacity divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarHeatCapacity(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricChargePerAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricChargePerAmountOfSubstance divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.divideBy(r));
}
public InverseAmountOfSubstance divideBy(EnergyAndWork r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public EnergyAndWork divideBy(InverseAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyAndWork(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(MolarHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public InverseAmountOfSubstance divideBy(BendingMomentOrTorque r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public MolarEnergy abs() { //units are maintained
return new MolarEnergy(super.abs());
}
public MolarEnergy neg() { //units are maintained
return new MolarEnergy(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(MolarEnergy r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(MolarEnergy r) {
return !(this.equals(r));
}
public MolarEnergy floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new MolarEnergy(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public MolarEnergy round(){ //returns (i,u) with i the closest int to x -- units maintained
return new MolarEnergy(Math.round(this.getX()),this.getU(),this.getUnits());
}
public MolarEnergy min(MolarEnergy r) { // units maintained
if (r.lessThan(this)) return new MolarEnergy(r.getX(),r.getU(),r.getUnits());
return new MolarEnergy(this.getX(),this.getU(),this.getUnits());
}
public MolarEnergy max(MolarEnergy r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new MolarEnergy(r.getX(),r.getU(),r.getUnits());
return new MolarEnergy(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public MolarEnergy mult(double r) {
return new MolarEnergy(this.value.mult(new UReal(r)),this.getUnits());
}
public MolarEnergy divideBy(double r) {
return new MolarEnergy(this.value.divideBy(new UReal(r)),this.getUnits());
}
public MolarEnergy mult(UReal r) {
return new MolarEnergy(this.value.mult(r),this.getUnits());
}
public MolarEnergy divideBy(UReal r) {
return new MolarEnergy(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public MolarEnergy clone() {
return new MolarEnergy(this.getUReal(),this.getUnits());
}
}
