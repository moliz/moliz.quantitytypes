package org.modelexecution.quantitytypes.java;

public class UEnumTest {

    public static void main(String[] args) {

     testFourLevels();

      testDaysOfWeek();
      testDaysOfWeekAlea();
  }

  private enum FourLevels {
      HIGH, MEDIUM, LOW, ZERO
  }

  private enum DaysOfWeekNames {
      MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
  }


  private static void testFourLevels() {
      double c1 = 1.0d;
      double c2 = 0.0d;
      double c3 = 0.0d;
      double c4 = 0.0d;
      UEnum<FourLevels> uEnum1 = new UEnum<>(FourLevels.class, new Double[]{c1, c2, c3, c4});
      UEnum<FourLevels> uEnum2 = new UEnum<>(FourLevels.class, new Double[]{c2, c1, c4, c3});
      for (double d = 0.9d; Double.compare(d, 0.0d) >= 0; d-=0.1d) {
          System.out.println(uEnum1);
          System.out.println(uEnum2);
          System.out.println(uEnum1.uEquals(uEnum2));
          System.out.println();
          c1 = d;
          c2 = (1-c1)*0.9;
          c3 = (1-c1)*0.05;
          c4 = 1 - (c1+c2+c3);
          uEnum1 = new UEnum<>(FourLevels.class, new Double[]{c1, c2, c3, c4});
          uEnum2 = new UEnum<>(FourLevels.class, new Double[]{c2, c1, c4, c3});
      }
      System.out.println(uEnum1.literals());
      System.out.println();
  }

  private static void testDaysOfWeek() {
      UEnum<DaysOfWeekNames> MONDAY = new UEnum<>(DaysOfWeekNames.class, new Double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d});
      UEnum<DaysOfWeekNames> today = new UEnum<>(DaysOfWeekNames.class, new Double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d});
      double conf = 1.0d;

      do {
          System.out.println("Is today Monday?" +  MONDAY.uEquals(today));
          System.out.println();
          conf = conf - 0.1d;
          double confOthers =(1 - conf)/6;
          today = new UEnum<>(DaysOfWeekNames.class, new Double[]{conf, confOthers, confOthers, confOthers, confOthers, confOthers, confOthers});
      }while (conf >= 0.0);
  }

  private static Double[] generateConf(int numValues){
      if (numValues <= 0) throw new RuntimeException("Number of Values should be greater than zero.");
      Double[] result = new Double[numValues];
      double sumConf = 0;
      for (int i = 0; i < result.length; i++) {
          result[i] = Math.random();
          sumConf += result[i];
      }
      for (int i = 0; i < result.length ; i++) {
          result[i] /= sumConf;
      }
      sumConf = 0;
      for (double conf: result) {
          sumConf += conf;
      }
//      System.out.format("Sum of Confidences = %11.9f\n", sumConf);

      return result;
  }

  private static Double[] generateConfOneElem(int numValues){
      Double[] result = generateConf(numValues);
      double max = 0.0d;
      int idx = 0;
      for (int i = 0; i < result.length; i++) {
          if (result[i] > max){
              max = result[i];
              idx = i;
          }
      }
      for (int i = 1; i <= numValues-3-1; i++) {
          result[idx] += result[(idx+1+i)%numValues];
      }
      result[(idx+1)%numValues]= result[(idx+numValues-3)%numValues];
      return result;
  }

  private static void testDaysOfWeekAlea() {
      for (int i = 0; i < 10; i++) {
          Double[] confs = generateConf(DaysOfWeekNames.values().length);
          UEnum<DaysOfWeekNames> uEnum1 = new UEnum<>(DaysOfWeekNames.class, confs);
          System.out.println(uEnum1);

          confs = generateConf(DaysOfWeekNames.values().length);
          UEnum<DaysOfWeekNames> uEnum2 = new UEnum<>(DaysOfWeekNames.class, confs);
          System.out.println(uEnum2);

          System.out.println("UEnum1 is equal to UEnum2? " + uEnum1.uEquals(uEnum2));
          System.out.println();
      }
  }


}
