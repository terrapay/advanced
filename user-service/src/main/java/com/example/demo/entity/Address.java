package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
//	@Id
	private Integer id;
	private String street;
	private int pin;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
