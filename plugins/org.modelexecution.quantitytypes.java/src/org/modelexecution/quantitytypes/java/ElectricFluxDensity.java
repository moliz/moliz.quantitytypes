package org.modelexecution.quantitytypes.java;

public class ElectricFluxDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[m]!=-2.0) return false;
		if (u.dimensions[s]!=1.0) return false;
		if (u.dimensions[l]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricFluxDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricFluxDensity");
    	this.unit = new Unit (q.unit);
    }

}
