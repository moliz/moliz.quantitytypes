package org.modelexecution.quantitytypes.java;

public class CommonUnits {

	// SOME EXAMPLES OF HOW UNITS CAN BE CREATED

	public final static Unit KM = new Unit("Kilometer", "Km", BaseUnits.Meter, 1.0, 1000.0, 0.0);
	public final static Unit HM = new Unit("Hectometer", "Hm", BaseUnits.Meter, 1.0, 100.0, 0.0);
	public final static Unit DAM = new Unit("Decameter", "Dam", BaseUnits.Meter, 1.0, 10.0, 0.0);
	public final static Unit M = new Unit(BaseUnits.Meter);
	public final static Unit DM = new Unit("Decimeter", "dm", BaseUnits.Meter, 1.0, 0.1, 0.0);
	public final static Unit CM = new Unit("Centimeter", "cm", BaseUnits.Meter, 1.0, 0.01, 0.0);
	public final static Unit MM = new Unit("Milimeter", "mm", BaseUnits.Meter, 1.0, 0.001, 0.0);

	public final static Unit KG = new Unit(BaseUnits.Kilogram);
	public final static Unit HG = new Unit("Hectogram", "Hgr", BaseUnits.Kilogram, 1.0, 0.1, 0.0);
	public final static Unit DAG = new Unit("Decagram", "Dagr", BaseUnits.Kilogram, 1.0, 0.01, 0.0);
	public final static Unit GR = new Unit("Gram", "gr", BaseUnits.Kilogram, 1.0, 0.001, 0.0);
	public final static Unit DG = new Unit("Decigram", "dgr", BaseUnits.Kilogram, 1.0, 0.0001, 0.0);
	public final static Unit CG = new Unit("Centigram", "cgr", BaseUnits.Kilogram, 1.0, 0.00001, 0.0);
	public final static Unit MG = new Unit("Miligram", "mgr", BaseUnits.Kilogram, 1.0, 0.000001, 0.0);

	public final static Unit KMS = new Unit("KilometerPerSecond", "Km/s", BaseUnits.Meter, 1.0, 1000.0, 0.0,
			BaseUnits.Second, -1.0, 1.0, 0.0);
	public final static Unit KMH = new Unit("KilometerPerHour", "Km/h", BaseUnits.Meter, 1.0, 1000.0, 0.0,
			BaseUnits.Second, -1.0, 3600.0, 0.0);
	public final static Unit KMS2 = new Unit("KilometerPerSecondSquared", "Km/s^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,
			BaseUnits.Second, -2.0, 1.0, 0.0);
	public final static Unit KMH2 = new Unit("KilometerPerHourSquared", "Km/h^2", BaseUnits.Meter, 1.0, 1000.0, 0.0,
			BaseUnits.Second, -2.0, 3600.0, 0.0);

	public final static Unit MILE = new Unit("Mile", "Mile", BaseUnits.Meter, 1.0, 1609.34, 0.0);
	public final static Unit YARD = new Unit("Yard", "yd", BaseUnits.Meter, 1.0, 0.9144, 0.0);
	public final static Unit FT = new Unit("Foot", "ft", BaseUnits.Meter, 1.0, 0.3048, 0.0);
	public final static Unit INCH = new Unit("Inch", "in", BaseUnits.Meter, 1.0, 0.0254, 0.0);

	public final static Unit MS = new Unit("MilePerSecond", "mile/s", BaseUnits.Meter, 1.0, 1609.34, 0.0,
			BaseUnits.Second, -1.0, 1.0, 0.0);
	public final static Unit MH = new Unit("MilePerHour", "mile/h", BaseUnits.Meter, 1.0, 1609.34, 0.0,
			BaseUnits.Second, -1.0, 3600.0, 0.0);
	public final static Unit MS2 = new Unit("MilePerSecondSquared", "mile/s^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,
			BaseUnits.Second, -2.0, 1.0, 0.0);
	public final static Unit MH2 = new Unit("MilePerHourSquared", "mile/h^2", BaseUnits.Meter, 1.0, 1609.34, 0.0,
			BaseUnits.Second, -2.0, 3600.0, 0.0);

	public final static Unit FARENHEIT = new Unit("Farenheit", "F", BaseUnits.Kelvin, 1.0, 0.55555555556,
			255.372222222);
	public final static Unit CELSIUS = new Unit("Celsius", "C", BaseUnits.Kelvin, 1.0, 1.0, 273.15);
	public final static Unit KELVIN = new Unit(BaseUnits.Kelvin);

}
