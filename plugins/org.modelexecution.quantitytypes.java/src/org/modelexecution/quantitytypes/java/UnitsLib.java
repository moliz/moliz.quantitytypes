
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
		case RadianPerSecondSquared:
				return new Unit(BaseUnits.Second,-2.0); //BaseUnits.Radian,1.0,
		case KilogramMeterSquared:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0); 
		case JouleSecond:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
		case RadianPerSecond:
				return new Unit(BaseUnits.Second,-1.0); //BaseUnits.Radian,1.0,
		case SquareMeter:
				return new Unit(BaseUnits.Meter,2.0); 
		case SquareMeterSteradian:
				return new Unit(BaseUnits.Meter,2.0); //BaseUnits.Radian,1.0,
		case SquareMeterKelvin:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0); 
		case 
			SquareMeterPerKelvin:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0); 
		case 
			Farad:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0); 
		case 
			Katal:
				return new Unit(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0); 
		case 
			WattPerSquareMeterKelvin:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0); 
		case 
			KilogramPerCubicMeter:
				return new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0); 
		case 
			Sievert:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0); 
		case 
			PascalSecond:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
		case 
			Coulomb:
				return new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
		case 
			CoulombPerMeter:
				return new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0); 
		case 
			CoulombPerCubicMeter:
				return new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0); 
		case 
			CoulombPerMole:
				return new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0); 
		case 
			AmperePerSquareMeter:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0); 
		case 
			AmperePerRadian:
				return new Unit(BaseUnits.Ampere,1.0); //BaseUnits.Radian,-1.0
		case 
			CoulombMeter:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
		case 
			VoltPerMeter:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0); 
		case 
			CoulombPerSquareMeter:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
		case 
			Siemens:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0); 
		case 
			Volt:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0); 
		case 
			JoulePerCubicMeter:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			Joule:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			JoulePerSquareMeter:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			CoulombPerKilogram:
				return new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0); 
		case 
			Newton:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
		case 
			NewtonPerCoulomb:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0); 
		case 
			NewtonPerMeter:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			Hertz:
				return new Unit(BaseUnits.Second,-1.0); 
		case 
			CubicMeterPerKilogramSecondSquared:
				return new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0); 
		case 
			JoulePerKelvin:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
		// case Watt: duplicated
		// case WattPerSquareMeter: duplicated
		case 
			Lux:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0); //BaseUnits.Radian,1.0,
		case 
			Henry:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0); 
		case 
			PerMole:
				return new Unit(BaseUnits.Mole,-1.0); 
		case 
			MeterPerFarad:
				return new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0); 
		case 
			SquareMeterPerSecond:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0); 
		case 
			MeterKilogram:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0); 
		case 
			MeterKelvin:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0); 
		case 
			MeterPerSecondSquared:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
		case 
			KilogramMeterPerSecond:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
		case 
			MeterPerKelvin:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0); 
		case 
			MeterPerSecond:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0); 
		case 
			CandelaPerSquareMeter:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0); 
		case 
			Lumen:
				return new Unit(BaseUnits.Candela,1.0); //BaseUnits.Radian,1.0,
		case 
			JoulePerTesla:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0); 
		case 
			AmpereTurnPerMeter:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0); 
		case 
			Weber:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0); 
		case 
			Tesla:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0); 
		case 
			AmpereTurn:
				return new Unit(BaseUnits.Ampere,1.0); //BaseUnits.Radian,1.0
		case 
			KilogramKelvin:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0); 
		case 
			KilogramPerSecond:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0); 
		case 
			KilogramPerSquareMeter:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0); 
		case 
			KilogramPerMeter:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0); 
		case 
			JoulePerMole:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0); 
		case 
			JoulePerMoleKelvin:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0); 
		case 
			HenryPerMeter:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0); 
		case 
			FaradPerMeter:
				return new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0); 
		case 
			Radian:
				return new Unit(); //BaseUnits.Radian,1.0
		case 
			Watt:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); 
		case	
			WattPerSteradian:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); //BaseUnits.Radian,-1.0,
		case 
			WattPerSquareMeterSteradian:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); //BaseUnits.Radian,-1.0,
		case 
			WattPerSquareMeter:
				return new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0); 
		case 
			Pascal:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			Ohm:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0); 
		case 
			Steradian:
				return new Unit(); //BaseUnits.Radian,1.0
		case 
			JoulePerKilogram:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0); 
		case 
			JoulePerKilogramKelvin:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
		case 
			JoulePerKilogramKelvinPerPascal:
				return new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0); 
		case 
			JoulePerKilogramKelvinPerCubicMeter:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
		case 
			MoleKelvin:
				return new Unit(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0); 
		case 
			WattPerMeterKelvin:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0); 
		// case SquareMeterPerSecond: duplicated
		case 
			SquareMeterKelvinPerWatt:
				return new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
		case 
			KelvinPerWatt:
				return new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
		case 
			MeterKelvinPerWatt:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0); 
		case 
			NewtonPerKilogram:
				return new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0); 
		case 
			SecondTimeSquared:
				return new Unit(BaseUnits.Second,2.0); 
		case 
			NewtonMeter:
				return new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0); 
		case 
			CubicMeter:
				return new Unit(BaseUnits.Meter,3.0); 
		case 
			CubicMeterPerKelvin:
				return new Unit(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0); 
		case 
			CubicMeterPerSecond:
				return new Unit(BaseUnits.Meter,3,BaseUnits.Second,-1.0); 
		case 
			JoulePerCubicMeterKelvin:
				return new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0); 
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
if (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u))
	return DerivedUnits.MolePerKilogram;
if (new Unit(BaseUnits.Second,-2.0).equals(u))  //BaseUnits.Radian,1.0,
	return DerivedUnits.RadianPerSecondSquared;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0).equals(u))
	return DerivedUnits.KilogramMeterSquared;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.JouleSecond;
if (new Unit(BaseUnits.Second,-1.0).equals(u))  //BaseUnits.Radian,1.0,
	return DerivedUnits.RadianPerSecond;
if (new Unit(BaseUnits.Meter,2.0).equals(u))
	return DerivedUnits.SquareMeter;
if (new Unit(BaseUnits.Meter,2.0).equals(u)) //BaseUnits.Radian,1.0,
	return DerivedUnits.SquareMeterSteradian;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.SquareMeterKelvin;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.SquareMeterPerKelvin;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(u))
	return DerivedUnits.Farad;
if (new Unit(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0).equals(u))
	return DerivedUnits.Katal;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.WattPerSquareMeterKelvin;
if (new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0).equals(u))
	return DerivedUnits.KilogramPerCubicMeter;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.Sievert;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.PascalSecond;
if (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.Coulomb;
if (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0).equals(u))
	return DerivedUnits.CoulombPerMeter;
if (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0).equals(u))
	return DerivedUnits.CoulombPerCubicMeter;
if (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0).equals(u))
	return DerivedUnits.CoulombPerMole;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.AmperePerSquareMeter;
if (new Unit(BaseUnits.Ampere,1.0).equals(u)) //BaseUnits.Radian,-1.0
	return DerivedUnits.AmperePerRadian;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.CoulombMeter;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(u))
	return DerivedUnits.VoltPerMeter;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.CoulombPerSquareMeter;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0).equals(u))
	return DerivedUnits.Siemens;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.Volt;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.JoulePerCubicMeter;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.Joule;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.JoulePerSquareMeter;
if (new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.CoulombPerKilogram;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.Newton;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(u))
	return DerivedUnits.NewtonPerCoulomb;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.NewtonPerMeter;
if (new Unit(BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.Hertz;
if (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.CubicMeterPerKilogramSecondSquared;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.JoulePerKelvin;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(u)) //BaseUnits.Radian,1.0,
	return DerivedUnits.Lux;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(u))
	return DerivedUnits.Henry;
if (new Unit(BaseUnits.Mole,-1.0).equals(u))
	return DerivedUnits.PerMole;
if (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0).equals(u))
	return DerivedUnits.MeterPerFarad;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.SquareMeterPerSecond;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0).equals(u))
	return DerivedUnits.MeterKilogram;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.MeterKelvin;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.MeterPerSecondSquared;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.KilogramMeterPerSecond;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.MeterPerKelvin;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.MeterPerSecond;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(u))
	return DerivedUnits.CandelaPerSquareMeter;
if (new Unit(BaseUnits.Candela,1.0).equals(u)) //BaseUnits.Radian,1.0,
	return DerivedUnits.Lumen;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.JoulePerTesla;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0).equals(u))
	return DerivedUnits.AmpereTurnPerMeter;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(u))
	return DerivedUnits.Weber;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(u))
	return DerivedUnits.Tesla;
if (new Unit(BaseUnits.Ampere,1.0).equals(u)) //,BaseUnits.Radian,1.0
	return DerivedUnits.AmpereTurn;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.KilogramKelvin;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.KilogramPerSecond;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0).equals(u))
	return DerivedUnits.KilogramPerSquareMeter;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0).equals(u))
	return DerivedUnits.KilogramPerMeter;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0).equals(u))
	return DerivedUnits.JoulePerMole;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0).equals(u))
	return DerivedUnits.JoulePerMoleKelvin;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(u))
	return DerivedUnits.HenryPerMeter;
if (new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(u))
	return DerivedUnits.FaradPerMeter;
if (new Unit().equals(u)) //BaseUnits.Radian,1.0
	return DerivedUnits.Radian;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))
	return DerivedUnits.Watt;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))//BaseUnits.Radian,-1.0,
	return DerivedUnits.WattPerSteradian;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))//BaseUnits.Radian,-1.0,
	return DerivedUnits.WattPerSquareMeterSteradian;
if (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))
	return DerivedUnits.WattPerSquareMeter;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.Pascal;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0).equals(u))
	return DerivedUnits.Ohm;
if (new Unit().equals(u))//BaseUnits.Radian,1.0
	return DerivedUnits.Steradian;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.JoulePerKilogram;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.JoulePerKilogramKelvin;
if (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.JoulePerKilogramKelvinPerPascal;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.JoulePerKilogramKelvinPerCubicMeter;
if (new Unit(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0).equals(u))
	return DerivedUnits.MoleKelvin;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.WattPerMeterKelvin;
if (new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.SquareMeterKelvinPerWatt;
if (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.KelvinPerWatt;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
	return DerivedUnits.MeterKelvinPerWatt;
if (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.NewtonPerKilogram;
if (new Unit(BaseUnits.Second,2.0).equals(u))
	return DerivedUnits.SecondTimeSquared;
if (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
	return DerivedUnits.NewtonMeter;
if (new Unit(BaseUnits.Meter,3.0).equals(u))
	return DerivedUnits.CubicMeter;
if (new Unit(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.CubicMeterPerKelvin;
if (new Unit(BaseUnits.Meter,3,BaseUnits.Second,-1.0).equals(u))
	return DerivedUnits.CubicMeterPerSecond;
if (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
	return DerivedUnits.JoulePerCubicMeterKelvin;
return null;
	}

	public boolean isDerivedUnits(Unit u){

		return (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-2.0).equals(u)) 
            || (new Unit(BaseUnits.Meter,2.0, BaseUnits.Second,-3.0).equals(u))
            || (new Unit(BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u))
            || (new Unit(BaseUnits.Mole,1.0, BaseUnits.Meter,-3.0).equals(u))
            || (new Unit(BaseUnits.Second,-2.0).equals(u)) //BaseUnits.Radian,1.0,
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Second,-1.0).equals(u)) //BaseUnits.Radian,1.0,
            || (new Unit(BaseUnits.Meter,2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0).equals(u)) //BaseUnits.Radian,1.0,
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(u))
            || (new Unit(BaseUnits.Second,-1.0,BaseUnits.Mole,1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-1.0).equals(u))
            || (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Meter,-3.0).equals(u))
            || (new Unit(BaseUnits.Second,1.0,BaseUnits.Ampere,1.0,BaseUnits.Mole,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Ampere,1.0).equals(u)) //,BaseUnits.Radian,-1.0
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Ampere,2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,1.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(u)) //BaseUnits.Radian,1.0,
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(u))
            || (new Unit(BaseUnits.Mole,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,1.0,BaseUnits.Second,-4,BaseUnits.Ampere,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Candela,1.0).equals(u))
            || (new Unit(BaseUnits.Candela,1.0).equals(u)) //BaseUnits.Radian,1.0,
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Ampere,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-1.0).equals(u))
            || (new Unit(BaseUnits.Ampere,1.0).equals(u)) //,BaseUnits.Radian,1.0
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-2.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Meter,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Mole,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0,BaseUnits.Mole,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Ampere,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,-3.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,4.0,BaseUnits.Ampere,2.0).equals(u))
            //|| (new Unit(BaseUnits.Radian,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u)) //BaseUnits.Radian,-1.0,
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u)) //BaseUnits.Radian,-1.0,
            || (new Unit(BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Ampere,-2.0).equals(u))
            //|| (new Unit(BaseUnits.Radian,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,3,BaseUnits.Kilogram,-1.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Kelvin,1.0,BaseUnits.Mole,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-3.0,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-2.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,-1.0,BaseUnits.Second,3,BaseUnits.Kelvin,1.0).equals(u))
            || (new Unit(BaseUnits.Meter,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Second,2.0).equals(u))
            || (new Unit(BaseUnits.Meter,2.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0).equals(u))
            || (new Unit(BaseUnits.Meter,3.0).equals(u))
            || (new Unit(BaseUnits.Meter,3,BaseUnits.Kelvin,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,3,BaseUnits.Second,-1.0).equals(u))
            || (new Unit(BaseUnits.Meter,-1.0,BaseUnits.Kilogram,1.0,BaseUnits.Second,-2.0,BaseUnits.Kelvin,-1.0).equals(u))
			;
	}
	

}
