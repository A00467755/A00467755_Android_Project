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
@Table(name="Guest")
public class Guest {
	@Id
	@SequenceGenerator(name= "Guest_SEQ", sequenceName = "Guest_SEQ_ID", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO , generator="Guest_SEQ")
	@Column(name="guest_id")
	private Long id;
	@Column(name="reservation_id")
	private Long reservation_id;
	@Column(name="guest_name")
	private String guest_name;
	@Column(name="gender")
	private String gender;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
