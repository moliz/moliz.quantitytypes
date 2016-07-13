import java.util.Arrays;

public class Unit implements Cloneable {
	protected double [] dimensions = new double [BaseUnits.values().length];  
	// exponents for each dimension.  
	// [Radian, Meter, Kilogram, Second, Ampere, Kelvin, Mole, Candela]
	
	public Unit(){
		Arrays.fill(dimensions, 0.0); //dimensionless
	}

	public Unit(double [] u){
		this.dimensions = Arrays.copyOf(u, this.dimensions.length);
	}

	public Unit(BaseUnits d){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d.ordinal()] = 1.0;		
	}

	public Unit(BaseUnits d, double exp){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d.ordinal()] = exp;		
	}

	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
	}
	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
	}
	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
	}
	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
		dimensions[d5.ordinal()] = exp5;		
	}
	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5,BaseUnits d6, double exp6){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
		dimensions[d5.ordinal()] = exp5;		
		dimensions[d6.ordinal()] = exp6;
	}
	public Unit(BaseUnits d1, double exp1,BaseUnits d2, double exp2,BaseUnits d3, double exp3,BaseUnits d4, double exp4,BaseUnits d5, double exp5,BaseUnits d6, double exp6,BaseUnits d7, double exp7){
		Arrays.fill(dimensions, 0.0); 
		dimensions[d1.ordinal()] = exp1;		
		dimensions[d2.ordinal()] = exp2;		
		dimensions[d3.ordinal()] = exp3;		
		dimensions[d4.ordinal()] = exp4;		
		dimensions[d5.ordinal()] = exp5;		
		dimensions[d6.ordinal()] = exp6;
		dimensions[d7.ordinal()] = exp7;		
	}

	public Unit(Unit u){
		this.dimensions = Arrays.copyOf(u.dimensions, this.dimensions.length);
	}
	
	/************
	 * Other methods
	 * 
	 */
	
 	public int hashcode(){ //required for equals()
		double x=0.0;
 		for (int i=0;i<dimensions.length;i++) x+=dimensions[i]; 
 		return (int)Math.round(x);
	}

	public boolean equals(Unit u) {
		return Arrays.equals(this.dimensions, u.dimensions);
	}
	
	public boolean isBaseUnit(){
		int zeros = 0;
		int unos = 0;
		for (int i=0;i<dimensions.length;i++){
			if (dimensions[i]==0.0) zeros++;
			if (dimensions[i]==1.0) unos++;
		}
		return (zeros==dimensions.length-1) // all zeros (dimensionless) or all zeros but 1.
				&& (unos==1); //and one 1 or none
	}
	
	public boolean isDimensionless(){
		for (int i=0;i<dimensions.length;i++){
			if (dimensions[i]!=0.0) return false;
		}
		return true; //all exponents should be 0.0
	}
	
	public Unit clone(){
		return new Unit(this);
	}
	
	public Unit multiplyUnits (Unit x) {
		double [] result = new double [dimensions.length];
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] + x.dimensions[i]; //they are exponents
		}
		return new Unit(result);
	}

	public Unit divideUnits (Unit x) {
		double [] result = new double [dimensions.length];
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] - x.dimensions[i]; //they are exponents
		}
		return new Unit(result);
	}
	
	public Unit powerUnits (float s) {
		double [] result = new double [dimensions.length];  
		for (int i=0;i<this.dimensions.length;i++){
			result[i]=this.dimensions[i] * s; //they are exponents
		}
		return new Unit(result);
	}
	
	public String toString(){
			String s = "["+dimensions[0];
			for (int i=1;i<this.dimensions.length;i++){
				s+=","+this.dimensions[i]; 
			}
			return s+"]";
	}
	
	

}
