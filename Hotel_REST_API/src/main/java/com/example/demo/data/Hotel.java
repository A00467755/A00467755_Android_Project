package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;


@Entity
@Table(name="Hotel")
public class Hotel {
	@Id
	@SequenceGenerator(name= "Hotel_SEQ", sequenceName = "Hotel_SEQ_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO , generator="Hotel_SEQ")
	@Column(name="hotel_id")
	private Long id;
	@Column(name="hotel_name")
	private String hotel_name;
	@Column(name="price")
	private float price;
	@Column(name="availability")
	private String availability;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
}
