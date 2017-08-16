package introductiontodesignpatterns.answer;

import introductiontodesignpatterns.dao.AnswerDao;

public class Answer {
	private AnswerDao answerDao = new AnswerDao();

	public String getCompany() {
		return answerDao.getResouce("company");
	}

	public String getAddressTokyo() {
		return answerDao.getResouce("address_tokyo");
	}

	public String getAddressOsaka() {
		return answerDao.getResouce("address_osaka");
	}

	public String getHolyday() {
		return answerDao.getResouce("holyday");
	}

	public String getEvents() {
		return answerDao.getResouce("events");
	}

	public String getStudyMeeting() {
		return answerDao.getResouce("study_meeting");
	}
}