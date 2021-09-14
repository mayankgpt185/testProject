package com.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_manager")
public class DimManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MANAGER_SKEY")
	private Integer managerSkey;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "F_NAME")
	private String firstName;

	@Column(name = "L_NAME")
	private String lastName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "C_NAME")
	private String companyName;

	public Integer getManagerSkey() {
		return managerSkey;
	}

	public void setManagerSkey(Integer managerSkey) {
		this.managerSkey = managerSkey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
