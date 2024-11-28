package com.priya;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, String>{
	User findByUserName(String userName);

}
