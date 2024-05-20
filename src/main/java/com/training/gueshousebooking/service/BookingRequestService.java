package com.training.gueshousebooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.gueshousebooking.daos.CreateBookingRequestDao;
import com.training.gueshousebooking.daos.OfficeBookingRequestDao;
import com.training.gueshousebooking.daos.UserBookingRequestDao;
import com.training.gueshousebooking.models.BookingRequest;
import com.training.gueshousebooking.models.GuestHouse;
import com.training.gueshousebooking.models.User;
import com.training.gueshousebooking.repositories.BookingRequestRepository;
import com.training.gueshousebooking.repositories.GuestHouseRepository;
import com.training.gueshousebooking.repositories.UserRepository;

@Service
public class BookingRequestService {

	@Autowired
	BookingRequestRepository bookingRequestRepository;

	@Autowired
	GuestHouseRepository guestHouseRepository;

	@Autowired
	UserRepository userRepository;

	public List<UserBookingRequestDao> getListOfBookingRequestsByUser(int userId) {
		Iterable<BookingRequest> list = bookingRequestRepository.findByUserId(userId);
		List<UserBookingRequestDao> userBookingRequestDaoList = new ArrayList<UserBookingRequestDao>();
		for (BookingRequest bookingRequest : list) {
			UserBookingRequestDao dao = new UserBookingRequestDao(bookingRequest);
			if (bookingRequest.isActive()) {
				if (bookingRequest.isApproved()) {
					dao.setStatus("Approved");
				} else {
					dao.setStatus("Pending");
				}
			} else {
				if (bookingRequest.isApproved()) {
					dao.setStatus("Approved");
				} else {
					dao.setStatus("Rejected");
				}
			}
			userBookingRequestDaoList.add(dao);
		}
		return userBookingRequestDaoList;
	}

	public List<OfficeBookingRequestDao> getListOfBookingRequestsByOffice(int id) {
		Iterable<BookingRequest> list = bookingRequestRepository.findByOfficeId(id);
		List<OfficeBookingRequestDao> officeActiveBookingRequestDaoList = new ArrayList<OfficeBookingRequestDao>();
		int roomsTotal;
		int roomsBooked;
		for (BookingRequest bookingRequest : list) {
			if (bookingRequest.isActive()) {
				OfficeBookingRequestDao dao = new OfficeBookingRequestDao(bookingRequest);
				officeActiveBookingRequestDaoList.add(dao);
				roomsTotal = bookingRequest.getGuestHouse().getRoomsTotal();
				roomsBooked = bookingRequest.getGuestHouse().getRoomsBooked();
				dao.setRoomsAvailable(roomsTotal - roomsBooked);
			}
		}
		return officeActiveBookingRequestDaoList;

	}

	public boolean updateBookingRequest(int bookingId) {
		Optional<BookingRequest> bookingRequest = bookingRequestRepository.findById(bookingId);
		int roomsTotal;
		int roomsBooked;
		int roomsAvailable;
		if (bookingRequest.isPresent()) {
			BookingRequest request = bookingRequest.get();
			GuestHouse guestHouse = guestHouseRepository.findById(request.getGuestHouse().getId()).get();

			roomsTotal = request.getGuestHouse().getRoomsTotal();
			roomsBooked = request.getGuestHouse().getRoomsBooked();
			roomsAvailable = roomsTotal - roomsBooked;
			if (roomsAvailable >= request.getRoomsRequested()) {
				roomsAvailable = roomsAvailable - request.getRoomsRequested();
				request.setActive(false);
				request.setApproved(true);
				guestHouse.setRoomsBooked(request.getRoomsRequested() + roomsBooked);
				guestHouseRepository.save(guestHouse);
				return true;
			} else {
				request.setActive(false);
			}
			bookingRequestRepository.save(request);
		}
		return false;
	}

	public boolean createBookingRequest(CreateBookingRequestDao createBookingRequestDao) {
		BookingRequest bookingRequest = new BookingRequest();
		User user = userRepository.findById(createBookingRequestDao.getUserId()).get();
		GuestHouse guestHouse = guestHouseRepository.findById(createBookingRequestDao.getGuestHouseId()).get();
		bookingRequest.setUser(user);
		bookingRequest.setGuestHouse(guestHouse);
		bookingRequest.setActive(true);
		bookingRequest.setApproved(false);
		bookingRequest.setRoomsRequested(createBookingRequestDao.getRoomsRequested());
		bookingRequestRepository.save(bookingRequest);
		return true;
	}

	public List<OfficeBookingRequestDao> getListOfInActiveBookingRequestsByOffice(int id) {
		Iterable<BookingRequest> list = bookingRequestRepository.findByOfficeId(id);
		List<OfficeBookingRequestDao> officeInActiveBookingRequestDaoList = new ArrayList<OfficeBookingRequestDao>();
		for (BookingRequest bookingRequest : list) {
			if (!bookingRequest.isActive()) {
				OfficeBookingRequestDao dao = new OfficeBookingRequestDao(bookingRequest);
				officeInActiveBookingRequestDaoList.add(dao);

			}
		}
		return officeInActiveBookingRequestDaoList;
	}
}
