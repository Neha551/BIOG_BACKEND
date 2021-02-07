package com.app.entities.peripherals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.entities.core.Product;
import com.app.entities.enums.HeadphoneTypes;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="headphone_peripheral")
@JsonPropertyOrder(alphabetic = true)
public class HeadphonesPeripheral extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5177153367780900856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="headphone_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private HeadphoneTypes type;
	
	//from Hz to kHz
	@Column(name="frequency_response")
	private int frequencyResponse;
	
	@Column(name="is_microphone")
	private boolean isMicrophone;
	@Column(name="is_wireless")
	private boolean isWireless;
	
	@Column(name="enclosure_type",length=50)
	private String enclosureType;
	
	
	
	public HeadphonesPeripheral() {
		super();
	}



	public HeadphonesPeripheral(int id, HeadphoneTypes type, int frequencyResponse, boolean isMicrophone,
			boolean isWireless, String enclosureType, String color,String name, String manufacturer, String brand, float price, boolean isAvailable,String imageUrl) {
		super(name, manufacturer, brand, price, isAvailable,imageUrl,color);
		
		this.id = id;
		this.type = type;
		this.frequencyResponse = frequencyResponse;
		this.isMicrophone = isMicrophone;
		this.isWireless = isWireless;
		this.enclosureType = enclosureType;
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public HeadphoneTypes getType() {
		return type;
	}



	public void setType(HeadphoneTypes type) {
		this.type = type;
	}



	public int getFrequencyResponse() {
		return frequencyResponse;
	}



	public void setFrequencyResponse(int frequencyResponse) {
		this.frequencyResponse = frequencyResponse;
	}



	public boolean isMicrophone() {
		return isMicrophone;
	}



	public void setMicrophone(boolean isMicrophone) {
		this.isMicrophone = isMicrophone;
	}



	public boolean isWireless() {
		return isWireless;
	}



	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}



	public String getEnclosureType() {
		return enclosureType;
	}



	public void setEnclosureType(String enclosureType) {
		this.enclosureType = enclosureType;
	}



	@Override
	public String toString() {
		return "HeaphonesPeripheral [     "+super.toString()+ "       id=" + id + ", type=" + type + ", frequencyResponse=" + frequencyResponse
				+ ", isMicrophone=" + isMicrophone + ", isWireless=" + isWireless + ", enclosureType=" + enclosureType
				+ "]";
	}
	
	
	

}
