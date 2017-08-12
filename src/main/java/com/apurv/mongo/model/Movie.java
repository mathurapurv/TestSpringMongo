package com.apurv.mongo.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="imdb")
public class Movie {

	private Long movieId;
	private String movieName;
	private Date releaseDate;
	private String language;
	private boolean isNetflixAvailable = false;
	private String description;

	
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
