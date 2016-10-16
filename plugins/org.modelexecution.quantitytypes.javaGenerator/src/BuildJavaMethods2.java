import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BuildJavaMethods2 {
	
	
	public static void main(String[] args) throws IOException {
	
		List<Map<String, double[]>> qudt = loadQuantityUnitsFromCVS();
		
		System.out.println("There we go");
				
		generateFiles(qudt);
		
	}

	private static void generateFiles(List<Map<String, double[]>> qudt) {
		
		
		
//		MultAndDiv(qudt);	
//		InvAndSqrt(qudt);
		
	}
	
	private static void generateFile(){
		
		/*
		 
package org.modelexecution.quantitytypes.java;

import java.util.Arrays;

// Esta plantilla es solo para DerivedUnits.
//
//   Parameters: %%Dimension%% -- nombre de la dimension, y por tanto de la clase Java. Corresponde a una de los literales definidos en DerivedDimensions.java
//               %%Unit%% -- nombre de la unidad (En DerivedUnits.java)
//               %%Product%% -- parametro de la operacion mult()
//               %%MultResult%% -- resultado de la operacion mult()
//               %%Dividend%% -- parametro de la operacion divideBy()
//               %%DivResult%% -- resultado de la operacion divideBy()
//               %%SQRTDimension%% -- resultado de la operacion sqrt() [si tiene sentido]
//               %%INVDimension%% -- resultado de la operacion inverse() [si tiene sentido]
//
//En la operacion checkUnit() tambien hay parametros como %%BaseUnit1%%, %%BaseUnit2%%, ... y %%Base1Exponent%%, %%Base2Exponent%%,... 


public class %%Dimension%% extends Quantity {

	static protected boolean checkUnit(Unit u) {
		double [] x = new double [BaseUnits.values().length];
		Arrays.fill(x, 0.0);
		x[BaseUnits.%%BaseUnit1%%.ordinal()]=%%Base1Exponent%%;
		x[BaseUnits.%%BaseUnit2%%.ordinal()]=%%Base2Exponent%%;
		x[BaseUnits.%%BaseUnit3%%.ordinal()]=%%Base3Exponent%%;
		return Arrays.equals(x,u.dimensions);
	}

	public %%Dimension%%(Quantity q){
    	value = q.value.clone();
    	if (!checkUnit(q.unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (q.unit);
    }
    public %%Dimension%% () {
        value = new UReal();
        unit = new Unit(DerivedUnits.%%Unit%%);
    }

    public %%Dimension%%(UReal u){
    	value = u.clone();
        unit = new Unit(DerivedUnits.%%Unit%%);
    }

    public %%Dimension%%(UReal u, Unit unit){
    	value = u.clone();
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating an %%Dimension%%");
    	this.unit = new Unit (unit);
    }

	public %%Dimension%%(double x){ //"promotes" a real x 
		value = new UReal(x);
        unit = new Unit(DerivedUnits.%%Unit%%);
	}
  
    public %%Dimension%% (double x, double u) {
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
    
    public %%Dimension%%(double x, Unit unit){ //we only allow the same Units
    	value = new UReal(x);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
   }

    public %%Dimension%%(double x, double u, Unit unit){
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
    }

    public %%Dimension%%(String x) { //creates a %%Dimension%% from a string representing a real, with u=0.
    	value = new UReal(x);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
    
    public %%Dimension%%(String x, String u) { //creates a %%Dimension%% from two strings representing (x,u).
    	value = new UReal(x,u);
        unit = new Unit(DerivedUnits.%%Unit%%);
   }
   
    public %%Dimension%%(String x, String u, Unit unit) { //creates a %%Dimension%% from two strings representing (x,u).
    	value = new UReal(x,u);
    	if (!checkUnit(unit)) throw new RuntimeException("Invalid Unit for creating a %%Dimension%%");
    	this.unit = new Unit (unit);
   }

	
//	  Specific Type Operations
     
	public %%Dimension%% add(%%Dimension%% r) {  //only works if compatible units && operand has no offset
		
		return new %%Dimension%%(super.add(r));
	}
	
	public %%Dimension%% minus(%%Dimension%% r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)

		return new %%Dimension%%(super.minus(r));
	}

	// One per valid mult operand 

    public %%MultResult%% mult(%%Product%% r) { //both values and units are multiplied. No offsets allowed in any of the units
		return new AbsorbedDoseRate(super.mult(r));
	}
	
    // One per valid div operand 
	public %%DivResult%% divideBy(%%Dividend%% r) { //both values and units are divided. No offsets allowed in any of the units
		return new TimeSquared(super.divideBy(r));
	}

// in case inverse() returns a valid dimension -- otherwise just leave it commented.

   public %%INVDimension%% inverse() {
       return new  %%INVDimension%%(super.inverse());
   }

//in case sqrt() returns a valid dimension -- otherwise just leave it commented.

   public %%SQRTDimension%% sqrt() {
       return new  %%SQRTDimension%%(super.sqrt());
   }

	
	// OTHER OPERATIONS
	
	
	public %%Dimension%% abs() { //units are maintained
		return new %%Dimension%%(super.abs());
	}
	
	public %%Dimension%% neg() { //units are maintained
		return new %%Dimension%%(super.neg());
	}

    // power(s), and inverse() return Quantity
	// lessThan, LessEq, gt, ge all directly from Quantity

	public boolean equals(%%Dimension%% r) {  
		return  r.compatibleUnits(this) && 
				this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());
	}

	public boolean distinct(%%Dimension%% r) {  
		return !(this.equals(r));
	}
	
	public %%Dimension%% floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained
		return new %%Dimension%%(Math.floor(this.getX()),this.getU(),this.getUnits());
	}
	public %%Dimension%% round(){ //returns (i,u) with i the closest int to x -- units maintained
		return new %%Dimension%%(Math.round(this.getX()),this.getU(),this.getUnits());
	}
	public %%Dimension%% min(%%Dimension%% r) { // units maintained
		if (r.lessThan(this)) return new %%Dimension%%(r.getX(),r.getU(),r.getUnits()); 
		return new %%Dimension%%(this.getX(),this.getU(),this.getUnits());
	}
	public %%Dimension%% max(%%Dimension%% r) { // unit maintained
		//if (r>this) r; else this;
		if (r.gt(this)) return new %%Dimension%%(r.getX(),r.getU(),r.getUnits());
		return new %%Dimension%%(this.getX(),this.getU(),this.getUnits());
	}

	
	//  working with constants (note that add and minus do not work here
	

	public %%Dimension%% mult(double r) {  
		return new %%Dimension%%(this.value.mult(new UReal(r)),this.getUnits());
	}
	
	public %%Dimension%% divideBy(double r) {  
		return new %%Dimension%%(this.value.divideBy(new UReal(r)),this.getUnits());
	}

	public %%Dimension%% mult(UReal r) {  
		return new %%Dimension%%(this.value.mult(r),this.getUnits());
	}
	
	public %%Dimension%% divideBy(UReal r) {  
		return new %%Dimension%%(this.value.divideBy(r),this.getUnits());
	}

	// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity
	
 	public int hashcode(){ //required for equals()
		return Math.round((float)value.getX());
	}

 	public %%Dimension%% clone() {
		return new %%Dimension%%(this.getUReal(),this.getUnits());
	}


}

		  
		  
		 */
		
	}

	private static void InvAndSqrt(List<Map<String, double[]>> qudt) throws IOException {
		
		File file = new File("resultsSqrt.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
		
		for (int i=0; i<qudt.size(); i++){
			
			Map<String, double[]> qu1 = qudt.get(i);
			String qu1Name =  qu1.keySet().iterator().next();
			double[] tuple1 = qu1.values().iterator().next();
			
//			double[] result = inv(tuple1);
			double[] result = sqrt(tuple1);
			
			String resultantQUName = exists(result, qudt);
			
			if (!resultantQUName.equals("")){
//				System.out.print(qu1Name+".inv() returns "+resultantQUName);
//				System.out.print("\t=>\t inv ");
//				printTuple(tuple1);
//				System.out.print(" = ");
//				printTuple(result);
//				System.out.println("");
				
				output.write(qu1Name+".sqrt() returns "+resultantQUName+"\t=>\t sqrt ");
				output.write(printTuple(tuple1));
				output.write(" = ");
				output.write(printTuple(result)+"\n");
			}
		}
		output.close();
	}

	private static void MultAndDiv(List<Map<String, double[]>> qudt) throws IOException {
		
		File file = new File("resultsDiv.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		for (int i=0; i<qudt.size(); i++){
			
			Map<String, double[]> qu1 = qudt.get(i);
			String qu1Name =  qu1.keySet().iterator().next();
			double[] tuple1 = qu1.values().iterator().next();
			
			for (int j=0; j<qudt.size(); j++){
				if (i!=j){
					
					Map<String, double[]> qu2 = qudt.get(j);
					String qu2Name =  qu2.keySet().iterator().next();
					double[] tuple2 = qu2.values().iterator().next();
					
//					double[] result = mult(tuple1, tuple2);
					double[] result = divideBy(tuple1, tuple2);
					
					String resultantQUName = exists(result, qudt);
					
					if (!resultantQUName.equals("")){
//						System.out.print(qu1Name+".mult("+qu2Name+") returns "+resultantQUName+"\t=>\t");
//						printTuple(tuple1);
//						System.out.print(" * ");
//						printTuple(tuple2);
//						System.out.print(" = ");
//						printTuple(result);
//						System.out.println("");
						bw.write(qu1Name+".divideBy("+qu2Name+") returns "+resultantQUName+"\t=>\t");
						bw.write(printTuple(tuple1));
						bw.write(" * ");
						bw.write(printTuple(tuple2));
						bw.write(" = ");
						bw.write(result+"\n");
					}
				}
			}	
		}
		bw.close();
	}

	private static String exists(double[] result, List<Map<String, double[]>> qudt) {
		
		for (int i=0; i<qudt.size(); i++){
				Map<String, double[]> qui = qudt.get(i);
				double[] tuple1 = qui.values().iterator().next();
				boolean equal = equalTuple(tuple1, result);
				if (equal){
					return qui.keySet().iterator().next();
				}
		}
		return "";
	}

	private static boolean equalTuple(double[] tuple1, double[] result) {
		
		boolean equal = true;
		int i=0;
		while (!false && i<8){
			if (tuple1[i]!=result[i]){
				equal=false;
			}
			i++;
		}
		
		return equal;
	}

	private static double[] mult(double[] tuple1, double[] tuple2) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i] + tuple2[i];
		}
		return result;
	}
	
	private static double[] divideBy(double[] tuple1, double[] tuple2) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i] - tuple2[i];
		}
		return result;
	}
	
	
	private static double[] inv(double[] tuple1) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = 0.0 - tuple1[i];
		}
		return result;
	}
	
	
	private static double[] sqrt(double[] tuple1) {
		double[] result = new double[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i]/2;
		}
		return result;
	}

	
	private static List<Map<String, double[]>> loadQuantityUnitsFromCVS() throws IOException {
		
		List<Map<String, double[]>> qudt = new LinkedList<Map<String, double[]>>();
		
		BufferedReader br = new BufferedReader(new FileReader("QUDT.csv"));  
		String line = br.readLine(); //ignore the first line
		line = br.readLine();
		while (line != null) {
			
			StringTokenizer st = new StringTokenizer(line, ",");
			String quantityKind = st.nextToken();
			st.nextToken(); // QName
			String dimensionSymbol = st.nextToken();
			double[] tuple = obtainTuple(dimensionSymbol);
			
//			System.out.print("\n" + quantityKind + " " + dimensionSymbol + " ");
//			printTuple(tuple);

			Map<String, double[]> myMap = new HashMap<String, double[]>();
			myMap.put(quantityKind, tuple);
			qudt.add(myMap);
			
			line = br.readLine();
		}
		br.close();
		return qudt;
	}

	
	private static double[] obtainTuple(String dimensionSymbol) {
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

	private static boolean isPositive(String dimensionSymbol, int i) {
		boolean positive = true;
		if (dimensionSymbol.charAt(i+1)=='-'){
			positive = false;
		}
		return positive;
	}

	private static String printTuple(double[] tuple) {
		String s = "[";
		for (int i=0; i<tuple.length-1; i++){
			s+= tuple[i]+", ";
		}
		s+=tuple[tuple.length-1] + "]";
		return s;
	}
	
	
}
