package org.modelexecution.quantitytypes.java;

public class ElectricCurrentDensity extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Ampere.ordinal();
		int m = BaseUnits.Meter.ordinal();
		if (u.dimensions[m]!=-2.0) return false;
		if (u.dimensions[l]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=m)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ElectricCurrentDensity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ElectricCurrentDensity");
    	this.unit = new Unit (q.unit);
    }

}
