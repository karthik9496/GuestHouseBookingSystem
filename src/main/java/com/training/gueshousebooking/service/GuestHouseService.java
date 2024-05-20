package com.training.gueshousebooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.gueshousebooking.daos.CreateBookingRequestDao;
import com.training.gueshousebooking.daos.CreateGuestHouseDao;
import com.training.gueshousebooking.daos.GuestHouseDao;
import com.training.gueshousebooking.models.GuestHouse;
import com.training.gueshousebooking.models.Office;
import com.training.gueshousebooking.repositories.GuestHouseRepository;
import com.training.gueshousebooking.repositories.OfficeRepository;

@Service
public class GuestHouseService {
	@Autowired
	GuestHouseRepository guestHouseRepository;
	@Autowired
	OfficeRepository officeRepository;

	public List<GuestHouseDao> getListOfGuestHouses() {
		Iterable<GuestHouse> list = guestHouseRepository.findAll();
		List<GuestHouseDao> daoList = new ArrayList<GuestHouseDao>();
		for (GuestHouse guestHouse : list) {
			GuestHouseDao dao = new GuestHouseDao(guestHouse);
			daoList.add(dao);
		}
		return daoList;

	}

	public List<GuestHouseDao> getListOfGuestHousesByOffice(int officeId) {
		Iterable<GuestHouse> list = guestHouseRepository.getGuestHousesByOffice(officeId);
		List<GuestHouseDao> daoList = new ArrayList<GuestHouseDao>();
		for (GuestHouse guestHouse : list) {
			GuestHouseDao dao = new GuestHouseDao(guestHouse);
			daoList.add(dao);
		}

		return daoList;

	}

	public boolean createGuestHouse(CreateGuestHouseDao createGuestHouseDao) {
		Office office = officeRepository.findById(createGuestHouseDao.getOfficeId()).get();
		GuestHouse guestHouse = new GuestHouse();
		guestHouse.setOffice(office);
		guestHouse.setName(createGuestHouseDao.getGuestHouseName());
		guestHouse.setRoomsTotal(createGuestHouseDao.getTotalRooms());
		guestHouse.setRoomType(createGuestHouseDao.getRoomType());
		guestHouseRepository.save(guestHouse);
		return true;
	}
}
