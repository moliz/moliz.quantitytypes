package org.modelexecution.quantitytypes.java;

public class UncertaintyTest {
	
	
	public static void main(String[] args) {


	UBoolean b1 = new UBoolean(true, 0.9);
	UBoolean b2 = new UBoolean(true, 0.1);

	System.out.println("equivalent="+b1.equivalent(b2));
	
	System.out.println("xor="+b1.xor(b2));
	System.out.println("equals="+b1.equals(b2));
	System.out.println("equalsC="+b1.equalsC(b2,0.85));
	
	
	
	UReal x = new UReal(2.0,0.1);
	UReal y = new UReal(2.0,0.0);
	UReal y2 = new UReal(2.0,0.0001);
	
	System.out.println("z="+(x.ge(y)));
	
	System.out.println("z2="+(x.ge(y2)));
	
	}
		

}
