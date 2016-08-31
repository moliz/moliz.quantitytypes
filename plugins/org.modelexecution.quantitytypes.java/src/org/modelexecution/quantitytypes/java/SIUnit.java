package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class SIUnit implements Cloneable {

	/*
	 * ATTRIBUTES
	 */

	protected double[] dimensions = new double[BaseUnits.values().length];
	// exponents for each dimension.
	// [Meter, Kilogram, Second, Ampere, Kelvin, Mole, Candela]

	/*
	 * STATIC VARIABLES
	 */

	public final static String[] BaseUnitNames = { "Meter", "Kilogram", "Second", "Ampere", "Kelvin", "Mole", "Candela",
			"Radian", "Steradian" };

	public final static String[] DerivedUnitNames = { "Gray", "GrayPerSecond", "Becquerel", "MolePerCubicMeter",
			"MolePerKilogram", "RadianPerSecondSquared", "KilogramMeterSquared", "JouleSecond", "RadianPerSecond",
			"SquareMeter", "SquareMeterSteradian", "SquareMeterKelvin", "SquareMeterPerKelvin", "Farad", "Katal",
			"WattPerSquareMeterKelvin", "KilogramPerCubicMeter", "Sievert", "PascalSecond", "Coulomb",
			"CoulombPerMeter", "CoulombPerCubicMeter", "CoulombPerMole", "AmperePerSquareMeter", "AmperePerRadian",
			"CoulombMeter", "VoltPerMeter", "CoulombPerSquareMeter", "Siemens", "Volt", "JoulePerCubicMeter", "Joule",
			"JoulePerSquareMeter", "CoulombPerKilogram", "Newton", "NewtonPerCoulomb", "NewtonPerMeter", "Hertz",
			"CubicMeterPerKilogramSecondSquared", "JoulePerKelvin", "Lux", "Henry", "PerMole", "MeterPerFarad",
			"SquareMeterPerSecond", "MeterKilogram", "MeterKelvin", "MeterPerSecondSquared", "KilogramMeterPerSecond",
			"MeterPerKelvin", "MeterPerSecond", "CandelaPerSquareMeter", "Lumen", "JoulePerTesla", "AmpereTurnPerMeter",
			"Weber", "Tesla", "AmpereTurn", "KilogramKelvin", "KilogramPerSecond", "KilogramPerSquareMeter",
			"KilogramPerMeter", "JoulePerMole", "JoulePerMoleKelvin", "HenryPerMeter", "FaradPerMeter", "Radian",
			"Watt", "WattPerSteradian", "WattPerSquareMeterSteradian", "WattPerSquareMeter", "Pascal", "Ohm",
			"Steradian", "JoulePerKilogram", "JoulePerKilogramKelvin", "JoulePerKilogramKelvinPerPascal",
			"JoulePerKilogramKelvinPerCubicMeter", "MoleKelvin", "WattPerMeterKelvin", "SquareMeterKelvinPerWatt",
			"KelvinPerWatt", "MeterKelvinPerWatt", "NewtonPerKilogram", "SecondTimeSquared", "Torque", "CubicMeter",
			"CubicMeterPerKelvin", "CubicMeterPerSecond", "JoulePerCubicMeterKelvin" };

	public final static String[] BaseUnitSymbols = { "m", "kg", "s", "A", "K", "mol", "cd", "rad", "sr" };

	public final static String[] DerivedUnitSymbols = { "Gy", "Gy/s", "Bq", "mol/m^3", "mol/kg", "1/s^2", "kg*m^2",
			"J*s", "1/s", "m^2", "m^2", "m^2*K", "m^2/K", "F", "kat", "W/(m^2*K)", "kg/m^3", "Sv", "Pa*s", "C", "C/m",
			"C/m^3", "C/mol", "A/m^2", "A", "C*m", "V/m", "C/m^2", "S", "V", "J/m^3", "J", "J/m^2", "C/kg", "N", "N/C",
			"N/m", "Hz", "m^3/(kg*s^2)", "J/K", "Lx", "H", "1/mol", "m/F", "m^2/s", "m*kg", "m*K", "m/s^2", "kg*m/s",
			"m/K", "m/s", "cad/m^2", "lm", "J/T", "AT/m", "Wb", "T", "AT", "kg*K", "kg/s", "kg/m^2", "kg/m", "J/mol",
			"J/(mol*K)", "H/m", "F/m", "", "W", "W", "W/m^2", "W/m^2", "Pa", "Ohm", "", "J/kg", "J/(kg*K)",
			"J/(kg*K*Pa)", "J/(kg*K*m^3)", "mol*K", "W/(m*K)", "m^2/W", "K/W", "m*K/W", "N/kg", "s^2", "N*m", "m^3",
			"m^3/K", "m^3/s", "J/(m^3*K)" };

	/*
	 * HELPERS
	 */

	public static BaseUnits unitOfTheDimension(BaseDimensions d) {
		return BaseUnits.values()[d.ordinal()];
	}

	public static DerivedUnits unitOfTheDimension(DerivedDimensions d) {
		return DerivedUnits.values()[d.ordinal()];
	}

	public static BaseDimensions dimensionOfUnit(BaseUnits u) {
		return BaseDimensions.values()[u.ordinal()];
	}

	public static DerivedDimensions dimensionOfUnit(DerivedUnits u) {
		return DerivedDimensions.values()[u.ordinal()];
	}

	private void fillDim(BaseUnits d, double exp) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d.ordinal()] = exp;
	}

	private void fillDim(BaseUnits d1, double exp1, BaseUnits d2, double exp2) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
	}

	private void fillDim(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
	}

	private void fillDim(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
	}

	private void fillDim(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4, BaseUnits d5, double exp5) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
		dimensions[d5.ordinal()] = exp5;
	}

	/*
	 * CONSTRUCTORS
	 */

	public SIUnit() {
		Arrays.fill(dimensions, 0.0); // dimensionless
	}

	public SIUnit(double[] d) {
		this.dimensions = Arrays.copyOf(d, this.dimensions.length);
	}

	private int find(String[] array, String value) {
		// auxiliary method because Array does not have "indexOf()"
		for (int i = 0; i < array.length; i++)
			if (array[i] == value)
				return i;
		return -1;
	}

	public SIUnit(String symbol) {
		Arrays.fill(dimensions, 0.0);
		int p = find(BaseUnitSymbols, symbol);
		if (p > -1)
			dimensions[p] = 1.0;
		else {
			p = find(DerivedUnitSymbols, symbol);
			if (p > -1)
				fillDimensions(DerivedUnits.values()[p]);
		}
	}

	public SIUnit(BaseUnits d) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d.ordinal()] = 1.0;
	}

	public SIUnit(BaseUnits d, double exp) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d.ordinal()] = exp;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4, BaseUnits d5, double exp5) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
		dimensions[d5.ordinal()] = exp5;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4, BaseUnits d5, double exp5, BaseUnits d6, double exp6) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
		dimensions[d5.ordinal()] = exp5;
		dimensions[d6.ordinal()] = exp6;
	}

	public SIUnit(BaseUnits d1, double exp1, BaseUnits d2, double exp2, BaseUnits d3, double exp3, BaseUnits d4,
			double exp4, BaseUnits d5, double exp5, BaseUnits d6, double exp6, BaseUnits d7, double exp7) {
		Arrays.fill(dimensions, 0.0);
		dimensions[d1.ordinal()] = exp1;
		dimensions[d2.ordinal()] = exp2;
		dimensions[d3.ordinal()] = exp3;
		dimensions[d4.ordinal()] = exp4;
		dimensions[d5.ordinal()] = exp5;
		dimensions[d6.ordinal()] = exp6;
		dimensions[d7.ordinal()] = exp7;
	}

	public SIUnit(SIUnit u) {
		this.dimensions = Arrays.copyOf(u.dimensions, this.dimensions.length);
	}

	public SIUnit(DerivedUnits d) {
		Arrays.fill(dimensions, 0.0);
		fillDimensions(d);
	}

	private void fillDimensions(DerivedUnits d) {

		switch (d) {
		case Gray:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0);
			break;
		case GrayPerSecond:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -3.0);
			break;
		case Becquerel:
			fillDim(BaseUnits.Second, -1.0);
			break;
		case MolePerCubicMeter:
			fillDim(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0);
			break;
		case MolePerKilogram:
			fillDim(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0);
			break;
		case RadianPerSecondSquared:
			fillDim(BaseUnits.Second, -2.0, BaseUnits.Radian, 1.0);
			break;
		case KilogramMeterSquared:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0);
			break;
		case JouleSecond:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0);
			break;
		case RadianPerSecond:
			fillDim(BaseUnits.Second, -1.0, BaseUnits.Radian, 1.0);
			break;
		case SquareMeter:
			fillDim(BaseUnits.Meter, 2.0);
			break;
		case SquareMeterSteradian:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Steradian, 1.0);
			break;
		case SquareMeterKelvin:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, 1.0);
			break;
		case SquareMeterPerKelvin:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, -1.0);
			break;
		case Farad:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere, 2.0);
			break;
		case Katal:
			fillDim(BaseUnits.Second, -1.0, BaseUnits.Mole, 1.0);
			break;
		case WattPerSquareMeterKelvin:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin, -1.0);
			break;
		case KilogramPerCubicMeter:
			fillDim(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, 1.0);
			break;
		case Sievert:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0);
			break;
		case PascalSecond:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0);
			break;
		case Coulomb:
			fillDim(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0);
			break;
		case CoulombPerMeter:
			fillDim(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -1.0);
			break;
		case CoulombPerCubicMeter:
			fillDim(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -3.0);
			break;
		case CoulombPerMole:
			fillDim(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Mole, -1.0);
			break;
		case AmperePerSquareMeter:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Ampere, 1.0);
			break;
		case AmperePerRadian:
			fillDim(BaseUnits.Ampere, 1.0, BaseUnits.Radian, -1.0);
			break;
		case CoulombMeter:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0);
			break;
		case VoltPerMeter:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -1.0);
			break;
		case CoulombPerSquareMeter:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0);
			break;
		case Siemens:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Ampere, 2.0);
			break;
		case Volt:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, 1.0);
			break;
		case JoulePerCubicMeter:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case Joule:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case JoulePerSquareMeter:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case CoulombPerKilogram:
			fillDim(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0);
			break;
		case Newton:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0);
			break;
		case NewtonPerCoulomb:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -1.0);
			break;
		case NewtonPerMeter:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case Hertz:
			fillDim(BaseUnits.Second, -1.0);
			break;
		case CubicMeterPerKilogramSecondSquared:
			fillDim(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Second, -2.0);
			break;
		case JoulePerKelvin:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0);
			break;
		// case Watt: duplicated
		// case WattPerSquareMeter: duplicated
		case Lux:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0, BaseUnits.Radian, 1.0);
			break;
		case Henry:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -2.0);
			break;
		case PerMole:
			fillDim(BaseUnits.Mole, -1.0);
			break;
		case MeterPerFarad:
			fillDim(BaseUnits.Meter, 3, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -4, BaseUnits.Ampere, -2.0);
			break;
		case SquareMeterPerSecond:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -1.0);
			break;
		case MeterKilogram:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0);
			break;
		case MeterKelvin:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, 1.0);
			break;
		case MeterPerSecondSquared:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0);
			break;
		case KilogramMeterPerSecond:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0);
			break;
		case MeterPerKelvin:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, -1.0);
			break;
		case MeterPerSecond:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Second, -1.0);
			break;
		case CandelaPerSquareMeter:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0);
			break;
		case Lumen:
			fillDim(BaseUnits.Candela, 1.0, BaseUnits.Radian, 1.0);
			break;
		case JoulePerTesla:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Ampere, 1.0);
			break;
		case AmpereTurnPerMeter:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Ampere, 1.0);
			break;
		case Weber:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -1.0);
			break;
		case Tesla:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -1.0);
			break;
		case AmpereTurn:
			fillDim(BaseUnits.Ampere, 1.0, BaseUnits.Radian, 1.0);
			break;
		case KilogramKelvin:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Kelvin, 1.0);
			break;
		case KilogramPerSecond:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0);
			break;
		case KilogramPerSquareMeter:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -2.0);
			break;
		case KilogramPerMeter:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -1.0);
			break;
		case JoulePerMole:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Mole, -1.0);
			break;
		case JoulePerMoleKelvin:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0,
					BaseUnits.Mole, -1.0);
			break;
		case HenryPerMeter:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -2.0);
			break;
		case FaradPerMeter:
			fillDim(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere, 2.0);
			break;
		case Radian:
			fillDim(BaseUnits.Radian, 1.0);
			break;
		case Watt:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0);
			break;
		case WattPerSteradian:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Steradian, -1.0);
			break;
		case WattPerSquareMeterSteradian:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Steradian, -1.0); // ,
			break;
		case WattPerSquareMeter:
			fillDim(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0);
			break;
		case Pascal:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case Ohm:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -2.0);
			break;
		case Steradian:
			fillDim(BaseUnits.Steradian, 1.0);
			break;
		case JoulePerKilogram:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0);
			break;
		case JoulePerKilogramKelvin:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0);
			break;
		case JoulePerKilogramKelvinPerPascal:
			fillDim(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Kelvin, -1.0);
			break;
		case JoulePerKilogramKelvinPerCubicMeter:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0);
			break;
		case MoleKelvin:
			fillDim(BaseUnits.Kelvin, 1.0, BaseUnits.Mole, 1.0);
			break;
		case WattPerMeterKelvin:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin, -1.0);
			break;
		// case SquareMeterPerSecond: duplicated
		case SquareMeterKelvinPerWatt:
			fillDim(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0);
			break;
		case KelvinPerWatt:
			fillDim(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0);
			break;
		case MeterKelvinPerWatt:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0);
			break;
		case NewtonPerKilogram:
			fillDim(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0);
			break;
		case SecondTimeSquared:
			fillDim(BaseUnits.Second, 2.0);
			break;
		case NewtonMeter:
			fillDim(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0);
			break;
		case CubicMeter:
			fillDim(BaseUnits.Meter, 3.0);
			break;
		case CubicMeterPerKelvin:
			fillDim(BaseUnits.Meter, 3, BaseUnits.Kelvin, -1.0);
			break;
		case CubicMeterPerSecond:
			fillDim(BaseUnits.Meter, 3, BaseUnits.Second, -1.0);
			break;
		case JoulePerCubicMeterKelvin:
			fillDim(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0);
		}
	}

	/*
	 * methods
	 */

	public double[] dimensions() {
		return this.dimensions;
	}

	public int hashcode() { // required for equals()
		double x = 0.0;
		for (int i = 0; i < dimensions.length; i++)
			x += dimensions[i];
		return (int) Math.round(x);
	}

	public boolean equals(SIUnit u) {
		return Arrays.equals(this.dimensions, u.dimensions);
	}

	public boolean isBaseUnit() {
		int zeros = 0;
		int unos = 0;
		for (int i = 0; i < dimensions.length; i++) {
			if (dimensions[i] == 0.0)
				zeros++;
			if (dimensions[i] == 1.0)
				unos++;
		}
		return (zeros == dimensions.length - 1) // all zeros (dimensionless) or
												// all zeros but 1.
				&& (unos == 1); // and one 1 or none
	}

	public boolean isDimensionless() {
		for (int i = 0; i < dimensions.length; i++) {
			if (dimensions[i] != 0.0)
				return false;
		}
		return true; // all exponents should be 0.0
	}

	public SIUnit clone() {
		return new SIUnit(this);
	}

	public SIUnit multiplyUnits(SIUnit x) {
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] + x.dimensions[i]; // they are
																// exponents
		}
		return new SIUnit(result);
	}

	public SIUnit divideUnits(SIUnit x) {
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] - x.dimensions[i]; // they are
																// exponents
		}
		return new SIUnit(result);
	}

	public SIUnit powerUnits(float s) {
		double[] result = new double[dimensions.length];
		for (int i = 0; i < this.dimensions.length; i++) {
			result[i] = this.dimensions[i] * s; // they are exponents
		}
		return new SIUnit(result);
	}

	public String toString() {
		String s = "[" + dimensions[0];
		for (int i = 1; i < this.dimensions.length; i++) {
			s += "," + this.dimensions[i];
		}
		return s + "]";
	}

	public DerivedUnits toDerivedUnits() {
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.Gray;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -3.0).equals(this))
			return DerivedUnits.GrayPerSecond;
		if (new SIUnit(BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.Becquerel;
		if (new SIUnit(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0).equals(this))
			return DerivedUnits.MolePerCubicMeter;
		if (new SIUnit(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0).equals(this))
			return DerivedUnits.MolePerKilogram;
		if (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Second, -2.0).equals(this)) //
			return DerivedUnits.RadianPerSecondSquared;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0).equals(this))
			return DerivedUnits.KilogramMeterSquared;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.JouleSecond;
		if (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Second, -1.0).equals(this)) //
			return DerivedUnits.RadianPerSecond;
		if (new SIUnit(BaseUnits.Meter, 2.0).equals(this))
			return DerivedUnits.SquareMeter;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Steradian, 1.0).equals(this)) //
			return DerivedUnits.SquareMeterSteradian;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, 1.0).equals(this))
			return DerivedUnits.SquareMeterKelvin;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.SquareMeterPerKelvin;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere, 2.0)
				.equals(this))
			return DerivedUnits.Farad;
		if (new SIUnit(BaseUnits.Second, -1.0, BaseUnits.Mole, 1.0).equals(this))
			return DerivedUnits.Katal;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.WattPerSquareMeterKelvin;
		if (new SIUnit(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, 1.0).equals(this))
			return DerivedUnits.KilogramPerCubicMeter;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.Sievert;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.PascalSecond;
		if (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.Coulomb;
		if (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -1.0).equals(this))
			return DerivedUnits.CoulombPerMeter;
		if (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -3.0).equals(this))
			return DerivedUnits.CoulombPerCubicMeter;
		if (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Mole, -1.0).equals(this))
			return DerivedUnits.CoulombPerMole;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.AmperePerSquareMeter;
		if (new SIUnit(BaseUnits.Ampere, 1.0, BaseUnits.Radian, -1.0).equals(this)) //
			return DerivedUnits.AmperePerRadian;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.CoulombMeter;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -1.0)
				.equals(this))
			return DerivedUnits.VoltPerMeter;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.CoulombPerSquareMeter;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Ampere, 2.0)
				.equals(this))
			return DerivedUnits.Siemens;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, 1.0)
				.equals(this))
			return DerivedUnits.Volt;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.JoulePerCubicMeter;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.Joule;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.JoulePerSquareMeter;
		if (new SIUnit(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.CoulombPerKilogram;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.Newton;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -1.0)
				.equals(this))
			return DerivedUnits.NewtonPerCoulomb;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.NewtonPerMeter;
		if (new SIUnit(BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.Hertz;
		if (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.CubicMeterPerKilogramSecondSquared;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0)
				.equals(this))
			return DerivedUnits.JoulePerKelvin;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0, BaseUnits.Radian, 1.0).equals(this)) //
			return DerivedUnits.Lux;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -2.0)
				.equals(this))
			return DerivedUnits.Henry;
		if (new SIUnit(BaseUnits.Mole, -1.0).equals(this))
			return DerivedUnits.PerMole;
		if (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -4, BaseUnits.Ampere, -2.0)
				.equals(this))
			return DerivedUnits.MeterPerFarad;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.SquareMeterPerSecond;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0).equals(this))
			return DerivedUnits.MeterKilogram;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, 1.0).equals(this))
			return DerivedUnits.MeterKelvin;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.MeterPerSecondSquared;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.KilogramMeterPerSecond;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.MeterPerKelvin;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.MeterPerSecond;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0).equals(this))
			return DerivedUnits.CandelaPerSquareMeter;
		if (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Candela, 1.0).equals(this)) // ,
			return DerivedUnits.Lumen;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.JoulePerTesla;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Ampere, 1.0).equals(this))
			return DerivedUnits.AmpereTurnPerMeter;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -1.0)
				.equals(this))
			return DerivedUnits.Weber;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -1.0).equals(this))
			return DerivedUnits.Tesla;
		if (new SIUnit(BaseUnits.Ampere, 1.0, BaseUnits.Radian, 1.0).equals(this)) //
			return DerivedUnits.AmpereTurn;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Kelvin, 1.0).equals(this))
			return DerivedUnits.KilogramKelvin;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.KilogramPerSecond;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -2.0).equals(this))
			return DerivedUnits.KilogramPerSquareMeter;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -1.0).equals(this))
			return DerivedUnits.KilogramPerMeter;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Mole, -1.0)
				.equals(this))
			return DerivedUnits.JoulePerMole;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0,
				BaseUnits.Mole, -1.0).equals(this))
			return DerivedUnits.JoulePerMoleKelvin;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -2.0)
				.equals(this))
			return DerivedUnits.HenryPerMeter;
		if (new SIUnit(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere, 2.0)
				.equals(this))
			return DerivedUnits.FaradPerMeter;
		if (new SIUnit(BaseUnits.Radian, 1.0).equals(this)) //
			return DerivedUnits.Radian;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this))
			return DerivedUnits.Watt;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Steradian, -1.0)
				.equals(this)) //
			return DerivedUnits.WattPerSteradian;
		if (new SIUnit(BaseUnits.Steradian, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this)) //
			return DerivedUnits.WattPerSquareMeterSteradian;
		if (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this))
			return DerivedUnits.WattPerSquareMeter;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.Pascal;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere, -2.0)
				.equals(this))
			return DerivedUnits.Ohm;
		if (new SIUnit(BaseUnits.Steradian, 1.0).equals(this)) //
			return DerivedUnits.Steradian;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.JoulePerKilogram;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvin;
		if (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvinPerPascal;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvinPerCubicMeter;
		if (new SIUnit(BaseUnits.Kelvin, 1.0, BaseUnits.Mole, 1.0).equals(this))
			return DerivedUnits.MoleKelvin;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin, -1.0)
				.equals(this))
			return DerivedUnits.WattPerMeterKelvin;
		if (new SIUnit(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0).equals(this))
			return DerivedUnits.SquareMeterKelvinPerWatt;
		if (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0)
				.equals(this))
			return DerivedUnits.KelvinPerWatt;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0)
				.equals(this))
			return DerivedUnits.MeterKelvinPerWatt;
		if (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.NewtonPerKilogram;
		if (new SIUnit(BaseUnits.Second, 2.0).equals(this))
			return DerivedUnits.SecondTimeSquared;
		if (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
			return DerivedUnits.NewtonMeter;
		if (new SIUnit(BaseUnits.Meter, 3.0).equals(this))
			return DerivedUnits.CubicMeter;
		if (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kelvin, -1.0).equals(this))
			return DerivedUnits.CubicMeterPerKelvin;
		if (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Second, -1.0).equals(this))
			return DerivedUnits.CubicMeterPerSecond;
		if (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0)
				.equals(this))
			return DerivedUnits.JoulePerCubicMeterKelvin;
		return null;
	}

	public boolean isDerivedUnit() {

		return (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Mole, 1.0, BaseUnits.Meter, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Second, -2.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Second, -1.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 2.0).equals(this))
				|| (new SIUnit(BaseUnits.Steradian, 1.0, BaseUnits.Meter, 2.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere,
						2.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, -1.0, BaseUnits.Mole, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Meter, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0, BaseUnits.Mole, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Ampere, 1.0, BaseUnits.Radian, -1.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Ampere,
						2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere,
						1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 1.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0, BaseUnits.Radian, 1.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere,
						-2.0).equals(this))
				|| (new SIUnit(BaseUnits.Mole, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -4, BaseUnits.Ampere,
						-2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Candela, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Radian, 1.0, BaseUnits.Candela, 1.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Ampere, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Ampere, 1.0, BaseUnits.Radian, 1.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Kelvin, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Meter, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Mole,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin,
						-1.0, BaseUnits.Mole, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Ampere,
						-2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -3.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 4.0, BaseUnits.Ampere,
						2.0).equals(this))
				|| (new SIUnit(BaseUnits.Radian, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Steradian, -1.0, BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0,
						BaseUnits.Second, -3.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Steradian, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this)) //
				|| (new SIUnit(BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Ampere,
						-2.0).equals(this))
				|| (new SIUnit(BaseUnits.Steradian, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kilogram, -1.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kelvin, 1.0, BaseUnits.Mole, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -3.0, BaseUnits.Kelvin,
						-1.0).equals(this))
				|| (new SIUnit(BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin, 1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -2.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin,
						1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, -1.0, BaseUnits.Kilogram, -1.0, BaseUnits.Second, 3, BaseUnits.Kelvin,
						1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Second, 2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 2.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Kelvin, -1.0).equals(this))
				|| (new SIUnit(BaseUnits.Meter, 3, BaseUnits.Second, -1.0).equals(this)) || (new SIUnit(BaseUnits.Meter,
						-1.0, BaseUnits.Kilogram, 1.0, BaseUnits.Second, -2.0, BaseUnits.Kelvin, -1.0).equals(this));
	}

	public BaseUnits toBaseUnits() {
		if (new SIUnit(BaseUnits.Meter, 1.0).equals(this))
			return BaseUnits.Meter;
		if (new SIUnit(BaseUnits.Kilogram, 1.0).equals(this))
			return BaseUnits.Kilogram;
		if (new SIUnit(BaseUnits.Second, 1.0).equals(this))
			return BaseUnits.Second;
		if (new SIUnit(BaseUnits.Ampere, 1.0).equals(this))
			return BaseUnits.Ampere;
		if (new SIUnit(BaseUnits.Kelvin, 1.0).equals(this))
			return BaseUnits.Kelvin;
		if (new SIUnit(BaseUnits.Mole, 1.0).equals(this))
			return BaseUnits.Mole;
		if (new SIUnit(BaseUnits.Candela, 1.0).equals(this))
			return BaseUnits.Candela;
		return null;
	}

	public String name() {
		if (this.isDimensionless())
			return "";
		if (this.isBaseUnit())
			return BaseUnitNames[this.toBaseUnits().ordinal()];
		if (this.isDerivedUnit())
			return DerivedUnitNames[this.toDerivedUnits().ordinal()];
		String s = "";
		for (int i = 0; i < dimensions.length; i++) {
			if (dimensions[i] != 0.0) {
				s += BaseUnitNames[i];
				if (dimensions[i] != 1.0)
					s += "^" + dimensions[i];
				s += "*";
			}
		}
		;
		return s.substring(0, s.length() - 1);
	}

	public String symbol() {
		if (this.isDimensionless())
			return "";
		if (this.isBaseUnit())
			return BaseUnitSymbols[this.toBaseUnits().ordinal()];
		if (this.isDerivedUnit())
			return DerivedUnitSymbols[this.toDerivedUnits().ordinal()];
		String s = "";
		for (int i = 0; i < dimensions.length; i++) {
			if (dimensions[i] != 0.0) {
				s += BaseUnitSymbols[i];
				if (dimensions[i] != 1.0)
					s += "^" + dimensions[i];
				s += "*";
			}
		}
		;
		return s.substring(0, s.length() - 1);
	}

	public static String name(SIUnit u) {
		if (u.isDimensionless())
			return "";
		if (u.isBaseUnit())
			return BaseUnitNames[u.toBaseUnits().ordinal()];
		if (u.isDerivedUnit())
			return BaseUnitNames[u.toDerivedUnits().ordinal()];
		String s = "";
		for (int i = 0; i < u.dimensions.length; i++) {
			if (u.dimensions[i] != 0.0) {
				s += BaseUnitNames[i];
				if (u.dimensions[i] != 1.0)
					s += "^" + u.dimensions[i];
				s += "*";
			}
		}
		;
		return s.substring(0, s.length() - 1);
	}

	public static String symbol(SIUnit u) {
		if (u.isDimensionless())
			return "";
		if (u.isBaseUnit())
			return BaseUnitSymbols[u.toBaseUnits().ordinal()];
		if (u.isDerivedUnit())
			return BaseUnitSymbols[u.toDerivedUnits().ordinal()];
		String s = "";
		for (int i = 0; i < u.dimensions.length; i++) {
			if (u.dimensions[i] != 0.0) {
				s += BaseUnitSymbols[i];
				if (u.dimensions[i] != 1.0)
					s += "^" + u.dimensions[i];
				s += "*";
			}
		}
		return s.substring(0, s.length() - 1);
	}

}
