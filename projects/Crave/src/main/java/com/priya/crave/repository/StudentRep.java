package com.priya.crave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priya.crave.model.Student;

@Repository
public interface StudentRep extends JpaRepository<Student,Integer>{

}
