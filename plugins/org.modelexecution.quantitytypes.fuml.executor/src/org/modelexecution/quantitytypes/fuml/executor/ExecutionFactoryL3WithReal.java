package org.modelexecution.quantitytypes.fuml.executor;

import fUML.Semantics.Classes.Kernel.LiteralRealEvaluation;
import fUML.Semantics.Loci.LociL1.SemanticVisitor;
import fUML.Semantics.Loci.LociL3.ExecutionFactoryL3;
import fUML.Syntax.Classes.Kernel.Element;
import fUML.Syntax.Classes.Kernel.LiteralReal;

public class ExecutionFactoryL3WithReal extends ExecutionFactoryL3 {

	@Override
	public SemanticVisitor instantiateVisitor(Element element) {
		SemanticVisitor visitor = null;
		if (element instanceof LiteralReal) {
			visitor = new LiteralRealEvaluation();
		} else {
			visitor = super.instantiateVisitor(element);
		}
		return visitor;
	}
}
