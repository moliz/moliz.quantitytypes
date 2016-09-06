package org.modelexecution.quantitytypes.fuml.libraryregistry;

import org.modelexecution.fumldebug.core.ExecutionContext;
import org.modelexecution.fumldebug.debugger.uml.libraryregistry.AbstractUMLOpaqueBehaviorExecutionRegistry;
import org.modelexecution.quantitytypes.fuml.library.quantityfunctions.QuantityMinusFunctionBehaviorExecution;
import org.modelexecution.quantitytypes.fuml.library.urealfunctions.URealMinusFunctionBehaviorExecution;

public class QuantityBehaviorsExecutionRegistry extends AbstractUMLOpaqueBehaviorExecutionRegistry {

	public static final String UML_QUANTITY_BEHAVIORS_LIBRARY = "UML Quantity Behaviors Library";
	public static final String UML_UNCERTAINTY_BEHAVIORS_LIBRARY = "UML Uncertainty Behaviors Library";

	@Override
	public void registerOpaqueBehaviorExecutions(ExecutionContext executionContext) {
		loadOpaqueBehaviors(UML_QUANTITY_BEHAVIORS_LIBRARY);
		registerOpaqueBehaviorExecution(new QuantityMinusFunctionBehaviorExecution(),
				"QuantityBehaviors::QuantityFunctions::QuantityMinus", executionContext);

		loadOpaqueBehaviors(UML_UNCERTAINTY_BEHAVIORS_LIBRARY);
		registerOpaqueBehaviorExecution(new URealMinusFunctionBehaviorExecution(),
				"UncertaintyBehaviors::UncertaintyFunctions::URealMinus", executionContext);
	}

}
