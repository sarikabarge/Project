package com.bridgeit.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity

public class Actor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long actorId;
	private String name;
	private String gender;
	private Date DOB;
	private String bio;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy ="actors")
	//@ManyToMany()
	private List<Movie> movies;
	public long getActorId() {
		return actorId;
	}


	public void setActorId(long actorId) {
		this.actorId = actorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		movies = movies;
	}


	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + name + ", gender=" + gender + ", DOB=" + DOB + ", bio=" + bio
				+ ", Movies=" + movies + "]";
	}


	
	

	
	
}
