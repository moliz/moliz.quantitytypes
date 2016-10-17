import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BuildJavaMethods {
	
	
	public static void main(String[] args) throws IOException {
	
		List<QUEntry> qudt = loadQuantityUnitsFromCVS();
				
		generateFiles(qudt);
		
		System.out.println("Done");
		
	}

	private static void generateFiles(List<QUEntry> qudt) throws IOException {
		
		for (int i=0; i<qudt.size(); i++){
			
			generateFile(qudt, i);
		
		}
		
	}
	
	private static void generateFile(List<QUEntry> qudt, int i) throws IOException{
		
		QUEntry qu = qudt.get(i);
		
		File file = new File("generated/"+qu.getQuantityKind().replaceAll(" ", "")+".java");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        
        bw.write("package org.modelexecution.quantitytypes.java;\n");
        bw.write("import java.util.Arrays;\n");
        bw.write("public class "+qu.getQuantityKind().replace(" ", "")+" extends Quantity {\n");
		
        checkUnit(qudt, i, bw);
        
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(Quantity q){\n");
        bw.write("value = q.value.clone();\n");
        bw.write("if (!checkUnit(q.unit)) throw new RuntimeException(\"Invalid Unit for creating a "+qu.getQuantityKind().replace(" ", "")+"\");\n");
        bw.write("this.unit = new Unit (q.unit);\n");
        bw.write("}\n");
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" () {\n");
        bw.write("value = new UReal();\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(UReal u){\n");
        bw.write("value = u.clone();\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(UReal u, Unit unit){\n");
        bw.write("value = u.clone();\n");
        bw.write("if (!checkUnit(unit)) throw new RuntimeException(\"Invalid Unit for creating an "+qu.getQuantityKind().replace(" ", "")+"\");\n");
        bw.write("this.unit = new Unit (unit);\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(double x){ //\"promotes\" a real x\n"); 
        bw.write("value = new UReal(x);\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");
      
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" (double x, double u) {\n");
        bw.write("value = new UReal(x,u);\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");
        
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(double x, Unit unit){ //we only allow the same Units\n");
        bw.write("value = new UReal(x);\n");
        bw.write("if (!checkUnit(unit)) throw new RuntimeException(\"Invalid Unit for creating a "+qu.getQuantityKind().replace(" ", "")+"\");\n");
        bw.write("this.unit = new Unit (unit);\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(double x, double u, Unit unit){\n");
        bw.write("value = new UReal(x,u);\n");
        bw.write("if (!checkUnit(unit)) throw new RuntimeException(\"Invalid Unit for creating a "+qu.getQuantityKind().replace(" ", "")+"\");\n");
        bw.write("this.unit = new Unit (unit);\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(String x) { //creates a "+qu.getQuantityKind().replace(" ", "")+" from a string representing a real, with u=0.\n");
        bw.write("value = new UReal(x);\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");
        
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(String x, String u) { //creates a "+qu.getQuantityKind().replace(" ", "")+" from two strings representing (x,u).\n");
        bw.write("value = new UReal(x,u);\n");
        bw.write("unit = new Unit(DerivedUnits."+qu.getUnit().replace(" ", "")+");\n");
        bw.write("}\n");
       
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+"(String x, String u, Unit unit) { //creates a "+qu.getQuantityKind().replace(" ", "")+" from two strings representing (x,u).\n");
        bw.write("value = new UReal(x,u);\n");
        bw.write("if (!checkUnit(unit)) throw new RuntimeException(\"Invalid Unit for creating a "+qu.getQuantityKind().replace(" ", "")+"\");\n");
        bw.write("this.unit = new Unit (unit);\n");
        bw.write("}\n");

        bw.write("// Specific Type Operations\n");
         
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" add("+qu.getQuantityKind().replace(" ", "")+" r) {  //only works if compatible units && operand has no offset\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(super.add(r));\n");
        bw.write("}\n");
    	
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" minus("+qu.getQuantityKind().replace(" ", "")+" r) { //only works if compatible units. You can subtract 2 units with offsets, but it returns a DeltaUnit (without offset)\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(super.minus(r));\n");
        bw.write("}\n");
    	
        mult(qudt, i, bw);
        
        div(qudt, i, bw);
        
        inv(qudt, i, bw);
        
        sqrt(qudt, i, bw);
        
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" abs() { //units are maintained\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(super.abs());\n");
        bw.write("}\n");
    	
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" neg() { //units are maintained\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(super.neg());\n");
        bw.write("}\n");

        bw.write("// power(s), and inverse() return Quantity\n");
        bw.write("// lessThan, LessEq, gt, ge all directly from Quantity\n");

        bw.write("public boolean equals("+qu.getQuantityKind().replace(" ", "")+" r) {  \n");
        bw.write("return  r.compatibleUnits(this) && \n");
        bw.write("this.getUReal().equals(r.convertTo(this.getUnits()).getUReal());\n");
        bw.write("}\n");

        bw.write("public boolean distinct("+qu.getQuantityKind().replace(" ", "")+" r) {\n");  
        bw.write("return !(this.equals(r));\n");
        bw.write("}\n");
    	
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" floor() { //returns (i,u) with i the largest int such that (i,u)<=(x,u) -- units maintained\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(Math.floor(this.getX()),this.getU(),this.getUnits());\n");
        bw.write("}\n");
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" round(){ //returns (i,u) with i the closest int to x -- units maintained\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(Math.round(this.getX()),this.getU(),this.getUnits());\n");
        bw.write("}\n");
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" min("+qu.getQuantityKind().replace(" ", "")+" r) { // units maintained\n");
        bw.write("if (r.lessThan(this)) return new "+qu.getQuantityKind().replace(" ", "")+"(r.getX(),r.getU(),r.getUnits());\n"); 
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.getX(),this.getU(),this.getUnits());\n");
        bw.write("}\n");
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" max("+qu.getQuantityKind().replace(" ", "")+" r) { // unit maintained\n");
        bw.write("//if (r>this) r; else this;\n");
        bw.write("if (r.gt(this)) return new "+qu.getQuantityKind().replace(" ", "")+"(r.getX(),r.getU(),r.getUnits());\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.getX(),this.getU(),this.getUnits());\n");
        bw.write("}\n");

    	bw.write("// working with constants (note that add and minus do not work here\n");
    
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" mult(double r) {\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.value.mult(new UReal(r)),this.getUnits());\n");
        bw.write("}\n");
    	
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" divideBy(double r) {\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.value.divideBy(new UReal(r)),this.getUnits());\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" mult(UReal r) {\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.value.mult(r),this.getUnits());\n");
        bw.write("}\n");
    	
        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" divideBy(UReal r) {\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.value.divideBy(r),this.getUnits());\n");
        bw.write("}\n");

        bw.write("// Conversions to basic types: toString, toInteger, toReal, etc. directly from Quantity\n");
    	
        bw.write("public int hashcode(){ //required for equals()\n");
        bw.write("return Math.round((float)value.getX());\n");
        bw.write("}\n");

        bw.write("public "+qu.getQuantityKind().replace(" ", "")+" clone() {\n");
        bw.write("return new "+qu.getQuantityKind().replace(" ", "")+"(this.getUReal(),this.getUnits());\n");
        bw.write("}\n");
        bw.write("}\n");

        
        ////////////////////////////////////////////
        
        bw.close();
	}

	private static void checkUnit(List<QUEntry> qudt, int i, BufferedWriter bw) throws IOException {
		
		QUEntry qu = qudt.get(i);
		
		bw.write("static protected boolean checkUnit(Unit u) {\n"
				+ "double [] x = new double [BaseUnits.values().length];\n");	
		bw.write("x[BaseUnits.Meter.ordinal()]="+qu.getTuple()[0]+";\n");
		bw.write("x[BaseUnits.Kilogram.ordinal()]="+qu.getTuple()[1]+";\n");
		bw.write("x[BaseUnits.Second.ordinal()]="+qu.getTuple()[2]+";\n");
		bw.write("x[BaseUnits.Ampere.ordinal()]="+qu.getTuple()[3]+";\n");
		bw.write("x[BaseUnits.Kelvin.ordinal()]="+qu.getTuple()[4]+";\n");
		bw.write("x[BaseUnits.Mole.ordinal()]="+qu.getTuple()[5]+";\n");
		bw.write("x[BaseUnits.Radian.ordinal()]="+qu.getTuple()[6]+";\n");
		bw.write("x[BaseUnits.Candela.ordinal()]="+qu.getTuple()[7]+";\n");
		bw.write("return Arrays.equals(x,u.dimensions);\n"
				+"}\n\n");
		
	}

	private static void inv(List<QUEntry> qudt, int i, BufferedWriter bw) throws IOException {
			
			QUEntry qu1 = qudt.get(i);

			double[] result = qu1.inv();
			String resultantQUKind = exists(result, qudt);
			if (!resultantQUKind.equals("")){				
//				bw.write(qu1.getQuantityKind()+".inv() returns "+resultantQUKind+"\t=>\t inv ");
//				bw.write(qu1.printTuple());
//				bw.write(" = ");
//				bw.write(printTuple(result)+"\n");
				
				bw.write("public "+resultantQUKind.replace(" ", "")+" inverse() {\n");
				bw.write("return new  "+resultantQUKind.replace(" ", "")+"(super.inverse());\n");
				bw.write("}\n");
				
			}
			
		
	}
	
	private static void sqrt(List<QUEntry> qudt, int i, BufferedWriter bw) throws IOException {
		
		QUEntry qu1 = qudt.get(i);

		double[] result = qu1.sqrt();
		String resultantQUKind = exists(result, qudt);
		if (!resultantQUKind.equals("")){				
//			bw.write(qu1.getQuantityKind()+".sqrt() returns "+resultantQUKind+"\t=>\t sqrt ");
//			bw.write(qu1.printTuple());
//			bw.write(" = ");
//			bw.write(printTuple(result)+"\n");
			
			bw.write("public "+resultantQUKind.replace(" ", "")+" sqrt() {\n");
			bw.write("return new  "+resultantQUKind.replace(" ", "")+"(super.sqrt());\n");
			bw.write("}\n");
			
		}
	}
	
	public static String printTuple(double[] tuple) {
		String s = "[";
		for (int i=0; i<tuple.length-1; i++){
			s+= tuple[i]+", ";
		}
		s+=tuple[tuple.length-1] + "]";
		return s;
	}

	private static void mult(List<QUEntry> qudt, int i, BufferedWriter bw) throws IOException {
		
		for (int j = 0; j < qudt.size(); j++) {
			if (i != j) {

				QUEntry qu2 = qudt.get(j);

				double[] result = qudt.get(i).mult(qu2.getTuple());
				String resultantQUKind = exists(result, qudt);

				if (!resultantQUKind.equals("")) {
//					bw.write(qudt.get(i).getQuantityKind() + ".mult(" + qu2.getQuantityKind() + ") returns "
//							+ resultantQUName + "\t=>\t");
//					bw.write(printTuple(qudt.get(i).getTuple()));
//					bw.write(" * ");
//					bw.write(printTuple(qu2.getTuple()));
//					bw.write(" = ");
//					bw.write(result + "\n");
					
					bw.write("public "+resultantQUKind.replace(" ", "")+" mult("+qu2.getQuantityKind().replace(" ", "")+" r) { //both values and units are multiplied. No offsets allowed in any of the units\n");
					bw.write("return new "+resultantQUKind.replace(" ", "")+"(super.mult(r));\n");
					bw.write("}\n");
					
				}
				
			}
		}
		
	}
	
	private static void div(List<QUEntry> qudt, int i, BufferedWriter bw) throws IOException {
		
		for (int j = 0; j < qudt.size(); j++) {
			if (i != j) {

				QUEntry qu2 = qudt.get(j);

				double[] result = qudt.get(i).divideBy(qu2.getTuple());
				String resultantQUKind = exists(result, qudt);

				if (!resultantQUKind.equals("")) {
//					bw.write(qudt.get(i).getQuantityKind() + ".div(" + qu2.getQuantityKind() + ") returns "
//							+ resultantQUName + "\t=>\t");
//					bw.write(printTuple(qudt.get(i).getTuple()));
//					bw.write(" / ");
//					bw.write(printTuple(qu2.getTuple()));
//					bw.write(" = ");
//					bw.write(result + "\n");
					
					bw.write("public "+resultantQUKind.replace(" ", "")+" divideBy("+qu2.getQuantityKind().replace(" ", "")+" r) { //both values and units are divided. No offsets allowed in any of the units\n");
					bw.write("return new "+resultantQUKind.replace(" ", "")+"(super.divideBy(r));\n");
					bw.write("}\n");
					
				}
			}
		}
	}

	private static String exists(double[] result, List<QUEntry> qudt) {
		
		for (int i=0; i<qudt.size(); i++){
				QUEntry qui = qudt.get(i);
				boolean equal = Arrays.equals(qui.getTuple(), result);
				if (equal){
					return qui.getQuantityKind();
				}
		}
		return "";
	}
	
	private static List<QUEntry> loadQuantityUnitsFromCVS() throws IOException {
		
		List<QUEntry> qudt = new LinkedList<QUEntry>();
		
		BufferedReader br = new BufferedReader(new FileReader("QUDT.csv"));  
		String line = br.readLine(); //ignore the first line
		line = br.readLine();
		while (line != null) {
			
			StringTokenizer st = new StringTokenizer(line, ",");
			st.nextToken();
			String quantityKind = st.nextToken().substring(9);
			String dimensionSymbol = st.nextToken();
			st.nextToken();
			String unit = st.nextToken().substring(5);
			
			QUEntry quEntry = new QUEntry(quantityKind, dimensionSymbol, unit);
			qudt.add(quEntry);
			
			line = br.readLine();
		}
		br.close();
		return qudt;
	}
	
}
