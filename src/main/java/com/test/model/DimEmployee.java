package com.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_employee")
public class DimEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_SKEY")
	private Integer employeeSkey;

	@Column(name = "F_NAME")
	private String firstName;

	@Column(name = "L_NAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "CITY")
	private String city;

	@Column(name = "V_STATUS")
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEmployeeSkey() {
		return employeeSkey;
	}

	public void setEmployeeSkey(Integer employeeSkey) {
		this.employeeSkey = employeeSkey;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
