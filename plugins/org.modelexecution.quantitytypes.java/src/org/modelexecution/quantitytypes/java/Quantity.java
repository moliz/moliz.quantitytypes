package org.modelexecution.quantitytypes.java;

public class Quantity implements Comparable<Quantity> {

	protected UReal value;
	protected Unit unit;

	/*
	 * Constructors
	 */
	public Quantity() {
		value = new UReal();
		unit = new Unit(); // dimensionless
	}

	public Quantity(UReal u, Unit unit) {
		value = u.clone();
		this.unit = new Unit(unit);
	}

	public Quantity(double x) { // "promotes" a real x to a dimensionless (x,0)
		value = new UReal(x, 0.0);
		unit = new Unit(); // dimensionless
	}

	public Quantity(double x, double u) {
		value = new UReal(x, u);
		unit = new Unit(); // dimensionless
	}

	public Quantity(double x, double u, Unit unit) {
		value = new UReal(x, u);
		this.unit = new Unit(unit);
	}

	public Quantity(String x) { // creates an Quantity from a string
								// representing a real, with u=0.
		value = new UReal(x);
		unit = new Unit(); // dimensionless
	}

	public Quantity(String x, String u) { // creates an Quantity from two
											// strings representing (x,u).
		value = new UReal(x, u);
		unit = new Unit(); // dimensionless
	}

	public Quantity(String x, String u, Unit unit) { // creates an Quantity from
														// two strings
														// representing (x,u).
		value = new UReal(x, u);
		this.unit = new Unit(unit);
	}

	/*
	 * Setters and getters
	 */
	public UReal getUReal() {
		return value;
	}

	public void setUReal(UReal x) {
		value = new UReal(x.getX(), x.getU());
	}

	public double getX() {
		return value.getX();
	}

	public void setX(double x) {
		value.setX(x);
	}

	public double getU() {
		return value.getU();
	}

	public void setU(double u) {
		value.setU(u);
		;
	}

	public Unit getUnits() {
		return unit;
	}

	public void setUnits(Unit unit) {
		this.unit = new Unit(unit);
	}

	public UReal getValue() {
		return value;
	}

	/*
	 * Auxiliary operations. They are made publicly available to help
	 */

	public boolean compatibleUnits(Quantity x) {
		return this.unit.isCompatibleWith(x.unit);
	}

	public boolean compatibleUnits(Unit u) {
		return this.unit.isCompatibleWith(u);
	}

	/*
	 * Unit Conversion Operations
	 */

	public Quantity convertTo(Unit u) { // Have to have compatible units
		Quantity result = null;
		if (this.compatibleUnits(u)) {
			// UReal value = this.value.mult(new
			// UReal(this.unit.factor()/u.factor(),0.0));
			// for (int i = 0; i<BaseUnits.values().length; i++) {
			// if ((this.unit.siUnit.dimensions[i]>=0.0) &&
			// (this.unit.offset[i]!=0.0)) {
			// value = value.add(new UReal(this.unit.offset[i]));
			// }
			// }
			// result= new Quantity(value,u);
			result = new Quantity(new UReal(), u).convertFromSIUnits(this.convertToSIUnits().value);
		} else
			throw new ArithmeticException("Unit mismatch: the units of the two quantities to convert do not coincide");
		return result;
	}

	public Quantity convertToSIUnits() {

		UReal value = this.value.mult(new UReal(this.unit.factor(), 0.0));

		// OFFSET: Not sure if this works well in the general case... NEED TO
		// CHECK....
		for (int i = 0; i < BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i] >= 0.0) && (this.unit.offset[i] != 0.0)) {
				value = value.add(new UReal(this.unit.offset[i]));
			}
		}
		return new Quantity(value, new Unit(unit.dimensions));
	}

	public Quantity convertFromSIUnits(UReal v) {// v is the value of the
													// quantity expressed in
													// SIUnits

		UReal value = v.mult(new UReal(1.0 / this.unit.factor(), 0.0));

		// OFFSET: Not sure if this works well in the general case... NEED TO
		// CHECK....
		for (int i = 0; i < BaseUnits.values().length; i++) {
			if ((this.unit.dimensions[i] >= 0.0) && (this.unit.offset[i] != 0.0)) {
				value = value.minus(new UReal(this.unit.offset[i] / this.unit.conversionFactor[i]));
			}
		}
		return new Quantity(value, unit);
	}

	/*
	 * 
	 * Type Operations
	 */

	public Quantity add(Quantity r) { // only works if compatible units
		Quantity result = null;
		if (this.compatibleUnits(r)) {
			Quantity other = r.convertTo(this.getUnits());
			result = new Quantity(this.getUReal().add(other.getUReal()), this.getUnits());
		} else
			throw new ArithmeticException("Unit mismatch: the units of the two quantities to add do not coincide");
		return result;
	}

	public Quantity minus(Quantity r) { // only works if compatible units
		Quantity result = null;
		if (this.compatibleUnits(r)) {
			Quantity other = r.convertTo(this.getUnits());
			result = new Quantity(this.getUReal().minus(other.getUReal()), this.getUnits());
		} else
			throw new ArithmeticException(
					"Unit mismatch: the units of the two quantities to substract do not coincide");
		return result;
	}

	public Quantity mult(Quantity r) { // both values and units are multiplied
		Quantity result = new Quantity();
		Quantity one = this.convertToSIUnits();
		Quantity other = r.convertToSIUnits();
		result.setUReal(one.getUReal().mult(other.getUReal()));
		result.setUnits(one.getUnits().multiplyUnits(other.getUnits()));
		return result;
	}

	public Quantity divideBy(Quantity r) { // both values and units are divided
		Quantity result = new Quantity();
		Quantity one = this.convertToSIUnits();
		Quantity other = r.convertToSIUnits();
		result.setUReal(one.getUReal().divideBy(other.getUReal()));
		result.setUnits(one.getUnits().divideUnits(other.getUnits()));
		return result;
	}

	public Quantity abs() { // units are maintained
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().abs());
		result.setUnits(this.getUnits());
		return result;
	}

	public Quantity neg() { // units are maintained
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().neg());
		result.setUnits(this.getUnits());
		return result;
	}

	public Quantity power(float s) { // unit are also powered
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().power(s));
		result.setUnits(this.getUnits().powerUnits(s));
		return result;
	}

	public Quantity sqrt() { // unit are also squared
		Quantity result = new Quantity();
		result.setUReal(this.getUReal().sqrt());
		result.setUnits(this.getUnits().powerUnits(0.5f));
		return result;
	}

	public boolean lessThan(Quantity r) { // only if same unit
		boolean result = false;
		if (r.compatibleUnits(this)) {
			result = this.getUReal().lessThan(r.convertTo(this.getUnits()).getUReal());
		} else
			throw new ArithmeticException("Unit mismatch: the units of the two quantities to compare do not coincide");
		return result;
	}

	public boolean lessEq(Quantity r) { // only if same unit
		boolean result = false;
		if (r.compatibleUnits(this)) {
			Quantity other = r.convertTo(this.getUnits());
			result = (this.lessThan(other) || this.equals(other));
		} else
			throw new ArithmeticException("Unit mismatch: the units of the two quantities to compare do not coincide");
		return result;
	}

	public boolean gt(Quantity r) { // only if same unit
		boolean result = false;
		if (r.compatibleUnits(this)) {
			result = r.convertTo(this.getUnits()).lessThan(this);
		} else
			throw new ArithmeticException("Unit mismatch: the units of the two quantities to compare do not coincide");
		return result;
	}

	public boolean ge(Quantity r) { // only if same unit
		boolean result = false;
		if (r.compatibleUnits(this)) {
			Quantity other = r.convertTo(this.getUnits());
			result = (this.gt(other) || this.equals(other));
		} else
			throw new ArithmeticException("Unit mismatch: the unit of the two quantities to compare do not coincide");

		return result;
	}

	public boolean equals(Quantity r) {
		return r.compatibleUnits(this) && this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(Quantity r) {
		return !(this.equals(r));
	}

	public Quantity inverse() { // inverse (reciprocal)
		return new Quantity(1.0).divideBy(this);
	}

	public Quantity floor() { // returns (i,u) with i the largest int such that
								// (i,u)<=(x,u) -- units maintained
		return new Quantity(Math.floor(this.getX()), this.getU(), this.getUnits());
	}

	public Quantity round() { // returns (i,u) with i the closest int to x --
								// units maintained
		return new Quantity(Math.round(this.getX()), this.getU(), this.getUnits());
	}

	public Quantity min(Quantity r) { // units maintained
		if (r.lessThan(this))
			return new Quantity(r.getX(), r.getU(), r.getUnits());
		return new Quantity(this.getX(), this.getU(), this.getUnits());
	}

	public Quantity max(Quantity r) { // unit maintained
		// if (r>this) r; else this;
		if (r.gt(this))
			return new Quantity(r.getX(), r.getU(), r.getUnits());
		return new Quantity(this.getX(), this.getU(), this.getUnits());
	}

	/***
	 * working with constants (note that add and minus will only work if "this"
	 * is dimensionless
	 */

	public Quantity sAdd(double r) {
		return this.add(new Quantity(r));
	}

	public Quantity sMinus(double r) {
		return this.minus(new Quantity(r));
	}

	public Quantity sMult(double r) {
		return new Quantity(this.value.mult(new UReal(r)), this.getUnits());
	}

	public Quantity sDivideBy(double r) {
		return new Quantity(this.value.divideBy(new UReal(r)), this.getUnits());
	}

	/*
	 * Conversions to basic types
	 */

	public String toString() {
		return value.toString() + unit.toString();
	}

	public int toInteger() { //
		return (int) Math.floor(this.getX());
	}

	public double toReal() {
		return this.getX();
	}

	/*
	 * Other Methods
	 */

	public int hashcode() { // required for equals()
		return Math.round((float) value.getX());
	}

	public Quantity clone() {
		return new Quantity(this.getUReal(), this.getUnits());
	}

	@Override
	public int compareTo(Quantity other) {
		if (this.equals(other))
			return 0;
		if (this.lessThan(other))
			return -1;
		return 1;
	}

}
