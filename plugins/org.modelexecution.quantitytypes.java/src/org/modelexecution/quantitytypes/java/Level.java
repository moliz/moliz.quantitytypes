package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class Level extends Quantity {
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
		x[BaseUnits.Bit.ordinal()] = 1.0;
		x[BaseUnits.Shannon.ordinal()] = 0.0;
		x[BaseUnits.Erlang.ordinal()] = 0.0;
		x[BaseUnits.Decibel.ordinal()] = 1.0;
		return Arrays.equals(x, u.dimensions);
	}
	
	public Level(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating a Level");
		this.unit = new Unit(q.unit);
	}

	public Level() {
		value = new UReal();
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an Level");
		this.unit = new Unit(unit);
	}

	public Level(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(double x, Unit unit) { // we only allow the same Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Level");
		this.unit = new Unit(unit);
	}

	public Level(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Level");
		this.unit = new Unit(unit);
	}

	public Level(String x) { // creates a Level from a string representing a
								// real, with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(String x, String u) { // creates a Level from two strings
										// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Decibel);
	}

	public Level(String x, String u, Unit unit) { // creates a Level from two
													// strings representing
													// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a Level");
		this.unit = new Unit(unit);
	}
	
	// Specific Type Operations
		public Level add(Level r) { // only works if
															// compatible units &&
															// operand has
			// no offset
			return new Level(super.add(r));
		}

		public Level minus(Level r) {
			return new Level(super.minus(r));
		}

		// power(s), and inverse() return Quantity
		// lessThan, LessEq, gt, ge all directly from Quantity
		public boolean equals(Level r) {
			return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
		}

		public boolean distinct(Level r) {
			return !(this.equals(r));
		}

		public Level floor() { // returns (i,u) with i the largest int
											// such that
			// (i,u)<=(x,u) -- units maintained
			return new Level(Math.floor(this.getX()), this.getU(), this.getUnits());
		}

		public Level min(Level r) { // units maintained
			if (r.lessThan(this))
				return new Level(r.getX(), r.getU(), r.getUnits());
			return new Level(this.getX(), this.getU(), this.getUnits());
		}

		public Level max(Level r) { // unit maintained
			// if (r>this) r; else this;
			if (r.gt(this))
				return new Level(r.getX(), r.getU(), r.getUnits());
			return new Level(this.getX(), this.getU(), this.getUnits());
		}

		// working with constants (note that add and minus do not work here
		public Level mult(double r) {
			return new Level(this.value.mult(new UReal(r)), this.getUnits());
		}

		public Level divideBy(double r) {
			return new Level(this.value.divideBy(new UReal(r)), this.getUnits());
		}

		public Level mult(UReal r) {
			return new Level(this.value.mult(r), this.getUnits());
		}

		public Level divideBy(UReal r) {
			return new Level(this.value.divideBy(r), this.getUnits());
		}

		// Conversions to basic types: toString, toInteger, toReal, etc. directly
		// from Quantity
		public int hashcode() { // required for equals()
			return Math.round((float) value.getX());
		}

		public Level clone() {
			return new Level(this.getUReal(), this.getUnits());
		}
}
