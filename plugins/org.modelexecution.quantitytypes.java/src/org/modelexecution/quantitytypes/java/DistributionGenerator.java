package org.modelexecution.quantitytypes.java;

import java.util.Random;

public class DistributionGenerator {

	private static Random rnd = new Random();
	
	public DistributionGenerator(){
	}
	
	public double nextTruncated(double x, double u, double beta){
		
		double b = x + u*Math.sqrt(6/(1-beta*beta));
		double a = 2*x - b;
		double r1 = rnd.nextDouble();
		double r2 = rnd.nextDouble();
		return a + (b-a)*((1+beta)*r1 + (1-beta)*r2)/2;
	}
	
	public double nextTriangular(double x, double u){
		
		double b = x + u*Math.sqrt(6);
		double a = 2*x - b;
		double r1 = rnd.nextDouble();
		double r2 = rnd.nextDouble();
		return a + (b-a)*(r1+r2)/2;
	}
	
	public double nextUShaped(double x, double u){
		double r = rnd.nextDouble();
		return x + u*Math.sqrt(2)*Math.sin(2*Math.PI*r);
	}
}
