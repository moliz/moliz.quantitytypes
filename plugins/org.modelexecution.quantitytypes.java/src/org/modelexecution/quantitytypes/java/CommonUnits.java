package org.modelexecution.quantitytypes.java;

public class CommonUnits {

	
	//METRIC SYSTEM - SI UNITS

	//LENGTH
	public final static Unit EXAM = new Unit("Exameter", "Em", BaseUnits.Meter, 1.0, 1000000000000000000.0, 0.0);
	public final static Unit PETAM = new Unit("Petameter", "Pm", BaseUnits.Meter, 1.0, 1000000000000000.0, 0.0);
	public final static Unit TERAM = new Unit("Terameter", "Tm", BaseUnits.Meter, 1.0, 1000000000000.0, 0.0);
	public final static Unit GIGAM = new Unit("Gigameter", "Gm", BaseUnits.Meter, 1.0, 1000000000.0, 0.0);
	public final static Unit MEGAM = new Unit("Megaemeter", "Mm", BaseUnits.Meter, 1.0, 1000000.0, 0.0);
	public final static Unit KM = new Unit("Kilometer", "km", BaseUnits.Meter, 1.0, 1000.0, 0.0);
	public final static Unit HM = new Unit("Hectometer", "hm", BaseUnits.Meter, 1.0, 100.0, 0.0);
	public final static Unit DAM = new Unit("Decameter", "dam", BaseUnits.Meter, 1.0, 10.0, 0.0);
	public final static Unit M = new Unit(BaseUnits.Meter);
	public final static Unit DM = new Unit("Decimeter", "dm", BaseUnits.Meter, 1.0, 0.1, 0.0);
	public final static Unit CM = new Unit("Centimeter", "cm", BaseUnits.Meter, 1.0, 0.01, 0.0);
	public final static Unit MM = new Unit("Millimeter", "mm", BaseUnits.Meter, 1.0, 0.001, 0.0);
	public final static Unit MICROM = new Unit("Micrometer", "micro-m", BaseUnits.Meter, 1.0, 0.000001, 0.0);
	public final static Unit NANOM = new Unit("Nanometer", "nm", BaseUnits.Meter, 1.0, 0.000000001, 0.0);
	public final static Unit PICOM = new Unit("Picometer", "pm", BaseUnits.Meter, 1.0, 0.000000000001, 0.0);
	public final static Unit FENTOM = new Unit("Fentometer", "fm", BaseUnits.Meter, 1.0, 0.000000000000001, 0.0);
	public final static Unit ATTOM = new Unit("Attometer", "am", BaseUnits.Meter, 1.0, 0.000000000000000001, 0.0);

	//AREA (in addition to the derived measures defined by the SI)
	public final static Unit KM2 = new Unit("Kilometer^2", "km^2", BaseUnits.Meter, 2.0, 1000.0, 0.0);
	public final static Unit HM2 = new Unit("Hectometer^2", "hm^2", BaseUnits.Meter, 2.0, 100.0, 0.0);
	public final static Unit DAM2 = new Unit("Decameter^2", "dam^2", BaseUnits.Meter, 2.0, 10.0, 0.0);
	public final static Unit DM2 = new Unit("Decimeter^2", "dm^2", BaseUnits.Meter, 2.0, 0.1, 0.0);
	public final static Unit CM2 = new Unit("Centimeter^2", "cm^2", BaseUnits.Meter, 2.0, 0.01, 0.0);
	public final static Unit MM2 = new Unit("Millimeter^2", "mm^2", BaseUnits.Meter, 2.0, 0.001, 0.0);

	
	//VOLUME (in addition to the derived measures defined by the SI)
	public final static Unit KM3 = new Unit("Kilometer^3", "km^3", BaseUnits.Meter, 3.0, 1000.0, 0.0);
	public final static Unit HM3 = new Unit("Hectometer^3", "hm^3", BaseUnits.Meter, 3.0, 100.0, 0.0);
	public final static Unit DAM3 = new Unit("Decameter^3", "dam^3", BaseUnits.Meter, 3.0, 10.0, 0.0);
	public final static Unit DM3 = new Unit("Decimeter^3", "dm^3", BaseUnits.Meter, 3.0, 0.1, 0.0);
	public final static Unit CM3 = new Unit("Centimeter^3", "cm^3", BaseUnits.Meter, 3.0, 0.01, 0.0);
	public final static Unit MM3 = new Unit("Millimeter^3", "mm^3", BaseUnits.Meter, 3.0, 0.001, 0.0);

	public final static Unit EXALITRE = new Unit("Exalitre", "Ele", BaseUnits.Meter, 3.0, 10000000000000000.0, 0.0);
	public final static Unit PETALITRE = new Unit("Petalitre", "Plt", BaseUnits.Meter, 3.0, 1000000000000.0, 0.0);
	public final static Unit TERALITRE = new Unit("Teralitre", "Tlt", BaseUnits.Meter, 3.0, 1000000000.0, 0.0);
	public final static Unit GIGALITRE = new Unit("Gigalitre", "Glt", BaseUnits.Meter, 3.0, 1000000.0, 0.0);
	public final static Unit MEGALITRE = new Unit("Megalitre", "Mlt", BaseUnits.Meter, 3.0, 1000.0, 0.0);
	public final static Unit KLITRE = new Unit("Kilolitre", "klt", BaseUnits.Meter, 3.0, 1.0, 0.0);
	public final static Unit HLITRE = new Unit("Hectolitre", "hlt", BaseUnits.Meter, 3.0, 0.1, 0.0);
	public final static Unit DAMLITRE = new Unit("Decalitre", "dalt", BaseUnits.Meter, 3.0, 0.01, 0.0);
	public final static Unit LITRE = new Unit("litre", "lt", BaseUnits.Meter, 3.0, 0.001, 0.0);
	public final static Unit DLITRE = new Unit("Decilitre", "dlt", BaseUnits.Meter, 3.0, 0.0001, 0.0);
	public final static Unit CLITRE = new Unit("Centilitre", "clt", BaseUnits.Meter, 3.0, 0.00001, 0.0);
	public final static Unit MLITRE = new Unit("Millilitre", "mlt", BaseUnits.Meter, 3.0, 0.000001, 0.0);
	public final static Unit MICROLITRE = new Unit("Microlitre", "micro-lt", BaseUnits.Meter, 3.0, 0.000000001, 0.0);
	public final static Unit NANOLITRE = new Unit("Nanolitre", "nlt", BaseUnits.Meter, 3.0, 0.000000000001, 0.0);
	public final static Unit PICOLITRE = new Unit("Picolitre", "plt", BaseUnits.Meter, 3.0, 0.000000000000001, 0.0);
	public final static Unit FENTOLITRE = new Unit("Fentolitre", "flt", BaseUnits.Meter, 3.0, 0.000000000000000001, 0.0);
	public final static Unit ATTOLITRE = new Unit("Attolitre", "alt", BaseUnits.Meter, 3.0, 0.000000000000000000001, 0.0);

	
	//VELOCITY (in addition to the derived measures defined by the SI)
	public final static Unit KMS = new Unit("KilometerPerSecond", "km/s", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit KMH = new Unit("KilometerPerHour", "km/h", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit KMS2 = new Unit("KilometerPerSecondSquared", "km/s^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit KMH2 = new Unit("KilometerPerHourSquared", "km/h^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit CMS = new Unit("CentimeterPerSecond", "cm/s", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit CMH = new Unit("CentimeterPerHour", "cm/h", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit CMS2 = new Unit("CentimeterPerSecondSquared", "cm/s^2", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit CMH2 = new Unit("CentimeterPerHourSquared", "cm/h^2", BaseUnits.Meter, 1.0, 0.01, 0.0,BaseUnits.Second, -2.0, 3600.0);

	//MASS 
	public final static Unit EXAG = new Unit("Exagram", "Eg", BaseUnits.Kilogram, 1.0,   10000000000000000.0, 0.0);
	public final static Unit PETAG = new Unit("Petagram", "Pg", BaseUnits.Kilogram, 1.0, 1000000000000.0, 0.0);
	public final static Unit TERAG = new Unit("Teragram", "Tg", BaseUnits.Kilogram, 1.0, 1000000000.0, 0.0);
	public final static Unit GIGAG = new Unit("Gigagram", "Gg", BaseUnits.Kilogram, 1.0, 1000000.0, 0.0);
	public final static Unit MEGAG = new Unit("Megagram", "Mg", BaseUnits.Kilogram, 1.0, 1000.0, 0.0);
	public final static Unit KG = new Unit(BaseUnits.Kilogram);
	public final static Unit HG = new Unit("Hectogram", "hg", BaseUnits.Kilogram, 1.0, 0.1, 0.0);
	public final static Unit DAG = new Unit("Decagram", "dag", BaseUnits.Kilogram, 1.0, 0.01, 0.0);
	public final static Unit GR = new Unit("Gram", "g", BaseUnits.Kilogram, 1.0, 0.001, 0.0);
	public final static Unit DG = new Unit("Decigram", "dg", BaseUnits.Kilogram, 1.0, 0.0001, 0.0);
	public final static Unit CG = new Unit("Centigram", "cg", BaseUnits.Kilogram, 1.0, 0.00001, 0.0);
	public final static Unit MG = new Unit("Milligram", "mg", BaseUnits.Kilogram, 1.0, 0.000001, 0.0);
	public final static Unit MICROG = new Unit("Microgram", "micro-g", BaseUnits.Kilogram, 1.0, 0.000000001, 0.0);
	public final static Unit NANOG = new Unit("Nanogram", "ng", BaseUnits.Kilogram, 1.0, 0.000000000001, 0.0);
	public final static Unit PICOG = new Unit("Picogram", "pg", BaseUnits.Kilogram, 1.0, 0.000000000000001, 0.0);
	public final static Unit FENTOG = new Unit("Fentogram", "fg", BaseUnits.Kilogram, 1.0, 0.000000000000000001, 0.0);
	public final static Unit ATTOG = new Unit("Attogram", "ag", BaseUnits.Kilogram, 1.0, 0.000000000000000000001, 0.0);

	//TIME
	public final static Unit HOUR = new Unit("Hour", "hr", BaseUnits.Second, 1.0, 3600.0, 0.0);
	public final static Unit MIN = new Unit("Minute", "min", BaseUnits.Second, 1.0, 60.0, 0.0);
	public final static Unit SEC = new Unit(BaseUnits.Second);
	public final static Unit MILLISEC = new Unit("Millisecond", "ms", BaseUnits.Second, 1.0, 0.001, 0.0);
	public final static Unit MICROSEC = new Unit("Microsecond", "musec", BaseUnits.Second, 1.0, 0.000001, 0.0);

	//ELECTRIC CURRENT
	public final static Unit KA = new Unit("KiloAmpere", "kA", BaseUnits.Ampere, 1.0, 1000.0, 0.0);
	public final static Unit HA = new Unit("HectoAmpere", "hA", BaseUnits.Ampere, 1.0, 100.0, 0.0);
	public final static Unit DAA = new Unit("DecAmpere", "daA", BaseUnits.Ampere, 1.0, 10.0, 0.0);
	public final static Unit AMPERE = new Unit(BaseUnits.Ampere);
	public final static Unit DA = new Unit("DeciAmpere", "dA", BaseUnits.Ampere, 1.0, 0.1, 0.0);
	public final static Unit CA = new Unit("CentiAmpere", "cA", BaseUnits.Ampere, 1.0, 0.01, 0.0);
	public final static Unit MA = new Unit("MilliAmpere", "mA", BaseUnits.Ampere, 1.0, 0.001, 0.0);
	public final static Unit MICROA = new Unit("Microampere", "micro-A", BaseUnits.Ampere, 1.0, 0.000001, 0.0);
	public final static Unit NANOA = new Unit("Nanoampere", "nA", BaseUnits.Ampere, 1.0, 0.000000001, 0.0);
	public final static Unit PICOA = new Unit("Picoampere", "pA", BaseUnits.Ampere, 1.0, 0.000000000001, 0.0);
	public final static Unit FENTOA = new Unit("Fentoampere", "fA", BaseUnits.Ampere, 1.0, 0.000000000000001, 0.0);
	public final static Unit ATTOA = new Unit("Attoampere", "aA", BaseUnits.Ampere, 1.0, 0.000000000000000001, 0.0);

	//TEMPERATURE
	public final static Unit CELSIUS = new Unit("Celsius", "C", BaseUnits.Kelvin, 1.0, 1.0, 273.15);
	public final static Unit KELVIN = new Unit(BaseUnits.Kelvin);
	public final static Unit DeltaCELSIUS = new Unit("DeltaCelsius", "DeltaC", BaseUnits.Kelvin, 1.0, 1.0, 0.0);

	
	//AMOUNT OF SUBSTANCE
	public final static Unit KMOL= new Unit("KiloMole", "kmol", BaseUnits.Mole, 1.0, 1000.0, 0.0);
	public final static Unit HMOL = new Unit("HectoMole", "hmol", BaseUnits.Mole, 1.0, 100.0, 0.0);
	public final static Unit DAMOL = new Unit("DecMole", "damol", BaseUnits.Mole, 1.0, 10.0, 0.0);
	public final static Unit MOL = new Unit(BaseUnits.Mole);
	public final static Unit DMOL = new Unit("DeciMole", "dmol", BaseUnits.Mole, 1.0, 0.1, 0.0);
	public final static Unit CMOL = new Unit("CentiMole", "cmol", BaseUnits.Mole, 1.0, 0.01, 0.0);
	public final static Unit MMOL = new Unit("MilliMole", "mmol", BaseUnits.Mole, 1.0, 0.001, 0.0);
	public final static Unit MICROMOL = new Unit("MicroMole", "micro-mol", BaseUnits.Mole, 1.0, 0.000001, 0.0);
	public final static Unit NANOMOL = new Unit("NanoMole", "nmol", BaseUnits.Mole, 1.0, 0.000000001, 0.0);
	public final static Unit PICOMOL = new Unit("PicoMole", "pmol", BaseUnits.Mole, 1.0, 0.000000000001, 0.0);
	public final static Unit FENTOMOL = new Unit("FentoMole", "fmol", BaseUnits.Mole, 1.0, 0.000000000000001, 0.0);
	public final static Unit ATTOMOL = new Unit("AttoMole", "amol", BaseUnits.Mole, 1.0, 0.000000000000000001, 0.0);
	
	//LUMINOUS INTENSITY 
	public final static Unit CANDELA = new Unit(BaseUnits.Candela);
	
	//ANGLE
	public final static Unit RADIAN = new Unit(BaseUnits.Radian);
	public final static Unit DEG = new Unit("Degree", "º", BaseUnits.Radian, 1.0, 180.0/Math.PI, 0.0);
	public final static Unit TURN = new Unit("Turn", "tr", BaseUnits.Radian, 1.0, 2*Math.PI, 0.0);
	public final static Unit GRADIAN = new Unit("Gradian", "gon", BaseUnits.Radian, 1.0, Math.PI/200.0, 0.0);

//***********IMPERIAL SYSTEM
	
	//LENGTH	
	public final static Unit LEAGUE = new Unit("League", "lea", BaseUnits.Meter, 1.0, 4828.032, 0.0); //3 miles
	public final static Unit MILE = new Unit("Mile", "ml", BaseUnits.Meter, 1.0, 1609.34, 0.0); //8 fulongs, 1760 yd, 80 chains
	public final static Unit FURLONG = new Unit("Furlong", "fur", BaseUnits.Meter, 1.0, 201.168, 0.0); //220 yards
	public final static Unit CHAIN = new Unit("Chain", "ch", BaseUnits.Meter, 1.0, 20.1168, 0.0); //22 yards
	public final static Unit YARD = new Unit("Yard", "yd", BaseUnits.Meter, 1.0, 0.9144, 0.0); //3 feet
	public final static Unit FT = new Unit("Foot", "ft", BaseUnits.Meter, 1.0, 0.3048, 0.0); //12 inches
	public final static Unit INCH = new Unit("Inch", "in", BaseUnits.Meter, 1.0, 0.0254, 0.0); //1000 thou
	public final static Unit THOU = new Unit("Thou", "th", BaseUnits.Meter, 1.0, 0.0000254, 0.0);
	
    //MARITIME LENGTH	
	public final static Unit FATHOM = new Unit("Fathom", "ftm", BaseUnits.Meter, 1.0, 1.853184, 0.0); 
	public final static Unit CABLE = new Unit("Cable", "cable", BaseUnits.Meter, 1.0, 185.3184, 0.0); //100 ftm
	public final static Unit NAUT_MILE = new Unit("Nautical Mile", "Nautical_ml", BaseUnits.Meter, 1.0, 1853.184, 0.0); //10 cable
	public final static Unit LINK = new Unit("League", "link", BaseUnits.Meter, 1.0, 0.201168, 0.0); // 1/100 of a chain
	public final static Unit ROD = new Unit("League", "rod", BaseUnits.Meter, 1.0, 5.0292, 0.0); //5.5 yd
	public final static Unit PERCH = new Unit("League", "perch", BaseUnits.Meter, 1.0, 5.0292, 0.0); //=rod
	public final static Unit POLE = new Unit("League", "pole", BaseUnits.Meter, 1.0, 5.0292, 0.0); //=rod
	
	//VELOCITY
	public final static Unit MILEPERS = new Unit("MilePerSecond", "ml/s", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit MILEPERH = new Unit("MilePerHour", "ml/h", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit YARDPERS = new Unit("YardPerSecond", "yd/s", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit YARDPERH = new Unit("YardPerHour", "yd/h", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit FEETPERS = new Unit("FeetPerSecond", "ft/s", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit FEETPERH = new Unit("FeetPerHour", "ft/h", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -1.0, 3600.0);
	public final static Unit INCHPERS = new Unit("InchPerSecond", "in/s", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -1.0, 1.0);
	public final static Unit INCHPERH = new Unit("InchPerHour", "in/h", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -1.0, 3600.0);

	//ACCELERATION
	public final static Unit MILEPERS2 = new Unit("MilePerSecondSquared", "mile/s^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit MILEPERH2 = new Unit("MilePerHourSquared", "mile/h^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit YARDPERS2 = new Unit("YardPerSecond", "yd/s", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit YARDPERH2 = new Unit("YardPerHour", "yd/h", BaseUnits.Meter, 1.0, 0.9144, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit FEETPERS2 = new Unit("FeetPerSecond", "ft/s", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit FEETPERH2 = new Unit("FeetPerHour", "ft/h", BaseUnits.Meter, 1.0, 0.3048, 0.0,BaseUnits.Second, -2.0, 3600.0);
	public final static Unit INCHPERS2 = new Unit("InchPerSecond", "in/s", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -2.0, 1.0);
	public final static Unit INCHPERH2 = new Unit("InchPerHour", "in/h", BaseUnits.Meter, 1.0, 0.0254, 0.0,BaseUnits.Second, -2.0, 3600.0);

	//TEMPERATURE
	public final static Unit FARENHEIT = new Unit("Farenheit", "F", BaseUnits.Kelvin, 1.0, 5.0/9.0, 459.67*5.0/9.0);
	public final static Unit DeltaFARENHEIT = new Unit("DeltaFarenheit", "DeltaF", BaseUnits.Kelvin, 1.0, 5.0/9.0, 0.0);
	
	//AREA
    public final static Unit SQUAREPERCH = new Unit("SquarePerch", "perch^2", BaseUnits.Meter, 2.0, 25.29285264, 0.0); //1 rod^2
	public final static Unit ACRE = new Unit("Acre", "acre", BaseUnits.Meter, 2.0, 4046.8564224, 0.0); //1 furlog*1 chain=4840 yards^2
	public final static Unit ROOD = new Unit("Rood", "rood", BaseUnits.Meter, 2.0, 1011.7141056, 0.0); //1 furlong*rod=1210 yards^2
	public final static Unit SQUAREYARD = new Unit("SquareYard", "yd^2", BaseUnits.Meter, 2.0, 0.9144*0.9144, 0.0); //1 rod^2
	public final static Unit SQUAREFEET = new Unit("SquareFeet", "ft^2", BaseUnits.Meter, 2.0, 0.3048*0.3048, 0.0); //
	public final static Unit SQUAREINCH = new Unit("SquareInch", "in^2", BaseUnits.Meter, 2.0, 0.0254*0.0254, 0.0); //

	//VOLUME
    public final static Unit FLUIDOUNCE = new Unit("fluid ounce", "floz", BaseUnits.Meter, 3.0, 0.0000284130625, 0.0); 
	public final static Unit GILL = new Unit("gill", "gi", BaseUnits.Meter, 3.0, 0.0001420653125, 0.0); 
	public final static Unit PINT = new Unit("pint", "pt", BaseUnits.Meter, 3.0, 0.00056826125, 0.0); 
	public final static Unit QUART = new Unit("quart", "qt", BaseUnits.Meter, 3.0, 0.0011365225, 0.0); 
	public final static Unit GALLON= new Unit("gallon", "gal", BaseUnits.Meter, 3.0, 0.00454609, 0.0); 

	public final static Unit CUBICFOOT= new Unit("cubicfoot", "ft^2", BaseUnits.Meter, 3.0, 0.3048*0.3048*0.3048, 0.0); 
	public final static Unit CUBICINCH= new Unit("cubicinch", "in^3", BaseUnits.Meter, 3.0, 0.0254*0.0254*0.0254, 0.0); 
	

	//MASS
	public final static Unit GRAIN = new Unit("grain", "gr", BaseUnits.Kilogram, 1.0, 0.00006479891, 0.0);
	public final static Unit DRACHM = new Unit("drachm", "dr", BaseUnits.Kilogram, 1.0, 0.0017718451953125, 0.0);
	public final static Unit OUNCE = new Unit("grain", "oz", BaseUnits.Kilogram, 1.0, 0.028349523125, 0.0);
	public final static Unit POUND = new Unit("grain", "lb", BaseUnits.Kilogram, 1.0, 0.45359237, 0.0);
	public final static Unit STONE = new Unit("grain", "st", BaseUnits.Kilogram, 1.0, 6.35029318, 0.0);
	public final static Unit QUARTER = new Unit("grain", "qr", BaseUnits.Kilogram, 1.0, 12.70058636, 0.0);
	public final static Unit HUNDREDWEIGHT = new Unit("hundredweight", "cwt", BaseUnits.Kilogram, 1.0, 50.80234544, 0.0);
	public final static Unit TON = new Unit("ton", "t", BaseUnits.Kilogram, 1.0, 1016.0469088, 0.0);
	public final static Unit SLUG = new Unit("slug", "slug", BaseUnits.Kilogram, 1.0, 14.59390294, 0.0);

//*********** US SYSTEM
	
	//VOLUME
    public final static Unit CUSTFLUIDOUNCE = new Unit("customary fluid ounce", "floz", BaseUnits.Meter, 3.0, 0.0000295735295625, 0.0); 
	public final static Unit FLUIDPINT = new Unit("flpint", "flpt", BaseUnits.Meter, 3.0, 0.000473176473, 0.0); 
	public final static Unit FLUIDQUART = new Unit("fluidQuart", "flqt", BaseUnits.Meter, 3.0, 0.000946352946, 0.0); 
	public final static Unit LIQUIDGALLON= new Unit("liquidgallon", "liqgal", BaseUnits.Meter, 3.0, 0.003785411784, 0.0); //

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
