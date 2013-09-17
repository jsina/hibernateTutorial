package com.sinaSys.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	private int vehicleId;
	private String vehicleName;
	private Collection<UserDetails> users = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	@ManyToMany
	@JoinTable(name="USERS_VEHICLE",joinColumns=@JoinColumn(name="vehicle_id")
	, inverseJoinColumns = @JoinColumn(name = "User_id"))
	public Collection<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}

}
