package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class TrafficIntensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		double[] x = new double[BaseUnits.values().length];
		x[BaseUnits.Meter.ordinal()] = 0.0;
		x[BaseUnits.Kilogram.ordinal()] = 0.0;
		x[BaseUnits.Second.ordinal()] = 0.0;
		x[BaseUnits.Ampere.ordinal()] = 0.0;
		x[BaseUnits.Kelvin.ordinal()] = 0.0;
		x[BaseUnits.Mole.ordinal()] = 0.0;
		x[BaseUnits.Radian.ordinal()] = 0.0;
		x[BaseUnits.Candela.ordinal()] = 0.0;
		x[BaseUnits.Bit.ordinal()] = 0.0;
		x[BaseUnits.Shannon.ordinal()] = 0.0;
		x[BaseUnits.Erlang.ordinal()] = 1.0;
		x[BaseUnits.Decibel.ordinal()] = 0.0;
		return Arrays.equals(x, u.dimensions);
	}

	public TrafficIntensity(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating a TrafficIntensity");
		this.unit = new Unit(q.unit);
	}

	public TrafficIntensity() {
		value = new UReal();
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an TrafficIntensity");
		this.unit = new Unit(unit);
	}

	public TrafficIntensity(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(double x, Unit unit) { // we only allow the same
													// Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a TrafficIntensity");
		this.unit = new Unit(unit);
	}

	public TrafficIntensity(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a TrafficIntensity");
		this.unit = new Unit(unit);
	}

	public TrafficIntensity(String x) { // creates a TrafficIntensity from a
										// string representing a
		// real, with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(String x, String u) { // creates a TrafficIntensity
													// from two strings
		// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Erlang);
	}

	public TrafficIntensity(String x, String u, Unit unit) { // creates a
																// TrafficIntensity
																// from two
		// strings representing
		// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a TrafficIntensity");
		this.unit = new Unit(unit);
	}

	// Specific Type Operations
	public TrafficIntensity add(TrafficIntensity r) { // only works if
														// compatible units &&
														// operand has
		// no offset
		return new TrafficIntensity(super.add(r));
	}

	public TrafficIntensity minus(TrafficIntensity r) {
		return new TrafficIntensity(super.minus(r));
	}

	// power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity
	public boolean equals(TrafficIntensity r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(TrafficIntensity r) {
		return !(this.equals(r));
	}

	public TrafficIntensity floor() { // returns (i,u) with i the largest int
										// such that
		// (i,u)<=(x,u) -- units maintained
		return new TrafficIntensity(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public TrafficIntensity min(TrafficIntensity r) { // units maintained
		if (r.lt(this))
			return new TrafficIntensity(r.getX(), r.getU(), r.getUnits());
		return new TrafficIntensity(this.getX(), this.getU(), this.getUnits());
	}

	public TrafficIntensity max(TrafficIntensity r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new TrafficIntensity(r.getX(), r.getU(), r.getUnits());
		return new TrafficIntensity(this.getX(), this.getU(), this.getUnits());
	}

	// working with constants (note that add and minus do not work here
	public TrafficIntensity mult(double r) {
		return new TrafficIntensity(this.value.mult(new UReal(r)), this.getUnits());
	}

	public TrafficIntensity divideBy(double r) {
		return new TrafficIntensity(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	public TrafficIntensity mult(UReal r) {
		return new TrafficIntensity(this.value.mult(r), this.getUnits());
	}

	public TrafficIntensity divideBy(UReal r) {
		return new TrafficIntensity(this.value.divideBy(r), this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly
	// from Quantity
	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public TrafficIntensity clone() {
		return new TrafficIntensity(this.getUReal(), this.getUnits());
	}
}
