package dhbwka2015.labwbsys.perceptron;

import java.util.ArrayList;
import java.util.Random;

public class MyWeightSetter implements PerceptronLearnerIf {
	Random rn = new Random();
	
	public boolean learn(Perceptron learnObject, ArrayList<LearnInstance> samples) {
		
		learnObject.setThreshold(rn.nextDouble());
		
		for (int i=0; i<learnObject.getInputCount(); ++i){
			learnObject.setWeight(i + 1, rn.nextDouble());
		}
		
		return true;
	}

}
