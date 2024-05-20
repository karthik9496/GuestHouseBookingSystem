package com.training.gueshousebooking.daos;

public class CreateBookingRequestDao {

	private int userId;
	
	private int guestHouseId;
	
	private int roomsRequested;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGuestHouseId() {
		return guestHouseId;
	}

	public void setGuestHouseId(int guestHouseId) {
		this.guestHouseId = guestHouseId;
	}

	public int getRoomsRequested() {
		return roomsRequested;
	}

	public void setRoomsRequested(int roomsRequested) {
		this.roomsRequested = roomsRequested;
	}
	
	
}
