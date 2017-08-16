package introductiontodesignpatterns.proengineer;

import java.util.ArrayList;

import introductiontodesignpatterns.employee.PEEmployee;
import introductiontodesignpatterns.enums.QuestionType;
import introductiontodesignpatterns.project.Project;

public abstract class ProEngineer {
	protected PEEmployee currentPeEmployee;
	protected ArrayList<PEEmployee> employeeList = new ArrayList<>();
	private Project currentProject;

	public void recieveProject(PEEmployee peEmployee, Project project) {
		currentPeEmployee = peEmployee;
		setCurrentProject(project);
	}

	public void agreeProject() {
		if (getCurrentProject() == null) {
			System.out.println("提案されている案件はありません");
		} else {
			currentPeEmployee.assignProject(this);
		}
	}

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	public String askToEmployee(QuestionType qType) {
		return PEEmployee.ask(qType);
	}
}
