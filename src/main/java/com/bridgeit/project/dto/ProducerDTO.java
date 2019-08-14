package com.bridgeit.project.dto;
import java.sql.Date;
import java.time.LocalDateTime;


public class ProducerDTO {

	private String producerName;
	private String gender;
	private Date DOB;
	private String bio;

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dateTime) {
		DOB = dateTime;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
	
}
