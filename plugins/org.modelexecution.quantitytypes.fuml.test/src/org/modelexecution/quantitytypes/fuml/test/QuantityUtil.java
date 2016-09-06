package org.modelexecution.quantitytypes.fuml.test;

import fUML.Semantics.Classes.Kernel.DataValue;
import fUML.Semantics.Classes.Kernel.FeatureValue;
import fUML.Semantics.Classes.Kernel.RealValue;
import fUML.Semantics.Classes.Kernel.StructuredValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.Classes.Kernel.ValueList;

public class QuantityUtil {

	public static final String QUANTITY_DATA_TYPE_NAME = "Quantity";
	public static final String QUANTITY_VALUE_ATTRIBUTE_NAME = "value";
	public static final String QUANTITY_UNIT_ATTRIBUTE_NAME = "unit";
	public static final String LENGTH_DATA_TYPE_NAME = "Length";
	public static final String[] QUANTITY_DATA_TYPE_NAMES = new String[] { QUANTITY_DATA_TYPE_NAME,
			LENGTH_DATA_TYPE_NAME };

	public static final String UREAL_DATA_TYPE_NAME = "UReal";
	public static final String UREAL_VALUE_ATTRIBUTE_NAME = "x";
	public static final String UREAL_UNCERTAINTY_ATTRIBUTE_NAME = "u";

	public static final String UNIT_DATA_TYPE_NAME = "Unit";
	public static final String UNIT_DIMENSIONS_ATTRIBUTE_NAME = "dimensions";
	public static final float[] METER_UNIT_DIMENSIONS = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };

	private QuantityUtil() {
	}

	public static boolean isQuantity(Value value) {
		boolean isQuantity = false;
		for (String quantityDataTypeName : QUANTITY_DATA_TYPE_NAMES) {
			if (isOfType(value, quantityDataTypeName)) {
				isQuantity = true;
			}
		}
		return isQuantity;
	}

	public static boolean isLength(Value value) {
		return isOfType(value, LENGTH_DATA_TYPE_NAME);
	}

	public static boolean isUReal(Value value) {
		return isOfType(value, UREAL_DATA_TYPE_NAME);
	}

	public static boolean isUnit(Value value) {
		return isOfType(value, UNIT_DATA_TYPE_NAME);
	}

	private static boolean isOfType(Value value, String typeName) {
		boolean isOfType = false;
		if (value instanceof DataValue) {
			DataValue dataValue = (DataValue) value;
			if (dataValue != null & dataValue.type != null & dataValue.type.name != null) {
				isOfType = typeName.equals(dataValue.type.name);
			}
		}
		return isOfType;
	}

	public static Value getQuantityValue(Value quantity) {
		Value quantityValue = null;
		if (QuantityUtil.isQuantity(quantity)) {
			ValueList quantityValues = getFeatureValue((DataValue) quantity, QUANTITY_VALUE_ATTRIBUTE_NAME);
			if (quantityValues.size() == 1) {
				if (QuantityUtil.isUReal(quantityValues.get(0))) {
					quantityValue = quantityValues.get(0);
				}
			}
		}
		return quantityValue;
	}

	public static DataValue getQuantityUnit(Value quantity) {
		DataValue unitValue = null;
		if (QuantityUtil.isQuantity(quantity)) {
			ValueList quantityUnits = getFeatureValue((DataValue) quantity, QUANTITY_UNIT_ATTRIBUTE_NAME);
			if (quantityUnits.size() == 1) {
				if (isUnit(quantityUnits.get(0))) {
					unitValue = (DataValue) quantityUnits.get(0);
				}
			}
		}
		return unitValue;
	}

	public static ValueList getFeatureValue(StructuredValue value, String featureName) {
		for (FeatureValue featureValue : value.getFeatureValues()) {
			if (featureName.equals(featureValue.feature.name)) {
				return featureValue.values;
			}
		}
		return null;
	}

	public static boolean assertQuantityValue(Value quantity, float expectedValue, float valueDelta,
			float expectedUncertainty, float uncertaintyDelta) {
		Value quantityValue = getQuantityValue(quantity);
		return equalsUReal(quantityValue, expectedValue, valueDelta, expectedUncertainty, uncertaintyDelta);
	}

	public static boolean equalsUReal(Value realValue, float expectedValue, float valueDelta, float expectedUncertainty,
			float uncertaintyDelta) {
		boolean equals = false;
		if (QuantityUtil.isUReal(realValue)) {
			ValueList valueValues = getFeatureValue((DataValue) realValue, UREAL_VALUE_ATTRIBUTE_NAME);
			ValueList uncertaintyValues = getFeatureValue((DataValue) realValue, UREAL_UNCERTAINTY_ATTRIBUTE_NAME);
			if (valueValues.size() == 1 & uncertaintyValues.size() == 1) {
				if (valueValues.get(0) instanceof RealValue & uncertaintyValues.get(0) instanceof RealValue) {
					RealValue valueValue = (RealValue) valueValues.get(0);
					RealValue uncertaintyValue = (RealValue) uncertaintyValues.get(0);
					equals = equalsFloat(valueValue.value, expectedValue, valueDelta)
							&& equalsFloat(uncertaintyValue.value, expectedUncertainty, uncertaintyDelta);
				}
			}
		}
		return equals;
	}

	public static boolean isMeter(Value quantity) {
		return assertQuantityUnit(quantity, METER_UNIT_DIMENSIONS);
	}

	public static boolean assertQuantityUnit(Value quantity, float... dimensions) {
		boolean result = false;
		DataValue quantityUnit = getQuantityUnit(quantity);
		if (dimensions.length == 8) {
			result = equalsUnit(quantityUnit, dimensions[0], dimensions[1], dimensions[2], dimensions[3], dimensions[4],
					dimensions[5], dimensions[6], dimensions[7]);
		}
		return result;
	}

	public static boolean equalsUnit(Value value, float meter, float kilogram, float second, float ampere, float kelvin,
			float mole, float candela, float radian) {
		boolean equals = false;
		if (isUnit(value)) {
			ValueList dimensionValues = getFeatureValue((DataValue) value, UNIT_DIMENSIONS_ATTRIBUTE_NAME);
			if (dimensionValues.size() == 8) {
				RealValue meterValue = (RealValue) dimensionValues.get(0);
				RealValue kilogramValue = (RealValue) dimensionValues.get(1);
				RealValue secondValue = (RealValue) dimensionValues.get(2);
				RealValue ampereValue = (RealValue) dimensionValues.get(3);
				RealValue kelvinValue = (RealValue) dimensionValues.get(4);
				RealValue moleValue = (RealValue) dimensionValues.get(5);
				RealValue candelaValue = (RealValue) dimensionValues.get(6);
				RealValue radianValue = (RealValue) dimensionValues.get(7);

				equals = equalsFloat(meterValue.value, meter, 0.1f) && equalsFloat(kilogramValue.value, kilogram, 0.1f)
						&& equalsFloat(secondValue.value, second, 0.1f) && equalsFloat(ampereValue.value, ampere, 0.1f)
						&& equalsFloat(kelvinValue.value, kelvin, 0.1f) && equalsFloat(moleValue.value, mole, 0.1f)
						&& equalsFloat(candelaValue.value, candela, 0.1f)
						&& equalsFloat(radianValue.value, radian, 0.1f);
			}
		}
		return equals;
	}

	private static boolean equalsFloat(float f1, float f2, float delta) {
		if (Float.compare(f1, f2) == 0) {
			return true;
		}
		if ((Math.abs(f1 - f2) <= delta)) {
			return true;
		}
		return false;
	}

}
