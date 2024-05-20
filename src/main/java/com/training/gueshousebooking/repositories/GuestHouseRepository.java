package com.training.gueshousebooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.gueshousebooking.models.GuestHouse;

@Repository
public interface GuestHouseRepository extends CrudRepository<GuestHouse, Integer> {

	@Modifying 
	@Query ("UPDATE GuestHouse a SET a.roomsBooked = :roomsBooked WHERE a.id = :id")

	void updateBookingRequest(int roomsBooked, int id);
	
	@Query ("SELECT a FROM GuestHouse a where a.office.id = :officeId")

	List<GuestHouse> getGuestHousesByOffice(int officeId);
}
