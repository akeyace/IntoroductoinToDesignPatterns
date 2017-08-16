package introductiontodesignpatterns.workinformation;

import java.util.HashMap;

public interface WorkInformation {
	void setWorkInformation(String workName, String detail);

	String getWorkName();

	void setWorkName(String workName);

	String getDetail();

	void setDetail(String detail);

	HashMap<String, String> getOptions();

	void setOptions(String key, String value);
}
