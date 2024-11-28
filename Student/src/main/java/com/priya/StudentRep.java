package com.priya;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "student", path="student")
public interface StudentRep extends JpaRepository<Student, Integer> {

}
