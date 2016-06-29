package org.modelexecution.quantitytypes.java;


public class UnitsLib {
	
	public BaseUnits unitOfTheDimension(BaseDimensions d){
			return BaseUnits.values()[d.ordinal()];
		}
	public DerivedUnits unitOfTheDimension(DerivedDimensions d){
		return DerivedUnits.values()[d.ordinal()];
	}
	public BaseDimensions dimensionOfUnit(BaseUnits u){
			return BaseDimensions.values()[u.ordinal()];
		}
	public DerivedDimensions dimensionOfUnit(DerivedUnits u){
		return DerivedDimensions.values()[u.ordinal()];
	}

	/**********
	 * Conversions
	 */
	public Unit toUnit(DerivedUnits d){
		
		switch(d){
		case Gray:
			return new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0);
		case GrayPerSecond:
			return new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0);
		case Becquerel:
			return new Unit(BaseUnits.Second,-1.0);
		case MolePerCubicMeter:
			return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0);
		case MolePerKilogram:
			return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0);
//THIS IS WORK IN PROGRESS
		case RadianPerSecondSquared:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case KilogramMeterSquared:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case JouleSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case RadianPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case SquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case SquareMeterSteradian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case SquareMeterKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			SquareMeterPerKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Farad:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Katal:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			WattPerSquareMeterKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramPerCubicMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Sievert:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			PascalSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Coulomb:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombPerCubicMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombPerMole:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			AmperePerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			AmperePerRadian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			VoltPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombPerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Siemens:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Volt:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerCubicMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Joule:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CoulombPerKilogram:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Newton:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			NewtonPerCoulomb:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			NewtonPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Hertz:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CubicMeterPerKilogramSecondSquared:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		// case Watt: duplicated
		// case WattPerSquareMeter: duplicated
		case 
			Lux:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Henry:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			PerMole:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterPerFarad:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			SquareMeterPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterKilogram:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterPerSecondSquared:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramMeterPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterPerKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CandelaPerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Lumen:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerTesla:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			AmpereTurnPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Weber:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Tesla:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			AmpereTurn:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramPerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KilogramPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerMole:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerMoleKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			HenryPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			FaradPerMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Radian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Watt:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case	
			WattPerSteradian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			WattPerSquareMeterSteradian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			WattPerSquareMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Pascal:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Ohm:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			Steradian:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerKilogram:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerKilogramKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerKilogramKelvinPerPascal:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerKilogramKelvinPerCubicMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MoleKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			WattPerMeterKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		// case SquareMeterPerSecond: duplicated
		case 
			SquareMeterKelvinPerWatt:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			KelvinPerWatt:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			MeterKelvinPerWatt:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			NewtonPerKilogram:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			SecondTimeSquared:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			NewtonMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CubicMeter:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CubicMeterPerKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			CubicMeterPerSecond:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		case 
			JoulePerCubicMeterKelvin:
				return new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0); //CHANGE. THIS IS NOT CORRECT
		default: 
			return new Unit();
		}
	}
	
	public DerivedUnits toDerivedUnits(Unit u){
		
		if (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0).equals(u)) 
			return DerivedUnits.Gray;
		if (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0).equals(u))  
			return DerivedUnits.GrayPerSecond; 
		if (new Unit(BaseUnits.Second,-1.0).equals(u))  					 
			return DerivedUnits.Becquerel;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) 	 
			return DerivedUnits.MolePerCubicMeter;
// THIS IS WORK IN PROGRESS. 
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Kilogram,-1.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MolePerKilogram;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Second,-2.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.RadianPerSecondSquared;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramMeterSquared;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JouleSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.RadianPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeterSteradian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeterKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeterPerKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Farad;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Katal;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.WattPerSquareMeterKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramPerCubicMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Sievert;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.PascalSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Coulomb;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombPerCubicMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombPerMole;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.AmperePerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.AmperePerRadian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.VoltPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombPerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Siemens;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Volt;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerCubicMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Joule;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CoulombPerKilogram;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Newton;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.NewtonPerCoulomb;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.NewtonPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Hertz;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CubicMeterPerKilogramSecondSquared;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerKelvin;
		// Watt; duplicated
		// WattPerSquareMeter; duplicated
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Lux;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Henry;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.PerMole;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterPerFarad;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeterPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterKilogram;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterPerSecondSquared;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramMeterPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterPerKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CandelaPerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Lumen;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerTesla;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.AmpereTurnPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Weber;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Tesla;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.AmpereTurn;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramPerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KilogramPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerMole;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerMoleKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.HenryPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.FaradPerMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Radian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Watt;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.WattPerSteradian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.WattPerSquareMeterSteradian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.WattPerSquareMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Pascal;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Ohm;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.Steradian;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerKilogram;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerKilogramKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerKilogramKelvinPerPascal;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerKilogramKelvinPerCubicMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MoleKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.WattPerMeterKelvin;
		// SquareMeterPerSecond; duplicated
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SquareMeterKelvinPerWatt;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.KelvinPerWatt;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.MeterKelvinPerWatt;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.NewtonPerKilogram;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.SecondTimeSquared;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.NewtonMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CubicMeter;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CubicMeterPerKelvin;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.CubicMeterPerSecond;
		if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u)) //NEEDS TO BE CHANGED 	 
			return DerivedUnits.JoulePerCubicMeterKelvin;
		return null;
	}

	public boolean isDerivedUnits(Unit u){

		return (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0).equals(u)) 
			|| (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0).equals(u))
			|| (new Unit(BaseUnits.Second,-1.0).equals(u))
			|| (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u))

			//WORK IN PROGRESS and  has to be done for all Derived Units
			;
	}
	

}
