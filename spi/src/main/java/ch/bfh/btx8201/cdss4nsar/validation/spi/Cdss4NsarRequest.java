package ch.bfh.btx8201.cdss4nsar.validation.spi;

public class Cdss4NsarRequest {
	
	final String requestId;
	
	// Labor
	private int bloodPlateValue = -1;
	private double creatinineSerum = 0.00;
	private int creatinineClearance = -1;
	private double inr = 0.00;
	
	//Person
	private char sex = 'u';
	private boolean pregnant = false;
	private boolean onStereoids = false;
	private int age = -1;
	
	//Procedures
	private String procedure;
	
	
	public Cdss4NsarRequest(){
		requestId = "";
	}

	public String getId() {
		return requestId;
	}

	public int getBloodPlateValue() {
		return bloodPlateValue;
	}

	public void setBloodPlateValue(int bloodPlateValue) {
		this.bloodPlateValue = bloodPlateValue;
	}

	public double getCreatinineSerum() {
		return creatinineSerum;
	}

	public void setCreatinineSerum(double creatinineSerum) {
		this.creatinineSerum = creatinineSerum;
	}

	public int getCreatinineClearance() {
		return creatinineClearance;
	}

	public void setCreatinineClearance(int creatinineClearance) {
		this.creatinineClearance = creatinineClearance;
	}

	public double getInr() {
		return inr;
	}

	public void setInr(double inr) {
		this.inr = inr;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void isPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	public boolean isOnStereoids() {
		return onStereoids;
	}

	public void isOnStereoids(boolean onStereoids) {
		this.onStereoids = onStereoids;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getRequestId() {
		return requestId;
	}
	
	
}
