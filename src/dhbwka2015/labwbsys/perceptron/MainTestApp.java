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

	private static void testPerceptronLearningOr() {

		System.out.println(" Test complete learning algorithm");

		Perceptron p = new Perceptron(2, new MyWeightSetter());
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


	private static void hardcodedPerceptron(double threshold, double w1, double w2){
		Perceptron p = new Perceptron(2, null);
		p.setThreshold(threshold);
		p.setWeight(1, w1);
		p.setWeight(2, w2);

		double in[] = new double[2];

		in[0] = -1.0;
		in[1] = -1.0;
		System.out.println(in[0] + " || " + in[1] + "  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = -1.0;
		in[1] = 1.0;
		System.out.println(in[0] +" || " + in[1] +"  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = -1.0;
		System.out.println(in[0] +" || " + in[1] +"  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));

		in[0] = 1.0;
		in[1] = 1.0;
		System.out.println(in[0] +" || " + in[1] +"  => " + p.calculateRawResult(in) + "  ==>  "
				+ p.calcStepResult(in));
	}

	private static void testHardcodedPerceptronXOR() {
		Perceptron p = new Perceptron(2, null);
		Perceptron p1 = new Perceptron(2, null);
		Perceptron p2 = new Perceptron(2, null);
		p.setThreshold(-0.25);
		p.setWeight(1, 0.5);
		p.setWeight(2, 0.5);

		p1.setThreshold(0.25);
		p1.setWeight(1, 1);
		p1.setWeight(2, -1);

		hardcodedPerceptron(p1.getThreshold(), p1.getWeight(1), p1.getWeight(2));

		p2.setThreshold(0.25);
		p2.setWeight(1, -1);
		p2.setWeight(2, 1);

		hardcodedPerceptron(p2.getThreshold(), p2.getWeight(1), p2.getWeight(2));

		System.out.println(p);

		double in[] = new double[2];
		double pr[] = new double[2];

		in[0] = -1.0;
		in[1] = -1.0;
		pr[0] = p1.calcStepResult(in);
		pr[1] = p2.calcStepResult(in);
		System.out.println("0 || 0  => " + p.calculateRawResult(pr) + "  ==>  "
				+ p.calcStepResult(pr));

		in[0] = 1.0;
		in[1] = -1.0;
		pr[0] = p1.calcStepResult(in);
		pr[1] = p2.calcStepResult(in);
		System.out.println("1 || 0  => " + p.calculateRawResult(pr) + "  ==>  "
				+ p.calcStepResult(pr));

		in[0] = -1.0;
		in[1] = 1.0;
		pr[0] = p1.calcStepResult(in);
		pr[1] = p2.calcStepResult(in);
		System.out.println("0 || 1  => " + p.calculateRawResult(pr) + "  ==>  "
				+ p.calcStepResult(pr));

		in[0] = 1.0;
		in[1] = 1.0;
		pr[0] = p1.calcStepResult(in);
		pr[1] = p2.calcStepResult(in);
		System.out.println("1 || 1  => " + p.calculateRawResult(pr) + "  ==>  "
				+ p.calcStepResult(pr));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testHardcodedPerceptron();

		//testPerceptronLearningOr();

		testHardcodedPerceptronXOR();
	}
}
