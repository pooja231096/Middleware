package com.marketplace.venuemanagerclone.controller;

import java.math.BigInteger;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.marketplace.venuemanagerclone.model.NewVenuePOJO;
import com.marketplace.venuemanagerclone.model.UpdateVenuePOJO;
import com.marketplace.venuemanagerclone.model.VenueModel;
import com.marketplace.venuemanagerclone.repo.BookingsRepo;
import com.marketplace.venuemanagerclone.service.VenueProviderService;


@RestController
@RequestMapping("/venue")
@Transactional
public class VenueController {
	
	@Autowired
	private BookingsRepo bookingsRepo;
	@Autowired
	private VenueProviderService venueProviderService;
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public UpdateVenuePOJO updateVenue(@PathVariable("id") BigInteger vid, @RequestBody UpdateVenuePOJO updateObj) {
		return venueProviderService.updateVenueDetails(vid, updateObj);
	}
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping(path = "/view-all")
	public Iterable<VenueModel> viewAll() {
		return venueProviderService.viewAll();
	}
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@RequestMapping(value = "/addVenue", method = RequestMethod.POST)
	public ResponseEntity<String> addVenue(@Valid @RequestBody NewVenuePOJO addObj)
	{
		if(venueProviderService.addVenue(addObj) == true) {
			return new ResponseEntity<>("Venue Added Successfully!", HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Request Unuccessfully!", HttpStatus.BAD_REQUEST);
			
	}
	
	@CrossOrigin(origins="*",allowedHeaders="*")
	@Transactional
	@DeleteMapping(value = "/deleteVenue/{venueId}")
	public void deleteVenue(@PathVariable("venueId") BigInteger vid) {
		bookingsRepo.deleteByVenueId(vid);
		venueProviderService.deleteVenueById(vid);
	}
}
