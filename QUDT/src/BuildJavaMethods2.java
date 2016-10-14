import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BuildJavaMethods2 {
	
	
	public static void main(String[] args) throws IOException {
	
		List<Map<String, Integer[]>> qudt = loadQuantityUnitsFromCVS();
		
		MultAndDiv(qudt);
//		InvAndSqrt(qudt);
		
	}

	private static void InvAndSqrt(List<Map<String, Integer[]>> qudt) {
		for (int i=0; i<qudt.size(); i++){
			
			Map<String, Integer[]> qu1 = qudt.get(i);
			String qu1Name =  qu1.keySet().iterator().next();
			Integer[] tuple1 = qu1.values().iterator().next();
			
			Integer[] result = inv(tuple1);
//			Integer[] result = sqrt(tuple1);
			
			String resultantQUName = exists(result, qudt);
			
			if (!resultantQUName.equals("")){
				System.out.print(qu1Name+".inv() returns "+resultantQUName);
				System.out.print("\t=>\t1 / ");
				printTuple(tuple1);
				System.out.print(" = ");
				printTuple(result);
				System.out.println("");
			}
		}
	}

	private static void MultAndDiv(List<Map<String, Integer[]>> qudt) {
		
		for (int i=0; i<qudt.size(); i++){
			
			Map<String, Integer[]> qu1 = qudt.get(i);
			String qu1Name =  qu1.keySet().iterator().next();
			Integer[] tuple1 = qu1.values().iterator().next();
			
			for (int j=0; j<qudt.size(); j++){
				if (i!=j){
					
					Map<String, Integer[]> qu2 = qudt.get(j);
					String qu2Name =  qu2.keySet().iterator().next();
					Integer[] tuple2 = qu2.values().iterator().next();
					
					Integer[] result = mult(tuple1, tuple2);
//					Integer[] result = divideBy(tuple1, tuple2);
					
					String resultantQUName = exists(result, qudt);
					
					if (!resultantQUName.equals("")){
						System.out.print(qu1Name+".mult("+qu2Name+") returns "+resultantQUName+"\t=>\t");
						printTuple(tuple1);
						System.out.print(" * ");
						printTuple(tuple2);
						System.out.print(" = ");
						printTuple(result);
						System.out.println("");
					}
				}
			}	
		}
	}

	private static String exists(Integer[] result, List<Map<String, Integer[]>> qudt) {
		
		for (int i=0; i<qudt.size(); i++){
				Map<String, Integer[]> qui = qudt.get(i);
				Integer[] tuple1 = qui.values().iterator().next();
				boolean equal = equalTuple(tuple1, result);
				if (equal){
					return qui.keySet().iterator().next();
				}
		}
		return "";
	}

	private static boolean equalTuple(Integer[] tuple1, Integer[] result) {
		
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

	private static Integer[] mult(Integer[] tuple1, Integer[] tuple2) {
		Integer[] result = new Integer[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i] + tuple2[i];
		}
		return result;
	}
	
	private static Integer[] divideBy(Integer[] tuple1, Integer[] tuple2) {
		Integer[] result = new Integer[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i] - tuple2[i];
		}
		return result;
	}
	
	
	private static Integer[] inv(Integer[] tuple1) {
		Integer[] result = new Integer[8];
		for (int i=0; i<8; i++){
			result[i] = 0 - tuple1[i];
		}
		return result;
	}
	
	
	private static Integer[] sqrt(Integer[] tuple1) {
		Integer[] result = new Integer[8];
		for (int i=0; i<8; i++){
			result[i] = tuple1[i]/2;
		}
		return result;
	}

	
	private static List<Map<String, Integer[]>> loadQuantityUnitsFromCVS() throws IOException {
		
		List<Map<String, Integer[]>> qudt = new LinkedList<Map<String, Integer[]>>();
		
		BufferedReader br = new BufferedReader(new FileReader("QUDT.csv"));  
		String line = br.readLine(); //ignore the first line
		line = br.readLine();
		while (line != null) {
			
			StringTokenizer st = new StringTokenizer(line, ",");
			String quantityKind = st.nextToken();
			st.nextToken(); // QName
			String dimensionSymbol = st.nextToken();
			Integer[] tuple = obtainTuple(dimensionSymbol);
			
//			System.out.print("\n" + quantityKind + " " + dimensionSymbol + " ");
//			printTuple(tuple);

			Map<String, Integer[]> myMap = new HashMap<String, Integer[]>();
			myMap.put(quantityKind, tuple);
			qudt.add(myMap);
			
			line = br.readLine();
		}
		br.close();
		return qudt;
	}

	
	private static Integer[] obtainTuple(String dimensionSymbol) {
		Integer[] tuple = new Integer[8]; // <L, M, T, I, O, N, U, J>
		for (int i=0; i<tuple.length; i++){
			tuple[i] = 0;
		}
		int size = dimensionSymbol.length();
		int i = 0;
		while (i<size){
			boolean positive = isPositive(dimensionSymbol, i);
			
			if (dimensionSymbol.charAt(i) == 'L' && positive){
				tuple[0] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'L' && !positive){
				tuple[0] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'M' && positive){
				tuple[1] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'M' && !positive){
				tuple[1] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'T' && positive){
				tuple[2] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'T' && !positive){
				tuple[2] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'I' && positive){
				tuple[3] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'I' && !positive){
				tuple[3] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'O' && positive){
				tuple[4] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'O' && !positive){
				tuple[4] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'N' && positive){
				tuple[5] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'N' && !positive){
				tuple[5] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'U' && positive){
				tuple[6] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'U' && !positive){
				tuple[6] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
			} else if (dimensionSymbol.charAt(i) == 'J' && positive){
				tuple[7] = Integer.parseInt(dimensionSymbol.charAt(i+1)+"");
			} else if (dimensionSymbol.charAt(i) == 'J' && !positive){
				tuple[7] = 0 - Integer.parseInt(dimensionSymbol.charAt(i+2)+"");
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

	private static void printTuple(Integer[] tuple) {
		System.out.print("[");
		for (int i=0; i<tuple.length; i++){
			System.out.print(tuple[i]+", ");
		}
		System.out.print("]  ");
	}
	
	
}
