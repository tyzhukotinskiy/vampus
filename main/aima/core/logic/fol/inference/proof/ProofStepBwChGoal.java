package main.aima.core.logic.fol.inference.proof;

import main.aima.core.logic.fol.kb.data.Clause;
import main.aima.core.logic.fol.kb.data.Literal;
import main.aima.core.logic.fol.parsing.ast.Term;
import main.aima.core.logic.fol.parsing.ast.Variable;

import java.util.*;

/**
 * @author Ciaran O'Reilly
 */
public class ProofStepBwChGoal extends AbstractProofStep {
    //
    private List<ProofStep> predecessors = new ArrayList<ProofStep>();
    //
    private Clause toProve = null;
    private Literal currentGoal = null;
    private Map<Variable, Term> bindings = new LinkedHashMap<Variable, Term>();

    public ProofStepBwChGoal(Clause toProve, Literal currentGoal,
                             Map<Variable, Term> bindings) {
        this.toProve = toProve;
        this.currentGoal = currentGoal;
        this.bindings.putAll(bindings);
    }

    public Map<Variable, Term> getBindings() {
        return bindings;
    }

    public void setPredecessor(ProofStep predecessor) {
        predecessors.clear();
        predecessors.add(predecessor);
    }

    //
    // START-ProofStep
    @Override
    public List<ProofStep> getPredecessorSteps() {
        return Collections.unmodifiableList(predecessors);
    }

    @Override
    public String getProof() {
        StringBuilder sb = new StringBuilder();
        List<Literal> nLits = toProve.getNegativeLiterals();
        for (int i = 0; i < toProve.getNumberNegativeLiterals(); i++) {
            sb.append(nLits.get(i).getAtomicSentence());
            if (i != (toProve.getNumberNegativeLiterals() - 1)) {
                sb.append(" AND ");
            }
        }
        if (toProve.getNumberNegativeLiterals() > 0) {
            sb.append(" => ");
        }
        sb.append(toProve.getPositiveLiterals().get(0));
        return sb.toString();
    }

    @Override
    public String getJustification() {
        return "Current Goal " + currentGoal.getAtomicSentence().toString()
                + ", " + bindings;
    }
    // END-ProofStep
    //
}
