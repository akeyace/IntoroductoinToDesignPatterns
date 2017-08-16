package introductiontodesignpatterns.project;

import java.util.ArrayList;

import introductiontodesignpatterns.enums.ProjectStatus;
import introductiontodesignpatterns.proengineer.ProEngineer;

public abstract class Project {
	private ProjectStatus status;
	public ArrayList<ProEngineer> assignedEngineers = new ArrayList<>();

	public Project() {
		status = ProjectStatus.PROPOSED_IN;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public void assignEngineer(ProEngineer engineer) {
		assignedEngineers.add(engineer);
	}
}
