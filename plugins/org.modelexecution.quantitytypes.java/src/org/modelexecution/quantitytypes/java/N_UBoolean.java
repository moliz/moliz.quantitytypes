package org.modelexecution.quantitytypes.java;

import java.util.Arrays;
import java.util.Random;

public class N_UBoolean implements Cloneable, Comparable<N_UBoolean> {
    private static final int SAMPLESIZE = 10_000_000;
    private static Random rnd = new Random();

    protected final boolean value = true;
    protected final double confidence;
    protected boolean[] sample = new boolean[SAMPLESIZE];


    /***
     * Constructors
     ***/

    public N_UBoolean() {
        this.confidence = 0.0d;
        fillSample(sample, confidence);
    }

    public N_UBoolean(boolean value) { //"promotes" a boolean value to (value,1.0)
        this.confidence = value? 1.0d : 0.0d;
        fillSample(sample, confidence);
    }

    public N_UBoolean(boolean value, double c) {
        this.confidence = value ? c : 1 - c;
        fillSample(sample, this.confidence);
    }

    public N_UBoolean(boolean[] data){ // Calculate value and confidence for a data
        this.confidence = extractConfidence(data);
        if(data.length == this.sample.length)
            this.sample = Arrays.copyOf(data, data.length);
        else // If data length is not equal than sample length, create a new sample with confidence
            fillSample(sample, confidence);
    }

    /*
     * Auxiliary operations
     */

    private void fillSample(boolean s[], double c){
        for (int i = 0; i < SAMPLESIZE; i++) {
            // s[i] = (rnd.nextDouble() <= c);
            s[i] = Double.compare(rnd.nextDouble(), c) <= 0; // MFB . <= or < ; [0.0, 1.0)
        }
    }

    protected double extractConfidence() {
        int numTrue = 0;
        for (boolean b: this.sample) {
            if (b) numTrue++; // counting trues
        }
        return (double)numTrue / sample.length;
    }

    protected double extractConfidence(boolean[] data) {
        int numTrue = 0;
        for (boolean b: data) {
            if (b) numTrue++; // count trues
        }
        return (double)numTrue / data.length;
    }


     /*
      *  Getters
      */

    public static int getSamplesize() {
        return SAMPLESIZE;
    }

    public boolean getValue() {
        return value;
    }

    public double getConfidence() {
        return confidence;
    }

    public boolean[] getSample() {
        return Arrays.copyOf(sample, sample.length); // return sample;
    }

   /*
    * Type operations
    */

    public N_UBoolean not() {
        boolean[] notSample = new boolean[sample.length];
        for (int i = 0; i < notSample.length ; i++) {
            notSample[i] = !sample[i];
        }
        return new N_UBoolean(notSample);
    }

    public N_UBoolean and(N_UBoolean o) {
        boolean[] andSample = new boolean[SAMPLESIZE];
        for (int i = 0; i < SAMPLESIZE; i++) {
            andSample[i] = this.sample[i] & o.sample[i];
        }
        return new N_UBoolean(andSample);
    }

    public N_UBoolean or(N_UBoolean o) {
        boolean[] andSample = new boolean[SAMPLESIZE];
        for (int i = 0; i < SAMPLESIZE; i++) {
            andSample[i] = this.sample[i] | o.sample[i];
        }
        return new N_UBoolean(andSample);
    }

    public N_UBoolean implies(N_UBoolean nUBoolean) {
        boolean[] impliesSample = new boolean[SAMPLESIZE];
        for (int i = 0; i < SAMPLESIZE; i++) {
            impliesSample[i] = (!this.sample[i]) | nUBoolean.sample[i];
        }
        return new N_UBoolean(impliesSample);
    }

    public N_UBoolean equivalent(N_UBoolean nUBoolean) {
        N_UBoolean u1 = this.implies(nUBoolean);
        N_UBoolean u2 = nUBoolean.implies(this);
        N_UBoolean result = u1.and(u2);

        return result;
    }

    // equivalent	(X AND Y) OR (NOT X AND NOT Y)
    public N_UBoolean equivalent_V2(N_UBoolean nUBoolean) {
        N_UBoolean u1 = this.and(nUBoolean);
        N_UBoolean u2 = (this.not()).and((nUBoolean.not()));
        N_UBoolean result = u1.or(u2);

        return result;
    }

    public N_UBoolean xor(N_UBoolean nUBoolean) {
        return this.equivalent(nUBoolean).not();
    }

    // XOR	(X AND NOT Y) OR (NOT X AND Y)
    public N_UBoolean xor_V2(N_UBoolean nUBoolean) {
        N_UBoolean u1 = this.and(nUBoolean.not());
        N_UBoolean u2 = (this.not()).and(nUBoolean);

        return u1.or(u2);
    }


	/******
	 * Conversions
	 */
    @Override
    public String toString() {
        return "N_UBoolean{" +
                "value=" + value +
                ", confidence=" + confidence +
                ", sample=" + Arrays.toString(sample) +
                '}';
    }

	public boolean toBoolean(){ //
		return value; //works because it is in canonical form
	}
	
	/**
	 * Other Methods 
	 */

 	public int hashcode(){ //required for equals()
		return this.toBoolean()?1:0; 
	}

 	public N_UBoolean clone() {
		return new N_UBoolean(this.sample);
	}

	@Override
	public int compareTo(N_UBoolean other) {
		double x = (this.confidence-other.confidence);
		if (x==0) return 0;
		if (x<0) return -1;
		return 1;
	}


}
