package introductiontodesignpatterns.workinformation;

public class WorkInformationWithMemo extends WorkInformationDecorator {
	public WorkInformationWithMemo(WorkInformation workInformation, String memo) {
		this.workInformation = workInformation;
		setOptions("memo", memo);

	}
}
