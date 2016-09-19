package org.modelexecution.quantitytypes.fuml.library.quantityfunctions;

import java.util.List;

import fUML.Semantics.Classes.Kernel.DataValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fUML.Syntax.Classes.Kernel.DataType;
import fUML.Syntax.Classes.Kernel.Type;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.Behavior;

public class QuantityMinusFunctionBehaviorExecution extends QuantityFunctionBehaviorExecution {

	@Override
	protected DataValue doQuantityFunction(List<DataValue> arguments) {
		DataValue x = arguments.get(0);
		Value xValue = x.featureValues.get(0).values.get(0);

		DataValue y = arguments.get(1);
		Value yValue = y.featureValues.get(0).values.get(0);

		Value resultValue = substractValues(xValue, yValue);

		DataValue result = createQuantity(x.type, resultValue, x.featureValues.get(1).values.get(0));

		return result;
	}

	private DataValue createQuantity(DataType type, Value value, Value unit) {
		DataValue quantity = new DataValue();
		quantity.type = type;
		quantity.createFeatureValues();
		quantity.getFeatureValues().get(0).values.add(value);
		quantity.getFeatureValues().get(1).values.add(unit);
		return quantity;
	}

	private Value substractValues(Value xValue, Value yValue) {
		Behavior minusBehavior = getBaseMinusFunction(xValue, yValue);
		Execution minusBehaviorExecution = this.locus.factory.createExecution(minusBehavior, this.context);
		setFunctionInput(minusBehaviorExecution, xValue, yValue);
		Value resultValue = executeBaseFunction(minusBehaviorExecution);
		return resultValue;
	}

	private Behavior getBaseMinusFunction(Value xValue, Value yValue) {
		Behavior minusBehavior = null;
		Type baseType = getBaseType(xValue, yValue);
		if (baseType != null) {
			minusBehavior = getFunctionBehavior(baseType.name + "Minus");
		}
		return minusBehavior;
	}

	private Value executeBaseFunction(Execution baseFunctionExecution) {
		baseFunctionExecution.execute();
		return baseFunctionExecution.getOutputParameterValues().get(0).values.get(0);
	}

	@Override
	public Value new_() {
		return new QuantityMinusFunctionBehaviorExecution();
	}

}
