package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.Answer;

public class Nagata extends PEEmployee {
	final private static Nagata self = new Nagata();

	private Nagata() {
		System.out.println("--- 永田さんインスタンス生成 ---");
		answer = new Answer();
	}

	public static Nagata call() {
		return self;
	}
}
