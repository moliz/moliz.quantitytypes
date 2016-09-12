package org.modelexecution.quantitytypes.java;

public class PowerPerAngle extends Quantity {
	static protected boolean checkUnit(Unit u) {
		int r = BaseUnits.Radian.ordinal();
		int k = BaseUnits.Kilogram.ordinal();
		int s = BaseUnits.Second.ordinal();
		int m = BaseUnits.Meter.ordinal();
		if (u.dimensions[s]!=-3.0) return false;
		if (u.dimensions[k]!=1.0) return false;
		if (u.dimensions[r]!=-2.0) return false;
		if (u.dimensions[m]!=2.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=m)&&(i!=s)&&(i!=k)&&(i!=r)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}

	public PowerPerAngle(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a PowerPerAngle");
    	this.unit = new Unit (q.unit);
    }

}
