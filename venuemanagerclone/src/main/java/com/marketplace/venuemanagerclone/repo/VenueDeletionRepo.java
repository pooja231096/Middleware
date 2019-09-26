package com.marketplace.venuemanagerclone.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.venuemanagerclone.model.VenueModel;

@Repository
public interface VenueDeletionRepo extends JpaRepository<VenueModel, BigInteger>{
}
