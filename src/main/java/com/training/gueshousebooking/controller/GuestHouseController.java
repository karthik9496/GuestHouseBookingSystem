package com.training.gueshousebooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.gueshousebooking.daos.CreateGuestHouseDao;
import com.training.gueshousebooking.daos.GuestHouseDao;
import com.training.gueshousebooking.repositories.GuestHouseRepository;
import com.training.gueshousebooking.repositories.OfficeRepository;
import com.training.gueshousebooking.service.GuestHouseService;

@RestController

public class GuestHouseController {

	@Autowired
	GuestHouseRepository guestHouseRepository;

	@Autowired
	OfficeRepository officeRepository;

	@Autowired
	GuestHouseService guestHouseService;

	@GetMapping("/listOfGuestHouses")
	public List<GuestHouseDao> getListOfGuestHouses() {

		return guestHouseService.getListOfGuestHouses();

	}

	@PostMapping("/guestHouse")
	public boolean createGuestHouse(@RequestBody CreateGuestHouseDao createGuestHouseDao) {
		return guestHouseService.createGuestHouse(createGuestHouseDao);

	}

	@GetMapping("/listOfGuestHouses/{officeId}")
	public List<GuestHouseDao> getListOfGuestHouses(@PathVariable int officeId) {

		return guestHouseService.getListOfGuestHousesByOffice(officeId);
	}
}
