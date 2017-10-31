package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class Entropy extends Quantity {
	static protected boolean checkUnit(Unit u) {
		double[] x = new double[BaseUnits.values().length];
		x[BaseUnits.Shannon.ordinal()] = 0.0;
		x[BaseUnits.Kilogram.ordinal()] = 0.0;
		x[BaseUnits.Second.ordinal()] = 0.0;
		x[BaseUnits.Ampere.ordinal()] = 0.0;
		x[BaseUnits.Kelvin.ordinal()] = 0.0;
		x[BaseUnits.Mole.ordinal()] = 0.0;
		x[BaseUnits.Radian.ordinal()] = 0.0;
		x[BaseUnits.Candela.ordinal()] = 0.0;
		x[BaseUnits.Bit.ordinal()] = 0.0;
		x[BaseUnits.Shannon.ordinal()] = 1.0;
		x[BaseUnits.Erlang.ordinal()] = 0.0;
		x[BaseUnits.Decibel.ordinal()] = 0.0;
		return Arrays.equals(x, u.dimensions);
	}
	
	public Entropy(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating an Entropy");
		this.unit = new Unit(q.unit);
	}

	public Entropy() {
		value = new UReal();
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an Entropy");
		this.unit = new Unit(unit);
	}

	public Entropy(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(double x, Unit unit) { // we only allow the same Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Entropy");
		this.unit = new Unit(unit);
	}

	public Entropy(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Entropy");
		this.unit = new Unit(unit);
	}

	public Entropy(String x) { // creates a Entropy from a string representing a
								// real, with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(String x, String u) { // creates a Entropy from two strings
										// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public Entropy(String x, String u, Unit unit) { // creates a Entropy from two
													// strings representing
													// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Entropy");
		this.unit = new Unit(unit);
	}
	
	// Specific Type Operations
	public Entropy add(Entropy r) { // only works if compatible units && operand has
								// no offset
		return new Entropy(super.add(r));
	}

	public Entropy minus(Entropy r) { 
		return new Entropy(super.minus(r));
	}

	// power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity
	public boolean equals(Entropy r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Entropy r) {
		return !(this.equals(r));
	}

	public Entropy floor() { // returns (i,u) with i the largest int such that
							// (i,u)<=(x,u) -- units maintained
		return new Entropy(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public Entropy min(Entropy r) { // units maintained
		if (r.lessThan(this))
			return new Entropy(r.getX(), r.getU(), r.getUnits());
		return new Entropy(this.getX(), this.getU(), this.getUnits());
	}

	public Entropy max(Entropy r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new Entropy(r.getX(), r.getU(), r.getUnits());
		return new Entropy(this.getX(), this.getU(), this.getUnits());
	}

	// working with constants (note that add and minus do not work here
	public Entropy mult(double r) {
		return new Entropy(this.value.mult(new UReal(r)), this.getUnits());
	}

	public Entropy divideBy(double r) {
		return new Entropy(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	public Entropy mult(UReal r) {
		return new Entropy(this.value.mult(r), this.getUnits());
	}

	public Entropy divideBy(UReal r) {
		return new Entropy(this.value.divideBy(r), this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly
	// from Quantity
	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public Entropy clone() {
		return new Entropy(this.getUReal(), this.getUnits());
	}
}
