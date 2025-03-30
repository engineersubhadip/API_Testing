package POJO_Basics_4_ComplexNestedJSON;

import java.util.List;

public class Employee_Pojo {

	private String companyName;
	private String street;
	private String city;
	private int pincode;
	private List<String> bankAccounts;
	private List<Employee> employees;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public List<String> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<String> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
