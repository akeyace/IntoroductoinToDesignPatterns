package introductiontodesignpatterns.workinformation;

public class WorkInformation {
	String workName;
	String detail;

	public WorkInformation(String workName, String detail) {
		setWorkInformation(workName, detail);
	}

	public void setWorkInformation(String workName, String detail) {
		setWorkName(workName);
		setDetail(detail);
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
