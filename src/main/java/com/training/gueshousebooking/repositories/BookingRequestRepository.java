package com.training.gueshousebooking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.gueshousebooking.models.BookingRequest;

@Repository
public interface BookingRequestRepository extends CrudRepository<BookingRequest, Integer> {

	@Query("SELECT a FROM BookingRequest a WHERE a.user.id =:id")

	List<BookingRequest> findByUserId(int id);
	
	@Query("SELECT a FROM BookingRequest a WHERE a.guestHouse.office.id =:id")

	List<BookingRequest> findByOfficeId(int id);
	
	
}
