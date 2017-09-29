package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class Time extends Quantity {
	static protected boolean checkUnit(Unit u) {
		double[] x = new double[BaseUnits.values().length];
		x[BaseUnits.Meter.ordinal()] = 0.0;
		x[BaseUnits.Kilogram.ordinal()] = 0.0;
		x[BaseUnits.Second.ordinal()] = 1.0;
		x[BaseUnits.Ampere.ordinal()] = 0.0;
		x[BaseUnits.Kelvin.ordinal()] = 0.0;
		x[BaseUnits.Mole.ordinal()] = 0.0;
		x[BaseUnits.Radian.ordinal()] = 0.0;
		x[BaseUnits.Candela.ordinal()] = 0.0;
		x[BaseUnits.Bit.ordinal()] = 0.0;
		x[BaseUnits.Shannon.ordinal()] = 0.0;
		x[BaseUnits.Erlang.ordinal()] = 0.0;
		x[BaseUnits.Decibel.ordinal()] = 0.0;
		return Arrays.equals(x, u.dimensions);
	}

	public Time(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating a Time");
		this.unit = new Unit(q.unit);
	}

	public Time() {
		value = new UReal();
		unit = new Unit(BaseUnits.Second);
	}

	public Time(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Second);
	}

	public Time(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an Time");
		this.unit = new Unit(unit);
	}

	public Time(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Second);
	}

	public Time(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Second);
	}

	public Time(double x, Unit unit) { // we only allow the same Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Time");
		this.unit = new Unit(unit);
	}

	public Time(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Time");
		this.unit = new Unit(unit);
	}

	public Time(String x) { // creates a Time from a string representing a real,
							// with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Second);
	}

	public Time(String x, String u) { // creates a Time from two strings
										// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Second);
	}

	public Time(String x, String u, Unit unit) { // creates a Time from two
													// strings representing
													// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Time");
		this.unit = new Unit(unit);
	}

	// Specific Type Operations
	public Time add(Time r) { // only works if compatible units && operand has
								// no offset
		return new Time(super.add(r));
	}

	public Time minus(Time r) { // only works if compatible units. You can
								// subtract 2 units with offsets, but it returns
								// a DeltaUnit (without offset)
		return new Time(super.minus(r));
	}

	public TimeSquared mult(Time r) { // both values and units are multiplied.
										// No offsets allowed in any of the
										// units
		return new TimeSquared(super.mult(r));
	}

	public ElectricCharge mult(ElectricCurrent r) { // both values and units are
													// multiplied. No offsets
													// allowed in any of the
													// units
		return new ElectricCharge(super.mult(r));
	}

	public KinematicViscosity mult(AbsorbedDose r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new KinematicViscosity(super.mult(r));
	}

	public AbsorbedDose mult(AbsorbedDoseRate r) { // both values and units are
													// multiplied. No offsets
													// allowed in any of the
													// units
		return new AbsorbedDose(super.mult(r));
	}

	public AngularVelocity mult(AngularAcceleration r) { // both values and
															// units are
															// multiplied. No
															// offsets allowed
															// in any of the
															// units
		return new AngularVelocity(super.mult(r));
	}

	public AngularMass mult(AngularMomentum r) { // both values and units are
													// multiplied. No offsets
													// allowed in any of the
													// units
		return new AngularMass(super.mult(r));
	}

	public Angle mult(AngularVelocity r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new Angle(super.mult(r));
	}

	public AmountOfSubstance mult(CatalyticActivity r) { // both values and
															// units are
															// multiplied. No
															// offsets allowed
															// in any of the
															// units
		return new AmountOfSubstance(super.mult(r));
	}

	public KinematicViscosity mult(DoseEquivalent r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new KinematicViscosity(super.mult(r));
	}

	public MassPerUnitLength mult(DynamicViscosity r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new MassPerUnitLength(super.mult(r));
	}

	public ElectricFluxDensity mult(ElectricCurrentDensity r) { // both values
																// and units are
																// multiplied.
																// No offsets
																// allowed in
																// any of the
																// units
		return new ElectricFluxDensity(super.mult(r));
	}

	public Capacitance mult(ElectricalConductivity r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new Capacitance(super.mult(r));
	}

	public MagneticFlux mult(ElectromotiveForce r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new MagneticFlux(super.mult(r));
	}

	public DynamicViscosity mult(EnergyDensity r) { // both values and units are
													// multiplied. No offsets
													// allowed in any of the
													// units
		return new DynamicViscosity(super.mult(r));
	}

	public AngularMomentum mult(EnergyAndWork r) { // both values and units are
													// multiplied. No offsets
													// allowed in any of the
													// units
		return new AngularMomentum(super.mult(r));
	}

	public MassPerUnitTime mult(EnergyPerUnitArea r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new MassPerUnitTime(super.mult(r));
	}

	public LinearMomentum mult(Force r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new LinearMomentum(super.mult(r));
	}

	public MassPerUnitTime mult(ForcePerUnitLength r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new MassPerUnitTime(super.mult(r));
	}

	public EnergyAndWork mult(HeatFlowRate r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new EnergyAndWork(super.mult(r));
	}

	public EnergyPerUnitArea mult(HeatFlowRatePerUnitArea r) { // both values
																// and units are
																// multiplied.
																// No offsets
																// allowed in
																// any of the
																// units
		return new EnergyPerUnitArea(super.mult(r));
	}

	public Area mult(KinematicViscosity r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new Area(super.mult(r));
	}

	public LinearVelocity mult(LinearAcceleration r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new LinearVelocity(super.mult(r));
	}

	public LengthMass mult(LinearMomentum r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new LengthMass(super.mult(r));
	}

	public Length mult(LinearVelocity r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new Length(super.mult(r));
	}

	public ElectricChargeLineDensity mult(MagneticFieldStrength r) { // both
																		// values
																		// and
																		// units
																		// are
																		// multiplied.
																		// No
																		// offsets
																		// allowed
																		// in
																		// any
																		// of
																		// the
																		// units
		return new ElectricChargeLineDensity(super.mult(r));
	}

	public Mass mult(MassPerUnitTime r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new Mass(super.mult(r));
	}

	public EnergyAndWork mult(Power r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new EnergyAndWork(super.mult(r));
	}

	public EnergyPerUnitArea mult(PowerPerUnitArea r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new EnergyPerUnitArea(super.mult(r));
	}

	public DynamicViscosity mult(Pressure r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new DynamicViscosity(super.mult(r));
	}

	public Inductance mult(Resistance r) { // both values and units are
											// multiplied. No offsets allowed in
											// any of the units
		return new Inductance(super.mult(r));
	}

	public KinematicViscosity mult(SpecificEnergy r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new KinematicViscosity(super.mult(r));
	}

	public Area mult(ThermalDiffusivity r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new Area(super.mult(r));
	}

	public LinearVelocity mult(ThrustToMassRatio r) { // both values and units
														// are multiplied. No
														// offsets allowed in
														// any of the units
		return new LinearVelocity(super.mult(r));
	}

	public AngularMomentum mult(BendingMomentOrTorque r) { // both values and
															// units are
															// multiplied. No
															// offsets allowed
															// in any of the
															// units
		return new AngularMomentum(super.mult(r));
	}

	public Volume mult(VolumePerUnitTime r) { // both values and units are
												// multiplied. No offsets
												// allowed in any of the units
		return new Volume(super.mult(r));
	}

	public TimeSquared divideBy(Activity r) { // both values and units are
												// divided. No offsets allowed
												// in any of the units
		return new TimeSquared(super.divideBy(r));
	}

	public Resistance divideBy(Capacitance r) { // both values and units are
												// divided. No offsets allowed
												// in any of the units
		return new Resistance(super.divideBy(r));
	}

	public Inductance divideBy(ElectricalConductivity r) { // both values and
															// units are
															// divided. No
															// offsets allowed
															// in any of the
															// units
		return new Inductance(super.divideBy(r));
	}

	public TimeSquared divideBy(Frequency r) { // both values and units are
												// divided. No offsets allowed
												// in any of the units
		return new TimeSquared(super.divideBy(r));
	}

	public ThermalResistance divideBy(HeatCapacityAndEntropy r) { // both values
																	// and units
																	// are
																	// divided.
																	// No
																	// offsets
																	// allowed
																	// in any of
																	// the units
		return new ThermalResistance(super.divideBy(r));
	}

	public ElectricalConductivity divideBy(Inductance r) { // both values and
															// units are
															// divided. No
															// offsets allowed
															// in any of the
															// units
		return new ElectricalConductivity(super.divideBy(r));
	}

	public Capacitance divideBy(Resistance r) { // both values and units are
												// divided. No offsets allowed
												// in any of the units
		return new Capacitance(super.divideBy(r));
	}

	public HeatCapacityAndEntropy divideBy(ThermalResistance r) { // both values
																	// and units
																	// are
																	// divided.
																	// No
																	// offsets
																	// allowed
																	// in any of
																	// the units
		return new HeatCapacityAndEntropy(super.divideBy(r));
	}

	public Activity divideBy(TimeSquared r) { // both values and units are
												// divided. No offsets allowed
												// in any of the units
		return new Activity(super.divideBy(r));
	}

	public UReal divideBy(Time r) { // This operation converts first both
									// operands to SI units and then divides)
		return super.divideBy(r).value.clone();
	}

	public Activity inverse() {
		return new Activity(super.inverse());
	}

	public Time abs() { // units are maintained
		return new Time(super.abs());
	}

	public Time neg() { // units are maintained
		return new Time(super.neg());
	}

	// power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity
	public boolean equals(Time r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Time r) {
		return !(this.equals(r));
	}

	public Time floor() { // returns (i,u) with i the largest int such that
							// (i,u)<=(x,u) -- units maintained
		return new Time(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public Time round() { // returns (i,u) with i the closest int to x -- units
							// maintained
		return new Time(Math.round(this.getX()), this.getU(), this.getUnits());
	}

	public Time min(Time r) { // units maintained
		if (r.lessThan(this))
			return new Time(r.getX(), r.getU(), r.getUnits());
		return new Time(this.getX(), this.getU(), this.getUnits());
	}

	public Time max(Time r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new Time(r.getX(), r.getU(), r.getUnits());
		return new Time(this.getX(), this.getU(), this.getUnits());
	}

	// working with constants (note that add and minus do not work here
	public Time mult(double r) {
		return new Time(this.value.mult(new UReal(r)), this.getUnits());
	}

	public Time divideBy(double r) {
		return new Time(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	public Time mult(UReal r) {
		return new Time(this.value.mult(r), this.getUnits());
	}

	public Time divideBy(UReal r) {
		return new Time(this.value.divideBy(r), this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly
	// from Quantity
	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public Time clone() {
		return new Time(this.getUReal(), this.getUnits());
	}
}
