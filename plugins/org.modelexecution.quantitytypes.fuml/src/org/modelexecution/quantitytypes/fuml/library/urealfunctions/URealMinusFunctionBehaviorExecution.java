package org.modelexecution.quantitytypes.fuml.library.urealfunctions;

import java.util.List;

import fUML.Semantics.Classes.Kernel.DataValue;
import fUML.Semantics.Classes.Kernel.RealValue;

public class URealMinusFunctionBehaviorExecution extends URealFunctionBehaviorExecution {

	@Override
	protected DataValue doURealFunction(List<DataValue> arguments) {
		DataValue x = arguments.get(0);
		DataValue y = arguments.get(1);

		Float xValue = getValue(x);
		Float xU = getU(x);
		Float yValue = getValue(y);
		Float yU = getU(y);

		RealValue resultValue = new RealValue();
		resultValue.value = xValue - yValue;
		resultValue.type = this.locus.factory.getBuiltInType("Real");

		RealValue resultU = new RealValue();
		resultU.value = (float) Math.sqrt((double) ((xU * xU) + (yU * yU)));
		resultU.type = this.locus.factory.getBuiltInType("Real");

		DataValue result = new DataValue();
		result.type = x.type;
		result.createFeatureValues();
		result.getFeatureValues().get(0).values.add(resultValue);
		result.getFeatureValues().get(1).values.add(resultU);

		return result;
	}

	public fUML.Semantics.Classes.Kernel.Value new_() {
		// Create a new instance of this kind of function behavior execution.
		return new URealMinusFunctionBehaviorExecution();
	}

}
