package org.modelexecution.quantitytypes.java;

import java.util.ArrayList;
import java.util.List;


public class UString {

	public static final double THRESHOLD = 0.95d;
	private final String string;
	private final double sConf;

    /***
     * Constructors
     ***/

    public UString(String s, double sConf) {
        string = s;
        this.sConf = sConf;
    }

    /***
     * getters
     ***/
    public String getString() {
        return string;
    }

    public double getsConf() {
        return sConf;
    }

    /***
     * Auxiliary operations
     ***/
    public double confToDist(){
        return this.string.length()*(1 - this.sConf);
    }

    public double confToDist(double conf, int size){
        return size *(1 - conf);
    }

    public double distToConf(double dist, int size){
        return Math.max(1-dist/size, 0.0d);
    }

    @Override
    public String toString() {
        return String.format("{%s, %6.4f}", string, sConf);
    }

    public static int levenshteinDist(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        // System.out.println("Distance "+a+" to " + b+ ": "+costs[b.length()]);
        return costs[b.length()];
    }

    /***
     * UString operations
     ***/
    public UString uConcat(UString u){
        String s = this.getString() + u.getString();

        double auxDist = this.confToDist() + u.confToDist();
        double sConf = distToConf(auxDist, this.getString().length()+u.getString().length());
        return new UString(s, sConf);
    }

    public UString uSubstring(int lower, int upper){
        if (lower < 1 ) throw new RuntimeException("lower should be greater than 0");
        lower = lower -1; // para incluir desde hasta
        String s = this.getString().substring(lower, upper);
        double sConf = this.getsConf();
        return new UString(s, sConf);
    }

    public UBoolean uEquals(UString u) {
//        double dist = this.confToDist() + u.confToDist() + levenshteinDist(this.getString(), u.getString());
//        double conf = distToConf(dist, Math.max(this.string.length(), u.string.length()));
//        return new UBoolean(true, conf);
        int result = this.string.compareTo(u.string);
        boolean b = result == 0;
        double conf = (this==u) ? 1.0 : calculateConf(u);
        return new UBoolean(b, conf);
    }

    public UBoolean uEqualsIgnoreCase(UString u){
        return this.uToUpperCase().uEquals(u.uToUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UString uString = (UString) o;

        if (Double.compare(uString.getsConf(), getsConf()) != 0) return false;
        return getString().equals(uString.getString());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getString().hashCode();
        temp = Double.doubleToLongBits(getsConf());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public UInteger uSize() {
        return new UInteger(this.string.length(), this.confToDist());
    }

    public UString uToUpperCase(){
        return new UString(this.getString().toUpperCase(), this.getsConf());
    }

    public UString uToLowerCase(){
        return new UString(this.getString().toLowerCase(), this.getsConf());
    }

    public int indexOf(String s){
        return this.getString().indexOf(s);
    }

    public String at(int idx){
        if (idx < 1 || idx > this.string.length()) throw new IndexOutOfBoundsException("idx = " + idx);
        return this.getString().substring(idx-1, idx);
    }

    public UString uAt(int idx){
        return this.uSubstring(idx, idx);
    }

    public List<UString> uCharacters(){
        List<UString> uchars = new ArrayList<>();
        for (int i = 1; i <= this.string.length() ; i++) {
            uchars.add(this.uAt(i));
        }
        return uchars;
    }

    /****
    * Conversion operations
    ****/

    public String uToString(){
        return this.getString();
    }

    public double toReal(){
        return Double.parseDouble(this.getString());
    }

    public int toInteger(){
        return Integer.parseInt(this.getString());
    }

    public boolean toBoolean(){
        return Boolean.parseBoolean(this.getString());
    }

    /*
     * Revisar
     */
    public UBoolean uToUBoolean(){
        UBoolean rTrue = this.uEqualsIgnoreCase(new UString("TRUE", 1.0d));
        UBoolean rFalse = this.uEqualsIgnoreCase(new UString("FALSE", 1.0d));
        if(rTrue.getC() >= 0.5d)
            return new UBoolean(true, rTrue.getC());
        else if (rFalse.getC() >= 0.5d)
            return new UBoolean(false, rFalse.getC());
        else
            return new UBoolean(true, 0.5d);
    }

    public UBoolean lt(UString u){
        int result = this.string.compareTo(u.string);
        boolean b = result < 0;
        double conf = calculateConf(u);
        return new UBoolean(b, conf);
    }


    public UBoolean gt(UString u){
        int result = this.string.compareTo(u.string);
        boolean b = result > 0;
        double conf = calculateConf(u);
        return new UBoolean(b, conf);
    }

    public UBoolean le(UString u){
        int result = this.string.compareTo(u.string);
        boolean b = result <= 0;
        double conf = calculateConf(u);
        return new UBoolean(b, conf);
    }

    public UBoolean ge(UString u){
        int result = this.string.compareTo(u.string);
        boolean b = result >= 0;
        double conf = calculateConf(u);
        return new UBoolean(b, conf);
    }

    /*
     * La confianza es el producto de las confianzas del string
     * Aparecen problemas para confianzas inferiores a 0.7 porque para resultados de confianza menor a 0.5
     * "conmuta" de true a false y viceversa
     */
    private double calculateConf(UString u) {
        double conf = this.sConf * u.sConf; // conf producto de las confianzas de cada string
        return conf;
    }

    /*
     * Posible implementacion alternativa, limitando para los casos peores a conf = 0.5
     * No se usa en la ultima version
     */
    private double calculateConf_05(UString u) {
        double conf = this.sConf * u.sConf; // conf producto de las confianzas de cada string
        return Double.compare(conf,0.5d) >= 0 ? conf : 0.5d ;
    }
}