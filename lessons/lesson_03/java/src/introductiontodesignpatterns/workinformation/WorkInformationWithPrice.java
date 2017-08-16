package introductiontodesignpatterns.workinformation;

public class WorkInformationWithPrice extends WorkInformationDecorator {
	public WorkInformationWithPrice(WorkInformation workInformation, Number price) {
		this.workInformation = workInformation;
		setOptions("単価", price.toString());
	}

	public String getDetail() {
		if (Integer.parseInt(workInformation.getOptions().get("単価")) >= 600000) {
			return workInformation.getDetail() + " 高単価案件です";
		} else {
			return workInformation.getDetail();
		}
	}
}
