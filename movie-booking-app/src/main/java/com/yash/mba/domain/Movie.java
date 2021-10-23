package com.yash.mba.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "poster")
	private String poster;

	@Column(name = "genre")
	private String genre;

	@Column(name = "duration")
	private Integer duration;

//	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
//	@JsonBackReference
//	private Set<Screening> screenings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

//	public Set<Screening> getScreenings() {
//		return screenings;
//	}
//
//	public void setScreenings(Set<Screening> screenings) {
//		this.screenings = screenings;
//	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", poster=" + poster + ", genre=" + genre + ", duration=" + duration
				+ ", screenings=" + "]";
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, genre, id, poster);
	}



}