package ch.bfh.btx8201.cdss4nsar.domain;

public class CdssRequest {
	
	String id;
	int heartRate;
	int bloodPressure;
	
	public CdssRequest(){
		id = "";
		heartRate= 0;
		bloodPressure = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	

	
}
