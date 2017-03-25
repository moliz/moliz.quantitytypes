package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Angle extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=1.0;
x[BaseUnits.Candela.ordinal()]=0.0;
x[BaseUnits.Bit.ordinal()]=0.0;
x[BaseUnits.Shannon.ordinal()]=0.0;
x[BaseUnits.Erlang.ordinal()]=0.0;
x[BaseUnits.Decibel.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Angle(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
this.unit = new Unit (q.unit);
}
public Angle () {
value = new UReal();
unit = new Unit(BaseUnits.Radian);
}
public Angle(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Radian);
}
public Angle(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Angle");
this.unit = new Unit (unit);
}
public Angle(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Radian);
}
public Angle (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Radian);
}
public Angle(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
this.unit = new Unit (unit);
}
public Angle(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
this.unit = new Unit (unit);
}
public Angle(String x) { //creates a Angle from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Radian);
}
public Angle(String x, String u) { //creates a Angle from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Radian);
}
public Angle(String x, String u, Unit unit) { //creates a Angle from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Angle");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Angle add(Angle r) {  //only works if compatible units && operand has no offset
return new Angle(super.add(r));
}
public Angle minus(Angle r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Angle(super.minus(r));
}
public MagnetomotiveForce mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public SolidAngle mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new SolidAngle(super.mult(r));
}
public LuminousFlux mult(LuminousIntensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LuminousFlux(super.mult(r));
}
public AngularVelocity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularVelocity(super.mult(r));
}
public ElectricCurrent mult(CurrentPerAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public AngularVelocity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularVelocity(super.mult(r));
}
public Illuminance mult(Luminance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Illuminance(super.mult(r));
}
public AngularVelocity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularVelocity(super.divideBy(r));
}
public TimeSquared divideBy(AngularAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Time divideBy(AngularVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public AngularAcceleration divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularAcceleration(super.divideBy(r));
}
public UReal divideBy(Angle r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Angle abs() { //units are maintained
return new Angle(super.abs());
}
public Angle neg() { //units are maintained
return new Angle(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Angle r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Angle r) {
return !(this.equals(r));
}
public Angle floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Angle(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Angle round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Angle(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Angle min(Angle r) { // units maintained
if (r.lessThan(this)) return new Angle(r.getX(),r.getU(),r.getUnits());
return new Angle(this.getX(),this.getU(),this.getUnits());
}
public Angle max(Angle r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Angle(r.getX(),r.getU(),r.getUnits());
return new Angle(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Angle mult(double r) {
return new Angle(this.value.mult(new UReal(r)),this.getUnits());
}
public Angle divideBy(double r) {
return new Angle(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Angle mult(UReal r) {
return new Angle(this.value.mult(r),this.getUnits());
}
public Angle divideBy(UReal r) {
return new Angle(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Angle clone() {
return new Angle(this.getUReal(),this.getUnits());
}
}
