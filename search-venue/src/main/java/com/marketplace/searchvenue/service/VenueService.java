package com.marketplace.searchvenue.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.searchvenue.model.VenuesPOJO;
import com.marketplace.searchvenue.repository.VenueRepo;

@Service
public class VenueService {

	@Autowired
	private VenueRepo venueRepo;
	
	public List<VenuesPOJO> getAllVenues() {
		return venueRepo.findAll();
	}
	
	public List<VenuesPOJO> getByLocationAndCategory(String location, String category) {
		return venueRepo.findByLocationAndCategory(location, category);
	}

	public List<VenuesPOJO> getAllVenuesByLocation(String location) {
		return venueRepo.findByLocation(location);
	}

}
