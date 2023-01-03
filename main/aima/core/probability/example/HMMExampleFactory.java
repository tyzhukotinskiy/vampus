package main.aima.core.probability.example;

import main.aima.core.probability.hmm.HiddenMarkovModel;
import main.aima.core.probability.hmm.impl.HMM;
import main.aima.core.util.math.Matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ciaran O'Reilly
 * @author Ravi Mohan
 */
public class HMMExampleFactory {

    public static HiddenMarkovModel getUmbrellaWorldModel() {
        Matrix transitionModel = new Matrix(new double[][]{{0.7, 0.3},
                {0.3, 0.7}});
        Map<Object, Matrix> sensorModel = new HashMap<Object, Matrix>();
        sensorModel.put(Boolean.TRUE, new Matrix(new double[][]{{0.9, 0.0},
                {0.0, 0.2}}));
        sensorModel.put(Boolean.FALSE, new Matrix(new double[][]{
                {0.1, 0.0}, {0.0, 0.8}}));
        Matrix prior = new Matrix(new double[]{0.5, 0.5}, 2);
        return new HMM(ExampleRV.RAIN_t_RV, transitionModel, sensorModel, prior);
    }
}
