package com.app.entities.networking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.core.Product;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="wired_adapters")
@JsonPropertyOrder(alphabetic = true)
public class WiredNetworkAdapters extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3246988007322491173L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="wiredadapter_id")
	private Integer id;
	
	
	@Column(length=20)
	private String interFace;
	
	@Column(name="ports_number")
	private int portsNumber;
	
	//Gbit/s or Mbit/s
	@Column(name="port_speed")
	private int portSpeed;
		
	public WiredNetworkAdapters() {
		super();
	}



	public WiredNetworkAdapters(int id, String interFace, int portsNumber, int portSpeed,String name, String manufacturer, String brand, float price, boolean isAvailable,
			String imageUrl, String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.interFace = interFace;
		this.portsNumber = portsNumber;
		this.portSpeed = portSpeed;
	}



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getInterFace() {
		return interFace;
	}




	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}




	public int getPortsNumber() {
		return portsNumber;
	}




	public void setPortsNumber(int portsNumber) {
		this.portsNumber = portsNumber;
	}




	public int getPortSpeed() {
		return portSpeed;
	}




	public void setPortSpeed(int portSpeed) {
		this.portSpeed = portSpeed;
	}





	@Override
	public String toString() {
		return "WiredNetworkAdapters [     "+super.toString()+"         id=" + id + ", interFace=" + interFace + ", portsNumber=" + portsNumber
				+ ", portSpeed=" + portSpeed +  "]";
	}

	
	
}
