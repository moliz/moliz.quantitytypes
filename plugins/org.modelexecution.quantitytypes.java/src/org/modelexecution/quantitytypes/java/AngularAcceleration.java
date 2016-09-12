package org.modelexecution.quantitytypes.java;

public class AngularAcceleration extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Radian.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=1.0) return false;
		if (u.dimensions[s]!=-2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public AngularAcceleration(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a AngularAcceleration");
    	this.unit = new Unit (q.unit);
    }

}
