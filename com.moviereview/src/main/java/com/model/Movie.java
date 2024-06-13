package com.model;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieLanguage;
	private int movieYear;
	private String movieGenre;
	private int castId;
	private String trailerUrl;
	private String smallPoster;
	private String desc;
	private String actors;
	private String director;
	private String production;
	private String writer;
	private double rating;
	
	

	public Movie() {
		super();
	}
	
	public Movie(int movieId, String movieName, String movieLanguage, int movieYear, String movieGenre,
			String trailerUrl) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		
		this.trailerUrl = trailerUrl;
	}

	public Movie(String movieName, String movieLanguage, int movieYear, String movieGenre, String trailerUrl) {
		super();
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		this.trailerUrl = trailerUrl;
	}

	
	
	public Movie(String movieName, String movieLanguage, int movieYear, String movieGenre, int castId,
			String trailerUrl) {
		super();
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		this.castId = castId;
		this.trailerUrl = trailerUrl;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Movie(int movieId, String movieName, String movieLanguage, int movieYear, String movieGenre, 
			String trailerUrl, String smallPoster, double rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
	
		this.trailerUrl = trailerUrl;
		this.smallPoster = smallPoster;
		this.rating = rating;
	}

	public String getSmallPoster() {
		return smallPoster;
	}

	public void setSmallPoster(String smallPoster) {
		this.smallPoster = smallPoster;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Movie(String movieName, String movieLanguage, int movieYear, String movieGenre, 
			String trailerUrl, String smallPoster, String desc, String actors, String director, String production,
			String writer, double rating) {
		super();
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		
		this.trailerUrl = trailerUrl;
		this.smallPoster = smallPoster;
		this.desc = desc;
		this.actors = actors;
		this.director = director;
		this.production = production;
		this.writer = writer;
		this.rating = rating;
	}

	public Movie(int movieId, String movieName, String movieLanguage, int movieYear, String movieGenre, 
			String trailerUrl, String smallPoster, String desc, String actors, String director, String production,
			String writer, double rating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
		
		this.trailerUrl = trailerUrl;
		this.smallPoster = smallPoster;
		this.desc = desc;
		this.actors = actors;
		this.director = director;
		this.production = production;
		this.writer = writer;
		this.rating = rating;
	}

}
