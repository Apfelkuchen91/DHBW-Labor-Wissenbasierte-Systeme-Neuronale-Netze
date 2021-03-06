package dhbwka2015.labwbsys.perceptron;

import java.util.ArrayList;

public class Perceptron {
	public String name = "";
	private int size = 0;
	private PerceptronLearnerIf learner = null;
	private double weights[] = null;
	private double input[] = null;
	
	public static double ON = 1.0;
	public static double OFF = -1.0;

	public Perceptron(int inputsCount, PerceptronLearnerIf learner) {
		size = inputsCount + 1;
		this.learner = learner;
		
		weights = new double[size];
		input = new double[size];
	}

	public int getInputCount(){
		return size - 1;
	}
	
	public double getWeight(int index){
		if (index < 1 || index > size){
			return Double.NaN;
		}
		
		return weights[index];
	}
	
	public boolean setWeight(int index, double weight) {

		if (index < 0 || index > size) {
			return false;
		}

		weights[index] = weight;

		return true;
	}
	
	public boolean updateWeightAdditive(int index, double addFactor){
		if (index < 0 || index > size) {
			return false;
		}

		weights[index] += addFactor;

		return true;
		
	}

	public double getThreshold(){
		return weights[0];
	}
	
	public void setThreshold(double threshold) {
		weights[0] = -threshold;
	}

	public void updateThresholdAdditive(double addFactor){
		weights[0] += addFactor;
	}
	
	public double calcStepResult(double[] newInputs) {
		double res;

		if (calculateRawResult(newInputs) > 0) {
			res = ON;
		} else {
			res = OFF;
		}

		return res;
	}

	public double calculateRawResult(double[] newInputs) {
		if (newInputs.length != size - 1) {
			return Double.NaN;
		}

		setNewInput(newInputs);

		return scalarProduct(weights, input);
	}

	public boolean learn(ArrayList<LearnInstance> samples){
		if (learner == null){ return false; }
		
		return learner.learn(this, samples);
	}
	
	private void setNewInput(double[] newinput) {
		input[0]  =  1;

		for(int i = 0; i < newinput.length; i++){
			input[i+1] = newinput[i];
		}
	}

	private double scalarProduct(double[] a, double[] b)
	{
		if(a.length != b.length) {
			return Double.NaN;
		}
		double res = 0.0;

		for(int i = 0; i < a.length; i++){
			res += a[i] * b[i];
		}

		return res;
	}


	public String toString() {
		String res = "Perceptron \"" + name + "\"\n";

		res += "Weights: ";
		for (int i = 0; i < weights.length; ++i) {
			res += "  " + weights[i];
		}

		return res;
	}
}
