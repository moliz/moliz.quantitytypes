package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Power extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
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

public Power(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Power");
this.unit = new Unit (q.unit);
}
public Power () {
value = new UReal();
unit = new Unit(DerivedUnits.Watt);
}
public Power(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Watt);
}
public Power(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Power");
this.unit = new Unit (unit);
}
public Power(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Watt);
}
public Power (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Watt);
}
public Power(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Power");
this.unit = new Unit (unit);
}
public Power(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Power");
this.unit = new Unit (unit);
}
public Power(String x) { //creates a Power from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Watt);
}
public Power(String x, String u) { //creates a Power from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Watt);
}
public Power(String x, String u, Unit unit) { //creates a Power from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Power");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Power add(Power r) {  //only works if compatible units && operand has no offset
return new Power(super.add(r));
}
public Power minus(Power r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Power(super.minus(r));
}
public EnergyAndWork mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public AreaTemperature mult(ThermalInsulance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public ThermodynamicTemperature mult(ThermalResistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public LengthTemperature mult(ThermalResistivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthTemperature(super.mult(r));
}
public AngularMomentum mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public AbsorbedDoseRate divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public MassPerUnitTime divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public Mass divideBy(AbsorbedDoseRate r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public EnergyAndWork divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyAndWork(super.divideBy(r));
}
public HeatFlowRatePerUnitArea divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.divideBy(r));
}
public PowerPerAreaAngle divideBy(AreaAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new PowerPerAreaAngle(super.divideBy(r));
}
public CoefficientOfHeatTransfer divideBy(AreaTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.divideBy(r));
}
public MolarEnergy divideBy(CatalyticActivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarEnergy(super.divideBy(r));
}
public AreaTemperature divideBy(CoefficientOfHeatTransfer r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaTemperature(super.divideBy(r));
}
public MassPerUnitTime divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public ElectricCurrent divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public VolumePerUnitTime divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public Activity divideBy(EnergyAndWork r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public KinematicViscosity divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public LinearVelocity divideBy(Force r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public KinematicViscosity divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public EnergyAndWork divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyAndWork(super.divideBy(r));
}
public Area divideBy(HeatFlowRatePerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public ThermalConductivity divideBy(LengthTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalConductivity(super.divideBy(r));
}
public LinearMomentum divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public LinearAcceleration divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Force divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Force(super.divideBy(r));
}
public AbsorbedDose divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public CatalyticActivity divideBy(MolarEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new CatalyticActivity(super.divideBy(r));
}
public SolidAngle divideBy(PowerPerAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new SolidAngle(super.divideBy(r));
}
public AreaAngle divideBy(PowerPerAreaAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new AreaAngle(super.divideBy(r));
}
public Area divideBy(PowerPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public VolumePerUnitTime divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public PowerPerAngle divideBy(SolidAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new PowerPerAngle(super.divideBy(r));
}
public MassPerUnitTime divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public LengthTemperature divideBy(ThermalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthTemperature(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public LinearMomentum divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public Activity divideBy(BendingMomentOrTorque r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public EnergyDensity divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public UReal divideBy(Power r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public Power abs() { //units are maintained
return new Power(super.abs());
}
public Power neg() { //units are maintained
return new Power(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Power r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Power r) {
return !(this.equals(r));
}
public Power floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Power(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Power round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Power(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Power min(Power r) { // units maintained
if (r.lt(this)) return new Power(r.getX(),r.getU(),r.getUnits());
return new Power(this.getX(),this.getU(),this.getUnits());
}
public Power max(Power r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Power(r.getX(),r.getU(),r.getUnits());
return new Power(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Power mult(double r) {
return new Power(this.value.mult(new UReal(r)),this.getUnits());
}
public Power divideBy(double r) {
return new Power(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Power mult(UReal r) {
return new Power(this.value.mult(r),this.getUnits());
}
public Power divideBy(UReal r) {
return new Power(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Power clone() {
return new Power(this.getUReal(),this.getUnits());
}
}
