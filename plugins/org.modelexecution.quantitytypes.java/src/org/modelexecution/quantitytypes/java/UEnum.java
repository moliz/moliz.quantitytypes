package org.modelexecution.quantitytypes.java;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;


public class UEnum<K extends Enum<K>> {
    private final Map<K, Double> elements;

    public UEnum(Class<K> literals, Double[] conf) {
        this.elements = new EnumMap<>(literals);
        for (K o : literals.getEnumConstants()) {
            this.elements.put(o, conf[o.ordinal()]);
        }
    }

    public Map<K, Double> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (K k: elements.keySet()) {
            str.append(String.format("%s=%5.3f, ", k.toString(), elements.get(k)));
        }
        return "UEnum{"+str+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UEnum<?> uEnum = (UEnum<?>) o;

        return elements.equals(uEnum.elements);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    public UBoolean uEquals(UEnum<K> uEnum) {
        if (this == uEnum) return new UBoolean(true, 1.0d);
        if (uEnum == null || getClass() != uEnum.getClass()) return new UBoolean(false, 1.0d);

        double error = 0;
        for (K k: this.elements.keySet()) {
            double c1 = this.elements.get(k);
            double c2 = uEnum.elements.get(k);
            error +=  (c1-c2)*(c1-c2);  // suma de diferencias al cuadrado
        }
        error = Math.sqrt(error/2);

        return new UBoolean(true, 1.0d-error);
    }

    public Set<K> literals(){
        return this.elements.keySet();
    }


}