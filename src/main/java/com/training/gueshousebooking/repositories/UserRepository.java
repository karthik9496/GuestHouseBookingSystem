package com.training.gueshousebooking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.gueshousebooking.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByNameAndPassword(String name, String password);

}
