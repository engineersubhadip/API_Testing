package POJO_Deserialization;

import java.util.List;

public class Courses_Child {
	private List<webAutomation_Child> webAutomation;
	private List<api_Child> api;
	private List<mobile_Child> mobile;

	public List<webAutomation_Child> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<webAutomation_Child> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<api_Child> getApi() {
		return api;
	}

	public void setApi(List<api_Child> api) {
		this.api = api;
	}

	public List<mobile_Child> getMobile() {
		return mobile;
	}

	public void setMobile(List<mobile_Child> mobile) {
		this.mobile = mobile;
	}
}
