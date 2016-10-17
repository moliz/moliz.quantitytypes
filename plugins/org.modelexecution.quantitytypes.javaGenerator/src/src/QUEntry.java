import java.util.Arrays;

public class QUEntry {

	String quantityKind;
	String dimensionSymbol;
	String unit;
	double[] tuple;
	
	public QUEntry(String quantityKind, String dimensionSymbol, String unit) {
		this.quantityKind = quantityKind; 
		this.dimensionSymbol = dimensionSymbol;
		this.unit = unit;
		tuple = obtainTuple(dimensionSymbol);
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQuantityKind() {
		return quantityKind;
	}

	public void setQuantityKind(String quantityKind) {
		this.quantityKind = quantityKind;
	}

	public String getDimensionSymbol() {
		return dimensionSymbol;
	}

	public void setDimensionSymbol(String dimensionSymbol) {
		this.dimensionSymbol = dimensionSymbol;
	}

	public double[] getTuple() {
		return tuple;
	}

	public void setTuple(double[] tuple) {
		this.tuple = tuple;
	}

	public double[] obtainTuple(String dimensionSymbol) {
		double[] tuple = new double[8]; // <L, M, T, I, O, N, U, J>
		for (int i=0; i<tuple.length; i++){
			tuple[i] = 0.0;
		}
		int size = dimensionSymbol.length();
		int i = 0;
		while (i<size){
			boolean positive = isPositive(dimensionSymbol, i);
			
			if (dimensionSymbol.charAt(i) == 'L' && positive){
				tuple[0] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'L' && !positive){
				tuple[0] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'M' && positive){
				tuple[1] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'M' && !positive){
				tuple[1] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'T' && positive){
				tuple[2] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'T' && !positive){
				tuple[2] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'I' && positive){
				tuple[3] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'I' && !positive){
				tuple[3] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'O' && positive){
				tuple[4] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'O' && !positive){
				tuple[4] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'N' && positive){
				tuple[5] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'N' && !positive){
				tuple[5] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'U' && positive){
				tuple[6] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'U' && !positive){
				tuple[6] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'J' && positive){
				tuple[7] = Double.parseDouble(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'J' && !positive){
				tuple[7] = 0 - Double.parseDouble(dimensionSymbol.charAt(i+2)+"");
			}
			
			i=i+2;
			if (!positive){
				i++;
			}
		}
		return tuple;
	}

	public boolean isPositive(String dimensionSymbol, int i) {
		boolean positive = true;
		if (dimensionSymbol.charAt(i+1)=='-'){
			positive = false;
		}
		return positive;
	}
	
	public double[] mult(double[] tuple2) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple[i] + tuple2[i];
		}
		return result;
	}
	
	public double[] divideBy(double[] tuple2) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple[i] - tuple2[i];
		}
		return result;
	}
	
	public double[] sqrt() {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple[i]/2;
		}
		return result;
	}
	
	public double[] inv() {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = 0.0 - tuple[i];
		}
		return result;
	}

	public String printTuple() {
		String s = "[";
		for (int i=0; i<tuple.length-1; i++){
			s+= tuple[i]+", ";
		}
		s+=tuple[tuple.length-1] + "]";
		return s;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QUEntry other = (QUEntry) obj;
		if (!Arrays.equals(tuple, other.tuple))
			return false;
		return true;
	}
	
	
}
