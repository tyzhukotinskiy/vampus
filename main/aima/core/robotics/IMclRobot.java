package main.aima.core.robotics;

import main.aima.core.robotics.datatypes.IMclMove;
import main.aima.core.robotics.datatypes.IMclRangeReading;
import main.aima.core.robotics.datatypes.IMclVector;
import main.aima.core.robotics.datatypes.RobotException;

/**
 * This interface defines functionality a robotic agent has to implement in order to localize itself via {@link MonteCarloLocalization}.
 *
 * @param <V> an n-1-dimensional vector implementing {@link IMclVector}, where n is the dimensionality of the environment.
 * @param <M> a movement (or sequence of movements) of the robot, implementing {@link IMclMove}.
 * @param <R> a range measurement, implementing {@link IMclRangeReading}.
 * @author Arno von Borries
 * @author Jan Phillip Kretzschmar
 * @author Andreas Walscheid
 */
public interface IMclRobot<V extends IMclVector, M extends IMclMove<M>, R extends IMclRangeReading<R, V>> {
    /**
     * Causes a series of sensor measurements to determine the distance to various obstacles within the environment.
     *
     * @return an array of range measurements {@code <R>}.
     * @throws RobotException thrown if the range reading was not successful.
     */
    R[] getRangeReadings() throws RobotException;

    /**
     * Causes the robot to perform a movement.
     *
     * @return the move the robot performed.
     * @throws RobotException thrown if the move was not successful.
     */
    M performMove() throws RobotException;
}
