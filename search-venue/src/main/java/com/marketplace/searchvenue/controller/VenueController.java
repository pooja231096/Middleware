package com.marketplace.searchvenue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.searchvenue.model.VenuesPOJO;
import com.marketplace.searchvenue.service.VenueService;

@RestController
@RequestMapping("/Search")
public class VenueController {

	@Autowired
	private VenueService venueService;
	
	@RequestMapping(value = "/{location}/{category}", method = RequestMethod.GET)
	public List<VenuesPOJO> getVenueByFilter1(@PathVariable("location") String location, @PathVariable("category") String category) {
		return venueService.getByLocationAndCategory(location, category);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<VenuesPOJO> getAllVenues() {
		return venueService.getAllVenues();
	}
	
	@RequestMapping(value = "/{location}", method = RequestMethod.GET)
	public List<VenuesPOJO> getAllVenuesByLocation(@PathVariable("location") String location) {
		return venueService.getAllVenuesByLocation(location);
	}
}
