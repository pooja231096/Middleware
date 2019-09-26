package com.marketplace.venuemanagerclone.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "bookings")
public class BookingsPOJO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger booking_id;
	
	@Column(name="venue_id")
	private BigInteger venueId;

	public BigInteger getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(BigInteger booking_id) {
		this.booking_id = booking_id;
	}

	public BigInteger getVenueId() {
		return venueId;
	}

	public void setVenueId(BigInteger venueId) {
		this.venueId = venueId;
	}

	
			
}
