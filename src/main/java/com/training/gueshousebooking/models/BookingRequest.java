package com.training.gueshousebooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class BookingRequest {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean isApproved;

	private int roomsRequested;
	
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "fk_usr", referencedColumnName = "id")
	User user;

	@ManyToOne
	@JoinColumn(name = "fk_guest_house", referencedColumnName = "id")
	GuestHouse guestHouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getRoomsRequested() {
		return roomsRequested;
	}

	public void setRoomsRequested(int roomsRequested) {
		this.roomsRequested = roomsRequested;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GuestHouse getGuestHouse() {
		return guestHouse;
	}

	public void setGuestHouse(GuestHouse guestHouse) {
		this.guestHouse = guestHouse;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
