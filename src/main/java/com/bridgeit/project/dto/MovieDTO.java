package com.bridgeit.project.dto;

public class MovieDTO {

	private String movieName;
	private long yearOfRelease;
	private String poster;
	private String plot;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public long getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(long yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
	
}
