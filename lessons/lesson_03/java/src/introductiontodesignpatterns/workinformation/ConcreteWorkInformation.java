package introductiontodesignpatterns.workinformation;

import java.util.HashMap;

public class ConcreteWorkInformation implements WorkInformation {
	String workName;
	String detail;
	HashMap<String, String> options = new HashMap<>();

	public ConcreteWorkInformation(String workName, String detail) {
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

	public HashMap<String, String> getOptions() {
		return options;
	}

	public void setOptions(String key, String value) {
		options.put(key, value);
	}
}
