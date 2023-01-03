package main.aima.core.logic.fol.inference.otter;

import main.aima.core.logic.fol.kb.data.Clause;

/**
 * @author Ciaran O'Reilly
 */
public interface ClauseSimplifier {
    Clause simplify(Clause c);
}
