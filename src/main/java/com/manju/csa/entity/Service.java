package com.manju.csa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int serviceId;
	private String serviceType;
	private double serviceCost;
	private String derscription;


	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public double getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
	public String getDerscription() {
		return derscription;
	}
	public void setDerscription(String derscription) {
		this.derscription = derscription;
	}

}
