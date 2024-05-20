package com.training.gueshousebooking.daos;

import com.training.gueshousebooking.models.BookingRequest;

public class OfficeBookingRequestDao {

	private int bookingId;
	
	private String userName;
	
	private String officeName;
	
	private String guestHouseName;
	
	private int roomsRequested;
	
	private int roomsAvailable;
	
	boolean isApproved;
	
	boolean isActive;
	
	private char roomType;
	

	
	public char getRoomType() {
		return roomType;
	}

	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getGuestHouseName() {
		return guestHouseName;
	}

	public void setGuestHouseName(String guestHouseName) {
		this.guestHouseName = guestHouseName;
	}

	public int getRoomsAvailable() {
		return roomsAvailable;
	}

	public void setRoomsAvailable(int roomsAvailable) {
		this.roomsAvailable = roomsAvailable;
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
	

	public int getRoomsRequested() {
		return roomsRequested;
	}

	public void setRoomsRequested(int roomsRequested) {
		this.roomsRequested = roomsRequested;
	}

	public OfficeBookingRequestDao(BookingRequest bookingRequest) {
		super();
		this.bookingId = bookingRequest.getId();
		this.userName = bookingRequest.getUser().getName();
		this.officeName = bookingRequest.getGuestHouse().getOffice().getName();
		this.guestHouseName = bookingRequest.getGuestHouse().getName();
		this.isApproved = bookingRequest.isApproved();
		this.isActive = bookingRequest.isActive();
		this.roomsRequested = bookingRequest.getRoomsRequested();
		this.roomType = bookingRequest.getGuestHouse().getRoomType();
	}
	
}
