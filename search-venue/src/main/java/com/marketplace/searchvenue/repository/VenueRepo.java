package com.marketplace.searchvenue.repository;

import java.math.BigInteger;
// import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketplace.searchvenue.model.VenuesPOJO;

@Repository
public interface VenueRepo extends JpaRepository<VenuesPOJO, BigInteger>{
	
	public List<VenuesPOJO> findByLocationAndCategory(String location, String category);
	public List<VenuesPOJO> findByLocation(String location);
	//public List<VenuesPOJO> findByDate(Date date);
}
