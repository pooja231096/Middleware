package com.verizon.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.verizon.model.DAOVerify;

@Repository
public interface VerifyDao extends CrudRepository<DAOVerify, UUID> {

}