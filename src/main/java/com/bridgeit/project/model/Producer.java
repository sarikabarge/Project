package com.bridgeit.project.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


@Entity
@Component
public class Producer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
    private long producerId;
	private String producerName;
	private String Gender;
	private Date DOB;
	private String bio;
	public long getProducerId() {
		return producerId;
	}
	public void setProducerId(long producerId) {
		this.producerId = producerId;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDOB() {
		return DOB;
	} 
	public void setDOB(Date date) {
		DOB = date;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Movie> movies;

	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	@Override
	public String toString() {
		return "Producer [producerId=" + producerId + ", producerName=" + producerName + ", Gender=" + Gender + ", DOB="
				+ DOB + ", bio=" + bio + ", movies=" + movies + "]";
	}
	
}
