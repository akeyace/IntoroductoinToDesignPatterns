package introductiontodesignpatterns.answer;

public class AnswerProxy implements Answer {
	private Answer answer;

	private Answer getAnswer() {
		if (answer == null) {
			answer = new RealAnswer();
		}
		return answer;
	}

	public String getCompany() {
		return "PE-BANKやで";
	}

	public String getAddressTokyo() {
		return getAnswer().getAddressTokyo();
	}

	public String getAddressOsaka() {
		return "北浜やで";
	}

	public String getHolyday() {
		return "8月は山の日が休みやったで";
	}

	public String getEvents() {
		return getAnswer().getEvents();
	}

	public String getStudyMeeting() {
		return "今日 Java の勉強会あるで";
	}
}
