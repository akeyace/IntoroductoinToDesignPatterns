package introductiontodesignpatterns.workinformation;

public class WorkInformationNagata extends WorkInformationDecorator {

	public WorkInformationNagata(WorkInformation workInformation) {
		System.out.println("teeeee");
		this.workInformation = workInformation;
		this.workInformation.setWorkName(workInformation.getWorkName() + "[永田案件]");
	}

	public WorkInformation priceUp(Double priceUpRate) {
		this.workInformation.setOptions("単価", String
				.valueOf(Math.round(Integer.parseInt(this.workInformation.getOptions().get("単価")) * priceUpRate)));
		return this;
	}

	public String getDetail() {
		return workInformation.getDetail() + " オススメの案件です！";
	}
}
