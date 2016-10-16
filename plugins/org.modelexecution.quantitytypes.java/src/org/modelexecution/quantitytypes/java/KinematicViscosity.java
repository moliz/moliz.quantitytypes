package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class KinematicViscosity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=-1.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public KinematicViscosity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a KinematicViscosity");
this.unit = new Unit (q.unit);
}
public KinematicViscosity () {
value = new UReal();
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an KinematicViscosity");
this.unit = new Unit (unit);
}
public KinematicViscosity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a KinematicViscosity");
this.unit = new Unit (unit);
}
public KinematicViscosity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a KinematicViscosity");
this.unit = new Unit (unit);
}
public KinematicViscosity(String x) { //creates a KinematicViscosity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity(String x, String u) { //creates a KinematicViscosity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeterPerSecond);
}
public KinematicViscosity(String x, String u, Unit unit) { //creates a KinematicViscosity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a KinematicViscosity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public KinematicViscosity add(KinematicViscosity r) {  //only works if compatible units && operand has no offset
return new KinematicViscosity(super.add(r));
}
public KinematicViscosity minus(KinematicViscosity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new KinematicViscosity(super.minus(r));
}
public VolumePerUnitTime mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public AngularMomentum mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public Area mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public AbsorbedDose mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public DynamicViscosity mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new DynamicViscosity(super.mult(r));
}
public Force mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public MagneticDipoleMoment mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public MagneticFieldStrength mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectricCurrent mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public HeatFlowRate mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public HeatFlowRate mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public AbsorbedDose mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public ElectromotiveForce mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public EnergyAndWork mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public MassPerUnitTime mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public LinearMomentum mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public ThermalConductivity mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public LinearVelocity divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public AbsorbedDose divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public Time divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public TimeSquared divideBy(AbsorbedDoseRate r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Area divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Activity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public Time divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public MagneticFlux divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public Area divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Exposure divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public Time divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public AbsorbedDoseRate divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.divideBy(r));
}
public KinematicViscosity abs() { //units are maintained
return new KinematicViscosity(super.abs());
}
public KinematicViscosity neg() { //units are maintained
return new KinematicViscosity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(KinematicViscosity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(KinematicViscosity r) {
return !(this.equals(r));
}
public KinematicViscosity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new KinematicViscosity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public KinematicViscosity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new KinematicViscosity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public KinematicViscosity min(KinematicViscosity r) { // units maintained
if (r.lessThan(this)) return new KinematicViscosity(r.getX(),r.getU(),r.getUnits());
return new KinematicViscosity(this.getX(),this.getU(),this.getUnits());
}
public KinematicViscosity max(KinematicViscosity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new KinematicViscosity(r.getX(),r.getU(),r.getUnits());
return new KinematicViscosity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public KinematicViscosity mult(double r) {
return new KinematicViscosity(this.value.mult(new UReal(r)),this.getUnits());
}
public KinematicViscosity divideBy(double r) {
return new KinematicViscosity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public KinematicViscosity mult(UReal r) {
return new KinematicViscosity(this.value.mult(r),this.getUnits());
}
public KinematicViscosity divideBy(UReal r) {
return new KinematicViscosity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public KinematicViscosity clone() {
return new KinematicViscosity(this.getUReal(),this.getUnits());
}
}
