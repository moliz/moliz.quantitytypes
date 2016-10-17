package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ThermalConductivity extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-3.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=-1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ThermalConductivity(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermalConductivity");
this.unit = new Unit (q.unit);
}
public ThermalConductivity () {
value = new UReal();
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermalConductivity");
this.unit = new Unit (unit);
}
public ThermalConductivity(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalConductivity");
this.unit = new Unit (unit);
}
public ThermalConductivity(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalConductivity");
this.unit = new Unit (unit);
}
public ThermalConductivity(String x) { //creates a ThermalConductivity from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity(String x, String u) { //creates a ThermalConductivity from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.WattPerMeterKelvin);
}
public ThermalConductivity(String x, String u, Unit unit) { //creates a ThermalConductivity from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermalConductivity");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ThermalConductivity add(ThermalConductivity r) {  //only works if compatible units && operand has no offset
return new ThermalConductivity(super.add(r));
}
public ThermalConductivity minus(ThermalConductivity r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ThermalConductivity(super.minus(r));
}
public HeatFlowRate mult(LengthTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowRate(super.mult(r));
}
public Length mult(ThermalInsulance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public CoefficientOfHeatTransfer divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new CoefficientOfHeatTransfer(super.divideBy(r));
}
public SpecificHeatVolume divideBy(AngularMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatVolume(super.divideBy(r));
}
public Length divideBy(CoefficientOfHeatTransfer r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public SpecificHeatCapacity divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public LinearThermalExpansion divideBy(HeatFlowRatePerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public HeatFlowRatePerUnitArea divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowRatePerUnitArea(super.divideBy(r));
}
public LinearThermalExpansion divideBy(PowerPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public DynamicViscosity divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public AngularMomentum divideBy(SpecificHeatVolume r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMomentum(super.divideBy(r));
}
public VolumetricHeatCapacity divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumetricHeatCapacity(super.divideBy(r));
}
public KinematicViscosity divideBy(VolumetricHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public UReal divideBy(ThermalConductivity r) { //This operation converts first both operands to SI units and then divides)
return super.divideBy(r).value.clone();
}
public ThermalResistivity inverse() {
return new  ThermalResistivity(super.inverse());
}
public ThermalConductivity abs() { //units are maintained
return new ThermalConductivity(super.abs());
}
public ThermalConductivity neg() { //units are maintained
return new ThermalConductivity(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ThermalConductivity r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ThermalConductivity r) {
return !(this.equals(r));
}
public ThermalConductivity floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ThermalConductivity(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ThermalConductivity round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ThermalConductivity(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ThermalConductivity min(ThermalConductivity r) { // units maintained
if (r.lessThan(this)) return new ThermalConductivity(r.getX(),r.getU(),r.getUnits());
return new ThermalConductivity(this.getX(),this.getU(),this.getUnits());
}
public ThermalConductivity max(ThermalConductivity r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ThermalConductivity(r.getX(),r.getU(),r.getUnits());
return new ThermalConductivity(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ThermalConductivity mult(double r) {
return new ThermalConductivity(this.value.mult(new UReal(r)),this.getUnits());
}
public ThermalConductivity divideBy(double r) {
return new ThermalConductivity(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ThermalConductivity mult(UReal r) {
return new ThermalConductivity(this.value.mult(r),this.getUnits());
}
public ThermalConductivity divideBy(UReal r) {
return new ThermalConductivity(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ThermalConductivity clone() {
return new ThermalConductivity(this.getUReal(),this.getUnits());
}
}
