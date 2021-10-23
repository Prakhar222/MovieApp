package com.yash.mba.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "screening")
public class Screening {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "screening_id")
  private Long id;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "movie_id")
  @JsonManagedReference
  private Movie movie;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "auditorium_id")
  @JsonManagedReference
  private Auditorium auditorium;
  
//  @ManyToOne
//  @JsonIgnore
//  @JoinColumn(name = "theatre_id")
//  @JsonManagedReference
//  private Theatre theatre;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "start_time")
  private LocalTime startTime;

  @Column(name = "end_time")
  private LocalTime endTime;

  @Column(name = "is_full")
  private Boolean isFull;

  @Column(name = "price")
  private Double price;

//  @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
//  @JsonBackReference
//  private Set<SeatBooked> bookedSeats;
//
//  @OneToMany(mappedBy = "screening", cascade = CascadeType.ALL)
//  @JsonBackReference
//  private Set<Booking> bookings;
  
  

public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}

public Movie getMovie() {
	return movie;
}

public void setMovie(Movie movie) {
	this.movie = movie;
}

public Auditorium getAuditorium() {
	return auditorium;
}

public void setAuditorium(Auditorium auditorium) {
	this.auditorium = auditorium;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}

public LocalTime getStartTime() {
	return startTime;
}

public void setStartTime(LocalTime startTime) {
	this.startTime = startTime;
}

public LocalTime getEndTime() {
	return endTime;
}

public void setEndTime(LocalTime endTime) {
	this.endTime = endTime;
}

public Boolean getIsFull() {
	return isFull;
}

public void setIsFull(Boolean isFull) {
	this.isFull = isFull;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

//public Set<SeatBooked> getBookedSeats() {
//	return bookedSeats;
//}
//
//public void setBookedSeats(Set<SeatBooked> bookedSeats) {
//	this.bookedSeats = bookedSeats;
//}
//
//public Set<Booking> getBookings() {
//	return bookings;
//}
//
//public void setBookings(Set<Booking> bookings) {
//	this.bookings = bookings;
//}


public Screening() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "Screening [id=" + id + ", movie=" + movie + ", auditorium=" + auditorium + ", date=" + date + ", startTime="
			+ startTime + ", endTime=" + endTime + ", isFull=" + isFull + ", price=" + price + "]";
}


}