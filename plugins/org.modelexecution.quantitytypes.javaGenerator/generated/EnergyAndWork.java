package org.modelexecution.quantitytypes.java;
import java.util.Arrays;
public class EnergyAndWork extends Quantity {
static protected boolean checkUnit(Unit u) {
double [] x = new double [BaseUnits.values().length];
x[BaseUnits.Meter.ordinal()]=2.0;
x[BaseUnits.Kilogram.ordinal()]=1.0;
x[BaseUnits.Second.ordinal()]=-2.0;
x[BaseUnits.Ampere.ordinal()]=0.0;
x[BaseUnits.Kelvin.ordinal()]=0.0;
x[BaseUnits.Mole.ordinal()]=0.0;
x[BaseUnits.Radian.ordinal()]=0.0;
x[BaseUnits.Candela.ordinal()]=0.0;
return Arrays.equals(x,u.dimensions);
}

public EnergyAndWork(Quantity q){
value = q.value.clone();
if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
this.unit = new Unit (q.unit);
}
public EnergyAndWork () {
value = new UReal();
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork(UReal u){
value = u.clone();
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork(UReal u, Unit unit){
value = u.clone();
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an EnergyAndWork");
this.unit = new Unit (unit);
}
public EnergyAndWork(double x){ //"promotes" a real x
value = new UReal(x);
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork (double x, double u) {
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork(double x, Unit unit){ //we only allow the same Units
value = new UReal(x);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
this.unit = new Unit (unit);
}
public EnergyAndWork(double x, double u, Unit unit){
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
this.unit = new Unit (unit);
}
public EnergyAndWork(String x) { //creates a EnergyAndWork from a string representing a real, with u=0.
value = new UReal(x);
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork(String x, String u) { //creates a EnergyAndWork from two strings representing (x,u).
value = new UReal(x,u);
unit = new Unit(DerivedUnits.Joule);
}
public EnergyAndWork(String x, String u, Unit unit) { //creates a EnergyAndWork from two strings representing (x,u).
value = new UReal(x,u);
if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a EnergyAndWork");
this.unit = new Unit (unit);
}
// Specific Type Operations
public EnergyAndWork add(EnergyAndWork r) {  //only works if compatible units && operand has no offset
return new EnergyAndWork(super.add(r));
}
public EnergyAndWork minus(EnergyAndWork r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)
return new EnergyAndWork(super.minus(r));
}
public AngularMomentum mult(Time r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMomentum(super.mult(r));
}
public HeatFlowrate mult(Activity r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowrate(super.mult(r));
}
public HeatFlowrate mult(Frequency r) { //both values and units are multiplied. No offsets allowed in any of the units
return new HeatFlowrate(super.mult(r));
}
public MolarEnergy mult(InverseAmountOfSubstance r) { //both values and units are multiplied. No offsets allowed in any of the units
return new MolarEnergy(super.mult(r));
}
public AngularMass mult(TimeSquared r) { //both values and units are multiplied. No offsets allowed in any of the units
return new AngularMass(super.mult(r));
}
public Force divideBy(Length r) { //both values and units are divided. No offsets allowed in any of the units
return new Force(super.divideBy(r));
}
public AbsorbedDose divideBy(Mass r) { //both values and units are divided. No offsets allowed in any of the units
return new AbsorbedDose(super.divideBy(r));
}
public HeatFlowrate divideBy(Time r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatFlowrate(super.divideBy(r));
}
public MagneticFlux divideBy(ElectricCurrent r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFlux(super.divideBy(r));
}
public HeatCapacityAndEntropy divideBy(ThermodynamicTemperature r) { //both values and units are divided. No offsets allowed in any of the units
return new HeatCapacityAndEntropy(super.divideBy(r));
}
public MolarEnergy divideBy(AmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarEnergy(super.divideBy(r));
}
public Mass divideBy(AbsorbedDose r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public AngularMomentum divideBy(Activity r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMomentum(super.divideBy(r));
}
public Activity divideBy(AngularMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new Activity(super.divideBy(r));
}
public EnergyPerUnitArea divideBy(Area r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyPerUnitArea(super.divideBy(r));
}
public Mass divideBy(DoseEquivalent r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public VolumePerUnitTime divideBy(DynamicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new VolumePerUnitTime(super.divideBy(r));
}
public ElectromotiveForce divideBy(ElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectromotiveForce(super.divideBy(r));
}
public ElectricFieldStrength divideBy(ElectricDipoleMoment r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricFieldStrength(super.divideBy(r));
}
public ElectricDipoleMoment divideBy(ElectricFieldStrength r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.divideBy(r));
}
public ElectricCharge divideBy(ElectromotiveForce r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCharge(super.divideBy(r));
}
public Volume divideBy(EnergyDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public Area divideBy(EnergyPerUnitArea r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public Length divideBy(Force r) { //both values and units are divided. No offsets allowed in any of the units
return new Length(super.divideBy(r));
}
public ElectricDipoleMoment divideBy(ForcePerElectricCharge r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricDipoleMoment(super.divideBy(r));
}
public Area divideBy(ForcePerUnitLength r) { //both values and units are divided. No offsets allowed in any of the units
return new Area(super.divideBy(r));
}
public AngularMomentum divideBy(Frequency r) { //both values and units are divided. No offsets allowed in any of the units
return new AngularMomentum(super.divideBy(r));
}
public ThermodynamicTemperature divideBy(HeatCapacityAndEntropy r) { //both values and units are divided. No offsets allowed in any of the units
return new ThermodynamicTemperature(super.divideBy(r));
}
public Time divideBy(HeatFlowrate r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public MassPerUnitTime divideBy(KinematicViscosity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public LinearAcceleration divideBy(LengthMass r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearAcceleration(super.divideBy(r));
}
public LengthMass divideBy(LinearAcceleration r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public LinearVelocity divideBy(LinearMomentum r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearVelocity(super.divideBy(r));
}
public LinearMomentum divideBy(LinearVelocity r) { //both values and units are divided. No offsets allowed in any of the units
return new LinearMomentum(super.divideBy(r));
}
public MagneticFluxDensity divideBy(MagneticDipoleMoment r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticFluxDensity(super.divideBy(r));
}
public ElectricCurrent divideBy(MagneticFlux r) { //both values and units are divided. No offsets allowed in any of the units
return new ElectricCurrent(super.divideBy(r));
}
public MagneticDipoleMoment divideBy(MagneticFluxDensity r) { //both values and units are divided. No offsets allowed in any of the units
return new MagneticDipoleMoment(super.divideBy(r));
}
public SpecificHeatCapacity divideBy(MassTemPerature r) { //both values and units are divided. No offsets allowed in any of the units
return new SpecificHeatCapacity(super.divideBy(r));
}
public KinematicViscosity divideBy(MassPerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new KinematicViscosity(super.divideBy(r));
}
public AmountOfSubstance divideBy(MolarEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new AmountOfSubstance(super.divideBy(r));
}
public TemPeratureAmountOfSubstance divideBy(MolarHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new TemPeratureAmountOfSubstance(super.divideBy(r));
}
public Time divideBy(Power r) { //both values and units are divided. No offsets allowed in any of the units
return new Time(super.divideBy(r));
}
public Volume divideBy(Pressure r) { //both values and units are divided. No offsets allowed in any of the units
return new Volume(super.divideBy(r));
}
public Mass divideBy(SpecificEnergy r) { //both values and units are divided. No offsets allowed in any of the units
return new Mass(super.divideBy(r));
}
public MassTemPerature divideBy(SpecificHeatCapacity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassTemPerature(super.divideBy(r));
}
public MolarHeatCapacity divideBy(TemPeratureAmountOfSubstance r) { //both values and units are divided. No offsets allowed in any of the units
return new MolarHeatCapacity(super.divideBy(r));
}
public MassPerUnitTime divideBy(ThermalDiffusivity r) { //both values and units are divided. No offsets allowed in any of the units
return new MassPerUnitTime(super.divideBy(r));
}
public LengthMass divideBy(ThrustToMassRatio r) { //both values and units are divided. No offsets allowed in any of the units
return new LengthMass(super.divideBy(r));
}
public EnergyDensity divideBy(Volume r) { //both values and units are divided. No offsets allowed in any of the units
return new EnergyDensity(super.divideBy(r));
}
public DynamicViscosity divideBy(VolumePerUnitTime r) { //both values and units are divided. No offsets allowed in any of the units
return new DynamicViscosity(super.divideBy(r));
}
public EnergyAndWork abs() { //units are maintained
return new EnergyAndWork(super.abs());
}
public EnergyAndWork neg() { //units are maintained
return new EnergyAndWork(super.neg());
}
// power(s), and inverse() return Quantity
// lessThan, LessEq, gt, ge all directly from Quantity
public boolean equals(EnergyAndWork r) {  
return  r.compatibleUnits(this) && 
this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
}
public boolean distinct(EnergyAndWork r) {
return !(this.equals(r));
}
public EnergyAndWork floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
return new EnergyAndWork(Math.floor(this.getX()),this.getU(),this.getUnits());
}
public EnergyAndWork round(){ //returns (i,u) with i the closest int to x -- units maintained
return new EnergyAndWork(Math.round(this.getX()),this.getU(),this.getUnits());
}
public EnergyAndWork min(EnergyAndWork r) { // units maintained
if (r.lessThan(this)) return new EnergyAndWork(r.getX(),r.getU(),r.getUnits());
return new EnergyAndWork(this.getX(),this.getU(),this.getUnits());
}
public EnergyAndWork max(EnergyAndWork r) { // unit maintained
//if (r>this) r; else this;
if (r.gt(this)) return new EnergyAndWork(r.getX(),r.getU(),r.getUnits());
return new EnergyAndWork(this.getX(),this.getU(),this.getUnits());
}
// working with constants (note that add and minus do not work here
public EnergyAndWork mult(double r) {
return new EnergyAndWork(this.value.mult(new UReal(r)),this.getUnits());
}
public EnergyAndWork divideBy(double r) {
return new EnergyAndWork(this.value.divideBy(new UReal(r)),this.getUnits());
}
public EnergyAndWork mult(UReal r) {
return new EnergyAndWork(this.value.mult(r),this.getUnits());
}
public EnergyAndWork divideBy(UReal r) {
return new EnergyAndWork(this.value.divideBy(r),this.getUnits());
}
// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
public int hashcode(){ //required for equals()
return Math.round((float)value.getX());
}
public EnergyAndWork clone() {
return new EnergyAndWork(this.getUReal(),this.getUnits());
}
}
