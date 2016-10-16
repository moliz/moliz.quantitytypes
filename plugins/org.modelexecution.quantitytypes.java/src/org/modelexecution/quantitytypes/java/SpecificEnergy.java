package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class SpecificEnergy extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public SpecificEnergy(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a SpecificEnergy");
this.unit = new Unit (q.unit);
}
public SpecificEnergy () {
value = new UReal();
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an SpecificEnergy");
this.unit = new Unit (unit);
}
public SpecificEnergy(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificEnergy");
this.unit = new Unit (unit);
}
public SpecificEnergy(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificEnergy");
this.unit = new Unit (unit);
}
public SpecificEnergy(String x) { //creates a SpecificEnergy from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy(String x, String u) { //creates a SpecificEnergy from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.JoulePerKilogram);
}
public SpecificEnergy(String x, String u, Unit unit) { //creates a SpecificEnergy from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a SpecificEnergy");
this.unit = new Unit (unit);
}
// Specific Type Operations
public SpecificEnergy add(SpecificEnergy r) {  //only works if compatible units && operand has no offset
return new SpecificEnergy(super.add(r));
}
public SpecificEnergy minus(SpecificEnergy r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new SpecificEnergy(super.minus(r));
}
public EnergyAndWork mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public KinematicViscosity mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public AbsorbedDoseRate mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public EnergyDensity mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public AbsorbedDoseRate mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.mult(r));
}
public HeatFlowRate mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public EnergyPerUnitArea mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public Force mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public InversePermittivity mult(Permeability r) { //both values and units are multiplied. No offsets allowed in any of the units
return new InversePermittivity(super.mult(r));
}
public Area mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public LinearAcceleration divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public AbsorbedDoseRate divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.divideBy(r));
}
public SpecificHeatCapacity divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public Time divideBy(AbsorbedDoseRate r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public KinematicViscosity divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public MolarEnergy divideBy(AmountOfSubstancePerUnitMass r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarEnergy(super.divideBy(r));
}
public Exposure divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectromotiveForce divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public KinematicViscosity divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public MassPerUnitLength divideBy(GravitationalAttraction r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitLength(super.divideBy(r));
}
public Activity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Length divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LinearVelocity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public GravitationalAttraction divideBy(MassPerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new GravitationalAttraction(super.divideBy(r));
}
public AmountOfSubstancePerUnitMass divideBy(MolarEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstancePerUnitMass(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Activity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Length divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public LinearVelocity sqrt() {
return new  LinearVelocity(super.sqrt());
}
public SpecificEnergy abs() { //units are maintained
return new SpecificEnergy(super.abs());
}
public SpecificEnergy neg() { //units are maintained
return new SpecificEnergy(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(SpecificEnergy r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(SpecificEnergy r) {
return !(this.equals(r));
}
public SpecificEnergy floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new SpecificEnergy(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public SpecificEnergy round(){ //returns (i,u) with i the closest int to x -- units maintained
return new SpecificEnergy(Math.round(this.getX()),this.getU(),this.getUnits());
}
public SpecificEnergy min(SpecificEnergy r) { // units maintained
if (r.lessThan(this)) return new SpecificEnergy(r.getX(),r.getU(),r.getUnits());
return new SpecificEnergy(this.getX(),this.getU(),this.getUnits());
}
public SpecificEnergy max(SpecificEnergy r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new SpecificEnergy(r.getX(),r.getU(),r.getUnits());
return new SpecificEnergy(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public SpecificEnergy mult(double r) {
return new SpecificEnergy(this.value.mult(new UReal(r)),this.getUnits());
}
public SpecificEnergy divideBy(double r) {
return new SpecificEnergy(this.value.divideBy(new UReal(r)),this.getUnits());
}
public SpecificEnergy mult(UReal r) {
return new SpecificEnergy(this.value.mult(r),this.getUnits());
}
public SpecificEnergy divideBy(UReal r) {
return new SpecificEnergy(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public SpecificEnergy clone() {
return new SpecificEnergy(this.getUReal(),this.getUnits());
}
}
