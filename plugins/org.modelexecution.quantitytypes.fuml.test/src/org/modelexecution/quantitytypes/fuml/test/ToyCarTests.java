package org.modelexecution.quantitytypes.fuml.test;

import org.junit.Assert;
import org.junit.Test;
import org.modelexecution.quantitytypes.fuml.executor.Executor;

import fUML.Semantics.Classes.Kernel.Object_;
import fUML.Semantics.Classes.Kernel.Reference;
import fUML.Semantics.Classes.Kernel.Value;
import fUML.Semantics.Classes.Kernel.ValueList;
import fUML.Semantics.CommonBehaviors.BasicBehaviors.ParameterValueList;

public class ToyCarTests {

	private static final String TOYCAR_MODEL_PATH = "model/toycar.uml";

	@Test
	public void test1_NewAccMeasure() {
		ParameterValueList activityOutput = new Executor(TOYCAR_MODEL_PATH).executeActivity("test1_NewAccMeasure");
		Assert.assertEquals(1, activityOutput.size());
		Assert.assertEquals(1, activityOutput.getValue(0).values.size());

		Value outputValue = activityOutput.getValue(0).values.getValue(0);
		Assert.assertTrue(outputValue instanceof Reference);
		Object_ outputObject = ((Reference) outputValue).referent;
		Assert.assertEquals("AccMeasure", outputObject.types.getValue(0).name);

		ValueList initialPositionValues = QuantityUtil.getFeatureValue(outputObject, "initialPosition");
		Assert.assertEquals(1, initialPositionValues.size());
		Value initialPosition = initialPositionValues.get(0);
		Assert.assertTrue(QuantityUtil.assertQuantityValue(initialPosition, 0.0f, 0.1f, 0.001f, 0.0001f));
		Assert.assertTrue(QuantityUtil.isMeter(initialPosition));

		ValueList finalPositionValues = QuantityUtil.getFeatureValue(outputObject, "finalPosition");
		Assert.assertEquals(1, finalPositionValues.size());
		Value finalPosition = finalPositionValues.get(0);
		Assert.assertTrue(QuantityUtil.assertQuantityValue(finalPosition, 10.0f, 0.1f, 0.001f, 0.0001f));
		Assert.assertTrue(QuantityUtil.isMeter(finalPosition));
	}

	@Test
	public void test2_ComputeDistance() {
		ParameterValueList activityOutput = new Executor(TOYCAR_MODEL_PATH).executeActivity("test2_ComputeDistance");
		Assert.assertEquals(1, activityOutput.size());
		Assert.assertEquals(1, activityOutput.get(0).values.size());

		Value calculatedDistance = activityOutput.get(0).values.get(0);
		Assert.assertTrue(QuantityUtil.isLength(calculatedDistance));
		Assert.assertTrue(QuantityUtil.assertQuantityValue(calculatedDistance, 10.0f, 0.1f, 0.00141f, 0.0001f));
		Assert.assertTrue(QuantityUtil.isMeter(calculatedDistance));
	}
}
