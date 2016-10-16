package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class Length extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=1.0;
x[BaseUnits.Kilogram.ordinal()]=0.0;
x[BaseUnits.Second.ordinal()]=0.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public Length(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Length");
this.unit = new Unit (q.unit);
}
public Length () {
value = new UReal();
unit = new Unit(BaseUnits.Meter);
}
public Length(UReal u){
value = u.clone();
unit = new Unit(BaseUnits.Meter);
}
public Length(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an Length");
this.unit = new Unit (unit);
}
public Length(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(BaseUnits.Meter);
}
public Length (double x, double u) {
value = new UReal(x,u);
unit = new Unit(BaseUnits.Meter);
}
public Length(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
this.unit = new Unit (unit);
}
public Length(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
this.unit = new Unit (unit);
}
public Length(String x) { //creates a Length from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(BaseUnits.Meter);
}
public Length(String x, String u) { //creates a Length from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(BaseUnits.Meter);
}
public Length(String x, String u, Unit unit) { //creates a Length from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a Length");
this.unit = new Unit (unit);
}
// Specific Type Operations
public Length add(Length r) {  //only works if compatible units && operand has no offset
return new Length(super.add(r));
}
public Length minus(Length r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new Length(super.minus(r));
}
public LengthMass mult(Mass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthMass(super.mult(r));
}
public LengthTemPerature mult(ThermodynamicTemperature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LengthTemPerature(super.mult(r));
}
public LinearVelocity mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public Volume mult(Area r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Volume(super.mult(r));
}
public VolumeThermalExpansion mult(AreaThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumeThermalExpansion(super.mult(r));
}
public ThermalConductivity mult(CoefficientOfHeatTransfer r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalConductivity(super.mult(r));
}
public MassPerUnitArea mult(Density r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitArea(super.mult(r));
}
public MassPerUnitTime mult(DynamicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitTime(super.mult(r));
}
public ElectricDipoleMoment mult(ElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.mult(r));
}
public ElectricCharge mult(ElectricChargeLineDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCharge(super.mult(r));
}
public ElectricFluxDensity mult(ElectricChargeVolumeDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricFluxDensity(super.mult(r));
}
public MagneticFieldStrength mult(ElectricCurrentDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MagneticFieldStrength(super.mult(r));
}
public ElectromotiveForce mult(ElectricFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public ElectricChargeLineDensity mult(ElectricFluxDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricChargeLineDensity(super.mult(r));
}
public EnergyPerUnitArea mult(EnergyDensity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public Force mult(EnergyPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public EnergyAndWork mult(Force r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyAndWork(super.mult(r));
}
public ElectromotiveForce mult(ForcePerElectricCharge r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectromotiveForce(super.mult(r));
}
public Force mult(ForcePerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Force(super.mult(r));
}
public LinearVelocity mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearVelocity(super.mult(r));
}
public VolumePerUnitTime mult(KinematicViscosity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public AngularMass mult(LengthMass r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public AreaTemperature mult(LengthTemPerature r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaTemperature(super.mult(r));
}
public AbsorbedDose mult(LinearAcceleration r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public AngularMomentum mult(LinearMomentum r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public AreaThermalExpansion mult(LinearThermalExpansion r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AreaThermalExpansion(super.mult(r));
}
public KinematicViscosity mult(LinearVelocity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new KinematicViscosity(super.mult(r));
}
public ElectricCurrent mult(MagneticFieldStrength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ElectricCurrent(super.mult(r));
}
public LinearMomentum mult(MassPerUnitTime r) { //both values and units are multiplied. No offsets allowed in any of the units
return new LinearMomentum(super.mult(r));
}
public MassPerUnitLength mult(MassPerUnitArea r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MassPerUnitLength(super.mult(r));
}
public Mass mult(MassPerUnitLength r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Mass(super.mult(r));
}
public Inductance mult(Permeability r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Inductance(super.mult(r));
}
public Capacitance mult(Permittivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new Capacitance(super.mult(r));
}
public EnergyPerUnitArea mult(Pressure r) { //both values and units are multiplied. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.mult(r));
}
public VolumePerUnitTime mult(ThermalDiffusivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new VolumePerUnitTime(super.mult(r));
}
public ThermalResistivity mult(ThermalResistance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalResistivity(super.mult(r));
}
public ThermalInsulance mult(ThermalResistivity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new ThermalInsulance(super.mult(r));
}
public AbsorbedDose mult(ThrustToMassRatio r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AbsorbedDose(super.mult(r));
}
public LinearVelocity divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public LinearThermalExpansion divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearThermalExpansion(super.divideBy(r));
}
public InversePermittivity divideBy(Capacitance r) { //both values and units are divided. No offsets allowed in any of the units
return new InversePermittivity(super.divideBy(r));
}
public Capacitance divideBy(InversePermittivity r) { //both values and units are divided. No offsets allowed in any of the units
return new Capacitance(super.divideBy(r));
}
public TimeSquared divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(LinearThermalExpansion r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Time divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public ThermalInsulance divideBy(ThermalConductivity r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalInsulance(super.divideBy(r));
}
public ThermalConductivity divideBy(ThermalInsulance r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermalConductivity(super.divideBy(r));
}
public TimeSquared divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new TimeSquared(super.divideBy(r));
}
public LinearAcceleration divideBy(TimeSquared r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public Length abs() { //units are maintained
return new Length(super.abs());
}
public Length neg() { //units are maintained
return new Length(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(Length r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(Length r) {
return !(this.equals(r));
}
public Length floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new Length(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public Length round(){ //returns (i,u) with i the closest int to x -- units maintained
return new Length(Math.round(this.getX()),this.getU(),this.getUnits());
}
public Length min(Length r) { // units maintained
if (r.lessThan(this)) return new Length(r.getX(),r.getU(),r.getUnits());
return new Length(this.getX(),this.getU(),this.getUnits());
}
public Length max(Length r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new Length(r.getX(),r.getU(),r.getUnits());
return new Length(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public Length mult(double r) {
return new Length(this.value.mult(new UReal(r)),this.getUnits());
}
public Length divideBy(double r) {
return new Length(this.value.divideBy(new UReal(r)),this.getUnits());
}
public Length mult(UReal r) {
return new Length(this.value.mult(r),this.getUnits());
}
public Length divideBy(UReal r) {
return new Length(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public Length clone() {
return new Length(this.getUReal(),this.getUnits());
}
}
