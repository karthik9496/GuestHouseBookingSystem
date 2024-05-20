package com.training.gueshousebooking.daos;

import com.training.gueshousebooking.models.GuestHouse;

public class GuestHouseDao {

	private int id;

	String name;

	char roomType;

	int roomsTotal;

	int roomsBooked;

	String officeName;

	public GuestHouseDao(GuestHouse guestHouse) {
		this.id = guestHouse.getId();
		this.name = guestHouse.getName();
		this.roomType = guestHouse.getRoomType();
		this.roomsTotal = guestHouse.getRoomsTotal();
		this.roomsBooked = guestHouse.getRoomsBooked();
		this.officeName = guestHouse.getOffice().getName();
	}

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

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

}
