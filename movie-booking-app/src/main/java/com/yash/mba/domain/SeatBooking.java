package com.yash.mba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "seat_booking")
public class SeatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_booking_id")
	private long id;
	
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name = "screening_id")
	  @JsonManagedReference
	  private Screening screening;
	  
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name = "seat_id")
	  @JsonManagedReference
	  private Seat seat;
	  
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name = "user_id")
	  @JsonManagedReference
	  private User user;

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the screening
	 */
	public Screening getScreening() {
		return screening;
	}

	/**
	 * @param screening the screening to set
	 */
	public void setScreening(Screening screening) {
		this.screening = screening;
	}

	/**
	 * @return the seat
	 */
	public Seat getSeat() {
		return seat;
	}

	/**
	 * @param seat the seat to set
	 */
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

//	/**
//	 * @return the user
//	 */
//	public User getUser() {
//		return user;
//	}
//
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(User user) {
//		this.user = user;
//	}

	public SeatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SeatBooking [id=" + id + ", screening=" + screening + ", seat=" + seat + ", user=" + user + "]";
	}

	
	  
}
