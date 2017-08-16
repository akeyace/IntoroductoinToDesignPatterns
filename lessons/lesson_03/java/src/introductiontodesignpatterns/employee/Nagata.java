package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.answer.AnswerProxy;
import introductiontodesignpatterns.workinformation.ConcreteWorkInformation;
import introductiontodesignpatterns.workinformation.WorkInformationNagata;
import introductiontodesignpatterns.workinformation.WorkInformationWithMemo;
import introductiontodesignpatterns.workinformation.WorkInformationWithPrice;

public class Nagata extends PEEmployee {
	final private static Nagata self = new Nagata();

	private Nagata() {
		System.out.println("--- 永田さんインスタンス生成 ---");
		answer = new AnswerProxy();
	}

	public static Nagata call() {
		return self;
	}

	public void setWorkInformation(Number id, String workName, String detail, String memo, Number price) {
		workInformations.put(id,
				new WorkInformationNagata(new WorkInformationWithPrice(
						new WorkInformationWithMemo(new ConcreteWorkInformation(workName, detail), memo), price))
								.priceUp(1.2));
	}
}
