package org.modelexecution.quantitytypes.java;

public class KinematicViscosity extends Quantity {

	static protected boolean checkUnit(Unit u) {
		int l = BaseUnits.Meter.ordinal();
		int s = BaseUnits.Second.ordinal();
		if (u.dimensions[l]!=2.0) return false;
		if (u.dimensions[s]!=-1.0) return false;
		for (int i=0;i<u.dimensions.length;i++) {
			if ((i!=l)&&(i!=s)&&(u.dimensions[i]!=0.0)) return false;
		}
		return true;
	}
    /**
     * Constructors 
     */
	public KinematicViscosity(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a LinearVelocity");
    	this.unit = new Unit (q.unit);
    }


}
