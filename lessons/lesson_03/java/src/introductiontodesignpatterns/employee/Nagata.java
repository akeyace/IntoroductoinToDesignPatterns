package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.Answer;

public class Nagata extends PEEmployee {
	final private static Nagata self = new Nagata();

	private Nagata() {
	}

	public static Nagata call() {
		answer = new Answer();

		return self;
	}
}
