package com.training.gueshousebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.gueshousebooking.daos.CreateBookingRequestDao;
import com.training.gueshousebooking.daos.OfficeBookingRequestDao;
import com.training.gueshousebooking.daos.UserBookingRequestDao;
import com.training.gueshousebooking.repositories.BookingRequestRepository;
import com.training.gueshousebooking.service.BookingRequestService;

@RestController
@RequestMapping("/bookings")
public class BookingRequestController {

	@Autowired
	BookingRequestRepository bookingRequestRepository;

	@Autowired
	BookingRequestService bookingRequestService;

	@GetMapping("/user/{id}")
	public List<UserBookingRequestDao> getBookingRequestsByUser(@PathVariable int id) {

		return bookingRequestService.getListOfBookingRequestsByUser(id);

	}

	@GetMapping("/office/{id}")
	public List<OfficeBookingRequestDao> getBookingRequestsByOffice(@PathVariable int id) {

		return bookingRequestService.getListOfBookingRequestsByOffice(id);

	}
	
	//returns list of approved and rejected booking requests
	@GetMapping("/office/approved/{id}")
	public List<OfficeBookingRequestDao> getInActiveBookingRequestsByOffice(@PathVariable int id) {

		return bookingRequestService.getListOfInActiveBookingRequestsByOffice(id);

	}

	@PutMapping("/{id}")
	public boolean updateBookingRequest(@PathVariable int id) {
		return bookingRequestService.updateBookingRequest(id);
	}
	
	@PostMapping("/user")
	public boolean createBookingRequest(@RequestBody CreateBookingRequestDao bookingRequestDao) {
		return bookingRequestService.createBookingRequest(bookingRequestDao);
	}
}
