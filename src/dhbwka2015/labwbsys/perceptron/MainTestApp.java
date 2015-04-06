package dhbwka2015.labwbsys.perceptron;

import java.util.ArrayList;

public class MainTestApp {

	// Hardcoded perceptron similar to example on slides.
	private static void testHardcodedPerceptron() {
		Perceptron p = new Perceptron(2, null);
		p.setThreshold(0.25);
		p.setWeight(1, 0.5);
		p.setWeight(2, 0.5);

		System.out.println(p);

		double in[] = new double[2];

		in[0] = -1.0;
		in[1] = -1.0;
		System.out.println("0 || 0  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = -1.0;
		System.out.println("0 || 1  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = -1.0;
		in[1] = 1.0;
		System.out.println("1 || 0  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = 1.0;
		System.out.println("1 || 1  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));
	}

	private static void testPerceptronLearning() {

		System.out.println(" Test complete learning algorithm");

		Perceptron p = new Perceptron(2, new RandomWeightSetter());
		p.name = "OR-Operator";
		System.out.println(p);
		ArrayList<LearnInstance> samples = new ArrayList<LearnInstance>();

		samples.add(new LearnInstance(false, new double[] { 0.0, 0.0 }));
		samples.add(new LearnInstance(true, new double[] { 0.0, 1.0 }));
		samples.add(new LearnInstance(true, new double[] { 1.0, 0.0 }));
		samples.add(new LearnInstance(true, new double[] { 1.0, 1.0 }));

		p.learn(samples);

		System.out.println("Final Perceptron:");
		System.out.println(p);

		double in[] = new double[2];

		in[0] = 0;
		in[1] = 0;
		System.out.println("0 || 0  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = 0;
		System.out.println("0 || 1  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 0;
		in[1] = 1.0;
		System.out.println("1 || 0  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = 1.0;
		System.out.println("1 || 1  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testHardcodedPerceptron();

		testPerceptronLearning();
	}
}
