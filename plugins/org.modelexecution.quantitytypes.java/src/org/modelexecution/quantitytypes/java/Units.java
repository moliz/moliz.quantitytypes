package org.modelexecution.quantitytypes.java;


public class Units {

	
	//METRIC SYSTEM - SI UNITS

	//LENGTH
	public final static Unit Exameter = new Unit("Exameter", "Em", BaseUnits.Meter, 1.0, 1000000000000000000.0, 0.0);
	public final static Unit Petameter = new Unit("Petameter", "Pm", BaseUnits.Meter, 1.0, 1000000000000000.0, 0.0);
	public final static Unit Terameter = new Unit("Terameter", "Tm", BaseUnits.Meter, 1.0, 1000000000000.0, 0.0);
	public final static Unit Gigameter = new Unit("Gigameter", "Gm", BaseUnits.Meter, 1.0, 1000000000.0, 0.0);
	public final static Unit Megameter = new Unit("Megaemeter", "Mm", BaseUnits.Meter, 1.0, 1000000.0, 0.0);
	public final static Unit Kilometer = new Unit("Kilometer", "km", BaseUnits.Meter, 1.0, 1000.0, 0.0);
	public final static Unit Hectometer = new Unit("Hectometer", "hm", BaseUnits.Meter, 1.0, 100.0, 0.0);
	public final static Unit Decameter = new Unit("Decameter", "dam", BaseUnits.Meter, 1.0, 10.0, 0.0);
	public final static Unit Meter = new Unit(BaseUnits.Meter);
	public final static Unit Decimeter = new Unit("Decimeter", "dm", BaseUnits.Meter, 1.0, 0.1, 0.0);
	public final static Unit Centimeter = new Unit("Centimeter", "cm", BaseUnits.Meter, 1.0, 0.01, 0.0);
	public final static Unit Millimeter = new Unit("Millimeter", "mm", BaseUnits.Meter, 1.0, 0.001, 0.0);
	public final static Unit Micrometer = new Unit("Micrometer", "micro-m", BaseUnits.Meter, 1.0, 0.000001, 0.0);
	public final static Unit Nanometer = new Unit("Nanometer", "nm", BaseUnits.Meter, 1.0, 0.000000001, 0.0);
	public final static Unit Picometer = new Unit("Picometer", "pm", BaseUnits.Meter, 1.0, 0.000000000001, 0.0);
	public final static Unit Fentometer = new Unit("Fentometer", "fm", BaseUnits.Meter, 1.0, 0.000000000000001, 0.0);
	public final static Unit Attometer = new Unit("Attometer", "am", BaseUnits.Meter, 1.0, 0.000000000000000001, 0.0);

	//AREA (in addition to the derived measures defined by the SI)
	public final static Unit SquareKilometer = new Unit("Kilometer^2", "km^2", BaseUnits.Meter, 2.0, 1000.0, 0.0);
	public final static Unit SquareHectometer = new Unit("Hectometer^2", "hm^2", BaseUnits.Meter, 2.0, 100.0, 0.0);
	public final static Unit SquareDecameter = new Unit("Decameter^2", "dam^2", BaseUnits.Meter, 2.0, 10.0, 0.0);
	public final static Unit SquareDecimeter = new Unit("Decimeter^2", "dm^2", BaseUnits.Meter, 2.0, 0.1, 0.0);
	public final static Unit SquareCentimeter = new Unit("Centimeter^2", "cm^2", BaseUnits.Meter, 2.0, 0.01, 0.0);
	public final static Unit SquareMillimeter = new Unit("Millimeter^2", "mm^2", BaseUnits.Meter, 2.0, 0.001, 0.0);

	
	//VOLUME (in addition to the derived measures defined by the SI)
	public final static Unit CubicKilometer = new Unit("Kilometer^3", "km^3", BaseUnits.Meter, 3.0, 1000.0, 0.0);
	public final static Unit CubicHectometer = new Unit("Hectometer^3", "hm^3", BaseUnits.Meter, 3.0, 100.0, 0.0);
	public final static Unit CubicDecameter = new Unit("Decameter^3", "dam^3", BaseUnits.Meter, 3.0, 10.0, 0.0);
	public final static Unit CubicDecimeter = new Unit("Decimeter^3", "dm^3", BaseUnits.Meter, 3.0, 0.1, 0.0);
	public final static Unit CubicCentimeter = new Unit("Centimeter^3", "cm^3", BaseUnits.Meter, 3.0, 0.01, 0.0);
	public final static Unit CubicMillimiter = new Unit("Millimeter^3", "mm^3", BaseUnits.Meter, 3.0, 0.001, 0.0);

	public final static Unit Exalitre = new Unit("Exalitre", "Ele", BaseUnits.Meter, 3.0, 10000000000000000.0, 0.0);
	public final static Unit Petalitre = new Unit("Petalitre", "Plt", BaseUnits.Meter, 3.0, 1000000000000.0, 0.0);
	public final static Unit Teralitre = new Unit("Teralitre", "Tlt", BaseUnits.Meter, 3.0, 1000000000.0, 0.0);
	public final static Unit Gigalitre = new Unit("Gigalitre", "Glt", BaseUnits.Meter, 3.0, 1000000.0, 0.0);
	public final static Unit Megalitre = new Unit("Megalitre", "Mlt", BaseUnits.Meter, 3.0, 1000.0, 0.0);
	public final static Unit Kilolitre = new Unit("Kilolitre", "klt", BaseUnits.Meter, 3.0, 1.0, 0.0);
	public final static Unit Hectolitre = new Unit("Hectolitre", "hlt", BaseUnits.Meter, 3.0, 0.1, 0.0);
	public final static Unit Decalitre = new Unit("Decalitre", "dalt", BaseUnits.Meter, 3.0, 0.01, 0.0);
	public final static Unit Litre = new Unit("litre", "lt", BaseUnits.Meter, 3.0, 0.001, 0.0);
	public final static Unit Decilitre = new Unit("Decilitre", "dlt", BaseUnits.Meter, 3.0, 0.0001, 0.0);
	public final static Unit Centilitre = new Unit("Centilitre", "clt", BaseUnits.Meter, 3.0, 0.00001, 0.0);
	public final static Unit Millilitre = new Unit("Millilitre", "mlt", BaseUnits.Meter, 3.0, 0.000001, 0.0);
	public final static Unit Microlitre = new Unit("Microlitre", "micro-lt", BaseUnits.Meter, 3.0, 0.000000001, 0.0);
	public final static Unit Nanolitre = new Unit("Nanolitre", "nlt", BaseUnits.Meter, 3.0, 0.000000000001, 0.0);
	public final static Unit Picolitre = new Unit("Picolitre", "plt", BaseUnits.Meter, 3.0, 0.000000000000001, 0.0);
	public final static Unit Fentolitre = new Unit("Fentolitre", "flt", BaseUnits.Meter, 3.0, 0.000000000000000001, 0.0);
	public final static Unit Attolitre = new Unit("Attolitre", "alt", BaseUnits.Meter, 3.0, 0.000000000000000000001, 0.0);

	
	//VELOCITY (in addition to the derived measures defined by the SI)
	public final static Unit KilometerPerSecond = new Unit("KilometerPerSecond", "km/s", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit KilometerPerHour = new Unit("KilometerPerHour", "km/h", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit KilometerPerSecondSquared = new Unit("KilometerPerSecondSquared", "km/s^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit KilometerPerHourSquared = new Unit("KilometerPerHourSquared", "km/h^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit CentimeterPerSecond = new Unit("CentimeterPerSecond", "cm/s", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit CentimeterPerHour = new Unit("CentimeterPerHour", "cm/h", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit CentimeterPerSecondSquared = new Unit("CentimeterPerSecondSquared", "cm/s^2", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit CentimeterPerHourSquared = new Unit("CentimeterPerHourSquared", "cm/h^2", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -2.0, 3600.0);

	//MASS 
	public final static Unit Exagram = new Unit("Exagram", "Eg", BaseUnits.Kilogram, 1.0,   10000000000000000.0, 0.0);
	public final static Unit Petagram = new Unit("Petagram", "Pg", BaseUnits.Kilogram, 1.0, 1000000000000.0, 0.0);
	public final static Unit Teragram = new Unit("Teragram", "Tg", BaseUnits.Kilogram, 1.0, 1000000000.0, 0.0);
	public final static Unit Gigagram = new Unit("Gigagram", "Gg", BaseUnits.Kilogram, 1.0, 1000000.0, 0.0);
	public final static Unit Megagram = new Unit("Megagram", "Mg", BaseUnits.Kilogram, 1.0, 1000.0, 0.0);
	public final static Unit Kilogram = new Unit(BaseUnits.Kilogram);
	public final static Unit Hectogram = new Unit("Hectogram", "hg", BaseUnits.Kilogram, 1.0, 0.1, 0.0);
	public final static Unit Decagram = new Unit("Decagram", "dag", BaseUnits.Kilogram, 1.0, 0.01, 0.0);
	public final static Unit Gram = new Unit("Gram", "g", BaseUnits.Kilogram, 1.0, 0.001, 0.0);
	public final static Unit Decigram = new Unit("Decigram", "dg", BaseUnits.Kilogram, 1.0, 0.0001, 0.0);
	public final static Unit Centigram = new Unit("Centigram", "cg", BaseUnits.Kilogram, 1.0, 0.00001, 0.0);
	public final static Unit Milligram = new Unit("Milligram", "mg", BaseUnits.Kilogram, 1.0, 0.000001, 0.0);
	public final static Unit Microgram = new Unit("Microgram", "micro-g", BaseUnits.Kilogram, 1.0, 0.000000001, 0.0);
	public final static Unit Nanogram = new Unit("Nanogram", "ng", BaseUnits.Kilogram, 1.0, 0.000000000001, 0.0);
	public final static Unit Picogram = new Unit("Picogram", "pg", BaseUnits.Kilogram, 1.0, 0.000000000000001, 0.0);
	public final static Unit Fentogram = new Unit("Fentogram", "fg", BaseUnits.Kilogram, 1.0, 0.000000000000000001, 0.0);
	public final static Unit Attogram = new Unit("Attogram", "ag", BaseUnits.Kilogram, 1.0, 0.000000000000000000001, 0.0);

	//TIME
	public final static Unit Hour = new Unit("Hour", "hr", BaseUnits.Second, 1.0, 3600.0, 0.0);
	public final static Unit Minute = new Unit("Minute", "min", BaseUnits.Second, 1.0, 60.0, 0.0);
	public final static Unit Second = new Unit(BaseUnits.Second);
	public final static Unit Millisecond = new Unit("Millisecond", "ms", BaseUnits.Second, 1.0, 0.001, 0.0);
	public final static Unit Microsecond = new Unit("Microsecond", "musec", BaseUnits.Second, 1.0, 0.000001, 0.0);

	//ELECTRIC CURRENT
	public final static Unit KiloAmpere = new Unit("KiloAmpere", "kA", BaseUnits.Ampere, 1.0, 1000.0, 0.0);
	public final static Unit HectoAmpere = new Unit("HectoAmpere", "hA", BaseUnits.Ampere, 1.0, 100.0, 0.0);
	public final static Unit DecaAmpere = new Unit("DecAmpere", "daA", BaseUnits.Ampere, 1.0, 10.0, 0.0);
	public final static Unit Ampere = new Unit(BaseUnits.Ampere);
	public final static Unit DeciAmpere = new Unit("DeciAmpere", "dA", BaseUnits.Ampere, 1.0, 0.1, 0.0);
	public final static Unit CentiAmpere = new Unit("CentiAmpere", "cA", BaseUnits.Ampere, 1.0, 0.01, 0.0);
	public final static Unit MilliAmpere = new Unit("MilliAmpere", "mA", BaseUnits.Ampere, 1.0, 0.001, 0.0);
	public final static Unit MicroAmpere = new Unit("Microampere", "micro-A", BaseUnits.Ampere, 1.0, 0.000001, 0.0);
	public final static Unit NanoAmpere = new Unit("Nanoampere", "nA", BaseUnits.Ampere, 1.0, 0.000000001, 0.0);
	public final static Unit PicoAmpere = new Unit("Picoampere", "pA", BaseUnits.Ampere, 1.0, 0.000000000001, 0.0);
	public final static Unit FentoAmpere = new Unit("Fentoampere", "fA", BaseUnits.Ampere, 1.0, 0.000000000000001, 0.0);
	public final static Unit AttoAmpere = new Unit("Attoampere", "aA", BaseUnits.Ampere, 1.0, 0.000000000000000001, 0.0);

	//TEMPERATURE
	public final static Unit Celsius = new Unit("Celsius", "C", BaseUnits.Kelvin, 1.0, 1.0, 273.15);
	public final static Unit Kelvin = new Unit(BaseUnits.Kelvin);
	public final static Unit DeltaCelsius = new Unit("DeltaCelsius", "DeltaC", BaseUnits.Kelvin, 1.0, 1.0, 0.0);

	
	//AMOUNT OF SUBSTANCE
	public final static Unit KiloMole = new Unit("KiloMole", "kmol", BaseUnits.Mole, 1.0, 1000.0, 0.0);
	public final static Unit HectoMole = new Unit("HectoMole", "hmol", BaseUnits.Mole, 1.0, 100.0, 0.0);
	public final static Unit DecaMole = new Unit("DecMole", "damol", BaseUnits.Mole, 1.0, 10.0, 0.0);
	public final static Unit Mole = new Unit(BaseUnits.Mole);
	public final static Unit DeciMole = new Unit("DeciMole", "dmol", BaseUnits.Mole, 1.0, 0.1, 0.0);
	public final static Unit CentiMole = new Unit("CentiMole", "cmol", BaseUnits.Mole, 1.0, 0.01, 0.0);
	public final static Unit MilliMole = new Unit("MilliMole", "mmol", BaseUnits.Mole, 1.0, 0.001, 0.0);
	public final static Unit MicroMole = new Unit("MicroMole", "micro-mol", BaseUnits.Mole, 1.0, 0.000001, 0.0);
	public final static Unit NanoMole = new Unit("NanoMole", "nmol", BaseUnits.Mole, 1.0, 0.000000001, 0.0);
	public final static Unit PicoMole = new Unit("PicoMole", "pmol", BaseUnits.Mole, 1.0, 0.000000000001, 0.0);
	public final static Unit FentoMole = new Unit("FentoMole", "fmol", BaseUnits.Mole, 1.0, 0.000000000000001, 0.0);
	public final static Unit AttoMole = new Unit("AttoMole", "amol", BaseUnits.Mole, 1.0, 0.000000000000000001, 0.0);
	
	//LUMINOUS INTENSITY 
	public final static Unit Candela = new Unit(BaseUnits.Candela);
	
	//ANGLE
	public final static Unit Radian = new Unit(BaseUnits.Radian);
	public final static Unit Degree = new Unit("Degree", "º", BaseUnits.Radian, 1.0, 180.0/Math.PI, 0.0);
	public final static Unit Turn = new Unit("Turn", "tr", BaseUnits.Radian, 1.0, 2*Math.PI, 0.0);
	public final static Unit Gradian = new Unit("Gradian", "gon", BaseUnits.Radian, 1.0, Math.PI/200.0, 0.0);

//***********IMPERIAL SYSTEM
	
	//LENGTH	
	public final static Unit League = new Unit("League", "lea", BaseUnits.Meter, 1.0, 4828.032, 0.0); //3 miles
	public final static Unit Mile = new Unit("Mile", "ml", BaseUnits.Meter, 1.0, 1609.34, 0.0); //8 fulongs, 1760 yd, 80 chains
	public final static Unit Furlong = new Unit("Furlong", "fur", BaseUnits.Meter, 1.0, 201.168, 0.0); //220 yards
	public final static Unit Chain = new Unit("Chain", "ch", BaseUnits.Meter, 1.0, 20.1168, 0.0); //22 yards
	public final static Unit Yard = new Unit("Yard", "yd", BaseUnits.Meter, 1.0, 0.9144, 0.0); //3 feet
	public final static Unit Foot = new Unit("Foot", "ft", BaseUnits.Meter, 1.0, 0.3048, 0.0); //12 inches
	public final static Unit Inch = new Unit("Inch", "in", BaseUnits.Meter, 1.0, 0.0254, 0.0); //1000 thou
	public final static Unit Thou = new Unit("Thou", "th", BaseUnits.Meter, 1.0, 0.0000254, 0.0);
	
    //MARITIME LENGTH	
	public final static Unit Fathom = new Unit("Fathom", "ftm", BaseUnits.Meter, 1.0, 1.853184, 0.0); 
	public final static Unit Cable = new Unit("Cable", "cable", BaseUnits.Meter, 1.0, 185.3184, 0.0); //100 ftm
	public final static Unit NauticalMile = new Unit("Nautical Mile", "Nautical_ml", BaseUnits.Meter, 1.0, 1853.184, 0.0); //10 cable
	public final static Unit Link = new Unit("Link", "link", BaseUnits.Meter, 1.0, 0.201168, 0.0); // 1/100 of a chain
	public final static Unit Rod = new Unit("Rod", "rod", BaseUnits.Meter, 1.0, 5.0292, 0.0); //5.5 yd
	public final static Unit Perch = new Unit("Perch", "perch", BaseUnits.Meter, 1.0, 5.0292, 0.0); //=rod
	public final static Unit Pole = new Unit("Pole", "pole", BaseUnits.Meter, 1.0, 5.0292, 0.0); //=rod
	
	//VELOCITY
	public final static Unit MilePerSecond = new Unit("MilePerSecond", "ml/s", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit MilePerHour = new Unit("MilePerHour", "ml/h", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit YardPerSecond = new Unit("YardPerSecond", "yd/s", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit YardPerHour = new Unit("YardPerHour", "yd/h", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit FeetPerSecond = new Unit("FeetPerSecond", "ft/s", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit FeetPerHour = new Unit("FeetPerHour", "ft/h", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit InchPerSecond = new Unit("InchPerSecond", "in/s", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit InchPerHour = new Unit("InchPerHour", "in/h", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -1.0, 3600.0);

	//ACCELERATION
	public final static Unit MilePerSecondSquared = new Unit("MilePerSecondSquared", "mile/s^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit MilePerHourSquared = new Unit("MilePerHourSquared", "mile/h^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit YardPerSecondSquared = new Unit("YardPerSecondSquared", "yd/s^2", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit YardPerHourSquared = new Unit("YardPerHourSquared", "yd/h", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit FeetPerSecondSquared = new Unit("FeetPerSecondSquared", "ft/s", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit FeetPerHourSquared = new Unit("FeetPerHourSquared", "ft/h", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit InchPerSecondSquared = new Unit("InchPerSecondSquared", "in/s", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit InchPerHourSquared = new Unit("InchPerHourSquared", "in/h", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -2.0, 3600.0);

	//TEMPERATURE
	public final static Unit Farenheit = new Unit("Farenheit", "F", BaseUnits.Kelvin, 1.0, 5.0/9.0, 459.67*5.0/9.0);
	public final static Unit DeltaFarenheit = new Unit("DeltaFarenheit", "DeltaF", BaseUnits.Kelvin, 1.0, 5.0/9.0, 0.0);
	
	//AREA
    public final static Unit SquarePerch = new Unit("SquarePerch", "perch^2", BaseUnits.Meter, 2.0, 25.29285264, 0.0); //1 rod^2
	public final static Unit Acre = new Unit("Acre", "acre", BaseUnits.Meter, 2.0, 4046.8564224, 0.0); //1 furlog*1 chain=4840 yards^2
	public final static Unit Rood = new Unit("Rood", "rood", BaseUnits.Meter, 2.0, 1011.7141056, 0.0); //1 furlong*rod=1210 yards^2
	public final static Unit SquareYard = new Unit("SquareYard", "yd^2", BaseUnits.Meter, 2.0, 0.9144*0.9144, 0.0); //1 rod^2
	public final static Unit SquareFeet = new Unit("SquareFeet", "ft^2", BaseUnits.Meter, 2.0, 0.3048*0.3048, 0.0); //
	public final static Unit SquareInch = new Unit("SquareInch", "in^2", BaseUnits.Meter, 2.0, 0.0254*0.0254, 0.0); //

	//VOLUME
    public final static Unit FluidOunce = new Unit("fluid ounce", "floz", BaseUnits.Meter, 3.0, 0.0000284130625, 0.0); 
	public final static Unit Gill = new Unit("gill", "gi", BaseUnits.Meter, 3.0, 0.0001420653125, 0.0); 
	public final static Unit Pint = new Unit("pint", "pt", BaseUnits.Meter, 3.0, 0.00056826125, 0.0); 
	public final static Unit Quart = new Unit("quart", "qt", BaseUnits.Meter, 3.0, 0.0011365225, 0.0); 
	public final static Unit Gallon = new Unit("gallon", "gal", BaseUnits.Meter, 3.0, 0.00454609, 0.0); 

	public final static Unit CubicFoot = new Unit("cubicfoot", "ft^2", BaseUnits.Meter, 3.0, 0.3048*0.3048*0.3048, 0.0); 
	public final static Unit CubicInch= new Unit("cubicinch", "in^3", BaseUnits.Meter, 3.0, 0.0254*0.0254*0.0254, 0.0); 
	

	//MASS
	public final static Unit Grain = new Unit("grain", "gr", BaseUnits.Kilogram, 1.0, 0.00006479891, 0.0);
	public final static Unit Drachm = new Unit("drachm", "dr", BaseUnits.Kilogram, 1.0, 0.0017718451953125, 0.0);
	public final static Unit Ounce = new Unit("ounce", "oz", BaseUnits.Kilogram, 1.0, 0.028349523125, 0.0);
	public final static Unit Pound = new Unit("poud", "lb", BaseUnits.Kilogram, 1.0, 0.45359237, 0.0);
	public final static Unit Stone = new Unit("stone", "st", BaseUnits.Kilogram, 1.0, 6.35029318, 0.0);
	public final static Unit Quarter = new Unit("quarter", "qr", BaseUnits.Kilogram, 1.0, 12.70058636, 0.0);
	public final static Unit HundredWeight = new Unit("hundredweight", "cwt", BaseUnits.Kilogram, 1.0, 50.80234544, 0.0);
	public final static Unit Ton = new Unit("ton", "t", BaseUnits.Kilogram, 1.0, 1016.0469088, 0.0);
	public final static Unit Slug = new Unit("slug", "slug", BaseUnits.Kilogram, 1.0, 14.59390294, 0.0);

//*********** US SYSTEM
	
	//VOLUME
    public final static Unit CustomaryFluidOunce = new Unit("customary fluid ounce", "floz", BaseUnits.Meter, 3.0, 0.0000295735295625, 0.0); 
	public final static Unit FluidPint = new Unit("flpint", "flpt", BaseUnits.Meter, 3.0, 0.000473176473, 0.0); 
	public final static Unit FluidQuart = new Unit("fluidQuart", "flqt", BaseUnits.Meter, 3.0, 0.000946352946, 0.0); 
	public final static Unit LiquidGallon = new Unit("liquidgallon", "liqgal", BaseUnits.Meter, 3.0, 0.003785411784, 0.0); //

//************* SI DERIVED UNITS
	
	public final static Unit Gray = new Unit(DerivedUnits.Gray);
	public final static Unit GrayPerSecond = new Unit(DerivedUnits.GrayPerSecond);
	public final static Unit Becquerel = new Unit(DerivedUnits.Becquerel);
	public final static Unit MolePerCubicMeter = new Unit(DerivedUnits.MolePerCubicMeter);
	public final static Unit MolePerKilogram = new Unit(DerivedUnits.MolePerKilogram);
	public final static Unit RadianPerSecondSquared = new Unit(DerivedUnits.RadianPerSecondSquared);
	public final static Unit KilogramMeterSquared = new Unit(DerivedUnits.KilogramMeterSquared);
	public final static Unit JouleSecond = new Unit(DerivedUnits.JouleSecond);
	public final static Unit RadianPerSecond = new Unit(DerivedUnits.RadianPerSecond);
	public final static Unit SquareMeter = new Unit(DerivedUnits.SquareMeter);
	public final static Unit SquareMeterSteradian = new Unit(DerivedUnits.SquareMeterSteradian);
	public final static Unit SquareMeterKelvin = new Unit(DerivedUnits.SquareMeterKelvin);
	public final static Unit SquareMeterPerKelvin = new Unit(DerivedUnits.SquareMeterPerKelvin);
	public final static Unit Farad = new Unit(DerivedUnits.Farad);
	public final static Unit Katal = new Unit(DerivedUnits.Katal);
	public final static Unit WattPerSquareMeterKelvin = new Unit(DerivedUnits.WattPerSquareMeterKelvin);
	public final static Unit KilogramPerCubicMeter = new Unit(DerivedUnits.KilogramPerCubicMeter);
	public final static Unit Sievert = new Unit(DerivedUnits.Sievert);
	public final static Unit PascalSecond = new Unit(DerivedUnits.PascalSecond);
	public final static Unit Coulomb = new Unit(DerivedUnits.Coulomb);
	public final static Unit CoulombPerMeter = new Unit(DerivedUnits.CoulombPerMeter);
	public final static Unit CoulombPerCubicMeter = new Unit(DerivedUnits.CoulombPerCubicMeter);
	public final static Unit CoulombPerMole = new Unit(DerivedUnits.CoulombPerMole);
	public final static Unit AmperePerSquareMeter = new Unit(DerivedUnits.AmperePerSquareMeter);
	public final static Unit AmperePerRadian = new Unit(DerivedUnits.AmperePerRadian);
	public final static Unit CoulombMeter = new Unit(DerivedUnits.CoulombMeter);
	public final static Unit VoltPerMeter = new Unit(DerivedUnits.VoltPerMeter);
	public final static Unit CoulombPerSquareMeter = new Unit(DerivedUnits.CoulombPerSquareMeter);
	public final static Unit Siemens = new Unit(DerivedUnits.Siemens);
	public final static Unit Volt = new Unit(DerivedUnits.Volt);
	public final static Unit JoulePerCubicMeter = new Unit(DerivedUnits.JoulePerCubicMeter);
	public final static Unit Joule = new Unit(DerivedUnits.Joule);
	public final static Unit JoulePerSquareMeter = new Unit(DerivedUnits.JoulePerSquareMeter);
	public final static Unit CoulombPerKilogram = new Unit(DerivedUnits.CoulombPerKilogram);
	public final static Unit Newton = new Unit(DerivedUnits.Newton);
	public final static Unit NewtonPerCoulomb = new Unit(DerivedUnits.NewtonPerCoulomb);
	public final static Unit NewtonPerMeter = new Unit(DerivedUnits.NewtonPerMeter);
	public final static Unit Hertz = new Unit(DerivedUnits.Hertz);
	public final static Unit CubicMeterPerKilogramSecondSquared = new Unit(DerivedUnits.CubicMeterPerKilogramSecondSquared);
	public final static Unit JoulePerKelvin = new Unit(DerivedUnits.JoulePerKelvin);
	public final static Unit Lux = new Unit(DerivedUnits.Lux);
	public final static Unit Henry = new Unit(DerivedUnits.Henry);
	public final static Unit PerMole = new Unit(DerivedUnits.PerMole);
	public final static Unit MeterPerFarad = new Unit(DerivedUnits.MeterPerFarad);
	public final static Unit SquareMeterPerSecond = new Unit(DerivedUnits.SquareMeterPerSecond);
	public final static Unit MeterKilogram = new Unit(DerivedUnits.MeterKilogram);
	public final static Unit MeterKelvin = new Unit(DerivedUnits.MeterKelvin);
	public final static Unit MeterPerSecondSquared = new Unit(DerivedUnits.MeterPerSecondSquared);
	public final static Unit KilogramMeterPerSecond = new Unit(DerivedUnits.KilogramMeterPerSecond);
	public final static Unit MeterPerKelvin = new Unit(DerivedUnits.MeterPerKelvin);
	public final static Unit MeterPerSecond = new Unit(DerivedUnits.MeterPerSecond);
	public final static Unit CandelaPerSquareMeter = new Unit(DerivedUnits.CandelaPerSquareMeter);
	public final static Unit Lumen = new Unit(DerivedUnits.Lumen);
	public final static Unit JoulePerTesla = new Unit(DerivedUnits.JoulePerTesla);
	public final static Unit AmpereTurnPerMeter = new Unit(DerivedUnits.AmpereTurnPerMeter);
	public final static Unit Weber = new Unit(DerivedUnits.Weber);
	public final static Unit Tesla = new Unit(DerivedUnits.Tesla);
	public final static Unit AmpereTurn = new Unit(DerivedUnits.AmpereTurn);
	public final static Unit KilogramKelvin = new Unit(DerivedUnits.KilogramKelvin);
	public final static Unit KilogramPerSecond = new Unit(DerivedUnits.KilogramPerSecond);
	public final static Unit KilogramPerSquareMeter = new Unit(DerivedUnits.KilogramPerSquareMeter);
	public final static Unit KilogramPerMeter = new Unit(DerivedUnits.KilogramPerMeter);
	public final static Unit JoulePerMole = new Unit(DerivedUnits.JoulePerMole);
	public final static Unit JoulePerMoleKelvin = new Unit(DerivedUnits.JoulePerMoleKelvin);
	public final static Unit HenryPerMeter = new Unit(DerivedUnits.HenryPerMeter);
	public final static Unit FaradPerMeter = new Unit(DerivedUnits.FaradPerMeter);
	public final static Unit Watt = new Unit(DerivedUnits.Watt);
	public final static Unit WattPerSteradian = new Unit(DerivedUnits.WattPerSteradian);
	public final static Unit WattPerSquareMeterSteradian = new Unit(DerivedUnits.WattPerSquareMeterSteradian);
	public final static Unit WattPerSquareMeter = new Unit(DerivedUnits.WattPerSquareMeter);
	public final static Unit Pascal = new Unit(DerivedUnits.Pascal);
	public final static Unit Ohm = new Unit(DerivedUnits.Ohm);
	public final static Unit Steradian = new Unit(DerivedUnits.Steradian);
	public final static Unit JoulePerKilogram = new Unit(DerivedUnits.JoulePerKilogram);
	public final static Unit JoulePerKilogramKelvin = new Unit(DerivedUnits.JoulePerKilogramKelvin);
	public final static Unit JoulePerKilogramKelvinPerPascal = new Unit(DerivedUnits.JoulePerKilogramKelvinPerPascal);
	public final static Unit JoulePerKilogramKelvinPerCubicMeter = new Unit(DerivedUnits.JoulePerKilogramKelvinPerCubicMeter);
	public final static Unit MoleKelvin = new Unit(DerivedUnits.MoleKelvin);
	public final static Unit WattPerMeterKelvin = new Unit(DerivedUnits.WattPerMeterKelvin);
	public final static Unit SquareMeterKelvinPerWatt = new Unit(DerivedUnits.SquareMeterKelvinPerWatt);
	public final static Unit KelvinPerWatt = new Unit(DerivedUnits.KelvinPerWatt);
	public final static Unit MeterKelvinPerWatt = new Unit(DerivedUnits.MeterKelvinPerWatt);
	public final static Unit NewtonPerKilogram = new Unit(DerivedUnits.NewtonPerKilogram);
	public final static Unit SecondTimeSquared = new Unit(DerivedUnits.SecondTimeSquared);
	public final static Unit NewtonMeter = new Unit(DerivedUnits.NewtonMeter);
	public final static Unit CubicMeter = new Unit(DerivedUnits.CubicMeter);
	public final static Unit CubicMeterPerKelvin = new Unit(DerivedUnits.CubicMeterPerKelvin);
	public final static Unit CubicMeterPerSecond = new Unit(DerivedUnits.CubicMeterPerSecond);
	public final static Unit JoulePerCubicMeterKelvin = new Unit(DerivedUnits.JoulePerCubicMeterKelvin);
	
}
