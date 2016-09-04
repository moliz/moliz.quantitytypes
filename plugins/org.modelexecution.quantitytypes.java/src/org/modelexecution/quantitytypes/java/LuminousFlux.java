package org.modelexecution.quantitytypes.java;

public class LuminousFlux extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int k = BaseUnits.Candela.ordinal();
		int s = BaseUnits.Radian.ordinal();
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[s]!=1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=k)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public LuminousFlux(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LuminousFlux");
    	this.unit = new Unit (q.unit);
    }

}
