package com.priya.crave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priya.crave.model.Councellor;

@Repository
public interface CouncellorRep extends JpaRepository<Councellor, Integer>{

}
