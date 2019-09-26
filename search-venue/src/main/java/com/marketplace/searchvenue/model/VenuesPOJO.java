package com.marketplace.searchvenue.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public class VenuesPOJO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger venue_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	// private boolean available;
	@Column(name = "price")
	private double price;
	
	@Column(name = "capacity")
	private String capacity;

	@Column(name = "location")
	private String location;
	
	// private UUID provider_id;

	public BigInteger getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(BigInteger venue_id) {
		this.venue_id = venue_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
