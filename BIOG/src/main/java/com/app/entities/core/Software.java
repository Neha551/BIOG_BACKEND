package com.app.entities.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.enums.SoftwareType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "software")
@JsonPropertyOrder(alphabetic = true)
public class Software extends Product{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3230037973323726622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="software_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="software_type")	
	private SoftwareType type;
	
	@Column(name="media_type",length=50)
	private String mediaType;
	
	
	
	public Software() {
		super();
	}

	public Software(int id, SoftwareType type, String mediaType,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl,String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.type = type;
		this.mediaType = mediaType;
	}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SoftwareType getType() {
		return type;
	}

	public void setType(SoftwareType type) {
		this.type = type;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	
	

	@Override
	public String toString() {
		return "Software [     "+super.toString()+"         id=" + id + ", type=" + type + ", mediaType=" + mediaType + "]";
	}


}
