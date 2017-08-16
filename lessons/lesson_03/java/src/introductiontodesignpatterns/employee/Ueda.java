package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.Answer;

public class Ueda extends PEEmployee {
	final private static Ueda self = new Ueda();

	private Ueda() {
	}

	public static Ueda call() {
		answer = new Answer();

		return self;
	}
}
