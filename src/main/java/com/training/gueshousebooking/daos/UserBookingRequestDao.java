package com.training.gueshousebooking.daos;

import com.training.gueshousebooking.models.BookingRequest;

public class UserBookingRequestDao {

	private int bookingId;

	private String guestHouseName;

	private int roomsBooked;

	boolean isApproved;
	
	boolean isActive;
	
	char roomType;
	
	String status;

	public UserBookingRequestDao(BookingRequest bookingRequest) {
		super();
		this.bookingId = bookingRequest.getId();
		this.guestHouseName = bookingRequest.getGuestHouse().getName();
		this.roomsBooked = bookingRequest.getRoomsRequested();
		this.isApproved = bookingRequest.isApproved();
		this.isActive = bookingRequest.isActive();
		this.roomType = bookingRequest.getGuestHouse().getRoomType();
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getGuestHouseName() {
		return guestHouseName;
	}

	public void setGuestHouseName(String guestHouseName) {
		this.guestHouseName = guestHouseName;
	}

	public int getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(int roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public char getRoomType() {
		return roomType;
	}

	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
