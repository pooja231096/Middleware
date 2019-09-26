package com.marketplace.venuemanagerclone.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venue")
public class UpdateVenuePOJO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private BigInteger venue_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;

	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "category")
	private String category;

	@Column(name = "availability")
	private boolean availability;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigInteger getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(BigInteger venue_id) {
		this.venue_id = venue_id;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}
