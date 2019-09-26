package com.marketplace.superadmin.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.superadmin.model.User;


@Repository
public interface AdminRepo extends JpaRepository<User,UUID> {
	User findUserById(UUID id);
}
