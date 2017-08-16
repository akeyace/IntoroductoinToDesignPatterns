package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.AnswerProxy;

public class Nagata extends PEEmployee {
	final private static Nagata self = new Nagata();

	private Nagata() {
		System.out.println("--- 永田さんインスタンス生成 ---");
		answer = new AnswerProxy();
	}

	public static Nagata call() {
		return self;
	}
}
