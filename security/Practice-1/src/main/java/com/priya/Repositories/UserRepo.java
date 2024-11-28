package com.priya.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.priya.Model.Users;

@Repository
@Component
public interface UserRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
