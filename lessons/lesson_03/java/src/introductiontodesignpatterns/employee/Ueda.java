package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.Answer;

public class Ueda extends PEEmployee {
	final private static Ueda self = new Ueda();

	private Ueda() {
		System.out.println("--- 上田さんインスタンス生成 ---");
		answer = new Answer();
	}

	public static Ueda call() {
		return self;
	}
}
