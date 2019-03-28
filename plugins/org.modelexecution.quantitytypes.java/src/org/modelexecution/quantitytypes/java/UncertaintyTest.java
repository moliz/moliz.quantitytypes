package uDataTypes.java;

public class UncertaintyTest {
	
	
	public static void main(String[] args) {


	UBoolean b1 = new UBoolean(true, 1);
	UBoolean b2 = new UBoolean(true, 1);

	UBoolean res = b1.equivalent(b2);
	System.out.println("res="+res);
	
	UReal x = new UReal(2.0,0.1);
	UReal y = new UReal(2.0,0.0);
	UReal y2 = new UReal(2.0,0.0001);
	
	System.out.println("z="+(x.ge(y)));
	
	System.out.println("z2="+(x.ge(y2)));
	
	}
		

}
