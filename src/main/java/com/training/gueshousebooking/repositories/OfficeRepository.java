package com.training.gueshousebooking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.gueshousebooking.models.Office;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer>{
	

}
