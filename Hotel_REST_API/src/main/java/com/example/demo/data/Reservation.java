package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;

import com.example.demo.data.Guest;


@Entity
@Table(name="Reservation")
public class Reservation {
	@Id
	@SequenceGenerator(name= "Reservation_SEQ", sequenceName = "Reservation_SEQ_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO , generator="Reservation_SEQ")
	@Column(name="reservation_id")
	private Long id;
	@Column(name="hotel_name")
	private String hotel_name;
	@Column(name="checkin")
	private String checkin;
	@Column(name="checkout")
	private String checkout;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservation_id")
	private List<Guest> guest_list;
	
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
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public List<Guest> getGuest_list() {
		return guest_list;
	}
	public void setGuest_list(List<Guest> guest_list) {
		this.guest_list = guest_list;
	}

}

