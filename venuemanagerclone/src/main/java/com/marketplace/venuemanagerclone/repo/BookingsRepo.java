package com.marketplace.venuemanagerclone.repo;

import java.math.BigInteger;
// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.venuemanagerclone.model.BookingsPOJO;

@Repository
public interface BookingsRepo extends JpaRepository<BookingsPOJO, BigInteger>{
	BigInteger deleteByVenueId(BigInteger venueId); 
}
