package introductiontodesignpatterns.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import introductiontodesignpatterns.answer.Answer;
import introductiontodesignpatterns.answer.RealAnswer;
import introductiontodesignpatterns.enums.ProjectStatus;
import introductiontodesignpatterns.enums.QuestionType;
import introductiontodesignpatterns.proengineer.ProEngineer;
import introductiontodesignpatterns.project.Project;
import introductiontodesignpatterns.workinformation.WorkInformation;

public abstract class PEEmployee implements Employee {
	protected HashMap<Number, WorkInformation> workInformations = new HashMap<>();
	protected Employee employee;
	protected ArrayList<ProEngineer> proEngineers = new ArrayList<>();
	protected static Answer answer;

	static PEEmployee call() {
		return null;
	};

	public void proposalProject(ProEngineer proEngineer, Project project) {
		proEngineer.recieveProject(this, project);
	}

	public void assignProject(ProEngineer proEngineer) {
		proEngineers.add(proEngineer);
		proEngineer.getCurrentProject().assignEngineer(proEngineer);
		proEngineer.getCurrentProject().setStatus(ProjectStatus.CONTRACT);
	}

	public void setWorkInformation(Number id, String workName, String detail) {
		workInformations.put(id, new WorkInformation(workName, detail));
	}

	public void passWorkInfo(Number id, Employee employee) {
		System.out.println("案件受け渡し 案件ID: " + id.toString());
		employee.recieveWorkInfo(id, workInformations.get(id));
	}

	public void recieveWorkInfo(Number id, WorkInformation workInformation) {
		this.workInformations.put(id, workInformation);
	}

	public ArrayList<String> getWorkInfo(Number id) {
		WorkInformation workInformation = workInformations.get(id);

		return new ArrayList<String>(Arrays.asList(workInformation.getWorkName(), workInformation.getDetail()));
	}

	public static String ask(QuestionType qType) {
		if (answer == null) {
			answer = new RealAnswer();
		}

		switch (qType) {
		case COMPANY:
			return answer.getCompany();
		case ADDRESS_TOKYO:
			return answer.getAddressTokyo();
		case ADDRESS_OSAKA:
			return answer.getAddressOsaka();
		case HOLIDAY:
			return answer.getHolyday();
		case EVENTS:
			return answer.getEvents();
		case STUDY_MEETING:
			return answer.getStudyMeeting();
		}
		return "回答できませんでした";
	}
}
