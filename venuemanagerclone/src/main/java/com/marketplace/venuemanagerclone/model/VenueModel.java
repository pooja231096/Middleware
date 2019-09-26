package com.marketplace.venuemanagerclone.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "venue")
public class VenueModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "seq2")
	@TableGenerator(name = "seq2", initialValue = 7646, allocationSize = 3)
	@Column(name = "venue_id")
	private BigInteger venueId;
	
	@Column(name = "provider_id")
	private UUID provider_id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "availability")
	private Boolean availability;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "location")
	private String location;

	
	public UUID getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(UUID provider_id) {
		this.provider_id = provider_id;
	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigInteger getVenueId() {
		return venueId;
	}

	public void setVenueId(BigInteger venueId) {
		this.venueId = venueId;
	}	
}
