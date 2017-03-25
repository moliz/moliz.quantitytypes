package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class DataSpeed extends Quantity {
	static protected boolean checkUnit(Unit u) {
		double[] x = new double[BaseUnits.values().length];
		x[BaseUnits.Meter.ordinal()] = 0.0;
		x[BaseUnits.Kilogram.ordinal()] = 0.0;
		x[BaseUnits.Second.ordinal()] = -1.0;
		x[BaseUnits.Ampere.ordinal()] = 0.0;
		x[BaseUnits.Kelvin.ordinal()] = 0.0;
		x[BaseUnits.Mole.ordinal()] = 0.0;
		x[BaseUnits.Radian.ordinal()] = 0.0;
		x[BaseUnits.Candela.ordinal()] = 0.0;
		x[BaseUnits.Bit.ordinal()] = 1.0;
		x[BaseUnits.Shannon.ordinal()] = 0.0;
		x[BaseUnits.Erlang.ordinal()] = 0.0;
		x[BaseUnits.Decibel.ordinal()] = 0.0;
		return Arrays.equals(x, u.dimensions);
	}
	
	public DataSpeed(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating a BitRate");
		this.unit = new Unit(q.unit);
	}

	public DataSpeed() {
		value = new UReal();
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an BitRate");
		this.unit = new Unit(unit);
	}

	public DataSpeed(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(double x, Unit unit) { // we only allow the same Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a BitRate");
		this.unit = new Unit(unit);
	}

	public DataSpeed(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a BitRate");
		this.unit = new Unit(unit);
	}

	public DataSpeed(String x) { // creates a BitRate from a string representing a
								// real, with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(String x, String u) { // creates a BitRate from two strings
										// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataSpeed(String x, String u, Unit unit) { // creates a BitRate from two
													// strings representing
													// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a BitRate");
		this.unit = new Unit(unit);
	}
	
	// Specific Type Operations
	public DataSpeed add(DataSpeed r) { // only works if compatible units && operand has
								// no offset
		return new DataSpeed(super.add(r));
	}

	public DataSpeed minus(DataSpeed r) { 
		return new DataSpeed(super.minus(r));
	}

	// power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity
	public boolean equals(DataSpeed r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(DataSpeed r) {
		return !(this.equals(r));
	}

	public DataSpeed floor() { // returns (i,u) with i the largest int such that
							// (i,u)<=(x,u) -- units maintained
		return new DataSpeed(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public DataSpeed min(DataSpeed r) { // units maintained
		if (r.lessThan(this))
			return new DataSpeed(r.getX(), r.getU(), r.getUnits());
		return new DataSpeed(this.getX(), this.getU(), this.getUnits());
	}

	public DataSpeed max(DataSpeed r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new DataSpeed(r.getX(), r.getU(), r.getUnits());
		return new DataSpeed(this.getX(), this.getU(), this.getUnits());
	}

	// working with constants (note that add and minus do not work here
	public DataSpeed mult(double r) {
		return new DataSpeed(this.value.mult(new UReal(r)), this.getUnits());
	}

	public DataSpeed divideBy(double r) {
		return new DataSpeed(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	public DataSpeed mult(UReal r) {
		return new DataSpeed(this.value.mult(r), this.getUnits());
	}

	public DataSpeed divideBy(UReal r) {
		return new DataSpeed(this.value.divideBy(r), this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly
	// from Quantity
	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public DataSpeed clone() {
		return new DataSpeed(this.getUReal(), this.getUnits());
	}
}
