package com.yash.mba.domain;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "seat")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "seat_id")
  private Long id;

  @Column(name = "seat_number")
  private Integer seatNumber;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "auditorium_id")
  @JsonManagedReference
  private Auditorium auditorium;

//  @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
//  @JsonBackReference
//  private Set<SeatBooked> bookedSeats;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getSeatNumber() {
	return seatNumber;
}

public void setSeatNumber(Integer seatNumber) {
	this.seatNumber = seatNumber;
}

public Auditorium getAuditorium() {
	return auditorium;
}

public void setAuditorium(Auditorium auditorium) {
	this.auditorium = auditorium;
}

//public Set<SeatBooked> getBookedSeats() {
//	return bookedSeats;
//}
//
//public void setBookedSeats(Set<SeatBooked> bookedSeats) {
//	this.bookedSeats = bookedSeats;
//}

@Override
public String toString() {
	return "Seat [id=" + id + ", seatNumber=" + seatNumber + ", auditorium=" + auditorium + ", bookedSeats="
			+ "]";
}

public Seat() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
