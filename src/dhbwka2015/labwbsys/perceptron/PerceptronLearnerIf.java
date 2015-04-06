package dhbwka2015.labwbsys.perceptron;

import java.util.ArrayList;

public interface PerceptronLearnerIf {
	public boolean learn(Perceptron learnObject, ArrayList<LearnInstance> samples);

}
