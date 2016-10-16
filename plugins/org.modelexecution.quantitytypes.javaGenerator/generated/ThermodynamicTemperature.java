package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class ThermodynamicTemperature extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=0.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=1.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public ThermodynamicTemperature(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
this.unit = new Unit (q.unit);
}
public ThermodynamicTemperature () {
value = new UReal();
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an ThermodynamicTemperature");
this.unit = new Unit (unit);
}
public ThermodynamicTemperature(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
this.unit = new Unit (unit);
}
public ThermodynamicTemperature(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
this.unit = new Unit (unit);
}
public ThermodynamicTemperature(String x) { //creates a ThermodynamicTemperature from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature(String x, String u) { //creates a ThermodynamicTemperature from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Kelvin);
}
public ThermodynamicTemperature(String x, String u, Unit unit) { //creates a ThermodynamicTemperature from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
this.unit = new Unit (unit);
}
// Specific Type Operations
public ThermodynamicTemperature add(ThermodynamicTemperature r) {  //only works if compatible units && operand has no offset
return new ThermodynamicTemperature(super.add(r));
}
public ThermodynamicTemperature minus(ThermodynamicTemperature r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new ThermodynamicTemperature(super.minus(r));
}
public LengthTemperature mult(Length r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthTemperature(super.mult(r));
}
public MassTemperature mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassTemperature(super.mult(r));
}
public TemperatureAmountOfSubstance mult(AmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new TemperatureAmountOfSubstance(super.mult(r));
}
public AreaTemperature mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public Area mult(AreaThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Area(super.mult(r));
}
public HeatFlowratePerUnitArea mult(CoefficientOfHeatTransfer r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowratePerUnitArea(super.mult(r));
}
public EnergyAndWork mult(HeatCapacityAndEntropy r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public Length mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Length(super.mult(r));
}
public MolarEnergy mult(MolarHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public AbsorbedDose mult(SpecificHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public Volume mult(VolumeThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public EnergyDensity mult(VolumetricHeatCapacity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyDensity(super.mult(r));
}
public ThermalResistance divideBy(HeatFlowrate r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistance(super.divideBy(r));
}
public ThermalInsulance divideBy(HeatFlowratePerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalInsulance(super.divideBy(r));
}
public TemperatureAmountOfSubstance divideBy(InverseAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new TemperatureAmountOfSubstance(super.divideBy(r));
}
public ThermalResistance divideBy(Power r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalResistance(super.divideBy(r));
}
public ThermalInsulance divideBy(PowerPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalInsulance(super.divideBy(r));
}
public InverseAmountOfSubstance divideBy(TemperatureAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new InverseAmountOfSubstance(super.divideBy(r));
}
public HeatFlowratePerUnitArea divideBy(ThermalInsulance r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowratePerUnitArea(super.divideBy(r));
}
public HeatFlowrate divideBy(ThermalResistance r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowrate(super.divideBy(r));
}
public ThermodynamicTemperature abs() { //units are maintained
return new ThermodynamicTemperature(super.abs());
}
public ThermodynamicTemperature neg() { //units are maintained
return new ThermodynamicTemperature(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(ThermodynamicTemperature r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(ThermodynamicTemperature r) {
return !(this.equals(r));
}
public ThermodynamicTemperature floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new ThermodynamicTemperature(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public ThermodynamicTemperature round(){ //returns (i,u) with i the closest int to x -- units maintained
return new ThermodynamicTemperature(Math.round(this.getX()),this.getU(),this.getUnits());
}
public ThermodynamicTemperature min(ThermodynamicTemperature r) { // units maintained
if (r.lessThan(this)) return new ThermodynamicTemperature(r.getX(),r.getU(),r.getUnits());
return new ThermodynamicTemperature(this.getX(),this.getU(),this.getUnits());
}
public ThermodynamicTemperature max(ThermodynamicTemperature r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new ThermodynamicTemperature(r.getX(),r.getU(),r.getUnits());
return new ThermodynamicTemperature(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public ThermodynamicTemperature mult(double r) {
return new ThermodynamicTemperature(this.value.mult(new UReal(r)),this.getUnits());
}
public ThermodynamicTemperature divideBy(double r) {
return new ThermodynamicTemperature(this.value.divideBy(new UReal(r)),this.getUnits());
}
public ThermodynamicTemperature mult(UReal r) {
return new ThermodynamicTemperature(this.value.mult(r),this.getUnits());
}
public ThermodynamicTemperature divideBy(UReal r) {
return new ThermodynamicTemperature(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public ThermodynamicTemperature clone() {
return new ThermodynamicTemperature(this.getUReal(),this.getUnits());
}
}
