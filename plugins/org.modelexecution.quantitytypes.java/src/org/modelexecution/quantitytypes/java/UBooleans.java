package org.modelexecution.quantitytypes.java;

/** This class contains static versions of the operations for type UBoolean
 *  It is required because Esper (a CEP language) can only invoke static operations
 */

public class UBooleans {
  
    /**
     * Getters (no setters allowed in order to respect canonical form!)
     */
    public static boolean getB(UBoolean b) {
		return b.getB(); 
	}

    public static double getC(UBoolean b) {
		return b.getC();
	}

   /*********
     * 
     * STATIC Operations
     */

    public static UBoolean uNot(UBoolean b) {
	   return b.not();
   }

    public static UBoolean uAnd(UBoolean b1, UBoolean b2) {
	   return b1.and(b2);
   }
    public static UBoolean uOr(UBoolean b1, UBoolean b2) {
	   return b1.or(b2);
   }
    public static UBoolean uImplies(UBoolean b1, UBoolean b2) {
	   return b1.implies(b2);
   }
    public static UBoolean uXor(UBoolean b1, UBoolean b2) {
	   return b1.xor(b2);
   }
    public static UBoolean uEquivalent(UBoolean b1, UBoolean b2) {
	   return b1.equivalent(b2);
   }

    public static boolean equals(UBoolean b1, UBoolean b2) {
	   return b1.equals(b2);
   }

    public static boolean equalsC(UBoolean b1, UBoolean b2, double confidence) {
	   return b1.equalsC(b2,confidence);
   }

	/******
	 * STATIC Conversions
	 */
	public static String toString(UBoolean b) {
        return b.toString();
	}

	public static boolean toBoolean(UBoolean b) {
        return b.toBoolean();
	}

}
