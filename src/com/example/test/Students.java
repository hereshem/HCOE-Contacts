package com.example.test;

public class Students {

	String name, email, phone, address, image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Students(String name, String email, String phone, String address,
			String image) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.image = image;
	}
	
	
}
