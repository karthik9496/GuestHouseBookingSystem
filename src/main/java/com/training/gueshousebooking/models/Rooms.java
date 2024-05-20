package com.training.gueshousebooking.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Rooms {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "book_jpa_sequence_generator")
	@SequenceGenerator(name = "book_jpa_sequence_generator", sequenceName = "book_id_seq", allocationSize = 1)
	private int id;

	private int roomNo;

	private char roomType;

	private boolean isAlloted;

	@JoinColumn(name = "fk_guest_house", referencedColumnName = "id")
	@ManyToOne()
	GuestHouse guestHouse;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public char getRoomType() {
		return roomType;
	}

	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}

	public boolean isAlloted() {
		return isAlloted;
	}

	public void setAlloted(boolean isAlloted) {
		this.isAlloted = isAlloted;
	}

	public GuestHouse getGuestHouse() {
		return guestHouse;
	}

	public void setGuestHouse(GuestHouse guestHouse) {
		this.guestHouse = guestHouse;
	}

}
