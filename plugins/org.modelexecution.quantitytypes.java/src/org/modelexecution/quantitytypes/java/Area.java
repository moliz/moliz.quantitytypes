package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Area extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
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

public Area(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Area");
this.unit = new Unit (q.unit);
}
public Area () {
value = new UReal();
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Area");
this.unit = new Unit (unit);
}
public Area(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Area");
this.unit = new Unit (unit);
}
public Area(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Area");
this.unit = new Unit (unit);
}
public Area(String x) { //creates a Area from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area(String x, String u) { //creates a Area from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.SquareMeter);
}
public Area(String x, String u, Unit unit) { //creates a Area from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Area");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Area add(Area r) {  //only works if compatible units && operand has no offset
return new Area(super.add(r));
}
public Area minus(Area r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Area(super.minus(r));
}
public Volume mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public AngularMass mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public MagneticDipoleMoment mult(ElectricCurrent r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public AreaTemperature mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public KinematicViscosity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public MassPerUnitLength mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public LinearMomentum mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public ElectricDipoleMoment mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public ElectricChargeLineDensity mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public ElectricCurrent mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public ElectricCharge mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public Force mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyAndWork mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyAndWork mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public KinematicViscosity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public HeatFlowRate mult(HeatFlowRatePerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public LuminousFlux mult(Illuminance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LuminousFlux(super.mult(r));
}
public VolumeThermalExpansion mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.mult(r));
}
public VolumePerUnitTime mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public LuminousIntensity mult(Luminance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LuminousIntensity(super.mult(r));
}
public MagneticFlux mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public AngularMomentum mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public Mass mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public LengthMass mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public PowerPerAngle mult(PowerPerAreaAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new PowerPerAngle(super.mult(r));
}
public HeatFlowRate mult(PowerPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public Force mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public AreaAngle mult(SolidAngle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaAngle(super.mult(r));
}
public ThermalInsulance mult(ThermalResistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalInsulance(super.mult(r));
}
public Length divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public KinematicViscosity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public AreaThermalExpansion divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaThermalExpansion(super.divideBy(r));
}
public TimeSquared divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(AreaThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public TimeSquared divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Time divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public LinearThermalExpansion divideBy(LengthTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public LengthTemperature divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemperature(super.divideBy(r));
}
public TimeSquared divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public Time divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public AbsorbedDose divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public UReal divideBy(Area r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Length sqrt() {
return new  Length(super.sqrt());
}
public Area abs() { //units are maintained
return new Area(super.abs());
}
public Area neg() { //units are maintained
return new Area(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Area r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Area r) {
return !(this.equals(r));
}
public Area floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Area(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Area round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Area(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Area min(Area r) { // units maintained
if (r.lessThan(this)) return new Area(r.getX(),r.getU(),r.getUnits());
return new Area(this.getX(),this.getU(),this.getUnits());
}
public Area max(Area r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Area(r.getX(),r.getU(),r.getUnits());
return new Area(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Area mult(double r) {
return new Area(this.value.mult(new UReal(r)),this.getUnits());
}
public Area divideBy(double r) {
return new Area(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Area mult(UReal r) {
return new Area(this.value.mult(r),this.getUnits());
}
public Area divideBy(UReal r) {
return new Area(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Area clone() {
return new Area(this.getUReal(),this.getUnits());
}
}
