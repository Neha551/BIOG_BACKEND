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
@Table(name="wireless_adapters")
@JsonPropertyOrder(alphabetic = true)
public class WirelessNetworkAdapters extends Product{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6415710335763895689L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="wirelessadapter_id")
	private Integer id;
	
	
	@Column(length=50)
	private String protocol;
	
	@Column(length=50)
	private String interFace;
	
	
	
	public WirelessNetworkAdapters() {
		super();
	}


	public WirelessNetworkAdapters(int id, String protocol, String interFace,String name, String manufacturer, String brand, float price, boolean isAvailable,
			String imageUrl, String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.protocol = protocol;
		this.interFace = interFace;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProtocol() {
		return protocol;
	}



	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}



	public String getInterFace() {
		return interFace;
	}



	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}



	@Override
	public String toString() {
		return "WirelessNetworkAdapters [     "+super.toString()+"  id=" + id + ", protocol=" + protocol + ", interFace=" + interFace + "]";
	}
	
	

}
