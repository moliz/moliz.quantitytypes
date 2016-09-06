package org.modelexecution.quantitytypes.fuml.library.urealfunctions;

import java.util.ArrayList;
import java.util.List;

import fUML.Semantics.Classes.Kernel.DataValue;
import fUML.Semantics.Classes.Kernel.RealValue;
import fUML.Semantics.Classes.Kernel.ValueList;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public abstract class URealFunctionBehaviorExecution extends OpaqueBehaviorExecution {

	@Override
	public void doBody(ParameterValueList inputParameters, ParameterValueList outputParameters) {
		List<DataValue> arguments = getInputParameterValues(inputParameters);
		DataValue result = doURealFunction(arguments);
		setOutputParameterValues(outputParameters, result);
	}

	private List<DataValue> getInputParameterValues(ParameterValueList inputParameters) {
		List<DataValue> arguments = new ArrayList<DataValue>();
		for (ParameterValue inputParameter : inputParameters) {
			arguments.add((DataValue) inputParameter.values.getValue(0));
		}
		return arguments;
	}

	private void setOutputParameterValues(ParameterValueList outputParameters, DataValue result) {
		ParameterValue outputParameterValue = outputParameters.get(0);
		outputParameterValue.values = new ValueList();
		if (result != null) {
			outputParameterValue.values.add(result);
		}
	}

	protected abstract DataValue doURealFunction(List<DataValue> arguments);

	protected Float getValue(DataValue urealValue) {
		return ((RealValue) urealValue.featureValues.get(0).values.get(0)).value;
	}

	protected Float getU(DataValue urealValue) {
		return ((RealValue) urealValue.featureValues.get(1).values.get(0)).value;
	}

}
