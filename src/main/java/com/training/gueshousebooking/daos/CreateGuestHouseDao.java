package com.training.gueshousebooking.daos;

public class CreateGuestHouseDao {

	private int officeId;
	private String guestHouseName;
	private char roomType;
	private int totalRooms;

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	
	public String getGuestHouseName() {
		return guestHouseName;
	}

	public void setGuestHouseName(String guestHouseName) {
		this.guestHouseName = guestHouseName;
	}

	public char getRoomType() {
		return roomType;
	}

	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

}
