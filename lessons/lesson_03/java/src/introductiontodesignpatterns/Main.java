package introductiontodesignpatterns;

import introductiontodesignpatterns.employee.Nagata;
import introductiontodesignpatterns.employee.Ueda;
import introductiontodesignpatterns.enums.QuestionType;
import introductiontodesignpatterns.proengineer.Tanaka;
import introductiontodesignpatterns.project.JavaProject;

public class Main {
	public static void main(String[] args) throws Exception {
		// 田中さんのインスタンス生成
		Tanaka tanaka = new Tanaka();

		// 永田さん、新規案件を田中さんに提案
		Nagata.call().proposalProject(tanaka, new JavaProject());
		// 案件の状態確認
		System.out.println(tanaka.getCurrentProject().getStatus());

		// 案件に同意
		tanaka.agreeProject();
		// 案件の状態確認
		System.out.println(tanaka.getCurrentProject().getStatus());

		// 田中さん、永田さんに質問を行う
		System.out.println(tanaka.askToEmployee(QuestionType.ADDRESS_OSAKA));
		System.out.println(tanaka.askToEmployee(QuestionType.ADDRESS_TOKYO));
		System.out.println(tanaka.askToEmployee(QuestionType.STUDY_MEETING));

		// 案件情報をセット
		Nagata.call().setWorkInformation(1, "java案件", "Spring フレームワーク", "働き易い案件", 600000);
		// 案件情報を取得
		System.out.println(Nagata.call().getWorkInfo(1));

		// 案件情報をセット
		Ueda.call().setWorkInformation(2, "python案件", "機械学習");
		// 案件情報を確認
		System.out.println(Ueda.call().getWorkInfo(2));

		// 案件を受け渡す
		Nagata.call().passWorkInfo(1, Ueda.call());
		// 受け渡された案件を確認
		System.out.println(Ueda.call().getWorkInfo(1));
	}
}
