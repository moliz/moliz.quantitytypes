package org.modelexecution.quantitytypes.java;

public class ThermodynamicTemperature extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Kelvin.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public ThermodynamicTemperature(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a ThermodynamicTemperature");
    	this.unit = new Unit (q.unit);
    }

}
