package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class Unit extends SIUnit implements Cloneable {
	protected String name = "";
	protected String symbol = "";

	// public SIUnit siUnit;
	// this attribute contains the reference to the dimensions in the SI and
	// their exponents

	protected double[] conversionFactor = new double[BaseUnits.values().length];
	// to convert to SI Units. They are all 1.0 by default.
	// for example, from Kilometer to Meter,
	// this.conversionFactor[BaseUnits.Meter.ordinal()]=1000
	// from Gram to Kilogram,
	// this.conversionFactor[BaseUnits.Kilogram.ordinal()]=0.001
	// conversion factors are not affected by exponents, they are considered
	// only when making the conversions

	protected double[] offset = new double[BaseUnits.values().length];
	// to convert to SI Units. They are all 0.0 by default.
	// for example, from Celsius to Kelvin,
	// this.offset[BaseUnits.Kelvin.ordinal()] = +273.15
	// offsets, as conversion factors, are not affected by exponents, they are
	// considered only when making the conversions

	// joining the two:
	// from Celsius to Kelvin,
	// this.conversionFactor[BaseUnits.Kelvin.ordinal()]=1.0;
	// this.offset[BaseUnits.Kelvin.ordinal()] = +273.15
	// from Farenheit to Kelvin,
	// this.conversionFactor[BaseUnits.Kelvin.ordinal()]=0.55555555556;
	// this.offset[BaseUnits.Kelvin.ordinal()] = +255.372222222;

	public Unit() { // Dimensionless
		super();
		this.name = "";
		this.symbol = "";
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
	}

	public Unit(String name, String symbol, double[] d, double[] c, double[] o) {
		super(d);
		this.name = name;
		this.symbol = symbol;
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		this.offset = Arrays.copyOf(o, BaseUnits.values().length);
	}

	public Unit(double[] d) {
		super(d);
		this.name = super.name();
		this.symbol = super.symbol();
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
	}

	public Unit(double[] d, double[] c, double[] o) {
		super(d);
		this.name = super.name();
		this.symbol = super.symbol();
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		this.offset = Arrays.copyOf(o, BaseUnits.values().length);
	}

	public Unit(BaseUnits d, double exp) {
		super(d, exp);
		this.name = super.name();
		this.symbol = super.symbol();
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
	}

	public Unit(BaseUnits d) {
		super(d);
		this.name = super.name();
		this.symbol = super.symbol();
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
	}

	public Unit(DerivedUnits d) {
		super(d);
		this.name = super.name();
		this.symbol = super.symbol();
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
	}

	public Unit(String name, String symbol, BaseUnits d, double exp, double conv, double offset) {
		super(d, exp);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
		this.conversionFactor[d.ordinal()] = conv;
		this.offset[d.ordinal()] = offset;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2) {
		super(d1, exp1, d2, exp2);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2, BaseUnits d3, double exp3, double conv3, double offset3) {
		super(d1, exp1, d2, exp2, d3, exp3);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
		this.conversionFactor[d3.ordinal()] = conv3;
		this.offset[d3.ordinal()] = offset3;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2, BaseUnits d3, double exp3, double conv3, double offset3,
			BaseUnits d4, double exp4, double conv4, double offset4) {
		super(d1, exp1, d2, exp2, d3, exp3, d4, exp4);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
		this.conversionFactor[d3.ordinal()] = conv3;
		this.offset[d3.ordinal()] = offset3;
		this.conversionFactor[d4.ordinal()] = conv4;
		this.offset[d4.ordinal()] = offset4;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2, BaseUnits d3, double exp3, double conv3, double offset3,
			BaseUnits d4, double exp4, double conv4, double offset4, BaseUnits d5, double exp5, double conv5,
			double offset5) {
		super(d1, exp1, d2, exp2, d3, exp3, d4, exp4, d5, exp5);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0);
		Arrays.fill(offset, 0.0);
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
		this.conversionFactor[d3.ordinal()] = conv3;
		this.offset[d3.ordinal()] = offset3;
		this.conversionFactor[d4.ordinal()] = conv4;
		this.offset[d4.ordinal()] = offset4;
		this.conversionFactor[d5.ordinal()] = conv5;
		this.offset[d5.ordinal()] = offset5;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2, BaseUnits d3, double exp3, double conv3, double offset3,
			BaseUnits d4, double exp4, double conv4, double offset4, BaseUnits d5, double exp5, double conv5,
			double offset5, BaseUnits d6, double exp6, double conv6, double offset6) {
		super(d1, exp1, d2, exp2, d3, exp3, d4, exp4, d5, exp5, d6, exp6);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
		this.conversionFactor[d3.ordinal()] = conv3;
		this.offset[d3.ordinal()] = offset3;
		this.conversionFactor[d4.ordinal()] = conv4;
		this.offset[d4.ordinal()] = offset4;
		this.conversionFactor[d5.ordinal()] = conv5;
		this.offset[d5.ordinal()] = offset5;
		this.conversionFactor[d6.ordinal()] = conv6;
		this.offset[d6.ordinal()] = offset6;
	}

	public Unit(String name, String symbol, BaseUnits d1, double exp1, double conv1, double offset1, BaseUnits d2,
			double exp2, double conv2, double offset2, BaseUnits d3, double exp3, double conv3, double offset3,
			BaseUnits d4, double exp4, double conv4, double offset4, BaseUnits d5, double exp5, double conv5,
			double offset5, BaseUnits d6, double exp6, double conv6, double offset6, BaseUnits d7, double exp7,
			double conv7, double offset7) {
		super(d1, exp1, d2, exp2, d3, exp3, d4, exp4, d5, exp5, d6, exp6, d7, exp7);
		this.name = name;
		this.symbol = symbol;
		this.conversionFactor[d1.ordinal()] = conv1;
		this.offset[d1.ordinal()] = offset1;
		this.conversionFactor[d2.ordinal()] = conv2;
		this.offset[d2.ordinal()] = offset2;
		this.conversionFactor[d3.ordinal()] = conv3;
		this.offset[d3.ordinal()] = offset3;
		this.conversionFactor[d4.ordinal()] = conv4;
		this.offset[d4.ordinal()] = offset4;
		this.conversionFactor[d5.ordinal()] = conv5;
		this.offset[d5.ordinal()] = offset5;
		this.conversionFactor[d6.ordinal()] = conv6;
		this.offset[d6.ordinal()] = offset6;
		this.conversionFactor[d7.ordinal()] = conv7;
		this.offset[d7.ordinal()] = offset7;
	}

	public Unit(SIUnit u) {
		super(u);
		this.name = u.name();
		this.symbol = u.symbol();
		Arrays.fill(this.conversionFactor, 1.0);
		Arrays.fill(this.offset, 0.0);
	}

	public Unit(Unit u) {
		this.name = u.name;
		this.symbol = u.symbol;
		this.dimensions = Arrays.copyOf(u.dimensions, this.dimensions.length);
		this.conversionFactor = Arrays.copyOf(u.conversionFactor, this.conversionFactor.length);
		this.offset = Arrays.copyOf(u.offset, this.offset.length);
	}

	/*
	 * Queries, etc
	 */
	public double factor() {
		double f = 1.0;
		for (int i = 0; i < BaseUnits.values().length; i++)
			f *= (Math.pow(conversionFactor[i], dimensions[i]));
		return f;
	}

	public String name() {
		return this.name;
	}

	public String symbol() {
		return this.symbol;
	}

	public boolean equals(Unit u) { // hascode() from super.

		// we do not care about the name and symbols, focusing only on
		// the dimensions, conversion factors and offsets
		return Arrays.equals(this.conversionFactor, u.conversionFactor) && Arrays.equals(this.offset, u.offset)
				&& Arrays.equals(this.dimensions, u.dimensions);
	}

	public boolean isCompatibleWith(Unit u) {
		return Arrays.equals(this.dimensions, u.dimensions);
	}

	public Unit clone() {
		return new Unit(this);
	}

	/*
	 * Operations
	 */

	public Unit multiplyUnits(Unit u) {
		// resulting units expressed in SIUnits
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] + u.dimensions[i]; // they are
																// exponents
		}
		SIUnit siu = new SIUnit(result);
		return new Unit(siu.name(), siu.symbol(), result, this.conversionFactor, this.offset);
	}

	public Unit divideUnits(Unit u) {
		// resulting units expressed in SIUnits
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] - u.dimensions[i]; // they are
																// exponents
		}
		SIUnit siu = new SIUnit(result);
		return new Unit(siu.name(), siu.symbol(), result, this.conversionFactor, this.offset);
	}

	public Unit powerUnits(float s) {
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] * s; // they are exponents
		}
		SIUnit siu = new SIUnit(result);
		return new Unit(siu.name(), siu.symbol(), result, this.conversionFactor, this.offset);
	}

	public String toString() {
		String s = "<" + name + ";" + symbol + ";" + (new SIUnit(dimensions)) + ";[" + conversionFactor[0];
		for (int i = 1; i < this.conversionFactor.length; i++) {
			s += "," + this.conversionFactor[i];
		}
		;
		s += "];[" + offset[0];
		for (int i = 1; i < this.offset.length; i++) {
			s += "," + this.offset[i];
		}
		;
		return s + "]";
	}
}
