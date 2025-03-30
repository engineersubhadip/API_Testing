package POJO_Deserialization;

public class Parent {
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Courses_Child courses; // We are plugging in the object of Courses_Child inside the Parent JSON
	private String linkedin;

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Courses_Child getCourses() {
		return courses;
	}

	public void setCourses(Courses_Child courses) {
		this.courses = courses;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
}
