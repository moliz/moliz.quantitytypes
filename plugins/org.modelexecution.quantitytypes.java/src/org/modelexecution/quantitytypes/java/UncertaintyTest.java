package org.modelexecution.quantitytypes.java;

public class UncertaintyTest {
	
	
	public static void main(String[] args) {


	UBoolean b1 = new UBoolean(true, 1);
	UBoolean b2 = new UBoolean(true, 1);

	UBoolean res = b1.equivalent(b2);
	System.out.println("res="+res);
			
	
	}
		

}
