package com.marketplace.venuemanagerclone.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.venuemanagerclone.model.BookingsPOJO;
import com.marketplace.venuemanagerclone.model.NewVenuePOJO;
import com.marketplace.venuemanagerclone.model.UpdateVenuePOJO;
import com.marketplace.venuemanagerclone.model.VenueModel;
import com.marketplace.venuemanagerclone.repo.AddVenueRepo;
import com.marketplace.venuemanagerclone.repo.BookingsRepo;
import com.marketplace.venuemanagerclone.repo.VenueDeletionRepo;
import com.marketplace.venuemanagerclone.repo.VenueListRepo;
import com.marketplace.venuemanagerclone.repo.VenueRepository;

@Service
public class VenueProviderService {
	
	@Autowired
	private VenueRepository venueRepository;
	
	@Autowired
	private VenueListRepo venueListRepo;
	
	@Autowired
	private AddVenueRepo addVenueRepo;
	
	public UpdateVenuePOJO updateVenueDetails(BigInteger venueId, UpdateVenuePOJO updateObj) {
		UpdateVenuePOJO myVenue = venueRepository.findById(venueId).get();
		String desc = updateObj.getDescription();
		String title = updateObj.getTitle();
		double price = updateObj.getPrice();
		int cap = updateObj.getCapacity();
		String category = updateObj.getCategory();
		boolean avail = updateObj.isAvailability();
		myVenue.setCapacity(cap);
		myVenue.setCategory(category);
		myVenue.setDescription(desc);
		myVenue.setPrice(price);
		myVenue.setTitle(title);
		myVenue.setAvailability(avail);
		venueRepository.save(myVenue);
		return myVenue;
	}
	
	public boolean addVenue(NewVenuePOJO newObj) {
		NewVenuePOJO returnObj = addVenueRepo.save(newObj);
		if(returnObj != null)
			return true;
		else
			return false;
	}

	public void deleteVenueById(BigInteger vid) {
		addVenueRepo.deleteById(vid);
		/* List<BookingsPOJO> concernedBookings = bookingsRepo.findAll();
		System.out.println(concernedBookings.size());
		for(BookingsPOJO booking: concernedBookings) {
			BigInteger concernedVenueId = booking.getVenueId();
			if(concernedVenueId == vid) {
				System.out.println(vid);
				BigInteger bid = booking.getBooking_id();
				bookingsRepo.deleteById(bid);
				addVenueRepo.deleteById(concernedVenueId);
			}
		} */
	}

	public List<VenueModel> viewAll() {
		return venueListRepo.findAll();
	}

}
