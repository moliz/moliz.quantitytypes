package org.modelexecution.quantitytypes.java;

public class MagneticFlux extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		int k = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=-1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		if (u.dimensions[m]!=1.0) return false;
		if (u.dimensions[k]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((k!=i)&&(i!=l)&&(i!=s)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public MagneticFlux(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a MagneticFlux");
    	this.unit = new Unit (q.unit);
    }

}
