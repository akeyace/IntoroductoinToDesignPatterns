package introductiontodesignpatterns.employee;

import introductiontodesignpatterns.workinformation.WorkInformation;

interface Employee {
	static Employee call() {
		return null;
	};

	void setWorkInformation(Number id, String workName, String detail);

	void passWorkInfo(Number id, Employee employee);

	void recieveWorkInfo(Number id, WorkInformation workInformation);
}
