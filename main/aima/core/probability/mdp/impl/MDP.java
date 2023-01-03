package main.aima.core.probability.mdp.impl;

import main.aima.core.agent.Action;
import main.aima.core.probability.mdp.ActionsFunction;
import main.aima.core.probability.mdp.MarkovDecisionProcess;
import main.aima.core.probability.mdp.RewardFunction;
import main.aima.core.probability.mdp.TransitionProbabilityFunction;

import java.util.Set;

/**
 * Default implementation of the MarkovDecisionProcess<S, A> interface.
 *
 * @param <S> the state type.
 * @param <A> the action type.
 * @author Ciaran O'Reilly
 * @author Ravi Mohan
 */
public class MDP<S, A extends Action> implements MarkovDecisionProcess<S, A> {
    private Set<S> states = null;
    private S initialState = null;
    private ActionsFunction<S, A> actionsFunction = null;
    private TransitionProbabilityFunction<S, A> transitionProbabilityFunction = null;
    private RewardFunction<S> rewardFunction = null;

    public MDP(Set<S> states, S initialState,
               ActionsFunction<S, A> actionsFunction,
               TransitionProbabilityFunction<S, A> transitionProbabilityFunction,
               RewardFunction<S> rewardFunction) {
        this.states = states;
        this.initialState = initialState;
        this.actionsFunction = actionsFunction;
        this.transitionProbabilityFunction = transitionProbabilityFunction;
        this.rewardFunction = rewardFunction;
    }

    //
    // START-MarkovDecisionProcess
    @Override
    public Set<S> states() {
        return states;
    }

    @Override
    public S getInitialState() {
        return initialState;
    }

    @Override
    public Set<A> actions(S s) {
        return actionsFunction.actions(s);
    }

    @Override
    public double transitionProbability(S sDelta, S s, A a) {
        return transitionProbabilityFunction.probability(sDelta, s, a);
    }

    @Override
    public double reward(S s) {
        return rewardFunction.apply(s);
    }

    // END-MarkovDecisionProcess
    //
}
