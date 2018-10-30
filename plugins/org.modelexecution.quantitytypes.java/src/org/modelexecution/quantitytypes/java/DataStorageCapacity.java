package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class DataStorageCapacity extends Quantity {
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
		x[BaseUnits.Decibel.ordinal()] = 0.0;
		return Arrays.equals(x, u.dimensions);
	}
	
	public DataStorageCapacity(Quantity q) {
		value = q.value.clone();
		if (!checkUnit(q.unit))
			throw new RuntimeException("Invalid Unit for creating a DataStorageCapacity");
		this.unit = new Unit(q.unit);
	}

	public DataStorageCapacity() {
		value = new UReal();
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(UReal u) {
		value = u.clone();
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(UReal u, Unit unit) {
		value = u.clone();
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating an DataStorageCapacity");
		this.unit = new Unit(unit);
	}

	public DataStorageCapacity(double x) { // "promotes" a real x
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(double x, Unit unit) { // we only allow the same Units
		value = new UReal(x);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a DataStorageCapacity");
		this.unit = new Unit(unit);
	}

	public DataStorageCapacity(double x, double u, Unit unit) {
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a DataStorageCapacity");
		this.unit = new Unit(unit);
	}

	public DataStorageCapacity(String x) { // creates a DataStorageCapacity from a string representing a
								// real, with u=0.
		value = new UReal(x);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(String x, String u) { // creates a DataStorageCapacity from two strings
										// representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(BaseUnits.Bit);
	}

	public DataStorageCapacity(String x, String u, Unit unit) { // creates a DataStorageCapacity from two
													// strings representing
													// (x,u).
		value = new UReal(x, u);
		if (!checkUnit(unit))
			throw new RuntimeException("Invalid Unit for creating a DataStorageCapacity");
		this.unit = new Unit(unit);
	}
	
	// Specific Type Operations
	public DataStorageCapacity add(DataStorageCapacity r) { // only works if compatible units && operand has
								// no offset
		return new DataStorageCapacity(super.add(r));
	}

	public DataStorageCapacity minus(DataStorageCapacity r) { 
		return new DataStorageCapacity(super.minus(r));
	}

	public DataSpeed divideBy(Time r) { 
		return new DataSpeed(super.divideBy(r));
	}

	// power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity
	public boolean equals(DataStorageCapacity r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(DataStorageCapacity r) {
		return !(this.equals(r));
	}

	public DataStorageCapacity floor() { // returns (i,u) with i the largest int such that
							// (i,u)<=(x,u) -- units maintained
		return new DataStorageCapacity(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public DataStorageCapacity min(DataStorageCapacity r) { // units maintained
		if (r.lt(this))
			return new DataStorageCapacity(r.getX(), r.getU(), r.getUnits());
		return new DataStorageCapacity(this.getX(), this.getU(), this.getUnits());
	}

	public DataStorageCapacity max(DataStorageCapacity r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new DataStorageCapacity(r.getX(), r.getU(), r.getUnits());
		return new DataStorageCapacity(this.getX(), this.getU(), this.getUnits());
	}

	// working with constants (note that add and minus do not work here
	public DataStorageCapacity mult(double r) {
		return new DataStorageCapacity(this.value.mult(new UReal(r)), this.getUnits());
	}

	public DataStorageCapacity divideBy(double r) {
		return new DataStorageCapacity(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	public DataStorageCapacity mult(UReal r) {
		return new DataStorageCapacity(this.value.mult(r), this.getUnits());
	}

	public DataStorageCapacity divideBy(UReal r) {
		return new DataStorageCapacity(this.value.divideBy(r), this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly
	// from Quantity
	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public DataStorageCapacity clone() {
		return new DataStorageCapacity(this.getUReal(), this.getUnits());
	}
}
