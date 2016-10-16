package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class PowerPerUnitArea extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public PowerPerUnitArea(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerUnitArea");
this.unit = new Unit (q.unit);
}
public PowerPerUnitArea () {
value = new UReal();
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an PowerPerUnitArea");
this.unit = new Unit (unit);
}
public PowerPerUnitArea(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerUnitArea");
this.unit = new Unit (unit);
}
public PowerPerUnitArea(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerUnitArea");
this.unit = new Unit (unit);
}
public PowerPerUnitArea(String x) { //creates a PowerPerUnitArea from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea(String x, String u) { //creates a PowerPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerSquareMeter);
}
public PowerPerUnitArea(String x, String u, Unit unit) { //creates a PowerPerUnitArea from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerUnitArea");
this.unit = new Unit (unit);
}
// Specific Type Operations
public PowerPerUnitArea add(PowerPerUnitArea r) {  //only works if compatible units && operand has no offset
return new PowerPerUnitArea(super.add(r));
}
public PowerPerUnitArea minus(PowerPerUnitArea r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new PowerPerUnitArea(super.minus(r));
}
public EnergyPerUnitArea mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public HeatFlowrate mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowrate(super.mult(r));
}
public ThermalConductivity mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public ThermodynamicTemperature mult(ThermalInsulance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.mult(r));
}
public MassPerUnitTime mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public CoefficientOfHeatTransfer divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.divideBy(r));
}
public MassPerUnitArea divideBy(AbsorbedDoseRate r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitArea(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(CoefficientOfHeatTransfer r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public LinearAcceleration divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public MagneticFieldStrength divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public ElectricCurrentDensity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public LinearVelocity divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public Activity divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public MagneticFieldStrength divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public Activity divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public DynamicViscosity divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public EnergyDensity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public ElectricFieldStrength divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public AbsorbedDoseRate divideBy(MassPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDoseRate(super.divideBy(r));
}
public SolidAngle divideBy(PowerPerAreaAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new SolidAngle(super.divideBy(r));
}
public LinearVelocity divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public PowerPerAreaAngle divideBy(SolidAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new PowerPerAreaAngle(super.divideBy(r));
}
public DynamicViscosity divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public PowerPerUnitArea abs() { //units are maintained
return new PowerPerUnitArea(super.abs());
}
public PowerPerUnitArea neg() { //units are maintained
return new PowerPerUnitArea(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(PowerPerUnitArea r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(PowerPerUnitArea r) {
return !(this.equals(r));
}
public PowerPerUnitArea floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new PowerPerUnitArea(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public PowerPerUnitArea round(){ //returns (i,u) with i the closest int to x -- units maintained
return new PowerPerUnitArea(Math.round(this.getX()),this.getU(),this.getUnits());
}
public PowerPerUnitArea min(PowerPerUnitArea r) { // units maintained
if (r.lessThan(this)) return new PowerPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new PowerPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
public PowerPerUnitArea max(PowerPerUnitArea r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new PowerPerUnitArea(r.getX(),r.getU(),r.getUnits());
return new PowerPerUnitArea(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public PowerPerUnitArea mult(double r) {
return new PowerPerUnitArea(this.value.mult(new UReal(r)),this.getUnits());
}
public PowerPerUnitArea divideBy(double r) {
return new PowerPerUnitArea(this.value.divideBy(new UReal(r)),this.getUnits());
}
public PowerPerUnitArea mult(UReal r) {
return new PowerPerUnitArea(this.value.mult(r),this.getUnits());
}
public PowerPerUnitArea divideBy(UReal r) {
return new PowerPerUnitArea(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public PowerPerUnitArea clone() {
return new PowerPerUnitArea(this.getUReal(),this.getUnits());
}
}
