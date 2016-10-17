package org.modelexecution.quantitytypes.java.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
                CircleTest.class,
                TemperatureTest.class,
                ToyCarTest.class,
                //UnitCancellation.class,
                PressureTest.class
                })

public class AllTests {

}