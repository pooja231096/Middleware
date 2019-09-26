package com.marketplace.venuemanagerclone.repo;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.venuemanagerclone.model.NewVenuePOJO;

@Repository
public interface AddVenueRepo extends JpaRepository<NewVenuePOJO, BigInteger>{
}
