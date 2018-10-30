package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ElectricCurrent extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
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

public ElectricCurrent(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
this.unit = new Unit (q.unit);
}
public ElectricCurrent () {
value = new UReal();
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ElectricCurrent");
this.unit = new Unit (unit);
}
public ElectricCurrent(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
this.unit = new Unit (unit);
}
public ElectricCurrent(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
this.unit = new Unit (unit);
}
public ElectricCurrent(String x) { //creates a ElectricCurrent from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent(String x, String u) { //creates a ElectricCurrent from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Ampere);
}
public ElectricCurrent(String x, String u, Unit unit) { //creates a ElectricCurrent from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrent");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ElectricCurrent add(ElectricCurrent r) {  //only works if compatible units && operand has no offset
return new ElectricCurrent(super.add(r));
}
public ElectricCurrent minus(ElectricCurrent r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ElectricCurrent(super.minus(r));
}
public ElectricCharge mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public MagnetomotiveForce mult(Angle r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagnetomotiveForce(super.mult(r));
}
public MagneticDipoleMoment mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.mult(r));
}
public HeatFlowRate mult(ElectromotiveForce r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public MagneticFlux mult(Inductance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFlux(super.mult(r));
}
public EnergyAndWork mult(MagneticFlux r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public EnergyPerUnitArea mult(MagneticFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public ElectromotiveForce mult(Resistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public MagneticFieldStrength divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFieldStrength(super.divideBy(r));
}
public CurrentPerAngle divideBy(Angle r) { //both values and units are divided. No offsets allowed in any of the units
return new CurrentPerAngle(super.divideBy(r));
}
public ElectricCharge divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public ElectricCurrentDensity divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrentDensity(super.divideBy(r));
}
public ElectricChargePerAmountOfSubstance divideBy(CatalyticActivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargePerAmountOfSubstance(super.divideBy(r));
}
public Activity divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public LinearVelocity divideBy(ElectricChargeLineDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public VolumePerUnitTime divideBy(ElectricChargeVolumeDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public CatalyticActivity divideBy(ElectricChargePerAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new CatalyticActivity(super.divideBy(r));
}
public Area divideBy(ElectricCurrentDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Angle divideBy(CurrentPerAngle r) { //both values and units are divided. No offsets allowed in any of the units
return new Angle(super.divideBy(r));
}
public KinematicViscosity divideBy(ElectricFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricalConductivity divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricalConductivity(super.divideBy(r));
}
public MassPerUnitTime divideBy(Exposure r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public ElectricCharge divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public ElectricFluxDensity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectricChargeLineDensity divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.divideBy(r));
}
public Length divideBy(MagneticFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public Exposure divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new Exposure(super.divideBy(r));
}
public ElectricFluxDensity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFluxDensity(super.divideBy(r));
}
public ElectricChargeVolumeDensity divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricChargeVolumeDensity(super.divideBy(r));
}
public UReal divideBy(ElectricCurrent r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ElectricCurrent abs() { //units are maintained
return new ElectricCurrent(super.abs());
}
public ElectricCurrent neg() { //units are maintained
return new ElectricCurrent(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ElectricCurrent r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ElectricCurrent r) {
return !(this.equals(r));
}
public ElectricCurrent floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ElectricCurrent(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ElectricCurrent round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ElectricCurrent(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ElectricCurrent min(ElectricCurrent r) { // units maintained
if (r.lt(this)) return new ElectricCurrent(r.getX(),r.getU(),r.getUnits());
return new ElectricCurrent(this.getX(),this.getU(),this.getUnits());
}
public ElectricCurrent max(ElectricCurrent r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ElectricCurrent(r.getX(),r.getU(),r.getUnits());
return new ElectricCurrent(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ElectricCurrent mult(double r) {
return new ElectricCurrent(this.value.mult(new UReal(r)),this.getUnits());
}
public ElectricCurrent divideBy(double r) {
return new ElectricCurrent(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ElectricCurrent mult(UReal r) {
return new ElectricCurrent(this.value.mult(r),this.getUnits());
}
public ElectricCurrent divideBy(UReal r) {
return new ElectricCurrent(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ElectricCurrent clone() {
return new ElectricCurrent(this.getUReal(),this.getUnits());
}
}
