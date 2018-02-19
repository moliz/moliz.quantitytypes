package org.modelexecution.quantitytypes.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelexecution.quantitytypes.java.UBoolean;

public class UBooleanTest {
    private static final double DELTA = 1.0E-9;
    private static final double CONF09 = 0.9d;
    private static final int SAMPLESIZE = 10000;
    UBoolean uTrue, uFalse;


    @Before
    public void setUp(){
        uTrue = new UBoolean(true, CONF09);
        uFalse = new UBoolean(false, CONF09);
    }

    @After
    public void teardowun(){
        uTrue = null;
        uFalse = null;
    }

    @Test
    public void emptyUBoolean() throws Exception {
        UBoolean u = new UBoolean();

        assertEquals(true, u.getB());
        assertEquals(0.0, u.getC(), DELTA);
    }

    @Test
    public void trueUBoolean() throws Exception {
        UBoolean uBoolean = new UBoolean(true);
        assertEquals(true, uBoolean.getB());
        assertEquals(1.0, uBoolean.getC(), DELTA);
    }

    @Test
    public void falseUBoolean() throws Exception {
        UBoolean uBoolean = new UBoolean(false);
        assertEquals(true, uBoolean.getB());
        assertEquals(0.0, uBoolean.getC(), DELTA);
    }

    @Test
    public void true09UBoolean() throws Exception {
        double expectedConf = CONF09;

        assertEquals(true, uTrue.getB());
        assertEquals(expectedConf, uTrue.getC(), DELTA);
    }

    @Test
    public void false09UBoolean() throws Exception {
        double expectedConf = 1 - CONF09;

        assertEquals(true, uFalse.getB());
        assertEquals(expectedConf, uFalse.getC(), DELTA);
    }

    @Test
    public void notTrue09() throws Exception {
        double expectedConf = 1 - uTrue.getC();

        UBoolean u = uTrue.not();
        System.out.println(u.toString() + " = not " + uTrue);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void notFalse09() throws Exception {
        double expectedConf = 1 - uFalse.getC();

        UBoolean u = uFalse.not();
        System.out.println(u.toString() + " = not " + uFalse);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void andTrueTrue() throws Exception {
        double expectedConf = uTrue.getC() * uTrue.getC();

        UBoolean u = uTrue.and(uTrue);
        System.out.println(u.toString() + " = " + uTrue + " and " + uTrue);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void andTrueFalse() throws Exception {
        double expectedConf = uTrue.getC() * uFalse.getC();

        UBoolean u = uTrue.and(uFalse);
        System.out.println(u.toString() + " = " + uTrue + " and " + uFalse);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void andFalseTrue() throws Exception {
        double expectedConf = uFalse.getC() * uTrue.getC();

        UBoolean u = uFalse.and(uTrue);
        System.out.println(u.toString() + " = " + uFalse + " and " + uTrue);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void andFalseFalse() throws Exception {
        double expectedConf = uFalse.getC() * uFalse.getC();

        UBoolean u = uFalse.and(uFalse);
        System.out.println(u.toString() + " = " + uFalse + " and " + uFalse);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void orTrueTrue() throws Exception {
        UBoolean u1 = new UBoolean(true, 0.95);
        UBoolean u2 = new UBoolean(true, 0.90);
        double expectedConf = u1.getC() + u2.getC() - u1.getC()*u2.getC();

        UBoolean u = u1.or(u2);
        System.out.println(u.toString() + " = " + u1 + " or " + u2);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void orSampleSize() throws Exception {
        UBoolean[] uBooleans = new UBoolean[SAMPLESIZE];
        for (int i = 0; i < uBooleans.length; i++) {
            uBooleans[i] = new UBoolean(true, Math.random());
        }

        UBoolean u = uBooleans[0];
        double expectedConf = uBooleans[0].getC();
        for (int i = 1; i < uBooleans.length; i++) { // empezamos en 1, inicializamos u a u[0]
            u = u.or(uBooleans[i]);
            expectedConf = expectedConf + uBooleans[i].getC() - expectedConf*uBooleans[i].getC();
        }

        System.out.println(u.toString());

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void andSampleSize() throws Exception {
        UBoolean[] uBooleans = new UBoolean[SAMPLESIZE];
        for (int i = 0; i < uBooleans.length; i++) {
            uBooleans[i] = new UBoolean(true, Math.random());
        }

        UBoolean u = uBooleans[0];
        double expectedConf = uBooleans[0].getC();
        for (int i = 1; i < uBooleans.length; i++) { // empezamos en 1, inicializamos u a u[0]
            u = u.and(uBooleans[i]);
            expectedConf = expectedConf*uBooleans[i].getC();
        }

        System.out.println(u.toString());

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void impliesTrueTrue() throws Exception {
        UBoolean u1 = new UBoolean(true, 0.95);
        UBoolean u2 = new UBoolean(true, 0.90);
        double expectedConf = u1.getC() + u2.getC() - u1.getC()*u2.getC();

        UBoolean u = u1.implies(u2);
        System.out.println(u.toString() + " = " + u1 + " implies " + u2);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    // @Test
    public void equivalentTrueTrue() throws Exception {
        UBoolean u1 = new UBoolean(true, 0.95);
        UBoolean u2 = new UBoolean(true, 0.90);
        // double expectedConf = 2*u1.getC()*u2.getC() - Math.pow(u1.getC(),2)*Math.pow(u2.getC(),2);
        double impConf = u1.getC() + u2.getC() - u1.getC()*u2.getC();
        double expectedConf = impConf * impConf;

        UBoolean u = u1.equivalent(u2);
        System.out.println(u.toString() + " = " + u1 + " equivalent " + u2);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void equivalentWithImpliesTrueTrue() throws Exception {
        UBoolean u1 = new UBoolean(true, 0.95);
        UBoolean u2 = new UBoolean(true, 0.90);

        // u1.implies(u2).and(u2.implies(u1));
        // cp1 = confianza(u1.implies(u2)) = c1 + c2 - c1*c2
        // cp2 = confianza(u2.implies(u1)) = c2 + c1 - c2*c1 -- igual que la anterior
        // confianza(equivalent) = cp1 * cp2 -- AND de las dos partes
        double impConf = u1.getC() + u2.getC() - u1.getC()*u2.getC();
        double expectedConf = impConf * impConf;

        UBoolean u = u1.equivalent(u2);
        System.out.println(u.toString() + " = " + u1 + " equivalent " + u2);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }

    @Test
    public void xorTrueTrue() throws Exception {
        UBoolean u1 = new UBoolean(true, 0.95);
        UBoolean u2 = new UBoolean(true, 0.90);

        // xor = u1.equivalent(u2).not();
        // 1 - (c1 + c2 - c1*c2)^2
        double impConf = u1.getC() + u2.getC() - u1.getC()*u2.getC();
        double expectedConf = 1 - impConf * impConf;

        UBoolean u = u1.xor(u2);
        System.out.println(u.toString() + " = " + u1 + " xor " + u2);

        assertEquals(true, u.getB());
        assertEquals(expectedConf, u.getC(), DELTA);
    }


}