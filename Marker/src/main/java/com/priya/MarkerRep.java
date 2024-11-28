package com.priya;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "marker",path="marker")
public interface MarkerRep extends JpaRepository<Marker,String>
{
	
}