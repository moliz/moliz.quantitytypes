package org.modelexecution.quantitytypes.fuml.library.quantityfunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fUML.Semantics.Classes.Kernel.DataValue;
import fUML.Semantics.Classes.Kernel.IntegerValue;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.Classes.Kernel.ValueList;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;
import fUML.Syntax.Classes.Kernel.Parameter;
import fUML.Syntax.Classes.Kernel.ParameterDirectionKind;
import fUML.Syntax.Classes.Kernel.Type;
import fUML.Syntax.CommonBehaviors.BasicBehaviors.OpaqueBehavior;

public abstract class QuantityFunctionBehaviorExecution extends OpaqueBehaviorExecution {

	@Override
	public void doBody(ParameterValueList inputParameters, ParameterValueList outputParameters) {
		List<DataValue> arguments = getInputParameterValues(inputParameters);
		DataValue result = doQuantityFunction(arguments);
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

	protected abstract DataValue doQuantityFunction(List<DataValue> arguments);

	protected OpaqueBehavior getFunctionBehavior(String behaviorName) {
		for (OpaqueBehaviorExecution execution : this.locus.factory.primitiveBehaviorPrototypes) {
			if (execution.types.get(0).name.equals(behaviorName)) {
				return (OpaqueBehavior) execution.types.get(0);
			}
		}
		return null;
	}

	protected Type getBaseType(Value... values) {
		Type baseType = null;

		if (values.length > 0) {
			if (values[0] instanceof IntegerValue) {
				baseType = this.locus.factory.getBuiltInType("Integer");
			} else if (values[0] instanceof DataValue) {
				baseType = ((DataValue) values[0]).type;
			}
		}
		return baseType;
	}

	protected void setFunctionInput(Execution functionBehaviorExecution, Value... values) {
		ValueList inputValues = new ValueList();
		inputValues.addAll(Arrays.asList(values));

		int inputValueIndex = 0;
		for (Parameter parameter : functionBehaviorExecution.getBehavior().ownedParameter) {
			if (parameter.direction == ParameterDirectionKind.in
					| parameter.direction == ParameterDirectionKind.inout) {
				ParameterValue parameterValue = new ParameterValue();
				parameterValue.parameter = parameter;
				parameterValue.values = new ValueList();
				parameterValue.values.add(inputValues.get(inputValueIndex++));
				functionBehaviorExecution.setParameterValue(parameterValue);
			}
		}
	}
}
