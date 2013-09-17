package com.sinaSys.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "USER_DETAILS")
public class UserDetails {
	private int userId;
	private String userName;
	private Date date;
	private Collection<Vehicle> vehicles = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	@Lob
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToMany(mappedBy="users")
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
