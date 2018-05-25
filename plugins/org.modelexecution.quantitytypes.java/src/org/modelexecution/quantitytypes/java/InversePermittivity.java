package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class InversePermittivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=3.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-4.0;
x[BaseUnits.Ampere.ordinal()]=-2.0;
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

public InversePermittivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a InversePermittivity");
this.unit = new Unit (q.unit);
}
public InversePermittivity () {
value = new UReal();
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an InversePermittivity");
this.unit = new Unit (unit);
}
public InversePermittivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InversePermittivity");
this.unit = new Unit (unit);
}
public InversePermittivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InversePermittivity");
this.unit = new Unit (unit);
}
public InversePermittivity(String x) { //creates a InversePermittivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity(String x, String u) { //creates a InversePermittivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.MeterPerFarad);
}
public InversePermittivity(String x, String u, Unit unit) { //creates a InversePermittivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a InversePermittivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public InversePermittivity add(InversePermittivity r) {  //only works if compatible units && operand has no offset
return new InversePermittivity(super.add(r));
}
public InversePermittivity minus(InversePermittivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new InversePermittivity(super.minus(r));
}
public Length mult(Capacitance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public ElectromotiveForce mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public ElectricFieldStrength mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFieldStrength(super.mult(r));
}
public LinearVelocity mult(ElectricalConductivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public Permeability divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public Permeability divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public LinearAcceleration divideBy(Inductance r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Inductance divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public Resistance divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Resistance(super.divideBy(r));
}
public AbsorbedDose divideBy(Permeability r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public LinearVelocity divideBy(Resistance r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Permeability divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new Permeability(super.divideBy(r));
}
public Inductance divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new Inductance(super.divideBy(r));
}
public UReal divideBy(InversePermittivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Permittivity inverse() {
return new  Permittivity(super.inverse());
}
public InversePermittivity abs() { //units are maintained
return new InversePermittivity(super.abs());
}
public InversePermittivity neg() { //units are maintained
return new InversePermittivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(InversePermittivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(InversePermittivity r) {
return !(this.equals(r));
}
public InversePermittivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new InversePermittivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public InversePermittivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new InversePermittivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public InversePermittivity min(InversePermittivity r) { // units maintained
if (r.lt(this)) return new InversePermittivity(r.getX(),r.getU(),r.getUnits());
return new InversePermittivity(this.getX(),this.getU(),this.getUnits());
}
public InversePermittivity max(InversePermittivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new InversePermittivity(r.getX(),r.getU(),r.getUnits());
return new InversePermittivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public InversePermittivity mult(double r) {
return new InversePermittivity(this.value.mult(new UReal(r)),this.getUnits());
}
public InversePermittivity divideBy(double r) {
return new InversePermittivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public InversePermittivity mult(UReal r) {
return new InversePermittivity(this.value.mult(r),this.getUnits());
}
public InversePermittivity divideBy(UReal r) {
return new InversePermittivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public InversePermittivity clone() {
return new InversePermittivity(this.getUReal(),this.getUnits());
}
}
