package com.app.entities.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.enums.ExternalStorageType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "external_storage")
@JsonPropertyOrder(alphabetic = true)
public class ExternalStorage extends Product{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8702499726211560305L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="external_storageid")
	private Integer id;
	

	@Enumerated(EnumType.STRING)
	@Column(name="storage_type")
	private ExternalStorageType type;
	
	@Column(name="interface",length=40)
	private String interFace;
	
	//GB
	private int capacity;
	
	
		
	
	public ExternalStorage() {
		super();
	}


	public ExternalStorage(int id, ExternalStorageType type, String interFace, int capacity,String name, String manufacturer, String brand, float price, boolean isAvailable,
			String imageUrl, String color) {
		super(name, manufacturer, brand, price, isAvailable, imageUrl, color);
		this.id = id;
		this.type = type;
		this.interFace = interFace;
		this.capacity = capacity;
		
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public ExternalStorageType getType() {
		return type;
	}



	public void setType(ExternalStorageType type) {
		this.type = type;
	}



	public String getInterFace() {
		return interFace;
	}



	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	

	@Override
	public String toString() {
		return "ExternalStorage [     "+super.toString()+"       id=" + id + ", type=" + type + ", interFace=" + interFace + ", capacity=" + capacity
				+  "]";
	}


}
