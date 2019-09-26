package com.verizon.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.DAOUser;
@Repository
public interface ProfileDao  extends CrudRepository<DAOUser, UUID>{
DAOUser findByUsername(String username);
}
