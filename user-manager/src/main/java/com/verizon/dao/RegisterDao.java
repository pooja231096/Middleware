package com.verizon.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.RegisterPOJO;

@Repository
public interface RegisterDao extends CrudRepository<RegisterPOJO, UUID> {
	
	
	
}