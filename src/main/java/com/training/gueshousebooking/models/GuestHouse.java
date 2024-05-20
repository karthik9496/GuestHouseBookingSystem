package com.training.gueshousebooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class GuestHouse {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	String name;

	char roomType;
	
	int roomsTotal;
	
	int roomsBooked;
	
	@JoinColumn(name = "fk_office", referencedColumnName = "id")
	@ManyToOne()
	Office office;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public char getRoomType() {
		return roomType;
	}

	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}

	public int getRoomsTotal() {
		return roomsTotal;
	}

	public void setRoomsTotal(int roomsTotal) {
		this.roomsTotal = roomsTotal;
	}

	public int getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

}
