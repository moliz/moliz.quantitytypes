package org.modelexecution.quantitytypes.java;

public class Volume extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=3.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public Volume(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a Volume");
    	this.unit = new Unit (q.unit);
    }

}
