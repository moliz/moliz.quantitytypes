package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

public class Unit implements Cloneable {
	
//************************
//	ATTRIBUTES
//*************
	
	protected double [] dimensions = new double [BaseUnits.values().length];  
	// exponents for each dimension.  
	// [Meter, Kilogram, Second, Ampere, Kelvin, Mole, Candela, Radian, Bit, Shannon, Erlang, Decibel]
	

//*************************
//  STATIC VARIABLES
//**************
	
	public final static String [] BaseUnitNames ={"Meter", "Kilogram", "Second", "Ampere", "Kelvin", "Mole", "Candela", "Bit", "Shannon", "Erlang", "Decibel", "Radian"};

	public final static String [] DerivedUnitNames ={	
			"Gray",
			"GrayPerSecond",
			"Becquerel",
			"MolePerCubicMeter",
			"MolePerKilogram",
			"RadianPerSecondSquared",
			"KilogramMeterSquared",
			"JouleSecond",
			"RadianPerSecond",
			"SquareMeter",
			"SquareMeterSteradian",
			"SquareMeterKelvin",
			"SquareMeterPerKelvin",
			"Farad",
			"Katal",
			"WattPerSquareMeterKelvin",
			"KilogramPerCubicMeter",
			"Sievert",
			"PascalSecond",
			"Coulomb",
			"CoulombPerMeter",
			"CoulombPerCubicMeter",
			"CoulombPerMole",
			"AmperePerSquareMeter",
			"AmperePerRadian",
			"CoulombMeter",
			"VoltPerMeter",
			"CoulombPerSquareMeter",
			"Siemens",
			"Volt",
			"JoulePerCubicMeter",
			"Joule",
			"JoulePerSquareMeter",
			"CoulombPerKilogram",
			"Newton",
			"NewtonPerCoulomb",
			"NewtonPerMeter",
			"Hertz",
			"CubicMeterPerKilogramSecondSquared",
			"JoulePerKelvin",
			"Lux",
			"Henry",
			"PerMole",
			"MeterPerFarad",
			"SquareMeterPerSecond",
			"MeterKilogram",
			"MeterKelvin",
			"MeterPerSecondSquared",
			"KilogramMeterPerSecond",
			"MeterPerKelvin",
			"MeterPerSecond",
			"CandelaPerSquareMeter",
			"Lumen",
			"JoulePerTesla",
			"AmpereTurnPerMeter",
			"Weber",
			"Tesla",
			"AmpereTurn",
			"KilogramKelvin",
			"KilogramPerSecond",
			"KilogramPerSquareMeter",
			"KilogramPerMeter",
			"JoulePerMole",
			"JoulePerMoleKelvin",
			"HenryPerMeter",
			"FaradPerMeter",
			"Watt",
			"WattPerSteradian",
			"WattPerSquareMeterSteradian",
			"WattPerSquareMeter",
			"Pascal",
			"Ohm",
			"Steradian",
			"JoulePerKilogram",
			"JoulePerKilogramKelvin",
			"JoulePerKilogramKelvinPerPascal",
			"JoulePerKilogramKelvinPerCubicMeter",
			"MoleKelvin",
			"WattPerMeterKelvin",
			"SquareMeterKelvinPerWatt",
			"KelvinPerWatt",
			"MeterKelvinPerWatt",
			"NewtonPerKilogram",
			"SecondTimeSquared",
			"Torque",
			"CubicMeter",
			"CubicMeterPerKelvin",
			"CubicMeterPerSecond",
			"JoulePerCubicMeterKelvin", 
			"BitsPerSecond"};

	public final static String [] BaseUnitSymbols ={"m", "kg", "s", "A", "K", "mol", "cd", "bit", "Sh", "E", "dB", "rad"};

	public final static String [] DerivedUnitSymbols ={	
			"Gy",
			"Gy/s",
			"Bq",
			"mol/m^3",
			"mol/kg",
			"rad/s^2",
			"kg*m^2",
			"J*s",
			"rad/s",
			"m^2",
			"m^2*sr",
			"m^2*K",
			"m^2/K",
			"F",
			"kat",
			"W/(m^2*K)",
			"kg/m^3",
			"Sv",
			"Pa*s",
			"C",
			"C/m",
			"C/m^3",
			"C/mol",
			"A/m^2",
			"A/rad",
			"C*m",
			"V/m",
			"C/m^2",
			"S",
			"V",
			"J/m^3",
			"J",
			"J/m^2",
			"C/kg",
			"N",
			"N/C",
			"N/m",
			"Hz",
			"m^3/(kg*s^2)",
			"J/K",
			"lx",
			"H",
			"1/mol",
			"m/F",
			"m^2/s",
			"m*kg",
			"m*K",
			"m/s^2",
			"kg*m/s",
			"m/K",
			"m/s",
			"cd/m^2",
			"lm",
			"J/T",
			"AT/m",
			"Wb",
			"T",
			"AT",
			"kg*K",
			"kg/s",
			"kg/m^2",
			"kg/m",
			"J/mol",
			"J/(mol*K)",
			"H/m",
			"F/m",
			"W",
			"W/sr",
			"W/(m^2*sr)",
			"W/m^2",
			"Pa",
			"Ohm",
			"sr",
			"J/kg",
			"J/(kg*K)",
			"J/(kg*K*Pa)",
			"J/(kg*K*m^3)",
			"mol*K",
			"W/(m*K)",
			"K^2*m/W",
			"K/W",
			"m*K/W",
			"N/kg",
			"s^2",
			"N*m",
			"m^3",
			"m^3/K",
			"m^3/s",
			"J/(m^3*K)",
			"bit/s"
		};

	
/************************
* HELPERS
*************/
	
	public static BaseUnits unitOfTheDimension(BaseDimensions d){
		return BaseUnits.values()[d.ordinal()];
	}
	public static DerivedUnits unitOfTheDimension(DerivedDimensions d){
		return DerivedUnits.values()[d.ordinal()];
	}
	public static BaseDimensions dimensionOfUnit(BaseUnits u){
		return BaseDimensions.values()[u.ordinal()];
	}
	public static DerivedDimensions dimensionOfUnit(DerivedUnits u){
		return DerivedDimensions.values()[u.ordinal()];
	}
	
	private void fillDim(BaseUnits d, double exp){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d.ordinal()] = exp;		
	}

	private void fillDim(BaseUnits d1, double exp1,BaseUnits d2, double exp2){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
	}
	private void fillDim(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
	}
	private void fillDim(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
	}

	private void fillDim(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
		dimensions[d5.ordinal()] = exp5;		
	}

//************************
//	CONSTRUCTORS
//*************
	
	private double[] fillUnitDimensions(){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); //unitless
		return dim;
		
	}
	private double[] fillUnitDimensions(double [] d){
		double[] dim = new double [BaseUnits.values().length];  
		dim = Arrays.copyOf(d, dim.length);
		return dim;
	}
	private int find(String[] array, String value) {
	    //auxiliary method because Array does not have "indexOf()"
	    for(int i=0; i<array.length; i++) 
	         if(array[i] == value) return i;
	    return -1;
	}
	private double[] fillUnitDimensions(String symbol){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		int p = find(BaseUnitSymbols, symbol);
		if (p > -1) dim[p] = 1.0;
		else {
			p = find(DerivedUnitSymbols, symbol);
			if (p > -1) fillDimensions(DerivedUnits.values()[p]);
		}
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d.ordinal()] = 1.0;		
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d, double exp){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d.ordinal()] = exp;		
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;		
		dim[d3.ordinal()] = exp3;
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;		
		dim[d3.ordinal()] = exp3;		
		dim[d4.ordinal()] = exp4;
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;		
		dim[d3.ordinal()] = exp3;		
		dim[d4.ordinal()] = exp4;		
		dim[d5.ordinal()] = exp5;
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5,BaseUnits d6, double exp6){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;		
		dim[d3.ordinal()] = exp3;		
		dim[d4.ordinal()] = exp4;		
		dim[d5.ordinal()] = exp5;		
		dim[d6.ordinal()] = exp6;
		return dim;
	}
	private double[] fillUnitDimensions(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5,BaseUnits d6, double exp6,BaseUnits d7, double exp7){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		dim[d1.ordinal()] = exp1;		
		dim[d2.ordinal()] = exp2;		
		dim[d3.ordinal()] = exp3;		
		dim[d4.ordinal()] = exp4;		
		dim[d5.ordinal()] = exp5;		
		dim[d6.ordinal()] = exp6;
		dim[d7.ordinal()] = exp7;		
		return dim;
	}
	private double[] fillUnitDimensions(Unit u){
		double[] dim = new double [BaseUnits.values().length];  
		dim = Arrays.copyOf(u.dimensions, dim.length);
		return dim;
	}
	private double[] fillUnitDimensions(DerivedUnits d){
		double[] dim = new double [BaseUnits.values().length];  
		Arrays.fill(dim, 0.0); 
		fillDimensions(d);
		return dim;
	}	
	private void fillDimensions(DerivedUnits d){	
		
		switch(d){
		case Gray:
			fillDim(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0); 
			break;
		case GrayPerSecond:
			fillDim(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0); 
			break;
		case Becquerel:
			fillDim(BaseUnits.Second,-1.0); 
			break;
		case MolePerCubicMeter:
			fillDim(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); 
			break;
		case MolePerKilogram:
			fillDim(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0);
			break;
		case RadianPerSecondSquared:
				fillDim(BaseUnits.Second,-2.0,BaseUnits.Radian,1.0);
				break;
		case KilogramMeterSquared:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0); 
				break;
		case JouleSecond:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
				break;
		case RadianPerSecond:
				fillDim(BaseUnits.Second,-1.0, BaseUnits.Radian,1.0);
				break;
		case SquareMeter:
				fillDim(BaseUnits.Meter,2.0); 
				break;
		case SquareMeterSteradian:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Radian,2.0);
				break;
		case SquareMeterKelvin:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0); 
				break;
		case SquareMeterPerKelvin:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0); 
				break;
		case Farad:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0); 
				break;
		case Katal:
				fillDim(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0); 
				break;
		case WattPerSquareMeterKelvin:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0); 
				break;
		case KilogramPerCubicMeter:
				fillDim(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0); 
				break;
		case Sievert:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0); 
				break;
		case PascalSecond:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
				break;
		case Coulomb:
				fillDim(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
				break;
		case CoulombPerMeter:
				fillDim(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0); 
				break;
		case CoulombPerCubicMeter:
				fillDim(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0); 
				break;
		case CoulombPerMole:
				fillDim(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0); 
				break;
		case AmperePerSquareMeter:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0); 
				break;
		case AmperePerRadian:
				fillDim(BaseUnits.Ampere,1.0,BaseUnits.Radian,-1.0);
				break;
		case CoulombMeter:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
				break;
		case VoltPerMeter:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0); 
				break;
		case CoulombPerSquareMeter:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
				break;
		case Siemens:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0); 
				break;
		case Volt:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0); 
				break;
		case JoulePerCubicMeter:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case Joule:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case JoulePerSquareMeter:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case CoulombPerKilogram:
				fillDim(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
				break;
		case Newton:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
				break;
		case NewtonPerCoulomb:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0); 
				break;
		case NewtonPerMeter:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case Hertz:
				fillDim(BaseUnits.Second,-1.0); 
				break;
		case CubicMeterPerKilogramSecondSquared:
				fillDim(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0); 
				break;
		case JoulePerKelvin:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
				break;
		// case Watt: duplicated
		// case WattPerSquareMeter: duplicated
		case Lux:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0, BaseUnits.Radian,1.0);
				break;
		case Henry:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0); 
				break;
		case PerMole:
				fillDim(BaseUnits.Mole,-1.0); 
				break;
		case MeterPerFarad:
				fillDim(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0); 
				break;
		case SquareMeterPerSecond:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0); 
				break;
		case MeterKilogram:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0); 
				break;
		case MeterKelvin:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0); 
				break;
		case MeterPerSecondSquared:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
				break;
		case KilogramMeterPerSecond:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
				break;
		case MeterPerKelvin:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0); 
				break;
		case MeterPerSecond:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0); 
				break;
		case CandelaPerSquareMeter:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0); 
				break;
		case Lumen:
				fillDim(BaseUnits.Candela,1.0, BaseUnits.Radian,1.0);
				break;
		case JoulePerTesla:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0); 
				break;
		case AmpereTurnPerMeter:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0); 
				break;
		case Weber:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0); 
				break;
		case Tesla:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0); 
				break;
		case AmpereTurn:
				fillDim(BaseUnits.Ampere,1.0, BaseUnits.Radian,1.0);
				break;
		case KilogramKelvin:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0); 
				break;
		case KilogramPerSecond:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
				break;
		case KilogramPerSquareMeter:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0); 
				break;
		case KilogramPerMeter:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0); 
				break;
		case JoulePerMole:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0); 
				break;
		case JoulePerMoleKelvin:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0); 
				break;
		case HenryPerMeter:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0); 
				break;
		case FaradPerMeter:
				fillDim(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0); 
				break;
		case Watt:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); 
				break;
		case WattPerSteradian:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Radian,-2.0); 
				break;
		case WattPerSquareMeterSteradian:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0, BaseUnits.Radian,-2.0); //,
				break;
		case WattPerSquareMeter:
				fillDim(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); 
				break;
		case Pascal:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case Ohm:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0); 
				break;
		case Steradian:
				fillDim(BaseUnits.Radian,2.0);
				break;
		case JoulePerKilogram:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0); 
				break;
		case JoulePerKilogramKelvin:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
				break;
		case JoulePerKilogramKelvinPerPascal:
				fillDim(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0); 
				break;
		case JoulePerKilogramKelvinPerCubicMeter:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
				break;
		case MoleKelvin:
				fillDim(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0); 
				break;
		case WattPerMeterKelvin:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0); 
				break;
		// case SquareMeterPerSecond: duplicated
		case SquareMeterKelvinPerWatt:
				fillDim(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
				break;
		case KelvinPerWatt:
				fillDim(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
				break;
		case MeterKelvinPerWatt:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
				break;
		case NewtonPerKilogram:
				fillDim(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
				break;
		case SecondTimeSquared:
				fillDim(BaseUnits.Second,2.0); 
				break;
		case NewtonMeter:
				fillDim(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
				break;
		case CubicMeter:
				fillDim(BaseUnits.Meter,3.0); 
				break;
		case CubicMeterPerKelvin:
				fillDim(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0); 
				break;
		case CubicMeterPerSecond:
				fillDim(BaseUnits.Meter,3,BaseUnits.Second,-1.0); 
				break;
		case JoulePerCubicMeterKelvin:
				fillDim(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
				break;
		case BitsPerSecond:
				fillDim(BaseUnits.Bit,1.0,BaseUnits.Second,-1.0); 
		}
	}
	
	// --------------------------------------------------------------------------
	
	protected String name = "";
	protected String symbol = "";
	
	//public Unit siUnit;
	// this attribute contains the reference to the dimensions in the SI and their exponents
	
	protected double [] conversionFactor = new double [BaseUnits.values().length];
	// to convert to SI Units. They are all 1.0 by default.
	// for example, from Kilometer to Meter, this.conversionFactor[BaseUnits.Meter.ordinal()]=1000
	// from Gram to Kilogram, this.conversionFactor[BaseUnits.Kilogram.ordinal()]=0.001
	// conversion factors are not affected by exponents, they are considered only when making the conversions

	protected double [] offset = new double [BaseUnits.values().length];  
	// to convert to SI Units. They are all 0.0 by default.
	// for example, from Celsius to Kelvin, this.offset[BaseUnits.Kelvin.ordinal()] = +273.15
	// offsets, as conversion factors, are not affected by exponents, they are considered only when making the conversions

	// joining the two:
	// from Celsius to Kelvin, this.conversionFactor[BaseUnits.Kelvin.ordinal()]=1.0; 
	//                         this.offset[BaseUnits.Kelvin.ordinal()] = +273.15
	// from Farenheit to Kelvin, this.conversionFactor[BaseUnits.Kelvin.ordinal()]=0.55555555556; 
	//                           this.offset[BaseUnits.Kelvin.ordinal()] = +255.372222222;

	// IMPORTANT: In this version, only one offset is allowed in Units
	
	protected boolean checkOffset() {
		int atMostOne=0;
		for (int i=0;i<BaseUnits.values().length;i++)
			if (offset[i]!=0.0) atMostOne++;
		return atMostOne<=1;
	}

	protected boolean noOffset() {
		for (int i=0;i<BaseUnits.values().length;i++)
			if (offset[i]!=0.0) return false;
		return true;
	}
	
	protected double sumOffset() {
		double sum=0;
		for (int i=0;i<BaseUnits.values().length;i++)
			sum +=offset[i];
		return sum;
	}

	
	public Unit(){ //Unitless
		dimensions = fillUnitDimensions();
		this.name = ""; 
		this.symbol = "";
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
	}

	public Unit(String name, String symbol, double [] d, double [] c, double [] o){
		dimensions = fillUnitDimensions(d);
		this.name = name;
		this.symbol = symbol;
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		this.offset = Arrays.copyOf(o, BaseUnits.values().length);
//		assert checkOffset() : offset;
		if (!this.checkOffset()) throw new RuntimeException("Invalid Offset when creating unit: "+this.symbol);
	}

	public Unit(String name, String symbol, double [] d, double [] c){
		dimensions = fillUnitDimensions(d);
		this.name = name;
		this.symbol = symbol;
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		Arrays.fill(offset, 0.0); 
	}

	public Unit(double [] d){
		dimensions = fillUnitDimensions(d);
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
	}

	public Unit(double [] d, double [] c){ //no offset
		dimensions = fillUnitDimensions(d);
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		Arrays.fill(offset, 0.0); 
	}

	public Unit(double [] d, double [] c, double [] o){
		dimensions = fillUnitDimensions(d);
		this.conversionFactor = Arrays.copyOf(c, BaseUnits.values().length);
		this.offset = Arrays.copyOf(o, BaseUnits.values().length);
//		assert checkOffset() : offset;
		if (!this.checkOffset()) throw new RuntimeException("Invalid Offset when creating unit: "+this.symbol);
	}

	public Unit(BaseUnits d, double exp){
		dimensions = fillUnitDimensions(d,exp);
		Arrays.fill(this.conversionFactor, 1.0); 
		Arrays.fill(this.offset, 0.0); 
	}

	public Unit(BaseUnits d){
		dimensions = fillUnitDimensions(d);
		Arrays.fill(this.conversionFactor, 1.0); 
		Arrays.fill(this.offset, 0.0); 
	}

	public Unit(DerivedUnits d){
//		dimensions = fillUnitDimensions(d);
		fillUnitDimensions(d);
		Arrays.fill(this.conversionFactor, 1.0); 
		Arrays.fill(this.offset, 0.0); 
	}


	public Unit(String name, String symbol, BaseUnits d, double exp, double conv, double offset){
		dimensions = fillUnitDimensions(d,exp);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(this.conversionFactor, 1.0); 
		Arrays.fill(this.offset, 0.0); 
        this.conversionFactor[d.ordinal()] = conv;		
        this.offset[d.ordinal()] = offset;		
//		assert checkOffset() : offset;
		if (!this.checkOffset()) throw new RuntimeException("Invalid Offset when creating unit: "+this.symbol);
	}

	public Unit(String name, String symbol, 
			    BaseUnits d1, double exp1, double conv1, double offset1,
			    BaseUnits d2, double exp2, double conv2){
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
        this.conversionFactor[d1.ordinal()] = conv1;		
        this.offset[d1.ordinal()] = offset1;		
        this.conversionFactor[d2.ordinal()] = conv2;		
	}

	public Unit(String name, String symbol, 
		    BaseUnits d1, double exp1, double conv1, double offset1,
		    BaseUnits d2, double exp2, double conv2,
		    BaseUnits d3, double exp3, double conv3){
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2,d3,exp3);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
		this.conversionFactor[d1.ordinal()] = conv1;		
		this.offset[d1.ordinal()] = offset1;		
		this.conversionFactor[d2.ordinal()] = conv2;		
//		this.offset[d2.ordinal()] = offset2;		
		this.conversionFactor[d3.ordinal()] = conv3;		
//		this.offset[d3.ordinal()] = offset3;		
	}

	public Unit(String name, String symbol, 
		    BaseUnits d1, double exp1, double conv1, double offset1,
		    BaseUnits d2, double exp2, double conv2, //double offset2,
		    BaseUnits d3, double exp3, double conv3, //double offset3,
		    BaseUnits d4, double exp4, double conv4 ){ //double offset4
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2,d3,exp3,d4,exp4);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
		this.conversionFactor[d1.ordinal()] = conv1;		
		this.offset[d1.ordinal()] = offset1;		
		this.conversionFactor[d2.ordinal()] = conv2;		
//		this.offset[d2.ordinal()] = offset2;		
		this.conversionFactor[d3.ordinal()] = conv3;		
//		this.offset[d3.ordinal()] = offset3;		
		this.conversionFactor[d4.ordinal()] = conv4;		
//		this.offset[d4.ordinal()] = offset4;		
	}

	public Unit(String name, String symbol, 
		    BaseUnits d1, double exp1, double conv1, double offset1,
		    BaseUnits d2, double exp2, double conv2, //double offset2,
		    BaseUnits d3, double exp3, double conv3, //double offset3,
		    BaseUnits d4, double exp4, double conv4, //double offset4,
		    BaseUnits d5, double exp5, double conv5 ){ //,double offset5){
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2,d3,exp3,d4,exp4,d5,exp5);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(conversionFactor, 1.0); 
		Arrays.fill(offset, 0.0); 
		this.conversionFactor[d1.ordinal()] = conv1;		
		this.offset[d1.ordinal()] = offset1;		
		this.conversionFactor[d2.ordinal()] = conv2;		
//		this.offset[d2.ordinal()] = offset2;		
		this.conversionFactor[d3.ordinal()] = conv3;		
//		this.offset[d3.ordinal()] = offset3;		
		this.conversionFactor[d4.ordinal()] = conv4;		
//		this.offset[d4.ordinal()] = offset4;		
		this.conversionFactor[d5.ordinal()] = conv5;		
//		this.offset[d5.ordinal()] = offset5;				
	}

	public Unit(String name, String symbol, 
		    BaseUnits d1, double exp1, double conv1, double offset1,
		    BaseUnits d2, double exp2, double conv2, 
		    BaseUnits d3, double exp3, double conv3, 
		    BaseUnits d4, double exp4, double conv4, 
		    BaseUnits d5, double exp5, double conv5, 
		    BaseUnits d6, double exp6, double conv6){
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2,d3,exp3,d4,exp4,d5,exp5,d6,exp6);
		this.name = name;
		this.symbol = symbol;
		Arrays.fill(this.conversionFactor, 1.0); 
		Arrays.fill(this.offset, 0.0); 
		this.conversionFactor[d1.ordinal()] = conv1;		
		this.offset[d1.ordinal()] = offset1;		
		this.conversionFactor[d2.ordinal()] = conv2;		
//		this.offset[d2.ordinal()] = offset2;		
		this.conversionFactor[d3.ordinal()] = conv3;		
//		this.offset[d3.ordinal()] = offset3;		
		this.conversionFactor[d4.ordinal()] = conv4;		
//		this.offset[d4.ordinal()] = offset4;		
		this.conversionFactor[d5.ordinal()] = conv5;		
//		this.offset[d5.ordinal()] = offset5;		
		this.conversionFactor[d6.ordinal()] = conv6;		
//		this.offset[d6.ordinal()] = offset6;		
	}

	public Unit(String name, String symbol, 
		    BaseUnits d1, double exp1, double conv1, double offset1,
		    BaseUnits d2, double exp2, double conv2, 
		    BaseUnits d3, double exp3, double conv3, 
		    BaseUnits d4, double exp4, double conv4, 
		    BaseUnits d5, double exp5, double conv5, 
		    BaseUnits d6, double exp6, double conv6, 
		    BaseUnits d7, double exp7, double conv7){
		dimensions = fillUnitDimensions(d1,exp1,d2,exp2,d3,exp3,d4,exp4,d5,exp5,d6,exp6,d7,exp7);
		this.name = name;
		this.symbol = symbol;
		this.conversionFactor[d1.ordinal()] = conv1;		
		this.offset[d1.ordinal()] = offset1;		
		this.conversionFactor[d2.ordinal()] = conv2;		
//		this.offset[d2.ordinal()] = offset2;		
		this.conversionFactor[d3.ordinal()] = conv3;		
//		this.offset[d3.ordinal()] = offset3;		
		this.conversionFactor[d4.ordinal()] = conv4;		
//		this.offset[d4.ordinal()] = offset4;		
		this.conversionFactor[d5.ordinal()] = conv5;		
//		this.offset[d5.ordinal()] = offset5;		
		this.conversionFactor[d6.ordinal()] = conv6;		
//		this.offset[d6.ordinal()] = offset6;		
		this.conversionFactor[d7.ordinal()] = conv7;		
//		this.offset[d7.ordinal()] = offset7;		
	}
	
	public Unit(Unit u){
		this.dimensions = u.dimensions;
		this.name = u.name;
		this.symbol = u.symbol;
		this.conversionFactor = u.conversionFactor;
		this.offset = u.offset;
	}
	
	/************
	 * Queries, etc
	 * 
	 */
	public double factor(){
		double f = 1.0;
		for (int i = 0; i<BaseUnits.values().length; i++) 
			f *=(Math.pow(conversionFactor[i],dimensions[i]));
		return f;
	}
	
	public boolean equals(Unit u) { //hascode() from super.
		
		// we do not care about the name and symbols, focusing only on
		// the dimensions, conversion factors and offsets
		return  Arrays.equals(this.conversionFactor, u.conversionFactor) 
				&& Arrays.equals(this.offset, u.offset) 
				&&  Arrays.equals(this.dimensions, u.dimensions);
	}
	
	public boolean isCompatibleWith(Unit u) {
		return Arrays.equals(this.dimensions, u.dimensions);
	}
	
	
/****************
 *  Operations
 */
	
	public Unit multiplyUnits (Unit u) {
		//resulting units expressed in Units
		double [] result = new double [dimensions.length];
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] + u.dimensions[i]; //they are exponents
		}
		Unit siu = new Unit(result);
	    return new Unit(siu.name(), 
				        siu.symbol(), 
						result, 
	    				this.conversionFactor, 
	    				this.offset);
	}

	public Unit divideUnits (Unit u) {
		//resulting units expressed in Units
		double [] result = new double [dimensions.length];
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] - u.dimensions[i]; //they are exponents
		}
		Unit siu = new Unit(result);
	    return new Unit(siu.name(), 
	    				siu.symbol(), 
	    				result, 
	    				this.conversionFactor, 
	    				this.offset);
	}
	
	public Unit powerUnits (float s) {
		double [] result = new double [dimensions.length];  
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] * s; //they are exponents
		}
		Unit siu = new Unit(result);
	    return new Unit(siu.name(), 
	    				siu.symbol(), 
	    				result, 
						this.conversionFactor, 
						this.offset);
	}
	
	public String toString(){
		
		String s = "["+this.dimensions[0];
		for (int i=1;i<this.dimensions.length;i++){
			s+=","+this.dimensions[i]; 
		}
		s+="];";
		s += "<"+name+";"+symbol+";"+
					";["+conversionFactor[0];
			for (int i=1;i<this.conversionFactor.length;i++){
					s+=","+this.conversionFactor[i]; 
			};
			s+="];["+offset[0];
			for (int i=1;i<this.offset.length;i++){
					s+=","+this.offset[i]; 
			};
			return s+"]";
	}
	
	// --------------------
	
	
	
	/************
	 * methods
	 * 
	 */
	
	public double [] dimensions(){
		return this.dimensions;
	}
	
 	public int hashcode(){ //required for equals()
		double x=0.0;
 		for (int i=0;i<dimensions.length;i++) x+=dimensions[i]; 
 		return (int)Math.round(x);
	}

	public boolean isBaseUnit(){
		int zeros = 0;
		int unos = 0;
		for (int i=0;i<dimensions.length;i++){
			if (dimensions[i]==0.0) zeros++;
			if (dimensions[i]==1.0) unos++;
		}
		return (zeros==dimensions.length-1) // all exponents but 1 are 0.
				&& (unos==1); //and there is one exponent == 1 
	}
	
	public boolean isDimensionless(){ //all units but Radian are dimensionless 
		for (int i=0;i<dimensions.length;i++){
			if ((i!=BaseUnits.Radian.ordinal())&&(i!=BaseUnits.Erlang.ordinal())&&(dimensions[i]!=0.0)) return false;
		}
		return true; //all exponents should be 0.0 apart from the one from radian 
					 //and the one from the Erlang .
	}
	
	public boolean isUnitless(){ //all 8 exponents should be 0.0
		for (int i=0;i<dimensions.length;i++){
			if (dimensions[i]!=0.0) return false;
		}
		return true; 
	}
	
	public Unit clone(){
		return new Unit(this);
	}
	
	public DerivedUnits toDerivedUnits(){
		if (fillUnitDimensions(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.Gray;
		if (fillUnitDimensions(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0).equals(this))
			return DerivedUnits.GrayPerSecond;
		if (fillUnitDimensions(BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.Becquerel;
		if (fillUnitDimensions(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(this))
			return DerivedUnits.MolePerCubicMeter;
		if (fillUnitDimensions(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(this))
			return DerivedUnits.MolePerKilogram;
		if (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Second,-2.0).equals(this))  //
			return DerivedUnits.RadianPerSecondSquared;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0).equals(this))
			return DerivedUnits.KilogramMeterSquared;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.JouleSecond;
		if (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Second,-1.0).equals(this))  //
			return DerivedUnits.RadianPerSecond;
		if (fillUnitDimensions(BaseUnits.Meter,2.0).equals(this))
			return DerivedUnits.SquareMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Radian,2.0).equals(this)) //
			return DerivedUnits.SquareMeterSteradian;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.SquareMeterKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.SquareMeterPerKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(this))
			return DerivedUnits.Farad;
		if (fillUnitDimensions(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0).equals(this))
			return DerivedUnits.Katal;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.WattPerSquareMeterKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0).equals(this))
			return DerivedUnits.KilogramPerCubicMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.Sievert;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.PascalSecond;
		if (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.Coulomb;
		if (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0).equals(this))
			return DerivedUnits.CoulombPerMeter;
		if (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0).equals(this))
			return DerivedUnits.CoulombPerCubicMeter;
		if (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0).equals(this))
			return DerivedUnits.CoulombPerMole;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.AmperePerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Ampere,1.0,BaseUnits.Radian,-1.0).equals(this)) //
			return DerivedUnits.AmperePerRadian;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.CoulombMeter;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(this))
			return DerivedUnits.VoltPerMeter;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.CoulombPerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0).equals(this))
			return DerivedUnits.Siemens;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.Volt;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.JoulePerCubicMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.Joule;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.JoulePerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.CoulombPerKilogram;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.Newton;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(this))
			return DerivedUnits.NewtonPerCoulomb;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.NewtonPerMeter;
		if (fillUnitDimensions(BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.Hertz;
		if (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.CubicMeterPerKilogramSecondSquared;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.JoulePerKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0,BaseUnits.Radian,1.0).equals(this)) //
			return DerivedUnits.Lux;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(this))
			return DerivedUnits.Henry;
		if (fillUnitDimensions(BaseUnits.Mole,-1.0).equals(this))
			return DerivedUnits.PerMole;
		if (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0).equals(this))
			return DerivedUnits.MeterPerFarad;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.SquareMeterPerSecond;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0).equals(this))
			return DerivedUnits.MeterKilogram;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.MeterKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.MeterPerSecondSquared;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.KilogramMeterPerSecond;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.MeterPerKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.MeterPerSecond;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(this))
			return DerivedUnits.CandelaPerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Candela,1.0).equals(this)) //,
			return DerivedUnits.Lumen;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.JoulePerTesla;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0).equals(this))
			return DerivedUnits.AmpereTurnPerMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(this))
			return DerivedUnits.Weber;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(this))
			return DerivedUnits.Tesla;
		if (fillUnitDimensions(BaseUnits.Ampere,1.0,BaseUnits.Radian,1.0).equals(this)) //
		return DerivedUnits.AmpereTurn;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.KilogramKelvin;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.KilogramPerSecond;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0).equals(this))
			return DerivedUnits.KilogramPerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0).equals(this))
			return DerivedUnits.KilogramPerMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0).equals(this))
			return DerivedUnits.JoulePerMole;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0).equals(this))
			return DerivedUnits.JoulePerMoleKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(this))
			return DerivedUnits.HenryPerMeter;
		if (fillUnitDimensions(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(this))
			return DerivedUnits.FaradPerMeter;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this))
			return DerivedUnits.Watt;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Radian,-2.0).equals(this))//
			return DerivedUnits.WattPerSteradian;
		if (fillUnitDimensions(BaseUnits.Radian,-2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this))//
			return DerivedUnits.WattPerSquareMeterSteradian;
		if (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this))
			return DerivedUnits.WattPerSquareMeter;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.Pascal;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0).equals(this))
			return DerivedUnits.Ohm;
		if (fillUnitDimensions(BaseUnits.Radian,2.0).equals(this))//
			return DerivedUnits.Steradian;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.JoulePerKilogram;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvinPerPascal;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.JoulePerKilogramKelvinPerCubicMeter;
		if (fillUnitDimensions(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0).equals(this))
			return DerivedUnits.MoleKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.WattPerMeterKelvin;
		if (fillUnitDimensions(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.SquareMeterKelvinPerWatt;
		if (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.KelvinPerWatt;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
			return DerivedUnits.MeterKelvinPerWatt;
		if (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.NewtonPerKilogram;
		if (fillUnitDimensions(BaseUnits.Second,2.0).equals(this))
			return DerivedUnits.SecondTimeSquared;
		if (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
			return DerivedUnits.NewtonMeter;
		if (fillUnitDimensions(BaseUnits.Meter,3.0).equals(this))
			return DerivedUnits.CubicMeter;
		if (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.CubicMeterPerKelvin;
		if (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.CubicMeterPerSecond;
		if (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
			return DerivedUnits.JoulePerCubicMeterKelvin;
		if (fillUnitDimensions(BaseUnits.Bit,1.0, BaseUnits.Second,-1.0).equals(this))
			return DerivedUnits.BitsPerSecond;
		return null;
	}

	public boolean isDerivedUnit(){

		return (fillUnitDimensions(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0).equals(this)) 
            || (fillUnitDimensions(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Second,-2.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Second,-1.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,2.0,BaseUnits.Meter,2.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Ampere,1.0,BaseUnits.Radian,-1.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0,BaseUnits.Radian,1.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Mole,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,1.0,BaseUnits.Candela,1.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Ampere,1.0,BaseUnits.Radian,1.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,-2.0,BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Radian,-2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this)) //
            || (fillUnitDimensions(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Radian,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Second,2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,3,BaseUnits.Second,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(this))
            || (fillUnitDimensions(BaseUnits.Bit,1,BaseUnits.Second,-1.0).equals(this))
			;
	}

	public BaseUnits toBaseUnits() {
		if (new Unit(BaseUnits.Meter,1.0).equals(this)) return BaseUnits.Meter;
		if (new Unit(BaseUnits.Kilogram,1.0).equals(this)) return BaseUnits.Kilogram;
		if (new Unit(BaseUnits.Second,1.0).equals(this)) return BaseUnits.Second;
		if (new Unit(BaseUnits.Ampere,1.0).equals(this)) return BaseUnits.Ampere;
		if (new Unit(BaseUnits.Kelvin,1.0).equals(this)) return BaseUnits.Kelvin;
		if (new Unit(BaseUnits.Mole,1.0).equals(this)) return BaseUnits.Mole;
		if (new Unit(BaseUnits.Candela,1.0).equals(this)) return BaseUnits.Candela;
		if (new Unit(BaseUnits.Radian,1.0).equals(this)) return BaseUnits.Radian;
		if (new Unit(BaseUnits.Bit,1.0).equals(this)) return BaseUnits.Bit;
		if (new Unit(BaseUnits.Erlang,1.0).equals(this)) return BaseUnits.Erlang;
		if (new Unit(BaseUnits.Shannon,1.0).equals(this)) return BaseUnits.Shannon;
		if (new Unit(BaseUnits.Decibel,1.0).equals(this)) return BaseUnits.Decibel;
		return null;
	}

	public String name() {
    	if (this.isDimensionless()) return "";
    	if (this.isBaseUnit()) return BaseUnitNames[this.toBaseUnits().ordinal()];
    	if (this.isDerivedUnit()) return DerivedUnitNames[this.toDerivedUnits().ordinal()];
    	String s="";
    	for (int i=0;i<dimensions.length;i++){
    		if (dimensions[i]!=0.0) {
    			s+=BaseUnitNames[i];
    			if (dimensions[i]!=1.0) s+="^"+dimensions[i];
    			s+="*";
    		}
    	};
    	return s.substring(0, s.length()-1);
    }

	public String symbol() {
    	if (this.isDimensionless()) return "";
    	if (this.isBaseUnit()) return BaseUnitSymbols[this.toBaseUnits().ordinal()];
    	if (this.isDerivedUnit()) return DerivedUnitSymbols[this.toDerivedUnits().ordinal()];
    	String s="";
    	for (int i=0;i<dimensions.length;i++){
    		if (dimensions[i]!=0.0) {
    			s+=BaseUnitSymbols[i];
    			if (dimensions[i]!=1.0) s+="^"+dimensions[i];
    			s+="*";
    		}
    	};
    	return s.substring(0, s.length()-1);
    }

	public static String name(Unit u) {
    	if (u.isDimensionless()) return "";
    	if (u.isBaseUnit()) return BaseUnitNames[u.toBaseUnits().ordinal()];
    	if (u.isDerivedUnit()) return BaseUnitNames[u.toDerivedUnits().ordinal()];
    	String s="";
    	for (int i=0;i<u.dimensions.length;i++){
    		if (u.dimensions[i]!=0.0) {
    			s+=BaseUnitNames[i];
    			if (u.dimensions[i]!=1.0) s+="^"+u.dimensions[i];
    			s+="*";
    		}
    	};
    	return s.substring(0, s.length()-1);
    }

	public static String symbol(Unit u) {
    	if (u.isUnitless()) return "";
    	if (u.isBaseUnit()) return BaseUnitSymbols[u.toBaseUnits().ordinal()];
    	if (u.isDerivedUnit()) return BaseUnitSymbols[u.toDerivedUnits().ordinal()];
    	String s="";
    	for (int i=0;i<u.dimensions.length;i++){
    		if (u.dimensions[i]!=0.0) {
    			s+=BaseUnitSymbols[i];
    			if (u.dimensions[i]!=1.0) s+="^"+u.dimensions[i];
    			s+="*";
    		}
    	};
    	return s.substring(0, s.length()-1);
    }

}
