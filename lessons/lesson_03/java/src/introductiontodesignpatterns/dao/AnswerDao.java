package introductiontodesignpatterns.dao;

public class AnswerDao {

	/*
	 * DB に接続して値を取得する
	 *
	 * ※ DB にアクセスしている体
	 */
	public String getResouce(String resouceName) {
		System.out.println("--- データベースにアクセスします ---");
		switch (resouceName) {
		case "company":
			return "PE-BANK";
		case "address_tokyo":
			return "東京都港区高輪";
		case "address_osaka":
			return "大阪府大阪市中央区北浜";
		case "holyday":
			return "今月は8/11 (金) が国民の休日です";
		case "events":
			return "今月はビアガーデンがあります";
		case "study_meeting":
			return "毎週土曜日に勉強会があります";
		}

		return "Not Found";
	}
}