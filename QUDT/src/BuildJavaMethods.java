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

public class BuildJavaMethods {
	
	
	public static void main(String[] args) throws IOException {
	
		List<Map<String, double[]>> qudt = loadQuantityUnitsFromCVS();
		
		System.out.println("There we go");
		
//		MultAndDiv(qudt);
		
		InvAndSqrt(qudt);
		
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
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
		
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
						output.write(qu1Name+".divideBy("+qu2Name+") returns "+resultantQUName+"\t=>\t");
						output.write(printTuple(tuple1));
						output.write(" * ");
						output.write(printTuple(tuple2));
						output.write(" = ");
						output.write(result+"\n");
					}
				}
			}	
		}
		output.close();
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
