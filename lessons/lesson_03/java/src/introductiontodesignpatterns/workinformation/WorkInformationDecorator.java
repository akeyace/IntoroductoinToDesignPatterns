package introductiontodesignpatterns.workinformation;

import java.util.HashMap;

abstract class WorkInformationDecorator implements WorkInformation {
	protected WorkInformation workInformation;

	public void setWorkInformation(String workName, String detail) {
		workInformation.setWorkInformation(workName, detail);
	}

	public String getWorkName() {
		return workInformation.getWorkName();
	}

	public void setWorkName(String workName) {
		workInformation.setWorkName(workName);
	}

	public String getDetail() {
		return workInformation.getDetail();
	}

	public void setDetail(String detail) {
		workInformation.setDetail(detail);
	}

	public HashMap<String, String> getOptions() {
		return workInformation.getOptions();
	}

	public void setOptions(String key, String value) {
		workInformation.setOptions(key, value);
	}
}
