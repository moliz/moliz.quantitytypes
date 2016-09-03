package org.modelexecution.quantitytypes.java;

public class Area extends Quantity {

	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    public Area(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating an Area");
    	this.unit = new Unit (q.unit);
    }

}
