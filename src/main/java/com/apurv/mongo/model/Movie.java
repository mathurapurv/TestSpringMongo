package com.apurv.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="movies")
public class Movie {

	@Id
	private String id;
	private Long movieId;
	private String movieName;
	private Date releaseDate;
	private String language;
	private boolean isNetflixAvailable = false;
	private String description;

	
	public Movie(Long movieId, String movieName, Date releaseDate, String language, boolean isNetflixAvailable,
			String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.language = language;
		this.isNetflixAvailable = isNetflixAvailable;
		this.description = description;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Field(value="movie_id")
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	@Field(value="movie_name")
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Field(value="release_dt")
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Field(value="language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Field(value="netflix_available")
	public boolean isNetflixAvailable() {
		return isNetflixAvailable;
	}

	public void setNetflixAvailable(boolean isNetflixAvailable) {
		this.isNetflixAvailable = isNetflixAvailable;
	}

	@Field(value="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", language="
				+ language + ", isNetflixAvailable=" + isNetflixAvailable + ", description=" + description + "]";
	}
	

}
